package com.vega.springit.config;

import com.vega.springit.domain.User;
import java.util.Optional;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuditorAwareImpl implements AuditorAware<String> {

  @Override
  public Optional<String> getCurrentAuditor() {
    if(SecurityContextHolder.getContext().getAuthentication() == null){
      return Optional.of("master@gmail.com");
    }
    return Optional.of(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getEmail());
  }
}
