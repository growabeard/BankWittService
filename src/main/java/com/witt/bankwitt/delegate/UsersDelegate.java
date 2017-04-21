package com.witt.bankwitt.delegate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.witt.bankwitt.entities.User;
import com.witt.bankwitt.repositories.UserRepository;
import com.witt.bankwitt.response.ReturnUser;

@Component
public class UsersDelegate {

	@Autowired
	UserRepository userRepo;
	
	public ReturnUser[] getAll() {
		List<ReturnUser> users = new ArrayList<ReturnUser>();
		Iterable<User> allUsers = userRepo.findAll();
		
		for(User user: allUsers) {
			ReturnUser returnUser = new ReturnUser();
			returnUser.setFirst(user.getFirst());
			returnUser.setLast(user.getLast());
			users.add(returnUser);
		}
    	return users.toArray(new ReturnUser[users.size()]);
	}

}
