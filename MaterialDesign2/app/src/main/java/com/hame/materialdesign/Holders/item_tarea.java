package com.hame.materialdesign.Holders;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hame.materialdesign.R;


public class item_tarea extends RecyclerView.ViewHolder {
    private CardView cvBackgroud;
    private ImageView img;
    private TextView txt;


    public item_tarea(View itemView) {
        super(itemView);


        cvBackgroud=itemView.findViewById(R.id.cv_tarea);
        img=itemView.findViewById(R.id.imageView4);
        txt=itemView.findViewById(R.id.textView);

    }

    public void setData (int imageResource,String label){

        img.setImageResource(imageResource);
        txt.setText(label);
    }


}
