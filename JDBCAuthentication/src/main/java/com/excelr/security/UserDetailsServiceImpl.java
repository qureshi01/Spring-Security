package com.excelr.security;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.excelr.model.AppUser;
import com.excelr.repo.AppUserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AppUserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		AppUser user = repo.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("user not available in database");
		}
		Set<String> authorities=user.getAuthorities();
		Set<GrantedAuthority> gauthorities = new HashSet<GrantedAuthority>();
		gauthorities = authorities.stream().map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toSet());
		return new User(user.getUsername(), user.getPassword(), gauthorities);
	}
	
	public AppUser createUser(AppUser user) {
		return repo.save(user);
	}

}
