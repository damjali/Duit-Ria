/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package duitria;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
//start game 
//about game 
//create players (num of players,name of players) 
//board game 
//go 
//asset (houses and hotels included) 
//fate card 
//jail 
//free parking 
//go to jail 
//replay 
//end game (bankcrupt, end game) 
//save file (optional) 
//player wins 
class Player {
    String name;
    int money;
    int position;
    boolean jailCheck;
    int turn;
    public Player(String name, int money, int position) {
        this.name = name;
        this.money = money;
        this.position = position;
        this.jailCheck = false;
        this.turn = 0;
    }
}
class Tile {
    String name;
    int cost;
    int baseRent;
    Player owner;
    int houseCost;
    int numOfHouse;
    public Tile(String name, int cost, int baseRent,int houseCost) {
        this.name = name;
        this.cost = cost;
        this.baseRent = baseRent;
        this.houseCost = houseCost;
        this.owner = null;
        this.numOfHouse = 0;
    }
    public int calculateRent() {
        int calculatedRent = 0;
        if (numOfHouse == 0) {
            calculatedRent = baseRent;
        } else if (numOfHouse == 1) {
            calculatedRent = baseRent * 2;
        } else if (numOfHouse >= 2 && numOfHouse <= 4) {
            calculatedRent = (baseRent * 2) + (baseRent + (200000 * (numOfHouse - 1)));
        }
        return calculatedRent;
    }
}
class FateCard {
    String description;
    public FateCard(String description) {
        this.description = description;
    }
}
class Tax {
    String name;
    int cost;
    public Tax(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
}
class Go {
    String name;
    int payment;
    public Go(String name, int payment) {
        this.name = name;
        this.payment = payment;
    }
}
class FreeParking {
    String description;
    public FreeParking(String description) {
        this.description = description;
    }
}
class Jail {
    String name;
    public Jail(String name) {
        this.name = name;
    }
}
class GoToJail {
    String name;
    public GoToJail(String name) {
        this.name = name;
    }
}
public class DuitRIa {
    private List<Player> players;
    private List<Object> tiles;
    private int currentPlayerIndex;
    private Scanner keyboard;
    private Random rand;
    public DuitRIa() {
        keyboard = new Scanner(System.in);
        players = new ArrayList<>();
        tiles = new ArrayList<>();
        rand = new Random();
        System.out.print("How many players are playing : ");
        int playerNum = keyboard.nextInt();
        keyboard.nextLine();
        if (playerNum >= 2 && playerNum <= 4)
            initializePlayers(playerNum);
        else
            System.err.println("Error: Enter number 2-4");
        currentPlayerIndex = 0;
        initializeTile();
    }
    private void initializePlayers(int playerNum) {
        for (int i = 1; i <= playerNum; i++) {
            System.out.print("Player " + i + " name : ");
            String name = keyboard.nextLine();
            players.add(new Player(name,15000000,0));
        }
    }
    private void initializeTile() {
        tiles.add(new Go("Go",2000000));
        tiles.add(new Tile("Petaling Street",600000 ,60000 ,200000));
        tiles.add(new FateCard("Fate"));
        tiles.add(new Tile("Jonker Street",600000 ,60000 ,200000));
        tiles.add(new Tax("Tax",2000000 ));
        tiles.add(new Tile("KLIA",2000000 ,200000 ,200000));
        tiles.add(new Tile("Masjid Jamek",1000000 ,100000 ,200000));
        tiles.add(new FateCard("Fate Card"));
        tiles.add(new Tile("Batu Caves",1000000 ,100000 ,200000));
        tiles.add(new Tile("Siri Maha Mariamman Temple",1200000 ,120000 ,200000));
        tiles.add(new Jail("Jail"));
        tiles.add(new Tile("National Museum",1400000 ,140000 ,200000));
        tiles.add(new Tile("Tenaga Nasional Berhad",1500000 ,150000 ,200000));
        tiles.add(new Tile("Royal Palace",1400000 ,140000 ,200000));
        tiles.add(new Tile("Merdeka Square",1400000 ,140000 ,200000));
        tiles.add(new Tile("KLIA 2",2000000 ,200000 ,200000));
        tiles.add(new Tile("A'Famosa Resort",1700000 ,170000 ,200000));
        tiles.add(new FateCard("Fate Card"));
        tiles.add(new Tile("Kellie Castle",1800000 ,180000 ,200000));
        tiles.add(new Tile("Stadthuys",2000000 ,200000 ,200000));
        tiles.add(new FreeParking("This is a free resting place"));
        tiles.add(new Tile("Fraser's Hill",2200000 ,220000 ,200000));
        tiles.add(new FateCard("Fate Card"));
        tiles.add(new Tile("Cameron Highlands",2200000 ,220000 ,200000));
        tiles.add(new Tile("Genting Highland",2400000 ,240000 ,200000));
        tiles.add(new Tile("KL Sentral Station",2000000 ,200000 ,200000));
        tiles.add(new Tile("Pahang National Park",2600000 ,260000 ,200000));
        tiles.add(new Tile("Jabatan Bekalan Air",2600000 ,150000 ,200000));
        tiles.add(new Tile("Gunung Mulu National Park",2700000 ,260000 ,200000));
        tiles.add(new Tile("Kinabalu National Park",600000 ,270000 ,200000));
        tiles.add(new GoToJail("Fate"));
        tiles.add(new Tile("Tioman Islands",3000000 ,300000 ,200000));
        tiles.add(new Tile("Perhentian Islands",3000000 ,300000 ,200000));
        tiles.add(new FateCard("Fate Card"));
        tiles.add(new Tile("Sepadan Islands",3200000 ,320000 ,200000));
        tiles.add(new Tile("Pudu Sentral Station",2000000 ,200000 ,200000));
        tiles.add(new FateCard("Fate Card"));
        tiles.add(new Tile("KLCC",3500000 ,350000 ,200000));
        tiles.add(new Tax("Tax",2000000));
        tiles.add(new Tile("Sepang II Circuit",4000000 ,400000 ,200000));
    }
    private void displayBoard() {
        System.out.println("Current Board State: ");
        for (Player player : players)
            System.out.println(player.name + " is at position " + player.position + " with RM" + player.money);
    }
    private void performTurn(Player player) {
        keyboard = new Scanner(System.in);
        int diceRoll1 = rand.nextInt(6) + 1;
        int diceRoll2 = rand.nextInt(6) + 1;
        int diceRoll = diceRoll1 + diceRoll2;
        System.out.println(player.name + " rolled a " + diceRoll);
        player.position = (player.position + diceRoll) % tiles.size();
        Object currentTile = tiles.get(player.position);
        if (currentTile instanceof Tile) {
            Tile propertyTile = (Tile) currentTile;
            System.out.println(player.name + " landed on " + propertyTile.name);
            if (propertyTile.owner == null) {
                System.out.print("Do you want to buy " + propertyTile.name + " for RM" + propertyTile.cost + "? (Y/N):");
                String choice = keyboard.nextLine();
                if (choice.equalsIgnoreCase("Y")) {
                    if (propertyTile.cost >= player.money) {
                        System.out.println("Not enough money to buy " + propertyTile.name + ".");
                    } else {
                        System.out.println(player.name + " bought " + propertyTile.name + ".");
                        player.money -= propertyTile.cost;
                    }
                }
            } else if (propertyTile.owner != player) {
                int rentAmount = propertyTile.baseRent + propertyTile.calculateRent();
                System.out.println(propertyTile.name + " is owned by " + propertyTile.owner.name + ".");
                System.out.println(player.name + " has to pay rent of RM" + rentAmount + ".");
                player.money -= rentAmount;
                propertyTile.owner.money += rentAmount;
            } else {
                if (propertyTile.numOfHouse >= 0 && propertyTile.numOfHouse <= 4) {
                    System.out.print("Do you want to buy houses for " + propertyTile.name + "? (Y/N):");
                    String choice = keyboard.nextLine();
                    if (choice.equalsIgnoreCase("Y")) {
                        boolean buyHouseCheck = true;
                        int housePrice = propertyTile.houseCost;
                        System.out.println("You can buy " + (4 - propertyTile.numOfHouse) + " more houses.");
                        while (buyHouseCheck) {
                            System.out.print("How many do you want to buy? : ");
                            int numOfHouse = keyboard.nextInt();
                            keyboard.nextLine();
                            if (numOfHouse >= 0 && numOfHouse <= propertyTile.numOfHouse) {
                                if (housePrice * numOfHouse >= player.money) {
                                    System.out.println("You don't have enough money to buy that amount of houses.");
                                    buyHouseCheck = false;
                                } else {
                                    System.out.println("You bought the house for RM" + housePrice * numOfHouse);
                                    propertyTile.numOfHouse += numOfHouse;
                                    player.money -= housePrice * numOfHouse;
                                    buyHouseCheck = false;
                                }
                            } else {
                                System.out.println("Please buy in the amount of available houses.");
                            }
                        }
                    }
                }
            }
        } else if (currentTile instanceof FateCard) {
            FateCard fateCard = (FateCard) currentTile;
            System.out.println(player.name + " drew a " + fateCard.description + ":");
            fateCardOutcome(player);
        } else if (currentTile instanceof Jail) {
            if (player.jailCheck) {
                System.out.println(player.name + " is in the jail. Rolling doubles to get out of jail or pay RM250,000");
                diceRoll1 = rand.nextInt(6) + 1;
                diceRoll2 = rand.nextInt(6) + 1;
                if (diceRoll1 == diceRoll2) {
                    System.out.println(player.name + " managed to roll a double of " + diceRoll1 + "!");
                    player.jailCheck = false;
                    diceRoll = diceRoll1 + diceRoll2;
                    player.position += diceRoll;
                } else {
                    System.out.println("Sorry " + player.name + ", you rolled a " + diceRoll1 + " and " + diceRoll2 + ".");
                    player.money -= 250000;
                    player.jailCheck = false;
                    diceRoll = diceRoll1 + diceRoll2;
                    player.position += diceRoll;
                }
            } else {
                System.out.println(player.name + " is visitng the jail.");
            }
        } else if (currentTile instanceof Tax) {
            Tax tax = (Tax) currentTile;
            System.out.println(player.name + " has to pay the tax for RM" + tax.cost + ".");
        } else if (currentTile instanceof Go) {
            Go go = (Go) currentTile;
            System.out.println(player.name + " has passed the Go Tile." + player.name + " has received RM" + go.payment + ".");
            player.money += 2000000;
        } else if (currentTile instanceof FreeParking) {
            System.out.println(player.name + " is resting.");
        } else if (currentTile instanceof GoToJail) {
            GoToJail goToJail = (GoToJail) currentTile;
            System.out.println(player.name + " has to go to " + goToJail.name + ".");
            player.jailCheck = true;
            player.position = 10;
        }
        System.out.println(player.name + "'s turn is over. Press Enter to continue");
        keyboard.nextLine();
    }
    private void playGame() {
        keyboard = new Scanner(System.in);
        boolean gameRunning = true;
        while (gameRunning) {
            Player currentPlayer = players.get(currentPlayerIndex);
            displayBoard();
            System.out.println("It's " + currentPlayer.name + "'s turn. Press Enter to roll the dice.");
            keyboard.nextLine();
            performTurn(currentPlayer);
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
    }
    private void fateCardOutcome(Player player) {
        int randNum = rand.nextInt(10);
        switch(randNum) {
            case 0:
            System.out.print("Advance to Go.");
            player.position = 0;
            player.money += 2000000;
            break;
            case 1:
            System.out.print("Advance to the nearest railroad.");
            int nearestRailroad1 = player.position - 25;
            int nearestRailroad2 = player.position - 35;
            if (nearestRailroad1 < nearestRailroad2)
                player.position = 25;
            else
                player.position = 35;
            break;
            case 2:
            System.out.print("It is your birthday! Collect RM100,000 from everyone.");
            player.money += (100000 * players.size());
            for (Player otherPlayer : players) {
                if (!otherPlayer.equals(player))
                    otherPlayer.money -= 100000;
            }
            break;
            case 3:
            System.out.print("Bank error in your favor. Collect RM2,000,000.");
            player.money += 2000000;
            break;
            case 4:
            System.out.print("Go back 3 spaces.");
            player.position -= 3;
            break;
            case 5:
            System.out.print("Go to Jail.");
            player.position = 10;
            player.jailCheck = true;
            break;
            case 6:
            System.out.print("Make general repair on all your property. RM200,000 for each house.");
            int generalRepairTotal = 0;
            for (int count = 0; count < tiles.size(); count++) {
                Object currentTile = tiles.get(count);
                if (currentTile instanceof Tile) {
                    Tile propertyTile = (Tile) tiles;
                    if (propertyTile.owner.equals(player)) {
                        generalRepairTotal += (propertyTile.numOfHouse * 200000);
                        System.out.println(propertyTile.name + " costs RM" + (propertyTile.numOfHouse * 200000) + ".");
                    }
                }
            }
            System.out.println(player.name + " the total is RM" + generalRepairTotal);
            if (generalRepairTotal > player.money) {
                System.out.println("You don't have enough money.");
            } else {
                System.out.println("You successfully paid RM" + generalRepairTotal);
                player.money -= generalRepairTotal;
            }
            break;
            case 7:
            System.out.print("Pay hospital fees of RM250,000.");
            player.money -= 250000;
            break;
            case 8:
            System.out.print("Pay school fees of RM100,000.");
            player.money -= 100000;
            break;
            case 9:
            System.out.print("Pay speeding fine of RM100,000.");
            player.money -= 100000;
            break;
            default:
            fateCardOutcome(player);
        }
    }
    private void notEnoughMoney(Player player, int cost) {
        int tileCount = 0;
        int houseCount = 0;
        for (int i = 0; i < tiles.size(); i++) {
            Object currentTile = (Tile) tiles;
            if (currentTile instanceof Tile) {
                Tile propertyTile = (Tile) tiles;
                if (propertyTile.owner == player) {
                    tileCount++;
                    houseCount += propertyTile.numOfHouse;
                }
            }
        }
        System.out.println("You have a total asset of " + tileCount + " land(s) and " + houseCount + " house(s).");
        if (tileCount == 0 && houseCount == 0) {
            System.out.println("You can't afford to pay that much!");
            
        }
    }
    private void sortPlayers() {
        int diceRoll1 = rand.nextInt(6) + 1;
        int diceRoll2 = rand.nextInt(6) + 1;
    }
    public static void main(String[] args) {
        DuitRIa game = new DuitRIa();
        game.playGame();
    }
}