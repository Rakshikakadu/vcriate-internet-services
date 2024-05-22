package com.vcriate.RestaurantManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcriate.RestaurantManagementSystem.Model.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
}

