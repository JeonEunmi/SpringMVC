package com.service;

import java.util.List;

import com.domain.Member;

public interface MemberService {

	//ȸ�� ���� �Է� �޼ҵ�
	public int memberAdd(Member m);
	
	//ȸ�� ���� ��� �޼ҵ�
	public List<Member> memberList();
	
	//ȸ�� ���� �˻� �޼ҵ�
	public List<Member> memberList(String key, String value);

	//��ü ī��Ʈ �޼ҵ�
	public int totalcount();
	
	//ȸ�� ���� ���� �޼ҵ�
	public int memberDelete(Member m);
	
	//ȸ�� ���� ���� �޼ҵ�
	public int memberUpdate(Member m);
	
	
}
