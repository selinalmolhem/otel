/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Personel;
import Entity.Personel;
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
public class personelDao {

    Connector db = new Connector();
    Connection c = db.connect();

//    public List <Personel> findAll(){
//     List <Personel> lList =new ArrayList<>();
//     try {
//            Statement st = this.getC().createStatement();
//            ResultSet rs = st.executeQuery("select *from personel");
//           while( rs.next()){
//            Personel p = new Personel();
//            p.setPersonel_id(rs.getLong("personel_id"));
//            p.setAd_soyad(rs.getString("ad_soyad"));
//            p.setTc(rs.getInt("TC"));
//            p.setTel(rs.getString("tel"));
//            lList.add(p);
//        }} catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return lList;
//    
//    }
    public Personel find(long id) {
        Personel p = null;

        try {
            PreparedStatement pst = this.getC().prepareStatement("select *from personel where personel_id=?");
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();
            rs.next();
            p = new Personel();
            p.setPersonel_id(rs.getLong("personel_id"));
            p.setAd_soyad(rs.getString("ad_soyad"));
            p.setTc(rs.getInt("TC"));
            p.setTel(rs.getString("tel"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return p;
    }

    public void update(Personel personel) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("update personel set ad_soyad=?,TC=?,tel=? where personel_id=?");
            pst.setString(1, personel.getAd_soyad());
            pst.setInt(2, personel.getTc());
            pst.setString(3, personel.getTel());
            pst.setLong(4, personel.getPersonel_id());
            pst.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(personelDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void delete(Personel personel) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("delete from personel where personel_id=?");
            pst.setLong(1, personel.getPersonel_id());
            pst.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(personelDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void insert(Personel personel) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("insert into personel(ad_soyad,TC,tel) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, personel.getAd_soyad());
            pst.setInt(2, personel.getTc());
            pst.setString(3, personel.getTel());
            pst.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(personelDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public List<Personel> findAll() {
        List<Personel> personelList = new ArrayList<>();

        try {
            Statement st = this.getC().createStatement();
            ResultSet rs = st.executeQuery("select *from personel");
            while (rs.next()) {
                Personel personel = new Personel();
                personel.setPersonel_id(rs.getLong("personel_id"));
                personel.setAd_soyad(rs.getString("ad_soyad"));
                personel.setTc(rs.getInt("TC"));
                personel.setTel(rs.getString("tel"));
                personelList.add(personel);
            }
        } catch (SQLException e) {

            Logger.getLogger(personelDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return personelList;
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
