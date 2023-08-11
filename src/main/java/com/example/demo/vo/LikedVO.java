package com.example.demo.vo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "liked")
public class LikedVO {

	@Id
	private int likedNo;
	private int userNo;
	private int boardNo;
	private int lecNO;
	private int goodsNo;
	private int eduNO;
	private Date likedDate;
	
	
}
