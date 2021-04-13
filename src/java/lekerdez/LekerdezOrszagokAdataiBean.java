package lekerdez;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static lekerdez.AdatbazisKapcsolat.DRIVER;
import static lekerdez.AdatbazisKapcsolat.PASSWORD;
import static lekerdez.AdatbazisKapcsolat.SQL_KOTINENSEK_VAROSAI;
import static lekerdez.AdatbazisKapcsolat.URL;
import static lekerdez.AdatbazisKapcsolat.USER;

/**
 *
 * @author Nami
 */
public class LekerdezOrszagokAdataiBean {

    private ArrayList<Orszag> Euorszagok = new ArrayList<>();
    private ArrayList<Orszag> Amorszagok = new ArrayList<>();
    private ArrayList<Orszag> osszorszag = new ArrayList<>();

    public LekerdezOrszagokAdataiBean() {
        letrehoz();
    }

    public void letrehoz() {
        listaFeltolt();

    }

    public void listaFeltolt() {
        try {
            Class.forName(DRIVER);
            Connection kapcsolat = DriverManager.getConnection(URL, USER, PASSWORD);
            ResultSet eredmeny = kapcsolat.createStatement().executeQuery(SQL_KOTINENSEK_VAROSAI);
            while (eredmeny.next()) {
                String varos = eredmeny.getString("CITY");
                int darab = eredmeny.getInt("DB");
                String regio = eredmeny.getString("REGION_NAME");
                osszorszag.add(new Orszag(varos, darab, regio));
            }

        } catch (ClassNotFoundException | SQLException e) {
            ;
            //s=new StringBuilder(e.getMessage());
        }
    }


    public String europaTerkep() {
        String adat = "";
        int orszagokszama = osszorszag.size();
        for (int i = 0; i < orszagokszama; i++) {

            Orszag orszag = osszorszag.get(i);
            if (orszag.getKontinens().equals("Europe")) {
                adat += "[" + "'" + orszag.getNev() + "'" + "," + orszag.getDoolgozoszam() + "],";
                if (i == orszagokszama - 1) {
                    adat += "[" + "'" + orszag.getNev() + "'" + "," + orszag.getDoolgozoszam() + "]";
                }
            }
        }

        return adat;

    }

    public String amerikaTerkep() {
        String adat = "";
        int orszagokszama = osszorszag.size();
        for (int i = 0; i < orszagokszama; i++) {

            Orszag orszag = osszorszag.get(i);
            if (orszag.getKontinens().equals("Americas")) {
                adat += "[" + "'" + orszag.getNev() + "'" + "," + orszag.getDoolgozoszam() + "],";
                if (i == orszagokszama - 1) {
                    adat += "[" + "'" + orszag.getNev() + "'" + "," + orszag.getDoolgozoszam() + "]";
                }
            }
        }

        return adat;

    }

}
