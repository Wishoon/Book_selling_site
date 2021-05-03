package com.sales.book.main;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sales.book.goods.service.GoodService;
import com.sales.book.goods.vo.GoodsVO;

@Controller
public class MainController {

	@Autowired
	GoodService goodservice;
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(Model model) throws Exception {
		logger.info("main.jsp");
		
		Map<String, List<GoodsVO>> goodsMap = goodservice.listGoods();
		System.out.println(goodsMap.toString());
		model.addAttribute("goodsMap", goodsMap);
	
		return "main";
	}
	
}
