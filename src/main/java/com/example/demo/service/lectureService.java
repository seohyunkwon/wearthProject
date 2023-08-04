package com.example.demo.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.EducationJpaRepository;
import com.example.demo.repository.EducationMyBatisRepository;
import com.example.demo.repository.LectureJpaRepository;
import com.example.demo.repository.LectureMyBatisRepository;
import com.example.demo.vo.EducationVO;
import com.example.demo.vo.LectureVO;

import lombok.Setter;

@Service
@Setter
public class lectureService {

	@Autowired
	private LectureJpaRepository dao_JPA;
	
	@Autowired
	private LectureMyBatisRepository dao_MB;

	//MB (조회)
	public List<LectureVO> findAllLecture(){
		return dao_MB.findAllLecture();
	}
	
	public LectureVO findByNoLecture(int lecNO) {
		return dao_MB.findByNoLecture(lecNO);
	}
	
	public int insertLecture(LectureVO l) {
		return dao_MB.insertLecture(l);
	}
	
	//JPA (수정, 삭제)
	
	public void updateLecture(LectureVO l) {
		dao_JPA.save(l);
	}
	
	public void deleteLecture(int lecNO) {
		dao_JPA.deleteById(lecNO);
	}
}
