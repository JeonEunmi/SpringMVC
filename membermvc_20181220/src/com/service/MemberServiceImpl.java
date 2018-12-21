package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.domain.Member;
import com.persistance.MemberDAO;

//������ �����̳ʿ� ��ü�� ����ϴ� ������̼� ����
//->�������� ������ ���� �ĺ��� �߰� �ʿ�
@Service("memberService")
public class MemberServiceImpl implements MemberService {

	//MemberDAO ��ü�� ���� �������� ����
	//->���� ������ ���ؼ� �������̽� �ڷ��� ����
	//->�����δ� MemberDAOImpl ��ü�� ���޵ȴ�.
	//->�̸�����(byName) ���� ���� ����
	
	@Resource(name="memberDAO")
	private MemberDAO memberDAO;
	
	@Override
	public int memberAdd(Member m) {
		int result = this.memberDAO.memberAdd(m);
		return result;
	}

	@Override
	public List<Member> memberList() {
		List<Member> result = this.memberDAO.memberList();
		return result;
	}
	
	@Override
	public int totalcount() {
		int result = this.memberDAO.totalcount();
		return result;
	}
	
	//ȸ�� ���� ���� �޼ҵ�
	
	//ȸ�� ���� ���� �޼ҵ�
	
	

}
