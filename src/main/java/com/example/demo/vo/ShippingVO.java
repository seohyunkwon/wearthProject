package com.example.demo.vo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "shipping")
public class ShippingVO {
	
	@Id
	private int shippingNo;
	private int ordersNo;
	private int userNo;
	private String shippingStatus;
	private Date startDate;
	private Date finishDate;
	private int trackingNo;
	public int getShippingNo() {
		return shippingNo;
	}
	public void setShippingNo(int shippingNo) {
		this.shippingNo = shippingNo;
	}
	public int getOrdersNo() {
		return ordersNo;
	}
	public void setOrdersNo(int ordersNo) {
		this.ordersNo = ordersNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getShippingStatus() {
		return shippingStatus;
	}
	public void setShippingStatus(String shippingStatus) {
		this.shippingStatus = shippingStatus;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	public int getTrackingNo() {
		return trackingNo;
	}
	public void setTrackingNo(int trackingNo) {
		this.trackingNo = trackingNo;
	}
	
	
}
