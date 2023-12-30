
package duitria;
import java.awt.Color;
import java.util.*;
import javax.swing.*;

public class GameRules {
    GameRules(){

        Scanner user_input = new Scanner(System.in);
        JFrame window = new JFrame("Game Rules");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextArea textArea = new JTextArea(10,20);
        JScrollPane scroll = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        String string = gamerulestext();
        textArea.setText(string);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        window.add(scroll);
        textArea.setBackground(Color.WHITE);
        window.setVisible(true);
        window.setSize(798, 425);
        window.setLocationRelativeTo(null);
}
    
    public static String gamerulestext(){
        String string = """
                        DUITRIA 
                        
                        A. Introduction
                        The project of the game is to become the wealthiest player through buying, renting, and 
                        selling property. 
                        
                        B. The Play : 
                        
                        - “DuitRia” can be played up to 4 players per game. 
                        - Each player will get deposit RM 15M from the Creator before starting the game. 
                        - Each player must throw the dice, the player with the highest total will take their turn first following the next players. 
                        - Players will place on the corner marked "GO," throw the dice and move in the direction of the arrow the number of spaces indicated by the dice. After you have completed your play, the turn passes to the left. The players remain on the spaces occupied and proceed from that point on the player's next turn. 
                        - Two or more players may rest on the same space at the same time. According to the space you reached, you may be entitled to buy real estate or other properties - or obliged to pay 
                        rent, pay taxes, draw a Fate or Community Chest card, "Go to Jail," etc. 
                        
                        C. Game rules/mechanics: 
                        
                      

                        1. Number of players: 2 - 4 
                        
                        2. Two unbiased six-sided dice is used. 
                        
                        3. Every player begins at “GO” tile. 
                        
                        4. Starting by every player rolls the dice, highest number go first while lowest number go last. 
                        
                        5. Number of steps taken by player is determined by the dice, one roll (each dice) per player's turn, no special move or 'roll the dice twice'. 
                        
                        6. Property Ownership: 
                        
                        7. Players can purchase unowned properties that they land on. They can pass to next turn if they choose not to purchase it. If you land on the owned property again, you can enhance them by building houses. 
                        
                        8. Landing on an already owned properties required the active player to pay rent to the owner. 
                        
                        9. When you land on either of the card spaces, card will select randomly, thus you must follow the instructions and return the card.
                        
                        10. If you land at TAX you will be deducted RM 2M from your account.
                        
                        11. You land in Jail when :
                        
                        	(I) you lands on the space marked "Go to Jail"; 
                        	(2) you draw a card marked "Go to Jail. 
                        
                        When you are sent to Jail you cannot collect your RM 2M salary in that move since, regardless of where you is on the board, you must move it directly into Jail. Your turn ends when you are sent to Jail. If you are not "sent" to Jail but in the ordinary course of play land on that space, you are "Just Visiting," you incur no penalty, and you move ahead in the usual manner 
                        on your next turn. 
                        
                        You get out of Jail by :
                        
                        	throwing doubles on your next turns(only once); if you succeed in doing this you immediately move forward the number of spaces shown by your doubles throw. If you do not throw doubles by your turn, you must pay the RM 250K fine. You then get out of Jail and immediately move forward the number of spaces shown by your throw. Even though you are in Jail, you may sell property, and collect rents.
                        
                        12. FREE PARKING: A player landing on this place does not receive any money, property, or reward of any kind. This is just a "free" resting place.
                        
                        13. GO: Each time a players lands on or passes over GO, whether by throwing the dice or  drawing a card, the player will get RM 2M. The RM 2M is paid only once each time round the board.
                        
                        14. PAYING RENT: When you land on property owned by another player, the owner collects rent from you in accordance with the list printed on its Title Deed card. It is even more advantageous to have houses or hotels on properties because rents are much higher than unimproved properties. 
                        
                        15. HOUSES: For the first round, the players only must go through all unimproved properties until arriving “GO” for the second round. Second round, you can only buy an unowned property from the Creator. For the third round and upper, you may buy houses and erect them on those properties(player can chose how many houses that he/she want to buy but limit to 4 for each land). 
                        The price you must pay for each house is shown on your Title Deed card for the property on which you erect the house. The owner still collects double rent from an opponent who lands on the unimproved properties of his/her complete color-group.You can buy or erect more than one house on any one property of any color-group up to limit 4 houses to a property. You may have to choose either want to build houses evenly for every property or want to build randomly houses to property of any color-group.As you build randomly, you must total down all of houses that you want to sell.
                        
                        16. SELLING PROPERTIES : Player can sell any unimproved properties, railroads and utilities (include buildings) that they have to the Creator for one-half the price paid for them but cannot sell it to other players. To sell buildings, they have to follow the order of building in which have to sell the hotel, houses and properties accordingly.
                        
                        17. BANKRUPTCY: You are declared bankrupt if you owe more than you can pay either to another player or to the Creator. If your debt is to another player, you must tum over to 
                        that player all that you have of value and retire from the game. In making this settlement, if you own houses or hotels, you must return these to the Creator in exchange for money to the 
                        extent of one-half the amount paid for them; this cash is given to the Creator. Should you owe the Creator, instead of another player, more than you can pay (because of taxes or penalties) even by selling off buildings, you must turn over all assets to the Creator. A bankrupt player must immediately retire from the game. The last player left in the game wins.
                        
                        18. MISCELLANEOUS : Money can be loaned to a player only by the Creator. No player may borrow from or lend money to another player.
                        
                        
                        D. End game conditions: 
                        
                        1. Only one player left in the game without bankrupt. 
                        2. If all players decide to quit the game, the winner is determined by the highest total property value, followed by total amount of money. 
                        
                        
                        E. List of Fate Cards 
                        
                        I. Advance to Go (Collect RM 2M) 
                        II. Advance to the nearest Railroad. If unowned, you may buy it from the Bank. If 
                        owned, pay wonder twice the rental to which they are otherwise entitled 
                        III. It is your birthday. Collect RM 100K from every player 
                        IV. Bank error in your favor. Collect RM 2M 
                        V. Go Back 3 Spaces 
                        VI. Go to Jail. Go directly to Jail, do not pass Go, do not collect RM 2M 
                        VII. Make general repairs on all your property. For each house pay RM 200K. 
                        VIII. Pay hospital fees of RM 250K 
                        IX. Pay school fees of RM 100K 
                        X. Speeding fine RM 100K 
                        
                        
                        
                        
                        
                        
                        
                        """;
        return string;
    }
 
}
