package duitria;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.plaf.TreeUI;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Panel;

public class mainBoard extends JFrame {

    mainBoard (){


        JLabel label = new JLabel(); //creates a label 
        JFrame frame = new JFrame(); //Creates a frame
        Panel panelMainBoard = new Panel();
        //frame.setLayout(new BorderLayout(1000,1000));
        
        frame.setTitle("DuitRIA"); // Sets the title of the game
        frame.setLayout(null);
        panelMainBoard.setBackground(Color.green);
        //panelMainBoard.setPreferredSize(new Dimension(500,500));
        frame.setSize(1280,720); //set width 420, height 420
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //for fullscreen
        frame.setUndecorated(false); // to add or remove minimize, close button on top right
        frame.setVisible(true); //make frame visible
        frame.setResizable(false); // Prevent frame from being resized
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Exit out of application
        frame.getContentPane().setBackground(Color.WHITE); //change backgrond
        frame.add(panelMainBoard,BorderLayout.CENTER);
        panelMainBoard.setBounds((1280-500)/2,(720-500)-1, 500, 500);
    }
 }