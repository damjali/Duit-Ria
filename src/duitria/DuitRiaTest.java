package duitria;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
public class DuitRiaTest {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Random randomOne = new Random();
        Random randomTwo = new Random();

        int numOfPlayer = numOfPlayerInput(keyboard);

        // getting players names
        String playerNames[] = new String[numOfPlayer];
        playerNamesInput(keyboard, playerNames, numOfPlayer);

        // decide who starts
        int playerDice[] = new int[numOfPlayer];
        playerTurns(playerDice, playerNames);
        
        // Pause before start
        //gamePause(keyboard);

        // declare money
        int playerMoney[] = new int[numOfPlayer];
        for (int i = 0; i < numOfPlayer; i++) {
            playerMoney[i] = 15000000;
        }

        // declare starting point;
        int playerLocation[] = new int[numOfPlayer];
        for (int i = 0; i < numOfPlayer; i++) {
            playerLocation[i] = 0;
        }

        boolean status = true; // not stop game

        int playerRounds[] = new int[numOfPlayer];
        for (int i = 0; i < numOfPlayer; i++) {
            playerRounds[i] = 0;
        }

        for (int currentPlayer = 0; currentPlayer < numOfPlayer; currentPlayer++) {
            moves(playerNames, currentPlayer, playerLocation, playerRounds, playerMoney);
            locationChecker(playerNames, currentPlayer, playerLocation, keyboard, playerMoney, playerRounds);
        }
    }

    static int numOfPlayerInput(Scanner keyboard) {
        int num;

        System.out.print("Number of players: ");
        num = keyboard.nextInt();
        while (num > 4 || num < 2) {
            System.out.println("\nOnly 2-4 players are allowed.");
            System.out.print("Number of players: ");
            num = keyboard.nextInt();
        }
        return num;
    }

    static void playerNamesInput(Scanner keyboard, String[] playerNames, int numOfPlayers) {
        System.out.println("Please enter players' names.");
        for (int i = 1; i <= numOfPlayers; i++) {
            System.out.print("Player " + i + ": ");
            playerNames[i - 1] = keyboard.next();
        }
        System.out.println("");
    }

    static int randomDice(Random random1, Random random2) {
        int dice1, dice2, max = 6, min = 1;

        dice1 = random1.nextInt(max + min) + min;
        dice2 = random2.nextInt(max + min) + min;

        return dice1 + dice2;
    }

    static void playerTurns(int[] playerDice, String[] playerNames) {
        Random randomOne = new Random();
        Random randomTwo = new Random();

        System.out.println("\nLet's roll the dice to see who starts first!");

        for (int i = 0; i < playerDice.length; i++) {
            playerDice[i] = randomDice(randomOne, randomTwo);
        }

        for (int i = 1; i < playerDice.length; i++) {
            for (int j = 0; j < playerDice.length - 1; j++) {
                if (playerDice[j] < playerDice[j + 1]) {
                    int hold = playerDice[j + 1];
                    playerDice[j + 1] = playerDice[j];
                    playerDice[j] = hold;

                    String temp = playerNames[j + 1];
                    playerNames[j + 1] = playerNames[j];
                    playerNames[j] = temp;
                }
            }
        }

        for (int i = 0; i < playerDice.length; i++) {
            System.out.printf("\nPlayer %d: %-10s Dice: %d", i + 1, playerNames[i], playerDice[i]);
        }
    }

    static void gamePause(Scanner keyboard) {
        System.out.println("\n\nPress Enter to continue...");
        keyboard.nextLine();
    }

    static void moves(String[] playerNames, int currentPlayer, int[] playerLocation, int[] playerRounds, int[] playerMoney) {
        Random randomOne = new Random();
        Random randomTwo = new Random();
        int moves = randomDice(randomOne, randomTwo);

        System.out.println("\n\nIt is " + playerNames[currentPlayer] + "'s turn.");
        System.out.println(playerNames[currentPlayer] + " rolled " + moves);

        playerLocation[currentPlayer] += moves;

        if (playerLocation[currentPlayer] >= 40) {
            playerLocation[currentPlayer] %= 40;
            playerRounds[currentPlayer]++;
            playerMoney[currentPlayer] += 2000000;
            System.out.println("You passed Go!");
            System.out.println("Bank Account: RM" + playerMoney[currentPlayer]);
        }
    }

    static void locationChecker(String[] playerNames, int currentPlayer, int[] playerLocation, Scanner keyboard,
            int[] playerMoney, int[] playerRounds) {

        int locID[] = new int[40];
        int locPrice[] = new int[40];
        String locName[] = new String[40];
        String locAvail[] = new String[40];
        int locHouses[] = new int[40];
        int locRent[] = new int[40];
        int i = 0;

        try {
            Scanner locations = new Scanner(new FileInputStream("/Users/hada/Downloads"));

            while (locations.hasNextLine()) {
                String[] loc = locations.nextLine().split(",");
                locID[i] = Integer.parseInt(loc[0]);
                locName[i] = loc[1];
                locAvail[i] = loc[2];
                locPrice[i] = Integer.parseInt(loc[3]);
                locHouses[i] = Integer.parseInt(loc[4]);
                locRent[i] = Integer.parseInt(loc[5]);
                i++;
            }

            int j = 0;
            for (; j < 40; j++) {
                if (playerLocation[currentPlayer] == locID[j]) {
                    System.out.println(playerNames[currentPlayer] + " landed on " + locName[j]);
                    break;
                }
            }

            if (playerRounds[currentPlayer] > 1) {
                checkProperty(locName, locPrice, locAvail, currentPlayer, playerNames, playerMoney, j, playerRounds,
                        locHouses, locRent);
                if (locName[j].equals("FATE")) {
                    // GENERATE FATE CARD
                }

                if (locName[j].equals("GO TO JAIL!")) {
                    jail(playerLocation, currentPlayer, playerNames);
                }

                if (locName[j].equals("TAX")) {
                    tax(playerMoney, currentPlayer, playerNames);
                }
            }
        }

        catch (IOException e) {
        }
    }

    
    static void checkProperty(String[] locName, int[] locPrice, String[] locAvail, int currentPlayer, String[] playerNames, int[] playerMoney, int j, int[] playerRounds, int[] locHouses, int[] locRent){
        Scanner keyboard = new Scanner(System.in);
        
        if ((playerRounds[currentPlayer]>2 && locAvail[j].equalsIgnoreCase(playerNames[currentPlayer]) && !locName[j].equals("KLIA") && !locName[j].equals("KLIA2") && !locName[j].equals("KL SENTRAL STATION")&& !locName[j].equals("PUDU SENTRAL STATION"))){
            buyHouses (playerMoney,  currentPlayer, playerNames,  j, locName,  locHouses);
        }
        else if (playerRounds[currentPlayer]>1 && locAvail[j].equals("FOR SALE")){
            System.out.println("1.Buy "+ locName[j]+ " for "+ locPrice[j]);
            System.out.println("2.End Turn");
            int decision = keyboard.nextInt();
            while (decision !=1 && decision!=2){
                decision = keyboard.nextInt();
            }
            if (decision ==1){
                playerMoney[currentPlayer]-=locPrice[j];
                locAvail[j]=playerNames[currentPlayer];
                System.out.println(playerNames[currentPlayer]+" bought "+ locName[j]);
                System.out.println("Bank Account: "+ playerMoney[currentPlayer]);
            }
            else if(decision == 2){
            }
        }  
        else if (playerRounds[currentPlayer]>1 && !locAvail[j].equals("N/A") && !locAvail[j].equals(playerNames[currentPlayer])){
            System.out.println("You landed on "+ locAvail[j] + "'s property!");
            payRent(locHouses,  j,  currentPlayer,playerMoney,  playerNames, locRent, locPrice, locAvail);
        }
    }
    
    static void payRent(int[] locHouses, int j, int currentPlayer, int[] playerMoney, String[] playerNames, int[] locRent, int[] locPrice, String[] locAvail){
        if (locHouses[j]==0){
            playerMoney[currentPlayer]-=locPrice[j];
            System.out.println(playerNames[currentPlayer] + " paid RM " + locPrice[j] + " rent to "+ locAvail[j]);
            
            for (int i=0; i<playerNames.length;i++){
                if (locAvail[j].equals(playerNames[i]));
                playerMoney[i]+=locPrice[j];
            }
        }
        else if (locHouses[j]>0){
            int total = (locRent[j] + (200000*(locHouses[j]-1)));
            playerMoney[j]-=total;
            
            System.out.println(playerNames[currentPlayer] + " paid RM " + total + " rent to "+ locAvail[j]);
            
            for (int i=0; i<playerNames.length;i++){
                if (locAvail[j].equals(playerNames[i])){
                playerMoney[i]+=total;
                }
            }
        }
        
    }
    
    static void buyHouses (int[] playerMoney, int currentPlayer, String[] playerNames, int j, String[] locName, int[] locHouses){
        Scanner keyboard = new Scanner(System.in);    
        switch (locHouses[j]){
               case 0:{
                        System.out.println("1.Buy 1 house"+ locName[j]+ " for RM200K");
                        System.out.println("2.Buy 2 house"+ locName[j]+ " for RM400K");
                        System.out.println("3.Buy 3 house"+ locName[j]+ " for RM600K");
                        System.out.println("4.Buy 4 house"+ locName[j]+ " for RM800K");

                        System.out.println("5.End Turn");
                        int decision = keyboard.nextInt();
                        while (decision>=1 &&  decision<=5){
                            decision = keyboard.nextInt();
                        }
                        if (decision ==1){
                            playerMoney[currentPlayer]-=200000;
                            locHouses[j]++;
                            System.out.println(playerNames[currentPlayer]+" bought 1 house on "+ locName[j]);
                            System.out.println("Bank Account: "+ playerMoney[currentPlayer]);
                        }
                        else if(decision == 2){
                            playerMoney[currentPlayer]-=400000;
                            locHouses[j]++;
                            System.out.println(playerNames[currentPlayer]+" bought 2 house on "+ locName[j]);
                            System.out.println("Bank Account: "+ playerMoney[currentPlayer]);
                        }
                        else if(decision == 3){
                            playerMoney[currentPlayer]-=600000;
                            locHouses[j]++;
                            System.out.println(playerNames[currentPlayer]+" bought 3 house on "+ locName[j]);
                            System.out.println("Bank Account: "+ playerMoney[currentPlayer]);
                        }
                        else if(decision == 4){
                            playerMoney[currentPlayer]-=800000;
                            locHouses[j]++;
                            System.out.println(playerNames[currentPlayer]+" bought 4 house on "+ locName[j]);
                            System.out.println("Bank Account: "+ playerMoney[currentPlayer]);
                        }
                        else if(decision == 5){
                            return;
                        }
                        break;
               }
               case 1:{
                        System.out.println("1.Buy 1 house"+ locName[j]+ " for RM200K");
                        System.out.println("2.Buy 2 house"+ locName[j]+ " for RM400K");
                        System.out.println("3.Buy 3 house"+ locName[j]+ " for RM600K");
                        System.out.println("4.End Turn");
                        int decision = keyboard.nextInt();
                        while (decision>=1 &&  decision<=4){
                            decision = keyboard.nextInt();
                        }
                        if (decision ==1){
                            playerMoney[currentPlayer]-=200000;
                            locHouses[j]++;
                            System.out.println(playerNames[currentPlayer]+" bought 1 house on "+ locName[j]);
                            System.out.println("Bank Account: "+ playerMoney[currentPlayer]);
                        }
                        else if(decision == 2){
                            playerMoney[currentPlayer]-=400000;
                            locHouses[j]++;
                            System.out.println(playerNames[currentPlayer]+" bought 2 house on "+ locName[j]);
                            System.out.println("Bank Account: "+ playerMoney[currentPlayer]);
                        }
                        else if(decision == 3){
                            playerMoney[currentPlayer]-=600000;
                            locHouses[j]++;
                            System.out.println(playerNames[currentPlayer]+" bought 3 house on "+ locName[j]);
                            System.out.println("Bank Account: "+ playerMoney[currentPlayer]);
                        }
                        else if(decision == 4){
                            return;
                        }
                        break;
               }
               case 2:{
                        System.out.println("1.Buy 1 house"+ locName[j]+ " for RM200K");
                        System.out.println("2.Buy 2 house"+ locName[j]+ " for RM400K");
                        System.out.println("3.End Turn");
                        int decision = keyboard.nextInt();
                        while (decision>=1 &&  decision<=3){
                            decision = keyboard.nextInt();
                        }
                        if (decision ==1){
                            playerMoney[currentPlayer]-=200000;
                            locHouses[j]++;
                            System.out.println(playerNames[currentPlayer]+" bought 1 house on "+ locName[j]);
                            System.out.println("Bank Account: "+ playerMoney[currentPlayer]);
                        }
                        else if(decision == 2){
                            playerMoney[currentPlayer]-=400000;
                            locHouses[j]++;
                            System.out.println(playerNames[currentPlayer]+" bought 2 house on "+ locName[j]);
                            System.out.println("Bank Account: "+ playerMoney[currentPlayer]);
                        }
                        else if(decision == 3){
                            return;
                        }
                        break;
               }
               case 3: {
                        System.out.println("1.Buy 1 house"+ locName[j]+ " for RM200K");
                        System.out.println("2.End Turn");
                        int decision = keyboard.nextInt();
                        while (decision>=1 &&  decision<=2){
                            decision = keyboard.nextInt();
                        }
                        if (decision ==1){
                            playerMoney[currentPlayer]-=200000;
                            locHouses[j]++;
                            System.out.println(playerNames[currentPlayer]+" bought 1 house on "+ locName[j]);
                            System.out.println("Bank Account: "+ playerMoney[currentPlayer]);
                        }
                        else if(decision == 2){
                            return;
                        }
                        break;
               }
               case 4:{
                        System.out.println("End Turn");
                        System.out.println("Bank Account: "+ playerMoney[currentPlayer]);
                        break;
               }
    }
}
    
    static void jail (int[] playerLocation, int currentPlayer, String[] playerNames){
        playerLocation[currentPlayer]=30;
        System.out.println(playerNames[currentPlayer]+" went to jail.");
    }
    
    static void tax (int[] playerMoney, int currentPlayer, String[] playerNames){
        playerMoney[currentPlayer]-=2000000;
        System.out.println(playerNames[currentPlayer]+" paid taxes RM 2M");
        System.out.println("Bank Account: "+ playerMoney[currentPlayer]);
    }
    
   static int getPropertyIndex(String propertyName, String[] locName) {
    for (int i = 0; i < locName.length; i++) {
        if (locName[i].equalsIgnoreCase(propertyName)) {
            return i; // Return the index if the property is found
        }
    }
    return -1; // Return -1 if the property is not found
}


static void sellProperty(String propertyName, int currentPlayer, String[] playerNames, int[] playerMoney, int[] locHouses, int[] locPrices, String[] locName) {
    int propertyIndex = getPropertyIndex(propertyName, locName);

    int sellPrice = locPrices[propertyIndex] / 2;

    // Sell hotels first
    while (locHouses[propertyIndex] == 5) {
        playerMoney[currentPlayer] += sellPrice;
        locHouses[propertyIndex] = 0; // Reset the number of houses
        System.out.println(playerNames[currentPlayer] + " sold a hotel on " + propertyName + " to the Creator");
        System.out.println("Bank Account: " + playerMoney[currentPlayer]);
    }

    // Sell houses next
    while (locHouses[propertyIndex] > 0) {
        playerMoney[currentPlayer] += sellPrice;
        locHouses[propertyIndex]--; // Reduce the number of houses
        System.out.println(playerNames[currentPlayer] + " sold a house on " + propertyName + " to the Creator");
        System.out.println("Bank Account: " + playerMoney[currentPlayer]);
    }

    // Sell the property itself
    playerMoney[currentPlayer] += sellPrice;
    System.out.println(playerNames[currentPlayer] + " sold " + propertyName + " to the Creator");
    System.out.println("Bank Account: " + playerMoney[currentPlayer]);
}


static void declareBankruptcy(int currentPlayer, String[] playerNames, int[] playerMoney, int[] locHouses, int[] locPrices, String[] locName) {
    // Check if the player is bankrupt
    if (playerMoney[currentPlayer] < 0) {
        System.out.println(playerNames[currentPlayer] + " is declared bankrupt!");

        // Sell buildings and properties to settle the debt
        for (int i = 0; i < locName.length; i++) {
            if (locHouses[i] > 0) {
                sellProperty(locName[i], currentPlayer, playerNames, playerMoney, locHouses, locPrices, locName);
            }

            if (locName[i].equalsIgnoreCase(playerNames[currentPlayer])) {
                // Sell the property itself to the Creator
                int sellPrice = locPrices[i] / 2;
                playerMoney[currentPlayer] += sellPrice;
                System.out.println(playerNames[currentPlayer] + " sold " + locName[i] + " to the Creator");
                System.out.println("Bank Account: " + playerMoney[currentPlayer]);
            }
        }

        // Check if the player is still bankrupt after selling buildings and properties
        if (playerMoney[currentPlayer] < 0) {
            System.out.println(playerNames[currentPlayer] + " is still bankrupt!");

            // Turn over all assets to the Creator
            playerMoney[currentPlayer] = 0;
            System.out.println(playerNames[currentPlayer] + " turned over all assets to the Creator.");

            // Retire from the game
            System.out.println(playerNames[currentPlayer] + " retired from the game.");

            
        }
    }
}
}