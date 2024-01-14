package duitria;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

import duitria.Board.MiniTile;
import duitria.SaveFile;

import javax.swing.BorderFactory;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.io.Serializable;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Board extends JFrame implements ActionListener {
    

    JLabel diceOneImg;
    JLabel diceTwoImg;

    JFrame frame;

    JLabel labelImageDefault;
    JButton buttonRoll = new JButton();
    JButton buttonGameRules = new JButton();
    JButton buttonBuyLand = new JButton();
    JButton buttonSell = new JButton();
    JButton buttonLoan = new JButton();
    JButton buttonBankrupt = new JButton();
    JButton buttonBuyHouse = new JButton();
    JButton buttonPayRent = new JButton();
    JTextArea textPrompt = new JTextArea();

    String playerName1, playerName2, playerName3, playerName4;
    int playerNum;

    List<PlayerLogHistory> playerLogs;
    List<PlayerCard> playerCards;
    List<Player> players;
    List<Object> tiles;

    ArrayList<Tokens> tokenPosition = new ArrayList<Tokens>();
    JLabel token1 = new JLabel();
    JLabel token2 = new JLabel();
    JLabel token3 = new JLabel();
    JLabel token4 = new JLabel();

    Border border = BorderFactory.createLineBorder(Color.WHITE,1);


    int currentPlayerIndex;
    int sum;
    int yCordsPlayerLog;
    int fateCardRNG;
    int birthdayMoney;
    int generalRepairTotal;
    int cost;
    boolean creatorDebt;
    boolean playerDebt;
    boolean hasPaid;
    String saveFileNameChoice;
    String toString;
    Random rand;
    Player otherPlayer;
    Player currentPlayer;
    Scanner keyboard;
    Object playerCurrentTile;
    MiniTile propertyTile;
    MiniSpecialTile specialTile;
    MiniTax tax;
    MiniFateCard fateCard;
    MiniFreeParking freeParking;
    MiniGo go;
    MiniGoToJail goToJail;
    MiniJail jail;
    SaveFile saveFile;

    public void setName(String name1, String name2, String name3, String name4){
        playerName1 = name1;
        playerName2 = name2;
        playerName3 = name3;
        playerName4 = name4;
    }

    public static void main(String[] args) {
        System.setProperty("sun.java2d.uiScale", "1.0");
        Board board = new Board();
        board.BoardDeclaration(4);
    }

    public void setSaveFileNameChoice(String saveFileNameChoice) {
        this.saveFileNameChoice = saveFileNameChoice;
    }

    Board(){
        System.out.println("Entered Board");
    }

    public void initializeTile(JPanel panelBoard) {

            // Corner Tile (bottom right)
            tiles.add(new MiniGo(842, 842, 158, 158, panelBoard, "src\\duitria.tiles\\GO.png", "Go", 2000000,"src\\duitria.current.tiles\\CURRENT SPECIAL TILES\\GO EARN 2M.png"));
            // Bottom Tile
            tiles.add(new MiniTile(766, 842, 76, 158, panelBoard,"src\\duitria.tiles\\1 PETALING STREET.png", "Petaling Street",600000 ,60000 ,"Green","src\\duitria.current.tiles\\1 PETALING STREET.png"));
            tiles.add(new MiniFateCard(690,842, 76, 158, panelBoard,"src\\duitria.tiles\\FATE NORMAL.png", "Fate","src\\duitria.tiles\\FATE NORMAL.png"));
            tiles.add(new MiniTile(614, 842, 76, 158, panelBoard,"src\\duitria.tiles\\2 JONKER STREET.png", "Jonker Street",600000 ,60000 ,"Green", "src\\duitria.current.tiles\\2 JONKER STREET.png"));
            tiles.add(new MiniTax(538, 842, 76, 158, panelBoard,"src\\duitria.tiles\\TAX.png", "Tax",2000000,"src\\duitria.current.tiles\\CURRENT SPECIAL TILES\\PAY TAX.png"));
            tiles.add(new MiniSpecialTile(462, 842, 76, 158, panelBoard,"src\\duitria.tiles\\3 KLIA.png", "KLIA",2000000 ,200000, "src\\duitria.current.tiles\\3 KLIA.png"));
            tiles.add(new MiniTile(386, 842, 76, 158, panelBoard,"src\\duitria.tiles\\4 MASJID JAMEK.png", "Masjid Jamek",1000000 ,100000 ,"Blue", "src\\duitria.current.tiles\\4 MASJID JAMEK.png"));
            tiles.add(new MiniFateCard(310, 842, 76, 158, panelBoard,"src\\duitria.tiles\\FATE NORMAL.png", "Fate Card","src\\duitria.tiles\\FATE NORMAL.png"));
            tiles.add(new MiniTile(234, 842, 76, 158, panelBoard,"src\\duitria.tiles\\5 BATU CAVES.png", "Batu Caves",1000000 ,100000 ,"Blue", "src\\duitria.current.tiles\\5 BATU CAVES.png"));
            tiles.add(new MiniTile(158, 842, 76, 158, panelBoard,"src\\duitria.tiles\\6 SRI MAHA MARIAMMAN TEMPLE.png", "Siri Maha Mariamman Temple",1200000 ,120000 ,"Blue", "src\\duitria.current.tiles\\6 SRI MAHA MARIAMMAN TEMPLE.png"));
            // Corner Tile (bottom left)
            tiles.add(new MiniJail(0, 842, 158, 158, panelBoard, "src\\duitria.tiles\\JAIL.png", "Jail","src\\duitria.current.tiles\\CURRENT SPECIAL TILES\\VISITING JAIL.png"));
            // Left Tile
            tiles.add(new MiniTile(0, 766, 158, 76, panelBoard,"src\\duitria.tiles\\7 NATIONAL MUSEUM.png", "National Museum",1400000 ,140000 ,"Maroon", "src\\duitria.current.tiles\\7 NATIONAL MUSEUM.png"));
            tiles.add(new MiniTile(0, 690, 158, 76, panelBoard,"src\\duitria.tiles\\8 TENAGA NASIONAL BERHAD.png", "Tenaga Nasional Berhad",1500000 ,150000, "No Colour", "src\\duitria.current.tiles\\8 TENAGA NASIONAL BERHAD.png"));
            tiles.add(new MiniTile(0, 614, 158, 76, panelBoard,"src\\duitria.tiles\\9 ROYAL PALACE.png", "Royal Palace",1400000 ,140000 ,"Maroon", "src\\duitria.current.tiles\\9 ROYAL PALACE.png"));
            tiles.add(new MiniTile(0, 538, 158, 76, panelBoard,"src\\duitria.tiles\\10 MERDEKA SQUARE.png", "Merdeka Square",1400000 ,140000 ,"Maroon", "src\\duitria.current.tiles\\10 MERDEKA SQUARE.png"));
            tiles.add(new MiniSpecialTile(0, 462, 158, 76, panelBoard,"src\\duitria.tiles\\11 KLIA 2.png", "KLIA 2",2000000 ,200000, "src\\duitria.current.tiles\\11 KLIA 2.png"));
            tiles.add(new MiniTile(0, 386, 158, 76, panelBoard,"src\\duitria.tiles\\12 A FAMOSA FORT.png", "A'Famosa Resort",1700000 ,170000, "Light Blue", "src\\duitria.current.tiles\\12 A FAMOSA FORT.png"));
            tiles.add(new MiniFateCard(0, 310, 158, 76, panelBoard,"src\\duitria.tiles\\FATE LEFT.png", "Fate Card","src\\duitria.tiles\\FATE NORMAL.png"));
            tiles.add(new MiniTile(0, 234, 158, 76, panelBoard,"src\\duitria.tiles\\13 KELLIE CASTLE.png", "Kellie Castle",1800000 ,180000, "Light Blue", "src\\duitria.current.tiles\\13 KELLIE CASTLE.png"));
            tiles.add(new MiniTile(0, 158, 158, 76, panelBoard,"src\\duitria.tiles\\14 STADTHUYS.png", "Stadthuys",2000000 ,200000, "Light Blue", "src\\duitria.current.tiles\\14 STADTHUYS.png"));
            // Corner Tile (top left)
            tiles.add(new MiniFreeParking(0, 0, 158, 158, panelBoard, "src\\duitria.tiles\\FREE PARKING.png", "Free Parking","src\\duitria.current.tiles\\CURRENT SPECIAL TILES\\FREE PARKING.png"));
            // Top Tile
            tiles.add(new MiniTile(158, 0, 76, 158, panelBoard,"src\\duitria.tiles\\15 FRASER'S HILL.png", "Fraser's Hill",2200000 ,220000, "Purple", "src\\duitria.current.tiles\\15 FRASER'S HILL.png"));
            tiles.add(new MiniFateCard(234, 0, 76, 158, panelBoard,"src\\duitria.tiles\\FATE INVERTED.png", "Fate Card","src\\duitria.tiles\\FATE NORMAL.png"));
            tiles.add(new MiniTile(310, 0, 76, 158, panelBoard,"src\\duitria.tiles\\16 CAMERON HIGHLANDS.png", "Cameron Highlands",2200000 ,220000, "Purple", "src\\duitria.current.tiles\\16 CAMERON HIGHLANDS.png"));
            tiles.add(new MiniTile(386, 0, 76, 158, panelBoard,"src\\duitria.tiles\\17 GENTING HIGHLAND.png", "Genting Highland",2400000 ,240000, "Purple", "src\\duitria.current.tiles\\17 GENTING HIGHLAND.png"));
            tiles.add(new MiniSpecialTile(462, 0, 76, 158, panelBoard,"src\\duitria.tiles\\18 KL SENTRAL STATION.png", "KL Sentral Station",2000000 ,200000, "src\\duitria.current.tiles\\18 KL SENTRAL STATION.png"));
            tiles.add(new MiniTile(538, 0, 76, 158, panelBoard,"src\\duitria.tiles\\19 PAHANG NATIONAL PARK.png", "Pahang National Park",2600000 ,260000 ,"Orange", "src\\duitria.current.tiles\\19 PAHANG NATIONAL PARK.png"));
            tiles.add(new MiniTile(614, 0, 76, 158, panelBoard,"src\\duitria.tiles\\20 JABATAN BEKALAN AIR.png", "Jabatan Bekalan Air",2600000 ,150000, "No Colour", "src\\duitria.current.tiles\\20 JABATAN BEKALAN AIR.png"));
            tiles.add(new MiniTile(690, 0, 76, 158, panelBoard,"src\\duitria.tiles\\21 GUNUNG MULU NATIONAL PARK.png", "Gunung Mulu National Park",2700000 ,260000 ,"Orange", "src\\duitria.current.tiles\\21 GUNUNG MULU NATIONAL PARK.png"));
            tiles.add(new MiniTile(766, 0, 76, 158, panelBoard,"src\\duitria.tiles\\22 KINABALU NATIONAL PARK.png", "Kinabalu National Park", 2700000 ,270000 ,"Orange", "src\\duitria.current.tiles\\22 KINABALU NATIONAL PARK.png"));
            // Corner Tile (top right)
            tiles.add(new MiniGoToJail(842, 0, 158, 158, panelBoard, "src\\duitria.tiles\\GO TO JAIL.png", "Go To Jail","src\\duitria.current.tiles\\CURRENT SPECIAL TILES\\GO TO JAIL.png"));
            // Right Tile
            tiles.add(new MiniTile(842, 158, 158, 76, panelBoard,"src\\duitria.tiles\\23 TIOMAN ISLANDS.png", "Tioman Islands",3000000 ,300000 ,"Red", "src\\duitria.current.tiles\\23 TIOMAN ISLANDS.png"));
            tiles.add(new MiniTile(842, 234, 158, 76, panelBoard,"src\\duitria.tiles\\24 PERHENTIAN ISLANDS.png", "Perhentian Islands",3000000 ,300000 ,"Red", "src\\duitria.current.tiles\\24 PERHENTIAN ISLANDS.png"));
            tiles.add(new MiniFateCard(842, 310, 158, 76, panelBoard,"src\\duitria.tiles\\FATE RIGHT.png", "Fate Card","src\\duitria.tiles\\FATE NORMAL.png"));
            tiles.add(new MiniTile(842, 386, 158, 76, panelBoard,"src\\duitria.tiles\\25 SEPADAN ISLANDS.png", "Sepadan Islands",3200000 ,320000 ,"Red", "src\\duitria.current.tiles\\25 SEPADAN ISLANDS.png"));
            tiles.add(new MiniSpecialTile(842, 462, 158, 76, panelBoard,"src\\duitria.tiles\\26 PUDU SENTRAL STATION.png", "Pudu Sentral Station",2000000 ,200000, "src\\duitria.current.tiles\\26 PUDU SENTRAL STATION.png"));
            tiles.add(new MiniFateCard(842, 538, 158, 76, panelBoard,"src\\duitria.tiles\\FATE RIGHT.png", "Fate Card","src\\duitria.tiles\\FATE NORMAL.png"));
            tiles.add(new MiniTile(842, 614, 158, 76, panelBoard,"src\\duitria.tiles\\27 KLCC.png", "KLCC",3500000 ,350000, "Yellow", "src\\duitria.current.tiles\\27 KLCC.png"));
            tiles.add(new MiniTax(842, 690, 158, 76, panelBoard,"src\\duitria.tiles\\TAX 2.png", "Tax",2000000,"src\\duitria.current.tiles\\CURRENT SPECIAL TILES\\PAY TAX.png"));
            tiles.add(new MiniTile(842, 766, 158, 76, panelBoard,"src\\duitria.tiles\\28 SEPANG II CIRCUIT.png", "Sepang II Circuit",4000000 ,400000, "Yellow", "src\\duitria.current.tiles\\28 SEPANG II CIRCUIT.png"));

            token1.setBounds(880, 930, 30, 30);
            token1.setIcon(imageicon.getResizedImage("src\\SMALL TOKENS\\SMALL DORAEMON NORMAL.png", 30, 30));
            panelBoard.add(token1);

            token2.setBounds(920, 930, 30, 30);
            token2.setIcon(imageicon.getResizedImage("src\\SMALL TOKENS\\SMALL LUFFY NORMAL.png", 30, 30));
            panelBoard.add(token2);

            token3.setBounds(880, 965, 30, 30);
            token3.setIcon(imageicon.getResizedImage("src\\SMALL TOKENS\\SMALL MARIO NORMAL.png", 30, 30));
            panelBoard.add(token3);

            token4.setBounds(920, 965, 30, 30);
            token4.setIcon(imageicon.getResizedImage("src\\SMALL TOKENS\\SMALL POKEBALL NORMAL.png", 30, 30));
            panelBoard.add(token4);

            revalidate();

    }
    
    public void initializeTokenPosition(){
        SwingUtilities.invokeLater(() -> {
            tokenPosition.add(new Tokens(880,930,920,930,880,965,920,965));
            tokenPosition.add(new Tokens(880,930,920,930,880,965,920,965));
            tokenPosition.add(new Tokens(880,930,920,930,880,965,920,965));
        });
    }


    public void initializePlayer() {
        SwingUtilities.invokeLater(() -> {
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
        });
    }


    public void initializePlayerCard() {
        SwingUtilities.invokeLater(() -> {
            int yCords = 40;
            for (Player player : players) {
                playerCards.add(new PlayerCard(0, yCords, this, player, tiles));
                yCords += 205;
            }
            revalidate();
        });
    }

    public void playerLogHistory(Player player) {
        SwingUtilities.invokeLater(() -> {
            System.out.println("Bruh Moment");
            playerLogs.add(0, new PlayerLogHistory(1500, yCordsPlayerLog, this, player));
    
            // Update yCordsPlayerLog for each existing log
            int yOffset = 160;
            for (int i = 1; i < playerLogs.size(); i++) {
                playerLogs.get(i).setBounds(1500, yCordsPlayerLog + (i * yOffset), 420, 150);
            }
    
            // Remove the last element if the size exceeds a limit
            int limit = 10;
            if (playerLogs.size() > limit) {
                playerLogs.remove(limit);
            }
    
            // Repaint or revalidate your container
            revalidate();
        });
    }
    
    
    

    public void duitriaBoard(Player player, Object currentTile, int previousPlayerPosition, int diceRoll) {
        SwingUtilities.invokeLater(() -> {
            toString = "";

            if (previousPlayerPosition + diceRoll >= 40) {
                go = (MiniGo) tiles.get(0);
                toString += String.format(player.name + " has passed the Go Tile.\n" + player.name + " has received RM%,d.\n", go.payment);
                System.out.printf(Locale.US, player.name + " has passed the Go Tile. " + player.name + " has received RM%,d.\n", go.payment);
                player.money += go.payment;
                if (player.buyProperty)
                    player.buyHouse = true;
                player.buyProperty = true;
            }
            if (currentTile instanceof MiniTile) {
                playerCurrentTile = currentTile;
                propertyTile = (MiniTile) currentTile;
                System.out.println(player.name + " landed on " + propertyTile.name + ".");
                toString += player.name + " landed on " + propertyTile.name + ".\n";
                System.out.println(toString);
                if (propertyTile.owner == null && !player.hasLoan) { // BUY PROPERTY
                    if (player.buyProperty) {
                        buttonBuyLand.setEnabled(true);
                        buttonRoll.setEnabled(true);
                    }
                } else if (propertyTile.owner != player && propertyTile.owner != null) { // PAY RENT
                    int colourCount = 0;
                    Boolean doubleRent = false;
                    for (Object otherTile : tiles) {
                        if (otherTile instanceof MiniTile) {
                            MiniTile otherPropertyTile = (MiniTile) otherTile;
                            if (otherPropertyTile.owner == propertyTile.owner && otherPropertyTile.tileColour.equals(propertyTile.tileColour))
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
                    propertyTile.rentAmount = propertyTile.baseRent + propertyTile.calculateRent(doubleRent);
                    System.out.println(propertyTile.name + " is owned by " + propertyTile.owner.name + ".");
                    System.out.printf(player.name + " has to pay rent of RM%,d.\n", propertyTile.rentAmount);
                    if (propertyTile.rentAmount >= player.money) {
                        buttonSell.setEnabled(true);
                        System.out.println("You don't have enough money to pay the rent.");
                    } else {
                        buttonRoll.setEnabled(true);
                        player.money -= propertyTile.rentAmount;
                        propertyTile.owner.money += propertyTile.rentAmount;
                        toString += String.format(player.name + " paid RM%,d to " + propertyTile.owner.name + ".\n", propertyTile.rentAmount);
                        System.out.println(player.name + " successfully paid the rent.");
                        buttonRoll.setEnabled(true);
                    }
                } else { // VISIT PLAYER'S LAND (BUY HOUSE)
                    System.out.println(player.name + " is visiting his land.");
                    if (player.buyHouse && !player.hasLoan) {
                        buttonBuyHouse.setEnabled(true);
                        buttonRoll.setEnabled(true);
                        if (propertyTile.numOfHouse >= 0 && propertyTile.numOfHouse < 4 && player.money > 200000) { // PUT BUTTON BUY HOUSE
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
                                            propertyTile.numOfHouse += numOfHouse;
                                            player.money -= housePrice * numOfHouse;
                                            buyHouseCheck = false;
                                            toString += String.format(player.name + " bought " + numOfHouse + " house(s).\n");
                                            System.out.printf(Locale.US, "You bought the house for RM%,d.\n", (housePrice * numOfHouse));
                                        }
                                    } else {
                                        System.out.println("Please buy in the amount of available houses.");
                                    }
                                }
                            }
                        } else {
                            System.out.println("You have already bought the maximum amount of houses (4).");
                        }
                    }
                    buttonRoll.setEnabled(true);
                }
            } else if (currentTile instanceof MiniSpecialTile) {
                playerCurrentTile = currentTile;
                specialTile = (MiniSpecialTile) currentTile;
                System.out.println(player.name + " landed on " + specialTile.name + ".");
                toString += player.name + " landed on " + specialTile.name + ".\n";
                if (specialTile.owner == null && !player.hasLoan) { // BUY LAND
                    if (player.buyProperty) {
                        buttonBuyLand.setEnabled(true);
                        buttonRoll.setEnabled(true);
                    }
                } else if (specialTile.owner != player && specialTile.owner != null) {
                    System.out.println(specialTile.name + " is owned by " + specialTile.owner.name + ".");
                    System.out.printf(player.name + " has to pay rent of RM%,d.\n", specialTile.baseRent);
                    if (specialTile.baseRent >= player.money) {
                        buttonSell.setEnabled(true);
                    } else {
                        player.money -= specialTile.baseRent;
                        specialTile.owner.money += specialTile.baseRent;
                        toString += String.format(player.name + " paid RM%,d to " + specialTile.owner.name + ".\n", specialTile.baseRent);
                        System.out.println(player.name + " successfully paid the rent.");
                        buttonRoll.setEnabled(true);
                    }
                } else {
                    toString += player.name + " landed on " + specialTile.name + ".\n";
                    System.out.println(player.name + " is vitising his tile.");
                    buttonRoll.setEnabled(true);
                }
            } else if (currentTile instanceof MiniFateCard) {
                fateCard = (MiniFateCard) currentTile;
                System.out.println(player.name + " landed on the " + fateCard.name + ".");
                System.out.print(player.name + " drew a fate card: ");
                toString += player.name + " landed on " + fateCard.name + ": ";
                fateCardOutcome(player);
            } else if (currentTile instanceof MiniJail) {
                jail = (MiniJail) currentTile;
                System.out.println(player.name + " landed on the " + jail.name + ".");
                System.out.println(player.name + " is visitng the jail.");
                toString += player.name + " landed on " + jail.name + ".\n";
                buttonRoll.setEnabled(true);
            } else if (currentTile instanceof MiniTax) {
                tax = (MiniTax) currentTile;
                System.out.println(player.name + " landed on the " + tax.name + ".");
                toString += player.name + " landed on " + tax.name + ".\n";
                System.out.printf(Locale.US, player.name + " has to pay the tax for RM%,d.\n", tax.cost);
                if (tax.cost >= player.money) {
                    buttonSell.setEnabled(true);
                    System.out.println("You don't have enough money to pay taxes.");
                } else {
                    player.money -= tax.cost;
                    System.out.println(player.name + " successfully paid the taxes.");
                    toString += String.format(player.name + " has paid RM%,d to the Creator.\n", tax.cost);
                    buttonRoll.setEnabled(true);
                }
            } else if (currentTile instanceof MiniFreeParking) {
                freeParking = (MiniFreeParking) currentTile;
                System.out.println(player.name + " landed on the " + freeParking.name);
                System.out.println(player.name + " is resting.");
                toString += player.name + " landed on " + freeParking.name + ".\n";
                buttonRoll.setEnabled(true);
            } else if (currentTile instanceof MiniGoToJail) {
                goToJail = (MiniGoToJail) currentTile;
                System.out.println(player.name + " landed on the " + goToJail.name + ".");
                System.out.println(player.name + " has to go to jail.");
                toString += player.name + " landed on " + goToJail.name + ".\n";
                toString += player.name + " has entered the jail.\n";
                player.jailCheck = true;
                player.position = 10;
                buttonRoll.setEnabled(true);
            }
            player.toString = toString;
        });
    }

    public void fateCardOutcome(Player player) {
        fateCardRNG = rand.nextInt(10);
        switch(fateCardRNG) {
            case 0:
            System.out.println("Advance to Go and collect RM2,000,000.");
            toString += "\"Advance to Go\" card.\n";
            player.position = 0;
            player.money += 2000000;
            if (player.buyProperty)
                player.buyHouse = true;
            player.buyProperty = true;
            buttonRoll.setEnabled(true);
            break;
            case 1:
            System.out.println("Advance to the nearest railroad."); //add buy option for the railroads
            toString += "\"Advance to the nearest railroad\" card.\n";
            int nearestRailroad1 = player.position - 25;
            int nearestRailroad2 = player.position - 35;
            if (Math.abs(nearestRailroad1) < Math.abs(nearestRailroad2)) {
                player.position = 25;
                Object currentTile = tiles.get(player.position);
                fateCardRailRoad(player, currentTile);
            } else {
                player.position = 35;
                Object currentTile = tiles.get(player.position);
                fateCardRailRoad(player, currentTile);
            }
            break;
            case 2:
            System.out.println("It is your birthday! Collect RM100,000 from everyone.");
            toString += "\"It's Your Birthday\" card.\n";
            birthdayMoney = 0;
            for (Player otherPlayer : players) {
                if (!otherPlayer.equals(player)) {
                    if (100000 >= otherPlayer.money) {
                        buttonSell.setEnabled(true);
                        System.out.println(otherPlayer.name + " doesn't have enough to give birthday money.");
                    }
                    if (!otherPlayer.bankruptcy) {
                        otherPlayer.money -= 100000;
                        birthdayMoney += 100000;
                    }
                }
            }
            player.money += birthdayMoney;
            System.out.printf(player.name + " collected RM%,d from everyone.\n", birthdayMoney);
            toString += String.format(player.name + " collected RM%,d from everyone.\n", birthdayMoney);
            buttonRoll.setEnabled(true);
            break;
            case 3:
            System.out.println("Bank error in your favor, Collect RM2,000,000.");
            toString += "\"Bank Error\" card.\n";
            player.money += 2000000;
            buttonRoll.setEnabled(true);
            break;
            case 4:
            System.out.println("Go back 3 spaces.");
            toString += "\"Go Back 3 Spaces\" card.\n";
            player.position -= 3;
            buttonRoll.setEnabled(true);
            break;
            case 5:
            System.out.println("Go to Jail.");
            toString += "\"Go To Jail\" card.\n";
            player.position = 10;
            player.jailCheck = true;
            buttonRoll.setEnabled(true);
            break;
            case 6:
            System.out.println("Make general repair on all your property, RM200,000 for each house.");
            toString = "\"Make General Repair\" card.\n";
            generalRepairTotal = 0;
            for (Object currentTile : tiles) {
                if (currentTile instanceof MiniTile) {
                    MiniTile currentPropertyTile = (MiniTile) currentTile;
                    if (currentPropertyTile.owner == player) {
                        generalRepairTotal += (currentPropertyTile.numOfHouse * 200000);
                        System.out.printf(Locale.US, currentPropertyTile.name + " costs RM%,d.\n", (currentPropertyTile.numOfHouse * 200000));
                    }
                }
            }
            if (generalRepairTotal == 0) {
                buttonRoll.setEnabled(true);
                break;
            }
            System.out.printf(Locale.US, player.name + " the total for the repair is RM%,d.\n", generalRepairTotal);
            if (generalRepairTotal >= player.money) {
                buttonSell.setEnabled(true);
                System.out.println("You don't have enough money to pay the repair on the houses.");
            } else {
                player.money -= generalRepairTotal;
                System.out.printf(Locale.US, player.name + " successfully paid RM%,d.\n", generalRepairTotal);
                toString += String.format(player.name + " has paid RM%,d to the Creator.\n", generalRepairTotal);
            }
            buttonRoll.setEnabled(true);
            break;
            case 7:
            System.out.println("Pay hospital fees of RM250,000.");
            toString += "\"Pay Hospital Fees\" card.\n";
            if (250000 >= player.money) {
                buttonSell.setEnabled(true);
                System.out.println("You don't have enough money to pay the hospital fees.");
            } else {
                player.money -= 250000;
                System.out.println(player.name + " successfully paid the hospital fees.");
                toString += player.name + " has paid RM250,000 to the Creator.\n";
                buttonRoll.setEnabled(true);
            }
            break;
            case 8:
            System.out.println("Pay school fees of RM100,000.");
            toString += "\"Pay School Fees\" card.\n";
            if (100000 >= player.money) {
                buttonSell.setEnabled(true);
                System.out.println("You don't have enough money to pay the school fees.");
            } else {
                player.money -= 100000;
                System.out.println(player.name + " successfully paid the school fees.");
                toString += player.name + " has paid RM100,000 to the Creator.\n";
                buttonRoll.setEnabled(true);
            }
            break;
            case 9:
            System.out.println("Pay speeding fine of RM100,000.");
            toString += "\"Pay Speeding Fine\" card.\n";
            if (100000 >= player.money) {
                buttonSell.setEnabled(true);
                System.out.println("You don't have enough money to pay the speeding fine.");
            } else {
                player.money -= 100000;
                System.out.println(player.name + " successfully paid the speeding fine.");
                toString += player.name + " has paid RM100,000 to the Creator.\n";
                buttonRoll.setEnabled(true);
            }
            break;
            default:
            fateCardOutcome(player);
        }
        player.toString = toString;
    }

    public void fateCardRailRoad(Player player, Object currentTile) {
        SwingUtilities.invokeLater(() -> {
            specialTile = (MiniSpecialTile) currentTile;
            System.out.println(player.name + " landed on " + specialTile.name);
            toString += player.name + " landed on " + specialTile.name + ".\n";
            if (player.buyProperty) {
                if (specialTile.owner == null && !player.hasLoan) {
                    buttonBuyLand.setEnabled(true);
                    buttonRoll.setEnabled(true);
                    System.out.printf(Locale.US, "Do you want to buy " + specialTile.name + " for RM%,d? (Y/N):", specialTile.cost);
                } else if (specialTile.owner != player) {
                    System.out.println(specialTile.name + " is owned by " + specialTile.owner.name + ".");
                    System.out.printf(player.name + " has to pay double of rent for RM%,d.\n", (specialTile.baseRent * 2));
                    specialTile.rentAmount = specialTile.baseRent * 2;
                    if ((specialTile.baseRent * 2) >= player.money) {
                        buttonSell.setEnabled(true);
                        System.out.println("You don't have enough money to pay the rent.");
                    } else {
                        player.money -= specialTile.rentAmount;
                        specialTile.owner.money += specialTile.rentAmount;
                        System.out.println(player.name + " successfully paid the rent.");
                        toString += player.name + " has paid RM%,d to " + specialTile.owner.name + ".\n";
                        buttonRoll.setEnabled(true);
                    }
                } else if (specialTile.owner == player) {
                    System.out.println(player.name + " is vitising his tile.");
                    buttonRoll.setEnabled(true);
                }
            }
            player.toString = toString;
        });
    }
    public boolean canSell(Player player) {
        int tileCount = 0, houseCount = 0, specialTileCount = 0;
        for (Object currentTile : tiles) {
            if (currentTile instanceof MiniTile) {
                MiniTile currentPropertyTile = (MiniTile) currentTile;
                if (currentPropertyTile.owner == player) {
                    tileCount++;
                    houseCount += currentPropertyTile.numOfHouse;
                }
            }
            if (currentTile instanceof MiniSpecialTile) {
                MiniSpecialTile currentSpecialTile = (MiniSpecialTile) currentTile;
                if (currentSpecialTile.owner == player) {
                    specialTileCount++;
                }
            }
        }
        if (tileCount > 0 || specialTileCount > 0 || houseCount > 0)
            return true;
        else
            return false;
    }

    public void sellingProperties(Player player, int cost, boolean creatorDebt, boolean playerDebt, Player tileOwner) {
        List<MiniTile> propertySelector = new ArrayList<>();
        List<MiniSpecialTile> specialTileSelector = new ArrayList<>();
        FrameSellHouse frameSellHouse;
        FrameSellLand frameSellLand;
        player.propertySellCheck = true;
        hasPaid = false;
        this.creatorDebt = creatorDebt;
        this.playerDebt = playerDebt;
        this.cost = cost;
        int tileCount, houseCount, specialTileCount, tileCost, specialTileCost;
        if (creatorDebt) {
            for (Object currentTile : tiles) {
                if (currentTile instanceof MiniTile) {
                    MiniTile currentPropertyTile = (MiniTile) currentTile;
                    if (currentPropertyTile.owner == player) {
                        currentPropertyTile.numOfHouse = 0;
                        currentPropertyTile.owner = null;
                        System.out.println(player.name + " has given up " + currentPropertyTile.name + " to the Creator.");
                    }
                }
                if (currentTile instanceof MiniSpecialTile) {
                    MiniSpecialTile currentSpecialTile = (MiniSpecialTile) currentTile;
                    if (currentSpecialTile.owner == player) {
                        currentSpecialTile.owner = null;
                        System.out.println(player.name + " has given up " + currentSpecialTile.name + " to the Creator.");
                    }
                }
            }
            System.out.println("You can make a loan to not get kicked out from the game.");
            toString += player.name + " has given up all their assets to the Creator.\n";
            buttonLoan.setEnabled(true);
        }
        if (player.propertySellCheck) { // INTEGRATE SELL HOUSE PANEL
            tileCount = 0;
            houseCount = 0;
            tileCost = 0;
            specialTileCount = 0;
            specialTileCost = 0;
            for (Object currentTile : tiles) {
                if (currentTile instanceof MiniTile) {
                    MiniTile currentPropertyTile = (MiniTile) currentTile;
                    if (currentPropertyTile.owner == player) {
                        tileCount++;
                        tileCost += currentPropertyTile.cost;
                        houseCount += currentPropertyTile.numOfHouse;
                        propertySelector.add(currentPropertyTile);
                    }
                }
                if (currentTile instanceof MiniSpecialTile) {
                    MiniSpecialTile currentSpecialTile = (MiniSpecialTile) currentTile;
                    if (currentSpecialTile.owner == player) {
                        specialTileCount++;
                        specialTileCost += currentSpecialTile.cost;
                        specialTileSelector.add(specialTile);
                    }
                }
            }
            while (houseCount > 0 && cost >= player.money && playerDebt) { // HOUSE SELL TO PAY RENT
                frameSellHouse = new FrameSellHouse(propertySelector, player, true, false);
                while (frameSellHouse.landNumber < 0 || frameSellHouse.landNumber >= propertySelector.size() || frameSellHouse.houseNumber < 0 || frameSellHouse.houseNumber > propertySelector.get(frameSellHouse.landNumber).numOfHouse) {
                    frameSellHouse = new FrameSellHouse(propertySelector, player, true, false);
                }
                int totalHouseSold = 0;
                player.money += 100000 * frameSellHouse.houseNumber;
                propertySelector.get(frameSellHouse.landNumber).numOfHouse -= frameSellHouse.houseNumber;
                frameSellHouse.totalHouseCount -= frameSellHouse.houseNumber;
                totalHouseSold += frameSellHouse.houseNumber;
                if (cost < player.money) {
                    player.money -= cost;
                    cost = 0;
                    player.propertySellCheck = false;
                    hasPaid = true;
                    toString += player.name + " has sold " + totalHouseSold + " house(s).\n";
                    if (playerCurrentTile instanceof MiniTile) {
                        propertyTile = (MiniTile) playerCurrentTile;
                        toString += String.format(player.name + " has paid RM%,d rent to " + tileOwner.name + ".\n", propertyTile.rentAmount);
                    } else if (playerCurrentTile instanceof MiniSpecialTile) {
                        specialTile = (MiniSpecialTile) playerCurrentTile;
                        toString += String.format(player.name + " has paid RM%,d rent to " + tileOwner.name + ".\n", specialTile.rentAmount);
                    }
                    buttonRoll.setEnabled(true);
                    break;
                }
                if (frameSellHouse.totalHouseCount <= 0) { // GIVE UP ASSETS TO OWNER
                    for (MiniTile propertyTile : propertySelector) {
                        propertyTile.owner = tileOwner;
                    }
                    for (MiniSpecialTile specialTile : specialTileSelector) {
                        specialTile.owner = tileOwner;
                    }
                    toString += player.name + " has given all his assets to " + tileOwner.name + ".\n";
                    buttonLoan.setEnabled(true);
                    break;
                }
            }
            while (houseCount > 0 && cost >= player.money && !playerDebt) { // HOUSE SELL TO BUY PROPERTIES
                frameSellHouse = new FrameSellHouse(propertySelector, player, false, false);
                while (frameSellHouse.landNumber < 0 || frameSellHouse.landNumber > propertySelector.size() || frameSellHouse.houseNumber < 0 || frameSellHouse.houseNumber > propertySelector.get(frameSellHouse.landNumber).numOfHouse) {
                    frameSellHouse = new FrameSellHouse(propertySelector, player, false, false);
                }
                int totalHouseSold = 0;
                player.money += 100000 * frameSellHouse.houseNumber;
                propertySelector.get(frameSellHouse.landNumber).numOfHouse -= frameSellHouse.houseNumber;
                frameSellHouse.totalHouseCount -= frameSellHouse.houseNumber;
                totalHouseSold += frameSellHouse.houseNumber;
                if (cost < player.money) {
                    player.money -= cost;
                    cost = 0;
                    player.propertySellCheck = false;
                    hasPaid = true;
                    toString += player.name + " has sold " + totalHouseSold + " house(s).\n";
                    buttonBuyLand.setEnabled(true);
                    buttonRoll.setEnabled(true);
                    break;
                }
            }
            while (tileCount > 0 && cost >= player.money && !playerDebt) { // TILE SELL TO BUY PROPERTIES
                frameSellLand = new FrameSellLand(propertySelector, specialTileSelector, player, false, false);
                while (frameSellLand.landNumber < 0 || frameSellLand.landNumber > propertySelector.size()) {
                    frameSellLand = new FrameSellLand(propertySelector, specialTileSelector, player, false, false);
                }
                int totalLandSold = 0;
                if (frameSellLand.landNumber <= propertySelector.size()) {
                    player.money += (propertySelector.get(frameSellLand.landNumber - 1).cost * 0.5);
                    propertySelector.get(frameSellLand.landNumber - 1).owner = null;
                } else {
                    player.money += (specialTileSelector.get(frameSellLand.landNumber - propertySelector.size() - 1).cost * 0.5);
                    specialTileSelector.get(propertySelector.size() - frameSellLand.landNumber).owner = null;
                }
                frameSellLand.totalLandCount--;
                totalLandSold++;
                if (cost < player.money) {
                    player.money -= cost;
                    cost = 0;
                    player.propertySellCheck = false;
                    hasPaid = true;
                    toString += player.name + " has sold " + totalLandSold + " land(s).\n";
                    buttonBuyLand.setEnabled(true);
                    buttonRoll.setEnabled(true);
                    break;
                }
            }
            if (!hasPaid) {
                buttonLoan.setEnabled(true);
                player.propertySellCheck = false;
            }
        }
        player.toString = toString;
    }

    public void playerLoan(Player player, int cost, boolean debtCheck) {
        SwingUtilities.invokeLater(() -> {
            if (!player.hasLoan) { // INTEGRATE WITH LOAN PANEL
                System.out.println("Do you want to take a loan?");
                System.out.println("Loan is subjected to be paid back in full by 3 rounds.");
                System.out.print("Do you want to make a loan? (Y/N) :");
                String choice = keyboard.nextLine();
                if (choice.equalsIgnoreCase("Y")) {
                    System.out.printf(Locale.US, "You have to take a loan of atleast RM%,d.\n", (cost - player.money));
                    System.out.print("How much do you want to loan?: RM");
                    player.loanAmount = keyboard.nextInt();
                    keyboard.nextLine();
                    while (player.loanAmount <= (cost - player.money)) {
                        System.out.println("You have to request a bigger loan.");
                        System.out.print("How much do you want to loan?: RM");
                        player.loanAmount = keyboard.nextInt();
                        keyboard.nextLine();
                    }
                    System.out.printf(Locale.US, "You have submitted a loan for RM%,d.\n", player.loanAmount);
                    player.money += player.loanAmount;
                    player.hasLoan = true;
                    player.loanPeriod = 0;
                    toString += String.format(player.name + " has taken a loan for RM%,d.\n", player.loanAmount);
                    buttonRoll.setEnabled(true);
                } else if (debtCheck) {
                    bankrupt(player);
                }
            } else {
                if (player.loanPeriodCheck)
                    player.loanPeriod++;
                System.out.printf(player.name + " has a loan of RM%,d.\n", player.loanAmount);
                if (player.loanPeriod == 3) {
                    System.out.println("You have to pay the loan now, the loan period is up.");
                    System.out.printf("You have RM%,d.\n", player.money);
                    if (player.money < player.loanAmount) {
                        System.out.println("You don't have enough money to pay the loan.");
                        bankrupt(player);
                    } else {
                        System.out.println(player.name + " has successfully paid the loan back in full.");
                        player.money -= player.loanAmount;
                        player.loanAmount = 0;
                        player.hasLoan = false;
                        player.loanPeriod = 0;
                        System.out.printf(player.name + " now have RM%,d.\n", player.money);
                        toString += player.name + " has paid the loan in full.\n";
                        buttonRoll.setEnabled(true);
                    }
                } else {
                    System.out.print("Do you want to pay the loan now? (Y/N): ");
                    String choice = keyboard.nextLine();
                    if (choice.equalsIgnoreCase("Y")) {
                        if (player.money <= player.loanAmount && debtCheck) {
                            System.out.println("You couldn't pay the loan and have a debt.");
                            bankrupt(player);
                        }
                        if (player.money <= player.loanAmount)
                            System.out.println("You don't have enough money to pay your loan.");
                        else {
                            System.out.printf("You have RM%,d.\n", player.money);
                            if (player.money >= player.loanAmount) {
                                player.money -= player.loanAmount;
                                player.loanAmount = 0;
                            } else {
                                System.out.print("Please enter the amount you want to pay back : RM");
                                int payment = keyboard.nextInt();
                                keyboard.nextLine();
                                while (payment < 0 || payment > player.loanAmount) {
                                    System.out.println("Invalid input! Please re-enter your payment: RM");
                                    payment = keyboard.nextInt();
                                    keyboard.nextLine();
                                }
                                player.money -= payment;
                                player.loanAmount -= payment;
                                System.out.printf(player.name + " has successfully paid his loan for RM%,d.\n", payment);
                                toString += String.format(player.name + " has paid the loan for RM%,d.\n", payment);
                                buttonRoll.setEnabled(true);
                            }
                            if (player.loanAmount == 0) {
                                System.out.println(player.name + " has successfully paid the loan back in full.");
                                player.hasLoan = false;
                                player.loanPeriod = 0;
                                toString += player.name + " has paid the loan in full.\n";
                                buttonRoll.setEnabled(true);
                            }
                        }
                    }
                }
                if (player.hasLoan && player.loanPeriodCheck && !player.bankruptcy) {
                    System.out.println("Your loan will continue on for another " + (3 - player.loanPeriod) + " moves.");
                    player.loanPeriodCheck = false;
                    toString += player.name + " loan's will continue for another " + (3 - player.loanPeriod) + " moves.\n";
                    buttonRoll.setEnabled(true);
                }
            }
            player.toString = toString;
        });
    }

    public void bankrupt(Player player) {
        SwingUtilities.invokeLater(() -> {
            if (player.bankruptcy) {
                System.out.println(player.name + " has already declared bankruptcy.");
                toString += player.name + " has already declared bankruptcy.\n";
            } else {
                System.out.println(player.name + " has declared bankruptcy.");
                toString += player.name + " has declared bankruptcy.\n";
                player.bankruptcy = true;
                player.propertySellCheck = false;
                for (Object currentTile : tiles) {
                    if (currentTile instanceof MiniTile) {
                        MiniTile currentPropertyTile = (MiniTile) currentTile;
                        if (currentPropertyTile.owner == player) {
                            currentPropertyTile.owner = null;
                            currentPropertyTile.numOfHouse = 0;
                        }
                    }
                    if (currentTile instanceof MiniSpecialTile) {
                        MiniSpecialTile currentSpecialTile = (MiniSpecialTile) currentTile;
                        if (currentSpecialTile.owner == player) {
                            currentSpecialTile.owner = null;
                        }
                    }
                }
            }
            buttonRoll.setEnabled(true);
            player.toString = toString;
        });
    }

    public int isOnePlayerLeft() {
        int activePlayerAmount = 0;
        for (Player player : players) {
            if (!player.bankruptcy)
                activePlayerAmount++;
            }
        return activePlayerAmount;
    }

    public void BoardDeclaration(int playerNumber) {
    SwingUtilities.invokeLater(() -> {

        //Any declarations add here
        toString = "Welcome to DuitRia";
        yCordsPlayerLog = 140;
        currentPlayerIndex = -1;
        keyboard = new Scanner(System.in);
        playerLogs = new ArrayList<>();
        players = new ArrayList<>();
        playerCards = new ArrayList<>();
        tiles = new ArrayList<>();
        rand = new Random();
        saveFile = new SaveFile();
        playerNum = playerNumber;

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
        labelImageDefault = new JLabel();
        labelImageDefault.setIcon(imageicon.getResizedImage("src\\duitria.current.tiles\\0 DEFAULT CURRENT TILE.png",228,474));
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

        textPrompt.setBounds(177, 182, 175, 110);
        textPrompt.setBackground(Color.LIGHT_GRAY);
        textPrompt.setEditable(false);
        textPrompt.setFont(new Font("Arial", Font.ITALIC, 10));
        textPrompt.setText(toString);
        panelBoard.add(textPrompt);
        
        
        //Initialize Roll panel Button
        JPanel panelRoll = new JPanel();
        panelRoll.setBounds(110 , 860, 150,150);
        buttonRoll.setBounds(0 , 0, 150,150);
        buttonRoll.addActionListener(this);
        buttonRoll.setIcon(imageicon.getResizedImage("src\\duitria\\Icons\\dice.png", 150, 150));
        diceOneImg = new JLabel();
        diceTwoImg = new JLabel();

        //Initialize Button Bankcrupt
        buttonBankrupt = new JButton();
        buttonBankrupt.setBounds(314, 860, 125, 50);
        buttonBankrupt.setText("Bankrupt");
        buttonBankrupt.setEnabled(true);
        buttonBankrupt.addActionListener(this);
        this.add(buttonBankrupt);
    
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
        
        //Initialize Buy Land Button
        JPanel panelBuyLand = new JPanel();
        panelBuyLand.setBounds(700 , 225, 100,50);
        buttonBuyLand.setBounds(0 , 0, 100,50);
        buttonBuyLand.addActionListener(this);
        // buttonBuyLand.setIcon(imageicon.getResizedImage("src\\duitria\\Icons\\BUY.png", 100, 50));
        buttonBuyLand.setText("Buy Land");
        buttonBuyLand.setEnabled(false);
        panelBuyLand.setBackground(Color.WHITE);
        panelBuyLand.setBorder(border);
        panelBuyLand.setLayout(null);
        panelBuyLand.add(buttonBuyLand);
        panelBoard.add(panelBuyLand);
        

        //Initialize Buy House Button
        JPanel panelBuyHouse = new JPanel();
        panelBuyHouse.setBounds(700 , 325, 100,50);
        buttonBuyHouse.setBounds(0 , 0, 100,50);
        buttonBuyHouse.addActionListener(this);
        // buttonBuyLand.setIcon(imageicon.getResizedImage("src\\duitria\\Icons\\BUY.png", 100, 50));
        buttonBuyHouse.setText("Buy House");
        buttonBuyHouse.setEnabled(false);
        panelBuyHouse.setBackground(Color.WHITE);
        panelBuyHouse.setBorder(border);
        panelBuyHouse.setLayout(null);
        panelBuyHouse.add(buttonBuyHouse);
        panelBoard.add(panelBuyHouse);
                
        //Initialize Sell Button
        JPanel panelSell = new JPanel();
        panelSell.setBounds(700 , 425, 100,50);
        buttonSell.setBounds(0 , 0, 100,50);
        buttonSell.addActionListener(this);
        buttonSell.setEnabled(false);
        buttonSell.setIcon(imageicon.getResizedImage("src\\duitria\\Icons\\SELL.png", 100, 50));
        panelSell.setBackground(Color.WHITE);
        panelSell.setBorder(border);
        panelSell.setLayout(null);
        panelSell.add(buttonSell);
        panelBoard.add(panelSell);
        
        //Initialize Loan Button
        JPanel panelLoan = new JPanel();
        panelLoan.setBounds(700 , 525, 100,50);
        buttonLoan.setBounds(0 , 0, 100,50);
        buttonLoan.addActionListener(this);
        buttonLoan.setIcon(imageicon.getResizedImage("src\\duitria\\Icons\\LOAN.png", 100, 50));
        buttonLoan.setEnabled(false);
        panelLoan.setBackground(Color.WHITE);
        panelLoan.setBorder(border);
        panelLoan.setLayout(null);
        panelLoan.add(buttonLoan);
        panelBoard.add(panelLoan);



        //Initialize Pay Rent Button
        JPanel panelPayRent = new JPanel();
        panelPayRent.setBounds(700 , 625, 100,50);
        buttonPayRent.setBounds(0 , 0, 100,50);
        buttonPayRent.addActionListener(this);
        // buttonPayRent.setIcon(imageicon.getResizedImage("src\\duitria\\Icons\\LOAN.png", 100, 50));
        buttonPayRent.setText("Pay Rent");
        buttonPayRent.setEnabled(false);
        panelPayRent.setBackground(Color.WHITE);
        panelPayRent.setBorder(border);
        panelPayRent.setLayout(null);
        panelPayRent.add(buttonPayRent);
        panelBoard.add(panelPayRent);


        


        
        // test comment
        if (saveFile.newGame) {
            initializeTile(panelBoard);
            initializePlayer();
            initializePlayerCard();
        } else {
            initializeTile(panelBoard);
            tiles = saveFile.tiles;
            players = saveFile.players;
            initializePlayerCard();
        }


    });
    }
    public void playerCardUpdate() {
        SwingUtilities.invokeLater(() -> {
            for (int i = 0; i < players.size(); i++) {
                Player player = players.get(i);
                PlayerCard playerCard = playerCards.get(i);
                int ownedTile = 0;
                for (Object ownedTileCheck : tiles) {
                    if (ownedTileCheck instanceof MiniTile) {
                        propertyTile = (MiniTile) ownedTileCheck;
                        if (propertyTile.owner == player)
                            ownedTile++;
                    }
                    if (ownedTileCheck instanceof MiniSpecialTile) {
                        specialTile = (MiniSpecialTile) ownedTileCheck;
                        if (specialTile.owner == player)
                            ownedTile++;
                    }
                }
                String moneyFormat = String.format("Money : RM%,d", player.money);

                playerCard.labelPlayerMoney.setText(moneyFormat);

                playerCard.labelPlayerLand.setText("Land : " + ownedTile);

                playerCard.labelPlayerStatus.setText("Status : " + (player.bankruptcy ? "Bankrupt" : (player.hasLoan ? "Has Loan" : "Active Player")));
                revalidate();

            
            }
        });
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==buttonRoll) {
            buttonRoll.setEnabled(false);
            buttonBankrupt.setEnabled(true);
            if (isOnePlayerLeft() == 1) {
                for (Player player : players) {
                if (!player.bankruptcy) { // GAMEWINNER
                    
                    }
                }
            }
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            currentPlayer = players.get(currentPlayerIndex);
            currentPlayer.toString = "";
            if (currentPlayer.jailCheck) {
                // SAY YOU HAVE TO PULL 2 SAME DICE ROLL OR PAY 250K
            }
            // roll for 3 seconds
            long startTime = System.currentTimeMillis();
            Thread rollThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    long endTime = System.currentTimeMillis();
                    try {
                        int diceOne = 0, diceTwo = 0;
                        while ((endTime - startTime) / 1000F < 0.5) {
                            // roll dice
                            diceOne = rand.nextInt(1, 7);
                            diceTwo = rand.nextInt(1, 7);
                            sum = diceOne + diceTwo;
                            // update dice images
                            diceOneImg.setIcon(imageicon.getResizedImage("src\\duitria\\DiceIcons\\DICE" + diceOne + ".png",100,100));
                            diceTwoImg.setIcon(imageicon.getResizedImage("src\\duitria\\DiceIcons\\DICE" + diceTwo + ".png",100,100));
                            // sleep thread
                            Thread.sleep(60);
                            endTime = System.currentTimeMillis();
                        }
                        int previousPlayerPosition = currentPlayer.position;
                        currentPlayer.position = (currentPlayer.position + sum) % tiles.size();
                        Object currentTile = tiles.get(currentPlayer.position);
                        if (currentPlayer.jailCheck) {
                            if (diceOne == diceTwo) {
                                String textPrompt = "";
                                textPrompt += currentPlayer.name + " has managed to roll a double!.\n";
                                currentPlayer.jailCheck = false;
                                duitriaBoard(currentPlayer, currentTile, previousPlayerPosition, sum);
                            } else {
                                    String textPrompt = "";
                                    textPrompt += currentPlayer.name + " has to pay RM250,000 to get out of jail.\n";
                                    if (250000 >= currentPlayer.money) {
                                        buttonSell.setEnabled(true);
                                        System.out.println("You don't have enough money to pay the jail fines.");
                                } else {
                                    currentPlayer.money -= 250000;
                                    currentPlayer.jailCheck = false;
                                    toString += currentPlayer.name + " successfully paid the jail fines.";
                                    System.out.println(currentPlayer.name + " successfully paid the jail fines.");
                                }
                                    duitriaBoard(currentPlayer, currentTile, previousPlayerPosition, sum);
                            }
                        } else if (currentPlayer.bankruptcy) {
                            toString += currentPlayer.name + " has already declared bankruptcy.\n";
                        } else {
                            duitriaBoard(currentPlayer, currentTile, previousPlayerPosition, sum);
                        }
                            if (currentPlayer.hasLoan) {
                            currentPlayer.loanPeriodCheck = true;
                            playerLoan(currentPlayer, 0, false);
                        }
                        duitriaBoard(currentPlayer, currentTile, previousPlayerPosition, sum);
                        playerCardUpdate();
                        currentPlayer.toString = toString;
                        playerLogHistory(currentPlayer);
                        System.out.println(currentPlayer.toString);
                        saveFile.saveGame(players, tiles, saveFileNameChoice);
                        // buttonRoll.setEnabled(true);

                        revalidate();

                        } catch(InterruptedException e) {
                        System.out.println("Threading Error: " + e);
                        }
                    }
            });
        rollThread.start();
        }

        if(e.getSource()==buttonGameRules){
            GameRules gameRules = new GameRules();
        }

        if (e.getSource() == buttonBankrupt){
            JOptionPane optionPaneBankrupt = new JOptionPane();
            int choice = optionPaneBankrupt.showConfirmDialog(null, "Are you sure you want to declare bankrupcy?");
            switch (choice) {

                case JOptionPane.YES_OPTION:
                    bankrupt(currentPlayer);
                    JOptionPane optionPaneDeclareBankruptcy = new JOptionPane();
                    optionPaneDeclareBankruptcy.showMessageDialog(null, currentPlayer + " Has declared bankruptcy", "Bankruptcy",0);
                    buttonBankrupt.setEnabled(false);
                    break;

                case JOptionPane.NO_OPTION:
                    break;

                case JOptionPane.CANCEL_OPTION:
                    break;

                default:
                    break;
            }
        }

        if (e.getSource() == buttonBuyLand) {
            JOptionPane optionPaneBuyLand = new JOptionPane();
            int choice = optionPaneBuyLand.showConfirmDialog(null, "Are you sure you want to buy this land??");
            switch (choice) {
                case JOptionPane.YES_OPTION:
                        buttonBuyLand.setEnabled(false);
                        if (playerCurrentTile instanceof MiniTile) {
                            propertyTile = (MiniTile) playerCurrentTile;
                            if (propertyTile.cost >= currentPlayer.money) {
                                System.out.println("Not enough money to buy " + propertyTile.name + ".");
                                buttonSell.setEnabled(true);
                            } else {
                                currentPlayer.money -= propertyTile.cost;
                                propertyTile.owner = currentPlayer;
                                System.out.println(currentPlayer.name + " bought " + propertyTile.name + ".");
                                toString += currentPlayer.name + " has bought " + propertyTile.name + ".\n";
                                buttonRoll.setEnabled(true);
                }
                        } else if (playerCurrentTile instanceof MiniSpecialTile) {
                            specialTile = (MiniSpecialTile) playerCurrentTile;
                            if (specialTile.cost >= currentPlayer.money) {
                                System.out.println("You do not enough money to buy " + specialTile.name + ".");
                                buttonSell.setEnabled(true);
                            } else {
                                currentPlayer.money -= specialTile.cost;
                                specialTile.owner = currentPlayer;
                                System.out.println(currentPlayer.name + " bought " + specialTile.name + ".");
                                toString += currentPlayer.name + " has bought " + specialTile.name + ".\n";
                                buttonRoll.setEnabled(true);
                }
                        }
                break;
                case JOptionPane.NO_OPTION:
                break;
                case JOptionPane.CANCEL_OPTION:
                break;
                default:
                break;
            }
            currentPlayer.toString = toString;
            playerCardUpdate();
        }

        if (e.getSource() == buttonBuyHouse){
            buttonBuyHouse.setEnabled(false);
            String houseNum;
            JOptionPane buyHousePopUp = new JOptionPane();
            do {
                houseNum = buyHousePopUp.showInputDialog("Input how many houses you want to buy : ");
            } while (Integer.parseInt(houseNum) <= 4 && Integer.parseInt(houseNum) >=0);

            int houseNumber = Integer.parseInt(houseNum);
            if (playerCurrentTile instanceof MiniTile) {
                propertyTile = (MiniTile) playerCurrentTile; // PANEL BUY HOUSE
                
            }
        }
    
        if (e.getSource() == buttonLoan){
            buttonLoan.setEnabled(false);
            if (creatorDebt) {
                playerLoan(currentPlayer, cost, creatorDebt);
                if (!currentPlayer.bankruptcy) {
                    currentPlayer.propertySellCheck = false;
                    hasPaid = true;
                }
            }
            if (playerCurrentTile instanceof MiniTile) {
                propertyTile = (MiniTile) playerCurrentTile;
                playerLoan(currentPlayer, propertyTile.cost, false);
            } else if (playerCurrentTile instanceof MiniSpecialTile) {
                specialTile = (MiniSpecialTile) playerCurrentTile;
                playerLoan(currentPlayer, specialTile.cost, false);
            }
            currentPlayer.toString = toString;
            playerCardUpdate();
        }

        if (e.getSource() == buttonSell) {
            buttonSell.setEnabled(false);
            if (playerCurrentTile instanceof MiniTile) {
                propertyTile = (MiniTile) playerCurrentTile;
                if (propertyTile.owner == null) {
                    // SELL HOUSE AND LAND SYSTEM TO BUY LAND
                    if (canSell(currentPlayer)) {
                        sellingProperties(currentPlayer, propertyTile.cost, false, false, null);
                        if (!currentPlayer.bankruptcy && propertyTile.cost < currentPlayer.money) {
                            buttonBuyLand.setEnabled(true);
                            currentPlayer.money -= propertyTile.cost;
                            propertyTile.owner = currentPlayer;
                            System.out.println(currentPlayer.name + " bought " + propertyTile.name + ".");
                            toString += currentPlayer.name + " has bought " + propertyTile.name + ".\n";
                            buttonRoll.setEnabled(true);
                        }
                    } else {
                        buttonLoan.setEnabled(true);
                    }
                } else if (propertyTile.owner != currentPlayer) {
                    // SELL HOUSE SYSTEM TO PAY RENT, IF CAN'T PAY, GIVE ASSETS TO OWNER
                    sellingProperties(currentPlayer, propertyTile.rentAmount, false, true, propertyTile.owner);
                    if (!currentPlayer.bankruptcy && propertyTile.rentAmount < currentPlayer.money) {
                        currentPlayer.money -= propertyTile.rentAmount;
                        propertyTile.owner.money += propertyTile.rentAmount;
                        toString += String.format(currentPlayer.name + " paid RM%,d to " + propertyTile.owner.name + ".\n", propertyTile.rentAmount);
                        System.out.println(currentPlayer.name + " successfully paid the rent.");
                        buttonRoll.setEnabled(true);
                    }
                }
            } else if (playerCurrentTile instanceof MiniSpecialTile) {
                specialTile = (MiniSpecialTile) playerCurrentTile;
                if (specialTile.owner == null) {
                    // SELL HOUSE AND LAND TO BUY LAND
                    if (canSell(currentPlayer)) {
                        sellingProperties(currentPlayer, specialTile.cost, false, false, null);
                        if (!currentPlayer.bankruptcy && specialTile.cost < currentPlayer.money) {
                            buttonBuyLand.setEnabled(true);
                            currentPlayer.money -= specialTile.cost;
                            specialTile.owner = currentPlayer;
                            System.out.println(currentPlayer.name + " bought " + specialTile.name + ".");
                            toString += currentPlayer.name + " has bought " + specialTile.name + ".\n";
                            buttonRoll.setEnabled(true);
                        }
                    } else {
                        buttonLoan.setEnabled(true);
                    }
                } else if (specialTile.owner != currentPlayer) {
                    if (fateCardRNG == 1) {
                        sellingProperties(currentPlayer, specialTile.rentAmount, false, true, specialTile.owner);
                        if (!currentPlayer.bankruptcy && specialTile.rentAmount < currentPlayer.money) {
                            currentPlayer.money -= specialTile.rentAmount;
                            specialTile.owner.money += specialTile.rentAmount;
                            System.out.println(currentPlayer.name + " successfully paid the rent.");
                            toString += currentPlayer.name + " has paid RM%,d (double rent) to " + specialTile.owner.name + ".\n";
                            buttonRoll.setEnabled(true);
                        }
                    }
                    // SELL HOUSE SYSTEM TO PAY RENT, IF CAN'T PAY, GIVE ASSETS TO OWNER
                    sellingProperties(currentPlayer, specialTile.baseRent, false, true, specialTile.owner);
                    if (!currentPlayer.bankruptcy && specialTile.baseRent < currentPlayer.money) {
                        currentPlayer.money -= specialTile.baseRent;
                        specialTile.owner.money += specialTile.baseRent;
                        toString += String.format(currentPlayer.name + " paid RM%,d to " + specialTile.owner.name + ".\n", specialTile.baseRent);
                        System.out.println(currentPlayer.name + " successfully paid the rent.");
                        buttonRoll.setEnabled(true);
                    } else {
                        buttonLoan.setEnabled(true);
                    }
                }
            } else if (playerCurrentTile instanceof MiniTax) {
                MiniTax tax = (MiniTax) playerCurrentTile;
                sellingProperties(currentPlayer, tax.cost, true, false, null);
                if (!currentPlayer.bankruptcy && tax.cost < currentPlayer.money) {
                    currentPlayer.money -= tax.cost;
                    System.out.println(currentPlayer.name + " successfully paid the taxes.");
                    toString += String.format(currentPlayer.name + " has paid RM%,d to the Creator.\n", tax.cost);
                    buttonRoll.setEnabled(true);
                }
            } else if (playerCurrentTile instanceof MiniFateCard) {
                MiniFateCard fate = (MiniFateCard) playerCurrentTile;
                switch(fateCardRNG) {
                case 2:
                sellingProperties(otherPlayer, 100000, false, true, null);
                if (!currentPlayer.bankruptcy && 100000 < otherPlayer.money) {
                    System.out.println(otherPlayer.name + " successfully given the birthday money.");
                    otherPlayer.money -= 100000;
                    birthdayMoney += 100000;
                    buttonRoll.setEnabled(true);
                }
                break;
                case 6:
                sellingProperties(currentPlayer, generalRepairTotal, true, false, null);
                if (!currentPlayer.bankruptcy && generalRepairTotal < currentPlayer.money) {
                    currentPlayer.money -= generalRepairTotal;
                    System.out.printf(Locale.US, currentPlayer.name + " successfully paid RM%,d.\n", generalRepairTotal);
                    toString += String.format(currentPlayer.name + " has paid RM%,d to the Creator.\n", generalRepairTotal);
                    buttonRoll.setEnabled(true);
                }
                break;
                case 7:
                sellingProperties(currentPlayer, 250000, true, false, null);
                if (!currentPlayer.bankruptcy && 250000 < currentPlayer.money) {
                    currentPlayer.money -= 250000;
                    System.out.println(currentPlayer.name + " successfully paid the hospital fees.");
                    toString += currentPlayer.name + " has paid RM250,000 to the Creator.\n";
                    buttonRoll.setEnabled(true);
                }
                break;
                case 8:
                sellingProperties(currentPlayer, 100000, true, false, null);
                if (!currentPlayer.bankruptcy && 100000 < currentPlayer.money) {
                    currentPlayer.money -= 100000;
                    System.out.println(currentPlayer.name + " successfully paid the school fees.");
                    toString += currentPlayer.name + " has paid RM100,000 to the Creator.\n";
                    buttonRoll.setEnabled(true);
                }
                break;
                case 9:
                sellingProperties(currentPlayer, 100000, true, false, null);
                if (!currentPlayer.bankruptcy && 100000 < currentPlayer.money) {
                    currentPlayer.money -= 100000;
                    System.out.println(currentPlayer.name + " successfully paid the speeding fine.");
                    toString += currentPlayer.name + " has paid RM100,000 to the Creator.\n";
                    buttonRoll.setEnabled(true);
                }
                break;
                }
            }
            currentPlayer.toString = toString;
            playerCardUpdate();
        }
    }
    
class CornerBoardTile extends JPanel implements Serializable{

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
    
    MiniGo(int x, int y, int width, int height, JPanel panelBoard, String path, String name, int payment, String pathBig) {
        super(x, y, width, height, panelBoard, path);
        this.name = name;
        this.payment = payment; 

        buttonTile.setBounds(0, 0, width, height);
        buttonTile.setIcon(imageicon.getResizedImage(path, width, height));
        buttonTile.addActionListener(
            e -> {
                labelImageDefault.setIcon(imageicon.getResizedImage(pathBig, 228, 474));
            }
        );
        this.add(buttonTile);

    }
}

class MiniJail extends CornerBoardTile {
    String name;    // jail tile's name
    MiniJail(int x, int y, int width, int height, JPanel panelBoard, String path, String name) {
        super(x, y, width, height, panelBoard, path);
        this.name = name;
    }
    MiniJail(int x, int y, int width, int height, JPanel panelBoard, String path, String name, String pathBig) {
        super(x, y, width, height, panelBoard, path);
        this.name = name; 

        buttonTile.setBounds(0, 0, width, height);
        buttonTile.setIcon(imageicon.getResizedImage(path, width, height));
        buttonTile.addActionListener(
            e -> {
                labelImageDefault.setIcon(imageicon.getResizedImage(pathBig, 228, 474));
            }
        );
        this.add(buttonTile);

    }
}

class MiniFreeParking extends CornerBoardTile {
    String name;    //free parking tile's name
    MiniFreeParking(int x, int y, int width, int height, JPanel panelBoard, String path, String name) {
        super(x, y, width, height, panelBoard, path);
        this.name = name;
    }
    MiniFreeParking(int x, int y, int width, int height, JPanel panelBoard, String path, String name, String pathBig) {
        super(x, y, width, height, panelBoard, path);
        this.name = name; 

        buttonTile.setBounds(0, 0, width, height);
        buttonTile.setIcon(imageicon.getResizedImage(path, width, height));
        buttonTile.addActionListener(
            e -> {
                labelImageDefault.setIcon(imageicon.getResizedImage(pathBig, 228, 474));
            }
        );
        this.add(buttonTile);

    }
}

class MiniGoToJail extends CornerBoardTile {
    String name;    //free parking tile's name
    MiniGoToJail(int x, int y, int width, int height, JPanel panelBoard, String path, String name) {
        super(x, y, width, height, panelBoard, path);
        this.name = name;
    }
    MiniGoToJail(int x, int y, int width, int height, JPanel panelBoard, String path, String name, String pathBig) {
        super(x, y, width, height, panelBoard, path);
        this.name = name; 

        buttonTile.setBounds(0, 0, width, height);
        buttonTile.setIcon(imageicon.getResizedImage(path, width, height));
        buttonTile.addActionListener(
            e -> {
                labelImageDefault.setIcon(imageicon.getResizedImage(pathBig, 228, 474));
            }
        );
        this.add(buttonTile);

    }
}

class BoardTile extends JPanel implements Serializable{
    JButton buttonTile = new JButton();
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
    int rentAmount;     // tile's total rent amount
    
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

    MiniTile(int x, int y, int width, int height, JPanel panelBoard, String path, String name, int cost, int baseRent, String tileColour, String pathBig) {
        super(x, y, width, height, panelBoard, path);
        this.name = name;
        this.cost = cost;
        this.baseRent = baseRent;
        this.tileColour = tileColour;
        houseCost = 200000;
        owner = null;
        numOfHouse = 0;

        buttonTile.setBounds(0, 0, width, height);
        buttonTile.setIcon(imageicon.getResizedImage(path, width, height));
        buttonTile.addActionListener(
            e -> {
                labelImageDefault.setIcon(imageicon.getResizedImage(pathBig, 228, 474));
            }
        );
        this.add(buttonTile);
        
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
    int rentAmount; // special tile's rent amount
    MiniSpecialTile(int x, int y, int width, int height, JPanel panelBoard, String path, String name, int cost, int baseRent) {
        super(x, y , width, height, panelBoard, path);
        this.name = name;
        this.cost = cost;
        this.baseRent = baseRent;
        owner = null;

    }

    MiniSpecialTile(int x, int y, int width, int height, JPanel panelBoard, String path, String name, int cost, int baseRent, String pathBig) {
        super(x, y , width, height, panelBoard, path);
        this.name = name;
        this.cost = cost;
        this.baseRent = baseRent;
        owner = null;

        buttonTile.setBounds(0, 0, width, height);
        buttonTile.setIcon(imageicon.getResizedImage(path, width, height));
        buttonTile.addActionListener(
            e -> {
                labelImageDefault.setIcon(imageicon.getResizedImage(pathBig, 228, 474));
            }
        );
        this.add(buttonTile);

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
    
        MiniTax(int x, int y, int width, int height, JPanel panelBoard, String path, String name, int cost, String pathBig) {
        super(x, y , width, height, panelBoard, path);
        this.name = name;
        this.cost = cost; 

        buttonTile.setBounds(0, 0, width, height);
        buttonTile.setIcon(imageicon.getResizedImage(path, width, height));
        buttonTile.addActionListener(
            e -> {
                labelImageDefault.setIcon(imageicon.getResizedImage(pathBig, 228, 474));
            }
        );
        this.add(buttonTile);

    }
}
class MiniFateCard extends BoardTile {
    String name;    // fate card's name
    MiniFateCard(int x, int y, int width, int height, JPanel panelBoard, String path, String name) {
        super(x, y, width, height, panelBoard, path);
        this.name = name;
    }
    MiniFateCard(int x, int y, int width, int height, JPanel panelBoard, String path, String name, String pathBig) {
        super(x, y , width, height, panelBoard, path);
        this.name = name;

        buttonTile.setBounds(0, 0, width, height);
        buttonTile.setIcon(imageicon.getResizedImage(path, width, height));
        buttonTile.addActionListener(
            e -> {
                labelImageDefault.setIcon(imageicon.getResizedImage(pathBig, 228, 474));
            }
        );
        this.add(buttonTile);

    }
}

}

class PlayerCard extends JPanel {

    String playerName;
    double playerLand;
    double playerMoney;
    String playerStatus;
    JTextArea labelPlayerMoney = new JTextArea();
    JTextArea labelPlayerLand = new JTextArea();
    JTextArea labelPlayerStatus = new JTextArea();

    PlayerCard(int a, int b, JFrame frame, String playerName, double playerLand, double playerMoney, String playerStatus) {
        
        SwingUtilities.invokeLater(() -> {

            this.playerName = playerName;
            this.playerLand = playerLand;
            this.playerMoney = playerMoney;
            this.playerStatus = playerStatus;

            Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
            this.setBounds(0, b, 375, 175);
            this.setBackground(Color.LIGHT_GRAY);
            this.setBorder(border);
            this.setLayout(null);
            frame.add(this);

            JPanel panelPlayerName = new JPanel();
            panelPlayerName.setBounds(0, 0, 375, 50); // Set bounds for the panel
            // panelPlayerName.setBorder(border); // Set a background color for visibility
            panelPlayerName.setBackground(Color.LIGHT_GRAY);
            JTextArea labelPlayerName = new JTextArea();
            labelPlayerName.setText(this.playerName);
            panelPlayerName.setOpaque(false);
            labelPlayerName.setBounds(10, 10, 370, 38); 
            labelPlayerName.setFont(new Font("Inter", Font.BOLD, 40));
            labelPlayerName.setRows(10);
            labelPlayerName.setColumns(30);
            labelPlayerName.setMargin(new Insets(0, 570, 0, 0));
            panelPlayerName.add(labelPlayerName);
            this.add(panelPlayerName);


            JPanel panelPlayerDescription = new JPanel();
            panelPlayerDescription.setBounds(0, 0, 375, 110); // Set bounds for the panel
            // panelPlayerDescription.setBorder(border); // Set a background color for visibility
            panelPlayerDescription.setOpaque(false);
            panelPlayerDescription.setBackground(Color.LIGHT_GRAY);
            this.add(panelPlayerDescription);

            labelPlayerMoney.setText("Money : RM " + this.playerMoney);
            labelPlayerMoney.setBounds(5, 5, 375, 36); 
            labelPlayerMoney.setFont(new Font("Arial", Font.ITALIC, 30));
            labelPlayerMoney.setRows(1);
            labelPlayerMoney.setColumns(30);
            labelPlayerMoney.setOpaque(false);
            labelPlayerMoney.setMargin(new Insets(0, 300, 0, 0));
            panelPlayerDescription.add(labelPlayerMoney);

            labelPlayerLand.setText("Land : " + this.playerLand);
            labelPlayerLand.setBounds(5, 42, 375, 36); 
            labelPlayerLand.setFont(new Font("Arial", Font.ITALIC, 30));
            panelPlayerDescription.add(labelPlayerLand);

            labelPlayerStatus.setText("Status : " + this.playerStatus);
            labelPlayerStatus.setBounds(5, 79, 375, 36); 
            labelPlayerStatus.setFont(new Font("Arial", Font.ITALIC, 30));
            labelPlayerStatus.setRows(1);
            labelPlayerStatus.setColumns(30);
            labelPlayerStatus.setOpaque(false);
            labelPlayerStatus.setMargin(new Insets(0, 300, 0, 0));
            panelPlayerDescription.add(labelPlayerStatus);
            revalidate();

        });
    }

    //Not set player money , land and status yet
    PlayerCard(int x, int y, JFrame frame, Player player, List<Object> tiles) {
        SwingUtilities.invokeLater(() -> {
            
            Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
            this.setOpaque(false);
            this.setBounds(0, y, 375, 175);
            this.setLayout(null);
            frame.add(this);

            JPanel panelPlayerName = new JPanel();
            panelPlayerName.setBounds(0, 0, 375, 50); // Set bounds for the panel
            // panelPlayerName.setBorder(border); // Set a background color for visibility
            panelPlayerName.setBackground(Color.LIGHT_GRAY);
            JTextArea labelPlayerName = new JTextArea();
            labelPlayerName.setText(player.name);
            panelPlayerName.setOpaque(false);
            labelPlayerName.setBounds(10, 10, 370, 38); 
            labelPlayerName.setFont(new Font("Inter", Font.BOLD, 35));
            labelPlayerName.setRows(10);
            labelPlayerName.setColumns(30);
            labelPlayerName.setMargin(new Insets(0, 570, 0, 0));
            panelPlayerName.add(labelPlayerName);
            this.add(panelPlayerName);

            JPanel panelPlayerDescription = new JPanel();
            panelPlayerDescription.setBounds(0, 50, 375, 110); // Set bounds for the panel
            // panelPlayerDescription.setBorder(border); // Set a background color for visibility
            panelPlayerDescription.setOpaque(false);
            panelPlayerDescription.setBackground(Color.LIGHT_GRAY);
            this.add(panelPlayerDescription);

            String moneyFormat = String.format("Money : RM%,d", player.money);
            labelPlayerMoney.setText(moneyFormat);
            labelPlayerMoney.setBounds(5, 5, 375, 36); 
            labelPlayerMoney.setFont(new Font("Arial", Font.ITALIC, 25));
            labelPlayerMoney.setRows(1);
            labelPlayerMoney.setColumns(30);
            labelPlayerMoney.setBackground(Color.LIGHT_GRAY);
            labelPlayerMoney.setMargin(new Insets(0, 300, 0, 0));
            panelPlayerDescription.add(labelPlayerMoney);

            labelPlayerLand.setText("Land : 0");
            labelPlayerLand.setBounds(5, 42, 375, 36); 
            labelPlayerLand.setFont(new Font("Arial", Font.ITALIC, 25));
            labelPlayerLand.setRows(1);
            labelPlayerLand.setColumns(30);
            labelPlayerLand.setBackground(Color.LIGHT_GRAY);
            labelPlayerLand.setMargin(new Insets(0, 300, 0, 0));
            panelPlayerDescription.add(labelPlayerLand);

            labelPlayerStatus.setText("Status : " + (player.bankruptcy ? "Bankrupt" : (player.hasLoan ? "Has Loan" : "Active Player")));
            labelPlayerStatus.setBounds(5, 79, 375, 36); 
            labelPlayerStatus.setFont(new Font("Arial", Font.ITALIC, 25));
            labelPlayerStatus.setRows(1);
            labelPlayerStatus.setColumns(30);
            labelPlayerStatus.setBackground(Color.LIGHT_GRAY);
            labelPlayerStatus.setMargin(new Insets(0, 300, 0, 0));
            panelPlayerDescription.add(labelPlayerStatus);
            revalidate();
            
        });
    }
}

//             playerLogHistory.addLogEntry("Player1", "Bought a property");
//             playerLogHistory.addLogEntry("Player2", "Paid rent");
//             playerLogHistory.addLogEntry("Player1", "Passed Go");
//         });
//     }
// }

class PlayerLogHistory extends JPanel {
    
    PlayerLogHistory(int x, int y, JFrame frame, Player player){
        SwingUtilities.invokeLater(() -> {

            Border border = BorderFactory.createLineBorder(Color.BLACK,1);
            this.setOpaque(false);
            this.setBounds(x, y, 420, 150);
            this.setLayout(null);
            frame.add(this);

            JPanel panelPlayerLogMove = new JPanel();
            panelPlayerLogMove.setBounds(0, 0, 420, 50); // Set bounds for the panel
            // panelPlayerLogMove.setBorder(border); // Set a background color for visibility
            panelPlayerLogMove.setBackground(Color.LIGHT_GRAY);
            JTextArea labelPlayerMove = new JTextArea();
            labelPlayerMove.setText(player.name + " moves To Tile " + player.position);
            panelPlayerLogMove.setOpaque(false);
            labelPlayerMove.setBounds(10, 5, 420, 40); 
            labelPlayerMove.setFont(new Font("Inter", Font.BOLD, 25));
            labelPlayerMove.setRows(10);
            labelPlayerMove.setColumns(30);
            labelPlayerMove.setMargin(new Insets(0, 230, 0, 0));
            panelPlayerLogMove.add(labelPlayerMove);
            this.add(panelPlayerLogMove);
            revalidate();

            JPanel panelPlayerLogDescription = new JPanel();
            panelPlayerLogDescription.setBounds(0, 50, 420, 99); // Set bounds for the panel
            // panelPlayerLogDescription.setBorder(border); // Set a background color for visibility
            panelPlayerLogDescription.setBackground(Color.LIGHT_GRAY);
            this.add(panelPlayerLogDescription);
            revalidate();

            JTextArea labelPlayerLogDescription = new JTextArea();
            labelPlayerLogDescription.setText(player.toString);
            labelPlayerLogDescription.setBounds(0, 0, 410, 36); 
            labelPlayerLogDescription.setFont(new Font("Arial", Font.ITALIC, 15));
            labelPlayerLogDescription.setOpaque(false);
            labelPlayerLogDescription.setEditable(false);
            labelPlayerLogDescription.setRows(10);
            labelPlayerLogDescription.setMargin(new Insets(10, 0, 0, 0));
            labelPlayerLogDescription.setColumns(30);
            panelPlayerLogDescription.add(labelPlayerLogDescription);
            revalidate();

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

class Tokens {
    int xCordsPlayer1;
    int yCordsPlayer1;

    int xCordsPlayer2;
    int yCordsPlayer2;

    int xCordsPlayer3;
    int yCordsPlayer3;

    int xCordsPlayer4;
    int yCordsPlayer4;
    String path;

    Tokens( int xCordsPlayer1, int yCordsPlayer1 , int xCordsPlayer2, int yCordsPlayer2, int xCordsPlayer3, int yCordsPlayer3, int xCordsPlayer4, int yCordsPlayer4){

        this.xCordsPlayer1 = xCordsPlayer1; this.yCordsPlayer1 = yCordsPlayer1;

        this.xCordsPlayer2 = xCordsPlayer1; this.yCordsPlayer2 = xCordsPlayer1;
        
        this.xCordsPlayer3 = xCordsPlayer1; this.yCordsPlayer3 = xCordsPlayer1;
        
        this.xCordsPlayer4 = xCordsPlayer1; this.yCordsPlayer4 = xCordsPlayer1;
    }
}