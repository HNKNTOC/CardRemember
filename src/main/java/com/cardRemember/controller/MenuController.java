package com.cardRemember.controller;

import com.cardRemember.model.Data;
import com.cardRemember.view.MenuView;

/**
 * Control {@link com.cardRemember.view.MenuView}
 */
public class MenuController {
    private MenuView menuView;
    private Data data;

    public MenuController(MenuView menuView, Data data) {
        this.menuView = menuView;
        this.data = data;
    }



}
