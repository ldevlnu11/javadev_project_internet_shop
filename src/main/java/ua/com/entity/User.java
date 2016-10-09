package ua.com.entity;

import javax.persistence.*;

/**
 * Created by devnull on 09.10.16.
 */
@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    @Column(nullable = false, columnDefinition = "NCHAR(30)")
    private String firstname;
    @Column(nullable = false, columnDefinition = "NCHAR(30)")
    private String secondname;
    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private String email;
    private String phone;
    @Column(nullable = false)
    private String password;

    public User(){
    }

    public User(String firstname, String secondname, String login, String email, String phone, String password){
        this.firstname = firstname;
        this.secondname = secondname;
        this.login = login;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public long getID(){
        return ID;
    }

    public void setID(long ID){
        this.ID = ID;
    }

    public String getFirstname(){
        return firstname;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public String getSecondname(){
        return secondname;
    }

    public void setSecondname(String secondname){
        this.secondname = secondname;
    }

    public String getLogin(){
        return login;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public String toString(){
        return "UserInterface{" +
                "firstname='" + firstname + '\'' +
                ", secondname='" + secondname + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
