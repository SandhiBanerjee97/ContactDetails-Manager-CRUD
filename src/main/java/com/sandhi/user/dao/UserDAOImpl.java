package com.sandhi.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.sandhi.user.model.User;

public class UserDAOImpl implements UserDAO 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public int save(User user) 
	{
		String sql="INSERT INTO users(name,email,phone) VALUES(?,?,?)";
		Object arr[]= {user.getName(),user.getEmail(),user.getPhone()};
		int noOfRows=jdbcTemplate.update(sql,arr);
		return noOfRows;
	}

	public int update(User user) 
	{
		String sql="UPDATE users SET name=?,email=?,phone=? WHERE id="+user.getId();
		Object arr[]={user.getName(),user.getEmail(),user.getPhone()};
		int noOfRows=jdbcTemplate.update(sql,arr);
		return noOfRows;
	}

	public User get(final Integer id) 
	{
		String sql="SELECT * FROM users WHERE id="+id;
		ResultSetExtractor<User> extractor=new ResultSetExtractor<User>() 
		{	
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next())
				{
					String name=rs.getString("name");
					String email=rs.getString("email");
					String phone=rs.getString("phone");
					
					return new User(id,name,email,phone);
				}
				return null;
			}
		};
		return jdbcTemplate.query(sql,extractor);
	}

	public int delete(Integer id) 
	{
		String sql="DELETE FROM users WHERE id="+id;
		return jdbcTemplate.update(sql);
	}

	public List<User> list() 
	{
		String sql ="SELECT * FROM users";
		RowMapper<User> rowMapper=new RowMapper<User>()
		{

			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Integer id=rs.getInt("id");
				String name=rs.getString("name");
				String email=rs.getString("email");
				String phone=rs.getString("phone");
				
				return new User(id,name,email,phone);
			}
			
		};
		return jdbcTemplate.query(sql,rowMapper);
	}

}
