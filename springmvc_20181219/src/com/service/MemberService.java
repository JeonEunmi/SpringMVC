package com.service;

import java.util.List;

import com.domain.Member;

public interface MemberService {
	
	//회원 정보 입력 메소드
	public int memberAdd(Member m);
	
	//회원 정보 출력 메소드
	public List<Member> memberList();	

}
