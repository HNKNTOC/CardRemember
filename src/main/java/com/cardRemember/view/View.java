package com.cardRemember.view;
import com.cardRemember.model.Data;
import com.cardRemember.model.FailedViewModel;


/**
 * View displays data.
 */
public interface View{
    void show(Data data) throws FailedViewModel;
    void update();
    void close();
}
