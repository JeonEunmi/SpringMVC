package com.domain;

import java.util.List;

public class Members {
	
	private List<Member> members;

	//주의) 매개변수 생성자는 사용하지 않는다.

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

}
