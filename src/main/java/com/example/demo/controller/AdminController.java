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
    //UserDashBoard
    @GetMapping("/adminUserDashBoard")
    public String adminUserDashBoard(){
        return "admin/User/User";
    }


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

    @GetMapping("/adminContainerU")
    public String admin4(){
        return "admin/Container/ContainerUserList";
    }

    //*****************************Act***************************//

    //Act

    //WearthSchool

    //Shopping

}
