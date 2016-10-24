package com.example.bayembaye.myapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.bayembaye.myapp.R;

/**
 * this activity gonna display all the contact of an specific user
 * for that we gonna get the data from the server database 
 */

 public class ContactActivity extends AppCompatActivity {

    // TODO: 18/09/2016 find and display all the friends of an specific user  
    private ListView friendList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        //call the setters methods
        setterViews();
        setterActions();
    }
    // It's for the set views of the activity 
    private void setterViews(){
        friendList = (ListView)findViewById(R.id.friendList);
    }
    //the is for the setter action for the view of the user 
    private void setterActions(){
        friendList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // TODO: 18/09/2016 take the selected contact on the listViews 
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    
}
