package com.example.demo.db;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.example.demo.vo.CartVO;
import com.example.demo.vo.DetailCartVO;
import com.example.demo.vo.GoodsCategoryVO;
import com.example.demo.vo.GoodsVO;
import com.example.demo.vo.LikedVO;

public class ShopDBManager extends DBManager{

	//goods
		public static List<GoodsVO> findGoods(HashMap<Object, Object> map){
			SqlSession session = sqlSessionFactory.openSession();
			List<GoodsVO> list = session.selectList("goods.findGoods",map);
			session.close();
			return list;
		}
		//카테고리번호별 상품조회
		public static List<GoodsVO> findByCategoryNo(HashMap<Object, Object> map){
			SqlSession session = sqlSessionFactory.openSession();
			List<GoodsVO> list = session.selectList("goods.findByCategoryNo", map);
			session.close();
			return list;
		}
		//상품상세조회
		public static GoodsVO detailGoods(int goodsNo) {
			SqlSession session = sqlSessionFactory.openSession();
			GoodsVO g = session.selectOne("goods.detailGoods", goodsNo);
			session.close();
			return g;
		}
		//category 조회
		public static List<GoodsCategoryVO> findCategory(){
			SqlSession session = sqlSessionFactory.openSession();
			List<GoodsCategoryVO> list = session.selectList("category.findCategory");
			session.close();
			return list;
		}
		
		//전체 레코드수 조회
		public static int getTotalRecord(Integer categoryNo) {
			int re = -1;
			SqlSession session = sqlSessionFactory.openSession();
			re = session.selectOne("goods.getTotalRecord", categoryNo);
			session.close();
			return re;
		}
		
		//좋아유 버튼 클릭 시 1증가
		public static int insertGoodsLiked(HashMap<String, Object> map) {
			int re = -1;
			SqlSession session = sqlSessionFactory.openSession(true);
			re = session.insert("liked.insertGoodsLiked",map);
			session.close();
			return re;
		}
		
		//좋아요 삭제
		public static int deleteGoodsLiked(HashMap<String, Object> map) {
			int re = -1;
			SqlSession session = sqlSessionFactory.openSession(true);
			re = session.delete("liked.deleteGoodsLiked", map);
			session.close();
			return re;
		}
		
		//회원별 좋아요한 상품 목록 조회
		public static List<LikedVO> findLikedGoodsByUserNo(int userNo){
			SqlSession session = sqlSessionFactory.openSession();
			List<LikedVO> list = session.selectList("liked.findLikedGoodsByUserNo", userNo);
			session.close();
			return list;
		}
		
		//장바구니 추가
		public static int insertCart(HashMap<String, Object> map) {
			int re = -1;
			SqlSession session = sqlSessionFactory.openSession(true);
			re= session.insert("cart.insertCart", map);
			session.close();
			return re;
		}
		
		//유저별 장바구니 조회
		public static List<DetailCartVO> findCartByUserNo(int userNo) {
			SqlSession session = sqlSessionFactory.openSession();
			List<DetailCartVO> list = session.selectList("cart.findCartByUserNo", userNo);
			System.out.println("장바구니 목록!!!!!!!!!!!"+list);
			
			session.close();
			return list;
		}
		
		//장바구니-선택한 품목 삭제
		public static int deleteCartByGoodsNo(HashMap<String, Object> map) {
			int re = -1;
			SqlSession session = sqlSessionFactory.openSession(true);
			re = session.delete("cart.deleteCartByGoodsNo", map);
			session.close();
			return re;
		}
		
		//장바구니 품절상품 삭제
		public static int deleteCartByGoodsStock(int userNo) {
			int re =-1;
			SqlSession session=sqlSessionFactory.openSession(true);
			re = session.delete("cart.deleteCartByGoodsStock", userNo);
			session.close();
			return re;
		}
		
		//장바구니 수량 업데이트
		public static int updateCartCnt(HashMap<String, Object> map) {
			int re = -1;
			SqlSession session = sqlSessionFactory.openSession(true);
			re = session.update("cart.updateCartCnt",map);
			session.close();
			return re;
		}
		

}
