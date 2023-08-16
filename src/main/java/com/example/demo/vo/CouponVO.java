package com.example.demo.vo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Coupon")
public class CouponVO {

	@Id
	private int couponNo;
	private int userNo;
	private int couponCnt;
	private int couponDisCount;
	private String couponName;
	private String coupon_Info;
	private Date coupon_Date;
	private Date couponPeriod;
	public int getCouponNo() {
		return couponNo;
	}
	public void setCouponNo(int couponNo) {
		this.couponNo = couponNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getCouponCnt() {
		return couponCnt;
	}
	public void setCouponCnt(int couponCnt) {
		this.couponCnt = couponCnt;
	}
	public int getCouponDisCount() {
		return couponDisCount;
	}
	public void setCouponDisCount(int couponDisCount) {
		this.couponDisCount = couponDisCount;
	}
	public String getCouponName() {
		return couponName;
	}
	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
	public String getCoupon_Info() {
		return coupon_Info;
	}
	public void setCoupon_Info(String coupon_Info) {
		this.coupon_Info = coupon_Info;
	}
	public Date getCoupon_Date() {
		return coupon_Date;
	}
	public void setCoupon_Date(Date coupon_Date) {
		this.coupon_Date = coupon_Date;
	}
	public Date getCouponPeriod() {
		return couponPeriod;
	}
	public void setCouponPeriod(Date couponPeriod) {
		this.couponPeriod = couponPeriod;
	}
	
	
}
