package com.cardRemember.view;
import com.cardRemember.model.FailedViewModel;
import com.cardRemember.model.Model;


/**
 * View displays data.
 */
public interface View{
    void show(Model model) throws FailedViewModel;
    void update();
    void close();
}
