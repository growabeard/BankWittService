package com.witt.bankwitt.repositories;

import org.springframework.data.repository.CrudRepository;

import com.witt.bankwitt.entities.User;


public interface UserRepository extends CrudRepository<User, Integer> {

}
