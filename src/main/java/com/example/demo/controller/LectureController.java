package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.lectureService;
import com.example.demo.vo.LectureVO;

@Controller
public class LectureController {
	
	@Autowired
	private lectureService ls;
	//LectureMyBatisRepository, LectureJpaRepository
	
	
	//list
	@GetMapping("/school/lecture/list")
	public void list(Model model) {
		model.addAttribute("list",ls.findAllLecture());
	}
	
	//insert
	@GetMapping("/school/lecture/insert")
	public void insert() {}
	@PostMapping("/school/lecture/insert")
	public String insert(LectureVO l) {
		return "redirect:/school/lecture/list";
	}
	
	//update
	@GetMapping("/school/lecture/update/{lecNO}")
	public String update(Model model, @PathVariable("lecNO")int lecNO) {
		model.addAttribute("l",ls.findByNoLecture(lecNO));
		return "/school/lecture/update";
	}
	@PostMapping("/school/lecture/update")
	public String update(LectureVO l) {
		ls.updateLecture(l);
		return "redirect:/school/lecture/list";
	}
	
	//detail
	@GetMapping("/school/lecture/detail/{lecNO}")
	public ModelAndView detail(@PathVariable("lecNO")int lecNO) {
		System.out.println("교육컨트롤러(detail) 글번호 : "+ lecNO);
		ModelAndView mav = new ModelAndView("/school/lecture/detail");
		mav.addObject("l",ls.findByNoLecture(lecNO));
		return mav;
	}
}
