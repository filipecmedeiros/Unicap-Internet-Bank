package account;

public class AccountsRepository {
	private AbstractAccount [] accountsRepository ;
	private int size;
	private int lenght;
	
	public AccountsRepository (int size) {
		this.accountsRepository = new AbstractAccount [size];
		this.size = size;
		this.lenght = 0;
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
		for (int i=0; i<getLenght(); i++) {
			str += accountsRepository[i] + " ";
		}
		str += "]";
		return str;
	}
	
	public int get(AbstractAccount account) {
		int i=0;
		if (accountsRepository != null) {
			if (lenght > 0) {
				for (i=0; i<lenght; i++) {
					if (accountsRepository[i].equals(account)) {
						return i;
					}
				}
			}
		}
		return -1;
	}
	
	public boolean exist(AbstractAccount account) {
		boolean exist = false;
		
		if (get(account) != -1) {
			exist = true;
		}
		
		return exist;
	}
	
	public boolean add (AbstractAccount account) {
		boolean operation = false;
		if (accountsRepository != null) {
			if (lenght < size && !exist(account)) {
				accountsRepository[lenght] = account;
				lenght += 1;
				operation = true;
			}
		}
			
		return operation;
	}
	
	public boolean remove (AbstractAccount account) {
		boolean operation = false;
		if (accountsRepository != null) {
			int index = get(account);
			if(index != -1) {
				accountsRepository[index] = null;
				for (int i=index; i<lenght; i++) {
					accountsRepository[i] = accountsRepository[i+1];
				}
				lenght = lenght-1;
				operation = true;
			}
		}
		return operation;
	}
	
}
