package com.sales.book.cart;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sales.book.cart.service.CartService;
import com.sales.book.cart.vo.CartListVO;
import com.sales.book.cart.vo.CartVO;
import com.sales.book.goods.vo.GoodsVO;
import com.sales.book.member.vo.MemberVO;

@Controller
@RequestMapping(value="/cart")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@Autowired
	CartVO cartVO;
	
	@Autowired
	MemberVO memberVO; 
	
	@PostMapping("/addGoodsInCart.do")
	public @ResponseBody String addGoodsInCart(@RequestParam("goods_id") int goods_id, HttpServletRequest request) {
	
		HttpSession session = request.getSession();
		memberVO = (MemberVO)session.getAttribute("memberInfo");
		System.out.println(memberVO.toString());
	
		String member_id = memberVO.getMember_id();
		
		cartVO.setMember_id(member_id);
		cartVO.setGoods_id(goods_id);
		cartVO.setCart_id(memberVO.getCart_id());
//		System.out.println(cartVO.toString());
		int isAlreadyExisted = cartService.findCartGoods(cartVO);
		System.out.println(isAlreadyExisted);
		if(isAlreadyExisted != 1) {
			cartService.addGoodsInCart(cartVO);
			return "add_success";
		}else {
			return "already_existed";
		}
	}
	
	@GetMapping("/myCartList.do")
	public String myCartMain(HttpServletRequest request, Model model) throws Exception{
		
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO)session.getAttribute("memberInfo");
		
		String member_id = memberVO.getMember_id();
		int cart_id = memberVO.getCart_id();
		cartVO.setMember_id(member_id);
		cartVO.setCart_id(cart_id);
		System.out.println(cartVO.toString());
		
		List<CartListVO> cartList = cartService.myCartList(cartVO);
		System.out.println(cartList.toString());
		session.setAttribute("cartList", cartList);
		
		model.addAttribute("cartList", cartList);
		
		return "/cart/myCartList";
	}
	
	@PostMapping("/modifyCartQty.do")
	public @ResponseBody String modifyCartQty(@RequestParam("goods_id") int goods_id, @RequestParam("cart_goods_qty") int cart_goods_qty, HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		memberVO = (MemberVO)session.getAttribute("memberInfo");
		
		int cart_id = memberVO.getCart_id();
		
		System.out.println(goods_id);
		System.out.println(cart_id);
		System.out.println(cart_goods_qty);
		
		cartVO.setGoods_id(goods_id);
		cartVO.setCart_id(cart_id);
		cartVO.setCart_goods_qty(cart_goods_qty);
		
		boolean result = cartService.modifyCartQty(cartVO); // 수정 서비스 단		
		
		if(result = true) {
			return "modify_success";
		}else {
			return "modify_failed";
		}		
	}
	
	@PostMapping("/deleteCartGoods.do")
	public @ResponseBody String removeCartGoods(@RequestParam("cart_id") int cart_id, @RequestParam("goods_id") int goods_id) throws Exception{
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("cart_id", cart_id);
		parameters.put("goods_id", goods_id);
		
		System.out.println(parameters.toString());
		cartService.removeCartGoods(parameters);
		
		return "";
	}
}
