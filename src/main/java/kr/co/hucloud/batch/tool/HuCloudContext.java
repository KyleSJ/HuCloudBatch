package kr.co.hucloud.batch.tool;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HuCloudContext {

	private static AbstractApplicationContext ctx = null;
	
	public static void start() {
		
		String rootContext = "classpath:/spring/rootContext.xml";
		String quartz = "classpath:/spring/quartz.xml";
		String jobContext = "classpath:/spring/jobContext.xml";
		
		if(ctx == null)
			ctx = new ClassPathXmlApplicationContext(rootContext, quartz, jobContext);
	}
	
	public static <T> T getBean(String beanName) {
		return (T) load().getBean(beanName);
	}
	
	private static ApplicationContext load() {
		return ctx;
	}
	
	
	
}
