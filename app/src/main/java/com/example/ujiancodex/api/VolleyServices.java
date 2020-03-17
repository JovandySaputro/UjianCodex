package com.example.ujiancodex.api;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class VolleyServices {

    private IResult mResultCallback = null;
    private IResultObject mResultCallbackObject = null;
    private Context mContext;
    private RequestQueue requestQueue;

    public VolleyServices(IResult resultCallback, Context context) {
        mResultCallback = resultCallback;
        mContext = context;
    }
    public VolleyServices(IResultObject resultCallback, Context context) {
        mResultCallbackObject = resultCallback;
        mContext = context;
    }


    public void getDataVolley(String url) {
        String baseUrl = "https://hacker-news.firebaseio.com/v0/" + url;
        try {
            JsonArrayRequest jr = new JsonArrayRequest(Request.Method.GET, baseUrl, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    if (mResultCallback != null)
                        mResultCallback.notifySuccess(response);
                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (mResultCallback != null)
                        mResultCallback.notifyError(error);
                }
            }) {
            };
            Volley.newRequestQueue(mContext).add(jr);

        } catch (Exception e) {

        }
    }
    public void getDataObjectVolley(String url) {
        String baseUrl = "https://hacker-news.firebaseio.com/v0/" + url;
        try {
            JsonObjectRequest jr = new JsonObjectRequest(Request.Method.GET, baseUrl, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    if (mResultCallbackObject != null)
                        mResultCallbackObject.notifyJSonSuccess(response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (mResultCallbackObject != null)
                        mResultCallbackObject.notifyJSonError(error);
                }
            }) {
            };
            Volley.newRequestQueue(mContext).add(jr);

        } catch (Exception e) {

        }
    }

}
