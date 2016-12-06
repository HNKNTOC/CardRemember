package com.cardRemember.model;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

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
    public void checkGetData(String key,Object value) throws Exception {
        data.setData(key,value);
        assertEquals("Failed getting data by key = "+key,data.getData(key),value);
    }

    @Test(expected=IllegalArgumentException.class)
    public void ifKeyEqualsNull() throws Exception {
        data.setData(null,new Object());
    }

    @Test(expected=FailedGettingData.class)
    public void ifDataNotFound() throws Exception {
        data.getData(keyForString);
    }

    @Test()
    public void getStringOfData() throws Exception {
        data.setData(keyForString, testString);
        assertEquals(data.getString(keyForString),testString);
    }

    @Test(expected = FailedGettingData.class)
    public void getFailingStringOfData() throws Exception {
        data.setData(keyForString, new Object());
        data.getString(keyForString);
    }

    @Test()
    public void getIntOfData() throws Exception {
        int value = 5432;
        data.setData(keyForString, value);
        assertEquals(data.getInt(keyForString),value);
    }

    @Test(expected = FailedGettingData.class)
    public void getFailingIntOfData() throws Exception {
        data.setData(keyForString, testString);
        data.getInt(keyForString);
    }
}