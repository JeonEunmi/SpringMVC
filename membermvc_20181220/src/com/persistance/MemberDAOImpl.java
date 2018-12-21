package com.persistance;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.domain.Member;
import com.mapper.MemberMapper;

//������ �����̳ʿ� ��ü�� ����ϴ� ������̼� ����
//->�������� ������ ���� �ĺ��� �߰� �ʿ�
@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {

	//Spring JDBC���� �����ϴ� ���� ���� ���� ��ü�� ���� ��������
	//->�̸�����(byName) ���� ���� ����
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplateObject;

	//ȸ�� ���� �Է� �޼ҵ�
	public int memberAdd(Member m) {
		int result = 0;
		
		String sql = "INSERT INTO members (mid_, name_, phone, email, regDate)\r\n" + 
				"	VALUES ((SELECT CONCAT('M', LPAD(IFNULL(SUBSTR(MAX(mid_), 2), 0) + 1, 2, 0)) AS newId FROM members m)\r\n" + 
				"	, ?, ?, ?, NOW())";
		
		result = this.jdbcTemplateObject.update(sql
				, m.getName_(), m.getPhone(), m.getEmail());
		
		return result;
	}
	
	//ȸ�� ���� ��� �޼ҵ�
	public List<Member> memberList() {
		List<Member> result = new ArrayList<Member>();

		String sql = "SELECT mid_, name_, phone, email, regDate\r\n" + 
				"	FROM members\r\n" + 
				"	ORDER BY mid_";
		
		result = this.jdbcTemplateObject.query(sql, new MemberMapper());

		return result;
	}
	
	//��ü ī��Ʈ �޼ҵ�
	public int totalcount() {
		int result = 0;
		
		String sql = "SELECT COUNT(*) totalcount FROM members";
		result = this.jdbcTemplateObject.queryForObject(sql
						, Integer.class);
		
		return result;
	}
	
	//ȸ�� ���� ���� �޼ҵ�
	

	//ȸ�� ���� ���� �޼ҵ�
	

	
}
