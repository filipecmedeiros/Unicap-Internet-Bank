package br.unicap.bank.data;

import java.util.HashMap;
import java.util.Map;

import br.unicap.bank.model.User;

public class UserHashMapRepository implements IRepUser{
	private Map<String, User> hash;
	
	public UserHashMapRepository() {
		this.hash = new HashMap<String,User>();
	}
	
	@Override
	public void create(User o) {
		hash.put(o.getCpf(), o);
	}

	@Override
	public User read(String s) {
		return hash.get(s);
	}

	@Override
	public void update(User o) {
		hash.remove(o);
		hash.put(o.getCpf(), o);
	}

	@Override
	public void delete(User o) {
		hash.remove(o);
	}

	@Override
	public boolean exists(User o) {
		boolean exists = false;
		if (hash.get(o) != null) {
			exists = true;
		}
		return exists;
	}
	

}
