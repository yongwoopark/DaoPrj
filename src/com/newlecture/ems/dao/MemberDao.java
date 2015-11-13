package com.newlecture.ems.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.ems.vo.Member;

public class MemberDao {
	
	public List<Member> getMembers() throws SQLException{
		return getMembers("");
	}
	
	public List<Member> getMembers(int page) throws SQLException{
		return null;
	}
	
	public List<Member> getMembers(String query) throws SQLException{
		
		String sql = "SELECT * FROM MEMBERS WHERE NAME LIKE '%"+query+"%'";
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";			
		Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		List<Member> list = new ArrayList<Member>();
		Member member = null;
		
		while(rs.next())	{
			member = new Member();
			
			member.setMid(rs.getString("mid"));
			member.setName(rs.getString("name"));
			member.setPwd(rs.getString("age"));
			
			list.add(member);
		}		
								
		rs.close();
		st.close();
		con.close();
		
		return list;
	}
}
