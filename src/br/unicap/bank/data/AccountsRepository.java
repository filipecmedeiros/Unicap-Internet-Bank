package br.unicap.bank.data;

import br.unicap.bank.model.AbstractAccount;

public class AccountsRepository extends ArrayRepository <AbstractAccount> implements IRepAccount{

	public AccountsRepository(int lenght) {
		super(lenght);
	}
	
}
