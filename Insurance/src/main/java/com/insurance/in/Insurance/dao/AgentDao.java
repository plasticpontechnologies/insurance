package com.insurance.in.Insurance.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.insurance.in.Insurance.model.DocumentRequest;
import com.insurance.in.Insurance.model.Policies;

@Repository
@Transactional
public class AgentDao extends JdbcDaoSupport {

	@Autowired
    public AgentDao(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
	
public List<Policies> getAllDocumentData(){
		
	
	
		String sql = "select * from policies";
		
		List<Policies> documentList = this.getJdbcTemplate().query(sql, 
				BeanPropertyRowMapper.newInstance(Policies.class));
		
		return documentList;
		
	}
}
