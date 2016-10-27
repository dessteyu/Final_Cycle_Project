package com.example.bayembaye.myapp.Drivers;

/**
 * Created by bayembaye on 02/09/2016.
 */
public class Drivers {
    public final static String[] VilleOfSenegal = {
        "Dakar",
        "Saint Louis",
        "Pikine",
        "Richard Toll",
        "Louga",
        "Touba",
        "Diourbel"
    };
    public final static String[] Masters = {
            "Master 1",
            "Master 2"
    };
    public final static String[] Doctorat = {
            "Doctorat 1",
            "Doctorat 2",
            "Doctorat 3"

    };
    public final static String[] Licence = {
            "Licence 1",
            "Licence 2",
            "Licence 3"
    };

    public final static String ListDepThies []={"Mathematique et Informatique",
    "Informatique","LEA","LSEE","Hotelerie","Agronomie","LMIO","PC"};


    /**
     * this variable is for localhost
     */
    public final static String UrlName = "http://10.0.2.2/";
    /**
        THIS VARIABLE IS FOR UNICODE FORMAT SETTING WHEN WE GET OR INSERT DATA IN THE DATABASE SERVER
     */
    public final static String formatInsert  = "UTF-8";
    public final static String formatGetter = "iso-8859-1";
    public static boolean isValideMail(String mail){
        if (!containtNonValideValueOfMail(mail)) {
            //we make convert string to an array char
            final char[] test = mail.toCharArray();
            final int len = mail.length();
            int nbr = 0;
            for (char c : test) {
                if (c == '@')
                    nbr++;
                if (nbr > 1)
                    return false;
            }
            int lastdat = mail.lastIndexOf(".");
            String identityString = mail.substring(lastdat+1,len);
            return !(containtNumber(identityString)||identityString.contains(".")||identityString.isEmpty());
        }
        return false;
    }
    
    public static boolean isValideTel(String tel){
        return !tel.contains(".") || !tel.contains(" ");
    }

    public static boolean containtNumber(String valueTest){
        return  (valueTest.contains("0")||valueTest.contains("1")||valueTest.contains("2")||
                valueTest.contains("3")||valueTest.contains("4")||valueTest.contains("5")||
                valueTest.contains("6")||valueTest.contains("7")||valueTest.contains("8")||
                valueTest.contains("9"));
    }
    public static boolean containtNonValideValueOfMail( String mail){
        return  (mail.contains("#")|| mail.contains("|") || mail.contains("\\") || mail.contains(",")
                || mail.contains(";") || mail.contains("?") || mail.contains("'") || mail.contains("\"")
                || mail.contains("$") ||mail.contains("!") || mail.contains("%") || mail.contains("~")
                || mail.contains("`") || mail.contains(":") || mail.contains("/") || mail.contains("<")
                || mail.contains(">") || mail.contains("[") || mail.contains("]") || mail.contains("{")
                || mail.contains("}") || mail.contains("(") || mail.contains(")") || mail.contains("^")
                || mail.contains("&") || mail.contains("*") || mail.contains("+"));
    }
    public static  boolean TestVille(String ville){
        for (  String test : VilleOfSenegal) {
            if (!test.equals(ville))
                return false;
        }
        return true;
    }
    /**
     * define an error request on the server sql
     */
    public static String ErrorRequest = "--9ErrorRequest6--";
}
