package com.example.bayembaye.myapp.databaseInterne;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by bayembaye on 02/09/2016.
 */
public class SqlHelper extends SQLiteOpenHelper {

    /**
        create the name of database and table
     */


    private final static String DATABASENAME= "shAppDatabase.db";//name of database
    private final static int   VERSIONOFDATABASE = 1; //version of database


    /**
        define the name of all the tables of the database
    */
    private final static String tableUser = "user";
    private final static String tableUniversity = "university";
    private final static String tableUfr = "ufr";
    private final static String tableAmicale = "amicale";
    private final static String tableCycle = "cycle";
    private final static String tableAnnonce = "annonce";

    /**
     * Columns of the table annonce
     */
    public final static String id_annonce  = "id_anoc";
    public final static String id_user_anoc = "id_user";
    public final static String type_anoc = "type_anoc";
    public final static String detail_anoc = "detail";



    /**
     * define the names of the columns of the tables of the database;
     */


    /**
        Columns of the user table
     */
    public final static String id_user = "id_user";
    public final static String nie_user = "nie_user";
    public final static String name_user = "nom_user";
    public final static String lastname_user = "prenom_user";
    public final static String tel_user = "tel_user";
    public final static String email_user = "email_user";
    public final static String password_user = "pwd_user";
    public final static String ville_origine =  "ville_ori_user";
    public final static String id_ufr_user = "id_ufr";

    /**
        Columns of the university table
     */
    private final static String id_university = "id_university";
    private final static String name_university = "name_universitty";

    /**
        Columns of the amicale table
     */

    private final static String id_amicale = "id_amicale";
    private final static String name_amicale = "name_amicale";
    private final static String id_ville = "ville_origine";
    private final static String id_user_amicale = "id_user";

    /**
        Columns of table Cycle
     */
    private final static String id_cycle = "id_user";
    private final static String name_cycle = "name_cycle";
    private final static String level_cycle = "level_cycle";

    /**
     *
     * Columns of the table tableUfr
     */
    private final static String id_ufr = "id_ufr";
    private final static String id_ufr_univ = "id_univ";
    private final static String name_ufr = "name_ufr";



    public SqlHelper(Context context) {
        super(context, DATABASENAME, null, VERSIONOFDATABASE);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String RequeteOfCreationOftableUser = "CREATE TABLE "+tableUser
                +"("+id_user +"INTEGER NOT NULL PRIMARY KEY, "+nie_user +
                "INTEGER NOT NULL ,"+ name_user+" TEXT ," +lastname_user +" TEXT ,"+
                tel_user+ " INTEGER ,"+email_user +" TEXT ,"+password_user+ " TEXT,"+
                ville_origine+ " TEXT ,"+id_ufr_user+ " INTEGER NOT NULL )";
        String RequeteofCreationOfTableUniversiy = "CREATE TABLE "+tableUniversity +" ("+
                id_university+ " INTEGER PRIMARY KEY AUTOINCREMENT "+
                name_university+ " TEXT NOT NULL )";
        String RequeteOfCreationTableUfr =  "CREATE TABLE "+tableUfr+
                " ("+id_ufr +"INTEGER PRIMARY KEY AUTOINCREMENT ,"+id_ufr_univ+
                " INTEGER NOT NULL ,"+name_ufr +" TEXT )";
        String RequeteofCreationofTableAmicale = "CREATE TABLE "+tableAmicale + " (" +
                id_amicale +"INTEGERR PRIMARY KEY AUTOINCREMENT ,"+
                name_amicale +" TEXT ,"+id_ville +" TEXT NOT NULL ,"+
                id_user_amicale+ " INTEGER NOT NULL )";
        String RequeteOfCreationTableCycle = "CREATE TABLE "+tableCycle +" ("+
                id_cycle +" INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                name_cycle+ " Text ,"+ level_cycle+ " TEXT )";
        String RequeteOfCreationTableAnoc = "CREATE TABLE "+ tableAnnonce + " ("+
                id_annonce + " INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                id_user_anoc +" INTEGER NOT NULL ,"+ type_anoc +
                " TEXT ," +detail_anoc +" TEXT )";
        sqLiteDatabase.execSQL(RequeteOfCreationTableUfr);
        sqLiteDatabase.execSQL(RequeteofCreationOfTableUniversiy);
        sqLiteDatabase.execSQL(RequeteofCreationofTableAmicale);
        sqLiteDatabase.execSQL(RequeteOfCreationTableCycle);
        sqLiteDatabase.execSQL(RequeteOfCreationTableAnoc);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String RequeteDropTableUser = "DROP TABLE IF EXIST "+ tableUser;
        String RequeteDropTableUniversity = "DROP TABLE IF EXIST "+ tableUniversity;
        String RequeteDropTableCycle = " DROP TABLE IF EXIST "+ tableCycle;
        String RequeteDropTableAmicale = " DROP TABLE IF EXIST "+ tableAmicale;
        String RequeteDropTableUfr = "DROP TABLE IF EXIST "+ tableUfr;
        String RequeteDropTableAonc = " DROP TABLE IF EXIST "+ tableAnnonce;

        sqLiteDatabase.execSQL(RequeteDropTableUser);
        sqLiteDatabase.execSQL(RequeteDropTableUniversity);
        sqLiteDatabase.execSQL(RequeteDropTableCycle);
        sqLiteDatabase.execSQL(RequeteDropTableAmicale);
        sqLiteDatabase.execSQL(RequeteDropTableUfr);
        sqLiteDatabase.execSQL(RequeteDropTableAonc);
        onCreate(sqLiteDatabase);
    }
}
