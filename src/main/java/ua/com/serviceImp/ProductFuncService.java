package ua.com.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.dao.ProductInterface;
import ua.com.entity.Product;
import ua.com.service.ProductService;

import java.util.List;

/**
 * Created by devnull on 11.10.16.
 */
@Service("ProductService")
public class ProductFuncService implements ProductService{

    @Autowired
    private ProductInterface productInterface;

    @Override
    public void addProduct(Product product){
        productInterface.addProduct(product);
    }

    @Override
    public List<Product> showAllProducts(){
        return productInterface.showAllProducts();
    }

    @Override
    public Product findProduct(String product_code){
        return productInterface.findProduct(product_code);
    }

    @Override
    public void deleteProduct(String product_code){
        productInterface.deleteProduct(product_code);
    }

    @Override
    public void sellProduct(String product_code, int number){
        productInterface.sellProduct(product_code, number);
    }
}
