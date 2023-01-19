package com.greenhood.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenhood.exception.AuthorizationException;
import com.greenhood.model.Admin;
import com.greenhood.model.AdminCurrentSession;
import com.greenhood.model.LogInDTO;
import com.greenhood.repository.AdminDao;
import com.greenhood.repository.AdminSessionDao;

import net.bytebuddy.utility.RandomString;

@Service
public class AdminLogInServiceImpl implements LogInService{
	
	@Autowired
	private AdminDao aDao;
	
	@Autowired
	private AdminSessionDao aSDao;

	@Override
	public String logIn(LogInDTO dto) throws AuthorizationException {
		
Admin existingAdmin = aDao.findByMobileNo(dto.getMobileNo());
		
		if(existingAdmin == null) {
			throw new AuthorizationException("Please register your self first!");
		}
		
		Optional<AdminCurrentSession> validAdmin = aSDao.findById(existingAdmin.getAdminId());
		
		if(validAdmin.isPresent()) {
			throw new AuthorizationException("Customer already logged in!");
		}
		
		if(existingAdmin.getPassword().equals(dto.getPassword())) {
			
			String key = RandomString.make(6);
			
			AdminCurrentSession adminCurrentSession = new AdminCurrentSession(existingAdmin.getAdminId(),key,LocalDateTime.now());
			
			aSDao.save(adminCurrentSession);
			
			return adminCurrentSession.toString();
		}
		else {
			throw new AuthorizationException("Please enter a valid password!");
		}
	}

	@Override
	public String logOut(String uId) throws AuthorizationException {
		
		AdminCurrentSession validAdmin = (AdminCurrentSession) aSDao.findByUniqueId(uId);
		
		if(validAdmin == null) {
			throw new AuthorizationException("Admin haven't logged in with this number");
		}
		
		aSDao.delete(validAdmin);
		
		return "Logged out successfully!;";
	}

}
