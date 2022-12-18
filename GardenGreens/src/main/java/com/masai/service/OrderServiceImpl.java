package com.masai.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.exception.OrderException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.Orders;
import com.masai.model.OrdersDTO;
import com.masai.model.Planter;
import com.masai.model.Plants;
import com.masai.repository.CurrentSessionRepo;
import com.masai.repository.CustomerDao;
import com.masai.repository.OrderDao;
import com.masai.repository.PlantDao;
import com.masai.repository.PlanterDao;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao oDao;

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private CurrentSessionRepo currentUserRepo;

	@Autowired
	private PlantDao plantDao;

	@Autowired
	private PlanterDao planterDao;

	@Override
	public Orders addOrder(OrdersDTO orders, String key) throws OrderException, CustomerException {

		CurrentUserSession loggedUser = currentUserRepo.findByUuid(key);

		if (loggedUser == null) {
			throw new CustomerException("Please login first and Enter a Valid Key to placing the order.");
		}
		Customer customer = customerDao.findByCustomerEmail(orders.getCustomerEmail());

		if (customer == null) {
			throw new CustomerException("Invalid Customer Email details , Please login first for placing the order. ");
		}

		if (customer.getCustomerId() == loggedUser.getUserId()) {

			Orders orderDetails = new Orders();
			orderDetails.setOrderDate(LocalDate.now());
			orderDetails.setTransactionMode(orders.getTransactionMode());
			
			if (orders.getQuantityPlanter() > 0) {
				orderDetails.setPlanterQuantity(orders.getQuantityPlanter());
			}
			if (orders.getQuantityPlant() > 0) {
				orderDetails.setPlantQuantity(orders.getQuantityPlant());
			}

			orderDetails.setCustomerId(customer.getCustomerId());
			double total = 0;
			Optional<Planter> planter = planterDao.findById(orders.getPlanterId());
			Optional<Plants> plant = plantDao.findById(orders.getPlantId());


			if (planter.isPresent()) {

				Set<Planter> list = new HashSet<>();

				if (orders.getQuantityPlanter() <= planter.get().getPlanterStock()) {
					list.add(planter.get());
					orderDetails.setPlanters(list);
					planter.get().setPlanterStock(planter.get().getPlanterStock() - orders.getQuantityPlanter());
					planterDao.save(planter.get());
					total = total + (orders.getQuantityPlanter() * planter.get().getPlanterCost());
				} else
					throw new OrderException("Insufficient stock for planters ");

			}

			if (plant.isPresent()) {

				Set<Plants> list = new HashSet<>();

				if (orders.getQuantityPlant() <= plant.get().getPlantStock()) {
					list.add(plant.get());
					orderDetails.setPlants(list);
					plant.get().setPlantStock(plant.get().getPlantStock() - orders.getQuantityPlant());
					plantDao.save(plant.get());
					total = total + orders.getQuantityPlant() * plant.get().getPlantCost();
				} else
					throw new OrderException("Insufficient stock for plants ");

			}

			orderDetails.setCost((int) total);
			oDao.save(orderDetails);

			return orderDetails;

		}

		throw new CustomerException("Please Login for placing the order...");

	}



	@Override
	public String deleteOrder(Integer orderId, String key) throws OrderException, CustomerException {

		CurrentUserSession loggeduser = currentUserRepo.findByUuid(key);

		if (loggeduser == null) {
			throw new CustomerException("Please login first and Enter a Valid Key to deleting the order.");
		}

		Optional<Customer> opt = customerDao.findById(loggeduser.getUserId());

		Optional<Orders> orders = oDao.findById(orderId);

		if (opt.isPresent()) {
			if (orders.isPresent()) {
				if (orders.get().getCustomerId() == opt.get().getCustomerId()) {
					oDao.delete(orders.get());

					return "Order deleted successfully.";
				}
				throw new CustomerException("invalid key , Please login first for deleting the order. ");
			}
			throw new OrderException("No order found with this order id " + orderId);
		}
		throw new CustomerException("Invalid key details , Please login first for deleting the order. ");
	}

	

	@Override
	public List<Orders> viewAllOrders(String key) throws OrderException {
		CurrentUserSession loggeduser = currentUserRepo.findByUuid(key);
		List<Orders> li = new ArrayList<>();
		Optional<Customer> opt = customerDao.findById(loggeduser.getUserId());
		
		if(opt.get()!=null) {
			li.addAll(opt.get().getOrders());
			return li ;
		}
		else throw new OrderException("No order yet been placed...");
	}

}
