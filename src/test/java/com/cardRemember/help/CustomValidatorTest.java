package com.cardRemember.help;

import com.cardRemember.controller.Controller;
import com.cardRemember.model.Data;
import com.cardRemember.model.DataType;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(DataProviderRunner.class)
public class CustomValidatorTest {

    public static Data createMockData(DataType aDefault) {
        Data mock = mock(Data.class);
        when(mock.getDataType()).thenReturn(aDefault);
        return mock;
    }

    /**
     * Here listed Custom Validators and valid data.
     *
     * @return Array whit data for testing.
     */
    @DataProvider
    public static Object[][] dataValidation() {
        return new Object[][]{
                {new Controller.ValidatorDataType(DataType.Default), createMockData(DataType.Default)},
        };
    }

    /**
     * Here listed Custom Validators and invalid data.
     *
     * @return Array whit data for testing.
     */
    @DataProvider
    public static Object[][] dataNotValidation() {
        return new Object[][]{
                {new Controller.ValidatorDataType(DataType.Default), createMockData(DataType.Menu)},
        };
    }

    @Test
    @UseDataProvider("dataValidation")
    public void validationDataTypeSuccessful(ValidatorData.CustomValidator validator, Data data) throws Exception {
        assertTrue(validator.validation(data));
    }

    @Test
    @UseDataProvider("dataNotValidation")
    public void validationDataTypeFailed(ValidatorData.CustomValidator validator, Data data) throws Exception {
        assertFalse(validator.validation(data));
    }

    @Test
    @UseDataProvider("dataValidation")
    public void checkDefaultLastException(ValidatorData.CustomValidator validator, Data data) throws Exception {
        assertThat(validator.getLastException(), is(ValidatorData.CustomValidator.DEFAULT_LAST_EXCEPTION));
    }

    @Test
    @UseDataProvider("dataNotValidation")
    public void checkLastException(ValidatorData.CustomValidator validator, Data data) throws Exception {
        validator.validation(data);
        assertThat(validator.getLastException(), not(ValidatorData.CustomValidator.DEFAULT_LAST_EXCEPTION));
    }
}