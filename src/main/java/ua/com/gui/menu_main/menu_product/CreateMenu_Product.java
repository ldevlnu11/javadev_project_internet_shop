package ua.com.gui.menu_main.menu_product;

import ua.com.control.Main;
import ua.com.entity.Product;
import ua.com.service.ProductFuncService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by devnull on 14.10.16.
 */
public class CreateMenu_Product extends Thread{
    private JFrame frame;
    private JPanel createMenu_panel;
    private JButton createProduct_button;
    private JFormattedTextField numberProduct_field;
    private JFormattedTextField priceProduct_field;
    private JFormattedTextField nameProduct_field;
    private ProductFuncService productService = (ProductFuncService)Main.context.getBean("ProductService");


    public CreateMenu_Product() {
        createProduct_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(nameProduct_field.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Поле имя не может быть пустое!", "Ошибка!", JOptionPane.ERROR_MESSAGE);
                }else if(numberProduct_field.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Поле кол-во не может быть пустое!", "Ошибка!", JOptionPane.ERROR_MESSAGE);
                }else{
                    Product product = new Product(nameProduct_field.getText(), priceProduct_field.getText(), numberProduct_field.getText());
                    productService.addProduct(product);
                    JOptionPane.showMessageDialog(null, product.toString()+" был добавлен", "Добавлено", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                }
            }
        });
    }

    @Override
    public void run(){
        frame = new JFrame("Добавить товар");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(512, 512);
        frame.add(createMenu_panel);
    }
}
