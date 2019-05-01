package account;

public class AccountsRepository {
	private Account [] accountsRepository ;
	private int size;
	private int lenght;
	
	public AccountsRepository (int size) {
		this.accountsRepository = new Account [size];
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
	
	
	public void print() {
		System.out.print("[ ");
		for (int i=0; i<getLenght(); i++) {
			System.out.print(accountsRepository[i] + ", ");
		}
		System.out.println("]");
	}
	
	public int get(Account account) {
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
	
	public boolean exist(Account account) {
		boolean exist = false;
		
		if (get(account) != -1) {
			exist = true;
		}
		
		return exist;
	}
	
	public boolean add (Account account) {
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
	
	public boolean remove (Account account) {
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
