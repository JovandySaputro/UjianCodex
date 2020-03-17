package com.example.ujiancodex.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.ujiancodex.R;
import com.example.ujiancodex.model.listInfo;

import java.util.ArrayList;

@SuppressLint("SetTextI18n")
public class listAdapter extends RecyclerView.Adapter<listAdapter.ViewHolder> {
    Context mContext;
    private ArrayList<String> listInfos;


    public listAdapter(Context mContext, ArrayList<String> listInfos) {
        super();
        this.mContext = mContext;
        this.listInfos = listInfos;
    }


    @NonNull
    @Override
    public listAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_top_story, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull listAdapter.ViewHolder holder, int i) {
        holder.tvJudul.setText("id : " + listInfos.get(i));

    }

    @Override
    public int getItemCount() {
        return listInfos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{


        private TextView tvNumber, tvJudul, tvDate, tvTime;
        public ViewHolder(View itemView) {
            super(itemView);
//            imgproduk = itemView.findViewById(R.id.imageViewHeader);

            tvJudul = itemView.findViewById(R.id.etJudul);


        }

    }
}

