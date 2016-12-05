package com.cardRemember.view;

import com.cardRemember.model.FailedViewModel;
import com.cardRemember.model.Model;
import com.cardRemember.model.ModelType;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


/**
 * View menu for choice menu items.
 */
public class MenuView extends SwingView {

    public static final String menuItems = "MenuItems";

    @Override
    public void show(Model model) throws FailedViewModel {
        if (model.getModelType() == ModelType.Menu){
            List<MenuItem> data = (List<MenuItem>) model.getData(menuItems);
            mainFrame.add(createMenuPanel(data));
            update();
        }else {
            throw new FailedViewModel("View not able to display this model.");
        }
    }

    private JPanel createMenuPanel(List<MenuItem> itemsList){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        for (MenuItem menuItem : itemsList) {
            JButton button = new JButton();
            menuItem.useFor(button);
            panel.add(button);
        }
        return panel;
    }

    /**
     * This use for setting Menu Item.
     */
    public static class MenuItem{
        private String label = "DefaultLabelItem";
        private List<ActionListener> listenerList = new ArrayList<>();
        private JButton item;

        public MenuItem(String label) {
            this.label = label;
        }

        /**
         * Update for last item.
         * @return False if item == null.
         */
        public boolean update(){
            if(item == null)
                return false;
            useFor(item);
            return true;
        }

        private void useFor(JButton item){
            this.item = item;
            item.setText(label);
            removeAllListeners(item);
            for (ActionListener listener : listenerList) {
                item.addActionListener(listener);
            }
        }

        /**
         * Remove all listeners in {@link JButton}.
         * @param item In item need delete listeners.
         */
        private void removeAllListeners(JButton item) {
            for( ActionListener listener: item.getActionListeners() ) {
                item.removeActionListener(listener);
            }
        }

        public void addListener(ActionListener listener){
            listenerList.add(listener);
        }

        public boolean removeListener(ActionListener listener){
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
