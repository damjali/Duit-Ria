package duitria;

class Player {
    String name;
    int money;
    int position;       // 
    boolean jailCheck;  // check if player in jail or not
    int turn;           // 
    int diceRoll;       // 
    boolean playerLoan; // check if player is under a loan
    boolean bankruptcy; // 
    boolean buyProperty;//
    boolean buyHouse;   //
    public Player(String name) {
        this.name = name;
        this.money = 15000000;
        this.position = 0;
        this.jailCheck = false;
        this.turn = 0;
        this.diceRoll = 0;
        this.playerLoan = false;
        this.bankruptcy = false;
        this.buyProperty = false;
        this.buyHouse = false;
    }
}