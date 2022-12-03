/*
We have to use Swing, so I'm just creating a thank you screen when you exit.
 */
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EndScreen extends Canvas{
    public static final int WIDTH = 400, HEIGHT = 400; // canvas
    public static void DisplayScreen() {
        JFrame f = new JFrame("End Screen");//shows at the top
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new EndScreen();
        canvas.setSize(WIDTH, HEIGHT);
        f.add(canvas);
        f.pack();
        f.setVisible(true);
    }

        public void paint(Graphics g){
            g.setColor(Color.BLACK);
            g.drawString("Thank You For Using Our Detector",100,200); //writing the face and suit for the card
            g.drawString("Made by Ashley and John", 100, 250);//add our names, i guess credits??
        }
}


