package com.tmt.fleetmgt.parameters.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.tmt.fleetmgt.parameters.models.Country;
import com.tmt.fleetmgt.parameters.services.CountryService;

@Controller
public class CountryController {
    
    @Autowired
    private CountryService countryService;

    
    @GetMapping("/countries")
    public String getAll(Model model) {
        List<Country> countries = countryService.getAll();
        model.addAttribute("countryList", countries);
        return "parameters/countryList";
    }

    @GetMapping("/addCountry")
    public String addCountry() {
        return "parameters/countryAdd";
    }
}
