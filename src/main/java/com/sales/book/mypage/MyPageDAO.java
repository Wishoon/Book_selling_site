package com.sales.book.mypage;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.sales.book.order.vo.OrderVO;

@Repository
public class MyPageDAO {

	private static String namespace = "com.sales.book.mybatis.mapper.mypage";
	@Autowired
	private SqlSession sqlSession;
	
	public List<OrderVO> selectMyOrder(String member_id) throws DataAccessException{
		List<OrderVO> myOrderListGoods = sqlSession.selectList(namespace + ".selectMyOrderGoodsList", member_id);
		System.out.println(myOrderListGoods.toString());
		return myOrderListGoods;
	}

	public List<OrderVO> selectMyOrderDetail(String order_id) {
		List<OrderVO> myOrderDetailListGoods = sqlSession.selectList(namespace + ".selectMyOrderDetailGoodsList", order_id);
		return myOrderDetailListGoods;
	}
	
	public void cancelMyOrder(String order_id) {
		sqlSession.update(namespace + ".cancelMyOrder", order_id);
	}
}
 