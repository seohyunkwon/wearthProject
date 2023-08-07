package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String admin1(){
        return "admin/Main";
    }


    //DashBoard
    @GetMapping("/adminDashBoard")
    public String adminDashBoard(){
        return "admin/DashBoard/DashBoard";
    }

    //*****************************USER***************************//
    // 회원관리, 운영자관리 페이지

    //UserList
    @GetMapping("/adminUserList")
    public String adminUserList(){
        return "admin/User/UserList";
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
