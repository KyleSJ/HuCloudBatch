package kr.co.hucloud.batch.job.print.now.date;

import kr.co.hucloud.batch.job.print.now.date.biz.PrintNowDateBiz;
import kr.co.hucloud.batch.mq.rabbit.Producer;
import kr.co.hucloud.batch.tool.HuCloudContext;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class PrintNowDateJob extends QuartzJobBean {

	private PrintNowDateBiz printNowDateBiz;
	private Producer producer;
	
	
	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		
		printNowDateBiz = HuCloudContext.getBean("printNowDateBizImpl");
		producer = HuCloudContext.getBean("producer");
		
		producer.send("12345");
		
		System.out.println(printNowDateBiz.getNowDate());
	}
	
	
}
