

package Controller;

import Dao.OdemeDAO;
import Dao.musteriDao;
import Entity.Musteri;
import Entity.Odeme;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named
@SessionScoped
public class OdemeController implements Serializable{
    
    private Odeme odeme;
    private List<Odeme> odemelist;
    private OdemeDAO odemeDao;
    
    private musteriDao musteridao;
    private List<Musteri> musterilist;
    
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
        this.pagecount=(int)Math.ceil(this.getOdemeDao().count()/(double)pagesize);
        return pagecount;
    }

    public void setPagecount(int pagecount) {
        this.pagecount = pagecount;
    }
    
     public String deleteConfirm(Odeme odeme){
         return "confirm_delete2";
     }
    
     public String delete(){
           this.getOdemeDao().remove(this.odeme);
           this.clearForm(); 
           return "Odeme";
    }
    public void clearForm(){
       this.odeme=new Odeme();
    }
    public void updateForm(Odeme odeme){
        this.odeme=odeme;
    }
    public void update(){
         this.getOdemeDao().edit(this.odeme);
         this.clearForm();
    } 
    public void create(){
        this.getOdemeDao().create(this.odeme);
        this.clearForm();
    }
    public Odeme getOdeme() {
        if(this.odeme==null)
            this.odeme=new Odeme();
        return odeme;
    }
    public void setOdeme(Odeme odeme) {
        this.odeme = odeme;
    }
    public List<Odeme> getOdemelist() {
        this.odemelist=this.getOdemeDao().findAll(page,pagesize);
        return odemelist;
    }

    public void setOdemelist(List<Odeme> odemelist) {
        this.odemelist = odemelist;
    }

    public OdemeDAO getOdemeDao() {
        if(this.odemeDao==null)
            this.odemeDao=new OdemeDAO();
        return odemeDao;
    }

    public void setOdemeDao(OdemeDAO odemeDao) {
        this.odemeDao = odemeDao;
    }
    public musteriDao getMusteridao() {
        if(this.musteridao==null)
            this.musteridao=new musteriDao();
        return musteridao;
    }

    public void setMusteridao(musteriDao musteridao) {
        
        this.musteridao = musteridao;
    }

    public List<Musteri> getMusterilist() {
        this.musterilist=this.getMusteridao().findAl();
        return musterilist;
    }

    public void setMusterilist(List<Musteri> musterilist) {
        this.musterilist = musterilist;
    }
     
}
