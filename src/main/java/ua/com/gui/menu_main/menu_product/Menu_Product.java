package ua.com.gui.menu_main.menu_product;

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

    public Menu_Product(){
        createProduct_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new CreateMenu_Product().run();
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
