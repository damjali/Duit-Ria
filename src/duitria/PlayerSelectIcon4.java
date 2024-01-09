package duitria;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;


public class PlayerSelectIcon4 extends JFrame implements ActionListener {


    Border border = BorderFactory.createLineBorder(Color.BLACK,1);
    JButton buttonStart = new JButton();


    String player1;
    String player2;
    String player3;
    String player4;

    playerIcons playerIcon1;
    playerIcons playerIcon2;
    playerIcons playerIcon3;
    playerIcons playerIcon4;


    PlayerSelectIcon4 (){

    SwingUtilities.invokeLater(() -> {
        
     this.setSize(1280, 720);
     this.setVisible(true);
     this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     this.getContentPane().setBackground(Color.BLACK);
     this.setTitle("DuitRIA");
     this.setResizable(false);
     this.setLayout(null);

     
     JPanel panelBackground =  new JPanel();
     panelBackground.setBackground(Color.BLACK);
     panelBackground.setBounds(0, 0, 1280, 720);
     panelBackground.setLayout(null);
     this.add(panelBackground);

     buttonStart.setBounds(433, 570, 400, 80);
     buttonStart.setText("Start Game");
     buttonStart.setFocusable(false);
     buttonStart.addActionListener(this);
     panelBackground.add(buttonStart);

     
     playerIcon1 = new playerIcons(40, 110,panelBackground,"src\\playertoken\\CAT.png");
     playerIcon2 = new playerIcons(347, 110,panelBackground,"src\\playertoken\\CAR.png");
     playerIcon3 = new playerIcons(654, 110,panelBackground,"src\\playertoken\\HAT.png");
     playerIcon4 = new playerIcons(960, 110,panelBackground,"src\\playertoken\\DUCK.png");


     

      
    
     
});
    }

public void actionPerformed(ActionEvent e){
    if(e.getSource()==buttonStart){

        Board board = new Board();
        this.dispose();
        player1 = playerIcon1.playerNameTextField.getText();
        player2 = playerIcon2.playerNameTextField.getText();
        player3 = playerIcon3.playerNameTextField.getText();
        player4 = playerIcon4.playerNameTextField.getText();
        board.setName(player1, player2, player3, player4);
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



class playerIcons extends JPanel{

        JTextField playerNameTextField = new JTextField();

playerIcons(int x, int y, JPanel panelBackground, String path){
        SwingUtilities.invokeLater(() -> {
        this.setBackground(new Color(217,217,217));
        this.setBounds(x, y, 266, 350);
        this.setLayout(null);
        panelBackground.add(this);
        this.setBorder(border);

        JLabel labelToken = new JLabel();
        JPanel panelImage = new JPanel();
        JPanel panelPlayerName = new JPanel();

        panelImage.setBackground(new Color(143,143,143));
        panelImage.setBounds(6, 7, 253, 253);
        labelToken.setIcon(imageicon.getResizedImage(path, 253, 253));
        labelToken.setBounds(0, 0, 253, 253);
        panelImage.setLayout(null);
        panelImage.add(labelToken);
        this.add(panelImage);
        panelImage.setBorder(border);

        panelPlayerName.setBounds(6, 288, 253, 48);
        panelPlayerName.setBorder(border);
        panelPlayerName.setLayout(null);
        this.playerNameTextField.setBounds(0, 0, 253, 48);
        this.playerNameTextField.setPreferredSize(new Dimension(253,48));
        this.playerNameTextField.setFont(new Font("Arial", Font.BOLD, 30));
        this.playerNameTextField.setBorder(border);
        panelPlayerName.add(this.playerNameTextField);
        this.add(panelPlayerName);
    


        });
    }
}




}