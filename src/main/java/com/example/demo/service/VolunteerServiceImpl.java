package com.example.demo.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.VolunteerJPARepository;
import com.example.demo.repository.VolunteerMyBatisRepository;
import com.example.demo.vo.VolunteerVO;

import lombok.Setter;

@Service
@Setter
public class VolunteerServiceImpl implements VolunteerService {

	@Autowired
	private VolunteerJPARepository vJPA;
	
	@Autowired
	private VolunteerMyBatisRepository vMB;
	
	@Override
	public List<VolunteerVO> findAll(HashMap<String, Object> map) {
		System.out.println("process : VolunteerServiceImp--------------------------");
		return vMB.findAll(map);
	}
	
	@Override
	public int getTotalRecord() {
		return vMB.getTotalRecord();
	}
	
	//상세게시글
	@Override
	public VolunteerVO findByVolunteerNo(int volunteerno) {
		return vMB.findByVolunteerNo(volunteerno);
	}

}
