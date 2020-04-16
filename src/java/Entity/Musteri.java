package Entity;

import java.util.List;
import java.util.Objects;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KING PHONE
 */
public class Musteri {
    private Long musteri_id;
    private int tc;
    private String ad_soyad;
    private String tel;
    private String addres;
  

    private Personel personel;
    private List <Lokanta> musteri_lokanta;
    public Musteri() {
    }

    public List<Lokanta> getMusteri_lokanta() {
        return musteri_lokanta;
    }

    public void setMusteri_lokanta(List<Lokanta> musteri_lokanta) {
        this.musteri_lokanta = musteri_lokanta;
    }

    public Long getMusteri_id() {
        return musteri_id;
    }

    public void setMusteri_id(Long musteri_id) {
        this.musteri_id = musteri_id;
    }

    public int getTc() {
        return tc;
    }

    public void setTc(int tc) {
        this.tc = tc;
    }

    public String getAd_soyad() {
        return ad_soyad;
    }

    public void setAd_soyad(String ad_soyad) {
        this.ad_soyad = ad_soyad;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public Personel getPersonel() {
        return personel;
    }

    public void setPersonel(Personel personel) {
        this.personel = personel;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.musteri_id);
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
        final Musteri other = (Musteri) obj;
        if (!Objects.equals(this.musteri_id, other.musteri_id)) {
            return false;
        }
        return true;
    }

    

  


    

    
}
