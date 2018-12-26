package com.domain;

import java.sql.Date;

public class Member {

	// �ʵ� ����
	// ->���, �Է¿� �����ϴ� ��� �׸�
	// ->ȸ�����̵�, �̸�, ��ȭ��ȣ, �̸���, �����
	// ->���� �ڷ�, ���� �ĺ���
	private String mid_, name_, phone, email;
	private Date regDate;
	
	//�⺻ ������ �ʿ� -> �ڵ� ����
	
	// getter, setter
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	// toString()
	@Override
	public String toString() {
		return String.format("%s / %s / %s / %s / %tF"
					, this.getMid_(), this.getName_()
					, this.getPhone(), this.getEmail()
					, this.getRegDate());
	}

}
