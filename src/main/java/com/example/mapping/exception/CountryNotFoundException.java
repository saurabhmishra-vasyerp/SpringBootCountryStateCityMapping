package com.example.mapping.exception;

public class CountryNotFoundException extends RuntimeException{
	public CountryNotFoundException(){

    }
    public CountryNotFoundException(String message){
        super(message);
    }

}
