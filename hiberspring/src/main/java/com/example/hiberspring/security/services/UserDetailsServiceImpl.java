package com.example.hiberspring.security.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.hiberspring.model.User;
import com.example.hiberspring.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user;
		
			user = UserRepository.findByUsername(username)
					 .orElseThrow(() -> new UsernameNotFoundException(
							 "User Not Found with username: " + username));
		
				 return UserDetailsImpl.build(user);
				 }

}

