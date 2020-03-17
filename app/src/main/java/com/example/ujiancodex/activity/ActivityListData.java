package com.example.ujiancodex.activity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.ujiancodex.R;
import com.example.ujiancodex.adapter.listAdapter;
import com.example.ujiancodex.interfaces.ListAllIdView;
import com.example.ujiancodex.model.listInfo;
import com.example.ujiancodex.presenter.ListAllIdPresenter;

import java.util.ArrayList;

public class ActivityListData extends AppCompatActivity implements ListAllIdView.View {
    private Context mContext;
    private ListAllIdPresenter presenter;
    private RecyclerView list;
    private ArrayList<listInfo> listInfosall = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_top_story);
        mContext = this;
        list = findViewById(R.id.list_data);
        presenter = new ListAllIdPresenter(this,this);
        presenter.init();

        list.setHasFixedSize(true);
        list.setNestedScrollingEnabled(false);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        list.setLayoutManager(staggeredGridLayoutManager);



    }


    @Override
    public void getAllIdSuccess(ArrayList<String> listInfos) {
        RecyclerView.Adapter mAdapterEtalase = new listAdapter(mContext,listInfos);
        list.setAdapter(mAdapterEtalase);
//        for (int i = 0; i < listInfos.size(); i++){
//            presenter.getlist(listInfos.get(i)+".json");
//            listInfosall.add()
//        }

        Toast.makeText(this, "sukses", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getAllIdFailed(String message) {
        Toast.makeText(this, "gagal", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getAlldataSuccess(listInfo listInfos) {
//        RecyclerView.Adapter mAdapterEtalase = new listAdapter(mContext,listInfos);
//        list.setAdapter(mAdapterEtalase);
        Toast.makeText(this, "sukses list", Toast.LENGTH_SHORT).show();
    }



    @Override
    public void getAlldataFailed(String message) {
        Toast.makeText(this, "gagal list", Toast.LENGTH_SHORT).show();
    }
}