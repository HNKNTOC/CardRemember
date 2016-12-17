package com.cardRemember.controller;

import com.cardRemember.help.FailedValidation;
import com.cardRemember.help.ValidatorData;
import com.cardRemember.model.Data;
import com.cardRemember.model.DataType;
import com.cardRemember.view.View;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ControllerTest {

    private Controller controller = new Controller();

    @Test(expected = UnsupportedOperationException.class)
    public void whenNotSetViewThrowsException() throws Exception {
        controller.update();
    }

    @Test
    public void whenCheckDataTypeBeforeUpdate() throws Exception {
        ValidatorData validator = mock(ValidatorData.class);
        Data data = mock(Data.class);
        View view = mock(View.class);

        when(view.getDataType()).thenReturn(DataType.Default);

        controller.setData(data);
        controller.setView(view);
        controller.setValidatorData(validator);
        controller.update();

        verify(validator, atLeastOnce()).validation(data);
    }

    @Test()
    public void whenDataTypeValidationUpdateSuccessful() throws Exception {
        updateData(DataType.Default);
    }

    @Test(expected = FailedValidation.class)
    public void whenDataTypeNotValidationUpdateFailed() throws Exception {
        updateData(DataType.Menu);
    }

    private Controller.ValidatorDataType validator = new Controller.ValidatorDataType(DataType.Default);

    private void updateData(DataType dataTypeForData) {
        Data data = new Data(dataTypeForData);
        View view = mock(View.class);

        when(view.getDataType()).thenReturn(DataType.Default);

        controller.setData(data);
        controller.setView(view);
        controller.update();
    }

    @Test
    public void validationDataTypeSuccessful() throws Exception {
        Data mock = mock(Data.class);
        when(mock.getDataType()).thenReturn(DataType.Default);
        assertTrue(validator.validation(mock));
        assertThat(validator.getLastException(), is(Controller.ValidatorDataType.DEFAULT_LAST_EXCEPTION));
    }

    @Test
    public void validationDataTypeFailed() throws Exception {
        Data mock = mock(Data.class);
        when(mock.getDataType()).thenReturn(DataType.Menu);
        assertFalse(validator.validation(mock));
        assertThat(validator.getLastException(), not(Controller.ValidatorDataType.DEFAULT_LAST_EXCEPTION));
    }
}