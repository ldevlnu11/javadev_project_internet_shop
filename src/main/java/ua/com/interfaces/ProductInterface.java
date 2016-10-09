package ua.com.interfaces;

import ua.com.entity.Product;

import java.util.List;

/**
 * Created by devnull on 09.10.16.
 */
public interface ProductInterface{

    void addProduct(Product product);
    List<Product> showAllProducts();
    Product findProduct(String product_code);
    void deleteProduct(String product_code);
    void sellProduct(String product_code, int number);
}
