
package Dao;

import Util.Connector;
import Entity.Oda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OdaDAO {    
    private Connector connector;
    private Connection connection;
    
    public Oda find(Long id){
       Oda oda=null;
       try{
          PreparedStatement pst = this.getConnection().prepareStatement("select *from oda where oda_id=?");
           pst.setLong(1,id);
           ResultSet rs = pst.executeQuery();         
           rs.next();
           oda=new Oda();
           oda.setOda_id(rs.getLong("oda_id"));
           oda.setOda_no(rs.getInt("oda_no"));
           oda.setOda_tipi(rs.getString("oda_tipi"));
           oda.setDurum(rs.getString("durum"));
           
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
          
       return oda;
   }  
    
    public List<Oda> findAll(int page,int pagesize){
        List<Oda> odalist=new ArrayList<>();  
        int start=(page-1)*pagesize;
        try {
           
            PreparedStatement pst = this.getConnection().prepareStatement("select *from oda order by oda_id asc limit "+start+" ,"+pagesize);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
              
               Oda tmp=new Oda();
               tmp.setOda_id(rs.getLong("oda_id"));
               tmp.setOda_no(rs.getInt("oda_no"));
               tmp.setOda_tipi(rs.getString("oda_tipi"));
               tmp.setDurum(rs.getString("durum"));
               odalist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
              
        return odalist;
    }
    public int count() {
        int count=0;     
        try {
           
            PreparedStatement pst=this.getConnection().prepareStatement("select count(oda_id) as oda_count from oda");
            ResultSet rs=pst.executeQuery();
            rs.next();
            count=rs.getInt("oda_count");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
              
        return count;   
    }
    public void insert(Oda oda) {
      try{          
         // Statement st=this.getConnection().createStatement();
          //st.executeUpdate("insert into oda(oda_no,oda_tipi,durum) values('" +oda.getOda_no() +" ',' " +oda.getOda_tipi()+"','"+oda.getDurum()+"')"); 
          PreparedStatement pst = this.getConnection().prepareStatement("insert into oda(oda_no,oda_tipi,durum) values(?,?,?)");
            pst.setLong(1,oda.getOda_no() );
            pst.setString(2,oda.getOda_tipi());
            pst.setString(3, oda.getDurum());
            
            pst.executeUpdate();
            
         }catch (Exception ex) {
           System.out.println(ex.getMessage());
        }
        
    }

    public void delete(Oda oda) {
        
      try{         
          //Statement st=this.getConnection().createStatement();
          //st.executeUpdate("delete from oda where oda_id="+oda.getOda_id());
            PreparedStatement pst = this.getConnection().prepareStatement("delete from oda where oda_id=?");
            pst.setLong(1, oda.getOda_id());
            pst.executeUpdate();
     } catch (Exception ex) {
              System.out.println(ex.getMessage());

        }
    }

    public void update(Oda oda) {
          
      try{  
        
          /*Statement st=this.getConnection().createStatement();
          st.executeUpdate("update oda set oda_no='"+oda.getOda_no()+"' where oda_id="+oda.getOda_id());
          st.executeUpdate("update oda set oda_tipi='"+oda.getOda_tipi()+"' where oda_id="+oda.getOda_id());
          st.executeUpdate("update oda set durum='"+oda.getDurum()+"' where oda_id="+oda.getOda_id());*/
           PreparedStatement pst = this.getConnection().prepareStatement("update oda set oda_no=?,oda_tipi=?,durum=? where oda_id=?");
            pst.setLong(1, oda.getOda_no());
            pst.setString(2, oda.getOda_tipi());
            pst.setString(3, oda.getDurum());
            pst.setLong(4, oda.getOda_id());
            
            pst.executeUpdate();

     } catch (Exception ex) {
              System.out.println(ex.getMessage());

        }
    }

    public Connector getConnector() {
        if(this.connector==null)
            this.connector=new Connector();
        return connector;
    }

    public Connection getConnection() {
        if(this.connection==null)
            this.connection=this.getConnector().connect();
        return connection;
    }

    
}
