package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.domain.Member;
import com.persistance.MemberDAO;

//Spring MVC���� ���� ���� �õ��� @Service ������̼� ����
@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	//MemberDAO ��ü�� ���� �������� ����
	//->�����δ� MemberDAOImpl ��ü�� �������Եȴ�.
	//->������̼� ǥ��
	@Resource(name="memberDAO")
	private MemberDAO memberDAO;
	
	@Override
	public int memberAdd(Member m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Member> memberList() {
		List<Member> result = this.memberDAO.memberList();
		return result;
	}

}
