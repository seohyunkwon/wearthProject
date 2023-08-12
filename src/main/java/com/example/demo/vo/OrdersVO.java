package com.example.demo.vo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "orders")
@ToString
public class OrdersVO {

	@Id
	private int ordersNo;
	private int userNo;
	private int addrNo;
	private int ordersPrice;
	private Date ordersDate;
	private String ordersStatus;
	private String ordersContent;
	private int ordersCnt;

	private int shipPrice;

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

	public int getAddrNo() {
		return addrNo;
	}

	public void setAddrNo(int addrNo) {
		this.addrNo = addrNo;
	}

	public int getOrdersPrice() {
		return ordersPrice;
	}

	public void setOrdersPrice(int ordersPrice) {
		this.ordersPrice = ordersPrice;
	}

	public Date getOrdersDate() {
		return ordersDate;
	}

	public void setOrdersDate(Date ordersDate) {
		this.ordersDate = ordersDate;
	}

	public String getOrdersStatus() {
		return ordersStatus;
	}

	public void setOrdersStatus(String ordersStatus) {
		this.ordersStatus = ordersStatus;
	}

	public String getOrdersContent() {
		return ordersContent;
	}

	public void setOrdersContent(String ordersContent) {
		this.ordersContent = ordersContent;
	}

	public int getOrdersCnt() {
		return ordersCnt;
	}

	public void setOrdersCnt(int ordersCnt) {
		this.ordersCnt = ordersCnt;
	}

	public int getShipPrice() {
		return shipPrice;
	}

	public void setShipPrice(int shipPrice) {
		this.shipPrice = shipPrice;
	}

	
}
