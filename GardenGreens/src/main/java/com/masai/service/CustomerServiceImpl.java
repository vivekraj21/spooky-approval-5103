package com.masai.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.exception.OrderException;
import com.masai.model.Customer;
import com.masai.model.Orders;
import com.masai.repository.AddressDao;
import com.masai.repository.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao cDao;

	@Autowired
	private AddressDao aDao;

	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {

		Customer c = cDao.save(customer);

		if (c == null) {
			throw new CustomerException("Invalid Customer data...");
		}

		return c;
	}

	@Override
	public Customer upDateCustomer(Customer customer) throws CustomerException {

		Optional<Customer> opt = cDao.findById(customer.getCustomerId());

		if (opt.isPresent()) {
			Customer c = cDao.save(customer);
			return c;
		}

		throw new CustomerException("Invalid Customer..");
	}

	@Override
	public Customer deleteCustomer(Customer customer) throws CustomerException {

		Optional<Customer> opt = cDao.findById(customer.getCustomerId());

		if (opt.isPresent()) {
			cDao.delete(opt.get());
			return customer;
		}

		throw new CustomerException("Invalid Customer..");
	}

	@Override
	public Customer viewCustomer(Integer id) throws CustomerException {

		Optional<Customer> opt = cDao.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}

		throw new CustomerException("Invalid Customer Id : " + id);
	}

	@Override
	public List<Customer> viewAllCustomer() throws CustomerException {

		List<Customer> list = cDao.findAll();
		if (list.size() == 0) {
			throw new CustomerException("No Customer present..");
		}

		return list;
	}

	@Override
	public String addOrderToCustomer(int id, Orders order) throws CustomerException, OrderException {

		Optional<Customer> opt = cDao.findById(id);
        if(order == null) {
        	throw new OrderException("Invalid Order details...");
        }
        if(!opt.isPresent()) {
        	throw new CustomerException("Invalid Customer Details...");
        }
        
        Customer c = opt.get();
        c.getOrders().add(order);
        cDao.save(c);
        
		return "Order Placed successfully";
	}

	@Override
	public Set<Orders> viewAllOrders(int id) throws CustomerException, OrderException {
		
		Optional<Customer> opt = cDao.findById(id);
		
		if(opt.isPresent()) {
			Set<Orders> set = opt.get().getOrders();
			if(set.size() == 0) {
				throw new OrderException("NO Orders found..");
			}
			return set;
		}
		
		throw new CustomerException("Invalid Customer Detail..");
	}
	
	
	

}
