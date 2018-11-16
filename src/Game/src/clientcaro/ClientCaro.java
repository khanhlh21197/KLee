/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientcaro;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


/**
 *
 * @author klee211
 */
public class ClientCaro {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) throws IOException {
    
            Socket ClientSocket = new Socket("localhost", 7777); 
            System.out.println("Kết nối thành công!");
            System.out.println(ClientSocket.getInetAddress());
            
            
            //Tạo luồng nhận dữ liệu từ bàn phím
            DataInputStream inFromUser = new DataInputStream(System.in); 
            //Tạo luồng nhận dữ liệu từ Server
            DataInputStream inFromServer = new DataInputStream(ClientSocket.getInputStream()); 
            //Tạo luồng gửi dữ liệu lên Server
            DataOutputStream outToServer = new DataOutputStream(ClientSocket.getOutputStream()); 
        
            //Login at server
            LoginCaro logincaro = new LoginCaro(inFromServer, outToServer);

	}
}
