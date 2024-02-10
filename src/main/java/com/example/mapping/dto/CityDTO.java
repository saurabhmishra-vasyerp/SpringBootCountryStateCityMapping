package com.example.mapping.dto;

import com.example.mapping.model.State;

public class CityDTO {
	  private int cityId;
	    private String cityName;
	    private State state;
		public int getCityId() {
			return cityId;
		}
		public void setCityId(int cityId) {
			this.cityId = cityId;
		}
		public String getCityName() {
			return cityName;
		}
		public void setCityName(String cityName) {
			this.cityName = cityName;
		}
		public State getState() {
			return state;
		}
		public void setState(State state) {
			this.state = state;
		}
		public CityDTO(int cityId, String cityName, State state) {
			super();
			this.cityId = cityId;
			this.cityName = cityName;
			this.state = state;
		}
		public CityDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "CityDTO [cityId=" + cityId + ", cityName=" + cityName + ", state=" + state + "]";
		}
	    
	    
}
