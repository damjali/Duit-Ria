
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

public class Board {
    public static void main(String[] args) {
        
    //Creating Frame
    Border border = BorderFactory.createLineBorder(Color.BLACK,1);
    JFrame frame = new JFrame(); //Creates a frame
    frame.setVisible(true); //make frame visible
    frame.setSize(1280,720); //set width and height
    frame.setTitle("Frame1"); //change the title
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit when close
    frame.setResizable(false); //prevents frame from being resized
    ImageIcon image = new ImageIcon("logo.png"); //create an image icon
    frame.setIconImage(image.getImage()); //set the icon image to image
    frame.getContentPane().setBackground(Color.WHITE);
    frame.setLayout(null);
    
    //frame.getContentPane().setBackground(new Color(225,0,0));
    JPanel panelBoard = new JPanel();
    panelBoard.setBackground(Color.GREEN);
    panelBoard.setBounds(640-333, 360-351, 666, 666);
    frame.add(panelBoard);
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
    
    
    miniTilesUpAndBotom tile1 = new miniTilesUpAndBotom(511,561, panelBoard);
    miniTilesUpAndBotom fate1 = new miniTilesUpAndBotom(461,561, panelBoard);
    miniTilesUpAndBotom tile2 = new miniTilesUpAndBotom(411,561, panelBoard);
    miniTilesUpAndBotom tax1 = new miniTilesUpAndBotom(361,561, panelBoard);
    miniTilesUpAndBotom tile3 = new miniTilesUpAndBotom(311,561, panelBoard);
    miniTilesUpAndBotom tile4 = new miniTilesUpAndBotom(261,561, panelBoard);
    miniTilesUpAndBotom fate2 = new miniTilesUpAndBotom(211,561, panelBoard);
    miniTilesUpAndBotom tile5 = new miniTilesUpAndBotom(161,561, panelBoard);
    miniTilesUpAndBotom tile6 = new miniTilesUpAndBotom(111,561, panelBoard);
    

    
    
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
    
}
}

 class miniTilesUpAndBotom extends JPanel{
     
     miniTilesUpAndBotom(int a, int b, JPanel panelBoard){
            Border border = BorderFactory.createLineBorder(Color.BLACK,1);
            this.setBounds(a, b, 50, 105);
            this.setBackground(Color.WHITE);
            this.setBorder(border);
            this.setLayout(null);
            panelBoard.add(this);
     }
}
