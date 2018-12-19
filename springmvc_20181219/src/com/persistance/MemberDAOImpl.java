package com.persistance;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.domain.Member;
import com.mapper.MemberRowMapper;

//Spring MVC에서 저장소 역할 맡도록 @Repository 어노테이션 설정
@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {
	
	//JdbcTemplate 객체에 대한 의존주입 설정
	//->어노테이션 표기
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public int memberAdd(Member m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Member> memberList() {
		List<Member> result = new ArrayList<Member>();

		String sql = "SELECT mid_, name_, phone, email, regDate\r\n" + 
				"	FROM members\r\n" + 
				"	ORDER BY mid_";
		
		result = this.jdbcTemplateObject.query(sql, new MemberRowMapper());

		return result;
	}

}
