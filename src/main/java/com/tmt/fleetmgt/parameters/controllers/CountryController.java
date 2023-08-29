package com.tmt.fleetmgt.parameters.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @PostMapping("/countries")  //use same url as the countryList to wh it will be added
    public String save(Country country) {
        countryService.save(country);
        return "redirect:/countries";   //redirect to return updated country list
    }

    @RequestMapping(value = "/countries/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    //did not use delete mapping because the delete button on html page does a get request first thus throws error
    public String delete(@PathVariable Integer id){
        countryService.delete(id);
        return "redirect:/countries";
    }
}
