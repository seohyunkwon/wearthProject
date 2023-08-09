package com.example.demo.db;

import org.apache.ibatis.session.SqlSession;

import com.example.demo.vo.OpinionVO;

public class ReviewDBManager extends DBManager {
	public static int insertReview(OpinionVO review) {
		int re = -1 ;
		System.out.println("reviewDBManager op : "+review);
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.insert("review.insertReview", review);
		session.close();
		return re;
	}
}
