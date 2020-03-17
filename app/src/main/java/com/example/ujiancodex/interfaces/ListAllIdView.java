package com.example.ujiancodex.interfaces;



import com.example.ujiancodex.model.listIdInfo;
import com.example.ujiancodex.model.listInfo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public interface ListAllIdView {
    interface View {
        void getAllIdSuccess(ArrayList<String> listidInfos);
        void getAllIdFailed(String message);

        void getAlldataSuccess(listInfo listInfos);
        void getAlldataFailed(String message);

    }

    interface Presenter{
        void init();
    }

}
