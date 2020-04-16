/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author KING PHONE
 */
public class Connector {
    private Connection connection;
    public Connection connect() 
    {
        if(this.connection==null){ 
                 
         try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/otel","root","741");
              
            }catch(SQLException e){
                System.out.println(e.getMessage());}
            catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        }
        }
        return connection;
    
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }
    
}


