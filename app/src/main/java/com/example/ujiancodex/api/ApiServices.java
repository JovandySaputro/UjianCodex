package com.example.ujiancodex.api;

import android.util.Log;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ApiServices {

    private JSONObject params = null;

    public JSONObject listId(){
        params = new JSONObject();

        try{
            params.put(ParamKey.KEY, "pretty");
            return params;
        }catch (JSONException e){
            Log.e("Error ", e.getMessage());
        }
        return params;

    }


}
