package com.example.demo.controller;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoController {

    CustomerDAO customerDAO;
    @GetMapping("/view")
    public ModelAndView allCustomersView(){
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1,"im","Bucharest","Romania"));
        customers.add(new Customer(2,"gonna","Bucharest","Romania"));
        customers.add(new Customer(3,"kis","Bucharest","Romania"));
        ModelAndView modelAndView = new ModelAndView("view-page");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
    @GetMapping("/{country}")
    public ModelAndView getBycountry(@PathVariable String country)
    {
        ModelAndView modelAndView = new ModelAndView("view-page");
        modelAndView.addObject("customers", customerDAO.getALLByCountry(country));
        return modelAndView;
    }
    @GetMapping("/{city}")
    public ModelAndView getBycity(@PathVariable String city)
    {
        ModelAndView modelAndView = new ModelAndView("view-page");
        modelAndView.addObject("customers", customerDAO.getALLByCity(city));
        return modelAndView;
    }
    @GetMapping("/{username}")
    public ModelAndView getByusername(@PathVariable String username)
    {
        ModelAndView modelAndView = new ModelAndView("view-page");
        modelAndView.addObject("customers", customerDAO.getALLByUsername(username));
        return modelAndView;
    }
}
