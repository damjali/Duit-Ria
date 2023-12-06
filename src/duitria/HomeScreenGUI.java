package duitria;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class HomeScreenGUI extends JFrame {

    HomeScreenGUI (){


        JLabel label = new JLabel(); //creates a label 
        JFrame frame = new JFrame(); //Creates a frame
        ImageIcon image = new ImageIcon("Icons\\Main Home Scaled.png");// create an image icon
        Border border = BorderFactory.createLineBorder(new Color(0xFFD700),3);

        label.setText("Bro do you even code ?"); //set text of label
        frame.setTitle("DuitRIA"); // Sets the title of the game




        frame.setSize(1280,720); //set width 420, height 420
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //for fullscreen
        frame.setLayout(null); //it does not automatically order a label/image
        frame.setUndecorated(false); // to add or remove minimize, close button on top right
        frame.setVisible(true);
        frame.setVisible(true); //make frame visible
        frame.setResizable(false); // Prevent frame from being resized
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Exit out of application
        frame.setIconImage(image.getImage());//change the program icon
        frame.getContentPane().setBackground(Color.BLACK); //change backgrond



        frame.add(label);
        //label.setBorder(border);
        label.setForeground(Color.white);//set text color
        label.setFont(new Font("Comic Sans", Font.PLAIN,20));//set font and size
        label.setIcon(image);//put an icon on text
        //label.setIconTextGap(100);
        label.setHorizontalTextPosition(JLabel.LEFT); //set text left, center or right of image
        label.setVerticalTextPosition(JLabel.TOP); //set text to top, center or bottom of image icon
        label.setBounds(0,0,1280,720);
    
    }
 }