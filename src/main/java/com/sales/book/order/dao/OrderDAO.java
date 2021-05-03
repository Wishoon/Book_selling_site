package com.sales.book.order.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.sales.book.cart.vo.CartVO;
import com.sales.book.order.vo.OrderVO;

@Repository
public class OrderDAO {

	private static String namespace = "com.sales.book.mybatis.mapper.order";
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<OrderVO> selectMyOrderList(CartVO cartVO) throws DataAccessException{
		List<OrderVO> myOrderList = sqlSession.selectList(namespace + ".", cartVO);
		
		return myOrderList;
	}
	
	public void insertNewOrder(List<OrderVO> myOrderList) throws DataAccessException{
		
		OrderVO newOrder = (OrderVO)myOrderList.get(0);
		sqlSession.insert(namespace + ".insertNewOrder", newOrder);
		
		System.out.println(newOrder.toString());
		int order_id = sqlSession.selectOne(namespace + ".selectOrderNum", newOrder);
		
		for(int i=0; i<myOrderList.size(); i++) {
			OrderVO orderVO = (OrderVO)myOrderList.get(i);
			orderVO.setOrder_id(order_id);	
			sqlSession.insert(namespace + ".insertNewOrderDetail", orderVO);
		}
	}
	
	public void removeCart(List<OrderVO> myOrderList) throws DataAccessException{
		for(int i=0; i<myOrderList.size(); i++) {
			OrderVO orderVO = (OrderVO)myOrderList.get(i);
			sqlSession.delete(namespace + ".deleteCart", orderVO);
		}
	}

}
