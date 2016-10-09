package ua.com.function;

import ua.com.entity.Product;
import ua.com.interfaces.ProductInterface;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

/**
 * Created by devnull on 09.10.16.
 */
public class ProductFunction implements ProductInterface{

    private static EntityManagerFactory fac;
    private static EntityManager man;
    private final static String productTable = " Product ";
    private Scanner sc = new Scanner(System.in);

    static{
        fac = Persistence.createEntityManagerFactory("primary");
        man = fac.createEntityManager();
    }

    @Override
    public void addProduct(Product product){
        man.getTransaction().begin();
        man.persist(product);
        man.getTransaction().commit();
    }

    @Override
    public List<Product> showAllProducts(){
        return man.createQuery("select p from"+productTable+"p").getResultList();
    }

    @Override
    public Product findProduct(String product_code){
        Product product = null;
        try{
            product = (Product)man.createQuery("select p from"+productTable+"p where p.product_code =:product_code").setParameter("product_code", product_code).getSingleResult();
        }catch(NoResultException e){
            System.out.println("Не найден товар с данным кодом");
        }
        return product;
    }

    @Override
    public void deleteProduct(String product_code){
        Product product = null;
        try{
            product = (Product)man.createQuery("select p from"+productTable+"p where p.product_code =:product_code").setParameter("product_code", product_code).getSingleResult();
        }catch(NoResultException e){
            System.out.println("Не найден товар с данным кодом");
        }
        if(product != null){
            man.remove(product);
        }
    }

    @Override
    public void sellProduct(String product_code, int number){
        Product product = null;
        try{
            product = (Product)man.createQuery("select p from"+productTable+"p where p.product_code =:product_code").setParameter("product_code", product_code).getSingleResult();
        }catch(NoResultException e){
            System.out.println("Не найден товар с данным кодом");
        }
        product.setProduct_number(product.getProduct_number()-number);
        man.getTransaction().begin();
        man.merge(product);
        man.getTransaction().commit();
    }
}
