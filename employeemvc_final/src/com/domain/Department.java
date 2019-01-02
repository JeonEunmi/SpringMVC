package com.domain;

public class Department {

	private String deptId, dept_name;
	private int count_;

	//주의) 매개변수 있는 생성자를 사용하지 않는다.

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public int getCount_() {
		return count_;
	}

	public void setCount_(int count_) {
		this.count_ = count_;
	}


}