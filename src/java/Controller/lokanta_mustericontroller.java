/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.lokantaDao;
import Dao.lokanta_musteriDao;
import Dao.lokanta_musteriDao;
import Dao.musteriDao;
import Entity.Lokanta;
import Entity.Lokanta_musteri;
import Entity.Lokanta_musteri;
import Entity.Musteri;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author KING PHONE
 */
@Named
@SessionScoped
public class lokanta_mustericontroller implements Serializable {

 private List<Musteri> musterilist;
 private musteriDao musteriDao;
 
 
 private List<Lokanta> lokantlist;
  private lokantaDao lokantaDao;
  
    private List<Lokanta_musteri> lokanta_musterilist;
    private lokanta_musteriDao ADO;
    private Lokanta_musteri lokanta_musteri;

    public List<Lokanta_musteri> getLokanta_musterilist() {
        this.lokanta_musterilist=this.getADO().findAll();
        return lokanta_musterilist;
    }

    public lokanta_musteriDao getADO() {
         if(this.ADO==null)
            this.ADO=new lokanta_musteriDao();
        return ADO;
    }

    public Lokanta_musteri getLokanta_musteri() {
        if(this.lokanta_musteri==null)
            this.lokanta_musteri=new Lokanta_musteri();
        return lokanta_musteri;
    }
    
    public void clearForm() {
        this.lokanta_musteri = new Lokanta_musteri();
        
    }

    public void create() {
        
        this.getADO().insert(this.lokanta_musteri);
        this.clearForm();
       

    }
 public String deleteConfirm(Lokanta lokanta ) {
        return "confirm1";
    }
 
    public String delete() {
        this.getADO().delete(this.lokanta_musteri);
        
        this.clearForm();
        return "lokanta_musteri";
    }



    public void updateForm(Lokanta_musteri lokanta_musteri) {
        
        this.lokanta_musteri = lokanta_musteri;
        

    }

    public void update() {
       this.getADO().update(this.lokanta_musteri);
        this.clearForm();

    }
 

    public List<Musteri> getMusterilist() {
        this.musterilist = this.getMusteriDao().findAll();
        return musterilist;
    }

    public void setMusterilist(List<Musteri> musterilist) {
        this.musterilist = musterilist;
    }

    public musteriDao getMusteriDao() {
        if(this.musteriDao==null)
        {
            this.musteriDao=new musteriDao();
        }
        return musteriDao;
    }
    public List<Lokanta> getLokantlist() {
        this.lokantlist = this.getLokantaDao().findAll();
        return lokantlist;
        
    }

    public void setLokantlist(List<Lokanta> lokantlist) {
        this.lokantlist = lokantlist;
    }

    public lokantaDao getLokantaDao() {
         if(this.lokantaDao==null)
        {
            this.lokantaDao=new lokantaDao();
        }
        return lokantaDao;
    }

    public void setLokantaDao(lokantaDao lokantaDao) {
        this.lokantaDao = lokantaDao;
    }
    
}


