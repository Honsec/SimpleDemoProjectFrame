package com.sera.hongsec.volleyhelper;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Hongsec on 2016-08-21.
 * email : piaohongshi0506@gmail.com
 * QQ: 251520264
 */
public class VolleyHelper {


    private static RequestQueue requestQueue;

    /**
     *
     * @param applicationContext
     */
    public static RequestQueue getRequestqueque(Context applicationContext){
        if(requestQueue==null){
            requestQueue = Volley.newRequestQueue(applicationContext);
        }
        return requestQueue;
    }


}
