package com.examen2.examen2.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examen2.examen2.models.User;
import com.examen2.examen2.repository.UserRepository;


@Service
public class UserService extends BaseService<User> {

  @Autowired
  UserRepository userRepository;

  public UserService(UserRepository repository) {
    super(repository);
  }

  public User findByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  // registrar el usuario y hacer Hash a su password
  public User registerUser(User user) {
    String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
    user.setPassword(hashed);
    return userRepository.save(user);
  }

  // autenticar usuario
  public boolean authenticateUser(String email, String password) {
    User user = userRepository.findByEmail(email);
    if (user == null) {
      return false;
    } else {
      if (BCrypt.checkpw(password, user.getPassword())) {
        return true;
      } else {
        return false;
      }
    }
  }
}
