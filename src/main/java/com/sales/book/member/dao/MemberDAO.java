package com.sales.book.member.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.sales.book.member.vo.MemberVO;

@Repository
public class MemberDAO {

	private static String namespace = "com.sales.book.mybatis.mapper.member";
			
	@Autowired
	private SqlSession sqlSession;
	
	//회원가입
	public void insertNewMemeber(MemberVO memberVO) throws DataAccessException{
		sqlSession.insert(namespace + ".insertNewMember", memberVO);
		sqlSession.insert(namespace + ".insertAddress", memberVO);
		sqlSession.insert(namespace + ".createCart", memberVO);
	}

	//id 중복 확인
	public String selectOverlappedID(String id) throws DataAccessException{
		String result = sqlSession.selectOne(namespace + ".overlappedID", id);
		return result;
	}
	
	//로그인
	public MemberVO login(Map<String, String> loginMap) throws DataAccessException{
		MemberVO member = sqlSession.selectOne(namespace + ".login", loginMap);
		return member;
	}
}
