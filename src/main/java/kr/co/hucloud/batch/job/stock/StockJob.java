package kr.co.hucloud.batch.job.stock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import kr.co.hucloud.batch.job.stock.vo.StockVO;

public class StockJob extends QuartzJobBean {

	private String url = "http://finance.daum.net/quote/rise.daum?stype=P&page=%d&col=pchgrate&order=desc";
	private List<StockVO> stockList = new ArrayList<>();

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {

		int i = 1;

		while (true) {

			try {
				Document document = getDocument(i);
				Elements stockRows = getStockRows(document);

				if (stockRows.size() == 1) {
					break;
				}

				storeStockData(stockRows);
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}

			i += 1;
		}
		
		for( StockVO stock :stockList) {
			System.out.println(stock.getName());
			System.out.println(stock.getNowPrice());
		}

	}

	private Document getDocument(int i) throws IOException {
		return Jsoup.connect(String.format(url, i)).get();
	}

	private Elements getStockRows(Document document) {
		return document.select("#tabSBody1 > tbody > tr");
	}

	private void storeStockData(Elements stockRows) {
		StockVO stock = null;
		for (Element item : stockRows) {
			if (item.hasAttr("onmouseout")) {
				stock = new StockVO();
				Elements td = item.select("td");

				stock.setRank(Integer.parseInt(td.get(0).text()));
				stock.setName(td.get(1).text());
				stock.setNowPrice(td.get(2).text());
				stock.setUpAndDown(td.get(3).text());
				stock.setGrowthRate(td.get(4).text());
				stock.setDealQuantity(td.get(5).text());
				stock.setDealAmount(td.get(6).text());
				stock.setHighPrice(td.get(7).text());
				stockList.add(stock);
			}
		}
	}
}
