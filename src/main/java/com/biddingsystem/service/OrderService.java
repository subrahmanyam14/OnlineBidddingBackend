package com.biddingsystem.service;

import java.util.List;

import com.biddingsystem.entity.Orders;
import com.biddingsystem.entity.User;

public interface OrderService {

	List<Orders> addOrder(List<Orders> orders);

	List<Orders> updateOrders(List<Orders> orders);

	List<Orders> getOrdersByOrderId(String orderId);

	Orders getOrderById(int orderId);

	List<Orders> getOrdersByUser(User user);

	Orders updateOrder(Orders order);

	List<Orders> getOrdersByOrderIdAndStatusIn(String orderId, List<String> status);
	
	List<Orders> getOrdersByUserAndStatusIn(User user, List<String> status);
	
	List<Orders> getOrdersBySellerAndStatusIn(User user, List<String> status);
	
	List<Orders> getAllOrders();
	
	List<Orders> getOrdersByDeliveryPersonAndStatusIn(User user, List<String> status);

}
