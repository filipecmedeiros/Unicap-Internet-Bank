package br.unicap.bank.data;


public interface IRep <T> {
	
	void create(T o);
	
	T read(String s);
	
	void update (T o);
	
	void delete(T o);

	boolean exists(T o);
}
