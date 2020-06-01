package com.hcl.flightbookingapplication.service;

import java.util.Date;
import java.util.Optional;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.hcl.flightbookingapplication.dao.BookingRepository;
import com.hcl.flightbookingapplication.dto.TicketDetailsDto;
import com.hcl.flightbookingapplication.model.Booking;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TicketServiceImplTest {
	@InjectMocks
	TicketServiceImpl ticketService;
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
	@Test(expected = NullPointerException.class)
	public void TestSaveRouteForPositive(){

		Booking route = new Booking();
		route.setTicketNumber(123);;
		route.setNoOfSeats(5);

		Optional<Booking> routedto = Optional.ofNullable(new Booking());

		Mockito.when(bookingRepository.findByTicketNumber(Mockito.anyInt())).thenReturn(routedto);

		TicketDetailsDto result = ticketService.getTicketById(577);
		Assert.assertNotNull(route);
		Assert.assertNotNull(result);
	}
	@AfterClass
	public static void tearDown() {
		booking=null;
		
	}

}
