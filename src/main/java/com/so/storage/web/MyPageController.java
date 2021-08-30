package com.so.storage.web;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import iot.IoTServiceImpl;
import member.MemberServiceImpl;
import member.MemberVO;
import reservation.ReserPage;
import reservation.ReserServiceImpl;

@Controller
public class MyPageController {
	@Autowired private MemberServiceImpl service;
	@Autowired private IoTServiceImpl iot_service;
	@Autowired private ReserServiceImpl r_service;
	@Autowired private ReserPage page;
	
	
	// 마이페이지 나의 창고 페이지 이동
	@RequestMapping("/storage.my")
	public String IoT_list(Model model, HttpSession session) {
		// 로그인 회원 id 전달
		String id = (((MemberVO)session.getAttribute("loginInfo")) .getId());
		
		model.addAttribute("vo", iot_service.IoT_list(id));
		return "mypage/myStorage";
	}
	
	
	// 마이페이지 예약 내역 조회
	@RequestMapping("/booking.my")
	public String my_bookingList(HttpSession session, Model model, 
				String search, String keyword,
			@RequestParam(defaultValue = "1") int curPage) {

		session.setAttribute("ma_category", "my");

		// 페이지 처리된 예약 목록 조회
		page.setCurPage(curPage);	// 페이지의 현재 페이지는 curPage

		// 예약 목록 검색을 위한 처리
		page.setSearch(search);
		page.setKeyword(keyword);
		
		// 회원명과 페이지 정보를 보내기 위한 HashMap
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("page", page);
		map.put("admin", ((MemberVO)session.getAttribute("loginInfo")) .getSubcode());
		map.put("userid", ((MemberVO)session.getAttribute("loginInfo")) .getId());

		// 나의 예약 목록 조회하여 화면에 출력
		model.addAttribute("page", r_service.my_reser_list(map));
//		model.addAttribute("uri", "booking.my");
		
		// 나의 예약 내역 session에 올림.
		session.setAttribute("reservInfo", "page");
		
		return "mypage/my_booking_list";
	}
	
	
	
	// 마이페이지 화면 이동
	@RequestMapping("/mypage.my")
	public String mypage(HttpSession session, Model model) {
		session.setAttribute("category", "my");
		return "mypage/mypages";
	}

	// 마이페이지 정보 수정 화면 전 비밀번호 확인 페이지 이동
	@RequestMapping("/myinfo.my")
	public String myinfo_chk(HttpSession session) {
		session.setAttribute("my_category", "myinfo");
		return "mypage/myinfo";
	}

	// 마이페이지 정보 수정 전 비밀번호 확인
		@RequestMapping("/myinfo_chk")
		public String myinfo_chk(String id, String pw) {
			
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("id", id);
			map.put("pw", pw);
			if( service.member_pw_check(map) !=null )
				return "redirect:modify.my";
			else 
				return "redirect:myinfo.my";
		}
		// 마이페이지 정보 화면
			@RequestMapping("/modify.my")
			public String myinfo_modify() {
				return "mypage/myinfo_modify";
			}
			// 마이페이지 정보 수정 처리
			@RequestMapping("/myinfo_modify")
			public String myinfo_modify(MemberVO vo, HttpSession session) {
				service.member_update(vo);
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("id", vo.getId());
				map.put("pw", vo.getPw());
				session.setAttribute("loginInfo", service.member_login(map));
				return "redirect:mypage.my";
			}
		
		//마이페이지 회원탈퇴 페이지 이동
		@RequestMapping("/leave.my")
		public String leave_my(HttpSession session) {
			session.setAttribute("my_category", "leave");
			return "mypage/leave";
		}
		
		// 마이페이지 회원탈퇴 전 비밀번호 확인
			@RequestMapping("/leave_chk")
			public String leave_my(String id, String pw) {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("id", id);
				map.put("pw", pw);
				if( service.member_pw_check(map) !=null )
					return "mypage/leave_bye";
				else 
					
					return "redirect:leave.my";
			}
		
		// 마이페이지 회원탈퇴
			@RequestMapping("/leave_bye")
			public String leave_bye(String id) {
				service.member_delete(id);
				return "redirect:/";
			}
	
}
