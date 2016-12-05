package com.cardRemember.view;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Create JPanel and setting them.
 */
public class MenuFactory {
    private static final Logger LOGGER = LogManager.getLogger(MenuFactory.class);

    private int width = 300;
    private int height = 200;
    private int disposeOnClose = WindowConstants.DISPOSE_ON_CLOSE;
    private String[] itemsLabel = {"Item 1","Item 2","Item 3"};
    private AbstractAction action = new DefaultAction();

    private JFrame createJFrame(){
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(disposeOnClose);
        jFrame.setSize(width, height);
        return jFrame;
    }

    private JPanel createJPanel(){
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));
        for (String label : itemsLabel) {
            Button items = new Button(label);
            items.addActionListener(action);
            jPanel.add(items);
        }
        return jPanel;
    }

    public JFrame create(){
        JFrame jFrame = createJFrame();
        jFrame.add(createJPanel());
        return jFrame;
    }

    private class DefaultAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            LOGGER.debug(e);
        }
    }
}
