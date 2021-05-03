package com.sales.book.goods.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.sales.book.goods.vo.GoodsVO;

@Repository
public class GoodsDAO {
	
	private static String namespace = "com.sales.book.mybatis.mapper.goods";

//	@Autowired
	@Resource
	private SqlSession sqlSession;
	
	public List selectGoodsList(String goodsStatus) throws DataAccessException {
		return sqlSession.selectList(namespace + ".selectGoodsList", goodsStatus);
	
	}
	
	public GoodsVO selectGoodsDetail(String goods_id) throws DataAccessException {
		return sqlSession.selectOne(namespace + ".selectGoodsDetail", goods_id);
	}

	public List<String> selectKeywordSearch(String keyword) throws DataAccessException {
		List<String> list = sqlSession.selectList(namespace + ".selectKeywordSearch", keyword);
		return list;
	}
	
	public List<GoodsVO> searchGoods(String searchWord) throws DataAccessException {
		List<GoodsVO> list = sqlSession.selectList(namespace + ".searchGoods", searchWord);
		return list;
	}
	
	
}
