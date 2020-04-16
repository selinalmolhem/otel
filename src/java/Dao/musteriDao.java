/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Lokanta;
import Entity.Lokanta_musteri;
import Entity.Musteri;
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
public class musteriDao {

    Connector db = new Connector();
    Connection c = db.connect();
    private personelDao ADO;

    private lokantaDao lokantaDao;

    public lokantaDao getLokantaDao() {
        if (this.lokantaDao == null) {
            this.lokantaDao = new lokantaDao();
        }
        return lokantaDao;
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

    public personelDao getADO() {
        if (this.ADO == null) {
            this.ADO = new personelDao();
        }
        return ADO;
    }

    public List<Musteri> findAll() {
        List<Musteri> musteriList = new ArrayList<>();

        try {
            PreparedStatement pst = this.getC().prepareStatement("select *from musteri");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Musteri musteri = new Musteri();
                musteri.setMusteri_id(rs.getLong("musteri_id"));
                musteri.setAd_soyad(rs.getString("ad_soyad"));
                musteri.setTc(rs.getInt("TC"));
                musteri.setTel(rs.getString("tel"));
                musteri.setAddres(rs.getString("addres"));

                musteri.setMusteri_lokanta(this.getLokantaDao().getmusterlokanta(musteri.getMusteri_id()));
                musteri.setPersonel(this.getADO().find(rs.getLong("personel_id")));
                musteriList.add(musteri);
            }
        } catch (SQLException e) {

            Logger.getLogger(musteriDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return musteriList;
    }

//    public void insert(Musteri m) {
//        try {
//            PreparedStatement pst = this.getC().prepareStatement("insert into musteri(ad_soyad,TC,tel,addres) values(?,?,?,?)");
//            pst.setString(1, m.getAd_soyad());
//            pst.setString(2, m.getTel());
//            pst.setInt(3, m.getTc());
//            pst.setString(4, m.getAddres());
//
//            //  st.executeUpdate("insert into musteri(ad_soyad,TC,tel,addres) values('" + m.getAd_soyad() + "','" + m.getTc() + "','" + m.getTel() + "','" + m.getAddres() + "')");
//        } catch (SQLException e) {
//            Logger.getLogger(musteriDao.class.getName()).log(Level.SEVERE, null, e);
//        }
//    }

    public void delete(Musteri musteri) {

        try {
            PreparedStatement pst = this.getC().prepareStatement("delete from lokanta_musteri where musteri_id=?");
            pst.setLong(1, musteri.getMusteri_id());
            pst.executeUpdate();
            pst = this.getC().prepareStatement("delete from musteri where musteri_id=?");
            // st.executeUpdate("delete from musteri where musteri_id=" + musteri.getMusteri_id());
            pst.setLong(1, musteri.getMusteri_id());
            pst.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(musteriDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void insert(Musteri m) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("insert into musteri(ad_soyad, TC, tel, addres, personel_id) values(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, m.getAd_soyad());
            pst.setInt(2, m.getTc());
            pst.setString(3, m.getTel());
            pst.setString(4, m.getAddres());
            pst.setLong(5,m.getPersonel().getPersonel_id());
           pst.executeUpdate();
//            Statement st = this.getC().createStatement();
//            st.executeUpdate("insert into musteri(ad_soyad,TC,tel,addres,personel_id)"
//                    + "values('" + m.getAd_soyad() + "','" + m.getTc() + "','" + m.getTel() + "','" + m.getAddres() + "','" + selectedpersonel + "')", Statement.RETURN_GENERATED_KEYS);
            Long musteri_id = null;
            ResultSet gk = pst.getGeneratedKeys();

            if (gk.next()) {
                musteri_id = gk.getLong(1);
            }

            for (Lokanta C :m.getMusteri_lokanta() ) {
                pst = this.getC().prepareStatement("insert into lokanta_musteri (lokanta_id,musteri_id) values(?,?)");
                //   pst2.executeUpdate("insert into lokanta_musteri (lokanta_id,musteri_id) values(" + l + "," + musteri_id + ")");
                pst.setLong(1, C.getMenu_id());
                pst.setLong(2, musteri_id);

                pst.executeUpdate();

            }
        } catch (SQLException e) {
            Logger.getLogger(musteriDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void edit(Musteri m) {
        try {
            PreparedStatement pst = this.getC().prepareStatement("update musteri set ad_soyad=?,TC=?,tel=?,addres=? where musteri_id=?");
            pst.setString(1, m.getAd_soyad());
            pst.setInt(2, m.getTc());
            pst.setString(3, m.getTel());
            pst.setString(4, m.getAddres());
            pst.setLong(5, m.getMusteri_id());
            pst.executeUpdate();
            pst = this.getC().prepareStatement("delete from lokanta_musteri where musteri_id=?");
            pst.setLong(1, m.getMusteri_id());
            pst.executeUpdate();
           for (Lokanta C :m.getMusteri_lokanta() ) {
                pst = this.getC().prepareStatement("insert into lokanta_musteri (lokanta_id,musteri_id) values(?,?)");
                pst.setLong(1, C.getMenu_id());
                pst.setLong(2, m.getMusteri_id());
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            Logger.getLogger(musteriDao.class.getName()).log(Level.SEVERE, null, e);
        }

    }
     public Musteri find(Long id){
       Musteri l=null;
       try{
           PreparedStatement pst = this.getC().prepareStatement("select *from musteri where musteri_id=?");
           pst.setLong(1,id);
           ResultSet rs = pst.executeQuery();         
           rs.next();
           l=new Musteri();
           l.setMusteri_id(rs.getLong("musteri_id"));
           l.setAd_soyad(rs.getString("ad_soyad"));
           l.setTc(rs.getInt("TC"));
           l.setTel(rs.getString("tel"));
           l.setAddres(rs.getString("addres"));   
           
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
          
       return l;
   }
}
