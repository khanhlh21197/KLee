/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servercaro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author klee211
 */
public class TranscriptDAO {
    
     public static Connection con = null;
    public static PreparedStatement ps = null;
    public static ResultSet rs = null;
    public TranscriptDAO(){
        
    }
    public void BDopen(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gamecaro","root","");
            System.out.println("Da ket noi...");
        } catch (ClassNotFoundException ex) {
           // Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Loi: "+ ex.getMessage());
        } catch (SQLException ex) {
            //Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("chua ket noi Driver: "+ ex.getMessage());
        }
    }
    
    public ArrayList<User> getUser(){
        
         BDopen();
         ArrayList<User> ds = new ArrayList<>();
        if (con != null) {
            System.out.println("Connection ok!!!!!!!!");
            try {
                String SQL = "select * from user";
                ps = con.prepareStatement(SQL);
                rs = ps.executeQuery();
                
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String userName = rs.getString(2);
                    String password = rs.getString(3);
                    String fullName = rs.getString(4);
                    String birthday = rs.getString(5);
                    String email = rs.getString(6);
                    int scores = rs.getInt(7);
                    int matches = rs.getInt(8);
                    
                    ds.add(new User(id, userName, password, fullName, birthday, email, scores, matches));             
                }
            rs.close();
            ps.close();
            con.close();
            } catch (SQLException ex) {
                 System.out.println("Exception!");
            }
        }
        return ds;
    }
    
}
