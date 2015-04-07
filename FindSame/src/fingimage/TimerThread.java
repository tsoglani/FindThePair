/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fingimage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 *
 * @author gaitanesnikos
 */
public class TimerThread extends Thread {

    static int sec = 100;
    ImagePanel panel;
    ImageFrame fr;
    JLabel label = new JLabel();
    JPanel pa;
    JProgressBar progressBar = new JProgressBar();

    public TimerThread(ImagePanel panel, ImageFrame fr) {
        this.panel = panel;
        this.fr = fr;
        pa = fr.getP();
        pa.setLayout(new FlowLayout());
        pa.add(label);
        pa.add(progressBar);
        progressBar.setBorderPainted(true);
        progressBar.setMaximum(100);
        progressBar.setMinimum(0);
        progressBar.setForeground(Color.red);
        progressBar.setString("Time");
        progressBar.setBackground(Color.blue);

    }

    public void run() {

        while (true) {
            try {



                this.sleep(1000);

                label.setText(" Level  " + Integer.toString(ImagePanel.level - 1) + "    _     Score :    " + Integer.toString(ImagePanel.countScore) + "     TimeRemain : " + Integer.toString(sec));

                if (sec <= 0) {
                    panel.gameOver();
                    panel.setGameOver(true);
                    panel.repaint();
                    System.out.println("gameOver");
                    Base b = new Base(panel.getPlayerName(), fr, panel);

                    fr.repaint();
                    fr.getP().repaint();

                    sec = 0;
                    this.stop();
                    System.out.println("steel");
                }


                sec--;
                progressBar.setValue(sec);
                //     panel.chechNextLev();

            } catch (InterruptedException ex) {
            }








        }



    }
}
