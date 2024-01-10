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

    List<PlayerLogHistory> playerLogs;
    List<PlayerCard> playerCards;
    List<Player> players;
    List<Object> tiles;
    int currentPlayerIndex;
    int sum;
    int yCordsPlayerLog;
    String saveFileNameChoice;
    String toString;
    Scanner keyboard;
    Random rand;
    Player currentPlayer;
    MiniTile propertyTile;
    MiniSpecialTile specialTile;
    MiniTax tax;
    MiniFateCard fateCard;
    MiniFreeParking freeParking;
    MiniGo go;
    MiniGoToJail goToJail;
    MiniJail jail;
    Object playerCurrentTile;

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

    public void initializePlayerCard() {
        int yCords = 40;
        for (Player player : players) {
            playerCards.add(new PlayerCard(0, yCords, this, player, tiles));
            yCords += 205;
        }
    }

    public void playerLogHistory(Player player) {
        playerLogs.add(new PlayerLogHistory(1500, yCordsPlayerLog, this, player));
        yCordsPlayerLog += 160;
    }

    public void duitriaBoard(Player player, Object currentTile, int previousPlayerPosition, int diceRoll) {
        toString = "";
        if (previousPlayerPosition + diceRoll >= 40) {
            go = (MiniGo) tiles.get(0);
            toString += String.format(player.name + " has passed the Go Tile. " + player.name + " has received RM%,d.\n", go.payment);
            player.toString = toString;
            System.out.printf(Locale.US, player.name + " has passed the Go Tile. " + player.name + " has received RM%,d.\n", go.payment);
            player.money += go.payment;
            if (player.buyProperty)
                player.buyHouse = true;
            player.buyProperty = true;
        }
        if (currentTile instanceof MiniTile) {
            playerCurrentTile = currentTile;
            propertyTile = (MiniTile) currentTile;
            toString += player.name + " landed on " + propertyTile.name + ".\n";
            System.out.println(player.name + " landed on " + propertyTile.name + ".");
            if (propertyTile.owner == null && !player.hasLoan) { // BUY PROPERTY
                if (player.buyProperty) {
                    buttonBuy.setEnabled(true);
                }
            } else if (propertyTile.owner != player) { // PAY RENT
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
                int rentAmount = propertyTile.baseRent + propertyTile.calculateRent(doubleRent);
                System.out.println(propertyTile.name + " is owned by " + propertyTile.owner.name + ".");
                System.out.printf(player.name + " has to pay rent of RM%,d.\n", rentAmount);
                if (rentAmount >= player.money) {
                    System.out.println("You don't have enough money to pay the rent.");
                    sellingProperties(player, rentAmount, false, true, propertyTile.owner);
                    if (!player.bankruptcy && rentAmount < player.money) {
                        player.money -= rentAmount;
                        propertyTile.owner.money += rentAmount;
                        toString += String.format(player.name + " paid RM%,d to " + propertyTile.owner.name + ".\n", rentAmount);
                        player.toString = toString;
                        System.out.println(player.name + " successfully paid the rent.");
                    }
                } else {
                    player.money -= rentAmount;
                    propertyTile.owner.money += rentAmount;
                    toString += String.format(player.name + " paid RM%,d to " + propertyTile.owner.name + ".\n", rentAmount);
                    player.toString = toString;
                    System.out.println(player.name + " successfully paid the rent.");
                }
            } else { // VISIT PLAYER'S LAND (BUY HOUSE)
                toString += player.name + " landed on " + propertyTile.name + ".\n";
                player.toString = toString;
                System.out.println(player.name + " is visiting his land.");
                if (player.buyHouse && !player.hasLoan) {
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
                                        player.toString = toString;
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
            }
        } else if (currentTile instanceof MiniSpecialTile) {
            playerCurrentTile = currentTile;
            specialTile = (MiniSpecialTile) currentTile;
            System.out.println(player.name + " landed on " + specialTile.name + ".");
            if (specialTile.owner == null && !player.hasLoan) { // BUY LAND
                if (player.buyProperty) {
                    buttonBuy.setEnabled(true);
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
                        toString += String.format(player.name + " paid RM%,d to " + specialTile.owner.name + ".\n", specialTile.baseRent);
                        System.out.println(player.name + " successfully paid the rent.");
                    }
                } else {
                    player.money -= specialTile.baseRent;
                    specialTile.owner.money += specialTile.baseRent;
                    toString += String.format(player.name + " paid RM%,d to " + specialTile.owner.name + ".\n", specialTile.baseRent);
                    System.out.println(player.name + " successfully paid the rent.");
                }
            } else {
                toString += player.name + " landed on " + specialTile.name + ".\n";
                player.toString = toString;
                System.out.println(player.name + " is vitising his tile.");
            }
        } else if (currentTile instanceof MiniFateCard) {
            fateCard = (MiniFateCard) currentTile;
            System.out.println(player.name + " landed on the " + fateCard.name + ".");
            System.out.print(player.name + " drew a fate card: ");
            toString += player.name + " landed on " + fateCard.name + ".\n";
            player.toString = toString;
            fateCardOutcome(player);
        } else if (currentTile instanceof MiniJail) {
            jail = (MiniJail) currentTile;
            System.out.println(player.name + " landed on the " + jail.name + ".");
            System.out.println(player.name + " is visitng the jail.");
            toString += player.name + " landed on " + jail.name + ".\n";
            player.toString = toString;
        } else if (currentTile instanceof MiniTax) {
            tax = (MiniTax) currentTile;
            System.out.println(player.name + " landed on the " + tax.name + ".");
            toString += player.name + " landed on " + tax.name + ".\n";
            System.out.printf(Locale.US, player.name + " has to pay the tax for RM%,d.\n", tax.cost);
            if (tax.cost >= player.money) {
                System.out.println("You don't have enough money to pay taxes.");
                sellingProperties(player, tax.cost, true, false, null);
                if (!player.bankruptcy && tax.cost < player.money) {
                    player.money -= tax.cost;
                    System.out.println(player.name + " successfully paid the taxes.");
                    toString += String.format(player.name + " has paid RM%,d to the Creator.\n", tax.cost);
                    player.toString = toString;
                }
            } else {
                player.money -= tax.cost;
                System.out.println(player.name + " successfully paid the taxes.");
                toString += String.format(player.name + " has paid RM%,d to the Creator.\n", tax.cost);
                player.toString = toString;
            }
        } else if (currentTile instanceof MiniFreeParking) {
            freeParking = (MiniFreeParking) currentTile;
            System.out.println(player.name + " landed on the " + freeParking.name);
            System.out.println(player.name + " is resting.");
            toString += player.name + " landed on " + freeParking.name + ".\n";
            player.toString = toString;
        } else if (currentTile instanceof MiniGoToJail) {
            goToJail = (MiniGoToJail) currentTile;
            System.out.println(player.name + " landed on the " + goToJail.name + ".");
            System.out.println(player.name + " has to go to jail.");
            toString += player.name + " landed on " + goToJail.name + ".\n";
            toString += player.name + " has entered the jail.\n";
            player.toString = toString;
            player.jailCheck = true;
            player.position = 10;
        }
    }

    public void fateCardOutcome(Player player) {
        int randNum = rand.nextInt(10);
        switch(randNum) {
            case 0:
            System.out.println("Advance to Go and collect RM2,000,000.");
            toString += player.name + " drew a \"Advance to Go\" card.\n";
            player.toString = toString;
            player.position = 0;
            player.money += 2000000;
            if (player.buyProperty)
                player.buyHouse = true;
            player.buyProperty = true;
            break;
            case 1:
            System.out.println("Advance to the nearest railroad."); //add buy option for the railroads
            toString += player.name + " drew a \"Advance to the nearest railroad\" card.\n";
            player.toString = toString;
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
            toString += player.name + " drew a \"It's Your Birthday\" card.\n";
            int birthdayMoney = 0;
            player.money += (100000 * players.size());
            for (Player otherPlayer : players) {
                if (!otherPlayer.equals(player)) {
                    if (100000 >= otherPlayer.money) {
                        System.out.println(otherPlayer.name + " doesn't have enough to give birthday money.");
                        sellingProperties(otherPlayer, 100000, false, true, null);
                        if (!player.bankruptcy && 100000 < otherPlayer.money) {
                            System.out.println(otherPlayer.name + " successfully given the birthday money.");
                            otherPlayer.money -= 100000;
                            birthdayMoney += 100000;
                        }
                    }
                    otherPlayer.money -= 100000;
                    birthdayMoney += 100000;
                }
            }
            System.out.printf(player.name + " collected RM%,d from everyone.\n", birthdayMoney);
            toString += String.format(player.name + " collected RM%,d from everyone.\n", birthdayMoney);
            player.toString = toString;
            break;
            case 3:
            System.out.println("Bank error in your favor, Collect RM2,000,000.");
            toString += player.name + " drew a \"Bank Error\" card.\n";
            player.toString = toString;
            player.money += 2000000;
            break;
            case 4:
            System.out.println("Go back 3 spaces.");
            toString += player.name + " drew a \"Go Back 3 Spaces\" card.\n";
            player.toString = toString;
            player.position -= 3;
            break;
            case 5:
            System.out.println("Go to Jail.");
            toString += player.name + " drew a \"Go To Jail\" card.\n";
            player.toString = toString;
            player.position = 10;
            player.jailCheck = true;
            break;
            case 6:
            System.out.println("Make general repair on all your property, RM200,000 for each house.");
            toString = player.name + " drew a \"Make General Repair\" card.\n";
            player.toString = toString;
            int generalRepairTotal = 0;
            for (Object currentTile : tiles) {
                if (currentTile instanceof MiniTile) {
                    MiniTile currentPropertyTile = (MiniTile) currentTile;
                    if (currentPropertyTile.owner == player) {
                        generalRepairTotal += (currentPropertyTile.numOfHouse * 200000);
                        System.out.printf(Locale.US, currentPropertyTile.name + " costs RM%,d.\n", (currentPropertyTile.numOfHouse * 200000));
                    }
                }
            }
            if (generalRepairTotal == 0)
                break;
            System.out.printf(Locale.US, player.name + " the total for the repair is RM%,d.\n", generalRepairTotal);
            if (generalRepairTotal >= player.money) {
                System.out.println("You don't have enough money to pay the repair on the houses.");
                sellingProperties(player, generalRepairTotal, true, false, null);
                if (!player.bankruptcy && generalRepairTotal < player.money) {
                    player.money -= generalRepairTotal;
                    System.out.printf(Locale.US, player.name + " successfully paid RM%,d.\n", generalRepairTotal);
                    toString += String.format(player.name + " has paid RM%,d to the Creator.\n", generalRepairTotal);
                    player.toString = toString;
                }
            } else {
                player.money -= generalRepairTotal;
                System.out.printf(Locale.US, player.name + " successfully paid RM%,d.\n", generalRepairTotal);
                toString += String.format(player.name + " has paid RM%,d to the Creator.\n", generalRepairTotal);
                player.toString = toString;
            }
            break;
            case 7:
            System.out.println("Pay hospital fees of RM250,000.");
            toString += player.name + " drew a \"Pay Hospital Fees\" card.\n";
            if (250000 >= player.money) {
                System.out.println("You don't have enough money to pay the hospital fees.");
                sellingProperties(player, 250000, true, false, null);
                if (!player.bankruptcy && 250000 < player.money) {
                    player.money -= 250000;
                    System.out.println(player.name + " successfully paid the hospital fees.");
                    toString += player.name + " has paid RM250,000 to the Creator.\n";
                    player.toString = toString;
                }
            } else {
                player.money -= 250000;
                System.out.println(player.name + " successfully paid the hospital fees.");
                toString += player.name + " has paid RM250,000 to the Creator.\n";
                player.toString = toString;
            }
            break;
            case 8:
            System.out.println("Pay school fees of RM100,000.");
            toString += player.name + " drew a \"Pay School Fees\" card.\n";
            if (100000 >= player.money) {
                System.out.println("You don't have enough money to pay the school fees.");
                sellingProperties(player, 100000, true, false, null);
                if (!player.bankruptcy && 100000 < player.money) {
                    player.money -= 100000;
                    System.out.println(player.name + " successfully paid the school fees.");
                    toString += player.name + " has paid RM100,000 to the Creator.\n";
                    player.toString = toString;
                }
            } else {
                player.money -= 100000;
                System.out.println(player.name + " successfully paid the school fees.");
                toString += player.name + " has paid RM100,000 to the Creator.\n";
                player.toString = toString;
            }
            break;
            case 9:
            System.out.println("Pay speeding fine of RM100,000.");
            toString += player.name + " drew a \"Pay Speeding Fine\" card.\n";
            if (100000 >= player.money) {
                System.out.println("You don't have enough money to pay the speeding fine.");
                sellingProperties(player, 100000, true, false, null);
                if (!player.bankruptcy && 100000 < player.money) {
                    player.money -= 100000;
                    System.out.println(player.name + " successfully paid the speeding fine.");
                    toString += player.name + " has paid RM100,000 to the Creator.\n";
                    player.toString = toString;
                }
            } else {
                player.money -= 100000;
                System.out.println(player.name + " successfully paid the speeding fine.");
                toString += player.name + " has paid RM100,000 to the Creator.\n";
                player.toString = toString;
            }
            break;
            default:
            fateCardOutcome(player);
        }
    }

    public void fateCardRailRoad(Player player, Object currentTile) {
        specialTile = (MiniSpecialTile) currentTile;
        System.out.println(player.name + " landed on " + specialTile.name);
        toString += player.name + " landed on " + specialTile.name + ".\n";
        if (player.buyProperty) {
            if (specialTile.owner == null && !player.hasLoan) {
                System.out.printf(Locale.US, "Do you want to buy " + specialTile.name + " for RM%,d? (Y/N):", specialTile.cost);
                String choice = keyboard.nextLine();
                if (choice.equalsIgnoreCase("Y")) {
                    if (specialTile.cost >= player.money) {
                        System.out.println("Not enough money to buy " + specialTile.name + ".");
                        if (canSell(player)) {
                            sellingProperties(player, specialTile.cost, false, false, null);
                            if (!player.bankruptcy && specialTile.cost < player.money) {
                                player.money -= specialTile.cost;
                                specialTile.owner = player;
                                System.out.println(player.name + " bought " + specialTile.name + ".");
                                toString += player.name + " bought " + specialTile.name + ".\n";
                                player.toString = toString;
                            }
                        } else
                            playerLoan(player, specialTile.cost, false);
                    } else {
                        player.money -= specialTile.cost;
                        specialTile.owner = player;
                        System.out.println(player.name + " bought " + specialTile.name + ".");
                        toString += player.name + " bought " + specialTile.name + ".\n";
                        player.toString = toString;
                    }
                }
            } else if (specialTile.owner != player) {
                System.out.println(specialTile.name + " is owned by " + specialTile.owner.name + ".");
                System.out.printf(player.name + " has to pay double of rent for RM%,d.\n", (specialTile.baseRent * 2));
                if ((specialTile.baseRent * 2) >= player.money) {
                    System.out.println("You don't have enough money to pay the rent.");
                    sellingProperties(player, (specialTile.baseRent * 2), false, true, specialTile.owner);
                    if (!player.bankruptcy && (specialTile.baseRent * 2) < player.money) {
                        player.money -= (specialTile.baseRent * 2);
                        specialTile.owner.money += (specialTile.baseRent * 2);
                        System.out.println(player.name + " successfully paid the rent.");
                        toString += player.name + " has paid RM%,d to " + specialTile.owner.name + ".\n";
                        player.toString = toString;
                    }
                } else {
                    player.money -= (specialTile.baseRent * 2);
                    specialTile.owner.money += (specialTile.baseRent * 2);
                    System.out.println(player.name + " successfully paid the rent.");
                    toString += player.name + " has paid RM%,d to " + specialTile.owner.name + ".\n";
                    player.toString = toString;
                }
            } else if (specialTile.owner == player) {
                System.out.println(player.name + " is vitising his tile.");
                player.toString = toString;
            }
        }
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
        player.propertySellCheck = true;
        boolean hasPaid = false;
        int tileCount, houseCount, specialTileCount, tileCost, houseCost, specialTileCost;
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
            player.toString = toString;
            playerLoan(player, cost, creatorDebt);
            if (!player.bankruptcy) {
                player.propertySellCheck = false;
                hasPaid = true;
            }
        }
        while (player.propertySellCheck) {
            tileCount = 0;
            houseCount = 0;
            tileCost = 0;
            houseCost = 0;
            specialTileCount = 0;
            specialTileCost = 0;
            for (Object currentTile : tiles) {
                if (currentTile instanceof MiniTile) {
                    MiniTile currentPropertyTile = (MiniTile) currentTile;
                    if (currentPropertyTile.owner == player) {
                        tileCount++;
                        tileCost += currentPropertyTile.cost;
                        houseCount += currentPropertyTile.numOfHouse;
                        houseCost += (currentPropertyTile.numOfHouse * 200000);
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
            if (houseCount > 0 && cost >= player.money && playerDebt) {
                int count = 0, choice;
                System.out.println("\nYou have a total asset of " + houseCount + " house(s).");
                System.out.println("Each and every property sold back to the creator, the owner will only get one-half(1/2) of it back.");
                System.out.printf(Locale.US, "You have a total of RM%,.0f in house(s) (after Creator's cut).\n", (houseCost * 0.5));
                System.out.printf(Locale.US, "You have to sell atleast RM%,d.\n", (cost - player.money));
                System.out.println("You may choose from which property you want to sell the houses from.");
                for (MiniTile currentPropertyTile : propertySelector) {
                    count++;
                    System.out.println(count + ". " + currentPropertyTile.name + ": " + currentPropertyTile.numOfHouse + " house(s).");
                }
                while (true) {
                    System.out.print("Property choice. (1 - " + count + "): ");
                    choice = keyboard.nextInt();
                    keyboard.nextLine();
                    MiniTile currentPropertyTile = propertySelector.get(choice - 1);
                    while ((choice < 0 || choice > count) || currentPropertyTile.numOfHouse < 1) {
                        System.out.print("Please pick again. : ");
                        choice = keyboard.nextInt();
                        keyboard.nextLine();
                    }
                    currentPropertyTile = propertySelector.get(choice - 1);
                    System.out.print("How much do you want to sell? (" + currentPropertyTile.numOfHouse + " max) : ");
                    int houseSell = keyboard.nextInt();
                    keyboard.nextLine();
                    while (houseSell < 0 || houseSell > currentPropertyTile.numOfHouse) {
                        System.out.print("Please pick again. : ");
                        houseSell = keyboard.nextInt();
                        keyboard.nextLine();
                    }
                    int sellAmount = houseSell * 100000;
                    System.out.println(player.name + " successfully sold " + houseSell + " houses.");
                    player.money += sellAmount;
                    currentPropertyTile.numOfHouse -= houseSell;
                    houseCount -= houseSell;
                    if (cost >= player.money && houseCount > 0)
                        System.out.printf("\nPlease choose another property to sell houses (RM%,d more).\n", (cost - player.money));
                    else if (cost >= player.money && houseCount == 0) {
                        System.out.println("You have no more houses to sell.");
                        playerLoan(player, cost, playerDebt);
                        if (player.bankruptcy) {
                            player.propertySellCheck = false;
                            System.out.println("You have to turn over all your asset to the owner of the tile.");
                            toString += player.name + " has turned over all their assets to the owner of the tile.\n";
                            player.toString = toString;
                            for (Object currentTile : tiles) {
                                if (currentTile instanceof MiniTile) {
                                    MiniTile changeOwnerPropertyTile = (MiniTile) currentTile;
                                    if (changeOwnerPropertyTile.owner == player)
                                        changeOwnerPropertyTile.owner = tileOwner;
                                }
                                if (currentTile instanceof MiniSpecialTile) {
                                    MiniSpecialTile changeOwnerSpecialTile = (MiniSpecialTile) currentTile;
                                    if (changeOwnerSpecialTile.owner == player)
                                        changeOwnerSpecialTile.owner = tileOwner;
                                }
                            }
                            break;
                        } else {
                            System.out.printf(player.name + " has successfully paid the owner for RM%,d\n", cost);
                            toString += player.name + " has paid RM%,d to " + tileOwner.name + ".\n";
                            player.toString = toString;
                            player.propertySellCheck = false;
                            hasPaid = true;
                            break;
                        }
                    } else {
                        System.out.printf(player.name + " has successfully paid the owner for RM%,d\n", cost);
                        toString += player.name + " has paid RM%,d to " + tileOwner.name + ".\n";
                        player.toString = toString;
                        player.propertySellCheck = false;
                        hasPaid = true;
                        break;
                    }
                }
            } else if (houseCount > 0 && cost >= player.money && !playerDebt) {
                int count = 0, choice, totalHouseSold = 0;
                System.out.println("\nYou have a total asset of " + houseCount + " house(s).");
                System.out.println("Each and every property sold back to the creator, the owner will only get one-half(1/2) of it back.");
                System.out.printf(Locale.US, "You have a total of RM%,.0f in house(s) (after Creator's cut).\n", (houseCost * 0.5));
                System.out.printf(Locale.US, "You have to sell atleast RM%,d.\n", (cost - player.money));
                System.out.println("You may choose from which property you want to sell the houses from.");
                for (MiniTile currentPropertyTile : propertySelector) {
                    count++;
                    System.out.println(count + ". " + currentPropertyTile.name + ": " + currentPropertyTile.numOfHouse + " house(s).");
                }
                while (true) {
                    System.out.print("Property choice. (1 - " + count + "): ");
                    choice = keyboard.nextInt();
                    keyboard.nextLine();
                    MiniTile currentPropertyTile = propertySelector.get(choice - 1);
                    while (choice < 0 || choice > count && propertyTile.numOfHouse == 0) {
                        System.out.print("Please pick again. : ");
                        choice = keyboard.nextInt();
                        keyboard.nextLine();
                    }
                    currentPropertyTile = propertySelector.get(choice - 1);
                    System.out.print("How much do you want to sell? (" + currentPropertyTile.numOfHouse + " max) : ");
                    int houseSell = keyboard.nextInt();
                    keyboard.nextLine();
                    while (houseSell < 0 || houseSell > currentPropertyTile.numOfHouse) {
                        System.out.print("Please pick again. : ");
                        houseSell = keyboard.nextInt();
                        keyboard.nextLine();
                    }
                    int sellAmount = houseSell * 100000;
                    System.out.println(player.name + " successfully sold " + houseSell + " houses.");
                    player.money += sellAmount;
                    currentPropertyTile.numOfHouse -= houseSell;
                    houseCount -= houseSell;
                    totalHouseSold += houseSell;
                    if (cost >= player.money && houseCount > 0)
                        System.out.printf("\nPlease choose another property to sell houses (RM%,d more).\n", (cost - player.money));
                    else if (cost >= player.money && houseCount == 0) {
                        System.out.println("You have no more houses to sell.");
                        toString += player.name + " has sold " + totalHouseSold + " house(s).\n";
                        break;
                    } else {
                        player.propertySellCheck = false;
                        hasPaid = true;
                        toString += player.name + " has sold " + totalHouseSold + " house(s).\n";
                        player.toString = toString;
                        break;
                    }
                }
            }
            if (tileCount > 0 && cost >= player.money && !playerDebt) {
                int count = 0, choice, totalTileSold = 0;
                System.out.println("You have a total asset of " + tileCount + " in land(s) and " + specialTileCount + " in railroad(s).");
                System.out.println("Each and every property sold back to the creator, the owner will only get one-half(1/2) of it back.");
                System.out.printf(Locale.US, "You have a total of RM%,.0f in land(s) and RM%,.0f in railroad(s).\n", (tileCost * 0.5), (specialTileCost * 0.5));
                System.out.printf(Locale.US, "You have to sell atleast RM%,d.\n", (cost - player.money));
                System.out.println("You may choose from which property you want to sell the house from.");
                System.out.println("Property Tile(s).");
                for (MiniTile currentPropertyTile : propertySelector) {
                    count++;
                    System.out.printf(count + ". " + currentPropertyTile.name + ": RM%,.0f\n", (currentPropertyTile.cost * 0.5));
                }
                if (specialTileCount > 0) {
                    System.out.println("Special Tile(s).");
                    for (MiniSpecialTile currentSpecialTile : specialTileSelector) {
                        count++;
                        System.out.printf(count + ". " + currentSpecialTile.name + ": RM%,.0f\n", (currentSpecialTile.cost * 0.5));
                    }
                }
                while (true) {
                    System.out.print("Property choice. (1 - " + count + "): ");
                    choice = keyboard.nextInt();
                    keyboard.nextLine();
                    while (choice < 0 || choice > count) {
                        System.out.print("Please pick again. : ");
                        choice = keyboard.nextInt();
                        keyboard.nextLine();
                    }
                    if (choice <= propertySelector.size()) {
                        MiniTile currentPropertyTile = propertySelector.get(choice - 1);
                        System.out.println(currentPropertyTile.name + " has been sold.");
                        currentPropertyTile.owner = null;
                        tileCount--;
                        player.money += (int) (currentPropertyTile.cost * 0.5);
                        totalTileSold++;
                    } else {
                        MiniSpecialTile currentSpecialTile = specialTileSelector.get(choice - 1 - propertySelector.size());
                        System.out.println(currentSpecialTile.name + " has been sold.");
                        currentSpecialTile.owner = null;
                        specialTileCount--;
                        player.money += (int) (currentSpecialTile.cost * 0.5);
                        totalTileSold++;
                    }
                    if (cost >= player.money && (tileCount > 0 || specialTileCount > 0))
                        System.out.printf("\nPlease choose another property to sell (RM%,d more).\n", cost - player.money);
                    else if (cost >= player.money && tileCount == 0 && specialTileCount == 0) {
                        System.out.println("You no longer have properties to sell.");
                        player.propertySellCheck = false;
                        toString += player.name + " has sold " + totalTileSold + ".\n";
                        player.toString = toString;
                        break;
                    } else {
                        player.propertySellCheck = false;
                        hasPaid = true;
                        toString += player.name + " has sold " + totalTileSold + ".\n";
                        player.toString = toString;
                        break;
                    }
                }
            }
            if (!hasPaid) {
                System.out.println("You can't afford to pay that much!");
                playerLoan(player, cost, false);
                player.propertySellCheck = false;
            }
        }
    }

    public void playerLoan(Player player, int cost, boolean debtCheck) {
        if (!player.hasLoan) {
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
                player.toString = toString;
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
                    player.toString = toString;
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
                            player.toString = toString;
                        }
                        if (player.loanAmount == 0) {
                            System.out.println(player.name + " has successfully paid the loan back in full.");
                            player.hasLoan = false;
                            player.loanPeriod = 0;
                            toString += player.name + " has paid the loan in full.\n";
                            player.toString = toString;
                        }
                    }
                }
            }
            if (player.hasLoan && player.loanPeriodCheck && !player.bankruptcy) {
                System.out.println("Your loan will continue on for another " + (3 - player.loanPeriod) + " moves.");
                player.loanPeriodCheck = false;
            }
        }
    }

    public void bankrupt(Player player) {
        if (player.bankruptcy) {
            System.out.println(player.name + " has already declared bankruptcy");
        } else {
            System.out.println(player.name + " has declared bankruptcy.");
            toString += player.name + " has declared bankruptcy.\n";
            player.toString = toString;
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
    }

    Board() {
    SwingUtilities.invokeLater(() -> {

        //Any declarations add here
        yCordsPlayerLog = 140;
        currentPlayerIndex = -1;
        keyboard = new Scanner(System.in);
        playerLogs = new ArrayList<>();
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
        // PlayerLogHistory playerLog1 = new PlayerLogHistory(1500,140,this,playerName1);
        // PlayerLogHistory playerLog2 = new PlayerLogHistory(1500,300,this,playerName2);
        // PlayerLogHistory playerLog3 = new PlayerLogHistory(1500,460,this,playerName3);
        // PlayerLogHistory playerLog4 = new PlayerLogHistory(1500,620,this,playerName1);
        // PlayerLogHistory playerLog5 = new PlayerLogHistory(1500,780,this, playerName1);
        
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
        buttonBuy.setEnabled(false);
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
        initializePlayerCard();
        });
    }
    public void playerCardUpdate() {
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
        }
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==buttonRoll){
            buttonRoll.setEnabled(false);
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            currentPlayer = players.get(currentPlayerIndex);
            currentPlayer.toString = "";
            // roll for 3 seconds
            long startTime = System.currentTimeMillis();
            Thread rollThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    long endTime = System.currentTimeMillis();
                    try {
                        while ((endTime - startTime) / 1000F < 0.5) {
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
                        currentPlayer.position = (currentPlayer.position + sum) % tiles.size();
                        Object currentTile = tiles.get(currentPlayer.position);
                        duitriaBoard(currentPlayer, currentTile, previousPlayerPosition, sum);
                        playerCardUpdate();
                        playerLogHistory(currentPlayer);
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
            buttonLoan.setEnabled(false);
        }

        if (e.getSource() == buttonBuy) {
            buttonBuy.setEnabled(false);
            if (playerCurrentTile instanceof MiniTile) {
                propertyTile = (MiniTile) playerCurrentTile;
                if (propertyTile.cost >= currentPlayer.money) {
                    System.out.println("Not enough money to buy " + propertyTile.name + ".");
                    if (canSell(currentPlayer)) {
                        System.out.printf("Do you want to sell assets to buy this land? (Y/N):");
                        String sellChoice = keyboard.nextLine();
                        if (sellChoice.equalsIgnoreCase("Y")) {
                            sellingProperties(currentPlayer, propertyTile.cost, false, false, null);
                            if (!currentPlayer.bankruptcy && propertyTile.cost < currentPlayer.money) {
                                currentPlayer.money -= propertyTile.cost;
                                propertyTile.owner = currentPlayer;
                                System.out.println(currentPlayer.name + " bought " + propertyTile.name + ".");
                                toString += currentPlayer.name + " has bought " + propertyTile.name + ".\n";
                                currentPlayer.toString = toString;
                            }
                        }
                    } else 
                        playerLoan(currentPlayer, propertyTile.cost, false);
                } else {
                    currentPlayer.money -= propertyTile.cost;
                    propertyTile.owner = currentPlayer;
                    System.out.println(currentPlayer.name + " bought " + propertyTile.name + ".");
                    toString += currentPlayer.name + " has bought " + propertyTile.name + ".\n";
                    currentPlayer.toString = toString;
                }
            } else {
                if (specialTile.cost >= currentPlayer.money) {
                    System.out.println("You do not enough money to buy " + specialTile.name + ".");
                    if (canSell(currentPlayer)) {
                        sellingProperties(currentPlayer, specialTile.cost, false, false, null);
                        if (!currentPlayer.bankruptcy && specialTile.cost < currentPlayer.money) {
                            currentPlayer.money -= specialTile.cost;
                            specialTile.owner = currentPlayer;
                            System.out.println(currentPlayer.name + " bought " + specialTile.name + ".");
                            toString += currentPlayer.name + " has bought " + specialTile.name + ".\n";
                            currentPlayer.toString = toString;
                        }
                    } else
                        playerLoan(currentPlayer, specialTile.cost, false);
                } else {
                    currentPlayer.money -= specialTile.cost;
                    specialTile.owner = currentPlayer;
                    System.out.println(currentPlayer.name + " bought " + specialTile.name + ".");
                    toString += currentPlayer.name + " has bought " + specialTile.name + ".\n";
                    currentPlayer.toString = toString;
                }
            }
            playerCardUpdate();
        }

        if (e.getSource() == buttonSell){
            buttonSell.setEnabled(false);
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

class PlayerCard extends JPanel {

    String playerName;
    double playerLand;
    double playerMoney;
    String playerStatus;
    JLabel labelPlayerMoney = new JLabel();
    JLabel labelPlayerLand = new JLabel();
    JLabel labelPlayerStatus = new JLabel();
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

            labelPlayerMoney.setText("Money : RM " + this.playerMoney);
            labelPlayerMoney.setBounds(5, 5, 375, 36); 
            labelPlayerMoney.setFont(new Font("Arial", Font.ITALIC, 30));
            panelPlayerDescription.add(labelPlayerMoney);

            labelPlayerLand.setText("Land : " + this.playerLand);
            labelPlayerLand.setBounds(5, 42, 375, 36); 
            labelPlayerLand.setFont(new Font("Arial", Font.ITALIC, 30));
            panelPlayerDescription.add(labelPlayerLand);

            labelPlayerStatus.setText("Status : " + this.playerStatus);
            labelPlayerStatus.setBounds(5, 79, 375, 36); 
            labelPlayerStatus.setFont(new Font("Arial", Font.ITALIC, 30));
            panelPlayerDescription.add(labelPlayerStatus);

            
        });
    }

    //Not set player money , land and status yet
    PlayerCard(int x, int y, JFrame frame, Player player, List<Object> tiles) {
        SwingUtilities.invokeLater(() -> {
            
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

            String moneyFormat = String.format("Money : RM%,d", player.money);
            labelPlayerMoney.setText(moneyFormat);
            labelPlayerMoney.setBounds(5, 5, 375, 36); 
            labelPlayerMoney.setFont(new Font("Arial", Font.ITALIC, 30));
            panelPlayerDescription.add(labelPlayerMoney);

            labelPlayerLand.setText("Land : 0");
            labelPlayerLand.setBounds(5, 42, 375, 36); 
            labelPlayerLand.setFont(new Font("Arial", Font.ITALIC, 30));
            panelPlayerDescription.add(labelPlayerLand);

            labelPlayerStatus.setText("Status : " + (player.bankruptcy ? "Bankrupt" : (player.hasLoan ? "Has Loan" : "Active Player")));
            labelPlayerStatus.setBounds(5, 79, 375, 36); 
            labelPlayerStatus.setFont(new Font("Arial", Font.ITALIC, 30));
            panelPlayerDescription.add(labelPlayerStatus);
            
        });
    }
}



 class PlayerLogHistory extends JPanel {
    
    PlayerLogHistory(int x, int y, JFrame frame, Player player){
        SwingUtilities.invokeLater(() -> {

            Border border = BorderFactory.createLineBorder(Color.BLACK,1);
            this.setBackground(Color.LIGHT_GRAY);
            this.setBounds(x, y, 420, 150);
            this.setBorder(border);
            this.setLayout(null);
            frame.add(this);

            JPanel panelPlayerLogMove = new JPanel();
            panelPlayerLogMove.setBounds(0, 0, 420, 50); // Set bounds for the panel
            // panelPlayerLogMove.setBorder(border); // Set a background color for visibility
            panelPlayerLogMove.setBackground(Color.LIGHT_GRAY);
            JLabel labelPlayerMove = new JLabel();
            labelPlayerMove.setText(player.name + " moves To Tile " + player.position);
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
            
            labelPlayerLogDescription.setText(player.toString);
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