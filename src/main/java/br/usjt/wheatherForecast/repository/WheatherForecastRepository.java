package br.usjt.wheatherForecast.repository;

import br.usjt.wheatherForecast.model.entity.WheatherForecast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WheatherForecastRepository extends JpaRepository<WheatherForecast, Long> {

}