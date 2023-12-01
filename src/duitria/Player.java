package duitria;

class Player {
    String name;
    int money;
    int position;
    boolean jailCheck;
    int turn;
    int diceRoll;
    public Player(String name, int money) {
        this.name = name;
        this.money = money;
        this.position = 0;
        this.jailCheck = false;
        this.turn = 0;
        this.diceRoll = 0;
    }
}