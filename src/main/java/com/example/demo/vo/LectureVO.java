package com.example.demo.vo;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "lecture")
public class LectureVO {
	
	@Id
	private int lecNO;
	private String lecName;
	
	private String lecContent;
	private String lecStatus;
	private String lecDate;
	private String lecAddr;
	private String lecturer;
	private String lecApp;
	private String lecPhone;
	private int lecPrice;
	
	private String lecFile;
	private String lecDetailFile;
	private Date lecSysdate;
	
	private boolean liked;
	
	// 좋아요 상태 설정 세션유지를 위한 메소드
   public void setLiked(boolean liked) {
       this.liked = liked;
   }
	// lectureVO 클래스에 isLiked 메소드 추가
	public boolean isLiked(List<Integer> likedLecNOs) {
	    return likedLecNOs.contains(this.lecNO);
	}
	public int getLecNO() {
		return lecNO;
	}
	public void setLecNO(int lecNO) {
		this.lecNO = lecNO;
	}
	public String getLecName() {
		return lecName;
	}
	public void setLecName(String lecName) {
		this.lecName = lecName;
	}
	public String getLecContent() {
		return lecContent;
	}
	public void setLecContent(String lecContent) {
		this.lecContent = lecContent;
	}
	public String getLecStatus() {
		return lecStatus;
	}
	public void setLecStatus(String lecStatus) {
		this.lecStatus = lecStatus;
	}
	public String getLecDate() {
		return lecDate;
	}
	public void setLecDate(String lecDate) {
		this.lecDate = lecDate;
	}
	public String getLecAddr() {
		return lecAddr;
	}
	public void setLecAddr(String lecAddr) {
		this.lecAddr = lecAddr;
	}
	public String getLecturer() {
		return lecturer;
	}
	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}
	public String getLecApp() {
		return lecApp;
	}
	public void setLecApp(String lecApp) {
		this.lecApp = lecApp;
	}
	public String getLecPhone() {
		return lecPhone;
	}
	public void setLecPhone(String lecPhone) {
		this.lecPhone = lecPhone;
	}
	public int getLecPrice() {
		return lecPrice;
	}
	public void setLecPrice(int lecPrice) {
		this.lecPrice = lecPrice;
	}
	public String getLecFile() {
		return lecFile;
	}
	public void setLecFile(String lecFile) {
		this.lecFile = lecFile;
	}
	public String getLecDetailFile() {
		return lecDetailFile;
	}
	public void setLecDetailFile(String lecDetailFile) {
		this.lecDetailFile = lecDetailFile;
	}
	public Date getLecSysdate() {
		return lecSysdate;
	}
	public void setLecSysdate(Date lecSysdate) {
		this.lecSysdate = lecSysdate;
	}
	public boolean isLiked() {
		return liked;
	}
	
	
}
