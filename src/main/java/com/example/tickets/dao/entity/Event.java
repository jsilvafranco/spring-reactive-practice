package com.example.tickets.dao.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author jsilva.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Event {

  @Id
  private String id;

  @TextIndexed
  private String country;
  private String category;

  private Date date;
  private String description;
  private Integer capacity;

  @CreatedDate
  private Date createdDate;
  @LastModifiedDate
  private Date lastModifiedDate;




}
