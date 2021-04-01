package com.insurance.in.Insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.in.Insurance.dao.AppUserDAO;
import com.insurance.in.Insurance.dao.ClientDao;
import com.insurance.in.Insurance.model.DocumentRequest;
import com.insurance.in.Insurance.model.User;
import com.insurance.in.Insurance.repository.UserRepository;
import com.insurance.in.Insurance.utils.EncrytedPasswordUtils;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ClientDao clientDao;
	
	@Autowired
	private AppUserDAO appUserDao;
	
	int savedUniqueId = 0;
	
	public int saveUser(User user) {
		int savedUser = userRepository.saveUser(user);
		//savedUniqueId = savedUser;
		updateUserApp(user,savedUser);
		return savedUser;
	}
	
	public Long updateUserApp(User user,int uniqueId) {
		Long appUniqueId =(long) 0;
		if(uniqueId >0) {
			String encodedPwd = getEncodedPassword(user.getPassword());
			user.setPassword(encodedPwd);
			user.setEnabled(true);
			 appUniqueId=userRepository.saveUserAppDetails(user);		
		}
		if(appUniqueId > 0) {
			Long uniqueUserId = updateUserRole(appUniqueId);
		}
		return appUniqueId;
	}
	
	public String getEncodedPassword(String pwd) {
		return EncrytedPasswordUtils.encrytePassword(pwd); 		
	}
	
	public Long updateUserRole(Long appUniqueId) {
		int longValue =  appUniqueId.intValue();
		int roleId = 2;
		Long uniqueUserId = userRepository.saveUserRole(longValue, roleId);
		return uniqueUserId;
	}
	
	public List<DocumentRequest> getAllDocumentData(){
		List<DocumentRequest> documentList = clientDao.getAllDocumentData();
		return documentList;
	}
	
	public String getRoleByName(String name) {
		String roleName = appUserDao.findRoleByName(name);
		return roleName;
	}
	
}
