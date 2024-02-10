package com.example.mapping.service;

import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapping.dto.CountryDTO;
import com.example.mapping.exception.CountryNotFoundException;
import com.example.mapping.model.Country;
import com.example.mapping.repository.CountryRepository;
//import com.example.mapping.service.exception.CountryNotFoundException;

@Service
public class CountryServiceImpl implements CountryService {
	@Autowired
	private CountryRepository countryRepository;

	public CountryServiceImpl(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	@Override
	public List<CountryDTO> getAllCountries() {
		List<Country> countries = countryRepository.findAll();
		List<CountryDTO> countryDTOs = new ArrayList<>();
		for (Country country : countries) {
			CountryDTO countryDTO = new CountryDTO();
			countryDTO.setCountryId(country.getCountryId());
			countryDTO.setCountryName(country.getCountryName());
			countryDTOs.add(countryDTO);
		}
		// TODO Auto-generated method stub
		return countryDTOs;
	}

	@Override
	public CountryDTO getCountryById(int countryId) {
		// TODO Auto-generated method stub
		Country country = countryRepository.findById(countryId)
				.orElseThrow(() -> new CountryNotFoundException("Country Not Found With Id: " + countryId));
		CountryDTO countryDto = new CountryDTO();
		countryDto.setCountryId(country.getCountryId());
		countryDto.setCountryName(country.getCountryName());
		return countryDto;
	}

	@Override
	public void addCountry(CountryDTO countryDto) {
		// TODO Auto-generated method stub
		Country country = new Country();
		country.setCountryId(countryDto.getCountryId());
		country.setCountryName(countryDto.getCountryName());
		countryRepository.save(country);

	}

	@Override
	public void deleteById(int countryId) {
		// TODO Auto-generated method stub
		 if (!countryRepository.existsById(countryId)) {
		        throw new CountryNotFoundException("Country Not Found With Id: "+countryId);
		       }
		       countryRepository.deleteById(countryId);

	}

}
