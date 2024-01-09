
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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Board extends JFrame implements ActionListener {
    
    private SaveFile saveFile;
    private List<Player> players;
    private List<Object> tiles;
    private int currentPlayerIndex;
    private Scanner keyboard;
    private Random rand;


    JButton buttonRoll = new JButton();
    JButton buttonGameRules = new JButton();
    JButton buttonBuy = new JButton();
    JButton buttonSell = new JButton();
    JButton buttonLoan = new JButton();

    String playerName1;
    String playerName2;
    String playerName3;
    String playerName4;

    int playerNum;

    public void setName(String name1, String name2, String name3, String name4){
        playerName1 = name1;
        playerName2 = name2;
        playerName3 = name3;
        playerName4 = name4;
    }
    
    
    Board() {

        keyboard = new Scanner(System.in);
        players = new ArrayList<>();
        tiles = new ArrayList<>();
        rand = new Random();

        
        
    SwingUtilities.invokeLater(() -> {

    playerNum = PlayerNumber.playerNum;
   
    
    Border border = BorderFactory.createLineBorder(Color.BLACK,1);
    this.setVisible(true); 
    this.setSize(1920,1080); 
    this.setTitle("DuitRIA"); 
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    this.setResizable(false); 
    ImageIcon image = new ImageIcon("logo.png");
    this.setIconImage(image.getImage()); 
    this.getContentPane().setBackground(new Color (1, 50, 32));
    this.setLayout(null);
    
    JPanel panelBoard = new JPanel();
//    panelBoard.setBackground(new Color(0xA3FF9B));
panelBoard.setBackground(Color.BLACK);
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
    
    //For Default Tile
    JPanel panelDefault = new JPanel();
    panelDefault.setBounds(386, 263, 228, 474);
    panelDefault.setBackground(Color.WHITE);
    JLabel labelImageDefault = new JLabel();
    labelImageDefault.setIcon(imageicon.getResizedImage("src\\duitria.current.tiles\\1 PETALING STREET.png",228,474));
    labelImageDefault.setBounds(0, 0, 228, 474);
    panelDefault.add(labelImageDefault);
    panelDefault.setBorder(border);
    panelDefault.setLayout(null);
    panelBoard.add(panelDefault);
    
    
    
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

    miniTilesLeftAndRight tile7 = new miniTilesLeftAndRight(0,766, panelBoard,"src\\duitria.tiles\\7 NATIONAL MUSEUM.png");
    miniTilesLeftAndRight tile8 = new miniTilesLeftAndRight(0,690, panelBoard,"src\\duitria.tiles\\8 TENAGA NASIONAL BERHAD.png");
    miniTilesLeftAndRight tile9 = new miniTilesLeftAndRight(0,614, panelBoard,"src\\duitria.tiles\\9 ROYAL PALACE.png");
    miniTilesLeftAndRight tile10 = new miniTilesLeftAndRight(0,538, panelBoard,"src\\duitria.tiles\\10 MERDEKA SQUARE.png");
    miniTilesLeftAndRight tile11 = new miniTilesLeftAndRight(0,462, panelBoard,"src\\duitria.tiles\\11 KLIA 2.png");
    miniTilesLeftAndRight tile12 = new miniTilesLeftAndRight(0,386, panelBoard,"src\\duitria.tiles\\12 A FAMOSA FORT.png");
    miniTilesLeftAndRight fate3 = new miniTilesLeftAndRight(0,310, panelBoard,"src\\duitria.tiles\\FATE LEFT.png");
    miniTilesLeftAndRight tile13 = new miniTilesLeftAndRight(0,234, panelBoard,"src\\duitria.tiles\\13 KELLIE CASTLE.png");
    miniTilesLeftAndRight tile14 = new miniTilesLeftAndRight(0,158, panelBoard,"src\\duitria.tiles\\14 STADTHUYS.png");
    
    miniTilesLeftAndRight tile28 = new miniTilesLeftAndRight(842,766, panelBoard,"src\\duitria.tiles\\28 SEPANG II CIRCUIT.png");
    miniTilesLeftAndRight tax2 = new miniTilesLeftAndRight(842,690, panelBoard,"src\\duitria.tiles\\TAX 2.png");
    miniTilesLeftAndRight tile27 = new miniTilesLeftAndRight(842,614, panelBoard,"src\\duitria.tiles\\27 KLCC.png");
    miniTilesLeftAndRight fate6 = new miniTilesLeftAndRight(842,538, panelBoard,"src\\duitria.tiles\\FATE RIGHT.png");
    miniTilesLeftAndRight tile26 = new miniTilesLeftAndRight(842,462, panelBoard,"src\\duitria.tiles\\26 PUDU SENTRAL STATION.png");
    miniTilesLeftAndRight tile25 = new miniTilesLeftAndRight(842,386, panelBoard,"src\\duitria.tiles\\25 SEPADAN ISLANDS.png");
    miniTilesLeftAndRight fate5 = new miniTilesLeftAndRight(842,310,panelBoard,"src\\duitria.tiles\\FATE RIGHT.png");
    miniTilesLeftAndRight tile24 = new miniTilesLeftAndRight(842,234, panelBoard,"src\\duitria.tiles\\24 PERHENTIAN ISLANDS.png");
    miniTilesLeftAndRight tile23 = new miniTilesLeftAndRight(842,158, panelBoard,"src\\duitria.tiles\\23 TIOMAN ISLANDS.png");

    
    //INITIALIZE PLAYER CARD PANEL
    playerCard playerCard1 = new playerCard(0,40,this,playerName1);
    playerCard playerCard2 = new playerCard(0,245,this,playerName2);
    playerCard playerCard3 = new playerCard(0,450,this,playerName3);
    playerCard playerCard4 = new playerCard(0,655,this,playerName4);
    
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
    playerLogHistory playerLog1 = new playerLogHistory(1500,140,this,playerName1);
    playerLogHistory playerLog2 = new playerLogHistory(1500,300,this,playerName2);
    playerLogHistory playerLog3 = new playerLogHistory(1500,460,this,playerName3);
    playerLogHistory playerLog4 = new playerLogHistory(1500,620,this,playerName1);
    playerLogHistory playerLog5 = new playerLogHistory(1500,780,this, playerName1);
    
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
    
    //Initialize Buy Button
    JPanel panelBuy = new JPanel();
    panelBuy.setBounds(700 , 375, 100,50);
    buttonBuy.setBounds(0 , 0, 100,50);
    buttonBuy.addActionListener(this);
    buttonBuy.setIcon(imageicon.getResizedImage("src\\duitria\\Icons\\BUY.png", 100, 50));
    panelBuy.setBackground(Color.WHITE);
    panelBuy.setBorder(border);
    panelBuy.setLayout(null);
    panelBuy.add(buttonBuy);
    panelBoard.add(panelBuy);
    
    //Initialize Sell Button
    JPanel panelSell = new JPanel();
    panelSell.setBounds(700 , 475, 100,50);
    buttonSell.setBounds(0 , 0, 100,50);
    buttonSell.addActionListener(this);
    buttonSell.setIcon(imageicon.getResizedImage("src\\duitria\\Icons\\SELL.png", 100, 50));
    panelSell.setBackground(Color.WHITE);
    panelSell.setBorder(border);
    panelSell.setLayout(null);
    panelSell.add(buttonSell);
    panelBoard.add(panelSell);
    
    //Initialize Loan Button
    JPanel panelLoan = new JPanel();
    panelLoan.setBounds(700 , 575, 100,50);
    buttonLoan.setBounds(0 , 0, 100,50);
    buttonLoan.addActionListener(this);
    buttonLoan.setIcon(imageicon.getResizedImage("src\\duitria\\Icons\\LOAN.png", 100, 50));
    panelLoan.setBackground(Color.WHITE);
    panelLoan.setBorder(border);
    panelLoan.setLayout(null);
    panelLoan.add(buttonLoan);
    panelBoard.add(panelLoan);
    
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

            ImageIcon icon = imageicon.getResizedImage(path,76, 158);
            JLabel labelImage = new JLabel();
            labelImage.setIcon(icon);
            labelImage.setBounds(0, 0, this.getWidth(), this.getHeight());
            this.add(labelImage);
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
            
            ImageIcon icon = imageicon.getResizedImage(path,158, 76);
            JLabel labelImage = new JLabel();
            labelImage.setIcon(icon);
            labelImage.setBounds(0, 0, this.getWidth(), this.getHeight());
            this.add(labelImage);
            panelBoard.add(this);
         });
     }
}

class playerCard extends JPanel {

    String playerName;
    double playerLand;
    double playerMoney;
    String playerStatus;

    playerCard(int a, int b, JFrame frame, String playerName, double playerLand, double playerMoney, String playerStatus) {
        
        SwingUtilities.invokeLater(() -> {

            this.playerName = playerName;
            this.playerLand = playerLand;
            this.playerMoney = playerMoney;
            this.playerStatus = playerStatus;

            Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
            this.setBackground(Color.LIGHT_GRAY);
            this.setBounds(a, b, 375, 175);
            this.setBorder(border);
            this.setLayout(null);
            frame.add(this);

            JPanel panelPlayerName = new JPanel();
            panelPlayerName.setBounds(0, 0, 375, 50); // Set bounds for the panel
            // panelPlayerName.setBorder(border); // Set a background color for visibility
            panelPlayerName.setBackground(Color.LIGHT_GRAY);
            JLabel labelPlayerName = new JLabel();
            labelPlayerName.setText(this.playerName);
            panelPlayerName.setOpaque(false);
            labelPlayerName.setBounds(10, 10, 370, 38); 
            labelPlayerName.setFont(new Font("Inter", Font.BOLD, 40));
            panelPlayerName.add(labelPlayerName);
            this.add(panelPlayerName);


            JPanel panelPlayerDescription = new JPanel();
            panelPlayerDescription.setBounds(0, 50, 375, 110); // Set bounds for the panel
            // panelPlayerDescription.setBorder(border); // Set a background color for visibility
            panelPlayerDescription.setOpaque(false);
            panelPlayerDescription.setBackground(Color.LIGHT_GRAY);
            this.add(panelPlayerDescription);
            JLabel labelPlayerMoney = new JLabel();
            JLabel labelPlayerLand = new JLabel();
            JLabel labelPlayerstatus = new JLabel();

            labelPlayerMoney.setText("Money : RM " + this.playerMoney);
            labelPlayerMoney.setBounds(5, 5, 375, 36); 
            labelPlayerMoney.setFont(new Font("Arial", Font.ITALIC, 30));
            panelPlayerDescription.add(labelPlayerMoney);

            labelPlayerLand.setText("Land : " + this.playerLand);
            labelPlayerLand.setBounds(5, 42, 375, 36); 
            labelPlayerLand.setFont(new Font("Arial", Font.ITALIC, 30));
            panelPlayerDescription.add(labelPlayerLand);

            labelPlayerstatus.setText("Status : " + this.playerStatus);
            labelPlayerstatus.setBounds(5, 79, 375, 36); 
            labelPlayerstatus.setFont(new Font("Arial", Font.ITALIC, 30));
            panelPlayerDescription.add(labelPlayerstatus);

            
        });
    }

    //Not set player money , land and status yet
    playerCard(int a, int b, JFrame frame, String playerName) {
        SwingUtilities.invokeLater(() -> {

            this.playerName = playerName;
            this.playerLand = playerLand;
            this.playerMoney = playerMoney;
            this.playerStatus = playerStatus;

            Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
            this.setBackground(Color.LIGHT_GRAY);
            this.setBounds(a, b, 375, 175);
            this.setBorder(border);
            this.setLayout(null);
            frame.add(this);

            JPanel panelPlayerName = new JPanel();
            panelPlayerName.setBounds(0, 0, 375, 50); // Set bounds for the panel
            // panelPlayerName.setBorder(border); // Set a background color for visibility
            panelPlayerName.setBackground(Color.LIGHT_GRAY);
            JLabel labelPlayerName = new JLabel();
            labelPlayerName.setText(this.playerName);
            panelPlayerName.setOpaque(false);
            labelPlayerName.setBounds(10, 10, 370, 38); 
            labelPlayerName.setFont(new Font("Inter", Font.BOLD, 35));
            panelPlayerName.add(labelPlayerName);
            this.add(panelPlayerName);


            JPanel panelPlayerDescription = new JPanel();
            panelPlayerDescription.setBounds(0, 50, 375, 110); // Set bounds for the panel
            // panelPlayerDescription.setBorder(border); // Set a background color for visibility
            panelPlayerDescription.setOpaque(false);
            panelPlayerDescription.setBackground(Color.LIGHT_GRAY);
            this.add(panelPlayerDescription);
            JLabel labelPlayerMoney = new JLabel();
            JLabel labelPlayerLand = new JLabel();
            JLabel labelPlayerstatus = new JLabel();

            labelPlayerMoney.setText("Money : RM " + this.playerMoney);
            labelPlayerMoney.setBounds(5, 5, 375, 36); 
            labelPlayerMoney.setFont(new Font("Arial", Font.ITALIC, 30));
            panelPlayerDescription.add(labelPlayerMoney);

            labelPlayerLand.setText("Land : " + this.playerLand);
            labelPlayerLand.setBounds(5, 42, 375, 36); 
            labelPlayerLand.setFont(new Font("Arial", Font.ITALIC, 30));
            panelPlayerDescription.add(labelPlayerLand);

            labelPlayerstatus.setText("Status : " + this.playerStatus);
            labelPlayerstatus.setBounds(5, 79, 375, 36); 
            labelPlayerstatus.setFont(new Font("Arial", Font.ITALIC, 30));
            panelPlayerDescription.add(labelPlayerstatus);

            
        });
    }
}




 class playerLogHistory extends JPanel{
    String playerName;
    String tileNumber;
    String playerLogHistory;
     
     playerLogHistory(int a, int b, JFrame frame, String playerName){
         SwingUtilities.invokeLater(() -> {

            this.playerName = playerName;
            this.tileNumber = "6";
            this.playerLogHistory = "Paid Rent RM 500 to Ali";

            Border border = BorderFactory.createLineBorder(Color.BLACK,1);
            this.setBackground(Color.LIGHT_GRAY);
            this.setBounds(a, b, 420, 150);
            this.setBorder(border);
            this.setLayout(null);
            frame.add(this);

             JPanel panelPlayerLogMove = new JPanel();
            panelPlayerLogMove.setBounds(0, 0, 420, 50); // Set bounds for the panel
            // panelPlayerLogMove.setBorder(border); // Set a background color for visibility
            panelPlayerLogMove.setBackground(Color.LIGHT_GRAY);
            JLabel labelPlayerMove = new JLabel();
            labelPlayerMove.setText(playerName + " Move To Tile " + tileNumber);
            panelPlayerLogMove.setOpaque(false);
            labelPlayerMove.setBounds(10, 5, 420, 40); 
            labelPlayerMove.setFont(new Font("Inter", Font.BOLD, 25));
            panelPlayerLogMove.add(labelPlayerMove);
            this.add(panelPlayerLogMove);


            JPanel panelPlayerLogDescription = new JPanel();
            panelPlayerLogDescription.setBounds(0, 50, 420, 99); // Set bounds for the panel
            // panelPlayerLogDescription.setBorder(border); // Set a background color for visibility
            panelPlayerLogDescription.setOpaque(false);
            panelPlayerLogDescription.setBackground(Color.LIGHT_GRAY);
            this.add(panelPlayerLogDescription);
            JLabel labelPlayerLogDescription = new JLabel();
            
            labelPlayerLogDescription.setText(playerLogHistory);
            labelPlayerLogDescription.setBounds(10, 5, 410, 36); 
            labelPlayerLogDescription.setFont(new Font("Arial", Font.ITALIC, 20));
            panelPlayerLogDescription.add(labelPlayerLogDescription);


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



