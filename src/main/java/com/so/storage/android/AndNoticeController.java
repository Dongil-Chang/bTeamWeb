package com.so.storage.android;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import notice.NoticeServiceImpl;
import notice.NoticeVO;

@Controller
public class AndNoticeController {
	@Autowired private NoticeServiceImpl service;
	
	@ResponseBody
	@RequestMapping("/and_noticeSelect")
	public void and_notice_select(HttpServletResponse res) throws Exception {
		List<NoticeVO> list = service.and_notice_list();
		
		common_gson(res, list);
		
	}
	
	
	public void common_gson(HttpServletResponse res, List<NoticeVO> vo) throws Exception {
		Gson gson = new Gson(); 
		String json = gson.toJson(vo);
		PrintWriter out;
		out = res.getWriter();
		out.println(json);
	}
	
	
	

}
