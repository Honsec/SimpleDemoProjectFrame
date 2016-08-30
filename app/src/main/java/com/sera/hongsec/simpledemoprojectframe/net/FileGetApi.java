package com.sera.hongsec.simpledemoprojectframe.net;

import com.sera.hongsec.volleyhelper.MultiRequest;
import com.sera.hongsec.volleyhelper.base.MultipartRequestParams;

import org.json.JSONObject;

/**
 * Created by Hongsec on 2016-08-31.
 * email : piaohongshi0506@gmail.com
 * QQ: 251520264
 */
public class FileGetApi extends MultiRequest<FileGetApi> {

    @Override
    public MultipartRequestParams getMultiParamHeaders() {
        return null;
    }

    @Override
    public int getRequestType() {
        return 0;
    }

    @Override
    public String getRequestUrl() {
        return null;
    }

    @Override
    public void setResponseData(JSONObject response) {

    }
}
