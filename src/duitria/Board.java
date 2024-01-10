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
import java.util.Locale;
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
    public String saveFileNameChoice;
    public int sum;
    public Player currentPlayer;

    public void setName(String name1, String name2, String name3, String name4){
        playerName1 = name1;
        playerName2 = name2;
        playerName3 = name3;
        playerName4 = name4;
    }

    public void initializeTile(JPanel panelBoard) {
        // Corner Tile (bottom right)
        tiles.add(new MiniGo(842, 842, 158, 158, panelBoard, "src\\duitria.tiles\\GO.png", "Go", 2000000));
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
        tiles.add(new MiniJail(0, 842, 158, 158, panelBoard, "src\\duitria.tiles\\JAIL.png", "Jail"));
        // Left Tile
        tiles.add(new MiniTile(0, 766, 158, 76, panelBoard,"src\\duitria.tiles\\7 NATIONAL MUSEUM.png", "National Museum",1400000 ,140000 ,"Maroon"));
        tiles.add(new MiniTile(0, 690, 158, 76, panelBoard,"src\\duitria.tiles\\8 TENAGA NASIONAL BERHAD.png", "Tenaga Nasional Berhad",1500000 ,150000, "No Colour"));
        tiles.add(new MiniTile(0, 614, 158, 76, panelBoard,"src\\duitria.tiles\\9 ROYAL PALACE.png", "Royal Palace",1400000 ,140000 ,"Maroon"));
        tiles.add(new MiniTile(0, 538, 158, 76, panelBoard,"src\\duitria.tiles\\10 MERDEKA SQUARE.png", "Merdeka Square",1400000 ,140000 ,"Maroon"));
        tiles.add(new MiniSpecialTile(0, 462, 158, 76, panelBoard,"src\\duitria.tiles\\11 KLIA 2.png", "KLIA 2",2000000 ,200000));
        tiles.add(new MiniTile(0, 386, 158, 76, panelBoard,"src\\duitria.tiles\\12 A FAMOSA FORT.png", "A'Famosa Resort",1700000 ,170000, "Light Blue"));
        tiles.add(new MiniFateCard(0, 310, 158, 76, panelBoard,"src\\duitria.tiles\\FATE LEFT.png", "Fate Card"));
        tiles.add(new MiniTile(0, 234, 158, 76, panelBoard,"src\\duitria.tiles\\13 KELLIE CASTLE.png", "Kellie Castle",1800000 ,180000, "Light Blue"));
        tiles.add(new MiniTile(0, 158, 158, 76, panelBoard,"src\\duitria.tiles\\14 STADTHUYS.png", "Stadthuys",2000000 ,200000, "Light Blue"));
        // Corner Tile (top left)
        tiles.add(new MiniFreeParking(0, 0, 158, 158, panelBoard, "src\\duitria.tiles\\FREE PARKING.png", "Free Parking"));
        // Top Tile
        tiles.add(new MiniTile(158, 0, 76, 158, panelBoard,"src\\duitria.tiles\\15 FRASER'S HILL.png", "Fraser's Hill",2200000 ,220000, "Purple"));
        tiles.add(new MiniFateCard(234, 0, 76, 158, panelBoard,"src\\duitria.tiles\\FATE INVERTED.png", "Fate Card"));
        tiles.add(new MiniTile(310, 0, 76, 158, panelBoard,"src\\duitria.tiles\\16 CAMERON HIGHLANDS.png", "Cameron Highlands",2200000 ,220000, "Purple"));
        tiles.add(new MiniTile(386, 0, 76, 158, panelBoard,"src\\duitria.tiles\\17 GENTING HIGHLAND.png", "Genting Highland",2400000 ,240000, "Purple"));
        tiles.add(new MiniSpecialTile(462, 0, 76, 158, panelBoard,"src\\duitria.tiles\\18 KL SENTRAL STATION.png", "KL Sentral Station",2000000 ,200000));
        tiles.add(new MiniTile(538, 0, 76, 158, panelBoard,"src\\duitria.tiles\\19 PAHANG NATIONAL PARK.png", "Pahang National Park",2600000 ,260000 ,"Orange"));
        tiles.add(new MiniTile(614, 0, 76, 158, panelBoard,"src\\duitria.tiles\\20 JABATAN BEKALAN AIR.png", "Jabatan Bekalan Air",2600000 ,150000, "No Colour"));
        tiles.add(new MiniTile(690, 0, 76, 158, panelBoard,"src\\duitria.tiles\\21 GUNUNG MULU NATIONAL PARK.png", "Gunung Mulu National Park",2700000 ,260000 ,"Orange"));
        tiles.add(new MiniTile(766, 0, 76, 158, panelBoard,"src\\duitria.tiles\\22 KINABALU NATIONAL PARK.png", "Kinabalu National Park", 2700000 ,270000 ,"Orange"));
        // Corner Tile (top right)
        tiles.add(new MiniGoToJail(842, 0, 158, 158, panelBoard, "src\\duitria.tiles\\GO TO JAIL.png", "Go To Jail"));
        // Right Tile
        tiles.add(new MiniTile(842, 158, 158, 76, panelBoard,"src\\duitria.tiles\\23 TIOMAN ISLANDS.png", "Tioman Islands",3000000 ,300000 ,"Red"));
        tiles.add(new MiniTile(842, 234, 158, 76, panelBoard,"src\\duitria.tiles\\24 PERHENTIAN ISLANDS.png", "Perhentian Islands",3000000 ,300000 ,"Red"));
        tiles.add(new MiniFateCard(842, 310, 158, 76, panelBoard,"src\\duitria.tiles\\FATE RIGHT.png", "Fate Card"));
        tiles.add(new MiniTile(842, 386, 158, 76, panelBoard,"src\\duitria.tiles\\25 SEPADAN ISLANDS.png", "Sepadan Islands",3200000 ,320000 ,"Red"));
        tiles.add(new MiniSpecialTile(842, 462, 158, 76, panelBoard,"src\\duitria.tiles\\26 PUDU SENTRAL STATION.png", "Pudu Sentral Station",2000000 ,200000));
        tiles.add(new MiniFateCard(842, 538, 158, 76, panelBoard,"src\\duitria.tiles\\FATE RIGHT.png", "Fate Card"));
        tiles.add(new MiniTile(842, 614, 158, 76, panelBoard,"src\\duitria.tiles\\27 KLCC.png", "KLCC",3500000 ,350000, "Yellow"));
        tiles.add(new MiniTax(842, 690, 158, 76, panelBoard,"src\\duitria.tiles\\TAX 2.png", "Tax",2000000));
        tiles.add(new MiniTile(842, 766, 158, 76, panelBoard,"src\\duitria.tiles\\28 SEPANG II CIRCUIT.png", "Sepang II Circuit",4000000 ,400000, "Yellow"));
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

    private void duitriaBoard(Player player, Object currentTile, int previousPlayerPosition, int diceRoll) {
        if (previousPlayerPosition + diceRoll >= 40) {
            Go go = (Go) tiles.get(0);
            System.out.printf(Locale.US, player.name + " has passed the Go Tile. " + player.name + " has received RM%,d.\n", go.payment);
            player.money += go.payment;
            if (player.buyProperty)
                player.buyHouse = true;
            player.buyProperty = true;
        }
        if (currentTile instanceof Tile) {
            Tile propertyTile = (Tile) currentTile;
            System.out.println(player.name + " landed on " + propertyTile.name + ".");
            if (propertyTile.owner == null && !player.hasLoan) {
                if (player.buyProperty) {
                    System.out.printf(Locale.US, "Do you want to buy " + propertyTile.name + " for RM%,d? (Y/N):", propertyTile.cost);
                    String choice = keyboard.nextLine();
                    if (choice.equalsIgnoreCase("Y")) {
                        if (propertyTile.cost >= player.money) {
                            System.out.println("Not enough money to buy " + propertyTile.name + ".");
                            if (canSell(player)) {
                                System.out.printf("Do you want to sell assets to buy this land? (Y/N):");
                                String sellChoice = keyboard.nextLine();
                                if (sellChoice.equalsIgnoreCase("Y")) {
                                    sellingProperties(player, propertyTile.cost, false, false, null);
                                    if (!player.bankruptcy && propertyTile.cost < player.money) {
                                        System.out.println(player.name + " bought " + propertyTile.name + ".");
                                        player.money -= propertyTile.cost;
                                        propertyTile.owner = player;
                                    }
                                }
                            } else 
                                playerLoan(player, propertyTile.cost, false);
                        } else {
                            System.out.println(player.name + " bought " + propertyTile.name + ".");
                            player.money -= propertyTile.cost;
                            propertyTile.owner = player;
                        }
                    }
                }
            } else if (propertyTile.owner != player) {
                int colourCount = 0;
                Boolean doubleRent = false;
                for (Object otherTile : tiles) {
                    if (otherTile instanceof Tile) {
                        Tile otherPropertyTile = (Tile) otherTile;
                        if (otherPropertyTile.tileColour.equals(propertyTile.tileColour))
                            colourCount++;
                    }
                }
                switch (propertyTile.tileColour) {
                    case "Green", "Yellow":
                        if (colourCount == 2)
                            doubleRent = true;
                        break;
                    case "Blue", "Maroon", "Light Blue", "Purple", "Orange", "Red":
                        if (colourCount == 3)
                            doubleRent = true;
                        break;
                }
                int rentAmount = propertyTile.baseRent + propertyTile.calculateRent(doubleRent);
                System.out.println(propertyTile.name + " is owned by " + propertyTile.owner.name + ".");
                System.out.printf(player.name + " has to pay rent of RM%,d.\n", rentAmount);
                if (rentAmount >= player.money) {
                    System.out.println("You don't have enough money to pay the rent.");
                    sellingProperties(player, rentAmount, false, true, propertyTile.owner);
                    if (!player.bankruptcy && rentAmount < player.money) {
                        player.money -= rentAmount;
                        propertyTile.owner.money += rentAmount;
                        System.out.println(player.name + " successfully paid the rent.");
                    }
                } else {
                    player.money -= rentAmount;
                    propertyTile.owner.money += rentAmount;
                    System.out.println(player.name + " successfully paid the rent.");
                }
            } else {
                System.out.println(player.name + " is visiting his land.");
                if (player.buyHouse && !player.hasLoan) {
                    if (propertyTile.numOfHouse >= 0 && propertyTile.numOfHouse < 4) {
                        System.out.print("Do you want to buy houses for " + propertyTile.name + "? (Y/N):");
                        String choice = keyboard.nextLine();
                        if (choice.equalsIgnoreCase("Y")) {
                            boolean buyHouseCheck = true;
                            int housePrice = propertyTile.houseCost;
                            int numOfHouseCanBuy = Math.min((player.money / housePrice) - propertyTile.numOfHouse, 4);
                            System.out.println("You can buy " + numOfHouseCanBuy + " more houses.");
                            while (buyHouseCheck && player.money > propertyTile.houseCost) {
                                System.out.print("How many do you want to buy? : ");
                                int numOfHouse = keyboard.nextInt();
                                keyboard.nextLine();
                                if (numOfHouse >= 0 && numOfHouse <= numOfHouseCanBuy) {
                                    if (housePrice * numOfHouse >= player.money) {
                                        System.out.println("You don't have enough money to buy that amount of houses.");
                                        System.out.println("Please pick again.");
                                    } else {
                                        System.out.printf(Locale.US, "You bought the house for RM%,d.\n", (housePrice * numOfHouse));
                                        propertyTile.numOfHouse += numOfHouse;
                                        player.money -= housePrice * numOfHouse;
                                        buyHouseCheck = false;
                                    }
                                } else {
                                    System.out.println("Please buy in the amount of available houses.");
                                }
                            }
                        }
                    } else {
                        System.out.println("You have bought the maximum amount of houses (4).");
                    }
                }
            }
        } else if (currentTile instanceof SpecialTile) {
            SpecialTile specialTile = (SpecialTile) currentTile;
            System.out.println(player.name + " landed on " + specialTile.name + ".");
            if (specialTile.owner == null && !player.hasLoan) {
                if (player.buyProperty) {
                    System.out.printf(Locale.US, "Do you want to buy " + specialTile.name + " for RM%,d? (Y/N):", specialTile.cost);
                    String choice = keyboard.nextLine();
                    if (choice.equalsIgnoreCase("Y")) {
                        if (specialTile.cost >= player.money) {
                            System.out.println("You do not enough money to buy " + specialTile.name + ".");
                            if (canSell(player)) {
                                sellingProperties(player, specialTile.cost, false, false, null);
                                if (!player.bankruptcy && specialTile.cost < player.money) {
                                    System.out.println(player.name + " bought " + specialTile.name + ".");
                                    player.money -= specialTile.cost;
                                    specialTile.owner = player;
                                }
                            } else
                                playerLoan(player, specialTile.cost, false);
                        } else {
                            System.out.println(player.name + " bought " + specialTile.name + ".");
                            player.money -= specialTile.cost;
                            specialTile.owner = player;
                        }
                    }
                }
            } else if (specialTile.owner != player) {
                System.out.println(specialTile.name + " is owned by " + specialTile.owner.name + ".");
                System.out.printf(player.name + " has to pay rent of RM%,d.\n", specialTile.baseRent);
                if (specialTile.baseRent >= player.money) {
                    System.out.println("You don't have enough money to pay the rent.");
                    sellingProperties(player, specialTile.baseRent, false, true, specialTile.owner);
                    if (!player.bankruptcy && specialTile.baseRent < player.money) {
                        player.money -= specialTile.baseRent;
                        specialTile.owner.money += specialTile.baseRent;
                        System.out.println(player.name + " successfully paid the rent.");
                    }
                } else {
                    player.money -= specialTile.baseRent;
                    specialTile.owner.money += specialTile.baseRent;
                    System.out.println(player.name + " successfully paid the rent.");
                }
            } else {
                System.out.println(player.name + " is vitising his tile.");
            }
        } else if (currentTile instanceof FateCard) {
            FateCard fateCard = (FateCard) currentTile;
            System.out.println(player.name + " landed on the " + fateCard.name + ".");
            System.out.print(player.name + " drew a fate card: ");
            fateCardOutcome(player);
        } else if (currentTile instanceof Jail) {
            Jail jail = (Jail) currentTile;
            System.out.println(player.name + " landed on the " + jail.name + ".");
            System.out.println(player.name + " is visitng the jail.");
        } else if (currentTile instanceof Tax) {
            Tax tax = (Tax) currentTile;
            System.out.println(player.name + " landed on the " + tax.name + ".");
            System.out.printf(Locale.US, player.name + " has to pay the tax for RM%,d.\n", tax.cost);
            if (tax.cost >= player.money) {
                System.out.println("You don't have enough money to pay taxes.");
                sellingProperties(player, tax.cost, true, false, null);
                if (!player.bankruptcy && tax.cost < player.money) {
                    player.money -= tax.cost;
                    System.out.println(player.name + " successfully paid the taxes.");
                }
            } else {
                player.money -= tax.cost;
                System.out.println(player.name + " successfully paid the taxes.");
            }
        } else if (currentTile instanceof FreeParking) {
            FreeParking freeParking = (FreeParking) currentTile;
            System.out.println(player.name + " landed on the " + freeParking.name);
            System.out.println(player.name + " is resting.");
        } else if (currentTile instanceof GoToJail) {
            GoToJail goToJail = (GoToJail) currentTile;
            System.out.println(player.name + " landed on the " + goToJail.name + ".");
            System.out.println(player.name + " has to go to jail.");
            player.jailCheck = true;
            player.position = 10;
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

        //Frame Settings
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
    //panelBoard.setBackground(new Color(0xA3FF9B));
    panelBoard.setBackground(Color.BLACK);
    panelBoard.setBounds((this.getWidth()/2)-500, (this.getHeight()/2)-525, 1000, 1000);
    this.add(panelBoard);
    panelBoard.setLayout(null);
    panelBoard.setBorder(border);
    
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
        
        initializeTile(panelBoard);
        initializePlayer();
        initializePlayerCard(tiles);
        currentPlayer = players.get(0);
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
                                sum = diceOne + diceTwo;

                                // update dice images
                                diceOneImg.setIcon(imageicon.getResizedImage("src\\duitria\\DiceIcons\\DICE" + diceOne + ".png",100,100));
                                diceTwoImg.setIcon(imageicon.getResizedImage("src\\duitria\\DiceIcons\\DICE" + diceTwo + ".png",100,100));

                               
                            
                                // sleep thread
                                Thread.sleep(60);

                                endTime = System.currentTimeMillis();
                                
                            
                                
                            }
                            int previousPlayerPosition = currentPlayer.position;
                            currentPlayer.position += sum % tiles.size();
                            Object currentTile = tiles.get(currentPlayer.position);
                            duitriaBoard(currentPlayer, currentTile, previousPlayerPosition, sum);
                            buttonRoll.setEnabled(true);
                            } catch(InterruptedException e) {
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
        JButton buttonTile = new JButton();
    CornerBoardTile(int x, int y, int width, int height, JPanel panelBoard, String path) {
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


class MiniGo extends CornerBoardTile {
    String name;    // go tile's name
    int payment;    // go tile's payment
    MiniGo(int x, int y, int width, int height, JPanel panelBoard, String path, String name, int payment) {
        super(x, y, width, height, panelBoard, path);
        this.name = name;
        this.payment = payment;
    }
}
class MiniJail extends CornerBoardTile {
    String name;    // jail tile's name
    MiniJail(int x, int y, int width, int height, JPanel panelBoard, String path, String name) {
        super(x, y, width, height, panelBoard, path);
        this.name = name;
    }
}
class MiniFreeParking extends CornerBoardTile {
    String name;    //free parking tile's name
    MiniFreeParking(int x, int y, int width, int height, JPanel panelBoard, String path, String name) {
        super(x, y, width, height, panelBoard, path);
        this.name = name;
    }
}
class MiniGoToJail extends CornerBoardTile {
    String name;    //free parking tile's name
    MiniGoToJail(int x, int y, int width, int height, JPanel panelBoard, String path, String name) {
        super(x, y, width, height, panelBoard, path);
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
            panelPlayerDescription.setBounds(0, 0, 375, 110); // Set bounds for the panel
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