package com.example.demo.controller;

import com.example.demo.repository.AdminMyBatisRepository;
import com.example.demo.service.AdminService;
import com.example.demo.vo.UsersVO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@Controller
@Setter
public class AdminController {


    @Autowired
    private AdminService adminService;

    @GetMapping("/admin")
    public String admin1(){
        return "admin/Main";
    }


    //DashBoard
    @GetMapping("/adminDashBoard")
    public String adminDashBoard(Model model){
        return "admin/DashBoard/DashBoard";
    }

    //*****************************USER***************************//
    // 회원관리, 운영자관리 페이지

    //UserList
    @GetMapping("/adminUserList/{pageNUM}")
    public String adminUserList(Model model, @PathVariable("pageNUM") int pageNUM,
                                @RequestParam(required = false) String name,
                                @RequestParam(required = false) String id,
                                @RequestParam(required = false) Integer age,
                                @RequestParam(required = false) String phoneNumber){

        int start = (pageNUM-1) * AdminMyBatisRepository.pageSize+1;
        int end = start + AdminMyBatisRepository.pageSize-1;

         //검색기능이 활성화돼서 RequestParam값이 넘어올때


        //이건 검색 기능 활성화 안되었을 때
        System.out.println("adminUserList의 컨트롤러 작동");

        HashMap<String, Object> map = new HashMap<>();
        map.put("start", start);
        map.put("end", end);


        model.addAttribute("totalUser", adminService.getTotalUser());
        model.addAttribute("userList", adminService.getTotalUserList(map));
        model.addAttribute("totalPage", AdminMyBatisRepository.totalPage); // 추가된 부분

        return "admin/User/UserList";
    }

    @PostMapping("/checkId")
    public String checkId(@PathVariable String userId){
        int result = adminService.checkId(userId);

        System.out.println("CheckId 중복확인 1이면 중복아이디 있음" + result);
        if(result == 1){
            return "success";
        }
        else return "error";

    }

    @PostMapping("/InsertId")
    public String InsertUser(){
        return "1";
    }


    @DeleteMapping("/deleteUser/{userno}")
    @ResponseBody
    public String deleteUser(@PathVariable int userno) {
        int result = adminService.deleteUser(userno);
        System.out.println("deleteUser : "+ userno + " "+result);
        if (result > 0) {  // 삭제된 행의 수가 0보다 큰 경우
            return "success";  // 성공적으로 사용자가 삭제되면 "success" 반환
        } else {
            return "error";  // 사용자 삭제에 실패하면 "error" 반환
        }
    }
    //02 검색기능 만들기 : 검색은 이름 나이 아이디 핸드폰번호 거주지
    @DeleteMapping("/deleteSelectedUser")
    @ResponseBody
    public String deleteSelectedUser(@RequestBody List<Integer> checkedUserIds) {
        try {
            // 선택된 사용자 ID로 회원 삭제 로직 구현
            for (int userno : checkedUserIds) {
                adminService.deleteUser(userno);
            }
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }

    //AdminList

    @GetMapping("/adminAdminList")
    public String adminAdminList(){
        return "admin/User/AdminList";
    }

    //*****************************Act***************************//

    //Act

    //*****************************School***************************//
    //강연관리, 교육관리, 문의게시판

    @GetMapping("/adminSchoolEducation")
    public String adminEducation(){
        return "admin/School/SchoolEducation";
    }

    @GetMapping("/adminSchoolLecture")
    public String adminLecture(){
        return "admin/School/SchoolLecture";
    }
    //Shopping

}
