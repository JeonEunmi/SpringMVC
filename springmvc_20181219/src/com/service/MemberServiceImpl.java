package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.domain.Member;
import com.persistance.MemberDAO;

//Spring MVC에서 서비스 역할 맡도록 @Service 어노테이션 설정
@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	//MemberDAO 객체에 대한 의존주입 설정
	//->실제로는 MemberDAOImpl 객체가 의존주입된다.
	//->어노테이션 표기
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
