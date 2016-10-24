package com.example.bayembaye.myapp.databaseInterne;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.bayembaye.myapp.UseObjects.User;

import java.util.ArrayList;

/**
 * Created by bayembaye on 02/09/2016.
 */
public class RequeteOnUserTable {
    private SQLiteDatabase database;
    public RequeteOnUserTable(Context context){
    database = new SqlHelper(context).getWritableDatabase();
    }
    public ArrayList<User> listOfUsers (){
        ArrayList<User>list = null;

        return list;
    }
    private ArrayList<User> ConvertDataUser(Cursor cursor){
        ArrayList<User> list = new ArrayList<>();
        if (cursor == null)
            // TODO: 03/09/2016 code getting data in arraylist of user object 
            return list;

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {


            cursor.moveToNext();
        }
        return list;
    }
}
