package com.so.storage.android;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import manager.FaqVO;
import notice.NoticeServiceImpl;

@Controller
public class AndFaqController {
	@Autowired private NoticeServiceImpl service;
	
	@ResponseBody
	@RequestMapping("/and_faqSelect")
	public void and_faq_select(HttpServletResponse res) throws Exception {
		List<FaqVO> list = service.and_faq_list();
		
		common_gson(res, list);
	}
	
	public void common_gson(HttpServletResponse res, List<FaqVO> vo) throws Exception {
		Gson gson = new Gson(); 
		String json = gson.toJson(vo);
		PrintWriter out;
		out = res.getWriter();
		out.println(json);
	}
	
	
	

}
