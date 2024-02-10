package com.example.mapping.dto;

import com.example.mapping.model.Country;

public class StateDTO {
	   private int stateId;
	    private String stateName;
	    private Country country;
		public int getStateId() {
			return stateId;
		}
		public void setStateId(int stateId) {
			this.stateId = stateId;
		}
		public String getStateName() {
			return stateName;
		}
		public void setStateName(String stateName) {
			this.stateName = stateName;
		}
		public Country getCountry() {
			return country;
		}
		public void setCountry(Country country) {
			this.country = country;
		}
		public StateDTO(int stateId, String stateName, Country country) {
			super();
			this.stateId = stateId;
			this.stateName = stateName;
			this.country = country;
		}
		public StateDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "StateDTO [stateId=" + stateId + ", stateName=" + stateName + ", country=" + country + "]";
		}
	    
}
