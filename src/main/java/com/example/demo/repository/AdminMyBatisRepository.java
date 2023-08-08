package com.example.demo.repository;

import com.example.demo.db.AdminDBManager;
import com.example.demo.db.SchoolDBManager;
import com.example.demo.vo.EducationVO;
import com.example.demo.vo.UsersVO;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Repository
public class AdminMyBatisRepository {

	public static int pageSize =12;
	public static int totalRecord;
	public static int totalPage;

	public List<UsersVO> getTotalUserList() {
		
		return AdminDBManager.getTotalUserList();
	}

	public int deleteUser(int userno){
		return AdminDBManager.deleteUser(userno);
	}
}
