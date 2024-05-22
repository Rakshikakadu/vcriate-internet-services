package com.vcriate.RestaurantManagementSystem.Service;

import java.util.List;

import com.vcriate.RestaurantManagementSystem.Exception.MenuItemException;
import com.vcriate.RestaurantManagementSystem.Model.MenuItem;

public interface MenuItemService {
	
	List<MenuItem> getAllMenuItems();
    MenuItem getMenuItemById(Long id) throws MenuItemException;
    MenuItem createMenuItem(MenuItem menuItem);
    MenuItem updateMenuItem(Long id, MenuItem menuItem) throws MenuItemException;
    void deleteMenuItem(Long id) throws MenuItemException;
}
