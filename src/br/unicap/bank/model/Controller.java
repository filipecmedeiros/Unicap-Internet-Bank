package br.unicap.bank.model;

import br.unicap.bank.data.IRep;

public class Controller <T>{
	private IRep repository;
	
	public Controller(IRep rep) {
		this.repository = rep;
	}
	
	public IRep getRepository() {
		return this.repository;
	}
	
	public void create(T o) throws Exception{
		if (!repository.exists(o)) {
			repository.create(o);
		}
		else {
			throw new Exception();
		}
	}
	
	public T read(String s) {
		return (T) repository.read(s);
	}
	
	public void update(T o) {
		repository.update(o);
	}
	
	public void delete(T o) {
		repository.delete(o);
	}
}
