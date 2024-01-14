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
import java.io.File;
import java.awt.event.ActionListener;

public class SaveFileGUI extends JFrame implements ActionListener {

  
    
    Border border = BorderFactory.createLineBorder(Color.BLACK,1);
    JButton buttonSaveFile1 = new JButton();
    JButton buttonSaveFile2 = new JButton();
    JButton buttonSaveFile3 = new JButton();
    JButton buttonSaveFile4 = new JButton();
    
    SaveFile saveFile;
    String saveFile1 = "saveFile1.ser";
    String saveFile2 = "saveFile2.ser";
    String saveFile3 = "saveFile3.ser";
    String saveFile4 = "saveFile4.ser";

    SaveFileGUI (){

    SwingUtilities.invokeLater(() -> {
            
        this.setSize(1280, 720);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(Color.WHITE);
        this.setTitle("DuitRIA");
        this.setResizable(false);
        this.setLayout(null);
        
        JPanel panelImage = new JPanel();
        panelImage.setBackground(Color.BLACK);
        panelImage.setBounds(0, 0, 640, 720);
        JLabel labelIcon = new JLabel();
        labelIcon.setBounds(0, 0, 640, 720);
        labelIcon.setIcon(imageicon.getResizedImage("src\\duitria\\Icons\\logo-color.png", 640, 720));
        panelImage.add(labelIcon);
        this.add(panelImage);
        
        JPanel panelButtons = new JPanel();
        panelButtons.setBackground(new Color(24, 23, 23));
        panelButtons.setBounds(640, 0, 640, 720);
        panelButtons.setBorder(border);
        panelButtons.setLayout(null);
        this.add(panelButtons);
        
        buttonSaveFile1.addActionListener(this);
        buttonSaveFile1.setSize(500, 100);
        buttonSaveFile1.setBounds(70, 110, 500, 80);
        buttonSaveFile1.setText("SAVE FILE 1");
        buttonSaveFile1.setFocusable(false);
        panelButtons.add(buttonSaveFile1);
        
        buttonSaveFile2.addActionListener(this);
        buttonSaveFile2.setSize(500, 100);
        buttonSaveFile2.setBounds(70, 240, 500, 80);
        buttonSaveFile2.setText("SAVE FILE 2");
        buttonSaveFile2.setFocusable(false);
        panelButtons.add(buttonSaveFile2);

        buttonSaveFile3.addActionListener(this);
        buttonSaveFile3.setSize(500, 100);
        buttonSaveFile3.setBounds(70, 370, 500, 80);
        buttonSaveFile3.setText("SAVE FILE 3");
        buttonSaveFile3.setFocusable(false);
        panelButtons.add(buttonSaveFile3);

        buttonSaveFile4.addActionListener(this);
        buttonSaveFile4.setSize(500, 100);
        buttonSaveFile4.setBounds(70, 500, 500, 80);
        buttonSaveFile4.setText("SAVE FILE 4");
        buttonSaveFile4.setFocusable(false);
        panelButtons.add(buttonSaveFile4);

    });
}
    public boolean isFileAvailable(String fileName) {
        File file = new File(fileName);
        return file.exists() && file.isFile();
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==buttonSaveFile1) {
            if (isFileAvailable(saveFile1)) {
                saveFile.loadGame(saveFile1);
                Board board = new Board();
            } else {
                PlayerNumber playerNumber = new PlayerNumber();
            }
        }
        
        if (e.getSource()==buttonSaveFile2) {
            if (isFileAvailable(saveFile2)) {
                saveFile.loadGame(saveFile2);
                Board board = new Board();
            } else {
                PlayerNumber playerNumber = new PlayerNumber();
            }
        }

        if (e.getSource()==buttonSaveFile3) {
            if (isFileAvailable(saveFile3)) {
                saveFile.loadGame(saveFile3);
                Board board = new Board();
            } else {
                PlayerNumber playerNumber = new PlayerNumber();
            }
        }

        if (e.getSource()==buttonSaveFile4) {
            if (isFileAvailable(saveFile4)) {
                saveFile.loadGame(saveFile4);
                Board board = new Board();
            } else {
                PlayerNumber playerNumber = new PlayerNumber();
            }
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

}


 