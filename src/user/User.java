package user;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;


public class User {
    private SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    private String name;
    private String cpf;
    private Date age;


    public User(String name, String cpf, String age) {
        this.name = name;
        this.cpf = cpf;
        try {
            this.age = DATE_FORMAT.parse(age);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
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
        return DATE_FORMAT.format(this.age);
    }

    public void setAge(String age) {
        try {
            this.age = DATE_FORMAT.parse(age);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}