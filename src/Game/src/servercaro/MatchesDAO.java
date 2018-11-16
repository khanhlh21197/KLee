package servercaro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author klee211
 */
public class MatchesDAO {
    public static Connection con = null;
    public static PreparedStatement ps = null;
    public static ResultSet rs = null;
    public MatchesDAO(){
        
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
    public int getMatches(String username){
        int matches = 0;
        BDopen();
        try {
            String sql ="SELECT matches FROM `user` WHERE username= (?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            rs=ps.executeQuery();
            rs.next();
            matches = rs.getInt("matches");
             System.out.println(+matches);
            
            ps.close();
            con.close();
        } catch (SQLException ex) {
           // Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Loi1: "+ex.getMessage());
        }
        
        return matches;
    }
    public void setMatches(int matches, String username){
        BDopen();
        String sql = "UPDATE `user` SET `matches`=(?) WHERE username =(?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, matches);
            ps.setString(2, username);
            
           int sd= ps.executeUpdate();
           if(sd !=0){
               System.out.println("Thanh cong");
           }
           else{
               System.out.println("That bai");
           }
           ps.close();
           con.close();
        } catch (SQLException ex) {
            Logger.getLogger(MatchesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
}
