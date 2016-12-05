package com.cardRemember.view;
import java.util.Observer;

/**
 * View displays data.
 */
public interface View{
    void addObserver(Observer observer);
    void update();
    void close();
}
