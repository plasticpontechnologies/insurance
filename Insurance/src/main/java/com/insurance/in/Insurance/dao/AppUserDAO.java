package com.insurance.in.Insurance.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.insurance.in.Insurance.mapper.AppUserMapper;
import com.insurance.in.Insurance.model.AppUser;


@Repository
@Transactional
public class AppUserDAO extends JdbcDaoSupport{

	@Autowired
    public AppUserDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
	
	public AppUser findUserAccount(String userName) {
        // Select .. from App_User u Where u.User_Name = ?
        String sql = AppUserMapper.BASE_SQL + " where u.User_Name = ? ";
 
        Object[] params = new Object[] { userName };
        AppUserMapper mapper = new AppUserMapper();
        try {
            AppUser userInfo = this.getJdbcTemplate().queryForObject(sql, params, mapper);
            return userInfo;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
	
	public String findRoleByName(String name) {
		String sql = "select ar.role_name from app_role ar join user_role ur on ar.role_id = ur.ROLE_ID join app_user au on au.user_id = ur.USER_ID where au.USER_NAME= ? ";
		Object[] params = new Object[] { name };
		String roleName = this.getJdbcTemplate().queryForObject(sql, params, String.class);
		return roleName;
	}
}
