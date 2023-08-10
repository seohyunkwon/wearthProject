package com.example.demo.controller;

import java.net.http.HttpRequest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.OrdersMybatisRepository;
import com.example.demo.repository.PaymentMybatisRepository;
import com.example.demo.repository.ReviewMyBatisRepository;
import com.example.demo.repository.UserJpaRepository;
import com.example.demo.service.MyPageService;
import com.example.demo.vo.OpinionVO;
import com.example.demo.vo.OrdersDetailGoodsVO;
import com.example.demo.vo.OrdersDetailVO;
import com.example.demo.vo.OrdersVO;
import com.example.demo.vo.PaymentVO;
import com.example.demo.vo.UsersVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.Setter;

@Controller
@Setter
public class MypageController {

	@Autowired
	private MyPageService myPageService;

	@GetMapping("/mypage/shopping/list")
	public String shopping(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		UsersVO u = (UsersVO) session.getAttribute("u");
		if (u == null) {
			return "/userinfo/login";
		} else {
			int userno = u.getUserno();
			model.addAttribute("order_list", myPageService.findOrdersByUserNo(userno));
			return "/mypage/shopping/list";
		}
	}

	@GetMapping("/mypage/shopping/detail")
	public String detail_shopping(int ordersno, Model model) {
		List<OrdersDetailGoodsVO> list = myPageService.findOrdersDetailGoodsByOrdersNo(ordersno);
		OrdersVO order = myPageService.findOrderByOrdersNo(ordersno);
		PaymentVO payment = myPageService.findPaymentByOrdersNo(ordersno);
		model.addAttribute("ordersdetail_list", list);
		model.addAttribute("order", order);
		model.addAttribute("payment", payment);
		return "/mypage/shopping/detail";
	}

	@GetMapping("/mypage/act/list")
	public void act() {
	}

	@GetMapping("/mypage/edu/list")
	public void edu() {
	}

	@GetMapping("/mypage/edu/detail")
	public void detail_edu() {
	}

	@GetMapping("/mypage/update")
	public void updateForm() {
	}

	@PostMapping("/mypage/writeReview")
	@ResponseBody
	public int writeReview(int goodsno, String opinionName, String opinionContent, HttpSession session) {
		String id = ((UsersVO) session.getAttribute("u")).getNickname();
		OpinionVO o = new OpinionVO();
		o.setGoodsNo(goodsno);
		o.setOpinionName(opinionName);
		o.setOpinionContent(opinionContent);
		o.setID(id);
		int re = myPageService.insertReview(o);
		System.out.println("opinion : " + o);
		System.out.println("re : " + re);
		return re;

	}

	@PostMapping("/mypage/shopping/delete")
	public String deleteOrder(int ordersno) {
		if(myPageService.deleteOrder(ordersno)==1){
			return "redirect:/mypage/shopping/list";
		} else{
			return "redirect:/mypage/shopping/detail/ordersno"+ordersno;
		}
	}

}