/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.User;
import Util.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Selin almolhem
 */
public class userdao {
   Connector db = new Connector();
    Connection c = db.connect();
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
     public User find(long id) {
        User p = null;

        try {
            PreparedStatement pst = this.getC().prepareStatement("select *from users where uname=?");
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();
            rs.next();
            p = new User();
            p.setUserName(rs.getString("uname"));
            p.setPassword(rs.getString("password"));
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return p;
    }

  
     
}
