package br.usjt.wheatherForecast.service;

import br.usjt.wheatherForecast.model.entity.WheatherForecast;
import br.usjt.wheatherForecast.repository.WheatherForecastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class WheatherForecastService {

    @Autowired
    private WheatherForecastRepository repository;

    public Collection<WheatherForecast> findAllWheatherForecasts() {
        return repository.findAll();
    }

    public void save(WheatherForecast wheatherForecast) {
        repository.save(wheatherForecast);
    }
}
