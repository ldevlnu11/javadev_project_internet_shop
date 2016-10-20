package ua.com.gui.menu_customer;

import jdk.nashorn.internal.scripts.JO;
import sun.util.resources.cldr.ta.CurrencyNames_ta;
import ua.com.controller.Main;
import ua.com.entity.Customer;
import ua.com.serviceImp.CustomerFuncService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by devnull on 14.10.16.
 */
public class UpdateMenu_Customer extends Thread {

	private JFrame frame;
	private JPanel panel_Update;
	private JFormattedTextField oldRegion_field;
	private JFormattedTextField oldFname_field;
	private JFormattedTextField oldStreet_field;
	private JFormattedTextField oldCity_field;
	private JFormattedTextField oldProvince_field;
	private JFormattedTextField oldNumber_field;
	private JFormattedTextField oldSname_field;
	private JFormattedTextField oldFathername_field;
	private JFormattedTextField oldPhone_field;
	private JButton updateCustomer_button;
	private JFormattedTextField newFname_field;
	private JFormattedTextField newSname_field;
	private JFormattedTextField newFathername_field;
	private JFormattedTextField newPhone_field;
	private JFormattedTextField newCity_field;
	private JFormattedTextField newProvince_field;
	private JFormattedTextField newRegion_field;
	private JFormattedTextField newStreet_field;
	private JFormattedTextField newNumber_field;
	private CustomerFuncService customerService = (CustomerFuncService) Main.context.getBean("CustomerService");

	public UpdateMenu_Customer() {
		String fname, sname;
		final Customer customer;
		fname = JOptionPane.showInputDialog(null, "������� ��� ����������", "���", JOptionPane.INFORMATION_MESSAGE);
		sname = JOptionPane.showInputDialog(null, "������� ������� ����������", "�������",
				JOptionPane.INFORMATION_MESSAGE);
		customer = customerService.getCustomer(fname, sname);
		oldFname_field.setText(customer.getFirstname());
		oldSname_field.setText(customer.getSecondname());
		oldFathername_field.setText(customer.getFathername());
		oldPhone_field.setText(customer.getPhone());
		oldCity_field.setText(customer.getCity());
		oldProvince_field.setText(customer.getProvince());
		oldRegion_field.setText(customer.getRegion());
		oldStreet_field.setText(customer.getStreet());
		oldNumber_field.setText("" + customer.getNumber());
		updateCustomer_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<JFormattedTextField> newFieldList = new ArrayList<JFormattedTextField>();
					newFieldList.add(newFname_field);
					newFieldList.add(newSname_field);
					newFieldList.add(newFathername_field);
					newFieldList.add(newPhone_field);
					newFieldList.add(newCity_field);
					newFieldList.add(newProvince_field);
					newFieldList.add(newRegion_field);
					newFieldList.add(newStreet_field);
					newFieldList.add(newNumber_field);
					ArrayList<JFormattedTextField> oldFieldList = new ArrayList<JFormattedTextField>();
					oldFieldList.add(oldFname_field);
					oldFieldList.add(oldSname_field);
					oldFieldList.add(oldFathername_field);
					oldFieldList.add(oldPhone_field);
					oldFieldList.add(oldCity_field);
					oldFieldList.add(oldProvince_field);
					oldFieldList.add(oldRegion_field);
					oldFieldList.add(oldStreet_field);
					oldFieldList.add(oldNumber_field);
					for (int i = 0; i < newFieldList.size(); i++) {
						if (newFieldList.get(i).getText().isEmpty()) {
							newFieldList.get(i).setText(oldFieldList.get(i).getText());
						}
					}
					customer.setFirstname(newFname_field.getText());
					customer.setSecondname(newSname_field.getText());
					customer.setFathername(newFathername_field.getText());
					customer.setPhone(newPhone_field.getText());
					customer.setCity(newCity_field.getText());
					customer.setProvince(newProvince_field.getText());
					customer.setRegion(newRegion_field.getText());
					customer.setStreet(newStreet_field.getText());
					customer.setNumber(newNumber_field.getText());
					customerService.setCustomer(customer);
					frame.dispose();
				} catch (NullPointerException a) {
					JOptionPane.showMessageDialog(null, "������������ �� ������.", "������",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}

	@Override
	public void run() {
		frame = new JFrame("���� ��������� ����������");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(panel_Update);
		frame.setVisible(true);
		frame.setSize(512, 512);
	}

}