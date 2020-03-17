package com.example.ujiancodex.api;

import com.android.volley.VolleyError;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONObject;

public interface IResult {

    void notifySuccess(JSONArray response);
    void notifyError(VolleyError error);

}
