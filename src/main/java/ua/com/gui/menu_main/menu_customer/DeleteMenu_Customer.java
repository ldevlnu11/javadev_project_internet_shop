package ua.com.gui.menu_main.menu_customer;

import ua.com.control.Main;
import ua.com.service.CustomerFuncService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by devnull on 14.10.16.
 */
public class DeleteMenu_Customer extends Thread{

    private JFrame frame;
    private JPanel panel_deleteMenu;
    private JButton deleteCustomer_button;
    private JFormattedTextField firstname_field;
    private JFormattedTextField secondname_field;
    private JLabel firstname_lab;
    private JLabel secondname_lab;
    private CustomerFuncService customerService = (CustomerFuncService)Main.context.getBean("CustomerService");

    public DeleteMenu_Customer(){
        deleteCustomer_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

                firstname_field.setText("");
                secondname_field.setText("");
            }
        });
    }

    @Override
    public void run(){
        frame = new JFrame("Удалить посетителя");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel_deleteMenu);
        frame.setVisible(true);
        frame.setSize(512,512);
    }
}
