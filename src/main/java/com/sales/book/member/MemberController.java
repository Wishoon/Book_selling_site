package com.sales.book.member;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sales.book.member.service.MemberService;
import com.sales.book.member.vo.MemberVO;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@Autowired
	MemberVO memberVO;
	
	//회원 가입 페이지 이동
	@RequestMapping(value="/memberForm.do", method = RequestMethod.GET)
	public String memberForm(Model model) {
		
		return "/member/memberForm";
	}
	
	//로그인 페이지 이동
	@RequestMapping(value="/loginForm.do", method = RequestMethod.GET)
	public String loginForm(Model model) {
		
		return "/member/loginForm";
	}
	
	//회원 비밀번호 유효성 체크 (ajax)
	@RequestMapping(value="/effectiveness", method = RequestMethod.POST)
	public @ResponseBody boolean effectiveness(String pw) {
		
		boolean check = false;
		String pw_chk = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*?&`~'\"+=])[A-Za-z[0-9]$@$!%*?&`~'\"+=]{6,18}$";

		Pattern pattern_symbol = Pattern.compile(pw_chk); 
		Matcher matcher_symbol = pattern_symbol.matcher(pw);

		if(matcher_symbol.find()) { 
			check = true; 
		} 
		
		return check;
	}
	
	//회원 가입 전송
	@RequestMapping(value="/addMember.do", method = RequestMethod.POST)
	public ResponseEntity addMember(MemberVO memberVO, HttpServletResponse response, HttpServletRequest request) throws Exception{
		
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		String message = null;
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
		    memberService.addMember(memberVO);
		    message  = "<script>";
		    message +=" alert('회원 가입을 마쳤습니다. 로그인창으로 이동합니다.');";
		    message += " location.href='"+request.getContextPath()+"/member/loginForm.do';";
		    message += " </script>";
		    
		}catch(Exception e) {
			message  = "<script>";
		    message +=" alert('작업 중 오류가 발생했습니다. 다시 시도해 주세요');";
		    message += " location.href='"+request.getContextPath()+"/member/memberForm.do';";
		    message += " </script>";
			e.printStackTrace();
		}
		resEntity = new ResponseEntity(message, responseHeaders, HttpStatus.OK);
//		System.out.println(memberVO.toString());
		return resEntity;
	}
	
	@RequestMapping(value="/overlapped.do", method = RequestMethod.POST) 
	public ResponseEntity overlapped(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception{
		ResponseEntity resEntity = null;
		
		String result = memberService.overlapped(id);
//		System.out.println(result);
		resEntity = new ResponseEntity(result, HttpStatus.OK);
//		System.out.println(resEntity);
		return resEntity;
	}
	
	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public String login(@RequestParam Map<String, String> loginMap, HttpServletRequest request ,Model model) throws Exception {
		
		memberVO = memberService.login(loginMap);
		if(memberVO != null && memberVO.getMember_id() != null) {
			HttpSession session = request.getSession();
			session = request.getSession();
			session.setAttribute("isLogOn", true);
			session.setAttribute("memberInfo", memberVO);
			System.out.println(memberVO.toString());
		}else {
			return "/member/loginForm";
		}		
		return "redirect:/";
	}
	
	@RequestMapping(value="/logout.do", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		session.setAttribute("isLogOn", false);
		session.removeAttribute("memberInfo");
		
		return "redirect:/";
	}
	
}
