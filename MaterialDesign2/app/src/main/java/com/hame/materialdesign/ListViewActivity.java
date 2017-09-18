package com.hame.materialdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lv;
    private ImageView imv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initComponets();
    }
    public void initComponets()
    {
        lv = (ListView) findViewById(R.id.lv_opt);
        imv = (ImageView) findViewById(R.id.iv_lV);
        String[] options = getResources().getStringArray(R.array.selected_options);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                options);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0:
                imv.setImageResource(R.drawable.thumbnail_atm);
                break;
            case 1:
                imv.setImageResource(R.drawable.thumbnail_bag);
                break;
            case 2:
                imv.setImageResource(R.drawable.thumbnail_basket);
                break;
            case 3:
                imv.setImageResource(R.drawable.thumbnail_box);
                break;
            case 4:
                imv.setImageResource(R.drawable.thumbnail_briefcase);
                break;
            case 5:
                imv.setImageResource(R.drawable.thumbnail_calculator);
                break;
        }
    }
}
