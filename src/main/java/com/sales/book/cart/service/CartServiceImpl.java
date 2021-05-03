package com.sales.book.cart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.book.cart.CartDAO;
import com.sales.book.cart.vo.CartListVO;
import com.sales.book.cart.vo.CartVO;
import com.sales.book.goods.vo.GoodsVO;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartDAO cartDAO;

	@Override
	public int findCartGoods(CartVO cartVO) {
		return cartDAO.selectCountInCart(cartVO);
	}

	@Override
	public void addGoodsInCart(CartVO cartVO) {
		cartDAO.insertGoodsInCart(cartVO);	
	}

	@Override
	public List<CartListVO> myCartList(CartVO cartVO) {
		List<CartListVO> myCartList= cartDAO.selectMyCartList(cartVO);
//		if(myCartList.size() == 0) {
//			System.out.println(myCartList.size());
//			return null;
//		}
		return myCartList;
	}

	@Override
	public boolean modifyCartQty(CartVO cartVO) {
		boolean result = true;
		cartDAO.updateCartGoodsQty(cartVO);
		
		return result;
	}

	@Override
	public Map<String, Object> removeCartGoods(Map<String, Object> parameters) {
		
		cartDAO.deleteCartGoods(parameters);
		
		return null;
	}

	
	
	

//	@Override
//	public List<CartVO> myCartList(CartVO cartVO) {
//		
//		List<CartVO> myCartList = cartDAO.selectMyCartList(cartVO);
//		
//		return myCartList;
//	}

//	@Override
//	public Map<String, String> myCartList(CartVO cartVO) {
////		Map<String, List> cartMap = new HashMap<String, List>();
//		
////		List<CartVO> myCartList = cartDAO.selectCartList(cartVO);
////		if(myCartList.size()==0) {
////			return null;
////		}
////		
////		List<GoodsVO> myGoodsList = cartDAO.selectGoodsList(myCartList);
//		
//		Map<String, String> cartMap = cartDAO.selectMyCartList(cartVO);
//		
////		cartMap.put("myCartList", myCartList);
////		cartMap.put("myGoodsList", myGoodsList);
//		
//		return cartMap;
//	}
	
	
	
	
}
