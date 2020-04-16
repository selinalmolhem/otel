/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Lokanta;
import Util.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KING PHONE
 */
public class lokantaDao {

    Connector db = new Connector();

    Connection c = db.connect();
    
    public List<Lokanta> findAll() {
        List<Lokanta> lokantaList = new ArrayList<>();

        try {
            PreparedStatement pst = this.getC().prepareStatement("select *from lokanta");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Lokanta lokanta = new Lokanta();
                lokanta.setMenu_id(rs.getLong("lokanta_id"));
                lokanta.setMenu(rs.getString("menu"));
                lokanta.setFiyat(rs.getInt("fiyat"));

                lokantaList.add(lokanta);
            }
        } catch (SQLException e) {

            Logger.getLogger(lokantaDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return lokantaList;
    }

    public void insert(Lokanta lokanta) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("insert into lokanta(menu ,fiyat) values(?,?)", Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, lokanta.getMenu());
            pst.setInt(2, lokanta.getFiyat());
            pst.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(lokantaDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void delete(Lokanta lokanta) {

        try {
            PreparedStatement pst = this.getC().prepareStatement("delete from lokanta where lokanta_id=?");
            pst.setLong(1, lokanta.getMenu_id());
            pst.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(lokantaDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void update(Lokanta lokanta) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("update lokanta set menu=?,fiyat=? where lokanta_id=?");
            pst.setString(1, lokanta.getMenu());
            pst.setInt(2, lokanta.getFiyat());
            pst.setLong(2, lokanta.getMenu_id());
            pst.executeUpdate();

        } catch (SQLException e) {
            Logger.getLogger(lokantaDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public List<Lokanta> getmusterlokanta(Long musteri_id) {
        List<Lokanta> musterilokanta = new ArrayList<>();

        try {
            PreparedStatement pst = this.getC().prepareStatement("select *from lokanta_musteri where musteri_id=?");
            pst.setLong(1, musteri_id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                musterilokanta.add(this.find(rs.getLong("lokanta_id")));
            }
        } catch (SQLException e) {

            Logger.getLogger(lokantaDao.class.getName()).log(Level.SEVERE, null, e);
        }

        return musterilokanta;
    }

    public Lokanta find(Long id) {
        Lokanta l = null;
        try {
             PreparedStatement pst = this.getC().prepareStatement("select *from lokanta where lokanta_id=?");
             pst.setLong(1,id);
            ResultSet rs = pst.executeQuery();
            rs.next();
            l = new Lokanta();
            l.setMenu_id(rs.getLong("lokanta_id"));
            l.setMenu(rs.getString("menu"));
            l.setFiyat(rs.getInt("fiyat"));

        } catch (SQLException e) {

            Logger.getLogger(lokantaDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return l;
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

}
