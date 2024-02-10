package com.example.mapping.service;

import java.util.List;

import com.example.mapping.dto.StateDTO;

public interface StateService {
   
	List<StateDTO> getAllStatesByCountryId(int countryId);
    StateDTO getStateById(int stateId);
    void addstate(StateDTO stateDto);
    void deleteById(int stateId);
}
