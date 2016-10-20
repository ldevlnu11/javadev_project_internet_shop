package ua.com.controller;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.com.gui.menu_main.GUI;



/**
 * Created by devnull on 08.10.16.
 */
public class Main {

	
	public static ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
	
	public static void main(String[] args) {new GUI().run();}
}
