package com.sera.hongsec.simpledemoprojectframe.net;

import com.sera.hongsec.volleyhelper.JsonRequest;

import org.json.JSONObject;

/**
 * Created by Hongsec on 2016-08-31.
 * email : piaohongshi0506@gmail.com
 * QQ: 251520264
 */
public class EmptyApi extends JsonRequest<EmptyApi> {

    @Override
    public int getRequestType() {
        return 0;
    }

    @Override
    public String getRequestUrl() {
        return null;
    }

    @Override
    public JSONObject getHeaders() {
        return null;
    }

    @Override
    public void setResponseData(JSONObject response) {

    }
}
