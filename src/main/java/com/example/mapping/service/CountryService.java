package com.example.mapping.service;

import java.util.List;

import com.example.mapping.dto.CountryDTO;

public interface CountryService {

	List<CountryDTO> getAllCountries();

	CountryDTO getCountryById(int countryId);

	void addCountry(CountryDTO countryDto);

	void deleteById(int countryId);
}
