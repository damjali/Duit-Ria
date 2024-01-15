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

public class HomeScreenGUI extends JFrame implements ActionListener {

  
    
    Border border = BorderFactory.createLineBorder(Color.BLACK,1);
    JButton buttonStartGame = new JButton();
    JButton buttonGameRules = new JButton();
    JButton buttonContinueGame = new JButton();
    
    HomeScreenGUI (){

    SwingUtilities.invokeLater(() -> {
        
     this.setSize(1280, 720);
     this.setVisible(true);
     this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     this.getContentPane().setBackground(Color.WHITE);
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
     
     buttonStartGame.addActionListener(this);
     buttonStartGame.setSize(500, 100);
     buttonStartGame.setBounds(70, 180, 500, 80);
     buttonStartGame.setText("START GAME");
     buttonStartGame.setFocusable(false);
     panelButtons.add(buttonStartGame);
     
     buttonGameRules.addActionListener(this);
     buttonGameRules.setSize(500, 100);
     buttonGameRules.setBounds(70, 310, 500, 80);
     buttonGameRules.setText("GAME RULES");
     buttonGameRules.setFocusable(false);
     panelButtons.add(buttonGameRules);

     buttonContinueGame.addActionListener(this);
     buttonContinueGame.setSize(500, 100);
     buttonContinueGame.setBounds(70, 440, 500, 80);
     buttonContinueGame.setText("CONTINUE GAME");
     buttonContinueGame.setFocusable(false);
     panelButtons.add(buttonContinueGame);

        
    
    });
}
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==buttonStartGame) {
            PlayerNumber playerNumber = new PlayerNumber("saveFileGUI1.ser");
            this.dispose();
        }
        
        if (e.getSource()==buttonGameRules) {
            GameRules gameRule = new GameRules();
        }

        if (e.getSource() == buttonContinueGame) {
            SaveFileGUI saveFileGUI = new SaveFileGUI();
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


 