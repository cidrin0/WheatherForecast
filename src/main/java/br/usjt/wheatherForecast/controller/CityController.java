package br.usjt.wheatherForecast.controller;

import br.usjt.wheatherForecast.model.entity.City;
import br.usjt.wheatherForecast.model.entity.WheatherForecast;
import br.usjt.wheatherForecast.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

import static br.usjt.wheatherForecast.constants.Templates.CITIES_TEMPLATE;
import static br.usjt.wheatherForecast.constants.URIs.CITIES;

@RestController
@RequestMapping(CITIES)
public class CityController {

    @Autowired
    private CityService service;

    @GetMapping
    private ModelAndView getAll() {
        Collection<City> cities = service.findAllWheatherForecasts();

        ModelAndView modelAndView = new ModelAndView(CITIES_TEMPLATE);
        modelAndView.addObject("cities", cities);
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView save(City city) {
        service.save(city);
        return getAll();
    }
}