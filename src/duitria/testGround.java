package duitria;
import java.util.*;

public class testGround {
    private List<playerTest> players;

    class playerTest {
        String name;
        int diceRoll;

        public playerTest(String name) {
            this.name = name;
        }
    }

    private void startTest() {
        Random rand = new Random();
        HashMap<String, Integer> player = new HashMap<>();
        Set<Integer> diceRollSet = new HashSet<>();
        int diceRoll1, diceRoll2;
        players = new ArrayList<>();

        players.add(new playerTest("Amir"));
        players.add(new playerTest("Alia"));
        players.add(new playerTest("Zaf"));
        players.add(new playerTest("Aza"));

        // key and value
        player.put("Amir", 0);
        player.put("Alia", 0);
        player.put("Zaf", 0);
        player.put("Aza", 0);

        for (String playerName : player.keySet()) {
            do {
                diceRoll1 = rand.nextInt(6) + 1;
                diceRoll2 = rand.nextInt(6) + 1;
            } while (diceRollSet.contains(diceRoll1 + diceRoll2));

            int totalDiceRoll = diceRoll1 + diceRoll2;
            player.put(playerName, totalDiceRoll);
            diceRollSet.add(totalDiceRoll);
        }

        System.out.println("Original player order: " + players);

        // Sort the players list based on dice roll
        players.sort(Comparator.comparingInt(p -> player.get(p.name)));

        System.out.println("Sorted player order: " + players);

        // Call the players in the newly sorted order
        for (playerTest playerObj : players) {
            System.out.println("Calling player: " + playerObj.name);
        }
    }

    public static void main(String[] args) {
        testGround start = new testGround();
        start.startTest();
    }
}
