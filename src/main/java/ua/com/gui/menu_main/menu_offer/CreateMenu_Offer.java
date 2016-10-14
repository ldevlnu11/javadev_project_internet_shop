package ua.com.gui.menu_main.menu_offer;

import ua.com.control.Main;
import ua.com.entity.Offer;
import ua.com.service.OfferFuncService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by devnull on 14.10.16.
 */
public class CreateMenu_Offer extends Thread{

    private JFrame frame;
    private JPanel createMenu_panel;
    private JButton createOffer_button;
    private JComboBox status_combobox;
    private OfferFuncService offerService = (OfferFuncService)Main.context.getBean("OfferService");

    CreateMenu_Offer(){
        createOffer_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                offerService.createOffer(new Offer(status_combobox.getSelectedItem().toString()));
                frame.dispose();
            }
        });
    }

    @Override
    public void run(){
        frame = new JFrame("Оформить заказ");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(512, 512);
        frame.add(createMenu_panel);
    }
}