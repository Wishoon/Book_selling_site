package com.sales.book.goods.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.book.goods.dao.GoodsDAO;
import com.sales.book.goods.vo.GoodsVO;

@Service
public class GoodServiceImpl implements GoodService{
	@Autowired
	GoodsDAO goodsDAO;
	
	@Override
	public Map<String,List<GoodsVO>> listGoods() throws Exception {
		
		Map<String, List<GoodsVO>> goodsMap = new HashMap<String, List<GoodsVO>>();
		
		List<GoodsVO> goodsList = goodsDAO.selectGoodsList("bestseller");
		
		goodsMap.put("bestseller", goodsList);
		
		goodsList = goodsDAO.selectGoodsList("newbook");
		goodsMap.put("newbook", goodsList);
		
		goodsList = goodsDAO.selectGoodsList("steadyseller");
		goodsMap.put("steadyseller", goodsList);
		
		return goodsMap;
	}

	@Override
	public Map<String, GoodsVO> goodsDetail(String goods_id) throws Exception {
		
		Map<String, GoodsVO> goodsMap = new HashMap<String, GoodsVO>();
		
		GoodsVO goodsVO = goodsDAO.selectGoodsDetail(goods_id);
		goodsMap.put("goodsVO", goodsVO);
		
		return goodsMap;
	}

	@Override
	public List<String> keywordSearch(String keyword) throws Exception {
		
		List<String> list = goodsDAO.selectKeywordSearch(keyword);
		
		return list;
	}

	@Override
	public List<GoodsVO> searchGoods(String searchWord) throws Exception {
	
		List<GoodsVO> list = goodsDAO.searchGoods(searchWord);
		
		return list;
	}
	
	
	
}
