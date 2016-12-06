package com.cardRemember.model;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains logic applications.
 */
public class Data {
    private static final Logger LOGGER = LogManager.getLogger(Data.class);
    private final DataType dataType;
    private Map<String,Object> mapData = new HashMap<>();

    public Data(DataType dataType) {
        this.dataType = dataType;
    }



    public DataType getDataType() {
        return dataType;
    }

    /**
     * Set data in model.
     * @param key Key for get data. Not equals null.
     * @param data Data which need set.
     */
    public void setData(String key,Object data){
        if (key == null) throw new IllegalArgumentException("Key not equals null.");
        mapData.put(key,data);
    }

    /**
     * Get data of model on key.
     * @param key Key for data. Not equals null.
     * @return Data appropriate key.
     * @throws FailedGettingData If failed get data.
     */
    public Object getData(String key) throws FailedGettingData {
        if (key == null) throw new IllegalArgumentException("Key not equals null.");
        Object o = mapData.get(key);
        if (o == null) {
            FailedGettingData failedGettingData = new FailedGettingData("Failed found data by key = " + key);
            LOGGER.warn(failedGettingData);
            throw failedGettingData;
        }
        return o;
    }

    /**
     * Get data of model on key whit cast data in String.
     * @param key Key for data.
     * @return Data appropriate key.
     * @throws FailedGettingData If failed get data.
     */
    public String getString(String key) throws FailedGettingData {
        String data;
        try {
            data = (String) getData(key);
        } catch (ClassCastException  e) {
            FailedGettingData failed = new FailedGettingData("Failed get string by key = " + key, e);
            LOGGER.warn(failed);
            throw failed;
        }
        return data;
    }

    /**
     * Get data of model on key whit cast data in int.
     * @param key Key for data.
     * @return Data appropriate key.
     * @throws FailedGettingData If failed get data.
     */
    public int getInt(String key) throws FailedGettingData {
        int data;
        try {
            String s = getData(key).toString();
            data = Integer.parseInt(s);
        } catch (ClassCastException | NumberFormatException e) {
            FailedGettingData failed = new FailedGettingData("Failed get int by key = " + key, e);
            LOGGER.warn(failed);
            throw failed;
        }
        return data;
    }
}
