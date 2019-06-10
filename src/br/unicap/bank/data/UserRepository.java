package br.unicap.bank.data;

import br.unicap.bank.model.User;

public class UserRepository extends ArrayRepository<User> implements IRepUser{

	public UserRepository(int lenght) {
		super(lenght);
	}

}
