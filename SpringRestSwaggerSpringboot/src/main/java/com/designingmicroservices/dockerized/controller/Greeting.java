package com.designingmicroservices.dockerized.controller;
public class Greeting {
	private Long id;
	private String content;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Greeting(Long id, String content) {
		super();
		this.id = id;
		this.content = content;
	}
	
}
