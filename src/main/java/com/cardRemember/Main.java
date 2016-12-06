package com.cardRemember;


import com.cardRemember.model.Data;
import com.cardRemember.model.DataType;
import com.cardRemember.view.MenuView;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import static com.cardRemember.view.MenuView.MenuItem.createItem;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        Data data = new Data(DataType.Menu);

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

        MenuView menuView = new MenuView();
        data.setData(MenuView.menuItems, items);
        menuView.show(data);
    }

}
