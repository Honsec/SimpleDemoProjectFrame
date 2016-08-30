package com.sera.hongsec.volleyhelper.imp;

import org.json.JSONObject;

/**
 * Created by Hongsec on 2016-08-21.
 * email : piaohongshi0506@gmail.com
 * QQ: 251520264
 */
public interface VolleyParam<T>{
    public int getRequestType();
    public String getRequestUrl();
    /**
     * Post 提交时的添加数据
     * @return
     */
    public JSONObject getHeaders();

    /**
     * 只返回 status = true 时候的数据。
     * @param response
     */
    public void setResponseData(JSONObject response);



}
