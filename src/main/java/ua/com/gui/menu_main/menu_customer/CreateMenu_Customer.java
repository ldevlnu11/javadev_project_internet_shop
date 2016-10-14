package ua.com.gui.menu_main.menu_customer;

import ua.com.control.Main;
import ua.com.entity.Customer;
import ua.com.service.CustomerFuncService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by devnull on 13.10.16.
 */
public class CreateMenu_Customer extends Thread{

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
    private CustomerFuncService customerService = (CustomerFuncService)Main.context.getBean("CustomerService");

    public CreateMenu_Customer(){
        createCustomer_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    if(fathername_field.getText().isEmpty()){
                        fathername_field.setText("Не указано");
                    }
                    if(province_field.getText().isEmpty()){
                        province_field.setText("Не указано");
                    }
                    if(region_field.getText().isEmpty()){
                        region_field.setText("Не указано");
                    }
                    if(number_field.getText().isEmpty()){
                        number_field.setText("Не указано");
                    }
                    if(street_field.getText().isEmpty()){
                        street_field.setText("Не указано");
                    }
                Customer customer = new Customer(
                        firstname_field.getText(),
                        secondname_field.getText(),
                        fathername_field.getText(),
                        phone_field.getText(),
                        city_field.getText(),
                        province_field.getText(),
                        region_field.getText(),
                        street_field.getText(),
                        number_field.getText());
                    customerService.createCustomer(customer);
                    JOptionPane.showMessageDialog(null, "Добавлен пользователь "+customer, "Добавлено!", JOptionPane.INFORMATION_MESSAGE);
                    firstname_field.setText("");
                    secondname_field.setText("");
                    fathername_field.setText("");
                    city_field.setText("");
                    province_field.setText("");
                    region_field.setText("");
                    street_field.setText("");
                    number_field.setText("");
                    phone_field.setText("");
                    frame.dispose();
                }catch(Exception exc){
                    JOptionPane.showMessageDialog(null, "Error!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    @Override
    public void run(){
        frame = new JFrame("Меню добавления");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.isAlwaysOnTop();
        frame.isAutoRequestFocus();
        frame.add(customer_panel);
        frame.setVisible(true);
        frame.setSize(512, 512);
    }
}
