package com.vega.springit.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor
@Data
public class Comment extends Auditable{

  @Id
  @GeneratedValue
  private Long id;
  @NonNull
  private String body;

  public Comment(@NonNull String body, @NonNull Link link) {
    this.body = body;
    this.link = link;
  }

  // link
  @ManyToOne
  @NonNull
  private Link link;

}
