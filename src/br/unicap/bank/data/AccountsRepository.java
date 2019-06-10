package br.unicap.bank.data;

import br.unicap.bank.model.AbstractAccount;

public class AccountsRepository extends ArrayRepository <AbstractAccount> implements IRepAbstractAccount{

	public AccountsRepository(int lenght) {
		super(lenght);
	}
	
}
