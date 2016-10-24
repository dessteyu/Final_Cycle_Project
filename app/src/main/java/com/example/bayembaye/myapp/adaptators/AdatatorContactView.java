package com.example.bayembaye.myapp.adaptators;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bayembaye.myapp.R;
import com.example.bayembaye.myapp.UseObjects.User;

/**
 * Created by bayembaye on 21/10/2016.
 * this is for adapting the info users no the list view
 * for that we identified the id of the layout for the row and gonna add this in the ListView.
 */
public class AdatatorContactView extends ArrayAdapter<User> {

    public AdatatorContactView(Context context, int resource) {
        super(context, resource);
    }

    //this function is for calling the position on the view
    @Override
    public View getView(int position, View recup, ViewGroup parent) {

        User user = getItem(position);

        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View itemView = li.inflate(R.layout.row_contact, parent, false);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.imgcontactlist);
        TextView textView = (TextView) itemView.findViewById(R.id.viewname);
//        imageView.setImageResource(categorie.getDrawableResId());
//        textView.setText(categorie.getStringResId());
        return itemView;
    }
//for setting the position of all the view of a contact
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        User user = getItem(position);

        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View itemView = li.inflate(R.layout.row_contact, parent, false);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.imgcontactlist);
        TextView textView = (TextView) itemView.findViewById(R.id.viewname);
//        imageView.setImageResource(user.getDrawableResId());
//        textView.setText(categorie.getStringResId());
        return itemView;
    }
}
