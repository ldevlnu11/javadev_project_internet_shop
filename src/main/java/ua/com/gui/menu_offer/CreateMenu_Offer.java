package ua.com.gui.menu_offer;

import ua.com.controller.Main;
import ua.com.entity.Offer;
import ua.com.serviceImp.OfferServiceImp;

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
    private OfferServiceImp offerService = (OfferServiceImp)Main.context.getBean("OfferService");

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
