package com.domain;

public class Member {

	//동일 자료, 동일 식별자
	//주의) 변수명이 전송 자료의 식별자와 일치해야 한다
	private String name;
	private int age;
	
	//기본생성자 + setter 필요
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
