package com.cardRemember.controller;

import com.cardRemember.model.Data;
import com.cardRemember.view.MenuView;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Control {@link com.cardRemember.view.MenuView}
 */
public class MenuController {
    private static final Logger LOGGER = LogManager.getLogger(MenuController.class);
    private MenuView menuView;
    private Data data;

    public MenuController(MenuView menuView, Data data) {
        this.menuView = menuView;
        this.data = data;
    }


    public static class ListenerItemOne implements ActionListener{
        private static final Logger LOGGER = LogManager.getLogger(ListenerItemOne.class);
        @Override
        public void actionPerformed(ActionEvent e) {
            LOGGER.info(e);
        }
    }

}