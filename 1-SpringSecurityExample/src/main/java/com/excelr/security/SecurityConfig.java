package com.excelr.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
@Configuration
public class SecurityConfig {

//	@Bean
//	UserDetailsService userDetailsService() {
//		InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
//		UserDetails userDetails = User.withUsername("ExcelR").password(passwordEncoder().encode("ExcelR@123")).authorities("read").build();
//		inMemoryUserDetailsManager.createUser(userDetails);
//		return inMemoryUserDetailsManager;
//	}
//	
//	@Bean
//	BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.httpBasic(Customizer.withDefaults());
		http.authorizeHttpRequests(authorize->authorize.requestMatchers("/fsd").authenticated());
		http.addFilterBefore(new MyExcelRFilter(), BasicAuthenticationFilter.class);
		return http.build();
	}
}
