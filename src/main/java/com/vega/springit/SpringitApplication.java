package com.vega.springit;

import com.vega.springit.config.SpringitProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(SpringitProperties.class)
public class SpringitApplication {

  public static void main(String[] args) {

    SpringApplication.run(SpringitApplication.class, args);

  }

}
