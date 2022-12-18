package com.masai.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.model.Address;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.CustomerDTO;
import com.masai.repository.AddressDao;
import com.masai.repository.CurrentSessionRepo;
import com.masai.repository.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao cDao;

	@Autowired
	private AddressDao aDao;

	@Autowired
	private CurrentSessionRepo csDao;

	@Override
	public Customer addCustomer(CustomerDTO customer) throws CustomerException {

		Optional<Customer> opt = cDao.findByUsername(customer.getUsername());
		if (opt.isPresent()) {
			throw new CustomerException("Customer Already Exists..");
		}
		Address a = new Address();
		a.setAddressId(customer.getAddress().getAddressId());
		a.setCity(customer.getAddress().getCity());
		a.setColony(customer.getAddress().getColony());
		a.setHouseNo(customer.getAddress().getHouseNo());
		a.setPincode(customer.getAddress().getPincode());
		a.setState(customer.getAddress().getPincode());
		Customer c = new Customer();
		c.setCustomerId(customer.getCustomerId());
		c.setAddress(a);
		c.setCustomerEmail(customer.getCustomerEmail());
		c.setCustomerName(customer.getCustomerName());
		c.setUsername(customer.getUsername());
		c.setPassword(customer.getPassword());
		c.setBalance(customer.getBalance());
		Customer c1 = cDao.save(c);

		return c1;
	}

	@Override
	public Customer upDateCustomer(CustomerDTO customer,String key) throws CustomerException {

		 CurrentUserSession  loggedCustomer = csDao.findByUuid(key);
			
			if(loggedCustomer==null)
			{
				throw new CustomerException("Customer not login , Please Enter a Valid Key....");
			}
			
		Optional<Customer> opt = cDao.findByUsername(customer.getUsername());

		if (opt.isPresent()) {
			Address a = new Address();
			a.setAddressId(customer.getAddress().getAddressId());
			a.setCity(customer.getAddress().getCity());
			a.setColony(customer.getAddress().getColony());
			a.setHouseNo(customer.getAddress().getHouseNo());
			a.setPincode(customer.getAddress().getPincode());
			a.setState(customer.getAddress().getPincode());
			Customer c = new Customer();
			c.setCustomerId(customer.getCustomerId());
			c.setAddress(a);
			c.setCustomerEmail(customer.getCustomerEmail());
			c.setCustomerName(customer.getCustomerName());
			c.setUsername(customer.getUsername());
			c.setPassword(customer.getPassword());
			c.setBalance(customer.getBalance());
			Customer c1 = cDao.save(c);
			return c1;
		}

		throw new CustomerException("Invalid Customer..");
	}

	@Override
	public Customer deleteCustomer(String username,String key) throws CustomerException {

        CurrentUserSession  loggedCustomer = csDao.findByUuid(key);
		
		if(loggedCustomer==null)
		{
			throw new CustomerException("Customer not login , Please Enter a Valid Key....");
		}
		Optional<Customer> opt = cDao.findByUsername(username);

		if (opt.isPresent()) {
			cDao.delete(opt.get());
			return opt.get();
		}

		throw new CustomerException("Invalid Customer..");
	}



	



}
