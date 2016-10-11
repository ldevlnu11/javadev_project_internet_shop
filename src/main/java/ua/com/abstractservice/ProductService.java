package ua.com.abstractservice;

import ua.com.entity.Product;

import java.util.List;

/**
 * Created by devnull on 11.10.16.
 */
public interface ProductService{

    void addProduct(Product product);
    List<Product> showAllProducts();
    Product findProduct(String product_code);
    void deleteProduct(String product_code);
    void sellProduct(String product_code, int number);
}
