package duitria;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GUI {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame(); //Creates a frame
        frame.setTitle("DuitRIA"); // Sets the title of the game
        frame.setSize(420,420); //set width 40, height 40
        frame.setVisible(true); //make frame visible
        frame.setResizable(false); // Prevent frame from being resized
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Exit out of application

        ImageIcon image = new ImageIcon("logo-color.png");// create an image icon
        frame.setIconImage(image.getImage());//change the program icon
        frame.getContentPane().setBackground(Color.BLACK); //change backgrond

        
        
        
        
        
        
        
    }
    
}
