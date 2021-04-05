package com.insurance.in.Insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.in.Insurance.dao.AgentDao;
import com.insurance.in.Insurance.dao.ClientDao;
import com.insurance.in.Insurance.model.BuyPolicy;
import com.insurance.in.Insurance.model.DocumentRequest;
import com.insurance.in.Insurance.model.Policies;

@Service
public class AgentService {

	@Autowired
	private AgentDao agentDao;
	
	

	public  List<Policies> getAllDocumentData(){
		List<Policies> policies = agentDao.getAllDocumentData();
		return policies;
	}
}
