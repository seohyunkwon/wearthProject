package com.example.demo.controller;

import java.util.HashMap;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.VolunteerService;

import lombok.Setter;

@Controller
@Setter
public class VolunteerController {
	
	@Autowired
	private VolunteerService vs;
	
	//페이징 처리를 위한 변수 추가
		public int pageSize = 10;
		public int totalRecord;
		public int totalPage;	

	//봉사하기 게시글 목록 + 페이징 처리
	@GetMapping(value = {"/volunteer/list", "/volunteer/list/{pageNum}"})
	public String volunteerList(Model model, @PathVariable(required = false) Integer pageNum) {
		System.out.println("process : VolunteerController-------------------------------------");
		
		totalRecord = vs.getTotalRecord();
		totalPage = (int)Math.ceil(totalRecord/(double)pageSize);
		if (pageNum == null) {
			pageNum = 1;
		}
		System.out.println("totalRecord:" + totalRecord);
		System.out.println("totalPage:"+totalPage);
		System.out.println("현재페이지:"+pageNum);
		int start = (pageNum-1)*pageSize+1;	//앞페이지번호*한페이지레코드 +1이 현재 페이지의 첫번째 게시글 번호
		int end = start+pageSize-1; //현재 페이지의 첫번째 게시글번호 + 페이지사이즈(8) -1하면 마지막 게시글 번호
		System.out.println("현재페이지 첫 게시글 번호:"+start);
		System.out.println("현재페이지 마지막 게시글 번호:"+end);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		
		model.addAttribute("list", vs.findAll(map));
		model.addAttribute("totalPage", totalPage);
		return "volunteer/list";
	}
	
	@GetMapping("/volunteer/detail/{volunteerno}")
	public ModelAndView volunteerDetail(@PathVariable("volunteerno") int volunteerno) {
		System.out.println("volunteer Detail: -----------------------------------------");
		System.out.println("봉사글번호: "+ volunteerno);
		ModelAndView mav = new ModelAndView("/volunteer/detail");
		mav.addObject("v", vs.findByVolunteerNo(volunteerno));
		return mav;
	}
	
	
	
}
