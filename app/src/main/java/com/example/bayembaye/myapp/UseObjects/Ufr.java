package com.example.bayembaye.myapp.UseObjects;

/**
 * Created by bayembaye on 27/10/2016.
 */
public class Ufr {
    private int id_ufr;
    private  int id_ufr_univ;
    private String name_ufr;

    public Ufr(int id_ufr, String name_ufr, int id_ufr_univ) {
        this.id_ufr = id_ufr;
        this.name_ufr = name_ufr;
        this.id_ufr_univ = id_ufr_univ;
    }
    public Ufr(){}

    public int getId_ufr() {
        return id_ufr;
    }

    public void setId_ufr(int id_ufr) {
        this.id_ufr = id_ufr;
    }

    public String getName_ufr() {
        return name_ufr;
    }

    public void setName_ufr(String name_ufr) {
        this.name_ufr = name_ufr;
    }

    public int getId_ufr_univ() {
        return id_ufr_univ;
    }

    public void setId_ufr_univ(int id_ufr_univ) {
        this.id_ufr_univ = id_ufr_univ;
    }
}
