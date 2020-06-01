package com.hcl.flightbookingapplication.controller;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.flightbookingapplication.dto.BookingDto;
import com.hcl.flightbookingapplication.dto.BookingsDto;
import com.hcl.flightbookingapplication.dto.TicketDetailsDto;
import com.hcl.flightbookingapplication.service.BookingService;



@RestController
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	BookingDto booking1=new BookingDto();
	@PostMapping("/booking")
	public ResponseEntity<BookingDto> bookingtheTicket(@RequestBody BookingsDto bookingsDto,@RequestParam long userAccountNumber,@RequestParam long airLineAccountNumber) throws JSONException {
		 booking1=bookingService.bookTheTicket(bookingsDto,userAccountNumber,airLineAccountNumber);
		return new ResponseEntity<BookingDto>(booking1, HttpStatus.CREATED);
	}
	
}
