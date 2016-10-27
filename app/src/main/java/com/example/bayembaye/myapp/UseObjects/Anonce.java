package com.example.bayembaye.myapp.UseObjects;

/**
 * Created by bayembaye on 27/10/2016.
 */
public class Anonce {


    private int id_anoc;
    private int id_user;
    private String type_anoc;
    private String detail;

    public Anonce(int id_anoc, String detail, String type_anoc, int id_user) {
        this.id_anoc = id_anoc;
        this.detail = detail;
        this.type_anoc = type_anoc;
        this.id_user = id_user;

    }
    public Anonce(){

    }

    public int getId_anoc() {
        return id_anoc;
    }

    public void setId_anoc(int id_anoc) {
        this.id_anoc = id_anoc;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getType_anoc() {
        return type_anoc;
    }

    public void setType_anoc(String type_anoc) {
        this.type_anoc = type_anoc;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Anonce{" +
                "id_anoc=" + id_anoc +
                ", id_user=" + id_user +
                ", type_anoc='" + type_anoc + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
