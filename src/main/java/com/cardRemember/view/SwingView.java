package com.cardRemember.view;

import com.cardRemember.model.Data;
import com.cardRemember.model.DataType;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.swing.*;

/**
 * View menu for choice menu items.
 */
public abstract class SwingView implements View {
    private static final Logger LOGGER = LogManager.getLogger(SwingView.class);
    /**
     * Data Type which can display this View.
     */
    private final DataType displayDataType;
    protected JFrame mainFrame;


    public SwingView(DataType displayDataType) {
        this.displayDataType = displayDataType;
        this.mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    @Override
    public DataType getDataType() {
        return displayDataType;
    }

    @Override
    public void show(Data data) throws FailedViewModel {
        try {
            processingDataFromModel(data);
            update();
        } catch (Exception e) {
            FailedViewModel failedViewModel = new FailedViewModel("Failed processing data.", e,data);
            LOGGER.warn(failedViewModel);
            throw failedViewModel;
        }
    }

    /**
     * Gets the data models and working with them.
     */
    abstract void processingDataFromModel(Data data) throws ClassCastException;

    @Override
    public void update() {
        mainFrame.pack();
        mainFrame.repaint();
        mainFrame.setVisible(true);
    }

    @Override
    public void close() {
        mainFrame.setVisible(false);
        mainFrame = null;
    }
}
