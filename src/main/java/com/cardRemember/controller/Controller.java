package com.cardRemember.controller;

import com.cardRemember.help.FailedValidation;
import com.cardRemember.help.ValidatorData;
import com.cardRemember.model.Data;
import com.cardRemember.model.DataType;
import com.cardRemember.view.View;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Controller need for management {@link Data} and {@link com.cardRemember.view.View}
 */
public class Controller {
    private static final Logger LOGGER = LogManager.getLogger(Controller.class);
    private View view;
    private Data data;
    private ValidatorData validatorData = new ValidatorData();

    public Controller(Data data, View view) {
        this.data = data;
        this.view = view;
        validatorData.addCustomValidator(new ValidatorDataType(view.getDataType()));
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

    static class ValidatorDataType implements ValidatorData.CustomValidator{
        private static final Logger LOGGER = LogManager.getLogger(ValidatorDataType.class);
        private final DataType validationDataType;

        public ValidatorDataType(DataType validationDataType) {
            this.validationDataType = validationDataType;
        }

        @Override
        public void validation(Data data) throws FailedValidation {
            DataType dataType = data.getDataType();
            if (dataType != this.validationDataType) {
                FailedValidation failedValidation = new FailedValidation(
                        String.format("This view not able to display data \"%s\". This view display \"%s\".",
                                dataType,
                                this.validationDataType));
                LOGGER.warn(failedValidation);
                throw failedValidation;
            }
        }
    }

}
