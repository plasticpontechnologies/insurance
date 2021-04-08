package com.insurance.in.Insurance.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.insurance.in.Insurance.model.User;

@Repository
public class UserRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	KeyHolder saveUserRoleKeyHolder = new GeneratedKeyHolder();
	KeyHolder keyHolderUserApp = new GeneratedKeyHolder();
	
	public int saveUser(User user) {
		return jdbcTemplate.update("insert into user (user_name,phone_number,email,password) values (?,?,?,?)",
				new  Object[] {
						user.getName(),user.getPhone(),user.getEmail(),user.getPassword()
				});
		// keyHolderUser.getKey().intValue();
	}
	

	
	/*public int saveUserAppDetails(User user) {
		return jdbcTemplate.update("insert into app_user (user_name,ENCRYTED_PASSWORD,ENABLED) values(?,?,?)",
				new Object[] {
						user.getName(),user.getPassword(),user.isEnabled()
				});
		//return keyHolderUserApp.getKey().intValue();
	}*/
	
	public Long saveUserAppDetails(final User user) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				 PreparedStatement statement = con.prepareStatement("insert into app_user (user_name,ENCRYTED_PASSWORD,ENABLED) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
				 statement.setString(1, user.getName());
				 statement.setString(2, user.getPassword());
				 statement.setBoolean(3, user.isEnabled());
				return statement;
			}
		}, keyHolderUserApp);
		
		Long returnValue = keyHolderUserApp.getKey().longValue();
		
		return  returnValue;
	}
	
	public Long saveUserRole(final int user_id,final int role_id) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement statement1 = con.prepareStatement("insert into user_role (user_id,role_id) values(?,?)", Statement.RETURN_GENERATED_KEYS);
				statement1.setInt(1, user_id);
				statement1.setInt(2, role_id);
				return statement1;
			}
		}, saveUserRoleKeyHolder);
		
		return saveUserRoleKeyHolder.getKey().longValue();
	}



	public List<String> getNames() {
		String sql="select user_name from user";
		List<String> user=jdbcTemplate.query(sql, new RowMapper<String>() {

			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				//User userData= new User();
				String name=rs.getString("user_name");
				/*
				 * userData.setPhone(rs.getString("phone_number"));
				 * userData.setEmail(rs.getString("email"));
				 * userData.setPassword(rs.getString("password"));
				 */
				return name;
			}
			
		});
		return user;
	}
	
}
