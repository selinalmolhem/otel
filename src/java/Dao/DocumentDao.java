/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Document;
import Util.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bayoon
 */
public class DocumentDao {
    private Connector connector;
    private Connection connection;
    
    public List<Document> findAll(){
        List<Document> dlist=new ArrayList<>();      
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from document");

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                Document d = new Document();
                d.setId(rs.getLong("id"));
                d.setFilepath(rs.getString("path"));
                d.setFilename(rs.getString("name"));
                d.setFiletype(rs.getString("type"));
                dlist.add(d);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return dlist;
    }
    public void insert(Document d) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into document (path,name,type) values (?,?,?)");
            pst.setString(1, d.getFilepath());
            pst.setString(2, d.getFilename());
            pst.setString(3, d.getFiletype());
            pst.executeUpdate();

            
            }catch (SQLException ex) {
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
