package com.example.ujiancodex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.ujiancodex.interfaces.ListAllIdView;
import com.example.ujiancodex.model.listIdInfo;
import com.example.ujiancodex.model.listInfo;
import com.example.ujiancodex.presenter.ListAllIdPresenter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListAllIdView.View {
    ListAllIdPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new ListAllIdPresenter(this,this);
        presenter.init();
    }


    @Override
    public void getAllIdSuccess(ArrayList<String> listInfos) {
        Toast.makeText(this, "sukses", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getAllIdFailed(String message) {
        Toast.makeText(this, "gagal", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getAlldataSuccess(listInfo listInfos) {

    }



    @Override
    public void getAlldataFailed(String message) {

    }
}
