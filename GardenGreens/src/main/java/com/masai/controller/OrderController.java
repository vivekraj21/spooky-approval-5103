package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.exception.LogInException;
import com.masai.exception.OrderException;
import com.masai.model.Customer;
import com.masai.model.Orders;
import com.masai.model.OrdersDTO;
import com.masai.service.OrderService;

@RestController
@RequestMapping("/orderservice")
public class OrderController {

	@Autowired
	private OrderService oService;
	
	@PostMapping("/orders/{key}")
	public ResponseEntity<Orders> addOrder(@RequestBody OrdersDTO order,@PathVariable("key") String key) {
		
		Orders o = oService.addOrder(order,key);
		
		return new ResponseEntity<Orders>(o,HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/ordersdel/{orderId}/{key}")
	public ResponseEntity<String> deleteOrder(@PathVariable("orderId") Integer orderId,@PathVariable("key") String key) throws OrderException
	{
		String user = oService.deleteOrder(orderId,key);
		
		return new ResponseEntity<String>(user,HttpStatus.OK);
	}
	
	@GetMapping("/ordersview/{key}")
	public ResponseEntity<List<Orders> > viewAllOrder(@PathVariable("key") String key) throws LogInException, CustomerException
	{
		List<Orders> ord = oService.viewAllOrders(key);
		
		return new ResponseEntity<List<Orders> >(ord,HttpStatus.ACCEPTED);
	}
	
}
