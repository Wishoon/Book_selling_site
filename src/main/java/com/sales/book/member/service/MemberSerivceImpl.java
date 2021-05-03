package com.sales.book.member.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.book.member.dao.MemberDAO;
import com.sales.book.member.vo.MemberVO;

@Service
public class MemberSerivceImpl implements MemberService{
	
	@Autowired
	MemberDAO memberDAO;
	
	//회원가입
	@Override
	public void addMember(MemberVO memberVO) throws Exception {
		memberDAO.insertNewMemeber(memberVO);
	}

	//id 중복 확인
	@Override
	public String overlapped(String id) throws Exception {
		
		return memberDAO.selectOverlappedID(id);
	}

	//로그인
	@Override
	public MemberVO login(Map<String, String> loginMap) throws Exception {
		return memberDAO.login(loginMap);
	}
	
	
	

}
