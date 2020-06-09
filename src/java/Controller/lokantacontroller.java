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
 * @author Selin almolhem
 */
@Named
@SessionScoped
public class lokantacontroller implements Serializable {

    private int page = 1;
    private int pageSize = 25;
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
    private List<Lokanta> lokantaList;
    private lokantaDao ADO;
    private Lokanta lokanta;

    public lokantacontroller() {
        lokantaList = new ArrayList();
        this.ADO = new lokantaDao();

    }

    public List<Lokanta> getLokantaList() {
        this.lokantaList = this.ADO.findAll(page, pageSize);
        return lokantaList;
    }

    public lokantaDao getADO() {
        if (this.ADO == null) {
            this.ADO = new lokantaDao();
        }
        return ADO;
    }

    public Lokanta getLokanta() {
        if (this.lokanta == null) {
            this.lokanta = new Lokanta();
        }
        return lokanta;
    }

    public void clearForm() {
        this.lokanta = new Lokanta();

    }

    public void create() {
        this.getADO().insert(this.lokanta);
        this.clearForm();
    }

    public String deleteConfirm(Lokanta lokanta) {
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

    public void update() {
        this.getADO().update(this.lokanta);
        this.clearForm();
    }

}
//