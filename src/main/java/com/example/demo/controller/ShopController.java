package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.repository.UserJpaRepository;
import com.example.demo.repository.UserMyBatisRepository;
import com.example.demo.service.GoodsService;
import com.example.demo.vo.GoodsVO;
import com.example.demo.vo.LikedVO;
import com.example.demo.vo.UsersVO;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ch.qos.logback.classic.Logger;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.Setter;

@Controller
@Setter
public class ShopController {

	@Autowired
	private GoodsService gs;


	// 전체상품 조회 및 카테고리별 상품 조회
	@GetMapping(value = { "/shop/shopMain/{categoryNo}", "/shop/shopMain/{categoryNo}/{value}", "/shop/shopMain",
			"/shop/shopMain/{value}","/shop/shopMain/{categoryNo}/{value}/{pageNum}"})
	public ModelAndView findGoods(@PathVariable(required = false) Integer categoryNo,@PathVariable(required = false) String value, @PathVariable(value ="pageNum" ,required = false) Integer pageNum,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/shop/shopMain");
		HttpSession session = (HttpSession) request.getSession();
		session.setAttribute("categoryNo", categoryNo);
		if(value==null ) {
			value="liked";
			session.setAttribute("value", value);
		}
		if(pageNum==null) {
			pageNum=1;
		}
		session.setAttribute("value", value);
		//페이징기능
		int totalRecord=gs.getTotalRecord(categoryNo);
		int pageSize=12;
		int totalPage = (int)Math.ceil(totalRecord/(double)pageSize);
		int start = (pageNum-1)*pageSize+1;
		int end = start+pageSize-1;
		mav.addObject("totalPage", totalPage);
		System.out.println("시작번호 : "+start);
		System.out.println("마지막번호 : "+end);
		if(totalRecord<end) {
			end = totalRecord;
		}
		
		//select 정렬기능
		if (categoryNo == 1 ) {
			HashMap<Object, Object> map = new HashMap<Object, Object>();
			map.put("categoryNo", categoryNo);
			map.put("value", value);
			map.put("start", start);
			map.put("end", end);
			mav.addObject("list", gs.findGoods(map));
			
		} else if (categoryNo != 1 ) {
			session.setAttribute("categoryNo", categoryNo);
			HashMap<Object, Object> map = new HashMap<Object, Object>();
			map.put("categoryNo", categoryNo);
			map.put("value", value);
			map.put("start", start);
			map.put("end", end);
			mav.addObject("list", gs.findByCategoryNo(map));
		}
		UsersVO user = (UsersVO)session.getAttribute("u");
		if(user!=null) {
		int userNo = user.getUserno();
		session.setAttribute("userNo", userNo);
		}
		return mav;
	}

	// 상품 상세조회
	@GetMapping("/shop/detail")
	public void detailGoods(@RequestParam Integer goodsNo, Model model) {
		model.addAttribute("g", gs.detailGoods(goodsNo));
	}


	// 결제페이지 조회
	@GetMapping("shop/order")
	public String order() {
		return "shop/order";
	}
	
	//좋아요 버튼 클릭 시 db 추가
	@PostMapping("/insertGoodsLiked")
	@ResponseBody
	public void insertGoodsLiked(HttpServletRequest request,Model model) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		int goodsNo = Integer.parseInt(request.getParameter("goodsNo"));
		map.put("userNo", userNo);
		map.put("goodsNo", goodsNo);
		model.addAttribute(gs.insertGoodsLiked(map));
	}
	
	//좋아요 취소
	@PostMapping("/deleteGoodsLiked")
	@ResponseBody
	public void deleteGoodsLiked(Model model, HttpServletRequest request) {
		HashMap< String, Object> map = new HashMap<String, Object>();
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		int goodsNo = Integer.parseInt(request.getParameter("goodsNo"));
		map.put("userNo", userNo);
		map.put("goodsNo", goodsNo);
		model.addAttribute(gs.deleteGoodsLiked(map));
	}
	
	//유저의 좋아요목록 조회
	@PostMapping("/findLikedGoodsByUserNo")
	@ResponseBody
	public List<LikedVO> findLikedGoodsByUserNo(HttpServletRequest request) {
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		List<LikedVO> list = gs.findLikedGoodsByUserNo(userNo);
		return list;
	}
	
	
	//장바구니 추가
	@RequestMapping("/insertCart")
	@ResponseBody
	public void insertCart(int cnt, int goodsNo,Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
	int cartCnt = Integer.parseInt(request.getParameter("cnt"));
	goodsNo = Integer.parseInt(request.getParameter("goodsNo"));
	int userNo = Integer.parseInt(request.getParameter("userNo")) ;

	
	HashMap<String, Object> map = new HashMap<String, Object>();
	map.put("cartCnt", cartCnt);
	map.put("goodsNo", goodsNo);
	map.put("userNo", userNo);
	System.out.println("맵!!!"+map);
	model.addAttribute(gs.insertCart(map));
	}
	
	//유저별 장바구니 조회
	@GetMapping("/shop/cart/{userNo}")
	public ModelAndView detailCart(@PathVariable int userNo) {
		ModelAndView mav = new ModelAndView("shop/cart");
		mav.addObject("cart",gs.findCartByUserNo(userNo));
		return mav;
	}
	//품절된 장바구니 품목 삭제
	@PostMapping("/deleteCartByGoodsStock")
	@ResponseBody
	public void deleteCartByGoodsStock(Model model, HttpServletRequest request) {
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		model.addAttribute(gs.deleteCartByGoodsStock(userNo));
		System.out.println("품절 삭제 : "+userNo);
		
	}
	
	//선택한 장바구니 품목 삭제
	@PostMapping("/deleteCartByGoodsNo")
	@ResponseBody
	public void deleteCartByGoodsNo(HttpServletRequest request, Model model) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int goodsNo = Integer.parseInt(request.getParameter("goodsNo"));
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		map.put("goodsNo", goodsNo);
		map.put("userNo", userNo);
		model.addAttribute(gs.deleteCartByGoodsNo(map));
		}
	
	
	
	//장바구니 수량변경
	@PostMapping("/updateCartCnt")
	@ResponseBody
	public void updateCartCnt(HttpServletRequest request, Model model) {
		System.out.println("수량변경 컨트롤러 동작함!");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userNo", Integer.parseInt(request.getParameter("userNo")));
		map.put("goodsNo", Integer.parseInt(request.getParameter("goodsNo")));
		map.put("cartCnt", Integer.parseInt(request.getParameter("cartCnt")));
		System.out.println("map:"+map);
		model.addAttribute(gs.updateCartCnt(map));
	}

}
