package com.roberto.manfreda.live.chat.persistence;

import java.util.HashMap;
import java.util.Map;

public class VolatileModel {
    protected static final String TAG = VolatileModel.class.getSimpleName();

    private final Map<String, Object> beansMap = new HashMap<>();

    public void putBean(String key, Object object) {
        this.beansMap.put(key, object);
    }

    public Object getBean(String key) {
        return this.beansMap.get(key);
    }

}
