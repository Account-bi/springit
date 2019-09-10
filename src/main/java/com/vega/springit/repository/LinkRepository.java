package com.vega.springit.repository;

import com.vega.springit.domain.Link;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link,Long> {

  Link findByTitle(String title);

  List<Link> findAllByTitleLikeOrderByCreationDate(String title);

}
