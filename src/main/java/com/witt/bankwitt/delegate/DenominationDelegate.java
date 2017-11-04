package com.witt.bankwitt.delegate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.witt.bankwitt.delegate.response.UsersDenominationResponse;
import com.witt.bankwitt.entities.Denomination;
import com.witt.bankwitt.repositories.DenominationRepository;

@Service
public class DenominationDelegate {

	@Autowired
	DenominationRepository denominationRepo;
	
	@Autowired
	UsersDelegate usersDelegate;
	
	public void saveAll(UsersDenominationResponse infoToSave) {
		for(Denomination denom : infoToSave.getDenominations()) {
			denominationRepo.save(denom);
		}
	}
	
	public UsersDenominationResponse getIndividualUserInfo(Integer id) {
		UsersDenominationResponse response = new UsersDenominationResponse();
		response.setUser(usersDelegate.getUser(id));
		getAll(id, response);
		return response;
	}
	
	private void getAll(Integer userId, UsersDenominationResponse response) {
		List<Denomination> returnDenominations = new ArrayList<Denomination>();
		Iterable<Denomination> allDenominations = denominationRepo.findAllByUserid(userId);
		Double totalOverall = 0.0;
		
		for(Denomination denomination: allDenominations) {
			Double totalInDenomination = computeTotal(denomination.getValue(), denomination.getCount());
			totalOverall = totalOverall + totalInDenomination;
			denomination.setTotal(totalInDenomination.toString());
			returnDenominations.add(denomination);
		}
		response.setDenominations(returnDenominations);
		response.setTotal(totalOverall.toString());
	}

	private Double computeTotal(Double value, Integer count) {
		
		return value * count;
	}
}
