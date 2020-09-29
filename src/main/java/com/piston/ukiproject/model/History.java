package com.piston.ukiproject.model;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document  
public class History{
	@Id
	private String id;
	private String userId;
	private Date date;
	private Double price;
	private String serviceType;
	private String serviceStationName;
	private String status;
	
	public History(String id, String userId, Date date, Double price, String serviceType,
			String serviceStationName, String status) {
		super();
		this.id = id;
		this.userId = userId;
		this.date = date;
		this.price = price;
		this.serviceType = serviceType;
		this.serviceStationName = serviceStationName;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getServiceStationName() {
		return serviceStationName;
	}

	public void setServiceStationName(String serviceStationName) {
		this.serviceStationName = serviceStationName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "HistoryModel [id=" + id + ", userId=" + userId + ", date=" + date + ", price=" + price
				+ ", serviceType=" + serviceType + ", serviceStationName=" + serviceStationName + ", status=" + status
				+ "]";
	}
	
	

}
