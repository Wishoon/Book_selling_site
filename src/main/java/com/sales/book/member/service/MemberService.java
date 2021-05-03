package com.sales.book.member.service;

import java.util.Map;

import com.sales.book.member.vo.MemberVO;


public interface MemberService {

	//회원가입
	public void addMember(MemberVO memberVO) throws Exception;
	
	//id 중복 확인
	public String overlapped(String id) throws Exception;
	
	//로그인
	public MemberVO login(Map<String, String> loginMap) throws Exception;
	

	//로그아웃
}
