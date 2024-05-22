package com.vcriate.RestaurantManagementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcriate.RestaurantManagementSystem.Exception.MenuItemException;
import com.vcriate.RestaurantManagementSystem.Model.MenuItem;
import com.vcriate.RestaurantManagementSystem.Repository.MenuItemRepository;

@Service
public class MenuItemServiceImpl implements MenuItemService{
	
	@Autowired
    private MenuItemRepository menuItemRepository;

	@Override
	public List<MenuItem> getAllMenuItems() {
		return menuItemRepository.findAll();
	}

	@Override
	public MenuItem getMenuItemById(Long id) throws MenuItemException {
		return menuItemRepository.findById(id)
                .orElseThrow(() -> new MenuItemException("MenuItem not found with id: " + id));
	}

	@Override
	public MenuItem createMenuItem(MenuItem menuItem) {
		return menuItemRepository.save(menuItem);
	}

	@Override
	public MenuItem updateMenuItem(Long id, MenuItem menuItem) throws MenuItemException {
		MenuItem existingMenuItem = menuItemRepository.findById(id)
                .orElseThrow(() -> new MenuItemException("MenuItem not found with id: " + id));
        
        existingMenuItem.setName(menuItem.getName());
        existingMenuItem.setPrice(menuItem.getPrice());
        
        return menuItemRepository.save(existingMenuItem);
	}

	@Override
	public void deleteMenuItem(Long id) throws MenuItemException {
		MenuItem existingMenuItem = menuItemRepository.findById(id)
                .orElseThrow(() -> new MenuItemException("MenuItem not found with id: " + id));
        
        menuItemRepository.delete(existingMenuItem);
	}
	
	

}
