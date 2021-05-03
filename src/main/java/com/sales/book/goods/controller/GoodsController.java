package com.sales.book.goods.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sales.book.goods.service.GoodService;
import com.sales.book.goods.vo.GoodsVO;

@Controller
@RequestMapping(value="/goods")
public class GoodsController {
	@Autowired
	GoodService goodservice;
	
	@RequestMapping(value="/goodsDetail.do", method=RequestMethod.GET)
	public String goodsDetail(@RequestParam("goods_id") String goods_id, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		
		Map goodsMap = goodservice.goodsDetail(goods_id);
		model.addAttribute("goodsMap", goodsMap);
		
		HttpSession session = request.getSession();	//현재의 세션을 저장
		
		GoodsVO goodsVO = (GoodsVO)goodsMap.get("goodsVO");
		addGoodsInQuick(goods_id, goodsVO, session);
		
		return "/goods/goodsDetail";
	}
	
	private void addGoodsInQuick(String goods_id, GoodsVO goodsVO, HttpSession session) {
		
		boolean already_existed=false; // 상품 정보를 목록에 (true면 저장, false면 저장x)
		
		List<GoodsVO> quickGoodsList;
		quickGoodsList = (ArrayList<GoodsVO>)session.getAttribute("quickGoodsList"); //세션에 저장된 최근 본 상품 목록을 가져온다.
		
		if(quickGoodsList != null) {								//최근 본 상품이 있는 경우
			for(int i=0; i<quickGoodsList.size(); i++) {
				GoodsVO goodsBean = (GoodsVO)quickGoodsList.get(i); //상품 목록을 가져와 이미 존재하는 상품인지 비교를 한다.
				if(goods_id.equals(goodsBean.getGoods_id())) {		//----> 현재 중복 상품 비교 실행 불가
					already_existed=true;							
					break;
				}
			}
			if(already_existed==false) {							//존재하지 않는 상품이면 상품 정보를 목록에 저장한다.
				quickGoodsList.add(goodsVO);
			}
		}
		else {
			quickGoodsList = new ArrayList<GoodsVO>();				//최근 본 상품 목록이 없으면 생성하여 상품 정보를 저장한다.
			quickGoodsList.add(goodsVO);
		}
		session.setAttribute("quickGoodsList", quickGoodsList);		//최근 본 상품 목록을 세션에 저장한다.
		session.setAttribute("quickGoodsListNum", quickGoodsList.size());
	}
	
	@RequestMapping(value="/keywordSearch.do", method=RequestMethod.GET, produces = "application/text; charset=utf8")
	public @ResponseBody String keywordSearch(@RequestParam("keyword") String keyword) throws Exception {
		
		if(keyword == null || keyword.equals("")) {
			return null;
		}
		
		List<String> keywordList = goodservice.keywordSearch(keyword); //가져온 키워드가 포함된 상품 제목 조회
		
		JSONObject jsonObject = new JSONObject(); 
		jsonObject.put("keyword", keywordList);						   //조회 데이터를 JSON에 저장
		
		String jsonInfo = jsonObject.toString();					   //JSON 문자열로 변환
		
		System.out.println(jsonInfo);
		return jsonInfo;
	}
	
	@RequestMapping(value="/searchGoods.do", method=RequestMethod.GET)
	public String searchGoods(@RequestParam("searchWord") String searchWord, Model model) throws Exception {
		
		System.out.println(searchWord);
		List<GoodsVO> goodsList = goodservice.searchGoods(searchWord);
		model.addAttribute("goodsList", goodsList);
		
		return "/goods/searchGoods";
	}
	
}

