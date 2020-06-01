package com.hcl.flightbookingapplication.service;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.flightbookingapplication.dao.BookingRepository;
import com.hcl.flightbookingapplication.dao.FlightRepository;
import com.hcl.flightbookingapplication.dao.PassengerRepository;
import com.hcl.flightbookingapplication.dto.BookingDto;
import com.hcl.flightbookingapplication.dto.BookingsDto;
import com.hcl.flightbookingapplication.exception.NoSeatsAvailableException;
import com.hcl.flightbookingapplication.model.Booking;
import com.hcl.flightbookingapplication.model.Flight;
import com.hcl.flightbookingapplication.model.Passenger;

@RunWith(MockitoJUnitRunner.Silent.class)
public class BookingServiceImplTest {
	@InjectMocks
	BookingServiceImpl busBookingServiceImpl;
	@Mock
	BookingRepository busBookingRepo;
	
	@Mock
	FlightRepository busRepo;
	@Mock
	PassengerRepository userRepo;
	@Test(expected=NoSeatsAvailableException.class)
	public void bookBusServicefrusr() throws JSONException,NoSeatsAvailableException {
		BookingsDto bookingDto = new BookingsDto();
		Booking booking =new Booking();
		Flight flight=new Flight();
		flight.setAvailableSeats(10);
		Passenger passenger=new Passenger();
		passenger.setMobileNumber(9989787656l);
		booking.setNoOfSeats(5);
		bookingDto.setNumberOfSeats(4);
		Mockito.when(userRepo.getOne(bookingDto.getPassengerId())).thenReturn(null);
		busBookingServiceImpl.bookTheTicket(bookingDto, 89878787L, 787898L);
	}
	
	@Test(expected=NoSeatsAvailableException.class)
	public void bookBusServiceTestbus() throws JSONException,NoSeatsAvailableException {
		BookingsDto bookingDto = new BookingsDto();
		Flight flight=new Flight();
		BookingDto booking =new BookingDto();
		Passenger usr =new Passenger();
		usr.setEmail("bhavan");
		usr.setPassengerId(2);
		usr.setMobileNumber(9989787656l);
		bookingDto.setFlightNumber(123);
		booking.setFlightName("indigo");
		booking.setFlightNumber(123);
		booking.setNoOfSeats(3);
		bookingDto.setNumberOfSeats(3);
		flight.setAvailableSeats(10);
		bookingDto.setNumberOfSeats(flight.getAvailableSeats()-booking.getNoOfSeats());
		Mockito.when(userRepo.getOne(usr.getPassengerId())).thenReturn(usr);
		busBookingServiceImpl.bookTheTicket(bookingDto, 8878989087l,8767867867l);
		Assert.assertNotNull(usr);
		Assert.assertEquals(booking.getFlightNumber(), bookingDto.getFlightNumber());
		
	}
	

}
