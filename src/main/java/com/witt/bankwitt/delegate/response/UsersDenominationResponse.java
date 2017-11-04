package com.witt.bankwitt.delegate.response;

import java.util.List;

import com.witt.bankwitt.entities.Denomination;
import com.witt.bankwitt.entities.User;

public class UsersDenominationResponse {
	
	private List<Denomination> denominations;
	private User user;
	private String total;

	public void setUser(User thatUser) {
		this.user = thatUser;
	}

	public void setDenominations(List<Denomination> thatDenominations) {
		this.denominations = thatDenominations;
	}

	public List<Denomination> getDenominations() {
		return denominations;
	}

	public User getUser() {
		return user;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
	
}
