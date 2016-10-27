package com.example.bayembaye.myapp.adaptators;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bayembaye.myapp.R;
import com.example.bayembaye.myapp.UseObjects.Anonce;
import com.example.bayembaye.myapp.UseObjects.User;

import java.util.List;

/**
 * Created by bayembaye on 21/10/2016.
 * this is for adapting the info users no the list view
 * for that we identified the id of the layout for the row and gonna add this in the ListView.
 */
public class AdatatorContactView extends ArrayAdapter<User> {

    public AdatatorContactView(Context context, int resource, List<User> users) {
        super(context, resource,users);
    }

    //this function is for calling the position on the view
    @Override
    public View getView(int position, View recup, ViewGroup parent) {
        View row = recup;
        if (row == null) {
            LayoutInflater li = LayoutInflater.from(parent.getContext());
            row = li.inflate(R.layout.row_contact, parent, false);
        }
        //Identified the views
       ImageView imgUser = (ImageView)recup.findViewById(R.id.imgcontactlist);
        TextView nameUser = (TextView)recup.findViewById(R.id.viewname);
        TextView telView = (TextView)recup.findViewById(R.id.viewTel);
        Button findMebutton = (Button)recup.findViewById(R.id.buttonMeTrouver);
        ////\/|////
        ////Now we gonna use the view on the scream
        // earlier we gonna enable the button findMe
        findMebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"the toast for the find me button ",Toast.LENGTH_SHORT);
            }
        });
        User user = getItem(position);
        imgUser.setImageResource(R.drawable.male);
        nameUser.setText(user.getPrenom_user()+"   "+user.getNom_user());
        telView.setText(user.getTel_user());
       return row;
    }

}
