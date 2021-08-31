package com.so.storage.iot;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import iot.IoTServiceImpl;
import iot.IoTVO;
import member.MemberVO;
import reservation.ReserVO;

@Controller
public class IoTController {
	
	@Autowired private IoTServiceImpl service;
	
	@RequestMapping("/arduSetIoT")
	public String insert_temhum_iot(HttpSession session, IoTVO vo, HttpServletRequest req, Model model) {
		System.out.println("온도 : " + req.getParameter("temp") + "℃");
		System.out.println("습도 : " + req.getParameter("hum") + "%");
		System.out.println("압력 : " + req.getParameter("b_press"));
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		
		map.put("id", ((MemberVO) session.getAttribute("loginInfo") ).getId() );
		map.put("booking_member", ((ReserVO) session.getAttribute("reservInfo") ).getBooking_member() );
		map.put("temp", req.getParameter("temp"));
		map.put("hum", req.getParameter("hum"));
		map.put("product_code", ((ReserVO) session.getAttribute("reservInfo") ).getProduct_code() );
		map.put("b_press", req.getParameter("b_press"));
		
//		model.addAttribute("vo", req.getParameter("temp"));
//		model.addAttribute("vo", req.getParameter("hum"));
		
		model.addAttribute("map", service.IoT_insert_TemHum(map));
		return "redirect:checkIoT";
	}
	
	@RequestMapping("/arduPress")
	public String insert_press_iot(IoTVO vo, HttpServletRequest req, Model model) {		
		System.out.println("압력 : " + req.getParameter("b_press"));
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", "hanul");
		map.put("product_code", "CS0001");
		map.put("b_press", req.getParameter("b_press"));
		
//		model.addAttribute("vo", req.getParameter("temp"));
//		model.addAttribute("vo", req.getParameter("hum"));
		
		model.addAttribute("map", service.IoT_insert_Press(map));
		return "redirect:checkIoT";
	}
	
//	@RequestMapping("/checkIoT")
//	public String IoT_list_TemHum(IoTVO vo, HttpServletRequest req, Model model) {
//		model.addAttribute("vo",service.IoT_list(id));
//		return "iot/temHumVal";
//	}
	
//	@RequestMapping("/storage.my")
//	public String IoT_list(Model model, HttpSession session, String id) {
//		model.addAttribute("vo",service.IoT_list(id));
//		return "mypage/myStorage";
//	}
	
}