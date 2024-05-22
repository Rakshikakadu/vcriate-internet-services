package com.vcriate.RestaurantManagementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcriate.RestaurantManagementSystem.Exception.StaffException;
import com.vcriate.RestaurantManagementSystem.Model.Staff;
import com.vcriate.RestaurantManagementSystem.Repository.StaffRepository;

@Service
public class StaffServiceImpl implements StaffService{
	
	@Autowired
    private StaffRepository staffRepository;

	@Override
	public List<Staff> getAllStaff() {
		return staffRepository.findAll();
	}

	@Override
	public Staff getStaffById(Long id) throws StaffException {
		return staffRepository.findById(id)
                .orElseThrow(() -> new StaffException("Staff not found with id: " + id));
   
	}

	@Override
	public Staff createStaff(Staff staff) {
		 return staffRepository.save(staff);
	}

	@Override
	public Staff updateStaff(Long id, Staff staff) throws StaffException {
		Staff existingStaff = staffRepository.findById(id)
                .orElseThrow(() -> new StaffException("Staff not found with id: " + id));
        
        existingStaff.setName(staff.getName());
        existingStaff.setPosition(staff.getPosition());
        
        return staffRepository.save(existingStaff);
	}

	@Override
	public void deleteStaff(Long id) throws StaffException {
		Staff existingStaff = staffRepository.findById(id)
                .orElseThrow(() -> new StaffException("Staff not found with id: " + id));
        
        staffRepository.delete(existingStaff);
		
	}

}
