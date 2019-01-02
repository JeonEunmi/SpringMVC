package com.domain;

//자료형 클래스
public class Login {
	
	//아이디, 현재패스워드, 신규패스워드
	private String id_, pw_, newPw_;

	//주의) 매개변수 있는 생성자를 사용하지 않는다.

	public String getNewPw_() {
		return newPw_;
	}

	public void setNewPw_(String newPw_) {
		this.newPw_ = newPw_;
	}

	public String getId_() {
		return id_;
	}

	public void setId_(String id_) {
		this.id_ = id_;
	}

	public String getPw_() {
		return pw_;
	}

	public void setPw_(String pw_) {
		this.pw_ = pw_;
	}

}
