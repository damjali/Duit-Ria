
package duitria;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        //runs CLI
        DuitRIa game = new DuitRIa();
        game.playGame();     
        
        //Uncomment and comment CLI to run GUI
        // System.setProperty("sun.java2d.uiScale", "1.0");
        // HomeScreenGUI homescreengui = new HomeScreenGUI();
    }
}