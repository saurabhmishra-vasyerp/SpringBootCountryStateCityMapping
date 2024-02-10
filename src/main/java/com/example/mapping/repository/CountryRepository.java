package com.example.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mapping.model.Country;
@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>{

}
