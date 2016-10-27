package com.example.bayembaye.myapp.databaseOnServer;

import android.util.Log;
import android.webkit.WebHistoryItem;

import com.example.bayembaye.myapp.Drivers.Drivers;
import com.example.bayembaye.myapp.databaseInterne.SqlHelper;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bayembaye on 03/09/2016.
 */
public class ServerRequest {
    /**
     * the variable help to identified the of transaction on the server
     * we have two types of transaction : get a data or insert a data
     */

    private URL url;
    private HttpURLConnection connection = null;


    public ServerRequest (URL url){
        this.url = url;
    }

    private void connecting () {
        try {
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setReadTimeout(10000);
            connection.connect();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param mEmail
     * @param mPassword
     * @return
     */



    private boolean isSendForUserTest (String mEmail,String mPassword) {
        connecting();
        try {
            OutputStream outputStream = connection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            String postData = URLEncoder.encode("mEmail","UTF-8") + "="+ URLEncoder.encode(mEmail,"UTF-8")+"&"
                    +URLEncoder.encode("mPassword","UTF-8")+ "="+ URLEncoder.encode(mPassword,"UTF-8") ;
            bufferedWriter.write(postData);
            bufferedWriter.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }finally {
            connection.disconnect();
        }
        return true;
    }

    /**
     *
     * @param email
     * @param password
     * @return JSONObject
     */

    public JSONObject getExpeficiqueUser(String email, String password){
        JSONObject jsonObject = null;
        String returnvalue = "";
        connecting();
        try {
            OutputStream outputStream = connection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            String postData = URLEncoder.encode(SqlHelper.email_user,Drivers.formatInsert) + "="+
                    URLEncoder.encode(email,Drivers.formatInsert)+"&"
                    +URLEncoder.encode(SqlHelper.password_user,Drivers.formatInsert)+ "="+
                    URLEncoder.encode(password,Drivers.formatInsert) ;
            bufferedWriter.write(postData);
            bufferedWriter.close();
            outputStream.close();
            InputStream stream = connection.getInputStream();
            //lire les donnees recuperer dans le serveur
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream,Drivers.formatGetter));
            String line = "";
            while (( line = reader.readLine())!=null){
                returnvalue +=line;
            }
            reader.close();
            stream.close();
            jsonObject = new JSONObject(returnvalue);

        } catch (IOException e) {
            e.printStackTrace();
            Log.d("GetEx","can't get data");
        } catch (JSONException e) {
            Log.d("JSex","error to convert to json data");
            e.printStackTrace();
        }finally {
            connection.disconnect();
        }
        return (returnvalue.contains(Drivers.ErrorRequest)? null : jsonObject);
    }
    public boolean isUser (String email, String password){
        //TODO: return true if the user exist in external database

        return true;
    }

    /**
     *
     * @param hashMap
     * @return boolean
     */
    public boolean newUserInsert ( final HashMap<String,String> hashMap){
        connecting();
        try {
            OutputStream outputStream = connection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            String postData = URLEncoder.encode(SqlHelper.name_user, Drivers.formatInsert) + "="+
                    URLEncoder.encode(hashMap.get(SqlHelper.name_user),Drivers.formatInsert)+"&"
                    +URLEncoder.encode(SqlHelper.lastname_user,Drivers.formatInsert)+ "="+
                    URLEncoder.encode(hashMap.get(SqlHelper.lastname_user),Drivers.formatInsert)
                    +"&"
                    +URLEncoder.encode(SqlHelper.nie_user,Drivers.formatInsert)+ "="+
                    URLEncoder.encode(hashMap.get(SqlHelper.nie_user),Drivers.formatInsert)
                    +"&"
                    +URLEncoder.encode(SqlHelper.email_user,Drivers.formatInsert)+ "="+
                    URLEncoder.encode(hashMap.get(SqlHelper.email_user),Drivers.formatInsert)
                    +"&"
                    +URLEncoder.encode(SqlHelper.password_user,Drivers.formatInsert)+ "="+
                    URLEncoder.encode(hashMap.get(SqlHelper.password_user),Drivers.formatInsert)
                    +"&"+
                    URLEncoder.encode(SqlHelper.tel_user,Drivers.formatInsert) +"="+
                    URLEncoder.encode(hashMap.get(SqlHelper.tel_user),Drivers.formatInsert)
                    +"&"+
                    URLEncoder.encode(SqlHelper.id_ufr_user,Drivers.formatInsert) +"="+
                    URLEncoder.encode(hashMap.get(SqlHelper.id_ufr_user),Drivers.formatInsert)
                    +"&"+
                    URLEncoder.encode(SqlHelper.ville_origine,Drivers.formatInsert) +"="+
                    URLEncoder.encode(hashMap.get(SqlHelper.ville_origine),Drivers.formatInsert);

            bufferedWriter.write(postData);
            bufferedWriter.close();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return InsertIsOk("ok");
    }
    private boolean InsertIsOk(String test){
        //recuperer la donnee
        String returnvalue =null;
        try {
            InputStream stream = connection.getInputStream();
            //lire les donnees recuperer dans le serveur
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream,Drivers.formatGetter));
            String line = null;
            while (( line = reader.readLine())!=null){
                returnvalue +=line;
            }
            reader.close();
            stream.close();

        } catch (IOException e) {
            Log.w("INSERTTAG","WRONG");
            e.printStackTrace();
            return false;
        }finally {
            connection.disconnect();
        }
        return returnvalue.contains(test);
    }
    public boolean isExist(String test){
        return true;
    }
    public  boolean insertAnonce (String id_user,String type,String detail){
        connecting();
        try {
            OutputStream outputStream = connection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            // Striing for post data in the server
            String postData = URLEncoder.encode(SqlHelper.id_user,Drivers.formatInsert)+ "="+
                    URLEncoder.encode(id_user,Drivers.formatInsert)
                    +"&"
                    +URLEncoder.encode(SqlHelper.type_anoc,Drivers.formatInsert)+ "="+
                    URLEncoder.encode(type,Drivers.formatInsert) + "&"+
                    URLEncoder.encode(SqlHelper.detail_anoc,Drivers.formatInsert) + "="+
                    URLEncoder.encode(detail,Drivers.formatInsert);
            bufferedWriter.write(postData);
            outputStream.close();
            bufferedWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
        return InsertIsOk("ok");
    }

    /**
     * @return JSONObject
     * this function is for the contact of a user on the server.
     */
    public JSONObject getContactOnServer(ArrayList<String> listNumLocalContatt){
        // TODO: 18/09/2016 make the code for getting contact on the server
        // we gonna take all friend contact in the server for fot that we gonna test
        connecting();
        String txtRead = "";
        try {
            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,Drivers.formatGetter));
            String line ="";
            while ((line = reader.readLine())!=null){
                txtRead +=line;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }
}