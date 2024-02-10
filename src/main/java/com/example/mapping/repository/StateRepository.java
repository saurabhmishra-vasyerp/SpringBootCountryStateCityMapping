package com.example.mapping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.mapping.model.State;
@Repository
public interface StateRepository extends JpaRepository<State, Integer> {
	 @Query(value = "select * from state s where s.country_id=?1", nativeQuery = true)
	    public  List<State> findStatesByCountryId(int countryId);
}
