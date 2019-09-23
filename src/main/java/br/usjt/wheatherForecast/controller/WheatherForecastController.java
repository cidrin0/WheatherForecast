package br.usjt.wheatherForecast.controller;

import br.usjt.wheatherForecast.model.entity.WheatherForecast;
import br.usjt.wheatherForecast.service.WheatherForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

import static br.usjt.wheatherForecast.constants.Templates.FORECAST_TEMPLATE;
import static br.usjt.wheatherForecast.constants.URIs.WHEATHER_FORECAST;

@RestController
@RequestMapping(WHEATHER_FORECAST)
public class WheatherForecastController {

    @Autowired
    private WheatherForecastService service;

    @GetMapping
    private ModelAndView getAll() {
        Collection<WheatherForecast> forecasts = service.findAllWheatherForecasts();

        ModelAndView modelAndView = new ModelAndView(FORECAST_TEMPLATE);
        modelAndView.addObject("forecasts", forecasts);
        modelAndView.addObject("forecast", new WheatherForecast());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView save(WheatherForecast wheatherForecast) {
        service.save(wheatherForecast);
        return getAll();
    }
}