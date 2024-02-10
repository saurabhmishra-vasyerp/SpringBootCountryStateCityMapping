package com.example.mapping.service;

import java.util.List;

import com.example.mapping.dto.CityDTO;

public interface CityService {
	List<CityDTO> getAllCitiesByStateId(int stateId);

	CityDTO getCityById(int cityId);

	void addCity(CityDTO cityDTO);

	void deleteById(int cityId);

}
