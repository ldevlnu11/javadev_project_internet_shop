package ua.com.entity;

import ua.com.controller.Main;
import ua.com.serviceImp.ProductServiceImp;

import javax.persistence.*;
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
    private String product_price;
    private String product_number;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "offer_product", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "offer_id"))
    private List<Offer> offerList;

    public Product(){
    }

    public Product(String product_name, String product_price, String product_number){
        this.product_name = product_name;
        ProductServiceImp productService = (ProductServiceImp)Main.context.getBean("ProductService");
        String product_code = product_name.toUpperCase().replaceAll("[А, О, У, Е, Я, Ю, Й, И, Ы, Ь, Ъ]","");
        List<Product> product_codes = productService.showAllProducts();
        boolean x = true;
        while(x){
            for(Product p : product_codes){
                if(p.getProduct_code().equalsIgnoreCase(product_code)){
                    product_code += (int)(Math.random() * 10);
                }else{
                    break;
                }
            }
            break;
        }
        while(product_code.length() < 3){product_code += (int)(Math.random() * 10);};
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

    public String getProduct_price(){
        return product_price;
    }

    public void setProduct_price(String product_price){
        this.product_price = product_price;
    }

    public String getProduct_number(){
        return product_number;
    }

    public void setProduct_number(String product_number){
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
        return "\n"+
                "Имя: " + product_name + '\'' +
                ", Код: " + product_code + '\'' +
                ", Цена: " + product_price +
                ", Количество: " + product_number +".";
    }
}
