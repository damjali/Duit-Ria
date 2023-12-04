package duitria;

class Tile {
    String name;
    int cost;
    int baseRent;
    Player owner;
    int houseCost;
    int numOfHouse;
    public Tile(String name, int cost, int baseRent) {
        this.name = name;
        this.cost = cost;
        this.baseRent = baseRent;
        this.houseCost = 200000;
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
class SpecialTile {
    String name;
    int cost;
    int baseRent;
    Player owner;
    public SpecialTile(String name, int cost, int baseRent) {
        this.name = name;
        this.cost = cost;
        this.baseRent = baseRent;
        this.owner = null;
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
class FateCard {
    String name;
    public FateCard(String name) {
        this.name = name;
    }
}
class FreeParking {
    String name;
    public FreeParking(String name) {
        this.name = name;
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