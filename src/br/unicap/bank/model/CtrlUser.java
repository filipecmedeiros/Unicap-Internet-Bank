package br.unicap.bank.model;

import br.unicap.bank.data.IRepUser;

public class CtrlUser {
	private IRepUser users;
	
	public CtrlUser(IRepUser rep) {
		this.users = rep;
	}

	public void create (User user) throws Exception {
		if (!users.exists(user)) {
			users.create(user);
		}
		else {
			throw new Exception();
		}
	}
	
	public User read (String id) {
		return users.read(id);
	}
	
	public void update (User user) {
		users.update(user);
	}
	
	public void delete (User user) {
		users.delete(user);
	}
}
