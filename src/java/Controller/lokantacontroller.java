/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.lokantaDao;
import Dao.lokantaDao;
import Entity.Lokanta;
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
public class lokantacontroller implements Serializable {
private List<Lokanta> lokantaList;
    private lokantaDao ADO;
    private Lokanta lokanta;
    public lokantacontroller() {
         lokantaList = new ArrayList();
        this.ADO = new lokantaDao();

    }

    public List<Lokanta> getLokantaList() {
           this.lokantaList=this.ADO.findAll();
        return lokantaList;
    }

    public lokantaDao getADO() {
     if(this.ADO==null)
            this.ADO=new lokantaDao();
        return ADO;    }

    public Lokanta getLokanta() {
        if(this.lokanta==null)
            this.lokanta=new Lokanta();
        return lokanta;
    }
     public void clearForm() {
        this.lokanta = new Lokanta();
        
    }

    public String create() {
        this.getADO().insert(this.lokanta);
        this.clearForm();
        return"lokanta";

    }
 public String deleteConfirm(Lokanta lokanta ) {
        return "confirm";
    }
    public String delete() {
        this.getADO().delete(this.lokanta);
        this.clearForm();
        return "lokanta";

    }



    public void updateForm(Lokanta lokanta) {
        this.lokanta = lokanta;

    }

    public String update() {
       this.getADO().update(this.lokanta);
        this.clearForm();
return"lokanta";
    }
    
}
