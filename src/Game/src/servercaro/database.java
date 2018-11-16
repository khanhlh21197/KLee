/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servercaro;

/**
 *
 * @author klee211
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class database 
{
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
   
    public database()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gamecaro","root","");
             System.out.println("Da ket noi...");
           }catch (Exception e) 
        {
            System.out.println(e);
        }
    }
       
    public Boolean checkLogin(String uname,String pwd)
    {
        try {
            pst=con.prepareStatement("select * from user where username=? and password=?");        
            pst.setString(1, uname.toLowerCase()); 
            pst.setString(2, pwd.toLowerCase());    
          
            rs=pst.executeQuery();
            if(rs.next())
            {
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Xác nhận xảy ra lỗi"+e);
            return false;
        }
        
    }
    public Boolean checkRegister(String uname)
    {
        try {
                     
            String SQL = "select * from user where username=?";
            pst = con.prepareStatement(SQL);
            pst.setString(1, uname.toLowerCase()); 
            rs=pst.executeQuery();
            if(rs.next())
            {
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Xác nhận xảy ra lỗi"+e);
            return false;
        }
    }
}