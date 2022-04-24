package com.practice.security.config;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	
	private static final String RESOURCE_ID= "couponservice";
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService  userDetailsService;
	
	@Autowired
	private PasswordEncoder  passwordEncoder;
	
	@Autowired
	private DataSource dataSource;
	
	/*
	 * InMemory Token store
	 * 
	 * @Override public void configure(AuthorizationServerEndpointsConfigurer
	 * endpoints) throws Exception {
	 * 
	 * endpoints.tokenStore(new
	 * InMemoryTokenStore()).authenticationManager(authenticationManager)
	 * .userDetailsService(userDetailsService);
	 * 
	 * }
	 */
	
	
	//DataBase Token Store
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		
		endpoints.tokenStore(new JdbcTokenStore(dataSource)).authenticationManager(authenticationManager)
		.userDetailsService(userDetailsService);
		
	} 
	
	   
	//Password Grant Type
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception
	{
		clients.inMemory().withClient("couponclientapp").secret(passwordEncoder.encode("9999"))
		.authorizedGrantTypes("password","refresh_token").scopes("read", "write").resourceIds(RESOURCE_ID);		
	}
	
}
	
	//Authorization Code Grant Type
	//For Authorization code Grant Type need to create Separate Auth-server project
	
	/*
	 * @Override 
	 * public void configure(ClientDetailsServiceConfigurer clients)
	 * throws Exception 
	 * {
	 * clients.inMemory().withClient("couponclientapp").secret(passwordEncoder.
	 * encode("9999"))
	 * .authorizedGrantTypes("authorization_code,","password","refresh_token").
	 * scopes("read", "write") .resourceIds(RESOURCE_ID).redirectUris(
	 * "http://localhost:7070/codeHandlerPage");   
	 * }*/
	 

	
	
	

