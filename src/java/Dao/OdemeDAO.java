/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Odeme;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Util.Connector;
import java.sql.PreparedStatement;



public class OdemeDAO {
    
    private Connector connector;
    private Connection connection;
    
    private musteriDao musteridao;
  
    
    public Odeme find(Long id){
       Odeme odeme=null;
       try{
          PreparedStatement pst = this.getConnection().prepareStatement("select *from odeme where odeme_id=?");
           pst.setLong(1,id);
           ResultSet rs = pst.executeQuery();         
           rs.next();
           Odeme tmp=new Odeme();
               tmp.setOdeme_id(rs.getLong("odeme_id"));
               tmp.setTarih(rs.getDate("tarih"));
               tmp.setOdeme_tipi(rs.getString("odeme_tipi"));
               tmp.setFiyat(rs.getInt("fiyat"));
           
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
          
       return odeme;
   }  
    
    public List<Odeme> findAll(int page,int pagesize ) {
        List<Odeme> odemelist=new ArrayList<>(); 
        int start=(page-1)*pagesize;
        try {
           
             PreparedStatement pst=this.getConnection().prepareStatement("select * from odeme order by odeme_id asc limit "+start+" ,"+pagesize);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
              
               Odeme tmp=new Odeme();
               tmp.setOdeme_id(rs.getLong("odeme_id"));
               tmp.setTarih(rs.getDate("tarih"));
               tmp.setOdeme_tipi(rs.getString("odeme_tipi"));
               tmp.setFiyat(rs.getInt("fiyat"));
              
               tmp.setMusteri(this.getMusteridao().find( rs.getLong("musteri_id")));
               
               odemelist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
              
        return odemelist;   
    }
    public int count() {
        int count=0;     
        try {
           
            PreparedStatement pst=this.getConnection().prepareStatement("select count(odeme_id) as odeme_count from odeme");
            ResultSet rs=pst.executeQuery();
            rs.next();
            count=rs.getInt("odeme_count");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
              
        return count;   
    }
   
    public void create(Odeme odeme) {
        
        try{
            PreparedStatement pst=this.getConnection().prepareStatement("insert into odeme(odeme_tipi,fiyat,musteri_id) values(?,?,?)");
            pst.setString(1,odeme.getOdeme_tipi());
            pst.setInt(2,odeme.getFiyat());
            pst.setLong(3,odeme.getMusteri().getMusteri_id());
             
            pst.executeUpdate();
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void edit(Odeme odeme) {
        try{
            PreparedStatement pst=this.getConnection().prepareStatement("update odeme set odeme_tipi=?,fiyat=?,musteri_id=? where odeme_id=?");
            pst.setString(1,odeme.getOdeme_tipi());
            pst.setInt(2,odeme.getFiyat());
            pst.setLong(3,odeme.getMusteri().getMusteri_id());
            pst.setLong(4,odeme.getOdeme_id());
            
            pst.executeUpdate();
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    
    }
     public void remove(Odeme odeme) {
           try{
            PreparedStatement pst=this.getConnection().prepareStatement("delete from odeme where odeme_id=?");
            pst.setLong(1,odeme.getOdeme_id());
            
            pst.executeUpdate();
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    
    }

 public musteriDao getMusteridao() {
        if(this.musteridao==null)
            this.musteridao=new musteriDao();
        return musteridao;
    }
    public Connector getConnector() {
          if(this.connector==null)
            this.connector=new Connector();
        return connector;
    }

    public void setConnector(Connector connector) {
        this.connector = connector;
    }

    public Connection getConnection() {
        if(this.connection==null)
            this.connection=this.getConnector().connect();
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

   
}
