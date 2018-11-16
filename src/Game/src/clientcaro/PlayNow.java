package clientcaro;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


/**
 *
 * @author klee211
 */
public class PlayNow extends Thread {

    private JPanel user;

    public PlayNow(JPanel user) {
        this.user = user;
    }

    @Override
    public void run() {
        while (true) {
            user.setBorder(new LineBorder(Color.YELLOW));
            try {
                Thread.sleep(500);
                user.setBorder(new LineBorder(Color.RED));
                Thread.sleep(500);
            } catch (InterruptedException ex) {
               
            }
        }
    }
}
