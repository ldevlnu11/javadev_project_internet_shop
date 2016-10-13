package ua.com.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by devnull on 13.10.16.
 */
public class CustomerMenu extends Thread{

    private JFormattedTextField firstname_field;
    private JFormattedTextField secondname_field;
    private JFormattedTextField fathername_field;
    private JFormattedTextField city_field;
    private JFormattedTextField province_field;
    private JFormattedTextField region_field;
    private JFormattedTextField street_field;
    private JFormattedTextField number_field;
    private JFormattedTextField phone_field;
    private JLabel firstname_lab;
    private JLabel secondname_lab;
    private JLabel fathername_lab;
    private JLabel city_lab;
    private JLabel province_lab;
    private JLabel region_lab;
    private JLabel street_lab;
    private JLabel number_lab;
    private JLabel phone_lab;
    private JButton createCustomer_button;
    private JPanel customer_panel;
    private JFrame frame = new JFrame();

    public CustomerMenu(){
        createCustomer_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Hello world!");
            }
        });
    }

    @Override
    public void run(){
        frame = new JFrame("Menu");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.isAlwaysOnTop();
        frame.isAutoRequestFocus();
        frame.add(customer_panel);
        frame.setVisible(true);
        frame.setSize(512,512);
    }
}
