package com.practice.service;

import java.util.Map;

import com.practice.binding.LoginForm;
import com.practice.binding.UnlockAccForm;
import com.practice.binding.UserForm;

public interface UserService {
	
	public String loginCheck(LoginForm loginForm);
	public Map<Integer,String> getCountries();
	public Map<Integer,String> getStates(Integer countryId);
	public Map<Integer,String> getCities(Integer stateId);
	public boolean emailUnique(String email);
	public boolean saveUser(UserForm form);
	public boolean unlockAccount(UnlockAccForm  unlockAccForm);
	public String forgotPwd(String email);
	

}
