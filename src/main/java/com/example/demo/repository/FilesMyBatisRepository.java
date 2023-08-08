package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.db.FilesDBManager;
import com.example.demo.vo.FilesVO;

@Repository
public class FilesMyBatisRepository {

	public FilesVO findFile() {
		return FilesDBManager.findFile();
	}	
	
}
