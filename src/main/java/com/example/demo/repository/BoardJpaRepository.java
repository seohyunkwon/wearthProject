package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.BoardVO;

import jakarta.transaction.Transactional;

@Repository
public interface BoardJpaRepository extends JpaRepository<BoardVO, Integer> {
	
	@Query("select nvl(max(boardno), 0)+1 from BoardVO")
	public int getNextNo();
	
	@Modifying
	@Query(value = "insert into Board b(b.boardno, b.userno, b.b_title, b.b_content, b.b_date, b.b_hit) values(:#{#b.boardno},:#{#b.userno},:#{#b.b_title},:#{#b.b_content},sysdate,0)", nativeQuery = true)
	@Transactional
	public void insert(BoardVO b);

}
