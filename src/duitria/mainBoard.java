package duitria;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.plaf.TreeUI;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainBoard extends JFrame implements ActionListener{

        JLabel label = new JLabel(); //creates a label 
        JFrame frame = new JFrame(); //Creates a frame
        JButton button1 = new JButton(); //Creates a new button

    mainBoard (){




        Panel panelMainBoard = new Panel();
        Panel panelPlayerInfo1 = new Panel();
        Panel panelPlayerInfo2 = new Panel();
        Panel panelPlayerInfo3 = new Panel();
        Panel panelPlayerInfo4 = new Panel();
        Panel panelGameRules = new Panel();
        Panel panelRoll = new Panel();


        frame();
        frame.add(panelMainBoard,BorderLayout.CENTER);
        frame.add(panelPlayerInfo1,BorderLayout.CENTER);
        frame.add(panelPlayerInfo2,BorderLayout.CENTER);
        frame.add(panelPlayerInfo3,BorderLayout.CENTER);
        frame.add(panelPlayerInfo4,BorderLayout.CENTER);
        frame.add(panelGameRules,BorderLayout.CENTER);
        frame.add(panelRoll,BorderLayout.CENTER);

        button1 = new JButton();
        button1.setBounds(0,0,100,100);
        button1.addActionListener(this);






        panelMainBoard.setBackground(Color.green);
        panelMainBoard.setBounds((frame.getWidth()-600)/2,(frame.getHeight()-637)/2, 600, 600);

        panelPlayerInfo1.setBackground(Color.LIGHT_GRAY);
        panelPlayerInfo1.setBounds(0,10, 270, 100); //Gap between each panels is 20

        panelPlayerInfo2.setBackground(Color.LIGHT_GRAY);
        panelPlayerInfo2.setBounds(0,130, 270, 100);

        panelPlayerInfo3.setBackground(Color.LIGHT_GRAY);
        panelPlayerInfo3.setBounds(0,250, 270, 100);

        panelPlayerInfo4.setBackground(Color.LIGHT_GRAY);
        panelPlayerInfo4.setBounds(0,370, 270, 100);

        panelGameRules.setBackground(Color.LIGHT_GRAY);
        panelGameRules.setBounds(frame.getWidth()-270,0, 270, 70);

        panelRoll.setBackground(Color.LIGHT_GRAY);
        panelRoll.setBounds(145/2,530, 100, 100);
        panelRoll.add(button1);
        
    }

    public void frame(){


        frame.setTitle("DuitRIA"); // Sets the title of the game
        frame.setLayout(null);
        //panelMainBoard.setPreferredSize(new Dimension(500,500));
        frame.setSize(1280,720); //set width 420, height 420
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //for fullscreen
        frame.setUndecorated(false); // to add or remove minimize, close button on top right
        frame.setVisible(true); //make frame visible
        frame.setResizable(false); // Prevent frame from being resized
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Exit out of application
        frame.getContentPane().setBackground(Color.WHITE); //change backgrond

        
    }

    public void eventListener(ActionEvent e){
        if (e.getSource()==button1)
        System.out.println("Button roll is pressed");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
  
    }

  

 }

