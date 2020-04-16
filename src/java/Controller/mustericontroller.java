/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.lokantaDao;
import Dao.musteriDao;
import Dao.personelDao;
import Entity.Lokanta;
import Entity.Musteri;
import Entity.Personel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author KING PHONE
 */
@Named
@SessionScoped
public class mustericontroller implements Serializable {

    private List<Musteri> musteriList;
    private musteriDao ADO;
    private Musteri musteri;

    private List<Personel> personellist;
   
    private personelDao personelDao;

//    private lokantaDao lokantaDao;   incekt edecez
//    private List <Lokanta> lokantalist;
    @Inject
    private lokantacontroller lokantacontroller;
  

    public lokantacontroller getLokantacontroller() {
        return lokantacontroller;
    }

    public void setLokantacontroller(lokantacontroller lokantacontroller) {
        this.lokantacontroller = lokantacontroller;
    }

   

    public List<Personel> getPersonellist() {
        this.personellist = this.getPersonelDao().findAll();
        return personellist;
    }

    public void setPersonellist(List<Personel> pesonellist) {
        this.personellist = pesonellist;
    }

    public personelDao getPersonelDao() {

        if (this.personelDao == null) {
            this.personelDao = new personelDao();
        }
        return personelDao;
    }

    public void setPersonelDao(personelDao personelDao) {
        this.personelDao = personelDao;
    }

    public mustericontroller() {
        musteriList = new ArrayList();
        this.ADO = new musteriDao();
    }

    public List<Musteri> getMusteriList() {
        this.musteriList = this.getADO().findAll();

        return musteriList;
    }

    public musteriDao getADO() {
        if (this.ADO == null) {
            this.ADO = new musteriDao();
        }
        return ADO;
    }

    public Musteri getMusteri() {
        if (this.musteri == null) {
            this.musteri = new Musteri();
        }
        return musteri;
    }

   

    public void clearForm() {
        this.musteri = new Musteri();

    }

    public void create() {
        this.getADO().insert(this.musteri);
        this.clearForm();
        
    }
public String deleteConfirm(Musteri m ) {
        return "confirm2";
    }
 
    public String delete() {
        this.getADO().delete(this.musteri);
        this.musteri=new Musteri();
        this.clearForm();
        return"musteri";

    }

    public void updateForm(Musteri m) {
        this.musteri = m;
      
        
    }

    public void update() {
        
        this.getADO().edit(this.musteri);
        this.clearForm();

    }

    public void setMusteriList(List<Musteri> musteriList) {
        this.musteriList = musteriList;
    }

    public void setADO(musteriDao ADO) {
        this.ADO = ADO;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }
}
