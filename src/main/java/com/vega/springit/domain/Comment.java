package com.vega.springit.domain;

import com.vega.springit.service.BeanUtil;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.ocpsoft.prettytime.PrettyTime;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Comment extends Auditable{

  @Id
  @GeneratedValue
  private Long id;
  @NonNull
  private String body;



  // link
  @ManyToOne
  @NonNull
  private Link link;

  public String getPrettyTime() {
    PrettyTime pt = BeanUtil.getBean(PrettyTime.class);
    return pt.format(convertToDateViaInstant(getCreationDate()));
  }

  private Date convertToDateViaInstant(LocalDateTime dateToConvert) {
    return java.util.Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
  }

}
