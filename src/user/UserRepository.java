package user;


public class UserRepository {
	private User [] userRepository ;
	private int size;
	private int lenght;

	
	public UserRepository(int size) {
		this.userRepository = new User [size];
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
			str += userRepository[i] + " ";
		}
		str = str + "]";
		return str;
	}
	
	public int get(User user) {
		int i=0;
		if (userRepository != null) {
			if (lenght > 0) {
				for (i=0; i<lenght; i++) {
					if (userRepository[i].equals(user)) {
						return i;
					}
				}
			}
		}
		return -1;
	}
	
	public boolean exist(User user) {
		boolean exist = false;
		
		if (get(user) != -1) {
			exist = true;
		}
		
		return exist;
	}
	
	public boolean add (User user) {
		boolean operation = false;
		if (userRepository != null) {
			if (lenght < size && !exist(user)) {
				userRepository[lenght] = user;
				lenght += 1;
				operation = true;
			}
		}
			
		return operation;
	}
	
	public boolean remove (User user) {
		boolean operation = false;
		if (userRepository != null) {
			int index = get(user);
			if(index != -1) {
				userRepository[index] = null;
				for (int i=index; i<lenght; i++) {
					userRepository[i] = userRepository[i+1];
				}
				lenght = lenght-1;
				operation = true;
			}
		}
		return operation;
	}
	
	

}
