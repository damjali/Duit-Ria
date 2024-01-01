
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
    this.setSize(1280,720); //set width and height
    this.setTitle("Frame1"); //change the title
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit when close
    this.setResizable(false); //prevents frame from being resized
    ImageIcon image = new ImageIcon("logo.png"); //create an image icon
    this.setIconImage(image.getImage()); //set the icon image to image
    this.getContentPane().setBackground(Color.WHITE);
    this.setLayout(null);
    
    //frame.getContentPane().setBackground(new Color(225,0,0));
    JPanel panelBoard = new JPanel();
    panelBoard.setBackground(new Color(0xA3FF9B));
    panelBoard.setBounds(640-333, 360-351, 666, 666);
    this.add(panelBoard);
    panelBoard.setLayout(null);
    panelBoard.setBorder(border);
    
    
    //For Tile Free Parking
    JPanel panelFreeParking = new JPanel();
    panelFreeParking.setBounds(0, 0, 105, 105);
    panelFreeParking.setBackground(Color.WHITE);
    panelFreeParking.setBorder(border);
    panelFreeParking.setLayout(null);
    panelBoard.add(panelFreeParking);

    //For Tile GO
    JPanel panelGO = new JPanel();
    panelGO.setBounds(561, 561, 105, 105);
    panelGO.setBackground(Color.WHITE);
    panelGO.setBorder(border);
    panelGO.setLayout(null);
    /*
    JLabel labelGo = new JLabel();
    ImageIcon imageGO = new ImageIcon("C:\\Users\\Adam Razali\\Desktop\\Coding\\New Folder\\Adam Razali\\LearningSwing\\src\\ICONS\\GO.png");
    labelGo.setIcon(imageGO);
    labelGo.setBounds(561,561,105,105);
    panelGO.add(labelGo);
    */
    panelBoard.add(panelGO);
   
    //For Tile GO TO JAIL
    JPanel panelGoToJail = new JPanel();
    panelGoToJail.setBounds(561, 0, 105, 105);
    panelGoToJail.setBackground(Color.WHITE);
    panelGoToJail.setBorder(border);
    panelGoToJail.setLayout(null);
    panelBoard.add(panelGoToJail);
    
    //For Tile JAIL
    JPanel panelJail = new JPanel();
    panelJail.setBounds(0, 561, 105, 105);
    panelJail.setBackground(Color.WHITE);
    panelJail.setBorder(border);
    panelJail.setLayout(null);
    panelBoard.add(panelJail);
    
    
    
//    miniTilesUpAndBotom tile22 = new miniTilesUpAndBotom(512,0, panelBoard);
//    miniTilesUpAndBotom tile21 = new miniTilesUpAndBotom(463,0, panelBoard);
//    miniTilesUpAndBotom tile20 = new miniTilesUpAndBotom(414,0, panelBoard);
//    miniTilesUpAndBotom tile19 = new miniTilesUpAndBotom(365,0, panelBoard);
//    miniTilesUpAndBotom tile18 = new miniTilesUpAndBotom(316,0, panelBoard);
//    miniTilesUpAndBotom tile17 = new miniTilesUpAndBotom(267,0, panelBoard);
//    miniTilesUpAndBotom tile16 = new miniTilesUpAndBotom(202,0, panelBoard,66,105);
//    miniTilesUpAndBotom fate4 = new miniTilesUpAndBotom(153,0, panelBoard);
//    miniTilesUpAndBotom tile15 = new miniTilesUpAndBotom(104,0, panelBoard);
    
    miniTilesUpAndBotom tile1 = new miniTilesUpAndBotom(512,561, panelBoard, "D:\\JAVA PROJECTS\\DuitRIA\\src\\duitria.tiles\\latest.png");
//    miniTilesUpAndBotom fate1 = new miniTilesUpAndBotom(463,561, panelBoard);
//    miniTilesUpAndBotom tile2 = new miniTilesUpAndBotom(414,561, panelBoard);
//    miniTilesUpAndBotom tax = new miniTilesUpAndBotom(365,561, panelBoard);
//    miniTilesUpAndBotom tile3 = new miniTilesUpAndBotom(316,561, panelBoard);
//    miniTilesUpAndBotom tile4 = new miniTilesUpAndBotom(267,561, panelBoard);
//    miniTilesUpAndBotom fate2 = new miniTilesUpAndBotom(202,561, panelBoard,66,105);
//    miniTilesUpAndBotom tile5 = new miniTilesUpAndBotom(153,561, panelBoard);
//    miniTilesUpAndBotom tile6 = new miniTilesUpAndBotom(104,561, panelBoard);

    miniTilesLeftAndRight tile7 = new miniTilesLeftAndRight(0,512, panelBoard);
    miniTilesLeftAndRight fate8 = new miniTilesLeftAndRight(0,463, panelBoard);
    miniTilesLeftAndRight tile9 = new miniTilesLeftAndRight(0,414, panelBoard);
    miniTilesLeftAndRight tile10 = new miniTilesLeftAndRight(0,365, panelBoard);
    miniTilesLeftAndRight tile11 = new miniTilesLeftAndRight(0,316, panelBoard);
    miniTilesLeftAndRight tile12 = new miniTilesLeftAndRight(0,267, panelBoard);
    miniTilesLeftAndRight fate3 = new miniTilesLeftAndRight(0,202, panelBoard,105,66);
    miniTilesLeftAndRight tile13 = new miniTilesLeftAndRight(0,153, panelBoard);
    miniTilesLeftAndRight tile14 = new miniTilesLeftAndRight(0,104, panelBoard);
    
    miniTilesLeftAndRight tile28 = new miniTilesLeftAndRight(561,512, panelBoard);
    miniTilesLeftAndRight tax2 = new miniTilesLeftAndRight(561,463, panelBoard);
    miniTilesLeftAndRight tile27 = new miniTilesLeftAndRight(561,414, panelBoard);
    miniTilesLeftAndRight fate6 = new miniTilesLeftAndRight(561,365, panelBoard);
    miniTilesLeftAndRight tile26 = new miniTilesLeftAndRight(561,316, panelBoard);
    miniTilesLeftAndRight tile25 = new miniTilesLeftAndRight(561,267, panelBoard);
    miniTilesLeftAndRight fate5 = new miniTilesLeftAndRight(561,202, panelBoard,105,66);
    miniTilesLeftAndRight tile24 = new miniTilesLeftAndRight(561,153, panelBoard);
    miniTilesLeftAndRight tile23 = new miniTilesLeftAndRight(561,104, panelBoard);

    
    //INITIALIZE PLAYER CARD PANEL
    playerCard playerCard1 = new playerCard(0,26,this);
    playerCard playerCard2 = new playerCard(0,163,this);
    playerCard playerCard3 = new playerCard(0,300,this);
    playerCard playerCard4 = new playerCard(0,436,this);
    
    //INITIALIZE GAME RULE PANEL
    JPanel panelGameRule = new JPanel();
    panelGameRule.setBounds(1050, 26, 216, 60);
    panelGameRule.setBackground(Color.LIGHT_GRAY);
    panelGameRule.setBorder(border);
    panelGameRule.setLayout(null);
    buttonGameRules.setBounds(0, 0, 216, 60);
    buttonGameRules.addActionListener(this);
    buttonGameRules.setText("GAME RULES");
    buttonGameRules.setFocusable(false);
    panelGameRule.add(buttonGameRules);
    this.add(panelGameRule);
    
    //Initialize Player Log History Panel
    playerLogHistory playerLog1 = new playerLogHistory(1000,143,this);
    playerLogHistory playerLog2 = new playerLogHistory(1000,250,this);
    playerLogHistory playerLog3 = new playerLogHistory(1000,356,this);
    playerLogHistory playerLog4 = new playerLogHistory(1000,463,this);
    playerLogHistory playerLog5 = new playerLogHistory(1000,570,this);
    
    //Initialize Roll panel Button
    JPanel panelRoll = new JPanel();
    panelRoll.setBounds(75 , 568, 100,100);
    buttonRoll.setBounds(0 , 0, 100,100);
    buttonRoll.addActionListener(this);
    buttonRoll.setIcon(imageicon.getResizedImage("src\\duitria\\Icons\\dice.png", 100, 100));
    panelRoll.setBackground(Color.WHITE);
    panelRoll.setBorder(border);
    panelRoll.setLayout(null);
    panelRoll.add(buttonRoll);
    this.add(panelRoll);
    
    /*
    JLabel labelFree = new JLabel();
    labelFree.setText("FREE");
    labelFree.setFont(new Font("Arial",Font.BOLD,20));
    labelFree.setBounds(25,0,80 , 80);
    panelFreeParking.add(labelFree);
    JLabel labelParking = new JLabel();
    labelParking.setText("Parking");
    labelParking.setFont(new Font("PARKING",Font.BOLD,20));
    labelParking.setBounds(8,20,100 , 100);
    panelFreeParking.add(labelParking);
    */
    
    /*For TileGO
    JPanel panelGO = new JPanel();
    panelGO.setBounds(561, 561, 105, 105);
    panelGO.setBackground(Color.WHITE);
    panelGO.setBorder(border);
    panelGO.setLayout(null);
    JLabel labelGO = new JLabel();
    labelGO.setText("GO");
    labelGO.setFont(new Font("Arial",Font.BOLD,40));
    labelGO.setBounds(22,2,100 , 100);
    panelBoard.add(panelGO);
    panelGO.add(labelGO);
    */
    

    /*JPanel panel2 = new JPanel();
    panel2.setBackground(Color.BLUE);
    panel2.setBounds(640, 0, 640, 720);
    frame.add(panel2);
*/
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
            this.setBounds(a, b, 50, 105);
            this.setBackground(Color.WHITE);
            this.setBorder(border);
            this.setLayout(null);

            ImageIcon icon = imagetile.getResizedTile(path,50, 105);
            JLabel labelImage = new JLabel();
            labelImage.setIcon(icon);
            labelImage.setBounds(0, 0, this.getWidth(), this.getHeight());
            this.add(labelImage);
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
            this.setBounds(a, b, 105, 50);
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
            this.setBounds(a, b, 250, 116);
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
            this.setBounds(a, b, 280, 100);
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

