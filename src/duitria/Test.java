package duitria;

import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        PlayerTest player1 = new PlayerTest("Amir");
        PlayerTest player2 = new PlayerTest("Hakim");
        String filePath = "saveGame.ser";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(player1);
            oos.writeObject(player2);
            System.out.println("Game saved");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error occured: " + e.getMessage());
        }
    }
}
class PlayerTest implements Serializable {
    String name;
    PlayerTest(String name) {
        this.name = name;
    }
}