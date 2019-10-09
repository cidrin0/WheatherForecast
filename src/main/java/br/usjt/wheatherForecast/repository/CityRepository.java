package br.usjt.wheatherForecast.repository;

import br.usjt.wheatherForecast.model.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}