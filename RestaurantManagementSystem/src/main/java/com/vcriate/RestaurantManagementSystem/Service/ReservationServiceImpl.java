package com.vcriate.RestaurantManagementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcriate.RestaurantManagementSystem.Exception.ReservationException;
import com.vcriate.RestaurantManagementSystem.Model.Reservation;
import com.vcriate.RestaurantManagementSystem.Repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
    private ReservationRepository reservationRepository;

	@Override
	public List<Reservation> getAllReservations() {
		return reservationRepository.findAll();
	}

	@Override
	public Reservation getReservationById(Long id) throws ReservationException {
		return reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationException("Reservation not found with id: " + id));
    
	}
	
	@Override
	public Reservation createReservation(Reservation reservation) {
		return reservationRepository.save(reservation);
	}

	@Override
	public Reservation updateReservation(Long id, Reservation reservation) throws ReservationException {
		Reservation existingReservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationException("Reservation not found with id: " + id));
        
        existingReservation.setCustomer(reservation.getCustomer());
        existingReservation.setReservationTime(reservation.getReservationTime());
        
        return reservationRepository.save(existingReservation);
	}

	@Override
	public void deleteReservation(Long id) throws ReservationException {
		 Reservation existingReservation = reservationRepository.findById(id)
	                .orElseThrow(() -> new ReservationException("Reservation not found with id: " + id));
	        
	        reservationRepository.delete(existingReservation);
		
	}
	
	
	

}
