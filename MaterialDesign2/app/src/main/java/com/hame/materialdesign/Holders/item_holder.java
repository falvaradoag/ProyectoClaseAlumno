package com.hame.materialdesign.Holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hame.materialdesign.R;

public class item_holder extends RecyclerView.ViewHolder {

    private ImageView imgview;
    private TextView txtview;

    public item_holder(View itemView) {
        super(itemView);

        imgview =  itemView.findViewById(R.id.imageView3);
        txtview=  itemView.findViewById(R.id.txt_Ejemplo);


    }

    public void setData(int imageResour, String Label){
        imgview.setImageResource(imageResour);
        txtview.setText(Label);
    }

}
