package com.hame.materialdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class SelectedOPTActivity extends AppCompatActivity {

    private Spinner sp;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_opt);
        initComponets();
    }
    public void initComponets()
    {
        sp = (Spinner) findViewById(R.id.s_options);
        iv = (ImageView) findViewById(R.id.iv_select);
        String[] options = getResources().getStringArray(R.array.selected_options);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item, //Plantilla definida por android
                options);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position) {
                    case 0:
                        iv.setImageResource(R.drawable.thumbnail_atm);
                        break;
                    case 1:
                        iv.setImageResource(R.drawable.thumbnail_bag);
                        break;
                    case 2:
                        iv.setImageResource(R.drawable.thumbnail_basket);
                        break;
                    case 3:
                        iv.setImageResource(R.drawable.thumbnail_box);
                        break;
                    case 4:
                        iv.setImageResource(R.drawable.thumbnail_briefcase);
                        break;
                    case 5:
                        iv.setImageResource(R.drawable.thumbnail_calculator);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }




}
