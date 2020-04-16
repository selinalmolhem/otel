package Entity;

import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author KING PHONE
 */
public class Lokanta_musteri {

    private long lokanta_musteri_id;
   
    private Date tarih;
    private Musteri musteri;
    private Lokanta lokanta;

    public Lokanta_musteri() {
    }

    public long getLokanta_musteri_id() {
        return lokanta_musteri_id;
    }

    public void setLokanta_musteri_id(long lokanta_musteri_id) {
        this.lokanta_musteri_id = lokanta_musteri_id;
    }
    
    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    public Musteri getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }

    public Lokanta getLokanta() {
        return lokanta;
    }

    public void setLokanta(Lokanta lokanta) {
        this.lokanta = lokanta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (int) (this.lokanta_musteri_id ^ (this.lokanta_musteri_id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Lokanta_musteri other = (Lokanta_musteri) obj;
        if (this.lokanta_musteri_id != other.lokanta_musteri_id) {
            return false;
        }
        return true;
    }

}
