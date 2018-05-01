package com.movie.book.ticket.app.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.book.ticket.app.entities.MovieTicket;
import com.movie.book.ticket.app.service.MovieTicketBookingService;

@RestController
@RequestMapping(value="/api/movieTickets")
public class MovieTicktBookingController {

	@Autowired
	private MovieTicketBookingService movieTicketBookingService;
	
	@PostMapping(value="/create")
	public MovieTicket CreateMovieTicket(@RequestBody MovieTicket movieTicket) {	
		
		return movieTicketBookingService.createMovieTicket(movieTicket);		
	}
	
	@GetMapping(value="/movieTicket/{ticketId}")
	public MovieTicket getMovieTicketById(@PathVariable("ticketId")Integer ticketId) {
		return movieTicketBookingService.getMovieTicketById(ticketId);
	}
	
	@GetMapping(value="/movieTicket/all")
	public Iterable<MovieTicket> getAllMovieTickets() {
			
		return movieTicketBookingService.getAllMovieTickets();
	}
	
	
	@DeleteMapping(value="/movieTicket/{ticketId}")
	public void deleteMovieTicketById(@PathVariable("ticketId")Integer ticketId) {
		movieTicketBookingService.deleteMovieTicketById(ticketId);
	}
	
	@PutMapping(value="/movieTicket/{ticketId}/{newEmail:.+}")
	public MovieTicket updateTicket(@PathVariable("ticketId")Integer ticketId,@PathVariable("newEmail")String newEmail){
		return movieTicketBookingService.updateMovieTicket(ticketId, newEmail);
		
	}
	
}
