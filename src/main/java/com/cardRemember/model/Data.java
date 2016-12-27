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
    private Map<String, Object> mapData = new HashMap<>();

    public Data(DataType dataType, Map<String, Object> mapData) {
        this.dataType = dataType;
        this.mapData = mapData;
    }

    public Data(DataType dataType) {
        this.dataType = dataType;
    }

    public DataType getDataType() {
        return dataType;
    }

    /**
     * Set value in model.
     *
     * @param key   Key for get value. Not equals null.
     * @param value Value which need set.
     */
    public void setValue(String key, Object value) {
        if (key == null) throw new IllegalArgumentException("Key not equals null.");
        mapData.put(key, value);
    }

    /**
     * Get data of model on key.
     *
     * @param key Key for data. Not equals null.
     * @return Data appropriate key.
     * @throws FailedGettingData If failed get data.
     */
    public Object getValue(String key) throws FailedGettingData {
        if (key == null) throw new IllegalArgumentException("Key not equals null.");
        Object o = mapData.get(key);
        if (o == null) {
            FailedGettingData failedGettingData = new FailedGettingData("Failed found data by key = " + key);
            LOGGER.warn(failedGettingData);
            throw failedGettingData;
        }
        return o;
    }

    public <T> T getValue(String key, Class<T> valueClass) throws FailedGettingData {
        Object value = getValue(key);
        if (!valueClass.isAssignableFrom(value.getClass())) {
            FailedGettingData failedGettingData = new FailedGettingData(
                    String.format("Failed get by value key = %s valueClass = %s",
                            key, valueClass));
            LOGGER.warn(failedGettingData);
            throw failedGettingData;
        }
        return (T) value;
    }

    /**
     * Get data of model on key whit cast data in String.
     *
     * @param key Key for data.
     * @return Data appropriate key.
     * @throws FailedGettingData If failed get data.
     */
    public String getString(String key) throws FailedGettingData {
        String data;
        try {
            data = (String) getValue(key);
        } catch (ClassCastException e) {
            FailedGettingData failed = new FailedGettingData("Failed get string by key = " + key, e);
            LOGGER.warn(failed);
            throw failed;
        }
        return data;
    }

    /**
     * Get data of model on key whit cast data in int.
     *
     * @param key Key for data.
     * @return Data appropriate key.
     * @throws FailedGettingData If failed get data.
     */
    public int getInt(String key) throws FailedGettingData {
        int data;
        try {
            String s = getValue(key).toString();
            data = Integer.parseInt(s);
        } catch (ClassCastException | NumberFormatException e) {
            FailedGettingData failed = new FailedGettingData("Failed get int by key = " + key, e);
            LOGGER.warn(failed);
            throw failed;
        }
        return data;
    }

    public int getSize() {
        return mapData.size();
    }

    public void clear() {
        mapData.clear();
    }

    @Override
    public String toString() {
        return "Data{" +
                "dataType=" + dataType +
                ", mapData=" + mapData +
                '}';
    }
}
