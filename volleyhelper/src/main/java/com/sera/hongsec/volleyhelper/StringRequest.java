package com.sera.hongsec.volleyhelper;

import android.content.Context;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.sera.hongsec.volleyhelper.base.BaseRequest;
import com.sera.hongsec.volleyhelper.imp.StringCallBackListener;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Cant't  do post put method
 * Created by Hongsec on 2016-08-21.
 * email : piaohongshi0506@gmail.com
 * QQ: 251520264
 */
public abstract class  StringRequest<T> extends BaseRequest<T>  {


    @Override
    public void request(Context context, final StringCallBackListener<T> tCallBackListener) {
        super.request(context, tCallBackListener);
        com.android.volley.toolbox.StringRequest stringRequest = new com.android.volley.toolbox.StringRequest(getRequestType(), getRealUrl(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                JSONObject jsonObject= getJJsonObject(response,new JSONObject());

                setResult(jsonObject);

                if(result.status){

                    setResponseData(jsonObject);
                    if(tCallBackListener!=null){
                        tCallBackListener.onResponseString((T)StringRequest.this,response);
                        tCallBackListener.onResponse((T)StringRequest.this);
                    }
                }else{

                    if(tCallBackListener!=null){
                        tCallBackListener.onErrorResponse((T)StringRequest.this);
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                NetworkResponse response = error.networkResponse;
                if (response != null && response.data != null) {

                    try {
                        JSONObject jsonObject = new JSONObject(new String(response.data));
                        setResult(jsonObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if(tCallBackListener!=null){
                        tCallBackListener.onResponseString((T)StringRequest.this,new String(response.data));
                    }
                    if(tCallBackListener!=null){
                        tCallBackListener.onErrorResponse((T) StringRequest.this);
                    }

                    ErrorStatusProcess(response.statusCode);


                }else{

                    if(tCallBackListener!=null){
                        tCallBackListener.onErrorResponse((T) StringRequest.this);
                    }
                }




            }
        });

        VolleyHelper.getRequestqueque(context).add(stringRequest);
    }
}
