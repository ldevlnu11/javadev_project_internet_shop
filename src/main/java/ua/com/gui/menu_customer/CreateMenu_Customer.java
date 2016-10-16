package ua.com.gui.menu_customer;

import ua.com.control.Main;
import ua.com.entity.Customer;
import ua.com.service.CustomerFuncService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    private JButton createCustomer_button;
    private JPanel customer_panel;
    private JFrame frame = new JFrame();
    private CustomerFuncService customerService = (CustomerFuncService)Main.context.getBean("CustomerService");

    public CreateMenu_Customer(){
        createCustomer_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(firstname_field.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Поле имя не может быть пустое!", "Ошибка!", JOptionPane.ERROR_MESSAGE);
                }else if(secondname_field.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Поле фамилия не может быть пустое!", "Ошибка!", JOptionPane.ERROR_MESSAGE);
                }else if(city_field.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Поле город не может быть пустое!", "Ошибка!", JOptionPane.ERROR_MESSAGE);
                }else if(phone_field.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Поле номер телефона не может быть пустое!", "Ошибка!", JOptionPane.ERROR_MESSAGE);
                }else{
                    frame.dispose();
                    List<JFormattedTextField> unReuiredFields = new ArrayList<JFormattedTextField>();
                    unReuiredFields.add(fathername_field);
                    unReuiredFields.add(province_field);
                    unReuiredFields.add(region_field);
                    unReuiredFields.add(number_field);
                    unReuiredFields.add(street_field);
                    for(JFormattedTextField iField : unReuiredFields){
                        if(iField.getText().isEmpty()){
                            iField.setText("Не указано");
                        }
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
                    JOptionPane.showMessageDialog(null, "Добавлен пользователь " + customer, "Добавлено!", JOptionPane.INFORMATION_MESSAGE);
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
