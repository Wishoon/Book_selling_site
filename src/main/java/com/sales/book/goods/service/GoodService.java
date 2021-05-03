package com.sales.book.goods.service;

import java.util.List;
import java.util.Map;

import com.sales.book.goods.vo.GoodsVO;

public interface GoodService {
	
	public Map<String,List<GoodsVO>> listGoods() throws Exception;	// newbook, bestseller, steadyseller 가져오기
	
	public Map<String, GoodsVO> goodsDetail(String goods_id) throws Exception; // 상품 상세 정보 가져오기
	
	public List<String> keywordSearch(String keyword) throws Exception;	// keyword 검색하기
	
	public List<GoodsVO> searchGoods(String searchWord) throws Exception; // keyword 검색 데이터 가져오기
	
}
