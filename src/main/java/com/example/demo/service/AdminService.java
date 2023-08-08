package com.example.demo.service;

import com.example.demo.repository.AdminMyBatisRepository;
import com.example.demo.vo.UsersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminMyBatisRepository repository;

    public List<UsersVO> getTotalUserList() {
        return repository.getTotalUserList();
    }

    public int deleteUser(int userno) {
        return repository.deleteUser(userno);
    }
}