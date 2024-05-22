package com.vcriate.RestaurantManagementSystem.Security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.vcriate.RestaurantManagementSystem.Exception.UserException;
import com.vcriate.RestaurantManagementSystem.Model.User;
import com.vcriate.RestaurantManagementSystem.Repository.UserRepository;

@Service
public class UserDetailsServiceImpl {
	@Autowired
    private UserRepository userRepository;

    
    public UserDetails loadUserByUsername(String username) throws UserException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UserException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole())));
    }
}
