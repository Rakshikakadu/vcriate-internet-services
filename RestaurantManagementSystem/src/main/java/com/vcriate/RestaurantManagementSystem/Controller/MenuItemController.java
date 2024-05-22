package com.vcriate.RestaurantManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcriate.RestaurantManagementSystem.Exception.MenuItemException;
import com.vcriate.RestaurantManagementSystem.Model.MenuItem;
import com.vcriate.RestaurantManagementSystem.Service.MenuItemService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/menu-items")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @GetMapping("/get")
    public List<MenuItem> getAllMenuItems() {
        return menuItemService.getAllMenuItems();
    }

    @GetMapping("/getMenuById/{id}")
    public ResponseEntity<MenuItem> getMenuItemById(@PathVariable Long id) throws MenuItemException {
        MenuItem menuItem = menuItemService.getMenuItemById(id);
        return ResponseEntity.ok(menuItem);
    }

    @PostMapping("/create")
    public ResponseEntity<MenuItem> createMenuItem(@RequestBody MenuItem menuItem) {
        MenuItem createdMenuItem = menuItemService.createMenuItem(menuItem);
        return ResponseEntity.ok(createdMenuItem);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MenuItem> updateMenuItem(@PathVariable Long id, @RequestBody MenuItem menuItem) throws MenuItemException {
        MenuItem updatedMenuItem = menuItemService.updateMenuItem(id, menuItem);
        return ResponseEntity.ok(updatedMenuItem);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteMenuItem(@PathVariable Long id) throws MenuItemException {
        menuItemService.deleteMenuItem(id);
        return ResponseEntity.noContent().build();
    }
    
}
