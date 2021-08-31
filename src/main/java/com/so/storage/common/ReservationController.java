package com.so.storage.common;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import member.MemberVO;
import reservation.ReserServiceImpl;
import reservation.ReserVO;

@Controller
public class ReservationController {
	
	@Autowired
	private ReserServiceImpl service;

//	@RequestMapping ("/list.rv")
//	public String list(HttpSession session, Model model) {
//		session.setAttribute("category", "rv");
//		return "reservation/reservation";
//	}
	
	//Product_code 구분 
	@ResponseBody
	@RequestMapping("/and_reser_productCode")
	public void reser_productCode(String product_code, String product_type,String product_id, HttpServletResponse res) throws Exception {

		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("product_id", product_id); 
		map.put("product_type", product_type);
		
		List< ReserVO > list = service.reser_productCode(map);
		
		//System.out.println("dddd");
		common_gson(res, list);
		
		System.out.println(product_code + ", " + product_id+ ", " +product_type);
		
	}
	
	
	//예약추가
	@ResponseBody
	@RequestMapping("/and_reser_insert")
	public void join(HttpServletResponse res, String reser_product_code ,String reser_booking_member , String reser_booking_start ,String reser_booking_end) throws Exception {
		//MemberVO mVo = new MemberVO();
	
		
		ReserVO vo = new ReserVO(  reser_product_code, reser_booking_member ,reser_booking_start, reser_booking_end);
		
		service.reser_insert(vo);
		
		System.out.println(reser_product_code+ reser_booking_member +reser_booking_start+ reser_booking_end);
		//service.reser_list();
		
		common_gson(res, vo);
		
	}
	
	
	//안드로이드 관리자용 예약목록 확인
	@ResponseBody
	   @RequestMapping("/and_reservationList")
	   public void mg_reserList(HttpServletResponse res) throws Exception {
	      
	      List<ReserVO> list = service.mg_reser_list();
	      //System.out.println("dd");
	   
	      common_gson(res, list);
	   }
	
	
	@ResponseBody
    @RequestMapping("/and_user_reservationList")
    public void user_reserList(HttpServletResponse res, String id) throws Exception {

       List<ReserVO> list = service.user_reser_list(id);
       //ReserVO vo = new ReserVO();

       common_gson(res, list);
       //common_gson(res, vo);
       // System.out.println("bookingMember : "+id);
       // System.out.println("dd");
    }
	
	
	@ResponseBody
    
    @RequestMapping("/and_user_reservation_cancel") 
    public void user_reser_cancel(String id, String product_code, HttpServletResponse res) throws Exception {
    
    HashMap<String, String> map = new HashMap<String, String>(); 
    map.put("id",id); 
    map.put("product_code", product_code);
    
    ReserVO vo = new ReserVO();
    
    //vo.getProduct_code();
    
    service.user_reser_cancel(map);
    
    
    
    //System.out.println("dddd");
    common_gson(res, vo);
    
    }
	
	// 예약추가(Web)
	@ResponseBody
	   @RequestMapping("/reserv_step2.rv")
	   public String join(ReserVO vo) throws Exception {
	      
	      
	      
	      service.reser_insert(vo);
	      service.reser_using_update(vo);
	      service.reser_reserved_update(vo);
	      
	      
	      System.out.println("dd");
	      
	      return "reservation/reservationCheck";
	   }
	
	
	
	
	public void common_gson(HttpServletResponse res, List<ReserVO> vo) throws Exception {
		Gson gson = new Gson(); 
		String json = gson.toJson(vo);
		PrintWriter out;
		out = res.getWriter();
		out.println(json);
	}
	
	public void common_gson(HttpServletResponse res, ReserVO vo) throws Exception {
		Gson gson = new Gson(); 
		String json = gson.toJson(vo);
		PrintWriter out;
		out = res.getWriter();
		out.println(json);
	}
	
	
}
