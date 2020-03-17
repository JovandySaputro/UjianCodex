package com.example.ujiancodex.presenter;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.VolleyError;

import com.example.ujiancodex.api.ApiServices;
import com.example.ujiancodex.api.IResult;
import com.example.ujiancodex.api.IResultObject;
import com.example.ujiancodex.api.MethodKey;
import com.example.ujiancodex.api.Parsing;
import com.example.ujiancodex.api.VolleyServices;
import com.example.ujiancodex.interfaces.ListAllIdView;
import com.example.ujiancodex.model.listIdInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ListAllIdPresenter implements ListAllIdView.Presenter {
    private Context context;

    private ListAllIdView.View view;

    private IResult getIdCallback;
    private IResultObject getListCallback;
    private VolleyServices volleyServices;
    private ApiServices params;
    private Parsing parse;
    private MethodKey method;
    String jenisproduct;
    public ListAllIdPresenter(Context context, ListAllIdView.View view) {
        this.context = context;
        this.view = view;
        params = new ApiServices();
        parse = new Parsing();
    }

    public void GetAllid() {
        InitGetProductResultCallback();
        volleyServices = new VolleyServices(getIdCallback, context);
        volleyServices.getDataVolley(MethodKey.KEY_GET_ID);
    }


    private void InitGetProductResultCallback() {
        getIdCallback = new IResult() {
            @Override
            public void notifySuccess(JSONArray response) {
                getidProcess(response);

            }

            @Override
            public void notifyError(VolleyError error) {
                view.getAllIdFailed(error.getMessage());
            }
        };
    }

    private void getidProcess(JSONArray response) {
        Parsing parse = new Parsing();
        view.getAllIdSuccess(parse.ParsingListId(response));
    }

    private void GetLisProcess(JSONObject response) {
        Parsing parse = new Parsing();
        view.getAlldataSuccess(parse.ParsingList(response));
    }

    private void getallList(String id) {
        initSubKategoriProductResultCallback();
        volleyServices = new VolleyServices(getListCallback, context);
        volleyServices.getDataObjectVolley(MethodKey.KEY_GET_LIST +id);
    }

    private void initSubKategoriProductResultCallback() {
        getListCallback = new IResultObject() {


            @Override
            public void notifyJSonSuccess(JSONObject response) {
                GetLisProcess(response);
            }

            @Override
            public void notifyJSonError(VolleyError error) {

            }
        };

    }

    @Override
    public void init() {
        GetAllid();
    }
    public void getlist(String jenisproduct){
        this.jenisproduct = jenisproduct;
        getallList(jenisproduct);
    }
}
