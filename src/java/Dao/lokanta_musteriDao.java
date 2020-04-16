/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Lokanta_musteri;
import Entity.Lokanta_musteri;
import Util.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KING PHONE
 */
public class lokanta_musteriDao {

    private musteriDao musteriDao;
    private lokantaDao lokantaDao;
    private Connector db = new Connector();

    private Connection c = db.connect();

    public void update(Lokanta_musteri lokanta_musteri) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("update lokanta_musteri set musteri_id=?,lokanta_id=? where lokanta_musteri_id=?");
            pst.setLong(1, lokanta_musteri.getMusteri().getMusteri_id());
            pst.setLong(2, lokanta_musteri.getLokanta().getMenu_id());
            pst.setLong(3, lokanta_musteri.getLokanta_musteri_id());
            pst.executeUpdate();

        } catch (SQLException e) {
            Logger.getLogger(lokanta_musteriDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void delete(Lokanta_musteri lokanta_musteri) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("delete from lokanta_musteri where lokanta_musteri_id=?");
            pst.setLong(1, lokanta_musteri.getLokanta_musteri_id());
            pst.executeUpdate();

        } catch (SQLException e) {
            Logger.getLogger(lokanta_musteriDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void insert(Lokanta_musteri lokanta_musteri) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("insert into lokanta_musteri(musteri_id,lokanta_id) values(?,?)", Statement.RETURN_GENERATED_KEYS);
            pst.setLong(1, lokanta_musteri.getMusteri().getMusteri_id());
            pst.setLong(2, lokanta_musteri.getLokanta().getMenu_id());
            pst.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(lokanta_musteriDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public List<Lokanta_musteri> findAll() {
        List<Lokanta_musteri> lokanta_musteriList = new ArrayList<>();

        try {
            PreparedStatement pst = this.getC().prepareStatement("select *from lokanta_musteri");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Lokanta_musteri lokanta_musteri = new Lokanta_musteri();
                lokanta_musteri.setLokanta_musteri_id(rs.getLong("lokanta_musteri_id"));
                lokanta_musteri.setTarih(rs.getDate("talep_tarihi"));

                lokanta_musteri.setMusteri(this.getMusteriDao().find(rs.getLong("musteri_id")));
                lokanta_musteri.setLokanta(this.getLokantaDao().find(rs.getLong("lokanta_id")));
                lokanta_musteriList.add(lokanta_musteri);
            }
        } catch (SQLException e) {

            Logger.getLogger(lokanta_musteriDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return lokanta_musteriList;
    }

    public Connector getDb() {
        if (this.db == null) {
            this.db = new Connector();
        }
        return db;
    }

    public Connection getC() {
        if (this.c == null) {
            this.c = this.getDb().connect();
        }
        return c;
    }

    public musteriDao getMusteriDao() {
        if (this.musteriDao == null) {
            this.musteriDao = new musteriDao();
        }
        return musteriDao;
    }

    public lokantaDao getLokantaDao() {
        if (this.lokantaDao == null) {
            this.lokantaDao = new lokantaDao();
        }
        return lokantaDao;
    }

}
