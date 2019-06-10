package br.unicap.bank.model;

public class User {

    private String name;
    private String cpf;
    private String age;
    private UserKind kind;


    public User(String name, String cpf, String age) {
        this.name = name;
        this.cpf = cpf;
        this.age = age;
        this.kind = UserKind.STANDARD;
        
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setKind(int kind) {
        if(kind == 0){
            this.kind = UserKind.STANDARD;
        }
        if(kind == 1){
            this.kind = UserKind.VIP;
        }
        if(kind == 2){
            this.kind = UserKind.EXECUTIVO;
        }
    }

    public UserKind getKind() {
        return this.kind;
    }
    
    @Override
    public String toString () {
    	return this.cpf;
    }
    
    @Override
    public boolean equals(Object obj) {
    	boolean operation = false;
		if (obj instanceof User) {
			User user = (User) obj;
			operation = this.cpf.equals(user.cpf) && 
					this.name.equals(user.name) &&
					this.age.equals(user.age);
		}
		
		return operation;
    }
}