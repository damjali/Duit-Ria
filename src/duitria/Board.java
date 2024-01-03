
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
    this.getContentPane().setBackground(new Color (1, 50, 32));
    this.setLayout(null);
    
//    JPanel panelBackgroundImage = new JPanel();
//    panelBackgroundImage.setBounds(0, 0, 1920, 1080);
//    JLabel labelBackgroundImage = new JLabel();
//    labelBackgroundImage.setIcon(imageicon.getResizedImage("D:\\JAVA PROJECTS\\DuitRIA\\src\\duitria\\Icons\\ai-generative-beautiful-jungle-background-with-border-made-of-tropical-leaves-backdrop-with-copy-space-free-photo.jpg", 1920, 1080));
//    labelBackgroundImage.setBounds(0, 0, 1920, 1080);
//    panelBackgroundImage.add(labelBackgroundImage);
//    this.add(panelBackgroundImage);
//    
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
    JLabel labelImageFreeParking = new JLabel();
    labelImageFreeParking.setIcon(imageicon.getResizedImage("src\\duitria.tiles\\FREE PARKING.png",158,158));
    labelImageFreeParking.setBounds(0, 0, 158, 158);
    panelFreeParking.add(labelImageFreeParking);
    panelFreeParking.setBorder(border);
    panelFreeParking.setLayout(null);
    
    panelBoard.add(panelFreeParking);

    //For Tile GO
    JPanel panelGO = new JPanel();
    panelGO.setBounds(842, 842, 158, 158);
    panelGO.setBackground(Color.WHITE);
    panelGO.setBorder(border);
    JLabel labelImageGo = new JLabel();
    labelImageGo.setIcon(imageicon.getResizedImage("src\\duitria.tiles\\GO.png",158,158));
    labelImageGo.setBounds(0, 0, 158, 158);
    panelGO.add(labelImageGo);
    panelGO.setLayout(null);
    panelBoard.add(panelGO);
   
    //For Tile GO TO JAIL
    JPanel panelGoToJail = new JPanel();
    panelGoToJail.setBounds(842, 0, 158, 158);
    panelGoToJail.setBackground(Color.WHITE);
    JLabel labelImageGoToJail = new JLabel();
    labelImageGoToJail.setIcon(imageicon.getResizedImage("src\\duitria.tiles\\GO TO JAIL.png",158,158));
    labelImageGoToJail.setBounds(0, 0, 158, 158);
    panelGoToJail.add(labelImageGoToJail);
    panelGoToJail.setBorder(border);
    panelGoToJail.setLayout(null);
    panelBoard.add(panelGoToJail);
    
    //For Tile JAIL
    JPanel panelJail = new JPanel();
    panelJail.setBounds(0, 842, 158, 158);
    panelJail.setBackground(Color.WHITE);
    JLabel labelImageJail = new JLabel();
    labelImageJail.setIcon(imageicon.getResizedImage("src\\duitria.tiles\\JAIL.png",158,158));
    labelImageJail.setBounds(0, 0, 158, 158);
    panelJail.add(labelImageJail);
    panelJail.setBorder(border);
    panelJail.setLayout(null);
    panelBoard.add(panelJail);
    
    
    
   miniTilesUpAndBottom tile22 = new miniTilesUpAndBottom(766,0, panelBoard,"src\\duitria.tiles\\22 KINABALU NATIONAL PARK.png");
   miniTilesUpAndBottom tile21 = new miniTilesUpAndBottom(690,0, panelBoard,"src\\duitria.tiles\\21 GUNUNG MULU NATIONAL PARK.png");
   miniTilesUpAndBottom tile20 = new miniTilesUpAndBottom(614,0, panelBoard,"src\\duitria.tiles\\20 JABATAN BEKALAN AIR.png");
   miniTilesUpAndBottom tile19 = new miniTilesUpAndBottom(538,0, panelBoard,"src\\duitria.tiles\\19 PAHANG NATIONAL PARK.png");
   miniTilesUpAndBottom tile18 = new miniTilesUpAndBottom(462,0, panelBoard,"src\\duitria.tiles\\18 KL SENTRAL STATION.png");
   miniTilesUpAndBottom tile17 = new miniTilesUpAndBottom(386,0, panelBoard,"src\\duitria.tiles\\17 GENTING HIGHLAND.png");
   miniTilesUpAndBottom tile16 = new miniTilesUpAndBottom(310,0, panelBoard,"src\\duitria.tiles\\16 CAMERON HIGHLANDS.png");
   miniTilesUpAndBottom fate4 = new miniTilesUpAndBottom(234,0, panelBoard,"src\\duitria.tiles\\FATE INVERTED.png");
   miniTilesUpAndBottom tile15 = new miniTilesUpAndBottom(158,0, panelBoard,"src\\duitria.tiles\\15 FRASER'S HILL.png");
    
    miniTilesUpAndBottom tile1 = new miniTilesUpAndBottom(766,842, panelBoard,"src\\duitria.tiles\\1 PETALING STREET.png");
   miniTilesUpAndBottom fate1 = new miniTilesUpAndBottom(690,842, panelBoard,"src\\duitria.tiles\\FATE NORMAL.png");
   miniTilesUpAndBottom tile2 = new miniTilesUpAndBottom(614,842, panelBoard,"src\\duitria.tiles\\2 JONKER STREET.png");
   miniTilesUpAndBottom tax = new miniTilesUpAndBottom(538,842, panelBoard,"src\\duitria.tiles\\TAX.png");
   miniTilesUpAndBottom tile3 = new miniTilesUpAndBottom(462,842, panelBoard,"src\\duitria.tiles\\3 KLIA.png");
   miniTilesUpAndBottom tile4 = new miniTilesUpAndBottom(386,842, panelBoard,"src\\duitria.tiles\\4 MASJID JAMEK.png");
   miniTilesUpAndBottom fate2 = new miniTilesUpAndBottom(310,842, panelBoard,"src\\duitria.tiles\\FATE NORMAL.png");
   miniTilesUpAndBottom tile5 = new miniTilesUpAndBottom(234,842, panelBoard,"src\\duitria.tiles\\5 BATU CAVES.png");
   miniTilesUpAndBottom tile6 = new miniTilesUpAndBottom(158,842, panelBoard,"src\\duitria.tiles\\6 SRI MAHA MARIAMMAN TEMPLE.png");

    miniTilesLeftAndRight tile7 = new miniTilesLeftAndRight(0,766, panelBoard,"D:\\JAVA PROJECTS\\DuitRIA\\src\\duitria.tiles\\7 NATIONAL MUSEUM.png");
    miniTilesLeftAndRight tile8 = new miniTilesLeftAndRight(0,690, panelBoard,"D:\\JAVA PROJECTS\\DuitRIA\\src\\duitria.tiles\\8 TENAGA NASIONAL BERHAD.png");
    miniTilesLeftAndRight tile9 = new miniTilesLeftAndRight(0,614, panelBoard,"D:\\JAVA PROJECTS\\DuitRIA\\src\\duitria.tiles\\9 ROYAL PALACE.png");
    miniTilesLeftAndRight tile10 = new miniTilesLeftAndRight(0,538, panelBoard,"D:\\JAVA PROJECTS\\DuitRIA\\src\\duitria.tiles\\10 MERDEKA SQUARE.png");
    miniTilesLeftAndRight tile11 = new miniTilesLeftAndRight(0,462, panelBoard,"D:\\JAVA PROJECTS\\DuitRIA\\src\\duitria.tiles\\11 KLIA 2.png");
    miniTilesLeftAndRight tile12 = new miniTilesLeftAndRight(0,386, panelBoard,"D:\\JAVA PROJECTS\\DuitRIA\\src\\duitria.tiles\\12 A FAMOSA FORT.png");
    miniTilesLeftAndRight fate3 = new miniTilesLeftAndRight(0,310, panelBoard,"D:\\JAVA PROJECTS\\DuitRIA\\src\\duitria.tiles\\FATE LEFT.png");
    miniTilesLeftAndRight tile13 = new miniTilesLeftAndRight(0,234, panelBoard,"D:\\JAVA PROJECTS\\DuitRIA\\src\\duitria.tiles\\13 KELLIE CASTLE.png");
    miniTilesLeftAndRight tile14 = new miniTilesLeftAndRight(0,158, panelBoard,"D:\\JAVA PROJECTS\\DuitRIA\\src\\duitria.tiles\\14 STADTHUYS.png");
    
    miniTilesLeftAndRight tile28 = new miniTilesLeftAndRight(842,766, panelBoard,"D:\\JAVA PROJECTS\\DuitRIA\\src\\duitria.tiles\\28 SEPANG II CIRCUIT.png");
    miniTilesLeftAndRight tax2 = new miniTilesLeftAndRight(842,690, panelBoard,"D:\\JAVA PROJECTS\\DuitRIA\\src\\duitria.tiles\\TAX 2.png");
    miniTilesLeftAndRight tile27 = new miniTilesLeftAndRight(842,614, panelBoard,"D:\\JAVA PROJECTS\\DuitRIA\\src\\duitria.tiles\\27 KLCC.png");
    miniTilesLeftAndRight fate6 = new miniTilesLeftAndRight(842,538, panelBoard,"D:\\JAVA PROJECTS\\DuitRIA\\src\\duitria.tiles\\FATE RIGHT.png");
    miniTilesLeftAndRight tile26 = new miniTilesLeftAndRight(842,462, panelBoard,"D:\\JAVA PROJECTS\\DuitRIA\\src\\duitria.tiles\\26 PUDU SENTRAL STATION.png");
    miniTilesLeftAndRight tile25 = new miniTilesLeftAndRight(842,386, panelBoard,"D:\\JAVA PROJECTS\\DuitRIA\\src\\duitria.tiles\\25 SEPADAN ISLANDS.png");
    miniTilesLeftAndRight fate5 = new miniTilesLeftAndRight(842,310,panelBoard,"D:\\JAVA PROJECTS\\DuitRIA\\src\\duitria.tiles\\FATE RIGHT.png");
    miniTilesLeftAndRight tile24 = new miniTilesLeftAndRight(842,234, panelBoard,"D:\\JAVA PROJECTS\\DuitRIA\\src\\duitria.tiles\\24 PERHENTIAN ISLANDS.png");
    miniTilesLeftAndRight tile23 = new miniTilesLeftAndRight(842,158, panelBoard,"D:\\JAVA PROJECTS\\DuitRIA\\src\\duitria.tiles\\23 TIOMAN ISLANDS.png");

    
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

 class miniTilesUpAndBottom extends JPanel{ 
     
     miniTilesUpAndBottom(int a, int b, JPanel panelBoard, String path){
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

     miniTilesUpAndBottom(int a, int b, JPanel panelBoard){
         SwingUtilities.invokeLater(() -> {
            Border border = BorderFactory.createLineBorder(Color.BLACK,1);
            this.setBounds(a, b, 76, 158);
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
     
     miniTilesLeftAndRight(int a, int b, JPanel panelBoard, String path){
         SwingUtilities.invokeLater(() -> {
            Border border = BorderFactory.createLineBorder(Color.BLACK,1);
            this.setBounds(a, b, 158, 76);
            this.setBackground(Color.WHITE);
            this.setBorder(border);
            this.setLayout(null);
            
            ImageIcon icon = imagetile.getResizedTile(path,158, 76);
            JLabel labelImage = new JLabel();
            labelImage.setIcon(icon);
            labelImage.setBounds(0, 0, this.getWidth(), this.getHeight());
            this.add(labelImage);
            panelBoard.add(this);
         });
     }
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

