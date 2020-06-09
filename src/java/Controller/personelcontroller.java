/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.personelDao;
import Entity.Personel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Selin almolhem
 */
@Named
@SessionScoped
public class personelcontroller implements Serializable {

    private int page = 1;
    private int pageSize = 10;
    private int pageCount;

    public void next() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void previous() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getADO().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    private List<Personel> personelList;
    private personelDao ADO;
    private Personel personel;

    public personelcontroller() {
        personelList = new ArrayList();
        this.ADO = new personelDao();
    }

    public List<Personel> getPersonelList() {
        this.personelList = this.getADO().findAll(page, pageSize);
        return personelList;
    }

    public personelDao getADO() {
        if (this.ADO == null) {
            this.ADO = new personelDao();
        }
        return ADO;
    }

    public Personel getPersonel() {
        if (this.personel == null) {
            this.personel = new Personel();
        }
        return personel;
    }

    public String deleteConfirm(Personel personel) {
        return "confirm_delete";
    }

    public void clearForm() {
        this.personel = new Personel();

    }

    public void create() {
        this.getADO().insert(this.personel);
        this.clearForm();

    }

    public String delete() {
        this.getADO().delete(this.personel);
        this.clearForm();
        return "personel";
    }

    public void updateForm(Personel m) {
        this.personel = m;

    }

    public void update() {
        this.getADO().update(this.personel);
        this.clearForm();

    }

    public void setPersonelList(List<Personel> personelList) {
        this.personelList = personelList;
    }

    public void setADO(personelDao ADO) {
        this.ADO = ADO;
    }

    public void setPersonel(Personel personel) {
        this.personel = personel;
    }
}
