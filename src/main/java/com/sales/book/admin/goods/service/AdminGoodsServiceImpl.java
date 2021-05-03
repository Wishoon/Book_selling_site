package com.sales.book.admin.goods.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.book.admin.goods.dao.AdminGoodsDAO;
import com.sales.book.admin.goods.vo.AdminGoodsVO;

@Service
public class AdminGoodsServiceImpl implements AdminGoodsService{

	
	@Autowired
	AdminGoodsDAO adminGoodsDAO;
	
	@Override
	public List<AdminGoodsVO> listNewGoods(Map<String, Object> condMap) throws Exception {
		
		return adminGoodsDAO.selectNewGoodsList(condMap);
	}
}
