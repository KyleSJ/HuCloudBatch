package kr.co.hucloud.batch.mq.rabbit;

import kr.co.hucloud.batch.tool.HuCloudContext;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("producer")
public class Producer {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void send(String text) {
		
		MessageProperties messageProperties = new MessageProperties();
		messageProperties.setContentType("text/plain");
		byte[] body = text.getBytes();
		Message message = new Message(body, messageProperties);
		rabbitTemplate.send(message);
	}
	
}
