
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
import java.io.*;
import java.util.*;

public class Board extends JFrame implements ActionListener {
    
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
    
    private List<Player> players;
    private List<Object> tiles;
    private List<playerCard> playerCards;
    private int currentPlayerIndex;
    private Scanner keyboard;
    private Random rand;

    public void setName(String name1, String name2, String name3, String name4){
        playerName1 = name1;
        playerName2 = name2;
        playerName3 = name3;
        playerName4 = name4;
    }

    private void initializePlayers(int playerNum) {
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

    private void sortedPlayerTurn() {
        int count = 1;
        Map<String, Integer> playerTurn = new HashMap<>();
        Set<Integer> uniqueDiceRoll = new HashSet<>();
        for (Player player : players) {
            int diceRoll1, diceRoll2;
            do {
                diceRoll1 = rand.nextInt(6) + 1;
                diceRoll2 = rand.nextInt(6) + 1;
            } while (uniqueDiceRoll.contains(diceRoll1 + diceRoll2));
            player.diceRoll = diceRoll1 + diceRoll2;
            uniqueDiceRoll.add(diceRoll1 + diceRoll2);
            playerTurn.put(player.name,diceRoll1 + diceRoll2);
        }
        players.sort(Comparator.comparingInt(player -> playerTurn.get(player.name)));
        // PANEL POP UP FOR PLAYER'S TURN
        for(Player player : players) {
            System.out.println("Player " + count + " is " + player.name + ".");
            count++;
        }
    }

    private void initializeTile(JPanel panelBoard, Border border) {
        // BOTTOM RIGHT
        tiles.add(new GoCornerTile(panelBoard, border, "Go",2000000));
        // BOTTOM TILE
        tiles.add(new TileUpAndBottom(766, 842, panelBoard, "src\\duitria.tiles\\1 PETALING STREET.png", "Petaling Street",600000 ,60000 ,"Green"));
        tiles.add(new FateCardUpAndBottom(690, 842, panelBoard,"src\\duitria.tiles\\FATE NORMAL.png", "Fate"));
        tiles.add(new TileUpAndBottom(614,842, panelBoard,"src\\duitria.tiles\\2 JONKER STREET.png", "Jonker Street",600000 ,60000 ,"Green"));
        tiles.add(new TaxUpAndBottom(538,842, panelBoard,"src\\duitria.tiles\\TAX.png", "Tax",2000000 ));
        tiles.add(new SpecialTileUpAndBottom(462,842, panelBoard,"src\\duitria.tiles\\3 KLIA.png", "KLIA",2000000 ,200000));
        tiles.add(new TileUpAndBottom(386,842, panelBoard,"src\\duitria.tiles\\4 MASJID JAMEK.png", "Masjid Jamek",1000000 ,100000 ,"Blue"));
        tiles.add(new FateCardUpAndBottom(310,842, panelBoard,"src\\duitria.tiles\\FATE NORMAL.png", "Fate Card"));
        tiles.add(new TileUpAndBottom(234,842, panelBoard,"src\\duitria.tiles\\5 BATU CAVES.png", "Batu Caves",1000000 ,100000 ,"Blue"));
        tiles.add(new TileUpAndBottom(158,842, panelBoard,"src\\duitria.tiles\\6 SRI MAHA MARIAMMAN TEMPLE.png", "Siri Maha Mariamman Temple",1200000 ,120000 ,"Blue"));
        // BOTTOM LEFT
        tiles.add(new JailCornerTile(panelBoard, border, "Jail"));
        // LEFT TILE
        tiles.add(new TileLeftAndRight(0,766, panelBoard,"src\\duitria.tiles\\7 NATIONAL MUSEUM.png", "National Museum",1400000 ,140000 ,"Maroon"));
        tiles.add(new TileLeftAndRight(0,690, panelBoard,"src\\duitria.tiles\\8 TENAGA NASIONAL BERHAD.png", "Tenaga Nasional Berhad",1500000 ,150000, "No Colour"));
        tiles.add(new TileLeftAndRight(0,614, panelBoard,"src\\duitria.tiles\\9 ROYAL PALACE.png", "Royal Palace",1400000 ,140000 ,"Maroon"));
        tiles.add(new TileLeftAndRight(0,538, panelBoard,"src\\duitria.tiles\\10 MERDEKA SQUARE.png", "Merdeka Square",1400000 ,140000 ,"Maroon"));
        tiles.add(new SpecialTileLeftAndRight(0,462, panelBoard,"src\\duitria.tiles\\11 KLIA 2.png", "KLIA 2",2000000 ,200000));
        tiles.add(new TileLeftAndRight(0,386, panelBoard,"src\\duitria.tiles\\12 A FAMOSA FORT.png", "A'Famosa Resort",1700000 ,170000, "Light Blue"));
        tiles.add(new FateCardLeftAndRight(0,310, panelBoard,"src\\duitria.tiles\\FATE LEFT.png", "Fate Card"));
        tiles.add(new TileLeftAndRight(0,234, panelBoard,"src\\duitria.tiles\\13 KELLIE CASTLE.png", "Kellie Castle",1800000 ,180000, "Light Blue"));
        tiles.add(new TileLeftAndRight(0,158, panelBoard,"src\\duitria.tiles\\14 STADTHUYS.png", "Stadthuys",2000000 ,200000, "Light Blue"));
        // TOP LEFT
        tiles.add(new FreeParkingCornerTile(panelBoard, border, "Free Parking"));
        // UP TILE
        tiles.add(new TileUpAndBottom(158,0, panelBoard,"src\\duitria.tiles\\15 FRASER'S HILL.png", "Fraser's Hill",2200000 ,220000, "Purple"));
        tiles.add(new FateCardUpAndBottom(234,0, panelBoard,"src\\duitria.tiles\\FATE INVERTED.png", "Fate Card"));
        tiles.add(new TileUpAndBottom(310,0, panelBoard,"src\\duitria.tiles\\16 CAMERON HIGHLANDS.png", "Cameron Highlands",2200000 ,220000, "Purple"));
        tiles.add(new TileUpAndBottom(386,0, panelBoard,"src\\duitria.tiles\\17 GENTING HIGHLAND.png", "Genting Highland",2400000 ,240000, "Purple"));
        tiles.add(new SpecialTileUpAndBottom(462,0, panelBoard,"src\\duitria.tiles\\18 KL SENTRAL STATION.png", "KL Sentral Station",2000000 ,200000));
        tiles.add(new TileUpAndBottom(538,0, panelBoard,"src\\duitria.tiles\\19 PAHANG NATIONAL PARK.png", "Pahang National Park",2600000 ,260000 ,"Orange"));
        tiles.add(new TileUpAndBottom(614,0, panelBoard,"src\\duitria.tiles\\20 JABATAN BEKALAN AIR.png", "Jabatan Bekalan Air",2600000 ,150000, "No Colour"));
        tiles.add(new TileUpAndBottom(690,0, panelBoard,"src\\duitria.tiles\\21 GUNUNG MULU NATIONAL PARK.png", "Gunung Mulu National Park",2700000 ,260000 ,"Orange"));
        tiles.add(new TileUpAndBottom(766,0, panelBoard,"src\\duitria.tiles\\22 KINABALU NATIONAL PARK.png", "Kinabalu National Park", 600000 ,270000 ,"Orange"));
        // TOP RIGHT
        tiles.add(new GoToJailCornerTile(panelBoard, border, "Go To Jail"));
        // RIGHT TILE
        tiles.add(new TileLeftAndRight(842,158, panelBoard,"src\\duitria.tiles\\23 TIOMAN ISLANDS.png", "Tioman Islands",3000000 ,300000 ,"Red"));
        tiles.add(new TileLeftAndRight(842,234, panelBoard,"src\\duitria.tiles\\24 PERHENTIAN ISLANDS.png", "Perhentian Islands",3000000 ,300000 ,"Red"));
        tiles.add(new FateCardLeftAndRight(842,310,panelBoard,"src\\duitria.tiles\\FATE RIGHT.png", "Fate Card"));
        tiles.add(new TileLeftAndRight(842,386, panelBoard,"src\\duitria.tiles\\25 SEPADAN ISLANDS.png", "Sepadan Islands",3200000 ,320000 ,"Red"));
        tiles.add(new SpecialTileLeftAndRight(842,462, panelBoard,"src\\duitria.tiles\\26 PUDU SENTRAL STATION.png", "Pudu Sentral Station",2000000 ,200000));
        tiles.add(new FateCardLeftAndRight(842,538, panelBoard,"src\\duitria.tiles\\FATE RIGHT.png", "Fate Card"));
        tiles.add(new TileLeftAndRight(842,614, panelBoard,"src\\duitria.tiles\\27 KLCC.png", "KLCC",3500000 ,350000, "Yellow"));
        tiles.add(new TaxLeftAndRight(842,690, panelBoard,"src\\duitria.tiles\\TAX 2.png", "Tax",2000000));
        tiles.add(new TileLeftAndRight(842,766, panelBoard,"src\\duitria.tiles\\28 SEPANG II CIRCUIT.png", "Sepang II Circuit",4000000 ,400000, "Yellow"));
    }
    
    void playGame() {
        int diceRoll1, diceRoll2, diceRoll;
        keyboard = new Scanner(System.in);
        boolean gameRunning = true;
        while (gameRunning) {
            Player currentPlayer = players.get(currentPlayerIndex);
            if (currentPlayer.jailCheck) {
                System.out.print(currentPlayer.name + " is in the jail. Rolling doubles to get out of jail or pay RM250,000. Press Enter to roll the dice.");
                keyboard.nextLine();
                diceRoll1 = rand.nextInt(6) + 1;
                diceRoll2 = rand.nextInt(6) + 1;
                if (diceRoll1 == diceRoll2) {
                    System.out.println(currentPlayer.name + " managed to roll a double of " + diceRoll1 + "!");
                    currentPlayer.jailCheck = false;
                    diceRoll = diceRoll1 + diceRoll2;
                    currentPlayer.position += diceRoll;
                    playerTurn(currentPlayer, diceRoll);
                } else {
                    System.out.println("Sorry " + currentPlayer.name + ", you rolled a " + diceRoll1 + " and " + diceRoll2 + ", you have to pay RM250,000.");
                    if (250000 >= currentPlayer.money) {
                        sellingProperties(currentPlayer, 250000, true, false, null);
                        if (!currentPlayer.bankruptcy) {
                            System.out.println(currentPlayer.name + " successfully paid the jail fines.");
                            currentPlayer.money -= 250000;
                            currentPlayer.jailCheck = false;
                        }
                    } else {
                        System.out.println(currentPlayer.name + " successfully paid the jail fines.");
                        currentPlayer.money -= 250000;
                        currentPlayer.jailCheck = false;
                    }
                    diceRoll = diceRoll1 + diceRoll2;
                    currentPlayer.position += diceRoll;
                    playerTurn(currentPlayer, diceRoll);
                }
            } else if (currentPlayer.bankruptcy) {
                int count = 0;
                System.out.println(currentPlayer.name + " has already declared bankrupty.");
                for (Player player : players) {
                    if (!player.bankruptcy)
                        count++;
                }
                System.out.println(count + " more player remaining in the game.");
            } else {
                playerTurn(currentPlayer,0);
            }
            if (onePlayerLeft() == 1) {
                for (Player player : players) {
                    if (!player.bankruptcy) {
                        System.out.println(player.name + " wins!");
                        gameRunning = false;
                    }
                }
            }
            if (currentPlayer.hasLoan) {
                currentPlayer.loanPeriodCheck = true;
                playerLoan(currentPlayer, 0, false);
            }
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
        System.out.println("DuitRia has come to an end, thanks for playing!");
    }

    private boolean canSell(Player player) {
        int tileCount = 0, houseCount = 0, specialTileCount = 0;
        for (Object currentTile : tiles) {
            if (currentTile instanceof Tile) {
                Tile propertyTile = (Tile) currentTile;
                if (propertyTile.owner == player) {
                    tileCount++;
                    houseCount += propertyTile.numOfHouse;
                }
            }
            if (currentTile instanceof SpecialTile) {
                SpecialTile specialTile = (SpecialTile) currentTile;
                if (specialTile.owner == player) {
                    specialTileCount++;
                }
            }
        }
        if (tileCount > 0 || specialTileCount > 0 || houseCount > 0)
            return true;
        else
            return false;
    }

    private void sellingProperties(Player player, int cost, boolean creatorDebt, boolean playerDebt, Player tileOwner) { 
        List<Tile> propertySelector = new ArrayList<>();
        List<SpecialTile> specialTileSelector = new ArrayList<>();
        player.propertySellCheck = true;
        boolean hasPaid = false;
        int tileCount, houseCount, specialTileCount, tileCost, houseCost, specialTileCost;
        if (creatorDebt) {
            for (Object currentTile : tiles) {
                if (currentTile instanceof Tile) {
                    Tile propertyTile = (Tile) currentTile;
                    if (propertyTile.owner == player) {
                        propertyTile.numOfHouse = 0;
                        propertyTile.owner = null;
                        System.out.println(player.name + " has given up " + propertyTile.name + " to the Creator.");
                    }
                }
                if (currentTile instanceof SpecialTile) {
                    SpecialTile specialTile = (SpecialTile) currentTile;
                    if (specialTile.owner == player) {
                        specialTile.owner = null;
                        System.out.println(player.name + " has given up " + specialTile.name + " to the Creator.");
                    }
                }
            }
            System.out.println("You can make a loan to not get kicked out from the game.");
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
                if (currentTile instanceof Tile) {
                    Tile propertyTile = (Tile) currentTile;
                    if (propertyTile.owner == player) {
                        tileCount++;
                        tileCost += propertyTile.cost;
                        houseCount += propertyTile.numOfHouse;
                        houseCost += (propertyTile.numOfHouse * 200000);
                        propertySelector.add(propertyTile);
                    }
                }
                if (currentTile instanceof SpecialTile) {
                    SpecialTile specialTile = (SpecialTile) currentTile;
                    if (specialTile.owner == player) {
                        specialTileCount++;
                        specialTileCost += specialTile.cost;
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
                for (Tile propertyTile : propertySelector) {
                    count++;
                    System.out.println(count + ". " + propertyTile.name + ": " + propertyTile.numOfHouse + " house(s).");
                }
                while (true) {
                    System.out.print("Property choice. (1 - " + count + "): ");
                    choice = keyboard.nextInt();
                    keyboard.nextLine();
                    Tile propertyTile = propertySelector.get(choice - 1);
                    while ((choice < 0 || choice > count) || propertyTile.numOfHouse < 1) {
                        System.out.print("Please pick again. : ");
                        choice = keyboard.nextInt();
                        keyboard.nextLine();
                    }
                    propertyTile = propertySelector.get(choice - 1);
                    System.out.print("How much do you want to sell? (" + propertyTile.numOfHouse + " max) : ");
                    int houseSell = keyboard.nextInt();
                    keyboard.nextLine();
                    while (houseSell < 0 || houseSell > propertyTile.numOfHouse) {
                        System.out.print("Please pick again. : ");
                        houseSell = keyboard.nextInt();
                        keyboard.nextLine();
                    }
                    int sellAmount = houseSell * 100000;
                    System.out.println(player.name + " successfully sold " + houseSell + " houses.");
                    player.money += sellAmount;
                    propertyTile.numOfHouse -= houseSell;
                    houseCount -= houseSell;
                    if (cost >= player.money && houseCount > 0)
                        System.out.printf("\nPlease choose another property to sell houses (RM%,d more).\n", (cost - player.money));
                    else if (cost >= player.money && houseCount == 0) {
                        System.out.println("You have no more houses to sell.");
                        playerLoan(player, cost, playerDebt);
                        if (player.bankruptcy) {
                            player.propertySellCheck = false;
                            System.out.println("You have to turn over all your asset to the owner of the tile.");
                            for (Object currentTile : tiles) {
                                if (currentTile instanceof Tile) {
                                    Tile currentPropertyTile = (Tile) currentTile;
                                    if (currentPropertyTile.owner == player)
                                        currentPropertyTile.owner = tileOwner;
                                }
                                if (currentTile instanceof SpecialTile) {
                                    SpecialTile currentSpecialTile = (SpecialTile) currentTile;
                                    if (currentSpecialTile.owner == player)
                                        currentSpecialTile.owner = tileOwner;
                                }
                            }
                            break;
                        } else {
                            System.out.printf(player.name + " has successfully paid the owner for RM%,d\n", cost);
                            player.propertySellCheck = false;
                            hasPaid = true;
                            break;
                        }
                    } else {
                        System.out.printf(player.name + " has successfully paid the owner for RM%,d\n", cost);
                        player.propertySellCheck = false;
                        hasPaid = true;
                        break;
                    }
                }
            } else if (houseCount > 0 && cost >= player.money && !playerDebt) {
                int count = 0, choice;
                System.out.println("\nYou have a total asset of " + houseCount + " house(s).");
                System.out.println("Each and every property sold back to the creator, the owner will only get one-half(1/2) of it back.");
                System.out.printf(Locale.US, "You have a total of RM%,.0f in house(s) (after Creator's cut).\n", (houseCost * 0.5));
                System.out.printf(Locale.US, "You have to sell atleast RM%,d.\n", (cost - player.money));
                System.out.println("You may choose from which property you want to sell the houses from.");
                for (Tile propertyTile : propertySelector) {
                    count++;
                    System.out.println(count + ". " + propertyTile.name + ": " + propertyTile.numOfHouse + " house(s).");
                }
                while (true) {
                    System.out.print("Property choice. (1 - " + count + "): ");
                    choice = keyboard.nextInt();
                    keyboard.nextLine();
                    Tile propertyTile = propertySelector.get(choice - 1);
                    while (choice < 0 || choice > count && propertyTile.numOfHouse == 0) {
                        System.out.print("Please pick again. : ");
                        choice = keyboard.nextInt();
                        keyboard.nextLine();
                    }
                    propertyTile = propertySelector.get(choice - 1);
                    System.out.print("How much do you want to sell? (" + propertyTile.numOfHouse + " max) : ");
                    int houseSell = keyboard.nextInt();
                    keyboard.nextLine();
                    while (houseSell < 0 || houseSell > propertyTile.numOfHouse) {
                        System.out.print("Please pick again. : ");
                        houseSell = keyboard.nextInt();
                        keyboard.nextLine();
                    }
                    int sellAmount = houseSell * 100000;
                    System.out.println(player.name + " successfully sold " + houseSell + " houses.");
                    player.money += sellAmount;
                    propertyTile.numOfHouse -= houseSell;
                    houseCount -= houseSell;
                    if (cost >= player.money && houseCount > 0)
                        System.out.printf("\nPlease choose another property to sell houses (RM%,d more).\n", (cost - player.money));
                    else if (cost >= player.money && houseCount == 0) {
                        System.out.println("You have no more houses to sell.");
                        break;
                    } else {
                        player.propertySellCheck = false;
                        hasPaid = true;
                        break;
                    }
                }
            }
            if (tileCount > 0 && cost >= player.money && !playerDebt) {
                int count = 0, choice;
                System.out.println("You have a total asset of " + tileCount + " in land(s) and " + specialTileCount + " in railroad(s).");
                System.out.println("Each and every property sold back to the creator, the owner will only get one-half(1/2) of it back.");
                System.out.printf(Locale.US, "You have a total of RM%,.0f in land(s) and RM%,.0f in railroad(s).\n", (tileCost * 0.5), (specialTileCost * 0.5));
                System.out.printf(Locale.US, "You have to sell atleast RM%,d.\n", (cost - player.money));
                System.out.println("You may choose from which property you want to sell the house from.");
                System.out.println("Property Tile(s).");
                for (Tile propertyTile : propertySelector) {
                    count++;
                    System.out.printf(count + ". " + propertyTile.name + ": RM%,.0f\n", (propertyTile.cost * 0.5));
                }
                if (specialTileCount > 0) {
                    System.out.println("Special Tile(s).");
                    for (SpecialTile specialTile : specialTileSelector) {
                        count++;
                        System.out.printf(count + ". " + specialTile.name + ": RM%,.0f\n", (specialTile.cost * 0.5));
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
                        Tile propertyTile = propertySelector.get(choice - 1);
                        System.out.println(propertyTile.name + " has been sold.");
                        propertyTile.owner = null;
                        tileCount--;
                        player.money += (int) (propertyTile.cost * 0.5);
                    } else {
                        SpecialTile specialTile = specialTileSelector.get(choice - 1 - propertySelector.size());
                        System.out.println(specialTile.name + " has been sold.");
                        specialTile.owner = null;
                        specialTileCount--;
                        player.money += (int) (specialTile.cost * 0.5);
                    }
                    if (cost >= player.money && (tileCount > 0 || specialTileCount > 0))
                        System.out.printf("\nPlease choose another property to sell (RM%,d more).\n", cost - player.money);
                    else if (cost >= player.money && tileCount == 0 && specialTileCount == 0) {
                        System.out.println("You no longer have properties to sell.");
                        player.propertySellCheck = false;
                        break;
                    } else {
                        player.propertySellCheck = false;
                        hasPaid = true;
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

    private void playerLoan(Player player, int cost, boolean debtCheck) {
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
                        }
                        if (player.loanAmount == 0) {
                            System.out.println(player.name + " has successfully paid the loan back in full.");
                            player.hasLoan = false;
                            player.loanPeriod = 0;
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

    private void bankrupt(Player player) {
        System.out.println(player.name + " has declared bankruptcy.");
        player.bankruptcy = true;
        player.propertySellCheck = false;
        for (Object currentTile : tiles) {
            if (currentTile instanceof Tile) {
                Tile propertyTile = (Tile) currentTile;
                if (propertyTile.owner == player) {
                    propertyTile.owner = null;
                    propertyTile.numOfHouse = 0;
                }
            }
            if (currentTile instanceof SpecialTile) {
                SpecialTile specialTile = (SpecialTile) currentTile;
                if (specialTile.owner == player) {
                    specialTile.owner = null;
                }
            }
        }
    }

    private void playerTurn(Player currentPlayer, int diceRoll) {
        if (diceRoll == 0) {
            System.out.print("It's " + currentPlayer.name + "'s turn. Press Enter to roll the dice.");
            keyboard.nextLine();
            performTurn(currentPlayer, 0);
        } else {
            System.out.println(currentPlayer.name + " just got out of jail, move " + diceRoll + " spaces.");
            performTurn(currentPlayer, diceRoll);
        }
    }

    private void performTurn(Player player, int diceRoll) {
        int previousPlayerPosition = player.position; // make a tile check to see if player passed go or not here
        if (diceRoll == 0) {
            keyboard = new Scanner(System.in);
            int diceRoll1 = rand.nextInt(6) + 1;
            int diceRoll2 = rand.nextInt(6) + 1;
            diceRoll = diceRoll1 + diceRoll2;
            System.out.println(player.name + " rolled a " + diceRoll + ".");
            player.position = (player.position + diceRoll) % tiles.size();
        }
        Object currentTile = tiles.get(player.position);
        duitriaBoard(player, currentTile, previousPlayerPosition, diceRoll);
        System.out.println(player.name + "'s turn is over.\n");
    }

    private void duitriaBoard(Player player, Object currentTile, int previousPlayerPosition, int diceRoll) {
        if (previousPlayerPosition + diceRoll >= 40) {
            GoCornerTile go = (GoCornerTile) tiles.get(0);
            System.out.printf(Locale.US, player.name + " has passed the Go Tile. " + player.name + " has received RM%,d.\n", go.payment);
            player.money += go.payment;
            if (player.buyProperty)
                player.buyHouse = true;
            player.buyProperty = true;
        }
        if (currentTile instanceof TileUpAndBottom) {
            TileUpAndBottom propertyTile = (TileUpAndBottom) currentTile;
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
            System.out.println(player.name + " landed on " + fateCard.name + ".");
            System.out.print(player.name + " drew a fate card: ");
            fateCardOutcome(player);
        } else if (currentTile instanceof JailCornerTile) {
            JailCornerTile jail = (JailCornerTile) currentTile;
            System.out.println(player.name + " landed on " + jail.name + ".");
            System.out.println(player.name + " is visiting the jail.");
        } else if (currentTile instanceof Tax) {
            Tax tax = (Tax) currentTile;
            System.out.println(player.name + " landed on " + tax.name + ".");
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
        } else if (currentTile instanceof FreeParkingCornerTile) {
            FreeParkingCornerTile freeParking = (FreeParkingCornerTile) currentTile;
            System.out.println(player.name + " landed on " + freeParking.name);
            System.out.println(player.name + " is resting.");
        } else if (currentTile instanceof GoToJailCornerTile) {
            GoToJailCornerTile goToJail = (GoToJailCornerTile) currentTile;
            System.out.println(player.name + " landed on " + goToJail.name + ".");
            System.out.println(player.name + " has to go to jail.");
            player.jailCheck = true;
            player.position = 10;
        }
    }

    private void boardTile(Player player, Object currentTile) {

    }

    private void fateCardOutcome(Player player) {
        int randNum = rand.nextInt(10);
        switch(randNum) {
            case 0:
            System.out.println("Advance to Go and collect RM2,000,000.");
            player.position = 0;
            player.money += 2000000;
            if (player.buyProperty)
                player.buyHouse = true;
            player.buyProperty = true;
            break;
            case 1:
            System.out.println("Advance to the nearest railroad."); //add buy option for the railroads
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
            break;
            case 3:
            System.out.println("Bank error in your favor, Collect RM2,000,000.");
            player.money += 2000000;
            break;
            case 4:
            System.out.println("Go back 3 spaces.");
            player.position -= 3;
            break;
            case 5:
            System.out.println("Go to Jail.");
            player.position = 10;
            player.jailCheck = true;
            break;
            case 6:
            System.out.println("Make general repair on all your property, RM200,000 for each house.");
            int generalRepairTotal = 0;
            for (Object currentTile : tiles) {
                if (currentTile instanceof Tile) {
                    Tile propertyTile = (Tile) currentTile;
                    if (propertyTile.owner == player) {
                        generalRepairTotal += (propertyTile.numOfHouse * 200000);
                        System.out.printf(Locale.US, propertyTile.name + " costs RM%,d.\n", (propertyTile.numOfHouse * 200000));
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
                }
            } else {
                player.money -= generalRepairTotal;
                System.out.printf(Locale.US, player.name + " successfully paid RM%,d.\n", generalRepairTotal);
            }
            break;
            case 7:
            System.out.println("Pay hospital fees of RM250,000.");
            if (250000 >= player.money) {
                System.out.println("You don't have enough money to pay the hospital fees.");
                sellingProperties(player, 250000, true, false, null);
                if (!player.bankruptcy && 250000 < player.money) {
                    player.money -= 250000;
                    System.out.println(player.name + " successfully paid the hospital fees.");
                }
            } else {
                player.money -= 250000;
                System.out.println(player.name + " successfully paid the hospital fees.");
            }
            break;
            case 8:
            System.out.println("Pay school fees of RM100,000.");
            if (100000 >= player.money) {
                System.out.println("You don't have enough money to pay the school fees.");
                sellingProperties(player, 100000, true, false, null);
                if (!player.bankruptcy && 100000 < player.money) {
                    player.money -= 100000;
                    System.out.println(player.name + " successfully paid the school fees.");
                }
            } else {
                player.money -= 100000;
                System.out.println(player.name + " successfully paid the school fees.");
            }
            break;
            case 9:
            System.out.println("Pay speeding fine of RM100,000.");
            if (100000 >= player.money) {
                System.out.println("You don't have enough money to pay the speeding fine.");
                sellingProperties(player, 100000, true, false, null);
                if (!player.bankruptcy && 100000 < player.money) {
                    player.money -= 100000;
                    System.out.println(player.name + " successfully paid the speeding fine.");
                }
            } else {
                player.money -= 100000;
                System.out.println(player.name + " successfully paid the speeding fine.");
            }
            break;
            default:
            fateCardOutcome(player);
        }
    }

    private void fateCardRailRoad(Player player, Object currentTile) {
        SpecialTile specialTile = (SpecialTile) currentTile;
        System.out.println(player.name + " landed on " + specialTile.name);
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
                    }
                } else {
                    player.money -= (specialTile.baseRent * 2);
                    specialTile.owner.money += (specialTile.baseRent * 2);
                    System.out.println(player.name + " successfully paid the rent.");
                }
            } else if (specialTile.owner == player) {
                System.out.println(player.name + " is vitising his tile.");
            }
        }
    }

    private int onePlayerLeft() {
        int activePlayerAmount = 0;
        for (Player player : players) {
            if  (!player.bankruptcy)
                activePlayerAmount++;
        }
        return activePlayerAmount;
    }


    private void initializePlayerCard() {
        int yCords = 40;
        for (Player player : players) {
            playerCards.add(new playerCard(0, yCords, this, player.name));
            yCords += 205;
        }
    }

    Board() {
        
    SwingUtilities.invokeLater(() -> {
    Border border = BorderFactory.createLineBorder(Color.BLACK,1);
    playerNum = PlayerNumber.playerNum;
    
    // Border border = BorderFactory.createLineBorder(Color.BLACK,1);
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
    
    //For Tile Free Parking
    JPanel panelFreeParking = new JPanel();
    panelFreeParking.setBackground(Color.WHITE);
    panelFreeParking.setBounds(0, 0, 158, 158);
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
    //labelImageDefault.setIcon(imageicon.getResizedImage("src\\duitria.current.tiles\\0 DEFAULT CURRENT TILE.png",228,474));
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

    
    //INITIALIZE PLAYER CARD PANEL DEPENDS ON THE NUMBER OF PLAYERS INITIALIZED
    
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
    
    keyboard = new Scanner(System.in);
    players = new ArrayList<>();
    tiles = new ArrayList<>();
    playerCards = new ArrayList<>();
    rand = new Random();
    initializePlayers(playerNum);
    sortedPlayerTurn();
    initializeTile(panelBoard, border);
    initializePlayerCard();
    playGame();
    


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
class GoCornerTile extends JPanel {
    String name;
    int payment;
    GoCornerTile(JPanel panelBoard, Border border, String name, int payment) {
        //For Tile GO
        this.name = name;
        this.payment = payment;
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
    }
}

class JailCornerTile extends JPanel {
    String name;
    JailCornerTile(JPanel panelBoard, Border border, String name) {
        //For Tile JAIL
        this.name = name;
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
    }
}

class FreeParkingCornerTile extends JPanel {
    String name;
    FreeParkingCornerTile(JPanel panelBoard, Border border, String name) {
        //For Tile Free Parking
        this.name = name;
        JPanel panelFreeParking = new JPanel();
        panelFreeParking.setBackground(Color.WHITE);
        panelFreeParking.setBounds(0, 0, 158, 158);
        JLabel labelImageFreeParking = new JLabel();
        labelImageFreeParking.setIcon(imageicon.getResizedImage("src\\duitria.tiles\\FREE PARKING.png",158,158));
        labelImageFreeParking.setBounds(0, 0, 158, 158);
        panelFreeParking.add(labelImageFreeParking);
        panelFreeParking.setBorder(border);
        panelFreeParking.setLayout(null);
        panelBoard.add(panelFreeParking);
    }
} 

class GoToJailCornerTile extends JPanel {
    String name;
    GoToJailCornerTile(JPanel panelBoard, Border border, String name) {
        //For Tile GO TO JAIL
        this.name = name;
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
    }
}

class miniTilesUpAndBottom extends JPanel{
    miniTilesUpAndBottom(int x, int y, JPanel panelBoard, String filePath){
        SwingUtilities.invokeLater(() -> {
            Border border = BorderFactory.createLineBorder(Color.BLACK,1);
            this.setBounds(x, y, 76, 158);
            this.setBackground(Color.WHITE);
            this.setBorder(border);
            this.setLayout(null);

            ImageIcon icon = imageicon.getResizedImage(filePath,76, 158);
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

class TileUpAndBottom extends miniTilesUpAndBottom {
    String name;        // tile's name
    int cost;           // tile's cost
    int baseRent;       // tile's base rent
    String tileColour;  // tile's colour group
    Player owner;       // tile's ownership (based on player's reference)
    int houseCost;      // tile's housecost
    int numOfHouse;     // tile's number of houses built
    TileUpAndBottom(int x, int y, JPanel panelBoard, String path, String name, int cost, int baseRent, String tileColour) {
        super(x, y, panelBoard, path);
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

class SpecialTileUpAndBottom extends miniTilesUpAndBottom {
    String name;    // special tile's name
    int cost;       // special tile's cost
    int baseRent;   // special tile's base rent
    Player owner;   // special tile's ownership (based on player's reference)
    SpecialTileUpAndBottom(int x, int y, JPanel panelBoard, String path, String name, int cost, int baseRent) {
        super(x, y, panelBoard, path);
        this.name = name;
        this.cost = cost;
        this.baseRent = baseRent;
        owner = null;
    }
}

class TaxUpAndBottom extends miniTilesUpAndBottom {
    String name;    // tax's tile name
    int cost;       // tax's cost
    TaxUpAndBottom(int x, int y, JPanel panelBoard, String path, String name, int cost) {
        super(x, y, panelBoard, path);
        this.name = name;
        this.cost = cost;
    }
}

class GoUpAndBottom extends miniTilesUpAndBottom {
    String name;    // go tile's name
    int payment;    // go tile's payment
    GoUpAndBottom(int x, int y, JPanel panelBoard, String path, String name, int payment) {
        super(x, y, panelBoard, path);
        this.name = name;
        this.payment = payment;
    }
}

class FateCardUpAndBottom extends miniTilesUpAndBottom {
    String name;    // fatecard tile's name
    FateCardUpAndBottom(int x, int y, JPanel panelBoard, String path, String name) {
        super(x, y, panelBoard, path);
        this.name = name;
    }
}

class FreeParkingUpAndBottom extends miniTilesUpAndBottom {
    String name;    //free parking tile's name
    FreeParkingUpAndBottom(int x, int y, JPanel panelBoard, String path, String name) {
        super(x, y, panelBoard, path);
        this.name = name;
    }
}

class JailUpAndBottom extends miniTilesUpAndBottom {
    String name;    // jail tile's name
    JailUpAndBottom(int x, int y, JPanel panelBoard, String path, String name) {
        super(x, y, panelBoard, path);
        this.name = name;
    }
}

class GoToJailUpAndBottom extends miniTilesUpAndBottom {
    String name;    // go to jail tile's name
    GoToJailUpAndBottom(int x, int y, JPanel panelBoard, String path, String name) {
        super(x, y, panelBoard, path);
        this.name = name;
    }
}

 class miniTilesLeftAndRight extends JPanel{
     
     miniTilesLeftAndRight(int x, int y, JPanel panelBoard, String path){
         SwingUtilities.invokeLater(() -> {
            Border border = BorderFactory.createLineBorder(Color.BLACK,1);
            this.setBounds(x, y, 158, 76);
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

class TileLeftAndRight extends miniTilesLeftAndRight {
    String name;        // tile's name
    int cost;           // tile's cost
    int baseRent;       // tile's base rent
    String tileColour;  // tile's colour group
    Player owner;       // tile's ownership (based on player's reference)
    int houseCost;      // tile's housecost
    int numOfHouse;     // tile's number of houses built
    TileLeftAndRight(int x, int y, JPanel panelBoard, String path, String name, int cost, int baseRent, String tileColour) {
        super(x, y, panelBoard, path);
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

class SpecialTileLeftAndRight extends miniTilesLeftAndRight {
    String name;    // special tile's name
    int cost;       // special tile's cost
    int baseRent;   // special tile's base rent
    Player owner;   // special tile's ownership (based on player's reference)
    SpecialTileLeftAndRight(int x, int y, JPanel panelBoard, String path, String name, int cost, int baseRent) {
        super(x, y, panelBoard, path);
        this.name = name;
        this.cost = cost;
        this.baseRent = baseRent;
        owner = null;
    }
}

class TaxLeftAndRight extends miniTilesLeftAndRight {
    String name;    // tax's tile name
    int cost;       // tax's cost
    TaxLeftAndRight(int x, int y, JPanel panelBoard, String path, String name, int cost) {
        super(x, y, panelBoard, path);
        this.name = name;
        this.cost = cost;
    }
}

class FateCardLeftAndRight extends miniTilesLeftAndRight {
    String name;    // fatecard tile's name
    FateCardLeftAndRight(int x, int y, JPanel panelBoard, String path, String name) {
        super(x, y, panelBoard, path);
        this.name = name;
    }
}

class FreeParkingLeftAndRight extends miniTilesLeftAndRight {
    String name;    //free parking tile's name
    FreeParkingLeftAndRight(int x, int y, JPanel panelBoard, String path, String name) {
        super(x, y, panelBoard, path);
        this.name = name;
    }
}

class JailLeftAndRight extends miniTilesLeftAndRight {
    String name;    // jail tile's name
    JailLeftAndRight(int x, int y, JPanel panelBoard, String path, String name) {
        super(x, y, panelBoard, path);
        this.name = name;
    }
}

class GoToJailLeftAndRight extends miniTilesLeftAndRight {
    String name;    // go to jail tile's name
    GoToJailLeftAndRight(int x, int y, JPanel panelBoard, String path, String name) {
        super(x, y, panelBoard, path);
        this.name = name;
    }
}

class playerCard extends JPanel {
    String playerName;
    double playerLand;
    double playerMoney;
    String playerStatus;

    playerCard(int x, int y, JFrame frame, String playerName, double playerLand, double playerMoney, String playerStatus) {
        
        SwingUtilities.invokeLater(() -> {

            this.playerName = playerName;
            this.playerLand = playerLand;
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
    playerCard(int x, int y, JFrame frame, String playerName) {
        SwingUtilities.invokeLater(() -> {

            this.playerName = playerName;
            this.playerLand = playerLand;
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
}

class playerLogHistory extends JPanel{
    String playerName;
    String tileNumber;
    String playerLogHistory;
     
     playerLogHistory(int x, int y, JFrame frame, String playerName){
         SwingUtilities.invokeLater(() -> {

            this.playerName = playerName;
            this.tileNumber = "6";
            this.playerLogHistory = "Paid Rent RM 500 to Ali";

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