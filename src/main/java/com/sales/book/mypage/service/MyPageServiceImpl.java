package com.sales.book.mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.book.mypage.MyPageDAO;
import com.sales.book.order.vo.OrderVO;

@Service
public class MyPageServiceImpl implements MyPageService{
	
	@Autowired
	MyPageDAO myPageDAO;

	@Override
	public List<OrderVO> listMyOrderGoods(String member_id) {
		return myPageDAO.selectMyOrder(member_id);
	}

	@Override
	public List<OrderVO> listMyOrderGoodsDetail(String order_id) {
		// TODO Auto-generated method stub
		return myPageDAO.selectMyOrderDetail(order_id);
	}

	@Override
	public void cancelMyOrder(String order_id) {
		myPageDAO.cancelMyOrder(order_id);
	}	
	
	
	
}
