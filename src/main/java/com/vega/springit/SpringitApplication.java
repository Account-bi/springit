package com.vega.springit;

import com.vega.springit.config.SpringitProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@EnableConfigurationProperties(SpringitProperties.class)
public class SpringitApplication {

  @Autowired
  private SpringitProperties springitProperties;

  @Autowired
  private ApplicationContext applicationContext;

  public static void main(String[] args) {

    SpringApplication.run(SpringitApplication.class, args);


  }

  @Bean
  @Profile("dev")
  CommandLineRunner runner(){
      return args -> {
        System.out.println("Printing out all the bean names in the application context");
        System.out.println("----------------------------------------------------------");
        String[] beans = applicationContext.getBeanDefinitionNames();
      };
  }

}
