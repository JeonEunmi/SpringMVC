package com.service;

import java.util.List;

import com.domain.Member;

public interface MemberService {
	
	//ȸ�� ���� �Է� �޼ҵ�
	public int memberAdd(Member m);
	
	//ȸ�� ���� ��� �޼ҵ�
	public List<Member> memberList();	

}
