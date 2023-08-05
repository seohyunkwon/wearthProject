package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repository.OrderJpaRepository;
import com.example.demo.repository.OrdersDetailJpaRepository;
import com.example.demo.repository.UserJpaRepository;
import com.example.demo.vo.OrdersDetailVO;
import com.example.demo.vo.UsersVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.Setter;

@Controller
@Setter
public class MypageController {
	
	@Autowired
	private OrderJpaRepository or;
	@Autowired
	private OrdersDetailJpaRepository odr;
	
	@GetMapping("/mypage/shopping/list")
	public String shopping(Model model, 
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		UsersVO u = (UsersVO)session.getAttribute("u");
		if(u==null) {
			return "/userinfo/login";
		} else {
			int userno = u.getUserno();
			model.addAttribute("order_list", or.findByUserNo(userno));
			System.out.println(or.findByUserNo(userno));
			return "/mypage/shopping/list";
		}
	}
	
	@GetMapping("/mypage/shopping/detail/ordersno")
	public String detail_shopping(@RequestParam(required = true) int ordersno, Model model) {
		List<OrdersDetailVO> list = odr.findByOrdersNo(ordersno);
		model.addAttribute("ordersdetail_list", list);
		return "/mypage/shopping/detail";
	}
	
	@GetMapping("/mypage/act/list")
	public void act() {}
	
	@GetMapping("/mypage/edu/list")
	public void edu() {}
	
	@GetMapping("/mypage/edu/detail")
	public void detail_edu() {}
	
	@GetMapping("/mypage/update")
	public void updateForm() {}
	
}
