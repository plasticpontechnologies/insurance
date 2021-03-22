package com.insurance.in.Insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.in.Insurance.dao.ClientDao;
import com.insurance.in.Insurance.model.BuyPolicy;

@Service
public class ClientService {

	@Autowired
	private ClientDao clientDao;
	
	public int buyPolicy(BuyPolicy buyPolicy) {
		int savedRowCount = clientDao.buyPolicy(buyPolicy);
		return savedRowCount;
	}
}
