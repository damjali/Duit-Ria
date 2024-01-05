package duitria;

import javax.swing.*;
import javax.swing.border.Border;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;




public class diceRoll extends JFrame {


    String player1, player2, player3, player4;
    Border border = BorderFactory.createLineBorder(Color.BLACK,1);

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
        System.out.println(this.player1);

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

        //3. Roll Button
        Random rand = new Random();
        JButton rollButton = new JButton("Roll!");
        rollButton.setBounds(250, 550, 200, 50);
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

                                // update dice images
                                diceOneImg.setIcon(imageicon.getResizedImage("src\\\\duitria\\\\DiceIcons\\DICE" + diceOne + ".png",200,200));
                                diceTwoImg.setIcon(imageicon.getResizedImage("src\\duitria\\DiceIcons\\DICE" + diceTwo + ".png",200,200));

                               

                                // sleep thread
                                Thread.sleep(60);

                                endTime = System.currentTimeMillis();

                            }

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

        this.getContentPane().add(jPanel);

    }





class playerDiceMove extends JPanel{

    JPanel panelPlayerName = new JPanel();
    JPanel panelDiceValue = new JPanel();
    JLabel playerLabelName = new JLabel();
    JLabel labelDiceValue = new JLabel();

    playerDiceMove(int x, JFrame frame, String playerName){
        this.setBounds(x, 300, 135, 200);
        this.setBackground(new Color(143,143,143));
        this.setBorder(border);
        this.setLayout(null);
  

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
        labelDiceValue.setText("5");
        labelDiceValue.setFont(new Font("Arial", Font.BOLD, 120));
        panelDiceValue.add(labelDiceValue);
        
        



        this.add(panelDiceValue);
        this.add(panelPlayerName);
        frame.add(this);

    }
}
class ImgService {
   

    public static void updateImage(JLabel imageContainer, String filePath){
        BufferedImage image;
        try{
            InputStream inputStream = ImgService.class.getResourceAsStream(filePath);
            image = ImageIO.read(inputStream);
            imageContainer.setIcon(new ImageIcon(image));
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
    }

}


