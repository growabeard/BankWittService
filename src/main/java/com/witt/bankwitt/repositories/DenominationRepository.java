package com.witt.bankwitt.repositories;

import org.springframework.data.repository.CrudRepository;

import com.witt.bankwitt.entities.Denomination;

public interface DenominationRepository extends CrudRepository<Denomination, Integer> {

	Iterable<Denomination> findAllByUseridByOrderByValueAsc(Integer id);
	
}
