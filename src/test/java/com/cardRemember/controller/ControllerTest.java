package com.cardRemember.controller;

import com.cardRemember.help.ValidatorData;
import com.cardRemember.model.Data;
import com.cardRemember.model.DataType;
import com.cardRemember.view.View;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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

        controller.setData(data);
        controller.setView(mock(View.class));
        controller.setValidatorData(validator);
        controller.update();

        verify(validator, atLeastOnce()).validation(data);
    }

    private Controller.ValidatorDataType validator = new Controller.ValidatorDataType(DataType.Default);

    @Test
    public void validationDataTypeSuccessful() throws Exception {
        Data mock = mock(Data.class);
        when(mock.getDataType()).thenReturn(DataType.Default);
        assertTrue(validator.validation(mock));
    }

    @Test
    public void validationDataTypeFailed() throws Exception {
        Data mock = mock(Data.class);
        when(mock.getDataType()).thenReturn(DataType.Menu);
        assertFalse(validator.validation(mock));
    }
}