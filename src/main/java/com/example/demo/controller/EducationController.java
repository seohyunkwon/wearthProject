package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.repository.EducationMyBatisRepository;
import com.example.demo.service.EducationService;
import com.example.demo.vo.EducationVO;

import jakarta.servlet.http.HttpSession;
import lombok.Setter;

@Controller
@Setter
public class EducationController {
	
	@Autowired
	private EducationService es;
	//EducationMyBatisRepository, EducationJpaRepository
	
	
	// list
	@GetMapping(value={"/school/education/list/{category}/{search}/{pageNUM}", "/school/education/list/{pageNUM}"})
	public ModelAndView list( 
			@PathVariable(name = "category", required = false) String category, 
	        @PathVariable(name = "search", required = false) String search, 
	        @PathVariable("pageNUM") int pageNUM,
	        HttpSession session
			){
		
		System.out.println("search"+search);
		System.out.println("pageNum"+pageNUM);
		ModelAndView mav = new ModelAndView("/school/education/list");
		
	    int start = (pageNUM - 1) * EducationMyBatisRepository.pageSize + 1;
	    int end = start + EducationMyBatisRepository.pageSize - 1;
	    
	    String user = (String) session.getAttribute("u");
	    System.out.println("user"+ user);
	    
	    HashMap<String, Object> map = new HashMap<>();
	    map.put("category", category);
	    map.put("search", search);
	    map.put("start", start);
	    map.put("end", end);
	    
	    mav.addObject("list", es.findAllEducation(map));
	    mav.addObject("totalPage", EducationMyBatisRepository.totalPage);
	    return mav;
	}

	
	
	// insert에 파일올리기 추가하기
	@GetMapping("/school/education/insert")
	public void insert() {}
	@PostMapping("/school/education/insert")
	public String insert(EducationVO e) {
		return "redirect:/school/education/list";
	}
	
	// update에 파일올리기 추가하기
	@GetMapping("/school/education/update/{eduNO}")
	public String update(Model model, @PathVariable("eduNO")  int eduNO) {
		model.addAttribute("e",es.findByNoEducation(eduNO));
		return "/school/education/update";
	}
	@PostMapping("/school/education/update")
	public String update(EducationVO e) {
		es.updateEducation(e);
		return "redirect:/school/education/list";
	}
	
	//detail
	@GetMapping("/school/education/detail/{eduNO}")
	public ModelAndView detail(@PathVariable("eduNO") int eduNO) {
		System.out.println("교육컨트롤러(detail) 글번호 : "+ eduNO);
		ModelAndView mav = new ModelAndView("/school/education/detail");
			mav.addObject("e",es.findByNoEducation(eduNO));
		return mav;
	}
}
