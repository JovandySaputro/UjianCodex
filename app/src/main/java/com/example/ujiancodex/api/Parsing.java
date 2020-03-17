package com.example.ujiancodex.api;


import com.example.ujiancodex.model.listIdInfo;
import com.example.ujiancodex.model.listInfo;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Parsing {

    Gson gson = new Gson();

    public String DeNumber(float number){
        DecimalFormat formatter = new DecimalFormat("#,###,###,###");
        return formatter.format(number);
    }

    public ArrayList<String> ParseArray(JSONObject respContent) {
        ArrayList<String> arrayList = new ArrayList<>();
        String varData;
        try {
            varData = respContent.get("data").toString();
            try {
                JSONArray jsonArray = new JSONArray(varData);
                for (int i = 0; i < jsonArray.length(); i++) {
                    String object = jsonArray.get(i).toString();
                    arrayList.add(object);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }


    public String ParsingItems(String data) {

        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonArray = new JSONArray(jsonObject.getJSONArray("items"));
            return  jsonArray.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "";
    }



    public ArrayList<String> ParsingCategory(String data) {
        ArrayList<String> dataList = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(data);
            for (int i = 0; i < jsonArray.length(); i++) {
               dataList.add(jsonArray.get(i).toString());
            }
            return dataList;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return dataList;
    }

    public ArrayList<String> ParsingJenisProduct(JSONObject data) {
        ArrayList<String> dataList = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(data);
            for (int i = 0; i < jsonArray.length(); i++) {
                dataList.add(jsonArray.get(i).toString());
            }
            return dataList;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return dataList;
    }
    public listInfo ParsingList (JSONObject response) {

        return gson.fromJson(String.valueOf(response),listInfo.class);
    }
    public ArrayList<String> ParsingListId (JSONArray response) {
        ArrayList<String> dataList = new ArrayList<>();
        try {
        for (int i = 0; i < response.length(); i++) {
            String object = response.get(i).toString();
            dataList.add(object);
        }
        return dataList;
        } catch (JSONException e) {
            e.printStackTrace();
        }return dataList;
    }
}
