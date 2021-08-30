package com.so.storage.common;

//import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

//import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
//import com.google.gson.JsonArray;

import iot.IoTVO;
import manager.ProvisionVO;
import member.MemberServiceImpl;
import member.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberServiceImpl service;

	@ResponseBody
	@RequestMapping("/and_login")
	public void login(String id, String pw, HttpServletResponse res) throws Exception {

		System.out.println(id + ", " + pw);
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id); // 가져온 값 hashmap 에 담아줌
		map.put("pw", pw);
		
		MemberVO vo = service.member_login(map);
		
		common_gson(res, vo);
	}
	
	@ResponseBody
	@RequestMapping("/and_join")
	public void join(MemberVO vo, HttpServletResponse res) throws Exception {
		//vo = new MemberVO(id, pw, name, email, tel);
		//vo = new MemberVO(vo.getId(), vo.getPw(), vo.getName(), vo.getEmail(), vo.getTel());
		String id = vo.getId();
		String pw = vo.getPw();
		String name = vo.getName();
		String email = vo.getEmail();
		String tel = vo.getTel();
		vo = new MemberVO(id, pw, name, email, tel);
		service.member_join(vo);
		
		common_gson(res, vo);
	}
	
	@ResponseBody
	@RequestMapping("/and_leave")
	public void member_leave(String id, HttpServletResponse res) throws Exception {
		service.member_delete(id);
		
		MemberVO vo = new MemberVO();
		vo.getId();
		vo.getPw();
		vo.getName();
		vo.getEmail();
		vo.getTel();
		
		common_gson(res, vo);
	}
	
	@ResponseBody
	@RequestMapping("/and_pwchk")
	public void member_leave_pwchk(String pw, HttpServletResponse res) throws Exception {
		MemberVO vo = service.member_pw_check(pw);
		
		common_gson(res, vo);
	}	
	
	@ResponseBody
	@RequestMapping("/and_idChk")
	public boolean join_idChk(String id, HttpServletResponse res) throws Exception {
		
		return service.member_id_check(id);

// 아래 2줄 추가 주석 (08/03 18:45)		
//		 MemberVO vo = service.member_id_check(id);
//		
//		 common_gson(res, vo);
		 
	}
	
	@ResponseBody
	@RequestMapping("/and_accountUpdate")
	public void account_update(MemberVO vo, HttpServletResponse res) throws Exception {
		
		service.member_update(vo);
		
		common_gson(res, vo);
	}
	
	@ResponseBody
	@RequestMapping("/and_kakaojoin")
	public void kakaoLogin_insert(MemberVO vo, HttpServletResponse res) throws Exception {
		String id = vo.getId();
		String name = vo.getName();
		String kakao_login = vo.getKakao_login();
		vo = new MemberVO(id, name, kakao_login);
		service.kakaoLogin_join(vo);
		
		System.out.println(kakao_login);
		
		common_gson(res, vo);
	}
	
	@ResponseBody
	@RequestMapping("/and_memberList")
	public void mg_memberList(HttpServletResponse res) throws Exception {
		
		List<MemberVO> list = service.mg_member_list();
		
		common_gson(res, list);
	}
	
	
	
	@ResponseBody
	@RequestMapping("/and_provision_2")
	public void provisionSelect_2(String use_agreement, HttpServletResponse res) throws Exception {
		System.out.println(use_agreement);
		ProvisionVO vo = new ProvisionVO(); 
		vo = service.provision_select_2(use_agreement);
		common_gson(res, vo);
	}
	
	@ResponseBody
	@RequestMapping("/and_provision_1")
	public void provisionSelect_1(String person_information, HttpServletResponse res) throws Exception {
		System.out.println(person_information);
		ProvisionVO vo = new ProvisionVO();
		vo = service.provision_select_1(person_information);
		common_gson(res, vo);
	}
	
	@ResponseBody
	@RequestMapping("/and_proviAgree1")
	public void proviAgreeInsert_1(String id, HttpServletResponse res) throws Exception {
		service.provi_agree_insert1(id);
	}
	
	@ResponseBody
	@RequestMapping("/and_proviAgree2")
	public void proviAgreeInsert_2(String id, HttpServletResponse res) throws Exception {
		service.provi_agree_insert2(id);
	}
	
	@ResponseBody
	@RequestMapping("/and_iot")
	public void and_iot(String user_id, HttpServletResponse res) throws Exception {
		//IoTVO vo = new IoTVO();
		IoTVO vo = service.and_iot_select(user_id);
		
		int temperature = vo.getTemperature();
		int humidity = vo.getHumidity();
		String temhum_date = vo.getTemhum_date();
		vo = new IoTVO(temperature, humidity, temhum_date);
		
		//System.out.println(temhum_date);
		
		common_gson(res, vo);
	}
	
//	
//	// 마이페이지 화면 이동
//	@RequestMapping("/mypage.my")
//	public String mypage(HttpSession session, Model model) {
//		session.setAttribute("category", "my");
//		return "member/mypage";
//	}
//	
//	// 마이페이지 정보 수정 화면 이동
//	@RequestMapping("/myinfo.my")
//	public String myinfo_chk(HttpSession session) {
//		session.setAttribute("my_category", "myinfo");
//		return "member/myinfo";
//	}
//	
//	// 마이페이지 정보 수정
//	@RequestMapping("/myinfo_chk")
//	public String myinfo_chk(String password) {
//		
//		return "member/";
//	}
	
	public void common_gson(HttpServletResponse res, MemberVO vo) throws Exception {
		Gson gson = new Gson(); 
		String json = gson.toJson(vo);
		PrintWriter out;
		out = res.getWriter();
		out.println(json);
	}
	
	public void common_gson(HttpServletResponse res, List<MemberVO> vo) throws Exception {
		Gson gson = new Gson(); 
		String json = gson.toJson(vo);
		PrintWriter out;
		out = res.getWriter();
		out.println(json);
	}
	
	public void common_gson(HttpServletResponse res, ProvisionVO vo) throws Exception {
		Gson gson = new Gson(); 
		String json = gson.toJson(vo);
		PrintWriter out;
		out = res.getWriter();
		out.println(json);
	}
	
	public void common_gson(HttpServletResponse res, IoTVO vo) throws Exception {
		Gson gson = new Gson(); 
		String json = gson.toJson(vo);
		PrintWriter out;
		out = res.getWriter();
		out.println(json);
	}
}
