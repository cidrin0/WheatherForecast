package br.usjt.wheatherForecast.controller;

import br.usjt.wheatherForecast.model.entity.User;
import br.usjt.wheatherForecast.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static br.usjt.wheatherForecast.constants.URIs.WHEATHER_FORECAST;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("login");
        mv.addObject("user", new User());
        return mv;
    }

    @PostMapping("/doLogin")
    public String doLogin(HttpServletRequest request, User user) {
        if (loginService.doLogin(user)) {
            request.getSession().setAttribute("userActiveSession", user);
            return "redirect:" + WHEATHER_FORECAST;
        } else {
            return "login";
        }
    }
}