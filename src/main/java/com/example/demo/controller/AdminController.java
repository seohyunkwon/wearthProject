package com.example.demo.controller;

import com.example.demo.service.AdminService;
import com.example.demo.vo.UsersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
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
    @GetMapping("/adminUserList")
    public String adminUserList(Model model){
        System.out.println("adminUserList의 컨트롤러 작동");

        List<UsersVO> List = adminService.getTotalUserList();
        
        System.out.println("USERLIST 출력 : " + List);
        model.addAttribute("userList", List);
        return "admin/User/UserList";
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
