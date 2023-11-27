/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package duitria;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.GroupLayout;

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
    public Player(String name, int money, int position) {
        this.name = name;
        this.money = money;
        this.position = position;
    }
}

class Tile {
    String name;
    int cost;
    int rent;
    public Tile(String name, int cost, int rent) {
        this.name = name;
        this.cost = cost;
        this.rent = rent;
    }
}

class FateCard {
    String description;
    public FateCard(String description){
        this.description = description;
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
        tiles.add(new Go("Go",2000000 ,0 ));
        tiles.add(new Tile("Petaling Street",600000 ,60000 ));
        tiles.add(new FateCard("Fate"));
        tiles.add(new Tile("Jonker Street",600000 ,60000 ));
        tiles.add(new Tax("Tax"));
        tiles.add(new Tile("KLIA",2000000 ,200000 ));
        tiles.add(new Tile("Masjid Jamek",1000000 ,100000 ));
        tiles.add(new FateCard("Fate"));
        tiles.add(new Tile("Batu Caves",1000000 ,100000 ));
        tiles.add(new Tile("Siri Maha Mariamman Temple",1200000 ,120000 ));
        tiles.add(new Jail("Fate"));
        tiles.add(new Tile("National Museum",1400000 ,140000 ));
        tiles.add(new Tile("Tenaga Nasional Berhad",1500000 ,150000 ));
        tiles.add(new Tile("Royal Palace",1400000 ,140000 ));
        tiles.add(new Tile("Merdeka Square",1400000 ,140000 ));
        tiles.add(new Tile("KLIA 2",2000000 ,200000 ));
        tiles.add(new Tile("A'Famosa Resort",1700000 ,170000 ));
        tiles.add(new FateCard("Fate"));
        tiles.add(new Tile("Kellie Castle",1800000 ,180000 ));
        tiles.add(new Tile("Stadthuys",2000000 ,200000 ));
        tiles.add(new FreeParking("Fate"));
        tiles.add(new Tile("Fraser's Hill",2200000 ,220000 ));
        tiles.add(new FateCard("Fate"));
        tiles.add(new Tile("Cameron Highlands",2200000 ,220000 ));
        tiles.add(new Tile("Genting Highland",2400000 ,240000 ));
        tiles.add(new Tile("KL Sentral Station",2000000 ,200000 ));
        tiles.add(new Tile("Pahang National Park",2600000 ,260000 ));
        tiles.add(new Tile("Jabatan Bekalan Air",2600000 ,150000 ));
        tiles.add(new Tile("Gunung Mulu National Park",2700000 ,260000 ));
        tiles.add(new Tile("Kinabalu National Park",600000 ,270000 ));
        tiles.add(new GotToJail("Fate"));
        tiles.add(new Tile("Tioman Islands",3000000 ,300000 ));
        tiles.add(new Tile("Perhentian Islands",3000000 ,300000 ));
        tiles.add(new FateCard("Fate"));
        tiles.add(new Tile("Sepadan Islands",3200000 ,320000 ));
        tiles.add(new Tile("Pudu Sentral Station",2000000 ,200000 ));
        tiles.add(new FateCard("Fate"));
        tiles.add(new Tile("KLCC",3500000 ,350000 ));
        tiles.add(new Tax("Tax"));
        tiles.add(new Tile("Sepang II Circuit",4000000 ,400000 ));
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
            if (propertyTile.cost > player.money) {
                System.out.println("Not enough money to buy " + propertyTile.name);
            } else {
                System.out.println(player.name + " bought " + propertyTile.name + " for RM" + propertyTile.cost);
                player.money -= propertyTile.cost;
            }
        } else if (currentTile instanceof FateCard) {
            FateCard fateCard = (FateCard) currentTile;
            System.out.println(player.name + " drew a Fate card:" + fateCard.description);
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
    public static void main(String[] args) {
        DuitRIa game = new DuitRIa();
        game.playGame();
    }
}