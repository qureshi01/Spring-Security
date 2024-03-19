package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.model.Employee;
import com.example.repo.EmployeeRepo;

@Component
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private EmployeeRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Employee byEmail = repo.findByEmail(username);
		if(byEmail==null) {
			throw new UsernameNotFoundException("not found in db");
		}else {
			return new CustomUserDetails(byEmail);
		}
	}

}
