package duitria;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;


public class PlayerSelectIcon extends JFrame {


    Border border = BorderFactory.createLineBorder(Color.BLACK,1);

    PlayerSelectIcon (){

    SwingUtilities.invokeLater(() -> {
        
     this.setSize(1280, 720);
     this.setVisible(true);
     this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     this.getContentPane().setBackground(Color.BLACK);
     this.setTitle("DuitRIA");
     this.setResizable(false);
     this.setLayout(null);

     
     JPanel panelBackground =  new JPanel();
     panelBackground.setBackground(Color.BLACK);
     panelBackground.setBounds(0, 0, 1280, 720);
     panelBackground.setLayout(null);
     this.add(panelBackground);

     
     playerIcons playerIcon1 = new playerIcons(40, 110,panelBackground,"src\\duitria\\Tokens\\kisspng-scottish-terrier-hasbro-monopoly-token-madness-gam-5aeec53ce326f6.3711203115255975009304.png");
     playerIcons playerIcon2 = new playerIcons(347, 110,panelBackground,"src\\duitria\\Tokens\\kisspng-hasbro-monopoly-brik-game-car-monopoly-5b210efdcddc05.4082535715288931818432.png");
     playerIcons playerIcon3 = new playerIcons(654, 110,panelBackground,"src\\duitria\\Tokens\\pngfind.com-monopoly-png-2578492.png");
     playerIcons playerIcon4 = new playerIcons(960, 110,panelBackground,"src\\duitria\\Tokens\\pngfind.com-top-hat-png-565056.png");

    PlayerName player1 = new PlayerName(playerIcon1);
    PlayerName player2 = new PlayerName(playerIcon2);
    PlayerName player3 = new PlayerName(playerIcon3);
    PlayerName player4 = new PlayerName(playerIcon4);

     

      
     
});
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



class playerIcons extends JPanel{

    playerIcons(int x, int y, JPanel panelBackground, String path){
        this.setBackground(new Color(217,217,217));
        this.setBounds(x, y, 266, 500);
        this.setLayout(null);
        panelBackground.add(this);
        this.setBorder(border);

        JLabel labelToken = new JLabel();
        JPanel panelImage = new JPanel();
        panelImage.setBackground(new Color(143,143,143));
        panelImage.setBounds(6, 7, 253, 433);
        labelToken.setIcon(imageicon.getResizedImage(path, 253, 253));
        labelToken.setBounds(0, (panelImage.getHeight()/2)-117, 235, 253);
        panelImage.setLayout(null);
        panelImage.add(labelToken);
        this.add(panelImage);
        panelImage.setBorder(border);


    }
}

class PlayerName extends JPanel{

    PlayerName(playerIcons playericon){
     this.setBounds(6, 447, 253, 48);
     this.setBorder(border);
     playericon.add(this);

    }
}


}