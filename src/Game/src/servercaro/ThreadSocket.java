/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servercaro;

/**
 *
 * @author klee211
 */
import java.io.*;
import java.net.*;

public class ThreadSocket extends Thread {

    Socket socket;
    int port;
    database db;
    address add;

    ThreadSocket(Socket pSocket, int i) {
        this.socket = pSocket;
        port = i;
        db = new database();

    }

    @Override
    public void run() {
        try {
            System.out.println("------------" + port);
            //Tạo luồng nhận dữ liệu từ bàn phím
            DataInputStream inFromServer = new DataInputStream(System.in);
            //Tạo luồng nhận dữ liệu từ Client
            DataInputStream inFromClient = new DataInputStream(socket.getInputStream());
            //Tạo luồng gửi dữ liệu về Client
            DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());

            while (true) {
                String string = inFromClient.readLine();
                System.out.println(string);
                String[] ss = string.split("-");
                if (ss[0].equals("1"))//kiem tra dang nhap
                {
                    System.out.println("Username,Password:" + ss[1] + "," + ss[2]);
                    if (db.checkLogin(ss[1], ss[2])) {
                        outToClient.writeBytes("1\n");
                    } else {
                        outToClient.writeBytes("0\n");
                    }
                }
                if (ss[0].equals("2")) //dang ky thanh vien
                {
                    String infor;
                    String account;
                    account = "INSERT INTO `gamecaro`.`user` (`username`, `password`, `fullname`, `birthday`, `email`, `scores`, `matches` ) VALUES (?,?,?,?,?,?,?)";

                    db.pst = db.con.prepareStatement(account);
                    db.pst.setString(1, ss[1].toLowerCase());
                    db.pst.setString(2, ss[2]);
                    db.pst.setString(3, ss[3]);
                    db.pst.setString(4, ss[4]);
                    db.pst.setString(5, ss[5]);
                    db.pst.setInt(6, 0);
                    db.pst.setInt(7, 0);
                    db.pst.executeUpdate();
                    db.pst.close();
                    outToClient.writeBytes("1\n");
                }
                if (ss[0].equals("3")) // tao server
                {
                    System.out.println("Đã tạo Server");
                    int port1 = port + 1;
                    add.port1.add(port);
                    add.port2.add(port1);
                    add.ip.add("127.0.0.1");
                    add.name.add(ss[1]);
                    String _string = "127.0.0.1-" + port + "-" + port1;
                    //gui address ve client
                    outToClient.writeBytes(_string + "\n");
                }

                if (ss[0].equals("4")) // tao client
                {

                    String _strPort1 = ""; 
                    String _strPort2 = ""; 
                    String _strIp = ""; 
                    String _strName = "";
                    for (int i = 0; i < add.port1.size(); i++) {
                        _strPort1 = _strPort1 + add.port1.get(i) + "-";
                        _strPort2 = _strPort2 + add.port2.get(i) + "-";
                        _strIp = _strIp + add.ip.get(i) + "-";
                        _strName = _strName + add.name.get(i) + "-";
                    }

                    outToClient.writeBytes(_strPort1 + "\n");
                    outToClient.writeBytes(_strPort2 + "\n");
                    outToClient.writeBytes(_strIp + "\n");
                    outToClient.writeBytes(_strName + "\n");
                    System.out.println(_strPort1);
                    System.out.println(_strPort2);
                    System.out.println(_strIp);
                    System.out.println(_strName);
                    String[] sss = _strName.split("-");
                    System.out.println(sss.length);
                    for (int i = 0; i < sss.length; i++) {
                        System.out.println(sss[i]);
                    }
                }
                if (ss[0].equals("5")) {
                    int j = 0;
                    for (j = 0; j < add.name.size(); j++) {
                        if (ss[1].equals(add.name.get(j))) {
                            break;
                        }
                    }
                    add.port1.remove(j);
                    add.port2.remove(j);
                    add.ip.remove(j);
                    add.name.remove(j);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
   
    }
}
