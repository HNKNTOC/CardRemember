package com.cardRemember.view;
import com.cardRemember.model.Data;
import com.cardRemember.model.DataType;


/**
 * View displays data.
 */
public interface View{
    DataType getDataType();
    void show(Data data) throws FailedViewModel;
    void update();
    void close();
}
