package com.sales.book.mypage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sales.book.member.vo.MemberVO;
import com.sales.book.mypage.service.MyPageService;
import com.sales.book.order.vo.OrderVO;

@Controller
@RequestMapping("/mypage")
public class MyPageController {
	
	@Autowired
	MemberVO memberVO;
	
	@Autowired
	MyPageService myPageService;
	
	@GetMapping("/myPageMain.do")
	public String myPageMain(HttpServletRequest request, Model model) throws Exception{
		
		HttpSession session = request.getSession();
		
		session.setAttribute("side_menu", "my_page");
		
		memberVO = (MemberVO) session.getAttribute("memberInfo");
		
		String member_id = memberVO.getMember_id();
		List<OrderVO> myOrderList = myPageService.listMyOrderGoods(member_id);
		
		System.out.println(myOrderList.toString());
		model.addAttribute("myOrderList", myOrderList);
		return "/mypage/myPageMain";
	}
	
	@GetMapping("/myOrderDetail.do")
	public String myOrderDetail(HttpServletRequest request, Model model) throws Exception{
		
		String order_id = request.getParameter("order_id");
		
		List<OrderVO> myOrderDetailList = myPageService.listMyOrderGoodsDetail(order_id);
		
		System.out.println(myOrderDetailList.toString());
		model.addAttribute("myOrderList", myOrderDetailList);
		
		return "/mypage/myOrderDetail";
	}
	
	@GetMapping("/cancelMyOrder.do")
	public String cancelMyOrder(HttpServletRequest request, Model model) throws Exception {
		
		String order_id = request.getParameter("order_id");
		
		myPageService.cancelMyOrder(order_id);
		
		return "redirect:/mypage/myPageMain.do";
	}
	
}
