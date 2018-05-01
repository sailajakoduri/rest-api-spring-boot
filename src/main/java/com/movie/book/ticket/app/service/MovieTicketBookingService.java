package com.movie.book.ticket.app.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.book.ticket.app.dao.MovieTicketBookingDao;
import com.movie.book.ticket.app.entities.MovieTicket;

@Service
public class MovieTicketBookingService {

	@Autowired
	private MovieTicketBookingDao movieTicketBookingDao;

	public MovieTicket createMovieTicket(MovieTicket movieTicket) {
		return movieTicketBookingDao.save(movieTicket);
		
	}

	public MovieTicket getMovieTicketById(Integer ticketId) {
		return movieTicketBookingDao.findById(ticketId).get();
	}

	public Iterable<MovieTicket> getAllMovieTickets() {
		Iterable<MovieTicket> ticketList = movieTicketBookingDao.findAll();
		List<MovieTicket> list = new ArrayList<MovieTicket>();
		
		Iterator listIterator = ticketList.iterator();
		
		while(listIterator.hasNext()) {
			MovieTicket movieTicket = (MovieTicket) listIterator.next();
			list.add(movieTicket);
		}
		
		Collections.sort(list, new Comparator<MovieTicket>() {

			@Override
			public int compare(MovieTicket o1, MovieTicket o2) {				
				return o1.getPassengerName().compareTo(o2.getPassengerName());
			}
		});
		
		return (Iterable<MovieTicket>)list;
	}

	public void deleteMovieTicketById(Integer ticketId) {
		movieTicketBookingDao.deleteById(ticketId);
	}
	
	public MovieTicket updateMovieTicket(Integer ticketId, String newEmail) {
		MovieTicket ticketFromDb = movieTicketBookingDao.findById(ticketId).get();
		ticketFromDb.setEmail(newEmail);
		MovieTicket upadedTicket = movieTicketBookingDao.save(ticketFromDb);
		return upadedTicket;
	}

}
