package br.usjt.wheatherForecast.service;

import br.usjt.wheatherForecast.model.entity.City;
import br.usjt.wheatherForecast.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    public Collection<City> findAllWheatherForecasts() {
        return repository.findAll();
    }

    public City save(City wheatherForecast) {
        return repository.save(wheatherForecast);
    }

    public Collection<City> findAllByNameStartWith(String name) {
        return repository.findAllByNameStartWith(name);
    }

    public City findByLatitudeAndLongitude(Long latitude, Long longitude) {
        return repository.findByLatitudeAndLongitude(latitude, longitude);
    }
}
