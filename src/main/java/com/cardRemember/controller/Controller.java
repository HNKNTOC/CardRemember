package com.cardRemember.controller;

import com.cardRemember.help.FailedValidation;
import com.cardRemember.help.ValidatorData;
import com.cardRemember.model.Data;
import com.cardRemember.model.DataType;
import com.cardRemember.view.View;

/**
 * Controller need for management {@link Data} and {@link com.cardRemember.view.View}
 */
public class Controller {
    private View view;
    private Data data;
    private ValidatorData validatorData = new ValidatorData();

    public Controller(Data data, View view) {
        this.data = data;
        this.view = view;
        validatorData.addCustomValidator(new ValidatorDataType());
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public ValidatorData getValidatorData() {
        return validatorData;
    }

    public void setValidatorData(ValidatorData validatorData) {
        this.validatorData = validatorData;
    }

    public void update(){
        validatorData.validation(data);
        view.show(data);
    }

    class ValidatorDataType implements ValidatorData.CustomValidator{
        @Override
        public void validation(Data data) throws FailedValidation {
            DataType dataType = data.getDataType();
            if (dataType != DataType.Menu)
                throw new FailedValidation(
                        String.format("This view not able to display data \"%s\". This view display \"%s\".",
                                dataType,
                                view.getDataType()));
        }
    }

}
