package Lekerdez;


public class Orszag 
{
    
    private String nev;
    private int varosokSzama;
    private String kontinens;

    public Orszag(String nev, int varosokSzama, String kontinens) {
        this.nev = nev;
        this.varosokSzama = varosokSzama;
        this.kontinens = kontinens;
    }

  

    public String getNev() {
        return nev;
    }

    public int getVarosokSzama() {
        return varosokSzama;
    }

    public String getKontinens() {
        return kontinens;
    }
    
    
    
    
}

