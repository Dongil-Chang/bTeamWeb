package com.so.storage.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import reservation.ReserServiceImpl;
import reservation.ReserVO;

@Controller
public class WebReservationController {
	
	@Autowired private ReserServiceImpl service;
	
	//예약 날짜, 형태, 사이즈 선택 이후 예약 가능 상품 목록 요청
	@RequestMapping("reserv_step1.rv")
	public String reserv_step1 (ReserVO vo, Model model) {
		
		model.addAttribute("list", service.reserv_list(vo));
		return "reservation/reservation2";
	}
	
	
	//예약하기 화면 요청 (로그인시)
	@RequestMapping ("/list.rv")
	public String list(HttpSession session, Model model) {
		session.setAttribute("category", "rv");
		return "reservation/reservationForm";
	}
	
	//예약안내 화면 요청 (비로그인시)
	@RequestMapping("/reserv_info.rv")
	public String reserv_info(HttpSession session) {
		session.setAttribute("category", "rv");
		return "reservation/reserv_info";
	}
}
