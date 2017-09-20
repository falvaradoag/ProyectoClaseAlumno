package com.hame.materialdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void callOpenText(View view)
    {
        startActivity(new Intent(this,TextActivity.class));
    }

    public void callOpenCheckBx(View view)
    {
        startActivity(new Intent(this,ImageOPTActivity.class));
    }
    public void callSelOption(View view)
    {
        startActivity(new Intent(this,SelectedOPTActivity.class));
    }
    public void callSelListOption(View view)
    {
        startActivity(new Intent(this,ListViewActivity.class));
    }
    public void recyclerOption(View view)
    {
        startActivity(new Intent(this,RecyclerActivity.class));
    }

    public void recyclerOptionTarea(View view)
    {
        startActivity(new Intent(this,TareaRecyclerActivity.class));
    }

}
