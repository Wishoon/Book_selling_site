package com.sales.book.admin.goods;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.sales.book.admin.goods.service.AdminGoodsService;
import com.sales.book.admin.goods.vo.AdminGoodsVO;
import com.sales.book.common.CalcSearchPeriod;
import com.sales.book.goods.vo.GoodsVO;

@Controller
@RequestMapping(value = "/admin/goods")
public class AdminGoodsController {

	@Autowired
	AdminGoodsService adminGoodsService;

	@Autowired
	CalcSearchPeriod sc;
	
	@GetMapping("/adminGoodsMain.do")
	public ModelAndView adminMainPage(@RequestParam Map<String, String> dateMap, HttpServletRequest request)
			throws Exception {
		
		System.out.println(dateMap.toString());
		ModelAndView mav = new ModelAndView("/admin/goods/adminGoodsMain");
		
		HttpSession session = request.getSession();
		session.setAttribute("side_menu", "admin_mode");

		String fixedSearchPeriod = dateMap.get("fixedSearchPeriod");
		String year = dateMap.get("beginYear"); 
		String month = dateMap.get("beginMonth");
		String day = dateMap.get("beginDay");
		String section = dateMap.get("section");
		String pageNum = dateMap.get("pageNum");
		String beginDate = null, endDate = null;

		String[] tempDate = sc.calcSearchPeriod(year, month, day, fixedSearchPeriod).split(",");
		beginDate = tempDate[0];
		endDate = tempDate[1];
		dateMap.put("beginDate", beginDate);
		dateMap.put("endDate", endDate);

		Map<String, Object> condMap = new HashMap<String, Object>();

		if (section == null) {
			section = "1";
		}
		condMap.put("section", section);
		if (pageNum == null) {
			pageNum = "1";
		}
		condMap.put("pageNum", pageNum);
		condMap.put("beginDate", beginDate);
		condMap.put("endDate", endDate);

		List<AdminGoodsVO> newGoodsList = adminGoodsService.listNewGoods(condMap); // 상품들의 정보를 가져온다.

		System.out.println(newGoodsList.toString());
		
		mav.addObject("newGoodsList", newGoodsList);

		String beginDate1[] = beginDate.split("-");
		String endDate2[] = endDate.split("-");
		mav.addObject("beginYear", beginDate1[0]);
		mav.addObject("beginMonth", beginDate1[1]);
		mav.addObject("beginDay", beginDate1[2]);
		mav.addObject("endYear", endDate2[0]);
		mav.addObject("endMonth", endDate2[1]);
		mav.addObject("endDay", endDate2[2]);

		mav.addObject("section", section);
		mav.addObject("pageNum", pageNum);
		return mav;
		
	}
	
	@GetMapping("/addNewGoodsForm.do")
	public String addNewGoodsPage() throws Exception {
		return "/admin/goods/addNewGoodsForm";
	}
	
	@PostMapping("/addNewGoods.do")
	public String addNewGoods(HttpServletResponse response, MultipartHttpServletRequest multipartRequest, @RequestParam Map<Object, Object> result) throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Enumeration enu=multipartRequest.getParameterNames();
		while(enu.hasMoreElements()){
			String name=(String)enu.nextElement();
			String value=multipartRequest.getParameter(name);
			System.out.print(name);
			System.out.println(value);
//			newGoodsMap.put(name,value);
		}
		
		System.out.println(result.toString());
		//1. 상품 정보를 db에 입력
		//2. 상품 id와 아까 받아온 이미지 파일을 db에 입력
//		adminGoodsService.addNewGoods(goodsVO);
		
		return "1";
	}

}
