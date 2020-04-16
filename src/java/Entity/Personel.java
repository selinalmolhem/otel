package Entity;

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
public class Personel {

    private Long personel_id;
    private int tc;
    private String ad_soyad;
    private String tel;
     
    public Personel() {
    }

    public Long getPersonel_id() {
        return personel_id;
    }

    public void setPersonel_id(Long personel_id) {
        this.personel_id = personel_id;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.personel_id);
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
        final Personel other = (Personel) obj;
        if (!Objects.equals(this.personel_id, other.personel_id)) {
            return false;
        }
        return true;
    }


 

}
