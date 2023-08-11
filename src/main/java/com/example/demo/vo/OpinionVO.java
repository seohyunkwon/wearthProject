package com.example.demo.vo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "opinion")
public class OpinionVO {
	
	@Id
	private int opinionNO;
	private int eduNo;
	private int goodsNo;
	private int userNo;
	private String ID;
	private String opinionName;
	private String opinionContent;
	private Date opinionDate;
	private boolean opinionSecret;
	private String opinionPwd;
	private String opinionStatus;
	private int opinionScore;
	private int answerNo;
	private String type;
	public int getOpinionNO() {
		return opinionNO;
	}
	public void setOpinionNO(int opinionNO) {
		this.opinionNO = opinionNO;
	}
	public int getEduNo() {
		return eduNo;
	}
	public void setEduNo(int eduNo) {
		this.eduNo = eduNo;
	}
	public int getGoodsNo() {
		return goodsNo;
	}
	public void setGoodsNo(int goodsNo) {
		this.goodsNo = goodsNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getOpinionName() {
		return opinionName;
	}
	public void setOpinionName(String opinionName) {
		this.opinionName = opinionName;
	}
	public String getOpinionContent() {
		return opinionContent;
	}
	public void setOpinionContent(String opinionContent) {
		this.opinionContent = opinionContent;
	}
	public Date getOpinionDate() {
		return opinionDate;
	}
	public void setOpinionDate(Date opinionDate) {
		this.opinionDate = opinionDate;
	}
	public boolean isOpinionSecret() {
		return opinionSecret;
	}
	public void setOpinionSecret(boolean opinionSecret) {
		this.opinionSecret = opinionSecret;
	}
	public String getOpinionPwd() {
		return opinionPwd;
	}
	public void setOpinionPwd(String opinionPwd) {
		this.opinionPwd = opinionPwd;
	}
	public String getOpinionStatus() {
		return opinionStatus;
	}
	public void setOpinionStatus(String opinionStatus) {
		this.opinionStatus = opinionStatus;
	}
	public int getOpinionScore() {
		return opinionScore;
	}
	public void setOpinionScore(int opinionScore) {
		this.opinionScore = opinionScore;
	}
	public int getAnswerNo() {
		return answerNo;
	}
	public void setAnswerNo(int answerNo) {
		this.answerNo = answerNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
