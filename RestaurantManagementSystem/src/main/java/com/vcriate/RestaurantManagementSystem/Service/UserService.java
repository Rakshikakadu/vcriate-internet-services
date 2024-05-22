package com.vcriate.RestaurantManagementSystem.Service;

import java.util.List;

import com.vcriate.RestaurantManagementSystem.Exception.UserException;
import com.vcriate.RestaurantManagementSystem.Model.User;

public interface UserService {
	
	List<User> getAllUsers();
    User getUserById(Long id) throws UserException;
    User getUserByUsername(String username) throws UserException;
    User createUser(User user);
    User updateUser(Long id, User user) throws UserException;
    void deleteUser(Long id) throws UserException;

}
