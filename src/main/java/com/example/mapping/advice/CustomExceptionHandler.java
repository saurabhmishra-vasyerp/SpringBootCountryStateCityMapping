package com.example.mapping.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.mapping.dto.ResponseDTO;
import com.example.mapping.exception.CityNotFoundException;
import com.example.mapping.exception.CountryNotFoundException;
import com.example.mapping.exception.StateNotFoundException;

@RestControllerAdvice
public class CustomExceptionHandler {
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public ResponseDTO countryNotFoundExceptionHandler(CountryNotFoundException ex){
        return new ResponseDTO(400, "FAILURE", ex.getMessage());
    }
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public ResponseDTO StateNotFoundExceptionHandler(StateNotFoundException ex){
        return new ResponseDTO(400, "FAILURE", ex.getMessage());
    }
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public ResponseDTO CityNotFoundExceptionHandler(CityNotFoundException ex){
        return new ResponseDTO(400, "FAILURE", ex.getMessage());
    }

}
