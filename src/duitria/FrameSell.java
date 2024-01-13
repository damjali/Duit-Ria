package duitria;
import java.awt.Color;
import javax.swing.*;
import java.awt.Insets;

import java.awt.Font;

public class FrameSell extends JFrame{

    JButton buttonSell = new JButton(); // Fixed the typo in the variable name
    public static void main(String[] args) {
        System.setProperty("sun.java2d.uiScale", "1.0");
        FrameSell framesell = new FrameSell("Petaling Jaya - 4 Houses");
    }

    FrameSell(String propertyList){
        this.setSize(800, 800);
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.setResizable(false);
        this.setUndecorated(false);

        JPanel panelFrame = new JPanel();
        panelFrame.setBackground(Color.black);
        panelFrame.setBounds(0, 0, 800, 800);
        panelFrame.setLayout(null);
        this.add(panelFrame);

        JLabel labelBanner = new JLabel();
        labelBanner.setIcon(imageicon.getResizedImage("src\\duitria\\Banners\\huge.png", 700, 200));
        labelBanner.setBounds(50, 10, 700, 200);
        panelFrame.add(labelBanner);

        JLabel labelLandNumber = new JLabel();
        labelLandNumber.setText("Land Number : ");
        labelLandNumber.setFont((new Font("Arial", Font.BOLD, 16)));
        labelLandNumber.setBounds(465, 275, 200, 200);
        labelLandNumber.setForeground(Color.WHITE); // Set text color to white
        panelFrame.add(labelLandNumber);

        JLabel labelHouseNumber = new JLabel();
        labelHouseNumber.setText("House Number : ");
        labelHouseNumber.setFont((new Font("Arial", Font.BOLD, 16)));
        labelHouseNumber.setBounds(465, 375, 200, 200);
        labelHouseNumber.setForeground(Color.WHITE); // Set text color to white
        panelFrame.add(labelHouseNumber);


        JTextArea textAreaPropertyList = new JTextArea();
        textAreaPropertyList.setBounds(50, 250, 400, 400);
        textAreaPropertyList.setRows(10);
        textAreaPropertyList.setColumns(30);
        textAreaPropertyList.setBackground(Color.darkGray);
        textAreaPropertyList.setForeground(Color.WHITE); // Set text color to white
        textAreaPropertyList.setText(propertyList);
        textAreaPropertyList.setFont((new Font("Arial", Font.BOLD, 20)));
        textAreaPropertyList.setEditable(false);
        textAreaPropertyList.setMargin(new Insets(10, 10, 0, 0));
        panelFrame.add(textAreaPropertyList);

        JTextArea textAreaLandNumber = new JTextArea();
        textAreaLandNumber.setBounds(610, 350, 150, 50);
        textAreaLandNumber.setRows(10);
        textAreaLandNumber.setColumns(10);
        textAreaLandNumber.setBackground(Color.WHITE);
        textAreaLandNumber.setForeground(Color.BLACK); // Set text color to white
        textAreaLandNumber.setFont((new Font("Arial", Font.BOLD, 30)));
        textAreaLandNumber.setMargin(new Insets(10, 5, 0, 0));
        panelFrame.add(textAreaLandNumber);

        JTextArea textAreaHouseNumber = new JTextArea();
        textAreaHouseNumber.setBounds(610, 450, 150, 50);
        textAreaHouseNumber.setRows(10);
        textAreaHouseNumber.setColumns(10);
        textAreaHouseNumber.setBackground(Color.WHITE);
        textAreaHouseNumber.setForeground(Color.BLACK); // Set text color to white
        textAreaHouseNumber.setFont((new Font("Arial", Font.BOLD, 30)));
        textAreaHouseNumber.setMargin(new Insets(10, 5, 0, 0));
        panelFrame.add(textAreaHouseNumber);

        buttonSell.setBounds(560, 560, 100, 50);
        buttonSell.setSize(100, 50);
        buttonSell.setEnabled(true);
        buttonSell.setVisible(true);
        buttonSell.setText("SELL");
        buttonSell.setFont((new Font("Arial", Font.BOLD, 20)));
        panelFrame.add(buttonSell);

        this.setVisible(true);
    }
}
