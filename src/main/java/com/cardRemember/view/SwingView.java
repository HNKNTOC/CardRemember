package com.cardRemember.view;

import com.cardRemember.model.FailedViewModel;
import com.cardRemember.model.Model;
import com.cardRemember.model.ModelType;
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
     * Model Type which can display this View.
     */
    private final ModelType displayModelType;


    public SwingView(ModelType displayModelType) {
        this.displayModelType = displayModelType;
        this.mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    @Override
    public void show(Model model) throws FailedViewModel {
        ModelType modelType = model.getModelType();
        if (modelType != ModelType.Menu)
            throw new FailedViewModel(
                    String.format("This view not able to display model \"%s\". This view display \"%s\".",
                            modelType,
                            this.displayModelType));

        try {
            processingDataFromModel(model);
        } catch (Exception e) {
            FailedViewModel failedViewModel = new FailedViewModel("Failed processing Data From Model.",e);
            LOGGER.warn(failedViewModel);
            throw failedViewModel;
        }
    }

    /**
     * Gets the data models and working with them.
     */
    abstract void processingDataFromModel(Model model);

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
