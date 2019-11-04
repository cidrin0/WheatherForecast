package br.usjt.wheatherForecast.controller;

import br.usjt.wheatherForecast.model.entity.City;
import br.usjt.wheatherForecast.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

import static br.usjt.wheatherForecast.constants.Templates.CITIES_TEMPLATE;
import static br.usjt.wheatherForecast.constants.URIs.CITIES;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(CITIES)
public class CityController {

    @Autowired
    private CityService service;

    @GetMapping
    public ModelAndView getAll() {
        Collection<City> cities = service.findAllWheatherForecasts();

        ModelAndView modelAndView = new ModelAndView(CITIES_TEMPLATE);
        modelAndView.addObject("cities", cities);
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @GetMapping(params = {"name"})
    public ResponseEntity<Collection<City>> getByName(@RequestParam String name) {
        Collection<City> cities = service.findAllByNameStartWith(name);
        return ResponseEntity.ok(cities);
    }

    @GetMapping(params = {"latitude", "longitude"})
    public ResponseEntity<City> getByLocation(@RequestParam Long latitude, @RequestParam Long longitude) {
        City city = service.findByLatitudeAndLongitude(latitude, longitude);
        return ResponseEntity.ok(city);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseEntity<City> save(@RequestBody City city) {
        City ctySaved = service.save(city);
        URI uri = ServletUriComponentsBuilder.
                fromCurrentServletMapping().path("/{id}").
                buildAndExpand(ctySaved.getId()).
                toUri();
        return ResponseEntity.created(uri).body(ctySaved);
    }
}