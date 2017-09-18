package com.hame.materialdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TextActivity extends AppCompatActivity {

    public EditText etIng;
    public TextView txtVw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        initComponents();
    }
    private  void initComponents(){
        etIng = (EditText) findViewById(R.id.editText);
        txtVw = (TextView) findViewById(R.id.textView);

    }

    public void readText(View view){
        String text = etIng.getText().toString();
        if ((text != null) && (!text.trim().isEmpty())){
            txtVw.setText(text);
        }else {
            txtVw.setText("");
            Toast.makeText(this,getString(R.string.msj_empty_text), Toast.LENGTH_LONG).show();
        }
    }
}
