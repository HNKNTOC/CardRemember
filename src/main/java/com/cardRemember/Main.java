package com.cardRemember;

import com.cardRemember.view.MenuFactory;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        MenuFactory factory = new MenuFactory();
        JFrame jFrame = factory.create();
        jFrame.setVisible(true);
    }
}
