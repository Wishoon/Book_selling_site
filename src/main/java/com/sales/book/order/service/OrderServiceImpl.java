package com.sales.book.order.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.book.cart.vo.CartVO;
import com.sales.book.order.dao.OrderDAO;
import com.sales.book.order.vo.OrderVO;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDAO orderDAO;
	

	@Override
	public List<OrderVO> myOrderList(CartVO cartVO) {
		
		List<OrderVO> myOrderList = orderDAO.selectMyOrderList(cartVO);
		
		return myOrderList;
	}


	@Override
	public void addNewOrder(List<OrderVO> myOrderList) throws Exception{
		
		orderDAO.insertNewOrder(myOrderList);
		orderDAO.removeCart(myOrderList);
	}
	
}
