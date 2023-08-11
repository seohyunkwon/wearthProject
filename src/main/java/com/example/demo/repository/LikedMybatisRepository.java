package com.example.demo.repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.ShopDBManager;
import com.example.demo.vo.LikedVO;

@Repository
public class LikedMybatisRepository {
	//상품 좋아요 추가
	public static int insertGoodsLiked(HashMap<String, Object> map) {
		return ShopDBManager.insertGoodsLiked(map);
	}
	//상품 좋아요 취소
	public static int deleteGoodsLiked(HashMap<String, Object> map) {
		return ShopDBManager.deleteGoodsLiked(map);
	}
	//회원별 좋아요 목록 조회
	public static List<LikedVO> findLikedGoodsByUserNo(int userNo){
		return ShopDBManager.findLikedGoodsByUserNo(userNo);
	}
}
