package com.witt.bankwitt.delegate.response;

import com.witt.bankwitt.entities.Denomination;
import com.witt.bankwitt.entities.User;

public class UsersDenominationResponse {
	
	private Denomination[] denominations;
	private User user;

	public void setUser(User thatUser) {
		this.user = thatUser;
	}

	public void setDenominations(Denomination[] thatDenominations) {
		this.denominations = thatDenominations;
	}

	public Denomination[] getDenominations() {
		return denominations;
	}

	public User getUser() {
		return user;
	}
	
}
