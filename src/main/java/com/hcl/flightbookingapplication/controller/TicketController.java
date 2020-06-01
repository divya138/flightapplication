package com.hcl.flightbookingapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.flightbookingapplication.dto.TicketDetailsDto;
import com.hcl.flightbookingapplication.exception.TicketNotFoundException;
import com.hcl.flightbookingapplication.model.Booking;
import com.hcl.flightbookingapplication.service.TicketService;

@RestController
public class TicketController {
	
	@Autowired
	TicketService ticketService;
	@GetMapping("/ticket/{ticketNumber}")
	public ResponseEntity<TicketDetailsDto> getTicketDetails(@PathVariable int ticketNumber){
		TicketDetailsDto dto=ticketService.getTicketById(ticketNumber);
		return new ResponseEntity<TicketDetailsDto>(dto, HttpStatus.OK);
	
	}

}
