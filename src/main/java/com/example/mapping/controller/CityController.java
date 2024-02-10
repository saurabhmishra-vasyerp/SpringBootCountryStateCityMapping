package com.example.mapping.controller;

import java.util.List;



import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapping.dto.CityDTO;
import com.example.mapping.dto.ResponseDTO;
import com.example.mapping.model.Country;
import com.example.mapping.model.State;
import com.example.mapping.service.CityService;

@RestController
@RequestMapping("/api/country/{countryId}/state/{stateId}")
public class CityController {

	private CityService cityService;

	public CityController(CityService cityService) {
		this.cityService = cityService;
	}

	@GetMapping("/city")
	public ResponseDTO getAllCitiesByStateId(@PathVariable int stateId) {
		List<CityDTO> cities = cityService.getAllCitiesByStateId(stateId);
		return new ResponseDTO(200, "Success", cities);
	}

	@GetMapping("/city/{cityId}")
	public ResponseDTO getCityByID(@PathVariable int cityId) {
		CityDTO citydto = cityService.getCityById(cityId);
		return new ResponseDTO(200, "Success", citydto);
	}

	@PostMapping("/city")
	public ResponseDTO addCity(@RequestBody CityDTO cityDto, @PathVariable int stateId, @PathVariable int countryId) {
		cityDto.setState(new State(stateId, "", new Country(countryId, "")));
		cityService.addCity(cityDto);
		return new ResponseDTO(200, "Success", "ADD Successfull");
	}

	@DeleteMapping("/city/{cityId}")
	public ResponseDTO deleteCity(@PathVariable int cityId) {
		cityService.deleteById(cityId);
		return new ResponseDTO(200, "Success", "Delete Successfull");

	}

}
