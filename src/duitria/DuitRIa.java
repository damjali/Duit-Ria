package duitria;
import java.util.*;
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
        while (true) {
            System.out.print("How many players are playing: ");
            int playerNum = keyboard.nextInt();
            keyboard.nextLine();
            if (playerNum >= 2 && playerNum <= 4) {
                initializePlayers(playerNum);
                break;
            } else
            System.err.println("Error: Enter number 2-4");
        }
        sortedPlayerTurn();
        initializeTile();
    }
    private void initializePlayers(int playerNum) {
        for (int i = 1; i <= playerNum; i++) {
            System.out.print("Player " + i + " name: ");
            String name = keyboard.nextLine();
            players.add(new Player(name));
        }
    }
    private void initializeTile() {
        tiles.add(new Go("Go",2000000));
        tiles.add(new Tile("Petaling Street",600000 ,60000 ,"Green"));
        tiles.add(new FateCard("Fate"));
        tiles.add(new Tile("Jonker Street",600000 ,60000 ,"Green"));
        tiles.add(new Tax("Tax",2000000 ));
        tiles.add(new SpecialTile("KLIA",2000000 ,200000));
        tiles.add(new Tile("Masjid Jamek",1000000 ,100000 ,"Blue"));
        tiles.add(new FateCard("Fate Card"));
        tiles.add(new Tile("Batu Caves",1000000 ,100000 ,"Blue"));
        tiles.add(new Tile("Siri Maha Mariamman Temple",1200000 ,120000 ,"Blue"));
        tiles.add(new Jail("Jail"));
        tiles.add(new Tile("National Museum",1400000 ,140000 ,"Brown"));
        tiles.add(new Tile("Tenaga Nasional Berhad",1500000 ,150000, "No Colour"));
        tiles.add(new Tile("Royal Palace",1400000 ,140000 ,"Brown"));
        tiles.add(new Tile("Merdeka Square",1400000 ,140000 ,"Brown"));
        tiles.add(new SpecialTile("KLIA 2",2000000 ,200000));
        tiles.add(new Tile("A'Famosa Resort",1700000 ,170000, "Light Blue"));
        tiles.add(new FateCard("Fate Card"));
        tiles.add(new Tile("Kellie Castle",1800000 ,180000, "Light Blue"));
        tiles.add(new Tile("Stadthuys",2000000 ,200000, "Light Blue"));
        tiles.add(new FreeParking("Free Parking"));
        tiles.add(new Tile("Fraser's Hill",2200000 ,220000, "Purple"));
        tiles.add(new FateCard("Fate Card"));
        tiles.add(new Tile("Cameron Highlands",2200000 ,220000, "Purple"));
        tiles.add(new Tile("Genting Highland",2400000 ,240000, "Purple"));
        tiles.add(new SpecialTile("KL Sentral Station",2000000 ,200000));
        tiles.add(new Tile("Pahang National Park",2600000 ,260000 ,"Orange"));
        tiles.add(new Tile("Jabatan Bekalan Air",2600000 ,150000, "No Colour"));
        tiles.add(new Tile("Gunung Mulu National Park",2700000 ,260000 ,"Orange"));
        tiles.add(new Tile("Kinabalu National Park", 600000 ,270000 ,"Orange"));
        tiles.add(new GoToJail("Jail"));
        tiles.add(new Tile("Tioman Islands",3000000 ,300000 ,"Red"));
        tiles.add(new Tile("Perhentian Islands",3000000 ,300000 ,"Red"));
        tiles.add(new FateCard("Fate Card"));
        tiles.add(new Tile("Sepadan Islands",3200000 ,320000 ,"Red"));
        tiles.add(new SpecialTile("Pudu Sentral Station",2000000 ,200000));
        tiles.add(new FateCard("Fate Card"));
        tiles.add(new Tile("KLCC",3500000 ,350000, "Yellow"));
        tiles.add(new Tax("Tax",2000000));
        tiles.add(new Tile("Sepang II Circuit",4000000 ,400000, "Yellow"));
    }
    private void displayBoard() {
        System.out.println("Current Board State: ");
        for (Player player : players)
            System.out.printf(Locale.US, player.name + " is at position " + player.position + " with RM%,d.\n", player.money);
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
            if (propertyTile.owner == null) {
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
                                    sellingPropertiesPlayer(player, propertyTile.cost, false, false, null);
                                    System.out.println(player.name + " bought " + propertyTile.name + ".");
                                    player.money -= propertyTile.cost;
                                    propertyTile.owner = player;
                                }
                            }
                            
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
                    case "Blue", "Brown", "Light Blue", "Purple", "Orange", "Red":
                        if (colourCount == 3)
                            doubleRent = true;
                        break;
                }
                int rentAmount = propertyTile.baseRent + propertyTile.calculateRent(doubleRent);
                System.out.println(propertyTile.name + " is owned by " + propertyTile.owner.name + ".");
                System.out.printf(player.name + " has to pay rent of RM%,d.\n", rentAmount);
                if (rentAmount >= player.money) {
                    System.out.println("You don't have enough money to pay the rent.");
                    sellingPropertiesPlayer(player, rentAmount, false, true, );
                    player.money -= rentAmount;
                    propertyTile.owner.money += rentAmount;
                    System.out.println(player.name + " successfully paid the rent.");
                } else {
                    player.money -= rentAmount;
                    propertyTile.owner.money += rentAmount;
                    System.out.println(player.name + " successfully paid the rent.");
                }
            } else {
                System.out.println(player.name + " is visiting his land.");
                if (player.buyHouse) {
                    if (propertyTile.numOfHouse >= 0 && propertyTile.numOfHouse < 4) {
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
                                if (numOfHouse >= 0 && numOfHouse <= (4 - propertyTile.numOfHouse)) {
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
            if (specialTile.owner == null) {
                if (player.buyProperty) {
                    System.out.printf(Locale.US, "Do you want to buy " + specialTile.name + " for RM%,d? (Y/N):", specialTile.cost);
                    String choice = keyboard.nextLine();
                    if (choice.equalsIgnoreCase("Y")) {
                        if (specialTile.cost >= player.money) {
                            System.out.println("You do not enough money to buy " + specialTile.name + ".");
                            if (canSell(player)) {
                                sellingPropertiesPlayer(player, specialTile.cost, false);
                                System.out.println(player.name + " bought " + specialTile.name + ".");
                                player.money -= specialTile.cost;
                                specialTile.owner = player;
                            }
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
                    sellingPropertiesPlayer(player, specialTile.baseRent, false);
                    player.money -= specialTile.baseRent;
                    specialTile.owner.money += specialTile.baseRent;
                    System.out.println(player.name + " successfully paid the rent.");
                } else {
                    player.money -= specialTile.baseRent;
                    specialTile.owner.money += specialTile.baseRent;
                    System.out.println(player.name + " successfully paid the rent.");
                }
            } else if (specialTile.owner == player) {
                System.out.println(player.name + " is vitising his tile.");
            }
        } else if (currentTile instanceof FateCard) {
            FateCard fateCard = (FateCard) currentTile;
            System.out.print(player.name + " drew a " + fateCard.name + ": ");
            fateCardOutcome(player);
        } else if (currentTile instanceof Jail) {
                System.out.println(player.name + " is visitng the jail.");
        } else if (currentTile instanceof Tax) {
            Tax tax = (Tax) currentTile;
            System.out.printf(Locale.US, player.name + " has to pay the tax for RM%,d.\n", tax.cost);
            if (tax.cost >= player.money) {
                System.out.println("You don't have enough money to pay taxes.");
                sellingPropertiesPlayer(player, tax.cost, true);
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
            System.out.println(player.name + " has to go to " + goToJail.name + ".");
            player.jailCheck = true;
            player.position = 10;
        }
    }
    private void fateCardOutcome(Player player) {
        int randNum = rand.nextInt(10);
        switch(randNum) {
            case 0:
            System.out.println("Advance to Go and collect RM2,000,000.");
            player.position = 0;
            player.money += 2000000;
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
                        sellingPropertiesPlayer(otherPlayer, 100000, false);
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
            System.out.printf(Locale.US, player.name + " the total is RM%,d.\n", generalRepairTotal);
            if (generalRepairTotal >= player.money) {
                System.out.println("You don't have enough money to pay the repair on the houses.");
                sellingPropertiesPlayer(player, generalRepairTotal, true);
                player.money -= generalRepairTotal;
                System.out.printf(Locale.US, player.name + " successfully paid RM%,d.\n", generalRepairTotal);
            } else {
                player.money -= generalRepairTotal;
                System.out.printf(Locale.US, player.name + " successfully paid RM%,d.\n", generalRepairTotal);
            }
            break;
            case 7:
            System.out.println("Pay hospital fees of RM250,000.");
            if (250000 >= player.money) {
                System.out.println("You don't have enough money to pay the hospital fees.");
                sellingPropertiesPlayer(player, 250000, true);
            }
            player.money -= 250000;
            System.out.println(player.name + " successfully paid the hospital fees.");
            break;
            case 8:
            System.out.println("Pay school fees of RM100,000.");
            if (100000 >= player.money) {
                System.out.println("You don't have enough money to pay the hospital fees.");
                sellingPropertiesPlayer(player, 100000, true);
            }
            player.money -= 100000;
            System.out.println(player.name + " successfully paid the school fees.");
            break;
            case 9:
            System.out.println("Pay speeding fine of RM100,000.");
            if (100000 >= player.money) {
                System.out.println("You don't have enough money to pay the speeding fine.");
                sellingPropertiesPlayer(player, 100000, true);
            }
            player.money -= 100000;
            System.out.println(player.name + " successfully paid the speeding fine.");
            break;
            default:
            fateCardOutcome(player);
        }
    }
    private void fateCardRailRoad(Player player, Object currentTile) {
        SpecialTile specialTile = (SpecialTile) currentTile;
        System.out.println(player.name + " landed on " + specialTile.name);
        if (player.buyProperty) {
            if (specialTile.owner == null) {
                System.out.printf(Locale.US, "Do you want to buy " + specialTile.name + " for RM%,d? (Y/N):", specialTile.cost);
                String choice = keyboard.nextLine();
                if (choice.equalsIgnoreCase("Y")) {
                    if (specialTile.cost >= player.money) {
                        System.out.println("Not enough money to buy " + specialTile.name + ".");
                        if (canSell(player)) {
                            sellingPropertiesPlayer(player, specialTile.cost, false);
                            System.out.println(player.name + " bought " + specialTile.name + ".");
                            player.money -= specialTile.cost;
                            specialTile.owner = player;
                        }
                    } else {
                        System.out.println(player.name + " bought " + specialTile.name + ".");
                        player.money -= specialTile.cost;
                        specialTile.owner = player;
                    }
                }
            } else if (specialTile.owner != player) {
                System.out.println(specialTile.name + " is owned by " + specialTile.owner.name + ".");
                System.out.printf(player.name + " has to pay double of rent for RM%,d because of group colour.\n", (specialTile.baseRent * 2));
                if ((specialTile.baseRent * 2) >= player.money) {
                    System.out.println("You don't have enough money to pay the rent.");
                    sellingPropertiesPlayer(player, (specialTile.baseRent * 2), false);
                    player.money -= (specialTile.baseRent * 2);
                    specialTile.owner.money += (specialTile.baseRent * 2);
                    System.out.println(player.name + " successfully paid the rent.");
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
    private void sellingPropertiesPlayer(Player player, int cost, boolean creatorDebt, boolean playerDebt, Player tileOwner) { 
        List<Tile> propertySelector = new ArrayList<>();
        List<SpecialTile> specialTileSelector = new ArrayList<>();
        boolean propertySellCheck = true, bankrupt = false;
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
            System.out.println(player.name + " is now bankrupt!");
            player.bankruptcy = true;
        }
        while (propertySellCheck) {
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
            if (houseCount > 0 && cost >= player.money) {
                int count = 0, choice;
                System.out.println("\nYou have a total asset of " + tileCount + " land(s) and " + houseCount + " house(s).");
                System.out.println("Each and every property sold back to the creator, the owner will only get one-half(1/2) of it back.");
                System.out.printf(Locale.US, "You have a total of RM%,.0f in land(s) and RM%,.0f in house(s) (after Creator's cut).\n", (tileCost * 0.5), (houseCost * 0.5));
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
                        propertySellCheck = false;
                        break;
                    }
                }
            }
            if (cost >= player.money && playerDebt) {
                System.out.println("You have to turn over all your asset to the owner of the tile.");
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
                        break;
                    } else {
                        propertySellCheck = false;
                        break;
                    }
                }
            }
            if (bankrupt && cost >= player.money) {
                System.out.println("You can't afford to pay that much!");
                playerLoan(player);
                propertySellCheck = false;
            }
        }
    }
    private void playerLoan(Player player) {
        if (!player.hasLoan) {
            System.out.print("Do you want to make a loan? (Y/N) :");
            String choice = keyboard.nextLine();
            if (choice.equalsIgnoreCase("Y")) { //make loan algorithm
                System.out.print("How much do you want to loan?: RM");
                player.loanAmount = keyboard.nextInt();
                System.out.printf(Locale.US, "You have submitted a loan for RM%,.f2.\n", player.loanAmount);
                player.hasLoan = true;
            } else {
                bankrupt(player);
            }
        } else {
            System.out.printf(player.name + " already has a loan of RM%,d.\n", player.loanAmount);
            System.out.println("Do you want to pay the loan now? (Y/N): ");
            String choice = keyboard.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                double interestRate = 1.1;
                double payment = player.loanAmount * interestRate;
                System.out.printf(Locale.US, "The total payment is: RM%,.2f.\n", payment);
                if (player.money <= payment) {
                    System.out.println("You don't have enough money to pay your loan.");
                    bankrupt(player);
                } else {
                    player.money -= payment;
                    System.out.println(player.name + "has successfully paid his loan.");
                }
            } else {
                System.out.println("Your loan will continue on for another " + player.loanPeriod + " moves.");
            }
        }
    }
    private void bankrupt(Player player) {
        System.out.println(player.name + " has declared bankruptcy.");
        player.bankruptcy = true;
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
        for(Player player : players) {
            System.out.println("Player " + count + " is " + player.name + ".");
            count++;
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
    private int onePlayerLeft() {
        int activePlayerAmount = 0;
        for (Player player : players) {
            if  (!player.bankruptcy)
                activePlayerAmount++;
        }
        return activePlayerAmount;
    }
    void playGame() {
        int diceRoll1, diceRoll2, diceRoll;
        keyboard = new Scanner(System.in);
        boolean gameRunning = true;
        while (gameRunning) {
            Player currentPlayer = players.get(currentPlayerIndex);
            displayBoard();
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
                        sellingPropertiesPlayer(currentPlayer, 250000, true);
                        currentPlayer.money -= 250000;
                        currentPlayer.jailCheck = false;
                    } else {
                        currentPlayer.money -= 250000;
                        currentPlayer.jailCheck = false;
                    }
                    diceRoll = diceRoll1 + diceRoll2;
                    currentPlayer.position += diceRoll;
                    playerTurn(currentPlayer, diceRoll);
                }
            } else if (currentPlayer.bankruptcy) {
                System.out.println(currentPlayer.name + " has already declared bankrupty.");
            } else {
                playerTurn(currentPlayer,0);
            }
            if (onePlayerLeft() == 1) {
                for (Player player : players) {
                    if (player.bankruptcy) {
                        System.out.println(player.name + " wins!");
                        gameRunning = false;
                    }
                }
            }
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
        System.out.println("DuitRia has come to an end, thanks for playing!");
    }
}