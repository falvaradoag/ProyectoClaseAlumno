package com.hame.materialdesign.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hame.materialdesign.Holders.item_holder;
import com.hame.materialdesign.R;


public class item_Adapter extends RecyclerView.Adapter<item_holder> {

    private  int[] imageResour;
    private  String[] label;
    private Context context;




    @Override
    public item_holder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflat=  LayoutInflater.from(context);

        View view =inflat.inflate(R.layout.item_holder,parent,false);

        return new item_holder(view);
    }

    @Override
    public void onBindViewHolder(item_holder holder, int position) {

        holder.setData(imageResour [position],label[position]);

    }

    @Override
    public int getItemCount() {
        return label.length;
    }

    public item_Adapter(int[] imageResour, String[] label, Context context) {
        this.imageResour = imageResour;
        this.label = label;
        this.context = context;
    }


}
