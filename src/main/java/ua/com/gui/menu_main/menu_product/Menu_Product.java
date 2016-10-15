package ua.com.gui.menu_main.menu_product;

import ua.com.control.Main;
import ua.com.service.ProductFuncService;

import javax.persistence.NoResultException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by devnull on 14.10.16.
 */
public class Menu_Product extends Thread{

    private JFrame frame;
    private JPanel main_panel;
    private JButton createProduct_button;
    private JButton deleteProduct_button;
    private JButton findProduct_button;
    private JButton showAllProduct_button;
    private ProductFuncService productService = (ProductFuncService)Main.context.getBean("ProductService");

    public Menu_Product(){
        createProduct_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new CreateMenu_Product().run();
            }
        });
        deleteProduct_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new DeleteMenu_Product().run();
            }
        });
        findProduct_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String product_code = JOptionPane.showInputDialog(null, "Введите код товара", "Код", JOptionPane.INFORMATION_MESSAGE);
                if(product_code.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Поле код товара не может быть пустым!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }else{
                    try{
                        JOptionPane.showMessageDialog(null, productService.findProduct(product_code), "Результат", JOptionPane.INFORMATION_MESSAGE);
                    }catch(NoResultException a){
                        JOptionPane.showMessageDialog(null, "Товар с кодом \""+product_code+"\" не найден.", "Результат", JOptionPane.INFORMATION_MESSAGE);
                    }
                }            }
        });
        showAllProduct_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, productService.showAllProducts(), "Все товары", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    @Override
    public void run(){
        frame = new JFrame("Меню товаров");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(512, 512);
        frame.add(main_panel);
    }
}
