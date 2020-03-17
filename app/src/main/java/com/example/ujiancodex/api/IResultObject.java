package com.example.ujiancodex.api;

import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

public interface IResultObject {


    void notifyJSonSuccess(JSONObject response);
    void notifyJSonError(VolleyError error);
}
