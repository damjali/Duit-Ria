
package duitria;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Board extends JFrame implements ActionListener {
    
    JButton buttonRoll = new JButton();
    JButton buttonGameRules = new JButton();
    
    Board() {
        
        
    SwingUtilities.invokeLater(() -> {
    //Creating Frame
    Border border = BorderFactory.createLineBorder(Color.BLACK,1);
    this.setVisible(true); //make frame visible
    this.setSize(1920,1080); //set width and height
    this.setTitle("DuitRIA"); //change the title
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit when close
    this.setResizable(false); //prevents frame from being resized
    ImageIcon image = new ImageIcon("logo.png"); //create an image icon
    this.setIconImage(image.getImage()); //set the icon image to image
    this.getContentPane().setBackground(Color.WHITE);
    this.setLayout(null);
    
    //frame.getContentPane().setBackground(new Color(225,0,0));
    JPanel panelBoard = new JPanel();
    panelBoard.setBackground(new Color(0xA3FF9B));
    panelBoard.setBounds((this.getWidth()/2)-500, (this.getHeight()/2)-525, 1000, 1000);
    this.add(panelBoard);
    panelBoard.setLayout(null);
    panelBoard.setBorder(border);
    
    
    //For Tile Free Parking
    JPanel panelFreeParking = new JPanel();
    panelFreeParking.setBounds(0, 0, 158, 158);
    panelFreeParking.setBackground(Color.WHITE);
    panelFreeParking.setBorder(border);
    panelFreeParking.setLayout(null);
    panelBoard.add(panelFreeParking);

    //For Tile GO
    JPanel panelGO = new JPanel();
    panelGO.setBounds(842, 842, 158, 158);
    panelGO.setBackground(Color.WHITE);
    panelGO.setBorder(border);
    panelGO.setLayout(null);
    panelBoard.add(panelGO);
   
    //For Tile GO TO JAIL
    JPanel panelGoToJail = new JPanel();
    panelGoToJail.setBounds(842, 0, 158, 158);
    panelGoToJail.setBackground(Color.WHITE);
    panelGoToJail.setBorder(border);
    panelGoToJail.setLayout(null);
    panelBoard.add(panelGoToJail);
    
    //For Tile JAIL
    JPanel panelJail = new JPanel();
    panelJail.setBounds(0, 842, 158, 158);
    panelJail.setBackground(Color.WHITE);
    panelJail.setBorder(border);
    panelJail.setLayout(null);
    panelBoard.add(panelJail);
    
    
    
   miniTilesUpAndBotom tile22 = new miniTilesUpAndBotom(766,0, panelBoard);
   miniTilesUpAndBotom tile21 = new miniTilesUpAndBotom(690,0, panelBoard);
   miniTilesUpAndBotom tile20 = new miniTilesUpAndBotom(614,0, panelBoard);
   miniTilesUpAndBotom tile19 = new miniTilesUpAndBotom(538,0, panelBoard);
   miniTilesUpAndBotom tile18 = new miniTilesUpAndBotom(462,0, panelBoard);
   miniTilesUpAndBotom tile17 = new miniTilesUpAndBotom(386,0, panelBoard);
   miniTilesUpAndBotom tile16 = new miniTilesUpAndBotom(310,0, panelBoard);
   miniTilesUpAndBotom fate4 = new miniTilesUpAndBotom(234,0, panelBoard);
   miniTilesUpAndBotom tile15 = new miniTilesUpAndBotom(158,0, panelBoard);
    
    miniTilesUpAndBotom tile1 = new miniTilesUpAndBotom(766,842, panelBoard);
   miniTilesUpAndBotom fate1 = new miniTilesUpAndBotom(690,842, panelBoard);
   miniTilesUpAndBotom tile2 = new miniTilesUpAndBotom(614,842, panelBoard);
   miniTilesUpAndBotom tax = new miniTilesUpAndBotom(538,842, panelBoard);
   miniTilesUpAndBotom tile3 = new miniTilesUpAndBotom(462,842, panelBoard);
   miniTilesUpAndBotom tile4 = new miniTilesUpAndBotom(386,842, panelBoard);
   miniTilesUpAndBotom fate2 = new miniTilesUpAndBotom(310,842, panelBoard);
   miniTilesUpAndBotom tile5 = new miniTilesUpAndBotom(234,842, panelBoard);
   miniTilesUpAndBotom tile6 = new miniTilesUpAndBotom(158,842, panelBoard);

    miniTilesLeftAndRight tile7 = new miniTilesLeftAndRight(0,766, panelBoard);
    miniTilesLeftAndRight fate8 = new miniTilesLeftAndRight(0,690, panelBoard);
    miniTilesLeftAndRight tile9 = new miniTilesLeftAndRight(0,614, panelBoard);
    miniTilesLeftAndRight tile10 = new miniTilesLeftAndRight(0,538, panelBoard);
    miniTilesLeftAndRight tile11 = new miniTilesLeftAndRight(0,462, panelBoard);
    miniTilesLeftAndRight tile12 = new miniTilesLeftAndRight(0,386, panelBoard);
    miniTilesLeftAndRight fate3 = new miniTilesLeftAndRight(0,310, panelBoard);
    miniTilesLeftAndRight tile13 = new miniTilesLeftAndRight(0,234, panelBoard);
    miniTilesLeftAndRight tile14 = new miniTilesLeftAndRight(0,158, panelBoard);
    
    miniTilesLeftAndRight tile28 = new miniTilesLeftAndRight(842,766, panelBoard);
    miniTilesLeftAndRight tax2 = new miniTilesLeftAndRight(842,690, panelBoard);
    miniTilesLeftAndRight tile27 = new miniTilesLeftAndRight(842,614, panelBoard);
    miniTilesLeftAndRight fate6 = new miniTilesLeftAndRight(842,538, panelBoard);
    miniTilesLeftAndRight tile26 = new miniTilesLeftAndRight(842,462, panelBoard);
    miniTilesLeftAndRight tile25 = new miniTilesLeftAndRight(842,386, panelBoard);
    miniTilesLeftAndRight fate5 = new miniTilesLeftAndRight(842,310,panelBoard);
    miniTilesLeftAndRight tile24 = new miniTilesLeftAndRight(842,234, panelBoard);
    miniTilesLeftAndRight tile23 = new miniTilesLeftAndRight(842,158, panelBoard);

    
    //INITIALIZE PLAYER CARD PANEL
    playerCard playerCard1 = new playerCard(0,40,this);
    playerCard playerCard2 = new playerCard(0,245,this);
    playerCard playerCard3 = new playerCard(0,450,this);
    playerCard playerCard4 = new playerCard(0,655,this);
    
    //INITIALIZE GAME RULE PANEL
    JPanel panelGameRule = new JPanel();
    panelGameRule.setBounds(1600, 0, 320, 90);
    panelGameRule.setBackground(Color.LIGHT_GRAY);
    panelGameRule.setBorder(border);
    panelGameRule.setLayout(null);
    buttonGameRules.setBounds(0, 0, 320, 90);
    buttonGameRules.addActionListener(this);
    buttonGameRules.setText("GAME RULES");
    buttonGameRules.setFocusable(false);
    panelGameRule.add(buttonGameRules);
    this.add(panelGameRule);
    
    //Initialize Player Log History Panel
    playerLogHistory playerLog1 = new playerLogHistory(1500,140,this);
    playerLogHistory playerLog2 = new playerLogHistory(1500,300,this);
    playerLogHistory playerLog3 = new playerLogHistory(1500,460,this);
    playerLogHistory playerLog4 = new playerLogHistory(1500,620,this);
    playerLogHistory playerLog5 = new playerLogHistory(1500,780,this);
    
    //Initialize Roll panel Button
    JPanel panelRoll = new JPanel();
    panelRoll.setBounds(110 , 860, 150,150);
    buttonRoll.setBounds(0 , 0, 150,150);
    buttonRoll.addActionListener(this);
    buttonRoll.setIcon(imageicon.getResizedImage("src\\duitria\\Icons\\dice.png", 150, 150));
    panelRoll.setBackground(Color.WHITE);
    panelRoll.setBorder(border);
    panelRoll.setLayout(null);
    panelRoll.add(buttonRoll);
    this.add(panelRoll);
    
    });

    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==buttonRoll){
            System.out.println("Bruh Moment");
        }
    
        if(e.getSource()==buttonGameRules){
           GameRules gamerules = new GameRules();
        }
    }


}

 class miniTilesUpAndBotom extends JPanel{ 
     
     miniTilesUpAndBotom(int a, int b, JPanel panelBoard, String path){
         SwingUtilities.invokeLater(() -> {
            Border border = BorderFactory.createLineBorder(Color.BLACK,1);
            this.setBounds(a, b, 76, 158);
            this.setBackground(Color.WHITE);
            this.setBorder(border);
            this.setLayout(null);

            ImageIcon icon = imagetile.getResizedTile(path,76, 158);
            JLabel labelImage = new JLabel();
            labelImage.setIcon(icon);
            labelImage.setBounds(0, 0, this.getWidth(), this.getHeight());
            this.add(labelImage);
            panelBoard.add(this); 
         });
     }

     miniTilesUpAndBotom(int a, int b, JPanel panelBoard){
         SwingUtilities.invokeLater(() -> {
            Border border = BorderFactory.createLineBorder(Color.BLACK,1);
            this.setBounds(a, b, 76, 158);
            this.setBackground(Color.WHITE);
            this.setBorder(border);
            this.setLayout(null);
            panelBoard.add(this); 
         });
     }
     
     miniTilesUpAndBotom(int a, int b, JPanel panelBoard, int c, int d){
         SwingUtilities.invokeLater(() -> {
            Border border = BorderFactory.createLineBorder(Color.BLACK,1);
            this.setBounds(a, b, c, d);
            this.setBackground(Color.WHITE);
            this.setBorder(border);
            this.setLayout(null);
            panelBoard.add(this);
         });
     }

    private void setIcon(ImageIcon icon) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

 class miniTilesLeftAndRight extends JPanel{
     
     miniTilesLeftAndRight(int a, int b, JPanel panelBoard){
         SwingUtilities.invokeLater(() -> {
            Border border = BorderFactory.createLineBorder(Color.BLACK,1);
            this.setBounds(a, b, 158, 76);
            this.setBackground(Color.WHITE);
            this.setBorder(border);
            this.setLayout(null);
            panelBoard.add(this);
         });
     }
     miniTilesLeftAndRight(int a, int b, JPanel panelBoard, int c, int d){
         SwingUtilities.invokeLater(() -> {
            Border border = BorderFactory.createLineBorder(Color.BLACK,1);
            this.setBounds(a, b, c, d);
            this.setBackground(Color.WHITE);
            this.setBorder(border);
            this.setLayout(null);
            panelBoard.add(this);
         });
     }
}

 class playerCard extends JPanel{
     
     playerCard(int a, int b, JFrame frame){
         SwingUtilities.invokeLater(() -> {
            Border border = BorderFactory.createLineBorder(Color.BLACK,1);
            this.setBackground(Color.LIGHT_GRAY);
            this.setBounds(a, b, 375, 175);
            this.setBorder(border);
            this.setLayout(null);
            frame.add(this);
         });
     }

}

 class playerLogHistory extends JPanel{
     
     playerLogHistory(int a, int b, JFrame frame){
         SwingUtilities.invokeLater(() -> {
            Border border = BorderFactory.createLineBorder(Color.BLACK,1);
            this.setBackground(Color.LIGHT_GRAY);
            this.setBounds(a, b, 420, 150);
            this.setBorder(border);
            this.setLayout(null);
            frame.add(this);
         });
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

class imagetile{

    public static ImageIcon getResizedTile(String path, int width, int height){
        
        
        ImageIcon imageTile = new ImageIcon(new ImageIcon(path)
                                .getImage()
                                .getScaledInstance(
                                    width, 
                                    height, 
                                    Image.SCALE_SMOOTH));
    
    return imageTile;
    }
    
}

