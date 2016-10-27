package com.example.bayembaye.myapp.adaptators;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.bayembaye.myapp.R;
import com.example.bayembaye.myapp.UseObjects.Anonce;

import java.util.List;

/**
 * Created by bayembaye on 27/10/2016.
 */
public class AdapatorAnonce extends ArrayAdapter<Anonce> {

    public AdapatorAnonce(Context context, int resource, List<Anonce> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            LayoutInflater li = LayoutInflater.from(parent.getContext());
            row = li.inflate(R.layout.row_anonce, parent, false);
        }
            //Identified the views
            TextView typeView = (TextView)row.findViewById(R.id.typeAnonceRow);
            TextView textAnonceView = (TextView)row.findViewById(R.id.textAnonceRow);
            TextView idUserRow = (TextView)row.findViewById(R.id.fromUserRow);

            //use the view on the scream
            Anonce anonce = getItem(position);
            typeView.setText(anonce.getType_anoc());
            textAnonceView.setText(anonce.getDetail());
            idUserRow.setText(anonce.getId_user());

            return row;
        }
}
