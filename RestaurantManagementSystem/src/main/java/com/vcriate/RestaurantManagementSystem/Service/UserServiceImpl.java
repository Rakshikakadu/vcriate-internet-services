package com.vcriate.RestaurantManagementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcriate.RestaurantManagementSystem.Exception.UserException;
import com.vcriate.RestaurantManagementSystem.Model.User;
import com.vcriate.RestaurantManagementSystem.Repository.UserRepository;

@Service 
public class UserServiceImpl implements UserService{
	
	 @Autowired
	 private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Long id) throws UserException {
		return userRepository.findById(id)
                .orElseThrow(() -> new UserException("User not found with id: " + id));
    
	}

	@Override
	public User getUserByUsername(String username) throws UserException {
		
		return userRepository.findByUsername(username);
//		return userRepository.findByUsername(username)
//                .orElseThrow(() -> new UserException("User not found with username: " + username));
//   
	}

	@Override
	public User createUser(User user) {
		 return userRepository.save(user);
	}

	@Override
	public User updateUser(Long id, User user) throws UserException {
		User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserException("User not found with id: " + id));
        
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setRole(user.getRole());
        
        return userRepository.save(existingUser);
	}

	@Override
	public void deleteUser(Long id) throws UserException {
		 User existingUser = userRepository.findById(id)
	                .orElseThrow(() -> new UserException("User not found with id: " + id));
	        
	        userRepository.delete(existingUser);
		
	}

}
