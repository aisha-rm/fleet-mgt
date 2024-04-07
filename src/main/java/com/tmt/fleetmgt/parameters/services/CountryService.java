package com.tmt.fleetmgt.parameters.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmt.fleetmgt.parameters.models.Country;
import com.tmt.fleetmgt.parameters.repositories.CountryRepository;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAll(){
        return countryRepository.findAll();
    }
    
    public void save(Country country){
        countryRepository.save(country);
    }

    public void delete(Integer id){
        countryRepository.deleteById(id);
    }

    public Country getCountryById(Integer id) {
        return countryRepository.findById(id).orElse(null);
    }
}
