/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servercaro;

import java.util.ArrayList;

/**
 *
 * @author klee211
 */
public class address {

    public static ArrayList<Integer> port1 = new ArrayList<Integer>();
    public static ArrayList<Integer> port2 = new ArrayList<Integer>();
    public static ArrayList<String> ip = new ArrayList<String>();
    public static ArrayList<String> name = new ArrayList<String>();
    public address(Integer port1, Integer port2, String ip)
    {
      this.port1.add(port1);
      this.port2.add(port2);
      this.ip.add(ip);
    }

    address() {
    }
}
