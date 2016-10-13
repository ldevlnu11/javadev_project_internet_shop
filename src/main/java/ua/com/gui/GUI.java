package ua.com.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by devnull on 13.10.16.
 */
public class GUI extends Thread{
    private  JButton menu_customer;
    private JPanel main_panel;
    private  JButton menu_product;
    private  JButton menu_offer;
    private  JButton menu_user;
    private  JFrame frame;

    public GUI(){
        frame = new JFrame("Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(main_panel);
        frame.setVisible(true);
        frame.setSize(512,512);
        menu_customer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new CustomerMenu().run();
                System.out.println("CLICK!");
            }
        });
    }
}
