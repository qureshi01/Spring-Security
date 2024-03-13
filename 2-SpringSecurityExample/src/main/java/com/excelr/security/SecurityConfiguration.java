package com.excelr.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.httpBasic(Customizer.withDefaults());
		http.authorizeHttpRequests(authorize->authorize.requestMatchers(HttpMethod.POST,"/save").hasAnyRole("ADMIN","ADMIN1")
													   .requestMatchers(HttpMethod.GET,"/get").hasAnyRole("ADMIN","USER"));
		http.csrf(csrf->csrf.disable());
		return http.build();
	}
}
