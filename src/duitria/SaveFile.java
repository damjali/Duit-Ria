package duitria;
import java.io.*;
import java.util.*;

class SaveFile {
    boolean newGame = true;
    List<Player> players;
    List<Object> tiles;
    void saveGame(List<Player> players, List<Object> tiles, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(players);
            oos.writeObject(tiles);
            System.out.println("Game saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error occured: " + e.getMessage());
        }
    }
    
    void loadGame(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            players = (List<Player>) ois.readObject();
            tiles = (List<Object>) ois.readObject();

            // Use loadedPlayers and loadedTiles as needed
            System.out.println("Game loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        newGame = false;
    }
}