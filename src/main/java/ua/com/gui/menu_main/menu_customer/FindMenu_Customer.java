package ua.com.gui.menu_main.menu_customer;

import ua.com.control.Main;
import ua.com.entity.Customer;
import ua.com.service.CustomerFuncService;

import java.awt.*;
import java.util.*;
import javax.persistence.NoResultException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by devnull on 14.10.16.
 */
public class FindMenu_Customer extends Thread{
    private JPanel panel_FindMenu;
    private JButton findCustomer_button;
    private JFormattedTextField name_field;
    private JLabel name_lab;
    private JFrame frame;
    private CustomerFuncService customerService = (CustomerFuncService)Main.context.getBean("CustomerService");

    public FindMenu_Customer(){

        findCustomer_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                List<Customer> results;
                try{
                    results = customerService.findCustomer(name_field.getText());
                    for(Customer customer : results){
                        JOptionPane.showMessageDialog(null, customer, "Результат", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch(NoResultException exc){

                }
            }
        });
    }

    @Override
    public void run(){
        frame = new JFrame("Поиск посетителя");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel_FindMenu);
        frame.setVisible(true);
        frame.setSize(512,512);
    }
}
