package com.sales.book.admin.goods.service;

import java.util.List;
import java.util.Map;

import com.sales.book.admin.goods.vo.AdminGoodsVO;

public interface AdminGoodsService {
	
	public List<AdminGoodsVO> listNewGoods(Map<String, Object> condMap) throws Exception;
	
}
