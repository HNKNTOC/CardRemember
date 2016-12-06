package com.cardRemember;


import com.cardRemember.model.Data;
import com.cardRemember.view.MenuView;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static ApplicationContext context = new ClassPathXmlApplicationContext("beans/view.xml");

    public static void main(String[] args) {
        Data data = context.getBean("dataMenu",Data.class);
        System.out.println(data);
        MenuView menuView = new MenuView();
        menuView.show(data);
    }
}
