package com.example.mapping.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapping.dto.ResponseDTO;
import com.example.mapping.dto.StateDTO;
import com.example.mapping.model.Country;
import com.example.mapping.service.StateService;

@RestController
@RequestMapping("/api/country/{countryId}")
public class StateController {
	private StateService stateService;
    public StateController(StateService stateService){
        this.stateService= stateService;
    }
    @GetMapping("/state")
    public ResponseDTO getAllStatesByCountry(@PathVariable int countryId){
         List <StateDTO> states = stateService.getAllStatesByCountryId(countryId);
        return new ResponseDTO(200, "SUCCESS", states);
    }
    @GetMapping("/state/{stateId}")
    public ResponseDTO getStateById(@PathVariable int stateId){
        StateDTO stateDto = stateService.getStateById(stateId);
        return new ResponseDTO(200, "SUCCESS", stateDto);
    }

    @PostMapping("/state")
    public ResponseDTO addState(@RequestBody StateDTO stateDto,@PathVariable int countryId ){
        stateDto.setCountry(new Country(countryId, "null"));
        stateService.addstate(stateDto);
        return new ResponseDTO(200, "SUCCESS", "ADD SUCCESSFULL");
    }
    
    @DeleteMapping("/state/{stateId}")
    public ResponseDTO deleteStateById(@PathVariable int stateId){
        stateService.deleteById(stateId);
        return new ResponseDTO(200, "SUCCESS", "DELETE SUCCESSFULL");
    }
}
