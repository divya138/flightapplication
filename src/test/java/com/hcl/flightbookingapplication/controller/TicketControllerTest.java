package com.hcl.flightbookingapplication.controller;

import java.util.Date;

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
import com.hcl.flightbookingapplication.dao.BookingRepository;
import com.hcl.flightbookingapplication.dto.TicketDetailsDto;
import com.hcl.flightbookingapplication.model.Booking;
import com.hcl.flightbookingapplication.service.TicketServiceImpl;
@RunWith(MockitoJUnitRunner.Silent.class)
public class TicketControllerTest {
	@InjectMocks
	TicketController ticketController;
	@Mock
	TicketServiceImpl ticketServiceImpl;
	@Mock
	BookingRepository bookingRepository;

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
	@Test
	public void testgetTicketNumberpositive() {
		Mockito.when(ticketServiceImpl.getTicketById(booking.getTicketNumber())).thenReturn(dto);
		ResponseEntity<TicketDetailsDto> p1 = ticketController.getTicketDetails(booking.getTicketNumber());
		Assert.assertNotNull(p1);
		Assert.assertNotNull(dto);
		Assert.assertEquals(HttpStatus.OK, p1.getStatusCode());

	}
	@Test
	public void testgetTicketNumberpositiveNegtive() {
		Mockito.when(ticketServiceImpl.getTicketById(booking.getTicketNumber())).thenReturn(dto);
		ResponseEntity<TicketDetailsDto> p1 = ticketController.getTicketDetails(booking.getTicketNumber());
		Assert.assertNotNull(p1);
	
	}
	
	@AfterClass
	public static void tearDown() {
		booking=null;
		
	}
}
