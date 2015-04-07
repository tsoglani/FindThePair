/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fingimage;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author gaitanesnikos
 */
public class ThreadToShowLitleThePressedButton extends Thread {

    private ImageButton imageIconBeforePressed;
    private ImageButton imageIconNowPressed;
    StartingThread startingThread;

    public ThreadToShowLitleThePressedButton(ImageButton imageIconBeforePressed, ImageButton imageIconNowPressed, StartingThread startingThread) {
        this.imageIconBeforePressed = imageIconBeforePressed;
        this.imageIconNowPressed = imageIconNowPressed;
        this.startingThread = startingThread;
    }

    public void run() {
        try {
            this.sleep(500);
            imageIconBeforePressed.setIcon(startingThread.getQuestionMark());
            imageIconNowPressed.setIcon(startingThread.getQuestionMark());

        } catch (InterruptedException ex) {
        }


    }
}
