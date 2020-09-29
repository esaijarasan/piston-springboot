package com.piston.ukiproject.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Feedback {
	@Id
	private String id;
	private Date date;
	private Double agentRating;
	private Double appRating;
	private String comment;
	private String userId;
	private String phoneNumber;
	
	public Feedback(String id, Double agentRating, Double appRating, String comment, String userId,
			String phoneNumber, Date date) {
		super();
		this.id = id;
		this.agentRating = agentRating;
		this.appRating = appRating;
		this.comment = comment;
		this.userId = userId;
		this.phoneNumber = phoneNumber;
		this.date = date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getAgentRating() {
		return agentRating;
	}
	public void setAgentRating(Double agentRating) {
		this.agentRating = agentRating;
	}
	public Double getAppRating() {
		return appRating;
	}
	public void setAppRating(Double appRating) {
		this.appRating = appRating;
	}
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Feedback [id=" + id + ", agentRating=" + agentRating + ", appRating=" + appRating + ", comment="
				+ comment + ", userId=" + userId + ", phoneNumber=" + phoneNumber + "]";
	}
}
