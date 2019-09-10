package com.vega.springit;

import com.vega.springit.config.SpringitProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableConfigurationProperties(SpringitProperties.class)
@EnableJpaAuditing
public class SpringitApplication {

  private static final Logger log = LoggerFactory.getLogger(SpringitApplication.class);


  public static void main(String[] args) {
    SpringApplication.run(SpringitApplication.class, args);
  }

//  @Bean
//  CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository){
//    return args -> {
//      Link link = new Link("getting started with springboot 2","https://google.com");
//      linkRepository.save(link);
//
//      Comment comment = new Comment("This spring Boot 2 link is zuper!",link);
//      commentRepository.save(comment);
//      link.addComment(comment);
//
//      System.out.println("We just insert a link and a comment");
//      System.out.println("====================================");
//
//      Link firstLink = linkRepository.findByTitle("getting started with springboot 2");
//      System.out.println("title:" + firstLink.getTitle());
//
//    };
//  }




}
