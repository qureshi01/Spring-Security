package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	
//	@Bean
//	BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//	@Bean
//	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//		http.httpBasic(Customizer.withDefaults());
//		http.formLogin(Customizer.withDefaults());
//		http.authorizeHttpRequests(authorize->authorize.requestMatchers(HttpMethod.POST,"/save").hasRole("ADMIN")
//													   .requestMatchers(HttpMethod.GET,"/get","/","/viewEmployees","/employees").hasAnyRole("ADMIN","USER")
//													   .requestMatchers(HttpMethod.GET,"/uploadEmployee","/uploadEmployeeForm","/success").hasRole("ADMIN")
//													   .requestMatchers(HttpMethod.POST,"/saveWeb").hasRole("ADMIN"));
//		http.csrf(csrf->csrf.disable());
//		return http.build();
//	}

}
