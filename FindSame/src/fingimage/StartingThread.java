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
public class StartingThread extends Thread {

    public ImageIcon getQuestionMark() {
        return questionMark;
    }

    public void setQuestionMark(ImageIcon questionMark) {
        this.questionMark = questionMark;
    }
   ImageButton[] buttons;
   static int timeToStart=5000;
private ImageIcon questionMark;
ImageIcon [] im= {new ImageIcon("1.png"),new ImageIcon("2.png"),new ImageIcon("3.png")};
    public StartingThread(ImageButton[] buttons) {
        this.buttons = buttons;
      int  x=  (int) (Math.random()*3);
        questionMark=im[x];
        
    }
    
    
    
    
    public void run(){
        try {
            if (timeToStart>4500) {
                this.sleep(timeToStart);
            }else{
             this.sleep(1000);
             
            }
            
            
            for (int i = 0; i < buttons.length; i++) {
                buttons[i].setIcon(questionMark);
                buttons[i].setEnabled(true);
                this.sleep(100);
                
            }
        
            
            
            
            
        } catch (InterruptedException ex) {
            
        }
    
    
    
    }
}
