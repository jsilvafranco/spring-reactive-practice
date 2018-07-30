package com.example.tickets.dao.entity;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author jsilva.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "tickets")
public class Ticket {


  @Id
  private String seat;
  @TextIndexed
  private String location;
  private BigDecimal price;
  @TextIndexed
  private String status;

  public static Ticket generateNewTicket() {
    return new Ticket(UUID.randomUUID().toString(), "El Campin", BigDecimal.valueOf(150000),
        "AVAILABLE");
  }
}
