package com.witt.bankwitt.delegate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.witt.bankwitt.entities.User;
import com.witt.bankwitt.repositories.UserRepository;

@Component
public class UsersDelegate {

	@Autowired
	UserRepository userRepo;
	
	public User[] getAll() {
		List<User> users = new ArrayList<User>();
		Iterable<User> allUsers = userRepo.findAll();
		
		for(User user: allUsers) {
			users.add(user);
		}
    	return users.toArray(new User[users.size()]);
	}

	public User getUser(Integer id) {
		return userRepo.findBy(id);
	}

}
