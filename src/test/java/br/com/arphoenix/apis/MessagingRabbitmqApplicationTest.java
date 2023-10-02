package br.com.arphoenix.apis;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.AmqpConnectException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.arphoenix.apis.msrab.amqp.RabbitChannels;
import br.com.arphoenix.apis.msrab.amqp.Receiver;
import br.com.arphoenix.apis.msrab.amqp.Runner;

@SpringBootTest
public class MessagingRabbitmqApplicationTest {

	@MockBean
	private Runner runner;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private Receiver receiver;

	@Test
	void test() throws Exception {
		try {
			rabbitTemplate.convertAndSend(RabbitChannels.queueName, "Hello from RabbitMQ!");
			receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
		} catch (AmqpConnectException e) {
		}
	}

}