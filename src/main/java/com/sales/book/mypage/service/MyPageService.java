package com.sales.book.mypage.service;

import java.util.List;

import com.sales.book.order.vo.OrderVO;

public interface MyPageService {
	
	public List<OrderVO> listMyOrderGoods(String member_id);
	
	public List<OrderVO> listMyOrderGoodsDetail(String order_id);
	
	public void cancelMyOrder(String order_id);
}
