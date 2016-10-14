package ua.com.gui.menu_main.menu_customer;

import ua.com.gui.menu_main.menu_customer.CreateMenu_Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.print.attribute.standard.MediaSizeName.D;

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
                new ShowAllMenu_Customer().run();
            }
        });
        findOne_customer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new FindMenu_Customer().run();
            }
        });
        delete_customer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new DeleteMenu_Customer().run();
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
