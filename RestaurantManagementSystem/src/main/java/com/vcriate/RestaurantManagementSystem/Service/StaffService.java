package com.vcriate.RestaurantManagementSystem.Service;

import java.util.List;

import com.vcriate.RestaurantManagementSystem.Exception.StaffException;
import com.vcriate.RestaurantManagementSystem.Model.Staff;

public interface StaffService {
	
	List<Staff> getAllStaff();
    Staff getStaffById(Long id) throws StaffException;
    Staff createStaff(Staff staff);
    Staff updateStaff(Long id, Staff staff) throws StaffException;
    void deleteStaff(Long id) throws StaffException;

}
