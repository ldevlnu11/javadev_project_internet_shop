package ua.com.gui.menu_main.menu_customer;

import ua.com.control.Main;
import ua.com.entity.Customer;
import ua.com.service.CustomerFuncService;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by devnull on 14.10.16.
 */
public class ShowAllMenu_Customer extends Thread{
    private JPanel panel_ShowAll;
    private JTextArea result;
    private JButton ok_button;
    private JFrame frame;
    private CustomerFuncService customerService = (CustomerFuncService)Main.context.getBean("CustomerService");

    public ShowAllMenu_Customer(){
        result.setText(customerService.showAllCustomers().toString());
        ok_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
            }
        });
    }

    @Override
    public void run(){
        frame = new JFrame("Показать посетителей");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel_ShowAll);
        frame.setVisible(true);
        frame.pack();
    }
}
