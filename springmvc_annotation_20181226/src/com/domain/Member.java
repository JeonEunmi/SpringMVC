package com.domain;

public class Member {

	//�ʵ� ����
	//���� �ڷ�, ���� �ĺ���
	//�����ͺ��̽� �Է�, ��¿� �����ϴ� ��� �׸��� ����� ����
	private String mid_, name_, phone;

	//����) �Ű����� �����ڴ� ������� �ʴ´�.
	public Member() {
		
	}

	//getter, setter �ʿ� 
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
