package duitria;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.Border;

import duitria.Board.MiniTile;

import javax.swing.BorderFactory;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Board extends JFrame implements ActionListener {
    
    public static void main(String[] args) {

        System.setProperty("sun.java2d.uiScale", "1.0");
        Board board = new Board();

    }

    JLabel diceOneImg;
    JLabel diceTwoImg;

    JButton buttonRoll = new JButton();
    JButton buttonGameRules = new JButton();
    JButton buttonBuy = new JButton();
    JButton buttonSell = new JButton();
    JButton buttonLoan = new JButton();

    String playerName1, playerName2, playerName3, playerName4;
    int playerNum;
    public List<PlayerLogHistory> playerLogs;
    public List<PlayerCard> playerCards;
    public List<Player> players;
    public List<Object> tiles;
    public int currentPlayerIndex;
    public Scanner keyboard;
    public Random rand;

    public void setName(String name1, String name2, String name3, String name4){
        playerName1 = name1;
        playerName2 = name2;
        playerName3 = name3;
        playerName4 = name4;
    }

    public void initializeTile(JPanel panelBoard, Border border) {
        // Corner Tile (bottom right)
        tiles.add(new MiniGo(842, 842, 158, 158, panelBoard, border, "src\\duitria.tiles\\GO.png", "Go", 2000000));
        // Bottom Tile
        tiles.add(new MiniTile(766, 842, 76, 158, panelBoard,"src\\duitria.tiles\\1 PETALING STREET.png", "Petaling Street",600000 ,60000 ,"Green"));
        tiles.add(new MiniFateCard(690,842, 76, 158, panelBoard,"src\\duitria.tiles\\FATE NORMAL.png", "Fate"));
        tiles.add(new MiniTile(614, 842, 76, 158, panelBoard,"src\\duitria.tiles\\2 JONKER STREET.png", "Jonker Street",600000 ,60000 ,"Green"));
        tiles.add(new MiniTax(538, 842, 76, 158, panelBoard,"src\\duitria.tiles\\TAX.png", "Tax",2000000 ));
        tiles.add(new MiniSpecialTile(462, 842, 76, 158, panelBoard,"src\\duitria.tiles\\3 KLIA.png", "KLIA",2000000 ,200000));
        tiles.add(new MiniTile(386, 842, 76, 158, panelBoard,"src\\duitria.tiles\\4 MASJID JAMEK.png", "Masjid Jamek",1000000 ,100000 ,"Blue"));
        tiles.add(new MiniFateCard(310, 842, 76, 158, panelBoard,"src\\duitria.tiles\\FATE NORMAL.png", "Fate Card"));
        tiles.add(new MiniTile(234, 842, 76, 158, panelBoard,"src\\duitria.tiles\\5 BATU CAVES.png", "Batu Caves",1000000 ,100000 ,"Blue"));
        tiles.add(new MiniTile(158, 842, 76, 158, panelBoard,"src\\duitria.tiles\\6 SRI MAHA MARIAMMAN TEMPLE.png", "Siri Maha Mariamman Temple",1200000 ,120000 ,"Blue"));
        // Corner Tile (bottom left)
        tiles.add(new MiniJail(0, 842, 158, 158, panelBoard, border, "src\\duitria.tiles\\JAIL.png", "Jail"));
        // Left Tile
        tiles.add(new MiniTile(0, 766, 158, 76, panelBoard,"src\\duitria.tiles\\7 NATIONAL MUSEUM.png", "National Museum",1400000 ,140000 ,"Maroon"));
        tiles.add(new MiniTile(0, 690, 158, 76, panelBoard,"src\\duitria.tiles\\8 TENAGA NASIONAL BERHAD.png", "Tenaga Nasional Berhad",1500000 ,150000, "No Colour"));
        tiles.add(new MiniTile(0, 614, 158, 76, panelBoard,"src\\duitria.tiles\\9 ROYAL PALACE", "Royal Palace",1400000 ,140000 ,"Maroon"));
        tiles.add(new MiniTile(0, 538, 158, 76, panelBoard,"src\\duitria.tiles\\10 MERDEKA SQUARE.png", "Merdeka Square",1400000 ,140000 ,"Maroon"));
        tiles.add(new MiniSpecialTile(0, 462, 158, 76, panelBoard,"src\\duitria.tiles\\11 KLIA 2.png", "KLIA 2",2000000 ,200000));
        tiles.add(new MiniTile(0, 386, 158, 76, panelBoard,"src\\duitria.tiles\\12 A FAMOSA RESORT.png", "A'Famosa Resort",1700000 ,170000, "Light Blue"));
        tiles.add(new MiniFateCard(0, 310, 158, 76, panelBoard,"src\\duitria.tiles\\FATE LEFT.png", "Fate Card"));
        tiles.add(new MiniTile(0, 234, 158, 76, panelBoard,"src\\duitria.tiles\\13 KELLIE CASTLE.png", "Kellie Castle",1800000 ,180000, "Light Blue"));
        tiles.add(new MiniTile(0, 158, 158, 76, panelBoard,"src\\duitria.tiles\\14 STADTHUYS.png", "Stadthuys",2000000 ,200000, "Light Blue"));
        // Corner Tile (top left)
        tiles.add(new MiniFreeParking(0, 0, 158, 158, panelBoard, border, "src\\duitria.tiles\\FREE PARKING.png", "Free Parking"));
        // Top Tile
        tiles.add(new MiniTile(158, 0, 76, 158, panelBoard,"src\\duitria.tiles\\15 FRASER'S HILL.png", "Fraser's Hill",2200000 ,220000, "Purple"));
        tiles.add(new MiniFateCard(234, 0, 76, 158, panelBoard,"src\\duitria.tiles\\FATE INVERTED.png", "Fate Card"));
        tiles.add(new MiniTile(310, 0, 76, 158, panelBoard,"src\\duitria.tiles\\16 CAMERON HIGHLANDS.png", "Cameron Highlands",2200000 ,220000, "Purple"));
        tiles.add(new MiniTile(386, 0, 76, 158, panelBoard,"src\\duitria.tiles\\17 GENTING HIGHLANDS.png", "Genting Highland",2400000 ,240000, "Purple"));
        tiles.add(new MiniSpecialTile(462, 0, 76, 158, panelBoard,"src\\duitria.tiles\\18 KL SENTRAL STATION.png", "KL Sentral Station",2000000 ,200000));
        tiles.add(new MiniTile(538, 0, 76, 158, panelBoard,"src\\duitria.tiles\\19 PAHANG NATIONAL PARK.png", "Pahang National Park",2600000 ,260000 ,"Orange"));
        tiles.add(new MiniTile(614, 0, 76, 158, panelBoard,"src\\duitria.tiles\\20 JABATAN BEKALAN AIR.png", "Jabatan Bekalan Air",2600000 ,150000, "No Colour"));
        tiles.add(new MiniTile(690, 0, 76, 158, panelBoard,"src\\duitria.tiles\\21 GUNUNG MULU NATIONAL PARK.png", "Gunung Mulu National Park",2700000 ,260000 ,"Orange"));
        tiles.add(new MiniTile(766, 0, 76, 158, panelBoard,"src\\duitria.tiles\\22 KINABALU NATIONAL PARK.png", "Kinabalu National Park", 600000 ,270000 ,"Orange"));
        // Corner Tile (top right)
        tiles.add(new MiniGoToJail(842, 0, 158, 158, panelBoard, border, "src\\duitria.tiles\\GO TO JAIL.png", "Go To Jail"));
        // Right Tile
        tiles.add(new MiniTile(842, 158, 158, 76, panelBoard,"src\\duitria.tiles\\23 TIOMAN ISLANDS.png", "Tioman Islands",3000000 ,300000 ,"Red"));
        tiles.add(new MiniTile(842, 234, 158, 76, panelBoard,"src\\duitria.tiles\\24 PERHENTIAN ISLANDS.png", "Perhentian Islands",3000000 ,300000 ,"Red"));
        tiles.add(new MiniFateCard(842, 310, 158, 76, panelBoard,"src\\duitria.tiles\\FATE RIGHT.png", "Fate Card"));
        tiles.add(new MiniTile(842, 386, 158, 76, panelBoard,"src\\duitria.tiles\\25 SEPADAN ISLANDS.png", "Sepadan Islands",3200000 ,320000 ,"Red"));
        tiles.add(new MiniSpecialTile(842, 462, 158, 76, panelBoard,"src\\duitria.tiles\\26 PUDU SENTRAL STATION.png", "Pudu Sentral Station",2000000 ,200000));
        tiles.add(new MiniFateCard(842, 538, 158, 76, panelBoard,"src\\duitria.tiles\\FATE RIGHT.png", "Fate Card"));
        tiles.add(new MiniTile(842, 614, 158, 76, panelBoard,"src\\duitria.tiles\\27 KLCC.png", "KLCC",3500000 ,350000, "Yellow"));
        tiles.add(new MiniTax(842, 690, 158, 76, panelBoard,"src\\duitria.tiles\\TAX.png", "Tax",2000000));
        tiles.add(new MiniTile(842, 766, 158, 76, panelBoard,"src\\duitria.tiles\\28 SPEANG II CIRCUIT.png", "Sepang II Circuit",4000000 ,400000, "Yellow"));
    }
    
    public void initializePlayer() {
        switch (playerNum) {
            case 2:
            players.add(new Player(playerName1));
            players.add(new Player(playerName2));
            break;
            case 3:
            players.add(new Player(playerName1));
            players.add(new Player(playerName2));
            players.add(new Player(playerName3));
            break;
            default:
            players.add(new Player(playerName1));
            players.add(new Player(playerName2));
            players.add(new Player(playerName3));
            players.add(new Player(playerName4));
        }
    }

    public void initializePlayerCard(List<Object> tiles) {
        int yCords = 40;
        for (Player player : players) {
            playerCards.add(new PlayerCard(0, yCords, this, player, tiles));
            yCords += 205;
        }
    }
    
    Board() {
    SwingUtilities.invokeLater(() -> {
        //Any declarations add here
        keyboard = new Scanner(System.in);
        players = new ArrayList<>();
        playerCards = new ArrayList<>();
        tiles = new ArrayList<>();
        rand = new Random();
        
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


    
    //OLD TILE INITIALIZATION
        /*
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
        */
        //NEW TILE INITIALIZATION
        initializeTile(panelBoard, border);
        initializePlayer();
        initializePlayerCard(tiles);

    //OLD PLAYERCARD INITIALIZATION
    //playerCard playerCard1 = new playerCard(0,40,this,playerName1);
    //playerCard playerCard2 = new playerCard(0,245,this,playerName2);
    //playerCard playerCard3 = new playerCard(0,450,this,playerName3);
    //playerCard playerCard4 = new playerCard(0,655,this,playerName4);
    
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
    PlayerLogHistory playerLog1 = new PlayerLogHistory(1500,140,this,playerName1);
    PlayerLogHistory playerLog2 = new PlayerLogHistory(1500,300,this,playerName2);
    PlayerLogHistory playerLog3 = new PlayerLogHistory(1500,460,this,playerName3);
    PlayerLogHistory playerLog4 = new PlayerLogHistory(1500,620,this,playerName1);
    PlayerLogHistory playerLog5 = new PlayerLogHistory(1500,780,this, playerName1);
    
    //Initialize Roll panel Button
    JPanel panelRoll = new JPanel();
    panelRoll.setBounds(110 , 860, 150,150);
    buttonRoll.setBounds(0 , 0, 150,150);
    buttonRoll.addActionListener(this);
    buttonRoll.setIcon(imageicon.getResizedImage("src\\duitria\\Icons\\dice.png", 150, 150));
    diceOneImg = new JLabel();
    diceTwoImg = new JLabel();

        //for dice animation
        diceOneImg = new JLabel();
        diceOneImg.setIcon(imageicon.getResizedImage("src\\duitria\\DiceIcons\\DICE1.png",100,100));
        diceOneImg.setBounds(172, 728, 100, 100);
        panelBoard.add(diceOneImg);

        diceTwoImg = new JLabel();
        diceTwoImg.setIcon(imageicon.getResizedImage("src\\duitria\\DiceIcons\\DICE1.png",100,100));
        diceTwoImg.setBounds(728, 728, 100, 100);
        panelBoard.add(diceTwoImg);
        
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
                 buttonRoll.setEnabled(false);

                // roll for 3 seconds
                long startTime = System.currentTimeMillis();
                Thread rollThread = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        long endTime = System.currentTimeMillis();
                        try{
                            
                            while((endTime - startTime)/1000F < 0.5){
                                // roll dice
                                int diceOne = rand.nextInt(1, 7);
                                int diceTwo = rand.nextInt(1, 7);
                                int sum = diceOne + diceTwo;

                                // update dice images
                                diceOneImg.setIcon(imageicon.getResizedImage("src\\duitria\\DiceIcons\\DICE" + diceOne + ".png",100,100));
                                diceTwoImg.setIcon(imageicon.getResizedImage("src\\duitria\\DiceIcons\\DICE" + diceTwo + ".png",100,100));

                               
                            
                                // sleep thread
                                Thread.sleep(60);

                                endTime = System.currentTimeMillis();
                                
                            
                                
                            }
                                                        
                            buttonRoll.setEnabled(true);
                        }
                        catch(InterruptedException e){
                            System.out.println("Threading Error: " + e);
                        }
                    
                }
                });
                rollThread.start();
        }
    
        if(e.getSource()==buttonGameRules){
           GameRules gamerules = new GameRules();
        }

        if (e.getSource() == buttonLoan){

        }

        if (e.getSource() == buttonBuy){
            
        }

        if (e.getSource() == buttonSell){
            
        }
    }
    
class CornerBoardTile extends JPanel {
    CornerBoardTile(int x, int y, int width, int height, JPanel panelBoard, Border border, String path) {
        JPanel panelCornerTile = new JPanel();
        panelCornerTile.setBounds(x, y, width, height);
        panelCornerTile.setBackground(Color.WHITE);
        JLabel labelCornerTile = new JLabel();
        labelCornerTile.setIcon(imageicon.getResizedImage(path, width, height));
        labelCornerTile.setBounds(x, y, width, height);
        panelCornerTile.add(labelCornerTile);
        panelCornerTile.setBorder(border);
        panelCornerTile.setLayout(null);
        panelBoard.add(panelCornerTile);
    }
}
class MiniGo extends CornerBoardTile {
    String name;    // go tile's name
    int payment;    // go tile's payment
    MiniGo(int x, int y, int width, int height, JPanel panelBoard, Border border, String path, String name, int payment) {
        super(x, y, width, height, panelBoard, border, path);
        this.name = name;
        this.payment = payment;
    }
}
class MiniJail extends CornerBoardTile {
    String name;    // jail tile's name
    MiniJail(int x, int y, int width, int height, JPanel panelBoard, Border border, String path, String name) {
        super(x, y, width, height, panelBoard, border, path);
        this.name = name;
    }
}
class MiniFreeParking extends CornerBoardTile {
    String name;    //free parking tile's name
    MiniFreeParking(int x, int y, int width, int height, JPanel panelBoard, Border border, String path, String name) {
        super(x, y, width, height, panelBoard, border, path);
        this.name = name;
    }
}
class MiniGoToJail extends CornerBoardTile {
    String name;    //free parking tile's name
    MiniGoToJail(int x, int y, int width, int height, JPanel panelBoard, Border border, String path, String name) {
        super(x, y, width, height, panelBoard, border, path);
        this.name = name;
    }
}
class BoardTile extends JPanel {
    BoardTile(int x, int y, int width, int height, JPanel panelBoard, String path) {
        SwingUtilities.invokeLater(() -> {
            Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
            this.setBounds(x, y, width, height);
            this.setBackground(Color.WHITE);
            this.setBorder(border);
            this.setLayout(null);

            ImageIcon icon = imageicon.getResizedImage(path, width, height);
            JLabel labelImage = new JLabel();
            labelImage.setIcon(icon);
            labelImage.setBounds(0, 0, this.getWidth(), this.getHeight());
            this.add(labelImage);
            panelBoard.add(this);
        });
    }
}
class MiniTile extends BoardTile {
    String name;        // tile's name
    int cost;           // tile's cost
    int baseRent;       // tile's base rent
    String tileColour;  // tile's colour group
    Player owner;       // tile's ownership (based on player's reference)
    int houseCost;      // tile's housecost
    int numOfHouse;     // tile's number of houses built
    MiniTile(int x, int y, int width, int height, JPanel panelBoard, String path, String name, int cost, int baseRent, String tileColour) {
        super(x, y, width, height, panelBoard, path);
        this.name = name;
        this.cost = cost;
        this.baseRent = baseRent;
        this.tileColour = tileColour;
        houseCost = 200000;
        owner = null;
        numOfHouse = 0;
    }
    public int calculateRent(Boolean doubleRent) {
        int calculatedRent = 0;
        if (doubleRent)
            calculatedRent += baseRent;
        if (numOfHouse == 0)
            calculatedRent += baseRent;
        else if (numOfHouse == 1)
            calculatedRent += (baseRent * 2);
        else if (numOfHouse >= 2 && numOfHouse <= 4)
            calculatedRent += ((baseRent * 2) + (baseRent + (200000 * (numOfHouse - 1))));
        return calculatedRent;
    }
}
class MiniSpecialTile extends BoardTile {
    String name;    // special tile's name
    int cost;       // special tile's cost
    int baseRent;   // special tile's base rent
    Player owner;   // special tile's ownership (based on player's reference)
    MiniSpecialTile(int x, int y, int width, int height, JPanel panelBoard, String path, String name, int cost, int baseRent) {
        super(x, y , width, height, panelBoard, path);
        this.name = name;
        this.cost = cost;
        this.baseRent = baseRent;
        owner = null;
    }
}
class MiniTax extends BoardTile {
    String name;    // tax's tile name
    int cost;       // tax's cost
    MiniTax(int x, int y, int width, int height, JPanel panelBoard, String path, String name, int cost) {
        super(x, y, width, height, panelBoard, path);
        this.name = name;
        this.cost = cost;
    }
}
class MiniFateCard extends BoardTile {
    String name;    // fate card's name
    MiniFateCard(int x, int y, int width, int height, JPanel panelBoard, String path, String name) {
        super(x, y, width, height, panelBoard, path);
        this.name = name;
    }
}

}

 class miniTilesUpAndBottom extends JPanel{ 

     JLabel labelTokenPlayer1 = new JLabel();
     JLabel labelHouse1 = new JLabel();
     JLabel labelHouse2 = new JLabel();
     JLabel labelHouse3 = new JLabel();
     JLabel labelHouse4 = new JLabel();
     JButton buttonTiles = new JButton();

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

            buttonTiles.setBounds(0, 0, 76, 158);
            buttonTiles.setIcon(imageicon.getResizedImage(path, 75, 158));
            this.add(buttonTiles);

            panelBoard.add(this); 
         });
     }
     

    
}

 class miniTilesLeftAndRight extends JPanel{

     JLabel labelTokenPlayer1 = new JLabel();
     JLabel labelTokenPlayer2 = new JLabel();
     JLabel labelTokenPlayer3 = new JLabel();
     JLabel labelTokenPlayer4 = new JLabel();
     JButton buttonTiles = new JButton();

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

            buttonTiles.setBounds(0, 0, 158, 76);
            buttonTiles.setIcon(imageicon.getResizedImage(path, 158, 76));
            this.add(buttonTiles);



         });
     }
}

class PlayerCard extends JPanel {

    String playerName;
    double playerLand;
    double playerMoney;
    String playerStatus;

    PlayerCard(int a, int b, JFrame frame, String playerName, double playerLand, double playerMoney, String playerStatus) {
        
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
    PlayerCard(int x, int y, JFrame frame, Player player, List<Object> tiles) {
        SwingUtilities.invokeLater(() -> {
            this.playerLand = playerLand;
            this.playerName = playerName;
            this.playerMoney = playerMoney;
            this.playerStatus = playerStatus;
            
            Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
            this.setBackground(Color.LIGHT_GRAY);
            this.setBounds(x, y, 375, 175);
            this.setBorder(border);
            this.setLayout(null);
            frame.add(this);

            JPanel panelPlayerName = new JPanel();
            panelPlayerName.setBounds(0, 0, 375, 50); // Set bounds for the panel
            // panelPlayerName.setBorder(border); // Set a background color for visibility
            panelPlayerName.setBackground(Color.LIGHT_GRAY);
            JLabel labelPlayerName = new JLabel();
            labelPlayerName.setText(player.name);
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

            labelPlayerMoney.setText("Money : RM " + player.money);
            labelPlayerMoney.setBounds(5, 5, 375, 36); 
            labelPlayerMoney.setFont(new Font("Arial", Font.ITALIC, 30));
            panelPlayerDescription.add(labelPlayerMoney);
            int propertyOwned = 0;
            for (Object currentTile : tiles) {
                if (currentTile instanceof MiniTile) {
                    MiniTile propertyTile = (MiniTile) currentTile;
                    if (propertyTile.owner == player)
                        propertyOwned++;
                }
            }
            labelPlayerLand.setText("Land : " + propertyOwned);
            labelPlayerLand.setBounds(5, 42, 375, 36); 
            labelPlayerLand.setFont(new Font("Arial", Font.ITALIC, 30));
            panelPlayerDescription.add(labelPlayerLand);

            labelPlayerstatus.setText("Status : " + (player.bankruptcy ? "Bankrupt" : "Not bankrupt"));
            labelPlayerstatus.setBounds(5, 79, 375, 36); 
            labelPlayerstatus.setFont(new Font("Arial", Font.ITALIC, 30));
            panelPlayerDescription.add(labelPlayerstatus);
            
        });
    }
}



 class PlayerLogHistory extends JPanel{
    String playerName;
    String tileNumber;
    String playerLogHistory;
     
     PlayerLogHistory(int a, int b, JFrame frame, String playerName){
         SwingUtilities.invokeLater(() -> {

            this.playerName = playerName;
            this.tileNumber = "6";
            this.playerLogHistory = "<html>Paid Rent RM 500 to Ali</html>";

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