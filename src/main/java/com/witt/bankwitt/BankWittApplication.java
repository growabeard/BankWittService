package com.witt.bankwitt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.witt.bankwitt.delegate.DenominationDelegate;
import com.witt.bankwitt.delegate.UsersDelegate;
import com.witt.bankwitt.delegate.response.UsersDenominationResponse;
import com.witt.bankwitt.entities.User;

@SpringBootApplication
@Controller
public class BankWittApplication {
	
	@Autowired
	UsersDelegate usersDelegate;
	@Autowired
	DenominationDelegate denominationsDelegate;
	
	@RequestMapping("/users")
    @ResponseBody
    ResponseEntity<User[]> usersEnpoint() {
   		System.out.println("Looking up users");
    	User[] returnUsers = usersDelegate.getAll();
    	return new ResponseEntity<User[]>(returnUsers, HttpStatus.OK);
    }
    
    @RequestMapping("/denominations")
    @ResponseBody
    ResponseEntity<UsersDenominationResponse> getDenominationByUser(@RequestParam(value="userId", required=true) Integer id) {
   		System.out.println("Looking up users");
   		UsersDenominationResponse individualUserInfo = denominationsDelegate.getIndividualUserInfo(id);
    	return new ResponseEntity<UsersDenominationResponse>(individualUserInfo, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/savedenominations", method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<UsersDenominationResponse> saveDenominationByUser(@RequestBody(value="denomination", required=true) UsersDenominationResponse input) {
   		System.out.println("Looking up users");
   		denominationsDelegate.saveAll(input);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
	public static void main(String[] args) {
		SpringApplication.run(BankWittApplication.class, args);
	}
}
