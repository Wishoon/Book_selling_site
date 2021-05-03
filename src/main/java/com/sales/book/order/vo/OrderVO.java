package com.sales.book.order.vo;

import org.springframework.stereotype.Component;

@Component
public class OrderVO {
	
	private String member_id;
	private int cart_id;
	private int order_id;
	
	private int goods_id;
	private String goods_title;
	private int goods_sales_price;
	private String goods_fileName;
	private int cart_goods_qty;
	private int goods_delivery_price;
	private int goods_point;

	private int total_goods_price;
//	private int order_goods_qty;

	private String orderer_name; // 주문 사람
//	private String order_hp1;
	private String orderer_hp1;
	private String orderer_hp2;
	private String orderer_hp3;
	private String orderer_email1;
	private String orderer_email2;
	
	private String delivery_address;
	private String delivery_method; // 배송 방법
	private String receiver_name; // 받는 사람
	private String receiver_hp1;
	private String receiver_hp2;
	private String receiver_hp3;
//	private String post_code; // 우편번호
//	private String parcel_address; // 지번주소
//	private String street_address; // 도로명 주소
//	private String detail_address; // 나머지 주소
	private String delivery_message;
	private String gift_wrapping;

	private String pay_method; // 결제 방법
	private String card_com_name; // 카드 회사
	private String card_pay_month; // 할부 기간

	private String order_date; // 주문 결제 시간
	private String delivery_state; // 현재 주문 상품 배송 상태
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public String getGoods_title() {
		return goods_title;
	}
	public void setGoods_title(String goods_title) {
		this.goods_title = goods_title;
	}
	public int getGoods_sales_price() {
		return goods_sales_price;
	}
	public void setGoods_sales_price(int goods_sales_price) {
		this.goods_sales_price = goods_sales_price;
	}
	public String getGoods_fileName() {
		return goods_fileName;
	}
	public void setGoods_fileName(String goods_fileName) {
		this.goods_fileName = goods_fileName;
	}
	public int getCart_goods_qty() {
		return cart_goods_qty;
	}
	public void setCart_goods_qty(int cart_goods_qty) {
		this.cart_goods_qty = cart_goods_qty;
	}
	public int getGoods_delivery_price() {
		return goods_delivery_price;
	}
	public void setGoods_delivery_price(int goods_delivery_price) {
		this.goods_delivery_price = goods_delivery_price;
	}
	public int getGoods_point() {
		return goods_point;
	}
	public void setGoods_point(int goods_point) {
		this.goods_point = goods_point;
	}
	public String getOrderer_name() {
		return orderer_name;
	}
	public void setOrderer_name(String orderer_name) {
		this.orderer_name = orderer_name;
	}
	public String getOrderer_hp1() {
		return orderer_hp1;
	}
	public void setOrderer_hp1(String orderer_hp1) {
		this.orderer_hp1 = orderer_hp1;
	}
	public String getOrderer_hp2() {
		return orderer_hp2;
	}
	public void setOrderer_hp2(String orderer_hp2) {
		this.orderer_hp2 = orderer_hp2;
	}
	public String getOrderer_hp3() {
		return orderer_hp3;
	}
	public void setOrderer_hp3(String orderer_hp3) {
		this.orderer_hp3 = orderer_hp3;
	}
	public String getOrderer_email1() {
		return orderer_email1;
	}
	public void setOrderer_email1(String orderer_email1) {
		this.orderer_email1 = orderer_email1;
	}
	public String getOrderer_email2() {
		return orderer_email2;
	}
	public void setOrderer_email2(String orderer_email2) {
		this.orderer_email2 = orderer_email2;
	}
	public String getDelivery_address() {
		return delivery_address;
	}
	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}
	public String getDelivery_method() {
		return delivery_method;
	}
	public void setDelivery_method(String delivery_method) {
		this.delivery_method = delivery_method;
	}
	public String getReceiver_name() {
		return receiver_name;
	}
	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}
	public String getReceiver_hp1() {
		return receiver_hp1;
	}
	public void setReceiver_hp1(String receiver_hp1) {
		this.receiver_hp1 = receiver_hp1;
	}
	public String getReceiver_hp2() {
		return receiver_hp2;
	}
	public void setReceiver_hp2(String receiver_hp2) {
		this.receiver_hp2 = receiver_hp2;
	}
	public String getReceiver_hp3() {
		return receiver_hp3;
	}
	public void setReceiver_hp3(String receiver_hp3) {
		this.receiver_hp3 = receiver_hp3;
	}
	public String getDelivery_message() {
		return delivery_message;
	}
	public void setDelivery_message(String delivery_message) {
		this.delivery_message = delivery_message;
	}
	public String getGift_wrapping() {
		return gift_wrapping;
	}
	public void setGift_wrapping(String gift_wrapping) {
		this.gift_wrapping = gift_wrapping;
	}
	public String getPay_method() {
		return pay_method;
	}
	public void setPay_method(String pay_method) {
		this.pay_method = pay_method;
	}
	public String getCard_com_name() {
		return card_com_name;
	}
	public void setCard_com_name(String card_com_name) {
		this.card_com_name = card_com_name;
	}
	public String getCard_pay_month() {
		return card_pay_month;
	}
	public void setCard_pay_month(String card_pay_month) {
		this.card_pay_month = card_pay_month;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getDelivery_state() {
		return delivery_state;
	}
	public void setDelivery_state(String delivery_state) {
		this.delivery_state = delivery_state;
	}
	public int getTotal_goods_price() {
		return total_goods_price;
	}
	public void setTotal_goods_price(int total_goods_price) {
		this.total_goods_price = total_goods_price;
	}
	
	@Override
	public String toString() {
		return "OrderVO [member_id=" + member_id + ", cart_id=" + cart_id + ", order_id=" + order_id + ", goods_id="
				+ goods_id + ", goods_title=" + goods_title + ", goods_sales_price=" + goods_sales_price
				+ ", goods_fileName=" + goods_fileName + ", cart_goods_qty=" + cart_goods_qty
				+ ", goods_delivery_price=" + goods_delivery_price + ", goods_point=" + goods_point
				+ ", total_goods_price=" + total_goods_price + ", orderer_name=" + orderer_name + ", orderer_hp1="
				+ orderer_hp1 + ", orderer_hp2=" + orderer_hp2 + ", orderer_hp3=" + orderer_hp3 + ", orderer_email1="
				+ orderer_email1 + ", orderer_email2=" + orderer_email2 + ", delivery_address=" + delivery_address
				+ ", delivery_method=" + delivery_method + ", receiver_name=" + receiver_name + ", receiver_hp1="
				+ receiver_hp1 + ", receiver_hp2=" + receiver_hp2 + ", receiver_hp3=" + receiver_hp3
				+ ", delivery_message=" + delivery_message + ", gift_wrapping=" + gift_wrapping + ", pay_method="
				+ pay_method + ", card_com_name=" + card_com_name + ", card_pay_month=" + card_pay_month
				+ ", order_date=" + order_date + ", delivery_state=" + delivery_state + "]";
	}

	// 주문 리스트

	// 배송방법
	// 배송지 선택
	// 받는 사람
	// 휴대폰 번호 1,2,3
	// 주소

	// 결제방법
	// 카드 선택
	// 할부 기간

}
