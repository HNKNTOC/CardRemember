package com.cardRemember.view;

import javax.swing.*;

/**
 * View menu for choice menu items.
 */
public abstract class SwingView implements View{

    protected JFrame mainFrame;

    public SwingView() {
        this.mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        mainFrame.pack();
    }

    @Override
    public void update() {
        mainFrame.repaint();
        mainFrame.setVisible(true);
    }

    @Override
    public void close() {
        mainFrame.setVisible(false);
        mainFrame = null;
    }
}
