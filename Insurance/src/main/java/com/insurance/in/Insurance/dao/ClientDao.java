package com.insurance.in.Insurance.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.insurance.in.Insurance.model.BuyPolicy;
import com.insurance.in.Insurance.model.DocumentRequest;

@Repository
@Transactional
public class ClientDao extends JdbcDaoSupport{

	/*@Autowired
	JdbcTemplate jdbcTemplate;*/
	
	@Autowired
    public ClientDao(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
	
	public List<DocumentRequest> getAllDocumentData(){
		
		String sql = "select * from documentRequest";
		
		List<DocumentRequest> documentList = this.getJdbcTemplate().query(sql, 
				BeanPropertyRowMapper.newInstance(DocumentRequest.class));
		
		return documentList;
		
	}
	
	public int buyPolicy(BuyPolicy policy) {
		String sql = "insert into policies(firstName,lastName,email,password,phoneNumber,plan,city,country,dob,gender,jobType,policycategory,policytype,userId) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return this.getJdbcTemplate().update(sql, 
				new Object[] {policy.getFirstName(),policy.getLastName(),policy.getEmail(),policy.getPassword(),policy.getPhoneNumber(),
						policy.getPlan(),policy.getCity(),policy.getCountry(),policy.getDob(),policy.getGender(),policy.getJobType(),
						policy.getPolicycategory(),policy.getPolicytype(),policy.getUserId()
							
				});
	}
}
