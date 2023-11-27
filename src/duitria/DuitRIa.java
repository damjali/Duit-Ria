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
    String name;
    public FateCard(String name) {
        this.name = name;
    }
}

class Fate {
    String description;
    public Fate(String description){
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
        tiles.add(new Tile("Go",2000000 ,0 ));
        tiles.add(new Tile("Petaling Street",600000 ,5000 ));
        tiles.add(new FateCard("Fate"));
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