package com.example.demo.vo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "trainingRequest")
public class TrainingRequestVO {
	
	@Id
	private int reqNo;
	private String reqTitle;
	
//	@ManyToOne
//	@JoinColumn(name = "id", insertable = true, updatable = true)
//	private UsersVO users;
	
	private String reqContent;
	private String reqStatus;
	private String reqApp;
	private String reqAddr;
	private String reqDate;
	private String reqCompany;
	private String reqPhone;
	private Date reqSysDate;
	private int userNo;
	public int getReqNo() {
		return reqNo;
	}
	public void setReqNo(int reqNo) {
		this.reqNo = reqNo;
	}
	public String getReqTitle() {
		return reqTitle;
	}
	public void setReqTitle(String reqTitle) {
		this.reqTitle = reqTitle;
	}
	public String getReqContent() {
		return reqContent;
	}
	public void setReqContent(String reqContent) {
		this.reqContent = reqContent;
	}
	public String getReqStatus() {
		return reqStatus;
	}
	public void setReqStatus(String reqStatus) {
		this.reqStatus = reqStatus;
	}
	public String getReqApp() {
		return reqApp;
	}
	public void setReqApp(String reqApp) {
		this.reqApp = reqApp;
	}
	public String getReqAddr() {
		return reqAddr;
	}
	public void setReqAddr(String reqAddr) {
		this.reqAddr = reqAddr;
	}
	public String getReqDate() {
		return reqDate;
	}
	public void setReqDate(String reqDate) {
		this.reqDate = reqDate;
	}
	public String getReqCompany() {
		return reqCompany;
	}
	public void setReqCompany(String reqCompany) {
		this.reqCompany = reqCompany;
	}
	public String getReqPhone() {
		return reqPhone;
	}
	public void setReqPhone(String reqPhone) {
		this.reqPhone = reqPhone;
	}
	public Date getReqSysDate() {
		return reqSysDate;
	}
	public void setReqSysDate(Date reqSysDate) {
		this.reqSysDate = reqSysDate;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	
	
}
