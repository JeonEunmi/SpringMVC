package com.persistance;

import java.util.List;

import com.domain.Member;

public interface MemberDAO {
	
	//ȸ�� ���� �Է� �޼ҵ�
	public int memberAdd(Member m);
	
	//ȸ�� ���� ��� �޼ҵ�
	public List<Member> memberList();

}
