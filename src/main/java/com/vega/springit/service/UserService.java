package com.vega.springit.service;

import com.vega.springit.domain.User;
import com.vega.springit.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

  private final Logger logger = LoggerFactory.getLogger(UserService.class);

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User register(User user) {
     return userRepository.save(user);
  }

  public User save(User user){return userRepository.save(user);}

  @Transactional
  public void saveUsers(User... users){

    for(User user : users){
      logger.info("Saving User: "+user.getEmail());
      userRepository.save(user);
    }
  }

}
