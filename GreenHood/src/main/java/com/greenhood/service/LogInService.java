package com.greenhood.service;

import com.greenhood.exception.AuthorizationException;
import com.greenhood.model.LogInDTO;

public interface LogInService {
	
	public String logIn(LogInDTO dto) throws AuthorizationException;
	
	public String logOut(String uId) throws AuthorizationException;
}
