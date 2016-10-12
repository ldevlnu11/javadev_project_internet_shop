package ua.com.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by devnull on 08.10.16.
 */
@Entity
public class Offer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long offer_ID;
    @Column(columnDefinition = "NCHAR(128)")
    private String offer_status;
    private Date offer_date = new Date(System.currentTimeMillis());
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "offer_product", joinColumns = @JoinColumn(name = "offer_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> productList;
    @ManyToOne
    private Customer customer;

    public Offer(){
    }

    public Offer(String offer_status){
        this.offer_status = offer_status;
    }

    public long getOffer_ID(){
        return offer_ID;
    }

    public void setOffer_ID(long offer_ID){
        this.offer_ID = offer_ID;
    }

    public String getOffer_status(){
        return offer_status;
    }

    public void setOffer_status(String offer_status){
        this.offer_status = offer_status;
    }

    public Date getOffer_date(){
        return offer_date;
    }

    public void setOffer_date(Date offer_date){
        this.offer_date = offer_date;
    }

    public List<Product> getProductList(){
        return productList;
    }

    public void setProductList(List<Product> productList){
        this.productList = productList;
    }

    public Customer getCustomer(){
        return customer;
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    @Override
    public String toString(){
        return "\n"+"Offer{" +
                "offer_status='" + offer_status + '\'' +
                ", offer_date=" + offer_date +
                '}';
    }
}
