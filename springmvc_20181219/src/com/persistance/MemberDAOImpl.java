package com.persistance;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.domain.Member;
import com.mapper.MemberRowMapper;

//Spring MVC���� ����� ���� �õ��� @Repository ������̼� ����
@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {
	
	//JdbcTemplate ��ü�� ���� �������� ����
	//->������̼� ǥ��
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
