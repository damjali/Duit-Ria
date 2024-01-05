
package duitria;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        System.setProperty("sun.java2d.uiScale", "1.0");
        HomeScreenGUI homescreengui = new HomeScreenGUI();
        //hello bro
        DuitRIa game = new DuitRIa();
        game.playGame();
    
}
}