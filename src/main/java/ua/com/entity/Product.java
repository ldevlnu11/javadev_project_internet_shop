package ua.com.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by devnull on 08.10.16.
 */
@Entity
public class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long product_ID;
    @Column(nullable = false, columnDefinition = "NCHAR(128)")
    private String product_name;
    @Column(nullable = false, columnDefinition = "NCHAR(128)")
    private String product_code;
    private float product_price;
    private int product_number;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "offer_product", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "offer_id"))
    private List<Offer> offerList;

    public Product(){
    }

    public Product(String product_name, String product_code, float product_price, int product_number){
        this.product_name = product_name;
        this.product_code = product_code;
        this.product_price = product_price;
        this.product_number = product_number;
    }

    public long getProduct_ID(){
        return product_ID;
    }

    public void setProduct_ID(long product_ID){
        this.product_ID = product_ID;
    }

    public String getProduct_name(){
        return product_name;
    }

    public void setProduct_name(String product_name){
        this.product_name = product_name;
    }

    public String getProduct_code(){
        return product_code;
    }

    public void setProduct_code(String product_code){
        this.product_code = product_code;
    }

    public float getProduct_price(){
        return product_price;
    }

    public void setProduct_price(float product_price){
        this.product_price = product_price;
    }

    public int getProduct_number(){
        return product_number;
    }

    public void setProduct_number(int product_number){
        this.product_number = product_number;
    }

    public List<Offer> getOfferList(){
        return offerList;
    }

    public void setOfferList(List<Offer> offerList){
        this.offerList = offerList;
    }

    @Override
    public String toString(){
        return "\n"+"Product{" +
                "product_name='" + product_name + '\'' +
                ", product_code='" + product_code + '\'' +
                ", product_price=" + product_price +
                ", product_number=" + product_number +
                '}';
    }
}
