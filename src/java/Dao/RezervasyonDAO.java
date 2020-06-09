/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Rezervasyon;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Util.Connector;
import java.sql.PreparedStatement;

public class RezervasyonDAO {

    private Connector connector;
    private Connection connection;

    private musteriDao musteridao;

    private OdaDAO odaDao;
    
    public Rezervasyon find(Long id){
       Rezervasyon r=null;
       try{
          PreparedStatement pst = this.getConnection().prepareStatement("select *from rezervasyon where rezervasyon_id=?");
           pst.setLong(1,id);
           ResultSet rs = pst.executeQuery();         
           rs.next();
           Rezervasyon tmp = new Rezervasyon();
                tmp.setRezervasyon_id(rs.getLong("rezervasyon_id"));
                tmp.setGiris_tarihi(rs.getString("giris_tarihi"));
                tmp.setCikis_tarihi(rs.getString("cikis_tarihi"));
           
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
          
       return r;
   }

    public List<Rezervasyon> findAll(int page,int pagesize) {
        List<Rezervasyon> rezervasyonlist = new ArrayList<>();
        int start=(page-1)*pagesize;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from rezervasyon order by rezervasyon_id asc limit "+start+" ,"+pagesize);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Rezervasyon tmp = new Rezervasyon();
                tmp.setRezervasyon_id(rs.getLong("rezervasyon_id"));
                tmp.setGiris_tarihi(rs.getString("giris_tarihi"));
                tmp.setCikis_tarihi(rs.getString("cikis_tarihi"));

                tmp.setMusteri(this.getMusteridao().find(rs.getLong("musteri_id")));

                tmp.setOda(this.getOdaDao().find(rs.getLong("oda_id")));
                rezervasyonlist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return rezervasyonlist;
    }
    public int count() {
        int count=0;     
        try {
           
            PreparedStatement pst=this.getConnection().prepareStatement("select count(rezervasyon_id) as r_count from rezervasyon");
            ResultSet rs=pst.executeQuery();
            rs.next();
            count=rs.getInt("r_count");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
              
        return count;   
    }

    public musteriDao getMusteridao() {
        if (this.musteridao == null) {
            this.musteridao = new musteriDao();
        }
        return musteridao;
    }

    public OdaDAO getOdaDao() {
        if (this.odaDao == null) {
            this.odaDao = new OdaDAO();
        }
        return odaDao;
    }

    public void create(Rezervasyon rezervasyon) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into rezervasyon (giris_tarihi,cikis_tarihi,musteri_id,oda_id) values(?,?,?,?)");
            pst.setString(1, rezervasyon.getGiris_tarihi());
            pst.setString(2, rezervasyon.getCikis_tarihi());
            pst.setLong(3,rezervasyon.getMusteri().getMusteri_id());
            pst.setLong(4, rezervasyon.getOda().getOda_id());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void edit(Rezervasyon rezervasyon) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update rezervasyon set giris_tarihi=?,cikis_tarihi=?,musteri_id=?,oda_id=? where rezervasyon_id=?");
            pst.setString(1, rezervasyon.getGiris_tarihi());
            pst.setString(2, rezervasyon.getCikis_tarihi());
            pst.setLong(3, rezervasyon.getMusteri().getMusteri_id());
            pst.setLong(4, rezervasyon.getOda().getOda_id());
            pst.setLong(5, rezervasyon.getRezervasyon_id());

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void remove(Rezervasyon rezervasyon) {
        
         try{
            PreparedStatement pst=this.getConnection().prepareStatement("delete from musteri where musteri_id=?");
            pst.setLong(1,rezervasyon.getMusteri().getMusteri_id());   
            pst=this.getConnection().prepareStatement("delete from rezervasyon where rezervasyon_id=?");
            pst.setLong(1,rezervasyon.getRezervasyon_id());
            
            pst.executeUpdate();
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    
    }

    public Connector getConnector() {
        if (this.connector == null) {
            this.connector = new Connector();
        }
        return connector;
    }

    public void setConnector(Connector connector) {
        this.connector = connector;
    }

    public Connection getConnection() {
        if (this.connection == null) {
            this.connection = this.getConnector().connect();
        }
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}
