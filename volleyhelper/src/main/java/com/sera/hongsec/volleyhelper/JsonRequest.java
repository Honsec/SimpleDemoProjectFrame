package com.sera.hongsec.volleyhelper;

import android.content.Context;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.sera.hongsec.volleyhelper.base.BaseRequest;
import com.sera.hongsec.volleyhelper.imp.CallBackListener;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Most of all ok
 * Created by Hongsec on 2016-08-21.
 * email : piaohongshi0506@gmail.com
 * QQ: 251520264
 */
public abstract class JsonRequest<T> extends BaseRequest<T> {

    @Override
    public void request(Context context, final CallBackListener<T> tCallBackListener) {
        super.request(context, tCallBackListener);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(getRequestType(), getRealUrl(), getHeaders(), new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                setResult(response);

                if (result.status) {

                    setResponseData(response);
                    if (tCallBackListener != null) {
                        tCallBackListener.onResponse((T) JsonRequest.this);
                    }
                } else {

                    if (tCallBackListener != null) {
                        tCallBackListener.onErrorResponse((T) JsonRequest.this);
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

                    ErrorStatusProcess(response.statusCode);
                    if (tCallBackListener != null) {
                        tCallBackListener.onErrorResponse((T) JsonRequest.this);
                    }

                } else {

                    if (tCallBackListener != null) {
                        tCallBackListener.onErrorResponse((T) JsonRequest.this);
                    }
                }

            }
        });

        VolleyHelper.getRequestqueque(context).add(jsonObjectRequest);

    }


}
