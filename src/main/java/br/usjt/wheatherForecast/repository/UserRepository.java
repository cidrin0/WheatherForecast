package br.usjt.wheatherForecast.repository;

import br.usjt.wheatherForecast.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findOneByLoginAndPassword(String login, String password);
}