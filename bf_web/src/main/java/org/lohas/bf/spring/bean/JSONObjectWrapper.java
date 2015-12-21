package org.lohas.bf.spring.bean;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by fule on 14-6-7.
 */
public class JSONObjectWrapper {
    private JSONObject jsonObject;

    public JSONObjectWrapper(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public JSONObjectWrapper() {
    }

    public JSONObject getJSONObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }
}
