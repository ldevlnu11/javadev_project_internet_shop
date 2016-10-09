package ua.com.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by devnull on 08.10.16.
 */
@Entity
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    @Column(nullable = false, columnDefinition = "NCHAR(128)")
    private String firstname;
    @Column(nullable = false, columnDefinition = "NCHAR(128)")
    private String secondname;
    @Column(columnDefinition = "NCHAR(128)")
    private String fathername;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false, columnDefinition = "NCHAR(128)")
    private String city;
    @Column(columnDefinition = "NCHAR(128)")
    private String province; // область
    @Column(columnDefinition = "NCHAR(128)")
    private String region; // район
    @Column(columnDefinition = "NCHAR(128)")
    private String street;
    private int number;
    @OneToMany(mappedBy = "customer")
    private List<Offer> offerList = new ArrayList<Offer>();


    public Customer(){
    }

    public Customer(String firstname, String secondname, String fathername, String phone, String city, String province, String region, String street, int number){
        this.firstname = firstname;
        this.secondname = secondname;
        this.fathername = fathername;
        this.phone = phone;
        this.city = city;
        this.province = province;
        this.region = region;
        this.street = street;
        this.number = number;
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

    public String getFathername(){
        return fathername;
    }

    public void setFathername(String fathername){
        this.fathername = fathername;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getProvince(){
        return province;
    }

    public void setProvince(String province){
        this.province = province;
    }

    public String getRegion(){
        return region;
    }

    public void setRegion(String region){
        this.region = region;
    }

    public String getStreet(){
        return street;
    }

    public void setStreet(String street){
        this.street = street;
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public List<Offer> getOfferList(){
        return offerList;
    }

    public void setOfferList(List<Offer> offerList){
        this.offerList = offerList;
    }

    @Override
    public String toString(){
        return "\n"+"Customer{" +
                "firstname='" + firstname + '\'' +
                ", secondname='" + secondname + '\'' +
                ", fathername='" + fathername + '\'' +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", region='" + region + '\'' +
                ", street='" + street + '\'' +
                ", number=" + number +
                '}';
    }
}
