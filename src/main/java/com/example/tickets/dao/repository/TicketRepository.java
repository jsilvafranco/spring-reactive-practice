package com.example.tickets.dao.repository;

import com.example.tickets.dao.entity.Ticket;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author jsilva.
 */
@Repository
public interface TicketRepository extends ReactiveCrudRepository<Ticket, String> {

  Flux<Ticket> findByLocation(String location);

  Flux<Ticket> findByStatus(String status);

  Mono<Ticket> findBySeat(String seat);
}

