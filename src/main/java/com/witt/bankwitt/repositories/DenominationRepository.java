package com.witt.bankwitt.repositories;

import org.springframework.data.repository.CrudRepository;

import com.witt.bankwitt.entities.Denomination;

public interface DenominationRepository extends CrudRepository<Denomination, Integer> {

	Denomination findBy(String id);
	
	Iterable<Denomination> findAll();
	
	Iterable<Denomination> findAllByUserId(Integer id);
	
	Denomination save(Denomination entity);
}
