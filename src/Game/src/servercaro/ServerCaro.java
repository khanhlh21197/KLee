/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servercaro;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;


/**
 *
 * @author klee211
 */

public class ServerCaro {

    /**
     * @param args the command line arguments
     * 
     */         
        static int port = 1000;
          public static void main(String[] args) {
                   
                 try{
	            ServerSocket serverSocket = new ServerSocket(7777); 
	            System.out.println("Khởi chạy máy chủ thành công");
	            while(true){ //Khi luon chay va cho ket noi     
	                new ThreadSocket(serverSocket.accept(), port).start(); 
                        //Tạo Thread mới khi có 1 Client kết nối thành công
	                System.out.println("Có 1 kết nối đến");
                        port = port + 2;
	            }
	        }
	        catch(IOException e){
	            System.out.println("Exception: " +e.getMessage());
		}
	}
}
