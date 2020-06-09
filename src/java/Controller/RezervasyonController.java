

package Controller;

import Dao.OdaDAO;
import Dao.RezervasyonDAO;
import Dao.musteriDao;
import Entity.Musteri;
import Entity.Oda;
import Entity.Rezervasyon;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class RezervasyonController implements Serializable {
    
    private Rezervasyon rezervasyon;
    private List<Rezervasyon> rlist;
    private RezervasyonDAO rDao;
    
    private List<Musteri> musterilist;
    private musteriDao musteridao;
    
    private OdaDAO odaDao;
    private List<Oda> odalist;
    
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
        this.pagecount=(int)Math.ceil(this.getRDao().count()/(double)pagesize);
        return pagecount;
    }

    public void setPagecount(int pagecount) {
        this.pagecount = pagecount;
    }
    
   public String deleteConfirm(Rezervasyon rezer){
       return "confirm_delete3";
   } 
     public String delete(){
        this.getRDao().remove(this.rezervasyon);
        this.clearForm();
        return "Rezervasyon";
    }   
     public void clearForm(){
         this.rezervasyon=new Rezervasyon();
     }
    public void updateForm(Rezervasyon r){
        this.rezervasyon=r;
    }
     public void update(){
          this.getRDao().edit(this.rezervasyon);
          this.clearForm();
    }
    public void create(){
        this.getRDao().create(this.rezervasyon);
        this.clearForm();    
    }
    public Rezervasyon getRezervasyon() {
        if(this.rezervasyon==null)
            this.rezervasyon=new Rezervasyon();
        return rezervasyon;
    }
    public void setRezervasyon(Rezervasyon rezervasyon) {
        this.rezervasyon = rezervasyon;
    }
    public List<Rezervasyon> getRlist() {
        this.rlist=this.getRDao().findAll(page,pagesize);
        return rlist;
    }

    public void setRlist(List<Rezervasyon> rlist) {
        this.rlist = rlist;
    }

   
    public RezervasyonDAO getRDao() {
        if(this.rDao==null)
            this.rDao=new RezervasyonDAO();
        return rDao;
    }

    public void setRDao(RezervasyonDAO rDao) {
        this.rDao = rDao;
    }
    public musteriDao getMusteridao() {
        if(this.musteridao==null)
            this.musteridao=new musteriDao();
        return musteridao;
    }

    public List<Musteri> getMusterilist() {
        this.musterilist=this.getMusteridao().findAl();
        return musterilist;
    }

    public void setMusterilist(List<Musteri> musterilist) {
        this.musterilist = musterilist;
    }

    public OdaDAO getOdaDao() {
        if(this.odaDao==null)
            this.odaDao=new OdaDAO();
        return odaDao;
    }

    public List<Oda> getOdalist() {
        this.odalist=this.getOdaDao().findAll(page,pagesize);
        return odalist;
    }

    public void setOdalist(List<Oda> odalist) {
        this.odalist = odalist;
    }
    
}
