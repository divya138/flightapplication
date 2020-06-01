package com.hcl.flightbookingapplication.service;

import org.json.JSONException;

import com.hcl.flightbookingapplication.dto.BookingDto;
import com.hcl.flightbookingapplication.dto.BookingsDto;

public interface BookingService {
	
	public BookingDto bookTheTicket(BookingsDto bookingsDto,long passengerAccountNumber,long airLineAccountNumber)throws JSONException;

}
