package ua.com.gui.menu_customer;

import ua.com.controller.Main;
import ua.com.entity.Customer;
import ua.com.serviceImp.CustomerServiceImp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by devnull on 13.10.16.
 */
public class Menu_Customer extends Thread{
    private JButton delete_customer;
    private JButton update_customer;
    private JButton showAll_customer;
    private JButton findOne_customer;
    private JButton TODO;
    private JButton create_customer;
    private JPanel panel_Customer;
    private JFrame frame;
    private CustomerServiceImp customerService = (CustomerServiceImp)Main.context.getBean("CustomerService");

    public Menu_Customer(){
        frame = new JFrame("Меню посетителя");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel_Customer);
        frame.setVisible(true);
        frame.setSize(512,512);
        create_customer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new CreateMenu_Customer().run();
            }
        });
        update_customer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new UpdateMenu_Customer().run();
            }
        });
        showAll_customer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, customerService.showAllCustomers(), "Все посетители", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        findOne_customer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String name = JOptionPane.showInputDialog(null, "Введите имя или фамилию посетителя", "Имя или фамилия", JOptionPane.INFORMATION_MESSAGE);
                if(name.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Поле имя или фамилия не может быть пустым!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }else{
                    List<Customer> customerList = customerService.findCustomer(name);
                    if(customerList.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Посетитель с именем или фамилией \""+name+"\" не найден.", "Результат", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, customerList, "Результат", JOptionPane.INFORMATION_MESSAGE);
                    }
                }            }
        });
        delete_customer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String fname = JOptionPane.showInputDialog(null, "Введите имя посетителя", "Имя или фамилия", JOptionPane.INFORMATION_MESSAGE),
                        sname = JOptionPane.showInputDialog(null, "Введите фамилию посетителя", "Имя или фамилия", JOptionPane.INFORMATION_MESSAGE);
                if(fname.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Поле имя не может быть пустым!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }else if(sname.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Поле фамилия не может быть пустым!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }else{
                    try{
                        customerService.deleteCustomer(fname, sname);
                        JOptionPane.showMessageDialog(null,
                                "Удален посетитель " + fname + " " + sname,
                                "Удалено", JOptionPane.INFORMATION_MESSAGE);
                    }catch(Exception a){
                        JOptionPane.showMessageDialog(null, "Посетитель с именем \""+fname+"\" и фамилией \""+sname+"\" не найден.", "Результат", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        TODO.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null,
                        "Будет сделано в будущем.",
                        "Output",
                        JOptionPane.PLAIN_MESSAGE);
            }
        });
    }
}
