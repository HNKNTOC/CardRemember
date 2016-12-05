package com.cardRemember;


import com.cardRemember.model.Model;
import com.cardRemember.model.ModelType;
import com.cardRemember.view.MenuView;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        MenuView menuView = new MenuView();
        Model model = new Model(ModelType.Menu) {
        };
        List<MenuView.MenuItem> items = new ArrayList<>();

        AbstractAction abstractAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LOGGER.debug(e);
            }
        };

        items.add(createItem("Item 1",abstractAction));
        items.add(createItem("Item 2",abstractAction));
        items.add(createItem("Item 3",abstractAction));

        model.setData(MenuView.menuItems, items);
        menuView.show(model);
    }

     private static MenuView.MenuItem createItem(String label, AbstractAction listener){
        MenuView.MenuItem menuItem = new MenuView.MenuItem(label);
        menuItem.addListener(listener);
        return menuItem;
    }

}
