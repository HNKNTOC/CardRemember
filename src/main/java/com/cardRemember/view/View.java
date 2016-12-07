package com.cardRemember.view;
import com.cardRemember.model.Data;
import com.cardRemember.model.DataType;
import com.cardRemember.model.FailedViewModel;


/**
 * View displays data.
 */
public interface View{
    DataType getDataType();
    void show(Data data) throws FailedViewModel;
    void update();
    void close();
}
