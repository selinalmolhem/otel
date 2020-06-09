package login_logout;


import Entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsersDAO {
private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public static boolean validate(String user, String password,String a) {
        Connection con = null;
        PreparedStatement ps = null;
        

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement("Select uname,password,userTuru from Users where uname = ? and password = ? and userTuru =? ");
            ps.setString(1, user);
            ps.setString(2, password);
            ps.setString(3, a);
            
            ResultSet rs = ps.executeQuery();
            
            

            if (rs.next()) {
                //result found, means valid inputs
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
            DBConnection.close(con);
        }
        return false;
    }
     public  boolean validate(String user, String password) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement("Select uname,password,userTuru from Users where uname = ? and password = ?");
            ps.setString(1, user);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            
            

            if (rs.next()) {
                //result found, means valid inputs
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
            DBConnection.close(con);
        }
        return false;
    }

    static void insert(String uname, String password,String userTuru) {
        DBConnection.getConnection();

        try {
            Statement sts = DBConnection.getConnection().createStatement();
            String sql = "INSERT INTO users(uname,password,userTuru) VALUES('" + uname + "','"+password+"','" + userTuru + "')";
            sts.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

//    public boolean varmi() {
//       DBConnection.getConnection();
//        PreparedStatement ps ;
//        try {
//            ps = con.prepareStatement("Select uname,password,userTuru from Users where uname = ? and password = ?");
//            ps.setString(1,this.getUser().getUserName());
//            ps.setString(2,this.getUser().getPassword());
//            
//            ResultSet rs = ps.executeQuery();
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
    }

