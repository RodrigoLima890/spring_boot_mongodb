package com.spring.mongodb.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentsDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String msg;
	private Date date;
	private AuthorDto author;
	
	public CommentsDto() {
	}
	public CommentsDto(String msg, Date date, AuthorDto author) {
		super();
		this.msg = msg;
		this.date = date;
		this.author = author;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public AuthorDto getAuthor() {
		return author;
	}
	public void setAuthor(AuthorDto author) {
		this.author = author;
	}
	
	
	

}
