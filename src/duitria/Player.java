package duitria;
class Player {
    String name;
    double money;
    double loanAmount;
    int loanPeriod;
    int position;       // 
    int turn;           // 
    int diceRoll;       // 
    boolean jailCheck;  // check if player in jail or not
    boolean playerLoan; // check if player is under a loan
    boolean bankruptcy; // 
    boolean buyProperty;// 
    boolean buyHouse;   // 
    boolean hasLoan;    // 
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
    }
}