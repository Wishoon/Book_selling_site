package com.sales.book.cart;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.sales.book.cart.vo.CartListVO;
import com.sales.book.cart.vo.CartVO;

@Repository
public class CartDAO {
	
	private static String namespace = "com.sales.book.mybatis.mapper.cart";
	
	@Autowired
	private SqlSession sqlSession;

	
	
	public int selectCountInCart(CartVO cartVO) throws DataAccessException {
		int result = sqlSession.selectOne(namespace + ".selectCountInCart", cartVO);
		return result;
	}
	
	public void insertGoodsInCart(CartVO cartVO) throws DataAccessException {
		sqlSession.insert(namespace + ".insertGoodsDetailInCart", cartVO);
		System.out.println(cartVO.toString());
	}
	
	//수정 중
	public List<CartListVO> selectMyCartList(CartVO cartVO) throws DataAccessException {
		List<CartListVO> myCartList = sqlSession.selectList(namespace + ".selectMyGoodsList", cartVO);
		
		return myCartList;
	}
	public void updateCartGoodsQty(CartVO cartVO) throws DataAccessException {
		sqlSession.insert(namespace + ".updateCartGoodsQty", cartVO);
	}
	
	public Map<String, Object> deleteCartGoods(Map<String, Object> parameters) throws DataAccessException {
		sqlSession.delete(namespace + ".deleteCartGoods", parameters);
		
		return null;
	}
	
//	public void deleteCartGoods(int cart_id, int goods_id) throws DataAccessException {
//		sqlSession.delete(namespace + ".deleteCartGoods", cart_id);
//	}
	
	//	public Map<String, List> selectMyCartList(CartVO cartVO) throws DataAccessException {
//		return sqlSession.selectList(namespace + ".", cartVO);
//	}
//	public List<CartVO> selectCartList(CartVO cartVO) throws DataAccessException {
//		List<CartVO> cartList = sqlSession.selectList(namespace + ".cartResult", cartVO);
//		
//		return cartList;
//	}
//	
//	public List<GoodsVO> selectGoodsList(List<CartVO> cartVO) throws DataAccessException {
//		List<GoodsVO> myGoodsList = sqlSession.selectList(namespace + ".goodsResult", cartVO);
//		
//		return myGoodsList;
//	}
//	public Map<String, String> selectMyCartList(CartVO cartVO) throws DataAccessException {
//		return (Map<String, String>) sqlSession.selectList(namespace + ".selectMyCartList", cartVO);
//	}
}
