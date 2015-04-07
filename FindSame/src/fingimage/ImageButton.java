/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fingimage;

import javax.swing.*;
import javax.swing.*;

/**
 *
 * @author gaitanesnikos
 */
public class ImageButton extends JButton {

    boolean found;

    public int getWichOne() {
        return wichOne;
    }

    public void setWichOne(int wichOne) {
        this.wichOne = wichOne;
    }
    int wichOne;

    public ImageButton() {
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }
    private ImageIcon imageIconBuckUp;

    public ImageIcon getImIcon() {
        return imageIconBuckUp;
    }

    public void setImIcon(ImageIcon imIcon) {
        this.imageIconBuckUp = imIcon;
    }
}
