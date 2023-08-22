package com.tmt.fleetmgt.parameters.services;

import java.util.List;

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
    
}
