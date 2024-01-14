package duitria;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Test2 {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("saveGame.ser"))) {
            PlayerTest player1 = (PlayerTest) ois.readObject();
            PlayerTest player2 = (PlayerTest) ois.readObject();
            System.out.println(player1.name);
            System.out.println(player2.name);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("An error occured: " + e.getMessage());
        }
    }
}
