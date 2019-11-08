package com.opusmagus.jpa;

import org.springframework.data.repository.CrudRepository;

public interface CarsRepo extends CrudRepository<Car, Long> {
	//Car findById(Long id);
}