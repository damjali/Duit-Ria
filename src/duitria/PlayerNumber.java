package duitria;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;


public class PlayerNumber extends JFrame implements ActionListener {

    static int playerNum;
    
    Border border = BorderFactory.createLineBorder(Color.BLACK,1);
    JButton button2Player = new JButton();
    JButton button3Player = new JButton();
    JButton button4Player = new JButton();
    
    PlayerNumber (){

    SwingUtilities.invokeLater(() -> {
        
     this.setSize(1280, 720);
     this.setVisible(true);
     this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     this.getContentPane().setBackground(Color.BLACK);
     this.setTitle("DuitRIA");
     this.setResizable(false);
     this.setLayout(null);
      
     JPanel panelImage = new JPanel();
     panelImage.setBackground(Color.BLACK);
     panelImage.setBounds(0, 0, 640, 720);
     JLabel labelIcon = new JLabel();
     labelIcon.setBounds(0, 0, 640, 720);
     labelIcon.setIcon(imageicon.getResizedImage("src\\duitria\\Icons\\logo-color.png", 640, 720));
     panelImage.add(labelIcon);
     this.add(panelImage);
     
     
     
     JPanel panelButtons = new JPanel();
     panelButtons.setBackground(new Color(24, 23, 23));
     panelButtons.setBounds(640, 0, 640, 720);
     panelButtons.setBorder(border);
     panelButtons.setLayout(null);
     this.add(panelButtons);
     JLabel labelNumberOfPlayers = new JLabel();
     labelNumberOfPlayers.setText("NUMBER OF PLAYERS");
     labelNumberOfPlayers.setForeground(Color.white);
     labelNumberOfPlayers.setFont(new Font("Arial",Font.BOLD,45));
     labelNumberOfPlayers.setBounds(70, -110, 500, 500);
     panelButtons.add(labelNumberOfPlayers);


     
     button2Player.addActionListener(this);
     button2Player.setSize(500, 100);
     button2Player.setBounds(70, 230, 500, 80);
     button2Player.setText("2 PLAYERS");
     button2Player.setFocusable(false);
     panelButtons.add(button2Player);
     
     button3Player.addActionListener(this);
     button3Player.setSize(500, 100);
     button3Player.setBounds(70, 360, 500, 80);
     button3Player.setText("3 PLAYERS");
     button3Player.setFocusable(false);
     panelButtons.add(button3Player);

     button4Player.addActionListener(this);
     button4Player.setSize(500, 100);
     button4Player.setBounds(70, 490, 500, 80);
     button4Player.setText("4 PLAYERS");
     button4Player.setFocusable(false);
     panelButtons.add(button4Player);

        
    
    });
}
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button2Player){
            PlayerSelectIcon2 playerselecticon2 = new PlayerSelectIcon2();
            playerNum = 2;
            this.dispose();
        }
        
        if(e.getSource()==button3Player){
            PlayerSelectIcon3 playerselecticon3 = new PlayerSelectIcon3();
            playerNum = 3;
            this.dispose();
            
        }

        if(e.getSource()==button4Player){
            PlayerSelectIcon4 playerselecticon4 = new PlayerSelectIcon4();
            playerNum=4;
            this.dispose();
            
        }
    }


    


class imageicon{

    public static ImageIcon getResizedImage(String path, int width, int height){
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(path)
                                .getImage()
                                .getScaledInstance(
                                    width, 
                                    height, 
                                    Image.SCALE_SMOOTH));
    
    return imageIcon;
    }
    
}

}


 