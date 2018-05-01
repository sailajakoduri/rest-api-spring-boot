package com.movie.book.ticket.app;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.movie.book.ticket.app.entities.MovieTicket;
import com.movie.book.ticket.app.service.MovieTicketBookingService;

@SpringBootApplication
public class MovieTicketBookingManagementAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(MovieTicketBookingManagementAppApplication.class, args);
		
		MovieTicketBookingService ticketBookingService = applicationContext.getBean("movieTicketBookingService", MovieTicketBookingService.class);
		//Create a ticket 
		MovieTicket movieTicket = new MovieTicket();
		movieTicket.setBookingDate(new Date());
		movieTicket.setDestStation("FRISCO");
		movieTicket.setSourceStation("PLANO");
		movieTicket.setPassengerName("SK");
		movieTicket.setEmail("SK@gmail.com");
		
		ticketBookingService.createMovieTicket(movieTicket);
	}
}
