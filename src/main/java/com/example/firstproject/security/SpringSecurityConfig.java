package com.example.firstproject.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig  {

    // creating user with username : user password : password
	@Bean
 	public UserDetailsService userDetailsService() {
		
 		UserDetails user = User.withDefaultPasswordEncoder()
 			.username("user")
 			.password("password")
 			.roles("USER")
 			.build();
 		return new InMemoryUserDetailsManager(user);
 	}

    @Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	http
	        .httpBasic()
	        .and()
	        .authorizeRequests()
	        .antMatchers(HttpMethod.GET, "/api/v1/person/**").hasRole("USER")
	        .antMatchers(HttpMethod.POST, "/api/v1/person/**").hasRole("USER")
	        .antMatchers(HttpMethod.PUT, "/api/v1/person/**").hasRole("USER")
	        .antMatchers(HttpMethod.DELETE, "/api/v1/person/**").hasRole("USER")
	        .and()
	        .csrf().disable()
	        .formLogin().disable();
		return http.build();
	}


}