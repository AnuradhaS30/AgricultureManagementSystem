package com.product.Agriculture.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.product.Agriculture.model.CustomerUserDetail;
import com.product.Agriculture.model.User;
import com.product.Agriculture.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService
{

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Optional<User> user= userRepository.findUserByEmail(email);
		user.orElseThrow(() ->  new UsernameNotFoundException("User Not Found"));
		return user.map(CustomerUserDetail::new).get();
	}
}
