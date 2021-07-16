package com.cg.gsm.service;

import java.util.Map;

import com.cg.gsm.entities.Login;
import com.cg.gsm.exception.LoginException;

public interface ILoginService {

	public Login doLogin(Integer userId, String password) throws LoginException;

	public String encryptString(String str);

	public String decryptString(String str);

	public String encryptLogin(Login loginAcnt);

	public String generateToken(Login login);

	public Map<String, Integer> getAuthMap();

	public boolean verifyLogin(String tokenId) throws LoginException;
}
