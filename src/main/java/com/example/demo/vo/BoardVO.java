package com.example.demo.vo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
@Table(name = "board")
public class BoardVO {
	System.out.println("에에엑");
	@Id
	private int boardno;
	private int userno;
	private String b_title;
	private String b_content;
	private Date b_date;
	private int b_hit;
	
	@Transient	//테이블 매핑에서는 제외
	private String nickname;
	
	@Transient	//테이블 매핑에서는 제외
	private String fname;

	
}
