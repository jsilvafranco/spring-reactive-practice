package com.example.tickets.service;

import com.example.tickets.dao.entity.Ticket;
import com.example.tickets.dao.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author jsilva.
 */
@Service
public class TicketServiceImpl implements TicketService {

  @Autowired
  private TicketRepository ticketRepository;

  @Override
  public Mono<Ticket> createTicket(Ticket ticket) {
    return ticketRepository.save(ticket);
  }



  @Override
  public Mono<Ticket> updateTicket(Ticket ticket, String seat) {
    return findBySeat(seat).doOnSuccess(foundTicket -> {
      foundTicket.setLocation(ticket.getLocation());
      foundTicket.setPrice(ticket.getPrice());
      foundTicket.setSeat(ticket.getSeat());
      foundTicket.setStatus(ticket.getStatus());
      ticketRepository.save(foundTicket).subscribe();
    });

  }



  public Flux<Ticket> findByStatus(String status) {
    return ticketRepository.findByStatus(status);
  }


  public Flux<Ticket> findByLocation(String location) {
    return ticketRepository.findByLocation(location);
  }


  @Override
  public Flux<Ticket> findAll() {
    return ticketRepository.findAll();
  }

  @Override
  public Mono<Ticket> findBySeat(String seat) {
    return ticketRepository.findBySeat(seat)
        .switchIfEmpty(Mono.error(new Exception("No ticket found with seat id: " + seat)));
  }

  public Mono<Void> deleteBySeat(String seat){
    return ticketRepository.deleteById(seat);
  }

}
