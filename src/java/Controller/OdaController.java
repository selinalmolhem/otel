/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.OdaDAO;
import Entity.Oda;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class OdaController implements Serializable {
    
    private List<Oda> odalist;
    private OdaDAO odadao;
    
    private Oda oda;
       
    public void updateForm(Oda oda){
        this.oda=oda;
       
    }
     public void clearForm(){
        this.oda=new Oda();   
    }
    
   public String deleteConfirm(Oda oda){
       return "confirm_delete1";
   }  
    public void update(){
        this.getOdadao().update(this.oda);
        this.oda=new Oda();
        
    }   
    public String delete(){
        this.getOdadao().delete(this.oda);
        this.oda=new Oda();
        return "Oda";      
    }
    
    public void create(){
        this.getOdadao().insert(this.oda);
        this.oda=new Oda();
    }
    
    public OdaController() {
        this.odalist=new ArrayList();
        odadao=new OdaDAO();
    }
    
    public List<Oda> getOdalist() {
        this.odalist=this.getOdadao().findAll();
        return odalist;
    }

    public void setOdalist(List<Oda> odalist) {
        this.odalist = odalist;
    }

    public OdaDAO getOdadao() {
        if(this.odadao==null)
            this.odadao=new OdaDAO();
        return odadao;
    }

    public void setOdadao(OdaDAO odadao) {
        this.odadao = odadao;
    }

    public Oda getOda() {
        if(this.oda==null)
            this.oda=new Oda();
        return oda;
    }

    public void setOda(Oda oda) {
        this.oda = oda;
    }
    
    
    
    
}
