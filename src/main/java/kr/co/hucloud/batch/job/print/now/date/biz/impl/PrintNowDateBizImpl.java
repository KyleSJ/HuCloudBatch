package kr.co.hucloud.batch.job.print.now.date.biz.impl;

import kr.co.hucloud.batch.job.print.now.date.biz.PrintNowDateBiz;
import kr.co.hucloud.batch.job.print.now.date.dao.PrintNowDateDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrintNowDateBizImpl implements PrintNowDateBiz {

	@Autowired
	private PrintNowDateDAO printNowDAO;
	
	@Override
	public String getNowDate() {
		return printNowDAO.getNowDate();
	}
}
