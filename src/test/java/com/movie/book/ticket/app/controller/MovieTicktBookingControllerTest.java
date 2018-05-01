package com.movie.book.ticket.app.controller;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.movie.book.ticket.app.entities.MovieTicket;
import com.movie.book.ticket.app.service.MovieTicketBookingService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = MovieTicktBookingController.class, secure = false)

public class MovieTicktBookingControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MovieTicketBookingService movieTicketBookingService;
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	
	@Test
	public void CreateMovieTicketTest() throws Exception {

		MovieTicket movieTicket = new MovieTicket();
		movieTicket.setBookingDate(new Date());	
		movieTicket.setDestStation("FRISCO");
		movieTicket.setSourceStation("PLANO");
		movieTicket.setPassengerName("SK");
		movieTicket.setEmail("SK@gmail.com");
		
		String movieTicketJson ="{\"passengerName\": \"SK\",\"bookingDate\": \"2018-04-26T04:41:16.275+0000\",\"sourceStation\": \"PLANO\",\"destStation\": \"FRISCO\",\"email\": \"SK@gmail.com\"}";
		
		Mockito.when(
			movieTicketBookingService.createMovieTicket(Mockito.any(MovieTicket.class)))
			.thenReturn(movieTicket);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/api/movieTickets/create").accept(MediaType.APPLICATION_JSON).content(movieTicketJson)
				.contentType(MediaType.APPLICATION_JSON);
	
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	
		MockHttpServletResponse response = result.getResponse();
	
		assertEquals(HttpStatus.OK.value(), response.getStatus());	

	}
	
	@Test
	public void getMovieTicketTest() throws Exception {

		MovieTicket movieTicket = new MovieTicket();
		movieTicket.setTicketId(1);
		movieTicket.setBookingDate(formatter.parse("2018-04-26"));	
		movieTicket.setDestStation("FRISCO");
		movieTicket.setSourceStation("IRVING");
		movieTicket.setPassengerName("SCK");
		movieTicket.setEmail("SCK@gmail.com");
		
		String expectedMovieTicket ="{\"ticketId\":1,\"passengerName\": \"SCK\",\"bookingDate\": \"2018-04-26T05:00:00.000+0000\",\"sourceStation\": \"IRVING\",\"destStation\": \"FRISCO\",\"email\": \"SCK@gmail.com\"}";
		
		Mockito.when(
			movieTicketBookingService.getMovieTicketById(Mockito.anyInt()))
			.thenReturn(movieTicket);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/api/movieTickets/movieTicket/1").accept(MediaType.APPLICATION_JSON);
	
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse().getContentAsString());
	
		MockHttpServletResponse response = result.getResponse();
	
		assertEquals(HttpStatus.OK.value(), response.getStatus());	
		
		JSONAssert.assertEquals(expectedMovieTicket, result.getResponse()
				.getContentAsString(), false);


	}

}
