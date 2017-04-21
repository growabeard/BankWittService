package com.witt.bankwitt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.witt.bankwitt.delegate.UsersDelegate;
import com.witt.bankwitt.response.ReturnUser;

@SpringBootApplication
@Controller
public class BankWittApplication {
	
	@Autowired
	UsersDelegate usersDelegate;
	
	@RequestMapping("/users")
    @ResponseBody
    ResponseEntity<ReturnUser[]> foodListEnpoint() {
   		System.out.println("Looking up users");
    	ReturnUser[] returnUsers = usersDelegate.getAll();
    	return new ResponseEntity<ReturnUser[]>(returnUsers, HttpStatus.OK);
    }
    
	public static void main(String[] args) {
		SpringApplication.run(BankWittApplication.class, args);
	}
}
