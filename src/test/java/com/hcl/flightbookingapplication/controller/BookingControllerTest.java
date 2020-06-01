package com.hcl.flightbookingapplication.controller;

import java.util.Date;

import org.json.JSONException;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hcl.flightbookingapplication.dto.BookingDto;
import com.hcl.flightbookingapplication.dto.BookingsDto;
import com.hcl.flightbookingapplication.dto.TicketDetailsDto;
import com.hcl.flightbookingapplication.exception.InsufficientFundsException;
import com.hcl.flightbookingapplication.exception.NoSeatsAvailableException;
import com.hcl.flightbookingapplication.model.Booking;
import com.hcl.flightbookingapplication.service.BookingServiceImpl;

@RunWith(MockitoJUnitRunner.Silent.class)
public class BookingControllerTest {
	@InjectMocks
	BookingController busBookingController;
	
	@Mock
    BookingServiceImpl busBookingService;
	static TicketDetailsDto dto=new TicketDetailsDto();
	static Booking booking=null;
	@BeforeClass
	public static void setUp() {
		booking=new Booking();
		booking.setTicketNumber(23335);
		dto =new TicketDetailsDto();
		dto.setPassengerName("divya");
		dto.setDestination("chennai");
		dto.setAmmount(122);
		dto.setDepartureDate(new Date());
		dto.setEmial("divay@gmil.com");
		dto.setFlightName("indgo");
		dto.setNoOfSeats(2);
		dto.setOrigin("ongole");
		
	}
	
	
	@AfterClass
	public static void tearDown() {
		booking=null;
		
	}
	@Test
	public void testTicketbooking() throws NoSeatsAvailableException, InsufficientFundsException, JSONException {
		BookingDto bookingDto =new BookingDto();
		Booking booking =new Booking();
		bookingDto.setFlightNumber(123);;
		bookingDto.setNoOfSeats(3);
		BookingsDto dto=new BookingsDto();
		dto.setNumberOfSeats(3);
		dto.setPassengerId(1);
		Mockito.when(busBookingService.bookTheTicket(dto, 78786687L, 898987L)).thenReturn(bookingDto);
		ResponseEntity<BookingDto> b=busBookingController.bookingtheTicket(dto, 5786877868L, 798786879L);
		
		Assert.assertNotNull(b);
		
	}
	
	@Test
	public void testTicketbookingpos() throws NoSeatsAvailableException, InsufficientFundsException, JSONException {
		BookingDto bookingDto =new BookingDto();
		Booking booking =new Booking();
		bookingDto.setFlightNumber(123);
		bookingDto.setNoOfSeats(3);
		BookingsDto bookingsDto =new BookingsDto();
		bookingsDto.setFlightNumber(123);
		Mockito.when(busBookingService.bookTheTicket(bookingsDto, 76878L, 78789789L)).thenReturn(bookingDto);
		Assert.assertNotNull(booking);
		ResponseEntity<BookingDto> b=busBookingController.bookingtheTicket(bookingsDto, 5786877868L, 798786879L);
	
		
		Assert.assertEquals(HttpStatus.CREATED, b.getStatusCode());
		
	}

}
