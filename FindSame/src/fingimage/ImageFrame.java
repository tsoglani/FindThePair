/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fingimage;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author gaitanesnikos
 */
public class ImageFrame extends JFrame {

    private JPanel p;

    public ImageFrame() {
        p = new JPanel();

        this.setSize(600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImagePanel imp = new ImagePanel(this);
        this.add(imp, BorderLayout.CENTER);
        this.add(p, BorderLayout.BEFORE_FIRST_LINE);
        this.setVisible(true);

    }

    public JPanel getP() {
        return p;
    }

    public void setP(JPanel p) {
        this.p = p;
    }
}
