package com.movie.book.ticket.app.dao;

import org.springframework.stereotype.Repository;

import com.movie.book.ticket.app.entities.MovieTicket;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface MovieTicketBookingDao extends CrudRepository<MovieTicket, Integer>{

}
