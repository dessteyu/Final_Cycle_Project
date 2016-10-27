package com.example.bayembaye.myapp.adaptators;

import android.content.Context;
import android.support.v7.view.menu.MenuView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.bayembaye.myapp.R;
import com.example.bayembaye.myapp.UseObjects.Anonce;

/**
 * Created by bayembaye on 27/10/2016.
 */
public class AdapatorAnonce extends ArrayAdapter<Anonce> {
    public AdapatorAnonce(Context context, int resource) {
        super(context, resource);
    }

    public AdapatorAnonce(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public AdapatorAnonce(Context context, int resource, Anonce[] objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Anonce anonce = getItem(position);

        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View itemView  = li.inflate(R.layout.row_anonce,parent,false);

        return itemView;


    }
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        Anonce anonce = getItem(position);

        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View itemView = li.inflate(R.layout.row_anonce, parent, false);

        return itemView;
    }
}
