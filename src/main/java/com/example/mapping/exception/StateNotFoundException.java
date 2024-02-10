package com.example.mapping.exception;

public class StateNotFoundException extends RuntimeException{
	   public StateNotFoundException(){

	    }
	    public StateNotFoundException(String message){
	        super(message);
	    }

}
