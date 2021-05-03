package com.sales.book.admin.goods.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.sales.book.admin.goods.vo.AdminGoodsVO;


@Repository
public class AdminGoodsDAO {
	
	private static String namespace = "com.sales.book.mybatis.mapper.admin_goods";

	@Autowired
	private SqlSession sqlSession;
	
	public List<AdminGoodsVO> selectNewGoodsList (Map<String, Object> condMap) throws DataAccessException {
		System.out.println(condMap.toString());
		ArrayList<AdminGoodsVO> goodsList = (ArrayList)sqlSession.selectList(namespace + ".adminSelectGoods", condMap);
	
		return goodsList;
	}
	
}
