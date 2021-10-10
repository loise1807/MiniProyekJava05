package com.group05.miniproject.publisher;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group05.miniproject.config.MessagingConfig;
import com.group05.miniproject.dto.Order;
import com.group05.miniproject.dto.OrderStatus;

@RestController
@RequestMapping("/order")

public class OrderPublisher {
	
	@Autowired
	private RabbitTemplate template;
	
	@PostMapping("/{restaurantName}") 
		public String pasienOrder(@RequestBody Order order,@PathVariable String restaurantName) {
			order.setPasienId(UUID.randomUUID().toString());
		
			OrderStatus orderStatus =new OrderStatus(order,"PROCESS", "order placed successfully in "+ restaurantName);
			template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY,orderStatus);
			return "Success";
	}
}