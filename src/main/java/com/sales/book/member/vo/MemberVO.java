package com.sales.book.member.vo;

import org.springframework.stereotype.Component;

@Component
public class MemberVO {

	private String member_id;
	private String member_pw;
	private String member_name;
	private int cart_id;
	private String member_gender;
	private String member_birth_y;
	private String member_birth_m;
	private String member_birth_d;
	private String member_hp1;
	private String member_hp2;
	private String member_hp3;
	private String member_tel1;
	private String member_tel2;
	private String member_tel3;
	private String member_email1;
	private String member_email2;
	private String member_joinDate;
	private String post_code;
	private String parcel_address;
	private String street_address;
	private String detail_address;
	private String member_del_yn;
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pw() {
		return member_pw;
	}
	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public String getMember_gender() {
		return member_gender;
	}
	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}
	public String getMember_birth_y() {
		return member_birth_y;
	}
	public void setMember_birth_y(String member_birth_y) {
		this.member_birth_y = member_birth_y;
	}
	public String getMember_birth_m() {
		return member_birth_m;
	}
	public void setMember_birth_m(String member_birth_m) {
		this.member_birth_m = member_birth_m;
	}
	public String getMember_birth_d() {
		return member_birth_d;
	}
	public void setMember_birth_d(String member_birth_d) {
		this.member_birth_d = member_birth_d;
	}
	public String getMember_hp1() {
		return member_hp1;
	}
	public void setMember_hp1(String member_hp1) {
		this.member_hp1 = member_hp1;
	}
	public String getMember_hp2() {
		return member_hp2;
	}
	public void setMember_hp2(String member_hp2) {
		this.member_hp2 = member_hp2;
	}
	public String getMember_hp3() {
		return member_hp3;
	}
	public void setMember_hp3(String member_hp3) {
		this.member_hp3 = member_hp3;
	}
	public String getMember_tel1() {
		return member_tel1;
	}
	public void setMember_tel1(String member_tel1) {
		this.member_tel1 = member_tel1;
	}
	public String getMember_tel2() {
		return member_tel2;
	}
	public void setMember_tel2(String member_tel2) {
		this.member_tel2 = member_tel2;
	}
	public String getMember_tel3() {
		return member_tel3;
	}
	public void setMember_tel3(String member_tel3) {
		this.member_tel3 = member_tel3;
	}
	public String getMember_email1() {
		return member_email1;
	}
	public void setMember_email1(String member_email1) {
		this.member_email1 = member_email1;
	}
	public String getMember_email2() {
		return member_email2;
	}
	public void setMember_email2(String member_email2) {
		this.member_email2 = member_email2;
	}
	public String getMember_joinDate() {
		return member_joinDate;
	}
	public void setMember_joinDate(String member_joinDate) {
		this.member_joinDate = member_joinDate;
	}
	public String getPost_code() {
		return post_code;
	}
	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}
	public String getParcel_address() {
		return parcel_address;
	}
	public void setParcel_address(String parcel_address) {
		this.parcel_address = parcel_address;
	}
	public String getStreet_address() {
		return street_address;
	}
	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}
	public String getDetail_address() {
		return detail_address;
	}
	public void setDetail_address(String detail_address) {
		this.detail_address = detail_address;
	}
	public String getMember_del_yn() {
		return member_del_yn;
	}
	public void setMember_del_yn(String member_del_yn) {
		this.member_del_yn = member_del_yn;
	}
	
	@Override
	public String toString() {
		return "MemberVO [member_id=" + member_id + ", member_pw=" + member_pw + ", member_name=" + member_name
				+ ", cart_id=" + cart_id + ", member_gender=" + member_gender + ", member_birth_y=" + member_birth_y
				+ ", member_birth_m=" + member_birth_m + ", member_birth_d=" + member_birth_d + ", member_hp1="
				+ member_hp1 + ", member_hp2=" + member_hp2 + ", member_hp3=" + member_hp3 + ", member_tel1="
				+ member_tel1 + ", member_tel2=" + member_tel2 + ", member_tel3=" + member_tel3 + ", member_joinDate="
				+ member_joinDate + ", post_code=" + post_code + ", parcel_address=" + parcel_address
				+ ", street_address=" + street_address + ", detail_address=" + detail_address + ", member_del_yn="
				+ member_del_yn + "]";
	}
	

}
