package com.witt.bankwitt.repositories;

import org.springframework.data.repository.CrudRepository;

import com.witt.bankwitt.entities.Denomination;

public interface DenominationRepository extends CrudRepository<Denomination, Integer> {

	Denomination findBy(Integer id);
	
	Iterable<Denomination> findAll();
	
	Iterable<Denomination> findAllByUserid(Integer id);
	
	Denomination save(Denomination entity);
}
