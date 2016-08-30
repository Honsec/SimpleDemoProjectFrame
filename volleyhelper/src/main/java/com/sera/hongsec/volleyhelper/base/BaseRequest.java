package com.sera.hongsec.volleyhelper.base;

import android.content.Context;
import android.text.TextUtils;

import com.sera.hongsec.volleyhelper.ssl.HttpsTrustManager;
import com.sera.hongsec.volleyhelper.bean.Result;
import com.sera.hongsec.volleyhelper.imp.CallBackListener;
import com.sera.hongsec.volleyhelper.imp.StringCallBackListener;
import com.sera.hongsec.volleyhelper.imp.VolleyParam;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;

/**
 * Created by Hongsec on 2016-08-21.
 * email : piaohongshi0506@gmail.com
 * QQ: 251520264
 */
public abstract class BaseRequest<T> extends JsonParseUtil implements VolleyParam {

    /**
     * Api basic result
     */
    public Result result = new Result();

    /**
     * 主页地址
     */
    public String baseUrl() {

        //TODO  debug mode or other
        return "http://www.baidu.com";

    }

    /**
     *  如果需要自定义异常信息可继承这个。 详细信息在 api bean中
     * @param statusCode
     */
    public void ErrorStatusProcess(int statusCode){
        switch (statusCode){

            case 401:
                //TODO logout
                break;
            case 409:
                //TODO error
                break;

        };
    }
    /**
     *
     * @param context   must Application Context
     * @param tCallBackListener
     */
    public void request(Context context, final CallBackListener<T> tCallBackListener){
        HttpsTrustManager.allowAllSSL();
    };
    public void request(Context context, final StringCallBackListener<T> tCallBackListener){
        HttpsTrustManager.allowAllSSL();
    };


    public String getRealUrl() {

        StringBuilder stringBuilder = new StringBuilder();
        if (getRequestUrl().contains("http://") || getRequestUrl().contains("https://")) {
            stringBuilder.append(getRequestUrl());
        } else {
            stringBuilder.append(baseUrl());
        }
        stringBuilder.append("?");
        stringBuilder.append(getHeaderLink());
        stringBuilder.append(getCommonParams());

        return stringBuilder.toString();
    }

    private String getCommonParams() {

        //  mid=&ses=
        return "";
    }

    /**
     * 添加的属性值
     *
     * @return
     */
    public String getHeaderLink() {

        JSONObject headers = getHeaders();
        StringBuilder stringBuilder = new StringBuilder();
        if (headers != null) {
            Iterator<String> keys = headers.keys();

            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    stringBuilder.append("&");
                    stringBuilder.append(URLEncoder.encode(next, "utf8"));
                    stringBuilder.append("=");
                    if (!TextUtils.isEmpty(getJString(headers, next, ""))) {
                        stringBuilder.append(headers.getString(next));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException se) {
                    se.printStackTrace();
                }

            }

        }
//        MultipartRequestParams multiParamHeaders = getMultiParamHeaders();
//        multiParamHeaders.

        return stringBuilder.toString();
    }


    public void setResult(JSONObject response) {
        result.status = getJBoolean(response, "status", false);
        result.eror = getJInteger(response, "status", 0);
        result.msg = getJString(response, "status", "");
    }









}
