package ua.com.gui.menu_main;

import ua.com.gui.menu_main.menu_customer.Menu_Customer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by devnull on 13.10.16.
 */
public class GUI extends Thread{
    private  JButton menu_customer;
    private  JPanel main_panel;
    private  JButton menu_product;
    private  JButton menu_offer;
    private  JButton menu_user;
    private  JFrame frame = new JFrame();

    public GUI(){
        menu_customer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new Menu_Customer().run();
            }
        });
    }

    @Override
    public void run(){
        frame = new JFrame("Меню");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(main_panel);
        frame.setVisible(true);
        frame.setSize(512,512);
    }
}
