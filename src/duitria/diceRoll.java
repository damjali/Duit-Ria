package duitria;

import javax.swing.*;
import javax.swing.border.Border;
import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;




public class diceRoll extends JFrame {

    int count = 0;
    int diceValuePlayer1,diceValuePlayer2,diceValuePlayer3,diceValuePlayer4;
    String player1, player2, player3, player4;
    boolean differentValues = false;
    Border border = BorderFactory.createLineBorder(Color.WHITE,1);
    ArrayList<playerDiceMove> arrayListPlayers = new ArrayList<playerDiceMove>();
    boolean allPlayersRolled = false;

    public diceRoll(){
        this.setTitle("Rolling Double Dice");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(700, 700));
        this.pack();
        this.setBackground(Color.BLACK);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
         

    }

    public void getName(String a, String b, String c, String d){
        this.player1 = a;
        this.player2 = b;
        this.player3 = c;
        this.player4 = d;
    }


    public void addGuiComponents(){
        JPanel jPanel = new JPanel();
        JPanel panelPlayerMove = new JPanel();

        playerDiceMove playerdicemove1 = new playerDiceMove(45, this, player1);
        playerDiceMove playerdicemove2 = new playerDiceMove(200, this, player2);
        playerDiceMove playerdicemove3 = new playerDiceMove(355, this, player3);
        playerDiceMove playerdicemove4 = new playerDiceMove(510, this, player4);


  

        jPanel.setLayout(null);
        jPanel.setBackground(Color.black);


        // //1.Banner
        // JLabel bannerImg = ImgService.loadImage("resources/banner.png");
        // bannerImg.setBounds(45, 25, 600, 100);
        // jPanel.add(bannerImg);


        //2. Dices
        // JLabel diceOneImg = ImgService.loadImage("DiceIcons\\DICE1.png");

        JLabel diceOneImg = new JLabel();
        diceOneImg.setIcon(imageicon.getResizedImage("src\\duitria\\DiceIcons\\DICE1.png",200,200));
        diceOneImg.setBounds(100, 50, 200, 200);
        jPanel.add(diceOneImg);

        JLabel diceTwoImg = new JLabel();
        diceTwoImg.setIcon(imageicon.getResizedImage("src\\duitria\\DiceIcons\\DICE1.png",200,200));
        diceTwoImg.setBounds(390, 50, 200, 200);
        jPanel.add(diceTwoImg);

        //3. Start Game Button
        JButton startGameButton = new JButton("Start Game!");
        startGameButton.setBounds(260, 550, 200, 50);
        startGameButton.setEnabled(false);
        startGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String newPlayer1 = arrayListPlayers.get(0).playerName;
                String newPlayer2 = arrayListPlayers.get(1).playerName;
                String newPlayer3 = arrayListPlayers.get(2).playerName;
                String newPlayer4 = arrayListPlayers.get(3).playerName;
                System.out.println(newPlayer1 + newPlayer2 + newPlayer3 + newPlayer4);
                diceRoll.this.dispose();

                Board board = new Board();
                board.setName(newPlayer1, newPlayer2, newPlayer3, newPlayer4);
                
            }
        });
        //3. Roll Button

        Random rand = new Random();
        JButton rollButton = new JButton("Roll!");
        rollButton.setBounds(50, 550, 200, 50);
        rollButton.addActionListener(new ActionListener() {



        

            @Override

        public void actionPerformed(ActionEvent e) {
            
                rollButton.setEnabled(false);

                // roll for 3 seconds
                long startTime = System.currentTimeMillis();
                Thread rollThread = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        long endTime = System.currentTimeMillis();
                        try{
                            
                            while((endTime - startTime)/1000F < 0.5){
                                // roll dice
                                int diceOne = rand.nextInt(1, 7);
                                int diceTwo = rand.nextInt(1, 7);
                                int sum = diceOne + diceTwo;

                                if (count % 4 == 0) {
                                    playerdicemove1.diceValue = sum;
                                    playerdicemove1.labelDiceValue.setText(String.valueOf(sum));
                                    System.out.println(playerdicemove1.diceValue);
                                } else if (count % 4 == 1) {
                                    playerdicemove2.diceValue = sum;
                                    playerdicemove2.labelDiceValue.setText(String.valueOf(sum));
                                    System.out.println(playerdicemove2.diceValue);
                                } else if (count % 4 == 2) {
                                    playerdicemove3.diceValue = sum;
                                    playerdicemove3.labelDiceValue.setText(String.valueOf(sum));
                                    System.out.println(playerdicemove3.diceValue);
                                } else if (count % 4 == 3) {
                                    playerdicemove4.diceValue = sum;
                                    playerdicemove4.labelDiceValue.setText(String.valueOf(sum));
                                    System.out.println(playerdicemove4.diceValue);
                                }



                                // update dice images
                                diceOneImg.setIcon(imageicon.getResizedImage("src\\\\duitria\\\\DiceIcons\\DICE" + diceOne + ".png",200,200));
                                diceTwoImg.setIcon(imageicon.getResizedImage("src\\duitria\\DiceIcons\\DICE" + diceTwo + ".png",200,200));

                               
                            
                                // sleep thread
                                Thread.sleep(60);

                                endTime = System.currentTimeMillis();
                                
                            }


                            if (count%4==0){
                            playerdicemove1.diceValue2 = playerdicemove1.diceValue;

                            }
                            if (count%4==1){
                            playerdicemove2.diceValue2 = playerdicemove2.diceValue;
 
                            } 
                            if (count%4==2){
                            playerdicemove3.diceValue2 = playerdicemove3.diceValue;

                            }
                            if (count%4==3){
                            playerdicemove4.diceValue2 = playerdicemove4.diceValue;
 
                            }


                          count++;
                          System.out.println("count is : " + count);
                            
                            if (count%4==0){
                                if (playerdicemove1.diceValue2 != playerdicemove2.diceValue2 && 
                                    playerdicemove1.diceValue2 != playerdicemove3.diceValue2 && 
                                    playerdicemove1.diceValue2 != playerdicemove4.diceValue2 && 

                                    playerdicemove2.diceValue2 != playerdicemove3.diceValue2 &&
                                    playerdicemove2.diceValue2 != playerdicemove4.diceValue2 &&  
                                    
                                    playerdicemove3.diceValue2 != playerdicemove4.diceValue2 ){
                                    
                                    rollButton.setEnabled(false);
                                    startGameButton.setEnabled(true);
                                    arrayListPlayers.add(playerdicemove1);
                                    arrayListPlayers.add(playerdicemove2);
                                    arrayListPlayers.add(playerdicemove3);
                                    arrayListPlayers.add(playerdicemove4);

                                    Collections.sort(arrayListPlayers, new Comparator<duitria.diceRoll.playerDiceMove>() {
                                            @Override
                                            public int compare(duitria.diceRoll.playerDiceMove playerdicemove1, duitria.diceRoll.playerDiceMove playerdicemove2) {
                                                
                                                return Integer.compare(playerdicemove1.diceValue, playerdicemove2.diceValue);
                                            }
                                        });
                                }
                                else {
                                    


                                    


                                    rollButton.setEnabled(true);
                                }
                                
                            }
                            else
                            rollButton.setEnabled(true);



                            


                        }catch(InterruptedException e){
                            System.out.println("Threading Error: " + e);
                        }
                    
                }
                });
                rollThread.start();
            }
        });
        jPanel.add(rollButton);
        jPanel.add(startGameButton);

        this.getContentPane().add(jPanel);


        

    }






class playerDiceMove extends JPanel{

    JPanel panelPlayerName = new JPanel();
    JPanel panelDiceValue = new JPanel();
    JLabel playerLabelName = new JLabel();
    JLabel labelDiceValue1 = new JLabel();
    JLabel labelDiceValue = new JLabel();
    String playerName;
    int diceValue;
    int diceValue2;

    playerDiceMove(int x, JFrame frame, String playerName){
        this.setBounds(x, 300, 135, 200);
        this.setBackground(new Color(143,143,143));
        this.setBorder(border);
        this.setLayout(null);
        this.playerName = playerName;
  

        panelPlayerName.setBounds(0, 0, 135, 30);
        panelPlayerName.setBackground(Color.darkGray);
        panelPlayerName.setBorder(border);
        playerLabelName.setText(playerName);
        playerLabelName.setForeground(Color.white);
        playerLabelName.setFont(new Font("Arial", Font.BOLD, 15));
        playerLabelName.setBounds(0, 0,135, 30);
        playerLabelName.setVisible(true);
        panelPlayerName.add(playerLabelName);

        panelDiceValue.setBounds(0, 30, 135, 170);
        panelDiceValue.setOpaque(false);


        labelDiceValue.setFont(new Font("Arial", Font.BOLD, 120));
        panelDiceValue.add(labelDiceValue);
        
        



        this.add(panelDiceValue);
        this.add(panelPlayerName);
        frame.add(this);

    }
}
}



