package br.unicap.bank.data;

public abstract class ArrayRepository <T> implements IRep<T>{
	private T [] array ;
	private int size;
	private int lenght;
	
	@SuppressWarnings("unchecked")
	public ArrayRepository (int lenght) {
		this.array = (T []) new Object [lenght];
		this.lenght = lenght;
		this.size = 0;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public int getLenght() {
		return this.lenght;
	}
	
	public void setLenght(int lenght) {
		this.lenght = lenght;
	}
	
	
	public String toString() {
		String str = "[ ";
		for (int i=0; i<getSize(); i++) {
			str += array[i] + " ";
		}
		str += "]";
		return str;
	}
	
	private int getIndex(T o) {
		int index = 0;
		if (array != null) {
			for (index=0; index<size; index++) {
				if (array[index].equals(o)) {
					break;
				}
			}
		}
		else {
			index = size;
		}
		return index;
	}
	
	public boolean exists(T o) {
		boolean exists = false;
		
		for (int i=0; i<size; i++) {
			if (array[i].equals(o)){
				exists=true;
				break;
			}
		}
		
		return exists;
	}
	
	public void create (T o) {
		if (array != null) {
			if (size < lenght) {
				array[size] = o;
				size += 1;
			}
		}
	}
	
	public T read (String s) {
		int i=0;
		if (array != null) {
			if (size > 0) {
				for (i=0; i<size; i++) {
					if (array[i].toString().equals(s)) {
						return array[i];
					}
				}
			}
		}
		return null;
	}
	
	public void update (T o) {
		int index = getIndex(o);
		
		if (index != size) {
			array[index] = o;
		}
	}
	
	public void delete (T o) {
		int index = getIndex(o);
		
		if(index != size) {
			array[index] = null;
			for (int i=index; i<size; i++) {
				array[i] = array[i+1];
			}
			size = size-1;
		}
	}
}
