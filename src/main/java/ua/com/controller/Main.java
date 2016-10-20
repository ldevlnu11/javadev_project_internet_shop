package ua.com.controller;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.com.entity.Customer;
import ua.com.entity.Offer;
import ua.com.entity.Product;
import ua.com.gui.menu_main.GUI;
import ua.com.serviceImp.CustomerFuncService;
import ua.com.serviceImp.OfferFuncService;
import ua.com.serviceImp.ProductFuncService;

import java.util.Scanner;

/**
 * Created by devnull on 08.10.16.
 */
public class Main{

    private static Scanner sc;
    private static boolean isActive;
    private static boolean xCustomer;
    private static boolean xProduct;
    private static boolean xOffer;
    public static ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
    private static OfferFuncService offerFunction = (OfferFuncService) context.getBean("OfferService");
    private static CustomerFuncService customerFunction = (CustomerFuncService) context.getBean("CustomerService");
    private static ProductFuncService productFunction = (ProductFuncService) context.getBean("ProductService");

    static{
        sc = new Scanner(System.in);
        isActive = true;
        xOffer = true;
        xProduct = true;
        xCustomer = true;
    }


    public static void main(String[] args){

        new GUI().run();

        while(!isActive){
            xCustomer = true;
            xProduct = true;
            xOffer = true;
            showFunctional();
            switch(sc.next()){
                case "1":{
                    while(xCustomer){
                        showFunctionalCustomer();
                        switch(sc.next()){
                            case "1":{
                                String firstname, secondname, fathername, city, province, region, street, phone, number;
                                System.out.println("Введите имя");
                                firstname = sc.next();
                                System.out.println("Введите фамилию");
                                secondname = sc.next();
                                System.out.println("Введите отчество(если есть)");
                                fathername = sc.next();
                                System.out.println("Введите город");
                                city = sc.next();
                                System.out.println("Введите область(если есть)");
                                province = sc.next();
                                System.out.println("Введите район(если есть)");
                                region = sc.next();
                                System.out.println("Введите улицу(если есть)");
                                street = sc.next();
                                System.out.println("Введите номер дома(если есть)");
                                number = sc.next();
                                System.out.println("Введите номер телефона");
                                phone = sc.next();
                                customerFunction.createCustomer(new Customer(firstname, secondname, fathername, phone, city, province, region, street, number));
                                break;
                            }
                            case "2":{
                                System.out.println(customerFunction.showAllCustomers());
                                break;
                            }
                            case "3":{
                                System.out.println("Введите имя или фамилию пользователя");
                                System.out.println(customerFunction.findCustomer(sc.next()));
                                break;
                            }
                            case "4":{
                                Scanner s = new Scanner(System.in);
                                System.out.println("Введите имя и фамилию пользователя");
                                String fname = "", sname = "", input = s.nextLine();
                                boolean nextWord = false;
                                char []word = input.toCharArray();
                                for(int i = 0; i < word.length; i++){
                                    if(!nextWord){
                                        if(word[i] != (char)32){
                                            fname += word[i];
                                        }else{
                                            nextWord = true;
                                        }
                                    }else{
                                        sname += word[i];
                                    }
                                }
                                customerFunction.updateCustomer(fname, sname);
                                break;
                            }
                            case "5":{
                                System.out.println("Введите имя и фамилию пользователя");
                                Scanner s = new Scanner(System.in);
                                String fname = "", sname = "", input = s.nextLine();
                                boolean nextWord = false;
                                char []word = input.toCharArray();
                                for(int i = 0; i < word.length; i++){
                                    if(!nextWord){
                                        if(word[i] != (char)32){
                                            fname += word[i];
                                        }else{
                                            nextWord = true;
                                        }
                                    }else{
                                        sname += word[i];
                                    }
                                }
                                customerFunction.deleteCustomer(fname, sname);
                                break;
                            }
                            case "0":{
                                xCustomer = false;
                                break;
                            }
                            default:{
                                System.err.println("Выберите из списка");
                                break;
                            }
                        }
                    }
                    break;
                }
                case "2":{
                    while(xProduct){
                        showFuctionalProduct();
                        switch(sc.next()){
                            case "1":{
                                String name, code;
                                String number;
                                String price;
                                System.out.println("Введите имя товара");
                                name = sc.next();
                                System.out.println("Введите цену товара");
                                price = sc.next();
                                System.out.println("Введите кол-во товара");
                                number = sc.next();
                                productFunction.addProduct(new Product(name, price, number));
                                break;
                            }
                            case "2":{
                                System.out.println(productFunction.showAllProducts());
                                break;
                            }
                            case "3":{
                                System.out.println("Введите код товара");
                                System.out.println(productFunction.findProduct(sc.next()));
                                break;
                            }
                            case "4":{
                                String code;
                                int number;
                                System.out.println("Введите код товара");
                                code = sc.next();
                                System.out.println("Введите кол-во проданного товара");
                                number = sc.nextInt();
                                productFunction.sellProduct(code, number);
                                break;
                            }
                            case "5":{
                                System.out.println("Введите код товара");
                                productFunction.deleteProduct(sc.next());
                                break;
                            }
                            case "0":{
                                xProduct = false;
                                break;
                            }
                            default:{
                                System.err.println("Выберите из списка");
                                break;
                            }
                        }
                    }
                    break;
                }
                case "3":{
                    while(xOffer){
                        showFuctionalOffer();
                        switch(sc.next()){
                            case "1":{
                                System.out.println("Введите статус заказа");
                                offerFunction.createOffer(new Offer(sc.next()));
                                break;
                            }
                            case "2":{
                                System.out.println(offerFunction.showAllOffers());
                                break;
                            }
                            case "3":{
                                System.out.println(offerFunction.findUncomplitedOffers());
                                break;
                            }
                            case "4":{
                                offerFunction.deleteComplitedOffers();
                                break;
                            }
                            case "0":{
                                xOffer = false;
                                break;
                            }
                            default:{
                                System.err.println("Выберите из списка");
                                break;
                            }
                        }
                    }
                    break;
                }
                case "0":{
                    System.exit(0);
                    break;
                }
                default:{
                    System.err.println("Выберите из списка");
                    break;
                }
            }
        }
    }

    private static void showFunctional(){
        System.out.println("Введите 1, чтобы перейти в меню пользователя");
        System.out.println("Введите 2, чтобы перейти в меню товаров");
        System.out.println("Введите 3, чтобы перейти в меню заказов");
        System.out.println("Введите 0, чтобы выйти");
    }

    private static void showFunctionalCustomer(){
        System.out.println("Введите 1, чтобы добавить пользователя");
        System.out.println("Введите 2, чтобы посмотреть всех пользователей");
        System.out.println("Введите 3, чтобы найти пользователя");
        System.out.println("Введите 4, чтобы изменить пользователя");
        System.out.println("Введите 5, чтобы удалить пользователя");
        System.out.println("Введите 0, чтобы вернуться в главное меню");
    }

    private static void showFuctionalProduct(){
        System.out.println("Введите 1, чтобы добавить товар");
        System.out.println("Введите 2, чтобы посмотреть все товары");
        System.out.println("Введите 3, чтобы найти товар");
        System.out.println("Введите 4, чтобы продать товар");
        System.out.println("Введите 5, чтобы удалить товар");
        System.out.println("Введите 0, чтобы вернуться в главное меню");
    }

    private static void showFuctionalOffer(){
        System.out.println("Введите 1, чтобы добавить заказ");
        System.out.println("Введите 2, чтобы посмотреть все заказы");
        System.out.println("Введите 3, чтобы найти неотправленные заказы");
        System.out.println("Введите 4, чтобы удалить отправленные заказы");
        System.out.println("Введите 0, чтобы вернуться в главное меню");
    }
}
