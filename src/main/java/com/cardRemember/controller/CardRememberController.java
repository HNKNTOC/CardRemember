package com.cardRemember.controller;

import com.cardRemember.model.Data;
import com.cardRemember.view.View;

import java.util.Observable;
import java.util.Observer;

/**
 * Controller for using data and view.
 */
public class CardRememberController implements Observer {
    private View view;
    private Data data;

    public CardRememberController(View view, Data data) {
        this.view = view;
        this.data = data;
    }

    public void updateView(){
        view.show(data);
    }


    @Override
    public void update(Observable o, Object arg) {

    }
}
