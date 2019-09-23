package br.usjt.wheatherForecast.service;

import br.usjt.wheatherForecast.model.entity.User;
import br.usjt.wheatherForecast.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    UserRepository repository;

    public boolean doLogin(User user) {
        return repository.findOneByLoginAndPassword(user.getLogin(), user.getPassword()) != null;
    }
}