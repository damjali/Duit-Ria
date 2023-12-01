package duitria;
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
    String description;
    public FateCard(String description) {
        this.description = description;
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
