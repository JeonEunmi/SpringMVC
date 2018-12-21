package com.persistance;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.domain.Member;
import com.mapper.MemberMapper;

//스프링 컨테이너에 객체로 등록하는 어노테이션 설정
//->의존주입 설정을 위한 식별자 추가 필요
@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {

	//Spring JDBC에서 제공하는 쿼리 실행 전용 객체에 대한 의존주입
	//->이름기준(byName) 의존 주입 설정
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplateObject;

	//회원 정보 입력 메소드
	public int memberAdd(Member m) {
		int result = 0;
		
		String sql = "INSERT INTO members (mid_, name_, phone, email, regDate)\r\n" + 
				"	VALUES ((SELECT CONCAT('M', LPAD(IFNULL(SUBSTR(MAX(mid_), 2), 0) + 1, 2, 0)) AS newId FROM members m)\r\n" + 
				"	, ?, ?, ?, NOW())";
		
		result = this.jdbcTemplateObject.update(sql
				, m.getName_(), m.getPhone(), m.getEmail());
		
		return result;
	}
	
	//회원 정보 출력 메소드
	public List<Member> memberList() {
		List<Member> result = new ArrayList<Member>();

		String sql = "SELECT mid_, name_, phone, email, regDate\r\n" + 
				"	FROM members\r\n" + 
				"	ORDER BY mid_";
		
		result = this.jdbcTemplateObject.query(sql, new MemberMapper());

		return result;
	}
	
	//전체 카운트 메소드
	public int totalcount() {
		int result = 0;
		
		String sql = "SELECT COUNT(*) totalcount FROM members";
		result = this.jdbcTemplateObject.queryForObject(sql
						, Integer.class);
		
		return result;
	}
	
	//회원 정보 삭제 메소드
	

	//회원 정보 수정 메소드
	

	
}
