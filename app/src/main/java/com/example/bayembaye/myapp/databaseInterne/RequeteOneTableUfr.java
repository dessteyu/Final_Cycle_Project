package com.example.bayembaye.myapp.databaseInterne;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import com.example.bayembaye.myapp.Drivers.Drivers;
import com.example.bayembaye.myapp.UseObjects.Ufr;

import java.util.ArrayList;

/**
 * Created by bayembaye on 02/09/2016.
 */
public class RequeteOneTableUfr {
    private SQLiteDatabase db;

    public RequeteOneTableUfr(Context context) {
        db = new SqlHelper(context).getWritableDatabase();
    }
/*
Add a table a Ufr on the internal database
 */
    public boolean addURF(int id_ufr,int id_univ, String UFRName){
        ContentValues cv = new ContentValues();
        cv.put(SqlHelper.id_ufr,id_ufr);
        cv.put(SqlHelper.id_ufr_univ,id_univ);
        cv.put(SqlHelper.name_ufr,UFRName);
        return db.insert(SqlHelper.tableUfr,null,cv)!=-1?true:false;
    }
    public boolean delecteUFR (int id_ufr){
       return db.delete(SqlHelper.tableUfr,SqlHelper.id_ufr+"=?",new String[]{Integer.toString(id_ufr)})!=0?true:false;
    }
    public ArrayList<Ufr> selectAllUfr(int id_ufr){

        //we make the sql query
        String theQuery = "SELECT * FROM " + SqlHelper.tableUfr +" Where = ?";
        Cursor cursor = db.rawQuery(theQuery,new String[]{Integer.toString(id_ufr)});
        ArrayList<Ufr> listUfr = new ArrayList<>();
        if (cursor.getCount()==0){
            cursor.close();
            return null;
        }
        while (!cursor.isAfterLast()) {
            Ufr resultat = new Ufr();
            resultat.setId_ufr(cursor.getInt(cursor.getColumnIndex(SqlHelper.id_ufr)));
            resultat.setId_ufr_univ(cursor.getInt(cursor.getColumnIndex(SqlHelper.id_ufr_univ)));
            resultat.setName_ufr(cursor.getString(cursor.getColumnIndex(SqlHelper.name_ufr)));
            listUfr.add(resultat);
            cursor.moveToNext();
        }
        cursor.close();
        return listUfr;
    }
}
