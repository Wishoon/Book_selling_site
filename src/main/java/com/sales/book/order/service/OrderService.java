package com.sales.book.order.service;

import java.util.List;

import com.sales.book.cart.vo.CartVO;
import com.sales.book.order.vo.OrderVO;

public interface OrderService {

	public List<OrderVO> myOrderList (CartVO cartVO) throws Exception;
	 
	public void addNewOrder (List<OrderVO> myOrderList) throws Exception;
	
}
