package com.example.demo.controller;

import java.io.FileOutputStream;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.naming.SelfNaming;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.BoardService;
import com.example.demo.service.CommentsService;
import com.example.demo.service.FilesService;
import com.example.demo.vo.BoardVO;
import com.example.demo.vo.FilesVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.Setter;

@Controller
@Setter
public class Boardcontroller {
	
	@Autowired
	private BoardService bs;
	
	@Autowired
	private FilesService fs;
	
	@Autowired
	private CommentsService cs;
	
	//페이징 처리를 위한 변수 추가
	public int pageSize = 8;
	public int totalRecord;
	public int totalPage;
	
	//실천하기 게시글 목록 + 페이징 처리
	@GetMapping(value = {"/board/list", "/board/list/{pageNum}"})
	public String boardList(Model model, @PathVariable(required = false) Integer pageNum) {
		System.out.println("process : BoardController-------------------------------------");
		totalRecord = bs.getTotalRecord();
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
		
		model.addAttribute("list", bs.findAll(map));
		model.addAttribute("totalPage", totalPage);		//전체 페이지 수 만큼 페이징 버튼 띄우기 위해서
		
		return "board/list";
	}
	
	
	//실천하기 게시글 등록 - JPA
	@GetMapping("/board/insert")
	public String insert(Model model, HttpSession session) {
		System.out.println("boardInsert Controller---------------------------------");
		System.out.println((Object)(session.getAttribute("u")));
		model.addAttribute("boardno", bs.getNextNo());
		System.out.println("게시글 번호:"+bs.getNextNo());
		return "board/insert";
	}
	
	//실천하기 게시글 등록 완료 - JPA
	//사진 업로드 하지 않을 경우 default로 보여줄 값 설정해야함
	//file이 null 일 때 특정 이미지 불러오도록 설정할 예정
	@PostMapping("/board/insert")
	public ModelAndView insert(BoardVO b, FilesVO f, HttpServletRequest request) {
		System.out.println("insert POST Controller---------------------------------");		
		String path = request.getServletContext().getRealPath("/board");
		System.out.println("path:"+path);
		String fname = null;
		MultipartFile uploadFile = f.getUploadFile();
		fname = uploadFile.getOriginalFilename();
		System.out.println("fname: "+fname);
		//첨부파일이 있는 경우
		if(fname != null && !fname.equals("")) {
			try {
				FileOutputStream fos = new FileOutputStream(path+"/"+fname);				
				FileCopyUtils.copy(uploadFile.getBytes(), fos);
				fos.close();
				
				f.setFileno(fs.getNextNo());	//파일 번호 부여
				System.out.println("파일번호 : "+fs.getNextNo()); 		//여기까지 정상 작동
				f.setBoardno(b.getBoardno());	//input hidden으로 게시글 번호 담겨있음..
				System.out.println("f.getBoardno:"+f.getBoardno());
				f.setFname(fname);
				
				
				fs.insertInBoard(f);
				System.out.println("******************파일업로드 완료*******************");
			}catch (Exception e) {
				System.out.println("파일 업로드 예외발생:"+e.getMessage());
				
				
				
			}
		}else {
			fname = "";
		}
		bs.insert(b);
		ModelAndView mav = new ModelAndView("redirect:/board/list/1");	//게시글 작성 완료시 1페이지로 이동
		return mav;
	}
	
	//이미지 파일도 삭제되게끔 수정 필요함
	@GetMapping("/board/delete/{boardno}")
	public ModelAndView delete(@PathVariable("boardno") int boardno, HttpServletRequest request) {
		System.out.println("board delete 동작-----------------------------------------------");
		ModelAndView mav = new ModelAndView("redirect:/board/list/1");
		//이미지 파일이 있다면(해딩 boardno를 가지고 있는 파일이 있는지 select해야한다.)
		//fs.findByBoardno가 null이라면, null이 아니라면
		//String path = request.getServletContext().getRealPath("/images");
		/*
		 * String fname = bs.findById(no).getFname(); if(bs.deleteBoard(no, pwd) == 1) {
		 * if(fname != null && !fname.equals("")) { File file = new
		 * File(path+"/"+fname); file.delete(); } }
		 */
		bs.delete(boardno);
		System.out.println(boardno+"번 게시글 삭제 완료 ");
		return mav;
	}
	
}
