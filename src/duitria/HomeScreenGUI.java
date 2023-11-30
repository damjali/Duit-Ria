package duitria;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;

public class HomeScreenGUI extends JFrame {

    HomeScreenGUI (){


        JLabel label = new JLabel(); //creates a label 
        JFrame frame = new JFrame(); //Creates a frame


        label.setText("Bro do you even code ?"); //set text of label
        frame.setTitle("DuitRIA"); // Sets the title of the game




        //frame.setSize(420,420); //set width 420, height 420
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //for fullscreen

        frame.setUndecorated(false); // to add or remove minimize, close button on top right
        frame.setVisible(true);
        frame.setVisible(true); //make frame visible
        frame.setResizable(true); // Prevent frame from being resized
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Exit out of application
        ImageIcon image = new ImageIcon("Icons\\logo-color.png");// create an image icon
        frame.setIconImage(image.getImage());//change the program icon
        frame.getContentPane().setBackground(Color.BLACK); //change backgrond



        frame.add(label);
        label.setForeground(Color.WHITE);
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER); //set text left, center or right of image
        label.setVerticalTextPosition(JLabel.CENTER); //set text to top, center or bottom of image icon

    }
 }