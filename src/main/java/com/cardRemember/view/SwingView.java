package com.cardRemember.view;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * View menu for choice menu items.
 */
public class SwingView extends Observable implements View{

    private JFrame mainFrame;
    private MenuFactory factory;

    public SwingView(String title) {
        this.mainFrame = new JFrame(title);
    }

    @Override
    public void addObserver(Observer observer) {
        super.addObserver(observer);
    }

    @Override
    public void update() {

    }

    @Override
    public void close() {

    }
}
