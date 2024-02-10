package com.example.mapping.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapping.dto.CityDTO;
import com.example.mapping.exception.CityNotFoundException;
import com.example.mapping.model.City;
import com.example.mapping.repository.CityRepository;
@Service
public class CityServiceImpl implements CityService {
	@Autowired
	private CityRepository cityRepository;

	public CityServiceImpl(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	@Override
	public List<CityDTO> getAllCitiesByStateId(int stateId) {
		// TODO Auto-generated method stub
		List<City> cities = cityRepository.findCitiesByStateId(stateId);
		List<CityDTO> cityDtos = new ArrayList<>();
		for (City city : cities) {
			CityDTO cityDto = new CityDTO();
			cityDto.setCityId(city.getCityId());
			cityDto.setCityName(city.getCityName());
			cityDto.setState(city.getState());
			cityDtos.add(cityDto);
		}
		return cityDtos;
	}

	@Override
	public CityDTO getCityById(int cityId) {
		// TODO Auto-generated method stub
		City city = cityRepository.findById(cityId).get();
		CityDTO cityDto = new CityDTO();
		cityDto.setCityId(city.getCityId());
		cityDto.setCityName(city.getCityName());
		cityDto.setState(city.getState());
		return cityDto;

	}

	@Override
	public void addCity(CityDTO cityDTO) {
		// TODO Auto-generated method stub
		City city = new City();
		city.setCityId(cityDTO.getCityId());
		city.setCityName(cityDTO.getCityName());
		city.setState(cityDTO.getState());
		cityRepository.save(city);

	}

	@Override
	public void deleteById(int cityId) {
		// TODO Auto-generated method stub
		if(!cityRepository.existsById(cityId)){
            throw new CityNotFoundException("City Not Found with Id"+cityId);
        }
        cityRepository.deleteById(cityId);

	}

}
