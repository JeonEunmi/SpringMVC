package com.domain;

public class Search {

	//클라이언트가 보내는 자료에 대한 수신
	private String key, value;
	
	//기본생성자 필요 -> 자동 생성

	//getter, setter 필요
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
