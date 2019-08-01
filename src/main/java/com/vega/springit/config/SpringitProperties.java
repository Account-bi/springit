package com.vega.springit.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "springit") // der prefix springit kann in dem property file verwendet werden
public class SpringitProperties {

  /**
   * This is the welcome message
   */

  private String welcomeMsg = "Guten Tag!";

  public String getWelcomeMsg() {
    return welcomeMsg;
  }

  public void setWelcomeMsg(String welcomeMsg) {
    this.welcomeMsg = welcomeMsg;
  }
}
