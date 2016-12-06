package com.cardRemember.view;

import com.cardRemember.model.Data;
import com.cardRemember.model.FailedViewModel;
import com.cardRemember.model.DataType;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.swing.*;

/**
 * View menu for choice menu items.
 */
public abstract class SwingView implements View{
    private static final Logger LOGGER = LogManager.getLogger(SwingView.class);

    protected JFrame mainFrame;
    /**
     * Data Type which can display this View.
     */
    private final DataType displayDataType;


    public SwingView(DataType displayDataType) {
        this.displayDataType = displayDataType;
        this.mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    @Override
    public void show(Data data) throws FailedViewModel {
        DataType dataType = data.getDataType();
        if (dataType != DataType.Menu)
            throw new FailedViewModel(
                    String.format("This view not able to display data \"%s\". This view display \"%s\".",
                            dataType,
                            this.displayDataType));

        try {
            processingDataFromModel(data);
        } catch (Exception e) {
            FailedViewModel failedViewModel = new FailedViewModel("Failed processing data from data.",e);
            LOGGER.warn(failedViewModel);
            throw failedViewModel;
        }
    }

    /**
     * Gets the data models and working with them.
     */
    abstract void processingDataFromModel(Data data);

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
