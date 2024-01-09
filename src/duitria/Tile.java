package duitria;

import java.io.Serializable;

class Tile implements Serializable{
    String name;        // tile's name
    int cost;           // tile's cost
    int baseRent;       // tile's base rent
    String tileColour;  // tile's colour group
    Player owner;       // tile's ownership (based on player's reference)
    int houseCost;      // tile's housecost
    int numOfHouse;     // tile's number of houses built
    public Tile(String name, int cost, int baseRent, String tileColour) {
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
class SpecialTile implements Serializable{
    String name;    // special tile's name
    int cost;       // special tile's cost
    int baseRent;   // special tile's base rent
    Player owner;   // special tile's ownership (based on player's reference)
    public SpecialTile(String name, int cost, int baseRent) {
        this.name = name;
        this.cost = cost;
        this.baseRent = baseRent;
        owner = null;
    }
}
class Tax implements Serializable{
    String name;    // tax's tile name
    int cost;       // tax's cost
    public Tax(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
}
class Go implements Serializable{
    String name;    // go tile's name
    int payment;    // go tile's payment
    public Go(String name, int payment) {
        this.name = name;
        this.payment = payment;
    }
}
class FateCard implements Serializable{
    String name;    // fatecard tile's name
    public FateCard(String name) {
        this.name = name;
    }
}
class FreeParking implements Serializable{
    String name;    //free parking tile's name
    public FreeParking(String name) {
        this.name = name;
    }
}
class Jail implements Serializable{
    String name;    // jail tile's name
    public Jail(String name) {
        this.name = name;
    }
}
class GoToJail implements Serializable{
    String name;    // go to jail tile's name
    public GoToJail(String name) {
        this.name = name;
    }
}