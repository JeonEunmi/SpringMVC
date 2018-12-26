package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.domain.Member;
import com.persistance.MemberDAO;

//스프링 컨테이너에 객체로 등록하는 어노테이션 설정
//->의존주입 설정을 위한 식별자 추가 필요
@Service("memberService")
public class MemberServiceImpl implements MemberService {

	//MemberDAO 객체에 대한 의존주입 설정
	//->약한 결합을 위해서 인터페이스 자료형 권장
	//->실제로는 MemberDAOImpl 객체가 전달된다.
	//->이름기준(byName) 의존 주입 설정
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
	public List<Member> memberList(String key, String value){
		List<Member> result = this.memberDAO.memberList(key, value);
		return result;
	}
	
	@Override
	public int totalcount() {
		int result = this.memberDAO.totalcount();
		return result;
	}
	
	@Override
	public int memberDelete(Member m) {
		int result = this.memberDAO.memberDelete(m);
		return result;
	}
	
	@Override
	public int memberUpdate(Member m) {
		int result = this.memberDAO.memberUpdate(m);
		return result;
	}
	

}
