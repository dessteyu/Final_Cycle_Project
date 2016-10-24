package com.example.bayembaye.myapp.UseObjects;

/**
 * Created by bayembaye on 29/08/2016.
 */
public class User {
    /* the variables */
    private  int id_user;
    private int nie_user;
    private String nom_user;
    private String prenom_user;
    private int tel_user;
    private String email_user;
    private String pwd_user;
    private String ville_ori_user;
    private int id_ufr;

    /* the constructor of user */

    public User (){}

    public User(int id_user, int nie_user, String nom_user, String prenom_user, int tel_user, String email_user, String pwd_user, String ville_ori_user, int id_ufr) {
        this.id_user = id_user;
        this.nie_user = nie_user;
        this.nom_user = nom_user;
        this.prenom_user = prenom_user;
        this.tel_user = tel_user;
        this.email_user = email_user;
        this.pwd_user = pwd_user;
        this.ville_ori_user = ville_ori_user;
        this.id_ufr = id_ufr;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_ufr() {
        return id_ufr;
    }

    public void setId_ufr(int id_ufr) {
        this.id_ufr = id_ufr;
    }

    public String getVille_ori_user() {
        return ville_ori_user;
    }

    public void setVille_ori_user(String ville_ori_user) {
        this.ville_ori_user = ville_ori_user;
    }

    public String getPwd_user() {
        return pwd_user;
    }

    public void setPwd_user(String pwd_user) {
        this.pwd_user = pwd_user;
    }

    public String getEmail_user() {
        return email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    public int getTel_user() {
        return tel_user;
    }

    public void setTel_user(int tel_user) {
        this.tel_user = tel_user;
    }

    public String getPrenom_user() {
        return prenom_user;
    }

    public void setPrenom_user(String prenom_user) {
        this.prenom_user = prenom_user;
    }

    public String getNom_user() {
        return nom_user;
    }

    public void setNom_user(String nom_user) {
        this.nom_user = nom_user;
    }

    public int getNie_user() {
        return nie_user;
    }

    public void setNie_user(int nie_user) {
        this.nie_user = nie_user;
    }

    @Override
    public String toString() {
        return "User{" +
                "id_user=" + id_user +
                ", nie_user=" + nie_user +
                ", nom_user='" + nom_user + '\'' +
                ", prenom_user='" + prenom_user + '\'' +
                ", tel_user=" + tel_user +
                ", email_user='" + email_user + '\'' +
                ", pwd_user='" + pwd_user + '\'' +
                ", ville_ori_user='" + ville_ori_user + '\'' +
                ", id_ufr=" + id_ufr +
                '}';
    }
}
