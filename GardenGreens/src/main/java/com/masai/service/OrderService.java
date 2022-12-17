package com.masai.service;

import java.util.List;

import com.masai.exception.CustomerException;
import com.masai.exception.OrderException;
import com.masai.model.Orders;
import com.masai.model.OrdersDTO;

public interface OrderService {

	public Orders addOrder(OrdersDTO orders, String key) throws OrderException,CustomerException;
	
	public Orders updateOrder(Orders order) throws OrderException;
	
	public String deleteOrder(Integer orderId, String key) throws OrderException, CustomerException ;
	
	public Orders viewOrder(Integer orderId, String key) throws OrderException, CustomerException;
	
	public List<Orders> viewAllOrders() throws OrderException;
	
}
