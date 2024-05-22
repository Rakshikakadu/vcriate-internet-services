package com.vcriate.RestaurantManagementSystem.Service;

import java.util.List;

import com.vcriate.RestaurantManagementSystem.Exception.ReservationException;
import com.vcriate.RestaurantManagementSystem.Model.Reservation;

public interface ReservationService {
	List<Reservation> getAllReservations();
    Reservation getReservationById(Long id) throws ReservationException;
    Reservation createReservation(Reservation reservation);
    Reservation updateReservation(Long id, Reservation reservation) throws ReservationException;
    void deleteReservation(Long id) throws ReservationException;
}
