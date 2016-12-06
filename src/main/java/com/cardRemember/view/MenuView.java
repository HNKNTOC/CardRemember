package com.cardRemember.view;

import com.cardRemember.model.Data;
import com.cardRemember.model.DataType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


/**
 * View menu for choice menu items.
 */
public class MenuView extends SwingView {

    public static final String menuItems = "MenuItems";

    public MenuView() {
        super(DataType.Menu);
    }


    @Override
    void processingDataFromModel(Data model) {
        List<MenuItem> data = (List<MenuItem>) model.getData(menuItems);
        mainFrame.add(createMenuPanel(data));
        update();
    }

    private JPanel createMenuPanel(List<MenuItem> itemsList) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel itemPanel = new JPanel();
        settingMenuItems(itemPanel, itemsList);

        JPanel labelPanel = new JPanel();
        labelPanel.add(new JLabel("Hello this menu label."));

        mainPanel.add(labelPanel, BorderLayout.NORTH);
        mainPanel.add(itemPanel, BorderLayout.CENTER);
        return mainPanel;
    }

    private void settingMenuItems(JPanel panel, List<MenuItem> itemsList) {
        panel.setLayout(new GridLayout(0, 1));
        for (MenuItem menuItem : itemsList) {
            JButton button = new JButton();
            menuItem.useFor(button);
            panel.add(button);
        }
    }

    /**
     * This use for setting Menu Item.
     */
    public static class MenuItem {
        private String label = "DefaultLabelItem";
        private List<ActionListener> listenerList = new ArrayList<>();
        private JButton item;

        public MenuItem(String label) {
            this.label = label;
        }

        /**
         * Update for last item.
         *
         * @return False if item == null.
         */
        public boolean update() {
            if (item == null)
                return false;
            useFor(item);
            return true;
        }

        private void useFor(JButton item) {
            this.item = item;
            item.setText(label);
            removeAllListeners(item);
            for (ActionListener listener : listenerList) {
                item.addActionListener(listener);
            }
        }

        public static MenuView.MenuItem createItem(String label, AbstractAction listener){
            MenuView.MenuItem menuItem = new MenuView.MenuItem(label);
            menuItem.addListener(listener);
            return menuItem;
        }

        /**
         * Remove all listeners in {@link JButton}.
         *
         * @param item In item need delete listeners.
         */
        private void removeAllListeners(JButton item) {
            for (ActionListener listener : item.getActionListeners()) {
                item.removeActionListener(listener);
            }
        }

        public void addListener(ActionListener listener) {
            listenerList.add(listener);
        }

        public boolean removeListener(ActionListener listener) {
            return listenerList.remove(listener);
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }
    }

}
