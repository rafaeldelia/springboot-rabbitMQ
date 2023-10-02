package br.com.arphoenix.apis.msrab.service;

import java.time.LocalDate;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.arphoenix.apis.msrab.amqp.RabbitChannels;

@Service
public class ApiBaseService {


	@Autowired
	private RabbitTemplate rabbitTemplate;


	public String localDate() {
		return LocalDate.now().toString();
	}

	public String hello() {
		return "Hello";
	}
	
	public void sendMessageToRabbit() {
		rabbitTemplate.convertAndSend(RabbitChannels.queueName, "Hello from RabbitMQ!");
	}
	
	

}