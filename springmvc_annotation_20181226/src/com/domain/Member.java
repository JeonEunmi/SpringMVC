package com.domain;

public class Member {

	//필드 구성
	//동일 자료, 동일 식별자
	//데이터베이스 입력, 출력에 관여하는 모든 항목을 멤버로 구성
	private String mid_, name_, phone;

	//주의) 매개변수 생성자는 사용하지 않는다.
	public Member() {
		
	}

	//getter, setter 필요 
	public String getMid_() {
		return mid_;
	}

	public void setMid_(String mid_) {
		this.mid_ = mid_;
	}

	public String getName_() {
		return name_;
	}

	public void setName_(String name_) {
		this.name_ = name_;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
