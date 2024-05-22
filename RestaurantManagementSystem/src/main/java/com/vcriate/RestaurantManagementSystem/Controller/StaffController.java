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

import com.vcriate.RestaurantManagementSystem.Exception.StaffException;
import com.vcriate.RestaurantManagementSystem.Model.Staff;
import com.vcriate.RestaurantManagementSystem.Service.StaffService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping("/get")
    public List<Staff> getAllStaff() {
        return staffService.getAllStaff();
    }

    @GetMapping("/staffById/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable Long id) throws StaffException {
        Staff staff = staffService.getStaffById(id);
        return ResponseEntity.ok(staff);
    }

    @PostMapping("/create")
    public ResponseEntity<Staff> createStaff(@RequestBody Staff staff) {
        Staff createdStaff = staffService.createStaff(staff);
        return ResponseEntity.ok(createdStaff);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable Long id, @RequestBody Staff staff) throws StaffException {
        Staff updatedStaff = staffService.updateStaff(id, staff);
        return ResponseEntity.ok(updatedStaff);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStaff(@PathVariable Long id) throws StaffException {
        staffService.deleteStaff(id);
        return ResponseEntity.noContent().build();
    }
}
