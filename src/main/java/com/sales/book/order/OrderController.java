package com.sales.book.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sales.book.cart.vo.CartListVO;
import com.sales.book.cart.vo.CartVO;
import com.sales.book.member.vo.MemberVO;
import com.sales.book.order.service.OrderService;
import com.sales.book.order.vo.OrderVO;

@Controller
@RequestMapping(value="/order")
public class OrderController {

//	@RequestMapping(value="/orderEachGoods.do")
////	public String 
//	//로그인 상태가 아닐경우 로그인으로 이동
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderVO orderVO;
	
	@Autowired
	CartVO cartVO;
	
	@Autowired
	MemberVO memberVO;
	
	@PostMapping("/orderAllCartGoods.do")
	public String orderAllCartGoods(HttpServletRequest request, Model model, @RequestParam("cart_goods_qty") String[] cart_goods_qty) throws Exception {
		
		HttpSession session = request.getSession(); 
		List<CartListVO> cartList = (List<CartListVO>)session.getAttribute("cartList");
		System.out.println(cartList.toString());
		
		MemberVO memberVO = (MemberVO)session.getAttribute("memberInfo");
		System.out.println(memberVO.toString());
		List<OrderVO> myOrderList = new ArrayList<OrderVO>();
		
		for(int i=0; i<cart_goods_qty.length; i++) {
			String [] cart_goods = cart_goods_qty[i].split(":");
//			System.out.println(cart_goods_qty[i]);
			//카트 상품 아이디 및 주문 갯수
			//실제 상품 세부 정보 
			for(int j=0; j<cartList.size(); j++) {
				int goods_id = cartList.get(j).getGoods_id();
				
				if(goods_id == Integer.parseInt(cart_goods[0])) {
					OrderVO orderVO = new OrderVO(); 
					
					String goods_title = cartList.get(j).getGoods_title();
					int goods_sales_price = cartList.get(j).getGoods_sales_price();
					String goods_fileName = cartList.get(i).getGoods_fileName();
					
					orderVO.setGoods_id(goods_id);
					orderVO.setGoods_title(goods_title);
					orderVO.setGoods_sales_price(goods_sales_price);
					orderVO.setGoods_fileName(goods_fileName);
					orderVO.setCart_goods_qty(Integer.parseInt(cart_goods[1]));
					
					myOrderList.add(orderVO);
					break;
				}
			}
		}
		System.out.println(myOrderList.toString());
		
		session.setAttribute("orderer", memberVO);
		session.setAttribute("myOrderList", myOrderList);
		
		model.addAttribute("orderer", memberVO);
		model.addAttribute("myOrderList", myOrderList);
		
		return "/order/orderGoodsForm";
	}

	@PostMapping("/payToOrderGoods.do")
	public String payToOrderGoods(@RequestParam Map<String, String> receiverMap, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		
		System.out.println(receiverMap.toString());
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO)session.getAttribute("orderer");
		
//		service단으로 교체
		String member_id = memberVO.getMember_id();
		int cart_id = memberVO.getCart_id();
//		String orderer_name = memberVO.getMember_name();
//		String orderer_hp = memberVO.getMember_hp1() + "-" + memberVO.getMember_hp2() + "-" + memberVO.getMember_hp3();
//		String orderer_hp1 = memberVO.getMember_hp1();
//		String orderer_hp2 = memberVO.getMember_hp2();
//		String orderer_hp3 = memberVO.getMember_hp3();
		String delivery_address = "우편번호:"+receiverMap.get("post_code")+"<br>"+
				"도로명 주소:"+receiverMap.get("parcel_address")+"<br>"+
				"지번 주소:"+receiverMap.get("street_address")+"<br>"+
				"상세 주소:"+receiverMap.get("detail_address");
//		System.out.println(delivery_address);
//		System.out.println(receiverMap.toString());
		
		List<OrderVO> myOrderList = new ArrayList<OrderVO>();		
		myOrderList = (List<OrderVO>)session.getAttribute("myOrderList");
		
		for(int i=0; i<myOrderList.size(); i++) {
			OrderVO orderVO = (OrderVO)myOrderList.get(i);
			orderVO.setMember_id(member_id);
			orderVO.setCart_id(cart_id);
			orderVO.setOrderer_name(receiverMap.get("orderer_name"));
			orderVO.setOrderer_hp1(receiverMap.get("orderer_hp1"));
			orderVO.setOrderer_hp2(receiverMap.get("orderer_hp2"));
			orderVO.setOrderer_hp3(receiverMap.get("orderer_hp3"));
			orderVO.setOrderer_email1(receiverMap.get("orderer_email1"));
			orderVO.setOrderer_email2(receiverMap.get("orderer_email2"));
			orderVO.setReceiver_name(receiverMap.get("receiver_name"));
			orderVO.setReceiver_hp1(receiverMap.get("receiver_hp1"));
			orderVO.setReceiver_hp2(receiverMap.get("receiver_hp2"));
			orderVO.setReceiver_hp3(receiverMap.get("receiver_hp3"));
			orderVO.setDelivery_address(delivery_address);
			orderVO.setDelivery_state("delivery_prepared");
			orderVO.setDelivery_message(receiverMap.get("delivery_message"));
			orderVO.setDelivery_method(receiverMap.get("delivery_method"));
			orderVO.setGift_wrapping(receiverMap.get("gift_wrapping"));
			orderVO.setPay_method(receiverMap.get("pay_method"));
			orderVO.setCard_com_name(receiverMap.get("card_com_name"));
			orderVO.setCard_pay_month(receiverMap.get("card_pay_month"));
			
			myOrderList.set(i, orderVO);
			System.out.println(orderVO.toString());
		}
		
//		System.out.println(myOrderList.toString());
	
		orderService.addNewOrder(myOrderList);

		session.setAttribute("orderer", memberVO);
		model.addAttribute("myOrderList", myOrderList);
		model.addAttribute("myOrderInfo", receiverMap);
		return "/order/orderResult";
	}
	
}
