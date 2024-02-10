package com.example.mapping.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapping.dto.CountryDTO;
import com.example.mapping.dto.ResponseDTO;
import com.example.mapping.service.CountryService;

@RestController
@RequestMapping("/api")
public class CountryController {
	 private CountryService countryService;
	    public CountryController(CountryService countryService ){
	        this.countryService=countryService;
	    }
	    
	    @GetMapping("/country")
	    public ResponseDTO getAllCountries(){
	        List <CountryDTO> countries = countryService.getAllCountries();
	        return new ResponseDTO(200, "SUCCESS", countries);
	    }
	    @GetMapping("/country/{countryId}")
	    public ResponseDTO getCountryById(@PathVariable  int countryId){
	        CountryDTO countrydto = countryService.getCountryById(countryId);
	        return new ResponseDTO(200, "SUCCESS", countrydto);
	    }
	    @DeleteMapping("/country/{countryId}")
	    public ResponseDTO deleteCountryById(@PathVariable  int countryId){
	        countryService.deleteById(countryId);
	        return new ResponseDTO(200, "SUCCESS", "DELETE SUCCESSFULL");
	    }
	    @PostMapping("/country")
	    public ResponseDTO addCountry(@RequestBody CountryDTO countryDto){
	        countryService.addCountry(countryDto);
	        return new ResponseDTO(200, "SUCCESS", "ADD SUCCESSFULL");
	  }
	 
}
