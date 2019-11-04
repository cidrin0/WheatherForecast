package br.usjt.wheatherForecast.repository;

import br.usjt.wheatherForecast.model.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Query("SELECT C FROM City C WHERE name LIKE concat(?1 , '%') ")
    Collection<City> findAllByNameStartWith(String name);

    City findByLatitudeAndLongitude(Long latitude, Long longitude);
}