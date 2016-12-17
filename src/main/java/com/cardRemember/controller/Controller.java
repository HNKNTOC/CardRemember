package com.cardRemember.controller;

import com.cardRemember.help.FailedValidation;
import com.cardRemember.help.ValidatorData;
import com.cardRemember.model.Data;
import com.cardRemember.model.DataType;
import com.cardRemember.view.FailedViewModel;
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
    private ValidatorData validatorData;

    public Controller(Data data, View view) {
        this.data = data;
        this.view = view;
        initDefaultValidator(view);
    }

    public Controller() {
        this(new Data(DataType.Default), new DefaultView());
    }

    private void initDefaultValidator(View view) {
        validatorData = new ValidatorData();
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

    public void update() throws FailedValidation, FailedViewModel {
        validatorData.validation(data);
        view.show(data);
    }

    /**
     * This ValidatorDataType check DataType in Data.
     */
    static class ValidatorDataType implements ValidatorData.CustomValidator {
        private final DataType validationDataType;
        public static final String DEFAULT_LAST_EXCEPTION = "No last exception.";
        private String lastException = DEFAULT_LAST_EXCEPTION;

        public ValidatorDataType(DataType validationDataType) {
            this.validationDataType = validationDataType;
        }

        public DataType getValidationDataType() {
            return validationDataType;
        }

        @Override
        public boolean validation(Data data) {
            if (data.getDataType() == this.validationDataType) {
                return true;
            }
            updateLastException();
            return false;
        }

        @Override
        public String getLastException() {
            return this.lastException;
        }

        /**
         * Use when data not validation.
         */
        private void updateLastException() {
            this.lastException = "DataType not equal " + this.validationDataType;
        }
    }

    private static class DefaultView implements View {

        public DefaultView() {
        }

        @Override
        public DataType getDataType() {
            return DataType.Default;
        }

        @Override
        public void show(Data data) throws FailedViewModel {
            throw new UnsupportedOperationException("This a mock implementation view. Set view for controller.");

        }

        @Override
        public void update() {
            throw new UnsupportedOperationException("This a mock implementation view. Set view for controller.");

        }

        @Override
        public void close() {
            throw new UnsupportedOperationException("This a mock implementation view. Set view for controller.");

        }
    }

}
