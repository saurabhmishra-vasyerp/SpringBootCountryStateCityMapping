package com.example.mapping.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapping.dto.StateDTO;
import com.example.mapping.model.State;
import com.example.mapping.repository.StateRepository;

@Service
public class StateServiceImpl implements StateService {
	@Autowired
	private StateRepository stateRepository;

	public StateServiceImpl(StateRepository stateRepository) {
		this.stateRepository = stateRepository;
	}

	@Override
	public List<StateDTO> getAllStatesByCountryId(int countryId) {
		// TODO Auto-generated method stub
		List<State> states = stateRepository.findStatesByCountryId(countryId);
		List<StateDTO> stateDtos = new ArrayList<>();
		for (State state : states) {
			StateDTO stateDto = new StateDTO();
			stateDto.setStateId(state.getStateId());
			stateDto.setStateName(state.getStateName());
			stateDto.setCountry(state.getCountry());
			stateDtos.add(stateDto);
		}
		return stateDtos;
	}

	@Override
	public StateDTO getStateById(int stateId) {
		// TODO Auto-generated method stub

		State state = stateRepository.findById(stateId).get();
		StateDTO stateDto = new StateDTO();
		stateDto.setStateId(state.getStateId());
		stateDto.setStateName(state.getStateName());
		stateDto.setCountry(state.getCountry());
		return stateDto;
	}

	@Override
	public void addstate(StateDTO stateDto) {
		// TODO Auto-generated method stub
		State state = new State();
		state.setStateId(stateDto.getStateId());
		state.setStateName(stateDto.getStateName());
		state.setCountry(stateDto.getCountry());
		stateRepository.save(state);
	}

	@Override
	public void deleteById(int stateId) {
		// TODO Auto-generated method stub
		stateRepository.deleteById(stateId);
	}

}
