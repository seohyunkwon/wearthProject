package com.example.demo.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.FilesJpaRepository;
import com.example.demo.repository.FilesMyBatisRepository;
import com.example.demo.vo.FilesVO;

@Service
public class FilesServiceImpl implements FilesService {

	@Autowired
	private FilesJpaRepository fJPA;
	
	@Autowired
	private FilesMyBatisRepository fMB;
	
	@Override
	public FilesVO findFile() {
		System.out.println("process: FilesSerivceImpl------------------");
		return fMB.findFile();
	}

	@Override
	public int getNextNo() {
		return fJPA.getNextNo();
	}

	@Override
	public void insertInBoard(FilesVO f) {
		fJPA.insertInBoard(f);
		
	}
	
	@Override
	public void insertInVolunteer(FilesVO f) {
		fJPA.insertInVolunteer(f);
		
	}

}
