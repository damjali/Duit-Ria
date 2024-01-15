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
    PlayerSelection player1 = new PlayerSelection();
    PlayerSelection player2 = new PlayerSelection();
    PlayerSelection player3 = new PlayerSelection();
    PlayerSelection player4 = new PlayerSelection();
    String saveFileNameChoice;
    boolean differentValues = false;
    Border border = BorderFactory.createLineBorder(Color.WHITE,1);
    ArrayList<playerDiceMove> arrayListPlayers = new ArrayList<playerDiceMove>();
    boolean allPlayersRolled = false;
    playerDiceMove playerdicemove1;
    playerDiceMove playerdicemove2;
    playerDiceMove playerdicemove3;
    playerDiceMove playerdicemove4;
    JButton rollButton = new JButton("Roll!");
    Random rand = new Random();
    JLabel diceOneImg = new JLabel();
    JLabel diceTwoImg = new JLabel();
    JButton startGameButton = new JButton("Start Game!");
    int playerNumbers;

    public diceRoll(int playerNumber, String saveFileNameChoice){
        this.saveFileNameChoice = saveFileNameChoice;
        this.setTitle("Rolling Double Dice");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(700, 700));
        this.pack();
        this.setBackground(Color.BLACK);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        playerNumbers = playerNumber;
         

    }

    public void setSaveFileNameChoice(String saveFileNameChoice) {
        this.saveFileNameChoice = saveFileNameChoice;
    }

    public void getName(String a, String b, String c, String d){
        this.player1.name = a;
        this.player2.name = b;
        this.player3.name = c;
        this.player4.name = d;
    }

    public void getName(String a, String b, String c){
        this.player1.name = a;
        this.player2.name = b;
        this.player3.name = c;

    }

    public void getName(String a, String b){
        this.player1.name = a;
        this.player2.name = b;

    }

    public void getPath(String a, String b, String c, String d){
        this.player1.path = a;
        this.player2.path = b;
        this.player3.path = c;
        this.player4.path = d;
    }

    public void getPath(String a, String b, String c){
        this.player1.path = a;
        this.player2.path = b;
        this.player3.path = c;

    }

    public void getPath(String a, String b){
        this.player1.path = a;
        this.player2.path = b;

    }
    public void addGuiComponents(int playerNumber){
        
        JPanel jPanel = new JPanel();

        if (playerNumber == 4){
        playerdicemove1 = new playerDiceMove(45, this, player1.name, player1.path);
        playerdicemove2 = new playerDiceMove(200, this, player2.name, player2.path);
        playerdicemove3 = new playerDiceMove(355, this, player3.name, player3.path);
        playerdicemove4 = new playerDiceMove(510, this, player4.name, player4.path);
        }

        else if (playerNumber == 3){
        playerdicemove1 = new playerDiceMove(45, this, player1.name, player1.path);
        playerdicemove2 = new playerDiceMove(200, this, player2.name, player2.path);
        playerdicemove3 = new playerDiceMove(355, this, player3.name, player3.path);

        }
        else if (playerNumber == 2){
        playerdicemove1 = new playerDiceMove(45, this, player1.name, player1.path);
        playerdicemove2 = new playerDiceMove(200, this, player2.name, player2.path);
        }




  

        jPanel.setLayout(null);
        jPanel.setBackground(Color.black);

        diceOneImg = new JLabel();
        diceOneImg.setIcon(imageicon.getResizedImage("src\\duitria\\DiceIcons\\DICE1.png",200,200));
        diceOneImg.setBounds(100, 50, 200, 200);
        jPanel.add(diceOneImg);

        diceTwoImg = new JLabel();
        diceTwoImg.setIcon(imageicon.getResizedImage("src\\duitria\\DiceIcons\\DICE1.png",200,200));
        diceTwoImg.setBounds(390, 50, 200, 200);
        jPanel.add(diceTwoImg);



        //3. Start Game Button
        startGameButton = new JButton("Start Game!");
        startGameButton.setBounds(260, 550, 200, 50);
        startGameButton.setEnabled(false);
        startGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (playerNumbers == 4){

                player1.name = arrayListPlayers.get(3).playerName;
                player1.path = arrayListPlayers.get(3).path;
                player2.name = arrayListPlayers.get(2).playerName;
                player2.path = arrayListPlayers.get(2).path;
                player3.name = arrayListPlayers.get(1).playerName;
                player3.path = arrayListPlayers.get(1).path;
                player4.name = arrayListPlayers.get(0).playerName;
                player4.path = arrayListPlayers.get(0).path;
                System.out.println(player1.name + player2.name + player3.name + player4.name);
                diceRoll.this.dispose();

                Board board = new Board(4);
                board.setSaveFileNameChoice(saveFileNameChoice);
                board.setName(player1, player2, player3, player4);
                }

                else if (playerNumbers == 3){
                player1.name = arrayListPlayers.get(2).playerName;
                player1.path = arrayListPlayers.get(2).path;
                player2.name = arrayListPlayers.get(1).playerName;
                player2.path = arrayListPlayers.get(1).path;
                player3.name = arrayListPlayers.get(0).playerName;
                player3.path = arrayListPlayers.get(0).path;
                player4.name = "";
                player4.path = "";
                System.out.println(player1.name + player2.name + player3.name + player4.name);
                diceRoll.this.dispose();

                Board board = new Board(3);
                board.setSaveFileNameChoice(saveFileNameChoice);
                board.setName(player1, player2, player3, player4);
                }

                else if (playerNumbers == 2){
                player1.name = arrayListPlayers.get(1).playerName;
                player1.path = arrayListPlayers.get(1).path;
                player2.name = arrayListPlayers.get(0).playerName;
                player2.path = arrayListPlayers.get(0).path;
                player3.name = "";
                player3.path = "";
                player4.name = "";
                player4.path = "";
                System.out.println(player1.name + player2.name + player3.name + player4.name);
                diceRoll.this.dispose();

                Board board = new Board(2);
                board.setSaveFileNameChoice(saveFileNameChoice);
                board.setName(player1, player2, player3, player4);
                }
            }
        });


        if (playerNumber ==4)
            rollFunction4();

        else if (playerNumber ==3)
            rollFunction3();

        else if (playerNumber ==2)
            rollFunction2();
        

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
    String path;
    int diceValue;
    int diceValue2;

    playerDiceMove(int x, JFrame frame, String playerName, String path){
        this.setBounds(x, 300, 135, 200);
        this.setBackground(new Color(143,143,143));
        this.setBorder(border);
        this.setLayout(null);
        this.playerName = playerName;
        this.path = path;
        System.out.println("this is inside the playerdicemove" + this.playerName);

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


    
    public void rollFunction4(){
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

    }

    public void rollFunction3(){
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

                                if (count % 3 == 0) {
                                    playerdicemove1.diceValue = sum;
                                    playerdicemove1.labelDiceValue.setText(String.valueOf(sum));
                                    System.out.println(playerdicemove1.diceValue);
                                } else if (count % 3 == 1) {
                                    playerdicemove2.diceValue = sum;
                                    playerdicemove2.labelDiceValue.setText(String.valueOf(sum));
                                    System.out.println(playerdicemove2.diceValue);
                                } else if (count % 3 == 2) {
                                    playerdicemove3.diceValue = sum;
                                    playerdicemove3.labelDiceValue.setText(String.valueOf(sum));
                                    System.out.println(playerdicemove3.diceValue);
                                } 



                                // update dice images
                                diceOneImg.setIcon(imageicon.getResizedImage("src\\\\duitria\\\\DiceIcons\\DICE" + diceOne + ".png",200,200));
                                diceTwoImg.setIcon(imageicon.getResizedImage("src\\duitria\\DiceIcons\\DICE" + diceTwo + ".png",200,200));

                               
                            
                                // sleep thread
                                Thread.sleep(60);

                                endTime = System.currentTimeMillis();
                                
                            }


                            if (count%3==0){
                            playerdicemove1.diceValue2 = playerdicemove1.diceValue;

                            }
                            if (count%3==1){
                            playerdicemove2.diceValue2 = playerdicemove2.diceValue;
 
                            } 
                            if (count%3==2){
                            playerdicemove3.diceValue2 = playerdicemove3.diceValue;

                            }
                            


                          count++;
                          System.out.println("count is : " + count);
                            
                            if (count%3==0){
                                if (playerdicemove1.diceValue2 != playerdicemove2.diceValue2 && 
                                    playerdicemove1.diceValue2 != playerdicemove3.diceValue2 && 
                                     

                                    playerdicemove2.diceValue2 != playerdicemove3.diceValue2 ){
                                    
                                    rollButton.setEnabled(false);
                                    startGameButton.setEnabled(true);
                                    arrayListPlayers.add(playerdicemove1);
                                    arrayListPlayers.add(playerdicemove2);
                                    arrayListPlayers.add(playerdicemove3);



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

    }


     public void rollFunction2(){
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

                                if (count % 2 == 0) {
                                    playerdicemove1.diceValue = sum;
                                    playerdicemove1.labelDiceValue.setText(String.valueOf(sum));
                                    System.out.println(playerdicemove1.diceValue);
                                } else if (count % 2 == 1) {
                                    playerdicemove2.diceValue = sum;
                                    playerdicemove2.labelDiceValue.setText(String.valueOf(sum));
                                    System.out.println(playerdicemove2.diceValue);
                                } 



                                // update dice images
                                diceOneImg.setIcon(imageicon.getResizedImage("src\\\\duitria\\\\DiceIcons\\DICE" + diceOne + ".png",200,200));
                                diceTwoImg.setIcon(imageicon.getResizedImage("src\\duitria\\DiceIcons\\DICE" + diceTwo + ".png",200,200));

                               
                            
                                // sleep thread
                                Thread.sleep(60);

                                endTime = System.currentTimeMillis();
                                
                            }
                            System.out.println("this is executed");

                            if (count%2==0){
                            playerdicemove1.diceValue2 = playerdicemove1.diceValue;
                                System.out.println("this is executed 2");
                            }
                            else if (count%2==1){
                            playerdicemove2.diceValue2 = playerdicemove2.diceValue;
                                System.out.println("this is executed 3");
                            }


                          count++;
                          System.out.println("count is : " + count);
                            
                            if (count%2==0){
                                if (playerdicemove1.diceValue2 != playerdicemove2.diceValue2  ){
                                    
                                    rollButton.setEnabled(false);
                                    startGameButton.setEnabled(true);
                                    arrayListPlayers.add(playerdicemove1);
                                    arrayListPlayers.add(playerdicemove2);

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

    }

   

    


}



