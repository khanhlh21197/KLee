/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servercaro;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author klee211
 */
// truy xuat vao CSDL
public class ScoresDAO {
    public static Connection con = null;
    public static PreparedStatement ps = null;
    public static ResultSet rs = null;
    public ScoresDAO(){
        
    }
    public void BDopen(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gamecaro","root","");
            System.out.println("Da ket noi...");
        } catch (ClassNotFoundException ex) {
           // Logger.getLogger(ScoresDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Loi: "+ ex.getMessage());
        } catch (SQLException ex) {
            //Logger.getLogger(ScoresDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("chua ket noi Driver: "+ ex.getMessage());
        }
    }
    public int getdiem(String username){
        int diem = 0;
        BDopen();
        try {
            String sql ="SELECT scores FROM `user` WHERE username= (?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            rs=ps.executeQuery();
            rs.next();
            diem = rs.getInt("scores");
             System.out.println(+diem);
            
            ps.close();
            con.close();
        } catch (SQLException ex) {
           // Logger.getLogger(ScoresDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Loi1: "+ex.getMessage());
        }
        
        return diem;
    }
    public void setdiem(int diem, String username){
        BDopen();
        String sql = "UPDATE `user` SET `scores`=(?) WHERE username =(?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, diem);
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
            Logger.getLogger(ScoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

}
