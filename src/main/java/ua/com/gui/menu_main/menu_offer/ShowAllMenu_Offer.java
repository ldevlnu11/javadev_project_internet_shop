package ua.com.gui.menu_main.menu_offer;

import ua.com.control.Main;
import ua.com.service.OfferFuncService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by devnull on 14.10.16.
 */
public class ShowAllMenu_Offer extends Thread{
    private JFrame frame;
    private JPanel showAllOffer_panel;
    private JTextArea output;
    private JButton ok_button;
    private OfferFuncService offerService = (OfferFuncService)Main.context.getBean("OfferService");

    public ShowAllMenu_Offer(){
        output.setText(offerService.showAllOffers().toString());
        ok_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
            }
        });
    }

    @Override
    public void run(){
        frame = new JFrame("Заказы");
        frame.setVisible(true);
        frame.setSize(1024, 512);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.add(showAllOffer_panel);
    }
}
