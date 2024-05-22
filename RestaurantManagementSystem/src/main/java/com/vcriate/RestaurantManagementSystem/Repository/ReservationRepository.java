package com.vcriate.RestaurantManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcriate.RestaurantManagementSystem.Model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}

