package com.example.tickets;

import com.example.tickets.dao.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableMongoAuditing
@EnableReactiveMongoRepositories
@SpringBootApplication
public class OriginApplication {

  @Autowired
  private TicketRepository ticketRepository;
  @Autowired
  MongoTemplate template;

  public static void main(String[] args) {
    SpringApplication.run(OriginApplication.class, args);
  }





}
