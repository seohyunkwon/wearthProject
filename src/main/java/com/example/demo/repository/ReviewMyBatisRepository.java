package com.example.demo.repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.db.ReviewDBManager;
import com.example.demo.db.SchoolDBManager;
import com.example.demo.vo.OpinionVO;

@Repository
public class ReviewMyBatisRepository {

	public int insertReview(OpinionVO o) {
		return ReviewDBManager.insertReview(o);
	}

}
