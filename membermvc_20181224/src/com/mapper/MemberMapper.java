package com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.domain.Member;

public class MemberMapper implements RowMapper<Member> {

	@Override
	public Member mapRow(ResultSet rs, int count) throws SQLException {
		//데이터베이스에서 읽어온 결과를
		//미리 준비한 객체의 특정 변수와 연결
		Member m = new Member();
		m.setMid_(rs.getString("mid_"));
		m.setName_(rs.getString("name_"));
		m.setPhone(rs.getString("phone"));
		m.setEmail(rs.getString("email"));
		m.setRegDate(rs.getDate("regDate"));
		return m;
	}

}
