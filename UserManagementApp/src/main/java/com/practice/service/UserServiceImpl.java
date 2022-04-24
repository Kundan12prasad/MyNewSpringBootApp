package com.practice.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.binding.LoginForm;
import com.practice.binding.UnlockAccForm;
import com.practice.binding.UserForm;
import com.practice.entity.City;
import com.practice.entity.Country;
import com.practice.entity.State;
import com.practice.entity.User;
import com.practice.repository.CityRepository;
import com.practice.repository.CountryRepository;
import com.practice.repository.StateRepository;
import com.practice.repository.UserRepository;
import com.practice.utils.EmailUtils;

@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private CountryRepository countryRepo;
	
	@Autowired
	private StateRepository stateRepo;
	
	@Autowired
	private CityRepository cityRepo;	
	
	@Autowired
	private EmailUtils emailUtils;
	

	@Override
	public String loginCheck(LoginForm loginForm) {
		
		String email = loginForm.getEmail();
		String password = loginForm.getPassword();		
		User userAcc = repository.findByEmailAndPazzword(email,password);
		if(userAcc!=null)
		{
			String accStatus = userAcc.getAccStatus();
			if(accStatus.equals("Locked")) {
				return "Your Account is Locked";
			}			
			else
			{
				return "SUCCESS";				
			}			
		}
		
		else 
		{
			return " Invalid Credentials";
		}		
	}

	@Override
	public Map<Integer, String> getCountries() {
		List<Country> countries = countryRepo.findAll();
		Map<Integer,String> countryMap=new HashMap<Integer,String>();
		countries.forEach(country->{
			countryMap.put(country.getCountryId(), country.getCountryName());
			
		});		
		return countryMap;
	}

	@Override
	public Map<Integer, String> getStates(Integer countryId) {
		List<State> states = stateRepo.findByCountryId(countryId);
		
		Map<Integer,String> stateMap=new HashMap<>();
		
		states.forEach(state->{
			stateMap.put(state.getStateId(), state.getStateName());           	                 
			});
		
		return stateMap;
	}

	@Override
	public Map<Integer, String> getCities(Integer stateId) {
		List<City> cities = cityRepo.findByStateId(stateId);
		Map<Integer,String> citiesMap=new HashMap<>();
		cities.forEach(city->
		             {
		            	 citiesMap.put(city.getCityId(), city.getCityName());
		             });
		
		return citiesMap ;
	}

	@Override
	public boolean emailUnique(String email) {
		
		User userEmail = repository.findByEmail(email);
		if(userEmail== null)
		{
			return true;			
		}
		else {		
		return false;
		}
	}

	@Override
	public boolean saveUser(UserForm userForm) {
		userForm.setAccStatus("Locked");
		userForm.setPazzword(generateTempPwd());
		User entity=new User();
		BeanUtils.copyProperties(userForm, entity);
		User save = repository.save(entity);
		
		//String subject="User Registration Successfull|| Kundan IT";
		//String body=getUserRegEmailBody(userForm);
		
		if(save.getUserId() != null)
		{			
			String subject="User Registration Successfull|| Kundan IT";
			String body=getUserRegEmailBody(userForm);			
		    emailUtils.sendEmail(userForm.getEmail(), subject, body);
			return true;
		}		
		return false;
	}

	private String generateTempPwd() {
		
		String randomTxt = RandomStringUtils.randomAlphanumeric(10);		
		return randomTxt;
	}

	@Override
	public boolean unlockAccount(UnlockAccForm unlockAccForm) {
		String email = unlockAccForm.getEmail();
		String tmpPwd = unlockAccForm.getTmpPwd();
		User user = repository.findByEmailAndPazzword(email, tmpPwd);
		if(user!=null)
		{	
			String newpwd = unlockAccForm.getNewpwd();
			user.setPazzword(newpwd);
			user.setAccStatus("UNLOCKED");	
			repository.save(user);
			return true;
		}
		return false;			
	}

	@Override
	public String forgotPwd(String emailId) {
		User user = repository.findByEmail(emailId);
		if(user!= null)
		{
			String subject="Forgot Password|| KundanIT";
			String body1 = getForgotPwdEmailbody(user);
			emailUtils.sendEmail(user.getEmail(), subject, body1);			
			return "Email Sent with Password";
		}
		
		return "Enter Correct EmailId";
	}	
	
	//email template methods	
	private String getUserRegEmailBody(UserForm userForm)
	{
		StringBuffer sb=new StringBuffer();
		String fileName= "UNLOCK_ACCNT_EMAIL_BODY_TEMPLATE.txt";
		List<String>lines=new ArrayList<String>();
		try(BufferedReader br=Files.newBufferedReader(Paths.get(fileName)))
		{
		 lines = br.lines().collect(Collectors.toList());
		}		
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		lines.forEach(line->{
		if(line.contains("{FNAME}")) {
			
			 line=line.replace("{FNAME}", userForm.getFname());
		}
		
       if(line.contains("{LNAME}")) {
			
		line=line.replace("{LNAME}", userForm.getLname());
		}
       
       if(line.contains("{TEMP-PWD}")) {
			
			line=line.replace("{TEMP-PWD}", userForm.getPazzword());
		}
       
       if(line.contains("{EMAIL}")) {			
			line=line.replace("{EMAIL}", userForm.getEmail());
		}
       
       sb.append(line);			
		});			
		return  sb.toString();
	}
	
	private String getForgotPwdEmailbody(User entity)
	{
		StringBuffer sb=new StringBuffer();
		String fileName= "RECOVER_PASSWORD_EMAIL_BODY_TEMPLATE.txt";
		List<String> lines=new ArrayList<String>();
		try( BufferedReader br=Files.newBufferedReader(Paths.get(fileName)))
		{
			lines = br.lines().collect(Collectors.toList());			
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		lines.forEach(line->
		{
			if(line.contains("{FNAME}"))
			{
				line=line.replace("{FNAME}",entity.getFname());
			}
			
			if(line.contains("{LNAME}"))
			{
				line=line.replace("{LNAME}",entity.getLname());
			}			
			
			if(line.contains("{PWD}"))
			{
				line=line.replace("{PWD}",entity.getPazzword());
			}
			sb.append(line);
				
		});		
		
		return  sb.toString();
	}	

}
