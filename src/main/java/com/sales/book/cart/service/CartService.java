package com.sales.book.cart.service;

import java.util.List;
import java.util.Map;

import com.sales.book.cart.vo.CartListVO;
import com.sales.book.cart.vo.CartVO;

public interface CartService {
	
	public int findCartGoods(CartVO cartVO);
	
	public void addGoodsInCart(CartVO cartVO);
	
	public List<CartListVO> myCartList(CartVO cartVO);
	
	public boolean modifyCartQty(CartVO cartVO);
	
	public Map<String, Object> removeCartGoods(Map<String, Object> parameters);
//	public List<CartVO> myCartList(CartVO cartVO);
	
}
