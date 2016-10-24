package com.example.bayembaye.myapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.bayembaye.myapp.R;

/**
 * this activity is for making anoncement for an specific user
 * it's gonna be write to the server and interne database
 */

public class DoAnonce extends AppCompatActivity {
    private EditText detailA;
    private Spinner spinnerlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_anonce);
        setViewAc();
        actionView();
    }

    private void setViewAc(){
        spinnerlist = (Spinner)findViewById(R.id.spinnerlistA);
        detailA = (EditText)findViewById(R.id.textPostA);
    }

    private  void actionView(){
        spinnerlist.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String list[] = getResources().getStringArray(R.array.listOfanonce);
                Toast.makeText(getApplicationContext(),"le num is selected :" +list[i],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
