/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fingimage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author gaitanesnikos
 */
public class ImagePanel extends JPanel {

    private Dimension finalDimensions;
    private int checkNotToPressedTheSame;
    static int countScore = 0;
    boolean virginFinish = true;
    private JButton startOver = new JButton("newGame");
    String playerName = null;
    private boolean gameOver;
    int xxx = 1;
    private StartingThread startThread;
    boolean isAllreadyAnother = false;
    private int NumOfButtons = 16;
    static int level = 1;
    private ImageButton allreadyPressed;
    private ImageIcon pressedIcon;
    ImageFrame fr;
    private ImageButton[] buttons;
    private ImageIcon[] imageIcons = {new ImageIcon("heart.png"), new ImageIcon("walk1.png"), new ImageIcon("barrel.png"), new ImageIcon("pacMan.png"), new ImageIcon("cherry.png")};
    private ArrayList listWithImageIconsForEachButton = new ArrayList();
    private Random rand = new Random();

    public ImageButton[] getButtons() {
        return buttons;
    }

    public void setButtons(ImageButton[] buttons) {
        this.buttons = buttons;
    }

    public Dimension getFinalDimensions() {
        return finalDimensions;
    }

    public void setFinalDimensions(Dimension finalDimensions) {
        this.finalDimensions = finalDimensions;
    }

    public ImagePanel(ImageFrame fr) {
        enterName();
        this.fr = fr;
startOver.setIcon(new ImageIcon("playAgain.png"));
startOver.setPressedIcon(new ImageIcon("newGame.PNG"));
        startOver.addActionListener(nG);
        makeLevels();
        TimerThread tmerThed = new TimerThread(this, fr);
        tmerThed.start();

    }

    public void enterName() {
        try {
            playerName = JOptionPane.showInputDialog("exterName");
            if (playerName.equals("")) {
                System.out.println("Enter_A_RealName");
                enterName();

            }
        } catch (NullPointerException e) {
            System.exit(0);
        }
    }

    public void gameOver() {
        this.removeAll();
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void nextLenel() {

        countScore += 100;
        StartingThread.timeToStart -= 300;
        try {
            for (int i = 0; i < xxx * xxx; i++) {
                this.remove(buttons[i]);
            }

//            for (int i = 0; i < buttons.length; i++) {
//                buttons[i].setEnabled(true);
//            }

            makeLevels();
            for (int i = 0; i < listWithImageIconsForEachButton.size(); i++) {
                listWithImageIconsForEachButton.remove(i);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void makeLevels() {
        this.removeAll();
        virginFinish = true;
        level++;
        xxx += 1;
        if (xxx > 4) {
            xxx = 4;
        }
        if (level == 15) {
            xxx = 5;
            StartingThread.timeToStart = 5000;

        }

        if (level >= 15) {
            xxx = 5;
            TimerThread.sec = 150;
        }


        this.setLayout(new GridLayout(xxx, xxx));
        buttons = new ImageButton[(xxx) * (xxx)];

        int count = 0;


        int kkk = xxx;
        if (xxx == 5) {
            kkk = 13;
        }
        if (xxx == 4) {
            kkk = 8;
        }
        if (xxx == 3) {
            kkk = 5;
        }
        int integerStart = 0;
        for (int i = 0; i < (kkk); i++) {
            integerStart++;
            if (integerStart >= 5) {
                integerStart = 0;
            }

            //int randInt=  rand.nextInt(xxx);
            listWithImageIconsForEachButton.add(imageIcons[integerStart]);
            listWithImageIconsForEachButton.add(imageIcons[integerStart]);


        }


        for (int i = 0; i < xxx; i++) {
            for (int j = 0; j < xxx; j++) {

                buttons[count] = new ImageButton();
                this.add(buttons[count]);
                buttons[count].setWichOne(count);
                ImageIcon ic = addIconToButtons();
                buttons[count].setEnabled(false);
                buttons[count].setFound(false);
                buttons[count].setIcon(ic);
                buttons[count].setImIcon(ic);
                buttons[count].addActionListener(action);

                count++;
            }
        }
        startThread = new StartingThread(buttons);
        startThread.start();

    }

    public ImageIcon addIconToButtons() {



        int xx = rand.nextInt(listWithImageIconsForEachButton.size());
        ImageIcon im = (ImageIcon) listWithImageIconsForEachButton.get(xx);
        listWithImageIconsForEachButton.remove(xx);

        return im;


    }
    ActionListener action = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            ImageButton imageButtonNowPressed = (ImageButton) e.getSource();
            if (allreadyPressed != null && imageButtonNowPressed.getWichOne() == allreadyPressed.getWichOne()) {
                return;
            }
            imageButtonNowPressed.setIcon(imageButtonNowPressed.getImIcon());

            if (isAllreadyAnother) {



                allreadyPressed.setIcon(allreadyPressed.getImIcon());
                imageButtonNowPressed.setIcon(imageButtonNowPressed.getImIcon());






                if (!(allreadyPressed.getImIcon() == imageButtonNowPressed.getImIcon())) {
                    TimerThread.sec -= 10;
                    virginFinish = false;
                    new ThreadToShowLitleThePressedButton(allreadyPressed, imageButtonNowPressed, startThread).start();

                } else {
                    imageButtonNowPressed.setFound(true);
                    imageButtonNowPressed.removeActionListener(action);
                    allreadyPressed.removeActionListener(action);
                    allreadyPressed.setFound(true);
                    countScore += 10;
                }





            } else {
                allreadyPressed = imageButtonNowPressed;

            }

            isAllreadyAnother = !isAllreadyAnother;

            chechNextLev();


        }
    };

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void chechNextLev() {
        boolean gonextLevel = false;
        int counter = 0;
        for (int i = 0; i < buttons.length; i++) {

            if (buttons[i].found) {
                counter++;
                if (counter == buttons.length || counter == buttons.length - 1) {
                    gonextLevel = true;
                }


            }

        }
        if (gonextLevel) {
            if (virginFinish) {

                System.out.println("Perfect  you have bonus + 200 _ Ready for level " + level + 1);
                countScore += 200;
            }

            TimerThread.sec = 100;
            nextLenel();
            gonextLevel = false;

        }

    }
    ActionListener nG = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            newGame();
        }
    };

    public void newGame() {
        enterName();
        level = 1;
        xxx=1;
        StartingThread.timeToStart=5000;
        fr.getP().removeAll();
        TimerThread tmerThed = new TimerThread(this, fr);
        tmerThed.sec = 100;
        tmerThed.start();




        countScore = 0;
        this.makeLevels();
        System.out.println("level " + level);

    }

    public void paint(Graphics g) {
        super.paint(g);
        if (gameOver) {
//            g.clearRect(0, 0, this.getWidth(), this.getHeight());
//            Font f = new Font("", Font.BOLD, 60);
//            g.setFont(f);
//            g.drawString("GameOver", 100, 200);
            fr.setSize(this.getWidth(), this.getHeight() - 1);
            System.out.println(countScore);
            gameOver = false;
            finalDimensions = new Dimension(this.getWidth(), this.getHeight());
            fr.getP().add(startOver, BorderLayout.AFTER_LAST_LINE);

        }
    }
}
