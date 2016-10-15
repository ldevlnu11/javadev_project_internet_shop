package ua.com.gui.menu_main.menu_product;

import jdk.nashorn.internal.scripts.JO;
import ua.com.control.Main;
import ua.com.service.ProductFuncService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

/**
 * Created by devnull on 14.10.16.
 */
public class DeleteMenu_Product extends Thread{
    private JFrame frame;
    private JPanel deleteProductMenu_panel;
    private JButton deleteProduct_button;
    private JFormattedTextField productCode_field;
    private ProductFuncService productService = (ProductFuncService)Main.context.getBean("ProductService");

    public DeleteMenu_Product(){
        deleteProduct_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    if(productCode_field.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Поле код товара не может быть пустым!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    }else{
                        productService.deleteProduct(productCode_field.getText());
                        JOptionPane.showMessageDialog(null, "Товар с кодом \""+productCode_field.getText()+"\" удален.", "Удалено", JOptionPane.INFORMATION_MESSAGE);
                        frame.dispose();
                    }
                }catch(Exception a){
                    JOptionPane.showMessageDialog(null, "Товар с кодом \""+productCode_field.getText()+"\" не найден.", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }

    @Override
    public void run(){
        frame = new JFrame("Удаление товара");
        frame.add(deleteProductMenu_panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(512, 512);
    }
}
