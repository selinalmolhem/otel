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
    
    private int page=1;
    private int pagesize=10;
    private int pagecount;
    
    public void next(){
        if(this.page==this.getPagecount())
            this.page=1;
        else
            this.page++;
    }
    public void previous(){
        if(this.page==1)
            this.page=this.getPagecount();
        else
            this.page--;
    }
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getPagecount() {
        this.pagecount=(int)Math.ceil(this.getOdadao().count()/(double)pagesize);
        return pagecount;
    }

    public void setPagecount(int pagecount) {
        this.pagecount = pagecount;
    }
    
       
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
        this.odalist=this.getOdadao().findAll(page,pagesize);
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
