package com.hcl.flightbookingapplication.service;



import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcl.flightbookingapplication.dao.BookingRepository;
import com.hcl.flightbookingapplication.dto.TicketDetailsDto;
import com.hcl.flightbookingapplication.exception.TicketNotFoundException;
import com.hcl.flightbookingapplication.model.Booking;
@Service
@Transactional
public class TicketServiceImpl implements TicketService{
	@Autowired
	BookingRepository bookingRepository;

	@Override
	public TicketDetailsDto getTicketById(int id) {
		TicketDetailsDto dto=new TicketDetailsDto();
		Optional<Booking> optinal=bookingRepository.findByTicketNumber(id);
		Booking booking=new Booking();
		if(optinal.isPresent()) {
			booking=optinal.get();
		}
		else {
			throw new TicketNotFoundException("ticket not found");
		}
		if(booking!=null) {
		dto.setTicketNumber(booking.getTicketNumber());
		dto.setAmmount(booking.getAmmount());
		dto.setEmial(booking.getPassenger().getEmail());
		dto.setNoOfSeats(booking.getNoOfSeats());
		dto.setPassengerName(booking.getPassenger().getFirstName());
		dto.setOrigin(booking.getFlight().getOrigin());
		dto.setDestination(booking.getFlight().getDestination());
		dto.setDepartureDate(booking.getJourneyDate());
		dto.setFlightName(booking.getFlight().getFlightName());
		
		}
		return dto;
	}

}



