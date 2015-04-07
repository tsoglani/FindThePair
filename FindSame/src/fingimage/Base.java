package fingimage;

import java.io.*;
import java.lang.String;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author user
 */
public class Base {

    ImageFrame frame;
    String playerName = null;
    static Hashtable<String, Integer> scoreTable;
    FileWriter writeFile;
    String read, write;

    public Base(String name, ImageFrame frame,ImagePanel panel) {
        this.playerName = name;

        scoreTable = new Hashtable<String, Integer>();
        this.frame = frame;


        readAndWriteFromBase(panel);
    }

    public void readAndWriteFromBase(ImagePanel p) {

        try {


            OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream("scores.txt", true), "UTF-8");
            BufferedWriter fbw = new BufferedWriter(writer);
            fbw.write(playerName + " -" + ImagePanel.countScore);
            fbw.newLine();
            fbw.close();
            ReadFromBaseFile r = new ReadFromBaseFile(frame,p);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
