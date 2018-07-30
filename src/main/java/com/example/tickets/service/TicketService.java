package com.example.tickets.service;

import com.example.tickets.dao.entity.Ticket;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author jsilva.
 */
public interface TicketService {

  Mono<Ticket> createTicket(Ticket ticket);
  Mono<Ticket> updateTicket(Ticket ticket, String seat);
  Flux<Ticket> findAll();
  Mono<Ticket> findBySeat(String seat);
  Flux<Ticket> findByLocation(String location);
  Mono<Void> deleteBySeat(String seat);

}
