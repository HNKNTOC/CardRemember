package com.cardRemember.model;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains logic applications.
 */
public abstract class Model {
    private static final Logger LOGGER = LogManager.getLogger(Model.class);

    private Map<String,Object> mapData = new HashMap<>();

    /**
     * Set data in model.
     * @param key Key for get data.
     * @param data Data which need set.
     */
    protected void setData(String key,Object data){
        mapData.put(key,data);
    }

    /**
     * Get data of model on key.
     * @param key Key for data.
     * @return Data appropriate key.
     * @throws NotFoundData If data not found.
     */
    public Object getData(String key) throws NotFoundData {
        Object o = mapData.get(key);
        if (o == null) {
            LOGGER.info("Failed get data "+key);
            throw new NotFoundData("Failed get data "+key);
        }
        return o;
    }
}
