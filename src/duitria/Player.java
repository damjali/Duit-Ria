package duitria;

import java.io.Serializable;

class Player implements Serializable {
    String name;            // player's name
    int money;              // total money of the player
    int loanAmount;         // player's loan amount
    int loanPeriod;         // duration of the player's loan
    int position;           // player's position on the board
    int turn;               // which turn
    int diceRoll;           // diceRoll for the round
    boolean jailCheck;      // check if player in jail or not
    boolean playerLoan;     // check if player is under a loan
    boolean loanPeriodCheck;// check if the player's loan period been checked or not
    boolean bankruptcy;     // check if the player is bankrupt or not
    boolean buyProperty;    // first round pass check to buy property
    boolean propertySellCheck; // checking while selling property
    boolean buyHouse;       // second round pass check to buy houses
    boolean hasLoan;        // check if the player has a loan or not
    public Player(String name) {
        this.name = name;
        money = 15000000;
        loanAmount = 0;
        position = 0;
        turn = 0;
        diceRoll = 0;
        jailCheck = false;
        playerLoan = false;
        bankruptcy = false;
        buyProperty = false;
        buyHouse = false;
        hasLoan = false;
        loanPeriodCheck = false;
        propertySellCheck = false;
    }
}