package com.nt.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 @Override
protected void configure(HttpSecurity http) throws Exception {
	 http.authorizeRequests().antMatchers("/","/test").permitAll()
	 .anyRequest().authenticated()
	 .and().formLogin()
	 .and().oauth2Login()
	 .and().csrf().disable();
}
}
