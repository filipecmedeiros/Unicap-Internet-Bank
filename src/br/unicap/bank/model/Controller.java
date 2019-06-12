package br.unicap.bank.model;

import br.unicap.bank.data.IRep;

public class Controller <T>{
	private IRep<T> repository;
	
	public Controller(IRep<T> rep) {
		this.repository = (IRep<T>) rep;
	}

	public IRep<T> getRepository() {
		return this.repository;
	}
	
	public void create(T o) throws Exception{
		if (!repository.exists((T) o)) {
			repository.create((T) o);
		}
		else {
			throw new Exception();
		}
	}
	
	public T read(String s) {
		return repository.read(s);
	}
	
	public void update(T o) {
		repository.update(o);
	}
	
	public void delete(T o) {
		repository.delete(o);
	}
}
