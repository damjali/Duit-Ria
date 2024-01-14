package duitria;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

class PlayerWinner {
    
    List<Player> players;
    
    PlayerWinner(List<Player> players) {
        this.players = players;
    }
    
    public static void main(String[] args) {
        Player player = new Player("aniq");
        SwingUtilities.invokeLater(() -> {
        System.setProperty("sun.java2d.uiScale", "1.0");
        
        JFrame frame = new JFrame();
        frame.setVisible(true); 
        frame.setSize(1920,1080); 
        frame.setTitle("Winner of the game"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color (0, 0, 128));
        frame.setLayout(null);
               
        ImageIcon gold = new ImageIcon("src\\duitria\\Icons\\GOLD.png");
        ImageIcon silver = new ImageIcon("src\\duitria\\Icons\\SILVER.png");
        ImageIcon bronze = new ImageIcon("src\\duitria\\Icons\\BRONZE.png");
        
        ImageIcon winnerToken = imageicon.getResizedImage("src\\SMALL TOKENS\\SMALL POKEBALL NORMAL.png", 330, 330);
        ImageIcon secondToken = imageicon.getResizedImage("src\\SMALL TOKENS\\SMALL MARIO NORMAL.png", 330, 330);
        ImageIcon thirdToken = imageicon.getResizedImage("src\\SMALL TOKENS\\SMALL LUFFY NORMAL.png", 330, 330);

        JLabel one = new JLabel();
        one.setIcon(gold);
        one.setBounds(797,380,330,700);
        one.setVisible(true);
        frame.add(one);
        JLabel oneToken = new JLabel();
        oneToken.setIcon(winnerToken);
        oneToken.setBounds(797,40,330,330);
        oneToken.setVisible(true);
        frame.add(oneToken);
        
        JLabel two = new JLabel();
        two.setIcon(silver);
        two.setBounds(1135,500,330,580);
        two.setVisible(true);
        frame.add(two);
        JLabel twoToken = new JLabel();
        twoToken.setIcon(secondToken);
        twoToken.setBounds(1135,140,330,330);
        twoToken.setVisible(true);
        frame.add(twoToken);
        
        JLabel three = new JLabel();
        three.setIcon(bronze);
        three.setBounds(460,600,330,480);
        three.setVisible(true);
        frame.add(three);
        JLabel threeToken = new JLabel();
        threeToken.setIcon(thirdToken);
        threeToken.setBounds(460,240,330,330);
        threeToken.setVisible(true);
        frame.add(threeToken);
            
        
        
        JLabel winner = new JLabel();
        winner.setText(player.name);
        winner.setHorizontalTextPosition(JLabel.CENTER);
        winner.setVerticalTextPosition(JLabel.CENTER);
        winner.setHorizontalAlignment(JLabel.CENTER);
        winner.setVerticalAlignment(JLabel.CENTER);
        winner.setForeground(Color.BLACK);
        winner.setFont(new Font("Inter", Font.BOLD, 30));
        JPanel textBoxWinner = new JPanel();
        textBoxWinner.setSize(250,50);
        textBoxWinner.setBounds(40,20,250,50);
        textBoxWinner.setBackground(Color.WHITE);
        textBoxWinner.add(winner);
        one.add(textBoxWinner);
        
        JLabel second = new JLabel();
        second.setText(player.name);
        second.setHorizontalTextPosition(JLabel.CENTER);
        second.setVerticalTextPosition(JLabel.CENTER);
        second.setHorizontalAlignment(JLabel.CENTER);
        second.setVerticalAlignment(JLabel.CENTER);
        second.setForeground(Color.BLACK);
        second.setFont(new Font("Inter", Font.BOLD, 30));
        JPanel textBoxSecond = new JPanel();
        textBoxSecond.setSize(250,50);
        textBoxSecond.setBounds(40,20,250,50);
        textBoxSecond.setBackground(Color.WHITE);
        textBoxSecond.add(second);
        two.add(textBoxSecond);
        
        JLabel third = new JLabel();
        third.setText(player.name);
        third.setHorizontalTextPosition(JLabel.CENTER);
        third.setVerticalTextPosition(JLabel.CENTER);
        third.setHorizontalAlignment(JLabel.CENTER);
        third.setVerticalAlignment(JLabel.CENTER);
        third.setForeground(Color.BLACK);
        third.setFont(new Font("Inter", Font.BOLD, 30));
        JPanel textBoxThird = new JPanel();
        textBoxThird.setSize(250,50);
        textBoxThird.setBounds(40,20,250,50);
        textBoxThird.setBackground(Color.WHITE);
        textBoxThird.add(third);
        three.add(textBoxThird);

        });
    }
}

class imageicon{

    public static ImageIcon getResizedImage(String path, int width, int height){
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(path)
                                .getImage()
                                .getScaledInstance(
                                    width, 
                                    height, 
                                    Image.SCALE_SMOOTH));
    
    return imageIcon;
    }
    
}
