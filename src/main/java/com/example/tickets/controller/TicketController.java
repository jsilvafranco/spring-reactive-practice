package com.example.tickets.controller;

import com.example.tickets.dao.entity.Ticket;
import com.example.tickets.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author jsilva.
 */
@Slf4j
@RestController
@RequestMapping("/concerts/v1/tickets")
public class TicketController {

  private TicketService ticketService;

  public TicketController(TicketService service){
    this.ticketService = service;
  }

  @GetMapping
  public Flux<Ticket> findAll() {
    log.debug("getting all tickets");
    return ticketService.findAll();
  }

  @GetMapping(value = "/findByLocation", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<Ticket> findByLocation(@RequestParam String location) {
    log.debug("findByLocation ticket with location : {}", location);
    return ticketService.findByLocation(location);
  }


  @GetMapping("/findById/{id}")
  public Mono<Ticket> findOne(@PathVariable String id) {
    log.debug("findOne ticket with id : {}", id);
    return ticketService.findBySeat(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Ticket> create(@RequestBody Ticket ticket) {
    log.debug("create ticket with body : {}", ticket);
    return ticketService.createTicket(ticket);
  }

}
