package com.cardRemember.model;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;


@RunWith(DataProviderRunner.class)
public class DataTest {
    private Data data = new Data(DataType.Default);
    private String testString = "Test String";
    private String keyForString = "KeyForString";

    @DataProvider(format = "%m ( %p[0], %p[1] )")
    public static Object[][] dataForTestingExtraction() {
        return new Object[][]{
                {"KeyForObject", new Object()},
                {"KeyForString", "Test String"},
                {"KeyForInt"   , 12},
        };
    }

    @Test
    @UseDataProvider("dataForTestingExtraction")
    public void checkGetData(String key, Object value) throws Exception {
        data.setValue(key, value);
        assertEquals("Failed getting data by key = " + key, data.getValue(key), value);
    }

    @Test
    public void checkClear() throws Exception {
        data.setValue(keyForString,testString);
        assertEquals(data.getSize(),1);
        data.clear();
        assertEquals(data.getSize(),0);


    }

    @Test()
    public void checkDataType() throws Exception {
        assertTrue(data.getDataType() == DataType.Default);
    }

    @Test(expected=IllegalArgumentException.class)
    public void ifKeyEqualsNull() throws Exception {
        data.setValue(null,new Object());
    }

    @Test(expected=FailedGettingData.class)
    public void ifDataNotFound() throws Exception {
        data.getValue(keyForString);
    }

    @Test()
    public void getStringOfData() throws Exception {
        data.setValue(keyForString, testString);
        assertEquals(data.getString(keyForString),testString);
    }

    @Test(expected = FailedGettingData.class)
    public void getFailingStringOfData() throws Exception {
        data.setValue(keyForString, new Object());
        data.getString(keyForString);
    }

    @Test()
    public void getIntOfData() throws Exception {
        final int value = 5432;
        data.setValue(keyForString, value);
        assertEquals(data.getInt(keyForString),value);
    }

    @Test(expected = FailedGettingData.class)
    public void getFailingIntOfData() throws Exception {
        data.setValue(keyForString, testString);
        data.getInt(keyForString);
    }

    @Test
    public void getValueForClassSuccessful() throws Exception {
        final String keyForObject = "keyForObject";
        data.setValue(keyForObject, new ArrayList<String>());
        ArrayList value = data.getValue(keyForObject, ArrayList.class);
        assertThat(value, instanceOf(ArrayList.class));
    }

    @Test(expected = FailedGettingData.class)
    public void getValueForClassFailed() throws Exception {
        final String keyForObject = "keyForObject";
        data.setValue(keyForObject, new HashMap<>());
        data.getValue(keyForObject, ArrayList.class);
    }
}