package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.OrderException;
import com.masai.model.Orders;
import com.masai.repository.OrderDao;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao oDao;

	@Override
	public Orders addOrder(Orders order) throws OrderException {

//		Optional<Order> opt = oDao.findById(order.getOrderId());
//
//		if (opt.isPresent()) {
//			throw new OrderException("Order already present...");
//		}

		return oDao.save(order);

	}

	@Override
	public Orders updateOrder(Orders order) throws OrderException {

		Optional<Orders> opt = oDao.findById(order.getOrderId());

		if (opt.isPresent()) {
			Orders o = oDao.save(order);
			return o;
		}

		throw new OrderException("Invalid Order Details...");
	}

	@Override
	public Orders deleteOrder(Integer id) throws OrderException {
		
		Optional<Orders> opt = oDao.findById(id);
		
		if(opt.isPresent()) {
			Orders o = opt.get();
			oDao.delete(o);
			return o;
		}
		
		throw new OrderException("No Order found with Id : " +  id);
	}

	@Override
	public Orders viewOrder(Integer id) throws OrderException {
	
		Optional<Orders> opt = oDao.findById(id);
		if(opt.isPresent()) {
			
			return opt.get();
			
		}
		
		throw new OrderException("No order found with Id : " + id);
	}

	@Override
	public List<Orders> viewAllOrders() throws OrderException {
		
		List<Orders> list = oDao.findAll();
		
		if(list.size() == 0) {
			throw new OrderException("No records of orders....");
		}
		
		return list;
	}
	
	
	

}
