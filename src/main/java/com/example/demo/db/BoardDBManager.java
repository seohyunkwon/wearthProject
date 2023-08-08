package com.example.demo.db;


import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.example.demo.vo.BoardVO;


public class BoardDBManager extends DBManager{

	public static List<BoardVO> findAll(HashMap<String, Object> map){
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardVO> list = session.selectList("board.findAll", map);
		session.close();
		return list;
	}

	public static int getTotalRecord() {
		int totalRecord;
		SqlSession session = sqlSessionFactory.openSession();
		totalRecord = session.selectOne("board.getTotalRecord");
		return totalRecord;
	}
}