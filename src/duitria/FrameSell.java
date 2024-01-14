package duitria;
import java.awt.Color;
import javax.swing.*;

import duitria.Board.MiniTile;
import duitria.Board.MiniSpecialTile;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.*;
import java.awt.Font;

class FrameSellHouse extends JFrame {

    JButton buttonSell = new JButton(); // Fixed the typo in the variable name
    JTextArea textAreaHouseNumber;
    JTextArea textAreaLandNumber;
    int landNumber, houseNumber, totalHouseCount;
    boolean playerDebt, creatorDebt;

    FrameSellHouse(List<MiniTile> propertySelector, Player player, boolean playerDebt, boolean creatorDebt) {
        landNumber = 0;
        houseNumber = 0;
        totalHouseCount = 0;
        this.playerDebt = playerDebt;
        this.creatorDebt = creatorDebt;

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
        labelLandNumber.setForeground(Color.YELLOW); // Set text color to white
        panelFrame.add(labelLandNumber);

        JLabel labelHouseNumber = new JLabel();
        labelHouseNumber.setText("House Number : ");
        labelHouseNumber.setFont((new Font("Arial", Font.BOLD, 16)));
        labelHouseNumber.setBounds(465, 375, 200, 200);
        labelHouseNumber.setForeground(Color.YELLOW); // Set text color to white
        panelFrame.add(labelHouseNumber);

        JLabel labelMoneyIcon = new JLabel();
        labelMoneyIcon.setIcon(imageicon.getResizedImage("src\\duitria\\Banners\\925065.png", 50, 50));
        labelMoneyIcon.setBounds(50, 675, 50, 50);
        panelFrame.add(labelMoneyIcon);

        String playerCurrentMoney = String.format("RM%,d", player.money);
        JTextArea textAreaPlayerCurrentMoney = new JTextArea();
        textAreaPlayerCurrentMoney.setBounds(100, 680, 400, 400);
        textAreaPlayerCurrentMoney.setRows(10);
        textAreaPlayerCurrentMoney.setColumns(30);
        textAreaPlayerCurrentMoney.setBackground(Color.BLACK);
        textAreaPlayerCurrentMoney.setForeground(Color.YELLOW); // Set text color to white
        // textAreaPlayerCurrentMoney.setText(propertyList); player current money update here
        textAreaPlayerCurrentMoney.setText(playerCurrentMoney);
        textAreaPlayerCurrentMoney.setFont((new Font("Arial", Font.BOLD, 20)));
        textAreaPlayerCurrentMoney.setEditable(false);
        textAreaPlayerCurrentMoney.setMargin(new Insets(10, 10, 0, 0));
        panelFrame.add(textAreaPlayerCurrentMoney);

        int count = 0;
        String houseList = "";
        for (MiniTile propertyTile : propertySelector) {
            count++;
            totalHouseCount += propertyTile.numOfHouse;
            houseList += count + ". " + propertyTile.name + ": " + propertyTile.numOfHouse + " house(s)\n";
        }
        JTextArea textAreaPropertyList = new JTextArea();
        textAreaPropertyList.setBounds(50, 250, 400, 400);
        textAreaPropertyList.setRows(10);
        textAreaPropertyList.setColumns(30);
        textAreaPropertyList.setBackground(Color.darkGray);
        textAreaPropertyList.setForeground(Color.WHITE); // Set text color to white
        textAreaPropertyList.setText(houseList);
        textAreaPropertyList.setFont((new Font("Arial", Font.BOLD, 20)));
        textAreaPropertyList.setEditable(false);
        textAreaPropertyList.setMargin(new Insets(10, 10, 0, 0));
        panelFrame.add(textAreaPropertyList);

        textAreaLandNumber = new JTextArea();
        textAreaLandNumber.setBounds(610, 350, 150, 50);
        textAreaLandNumber.setRows(10);
        textAreaLandNumber.setColumns(10);
        textAreaLandNumber.setBackground(Color.WHITE);
        textAreaLandNumber.setForeground(Color.BLACK); // Set text color to white
        textAreaLandNumber.setFont((new Font("Arial", Font.BOLD, 30)));
        textAreaLandNumber.setMargin(new Insets(10, 5, 0, 0));
        panelFrame.add(textAreaLandNumber);

        textAreaHouseNumber = new JTextArea();
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

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == buttonSell){
            landNumber = Integer.parseInt(textAreaLandNumber.getText());
            houseNumber = Integer.parseInt(textAreaHouseNumber.getText());

        }
    }
}

class FrameSellLand extends JFrame {
    
    JButton buttonSell = new JButton(); // Fixed the typo in the variable name
    JTextArea textAreaLandNumber;
    int landNumber, totalLandCount;
    boolean playerDebt, creatorDebt;

    FrameSellLand(List<MiniTile> propertySelector, List<MiniSpecialTile> specialTileSelector, Player player, boolean playerDebt, boolean creatorDebt) {
        landNumber = 0;
        totalLandCount = 0;
        this.playerDebt = playerDebt;
        this.creatorDebt = creatorDebt;

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
        labelLandNumber.setForeground(Color.YELLOW); // Set text color to white
        panelFrame.add(labelLandNumber);

        JLabel labelHouseNumber = new JLabel();
        labelHouseNumber.setText("House Number : ");
        labelHouseNumber.setFont((new Font("Arial", Font.BOLD, 16)));
        labelHouseNumber.setBounds(465, 375, 200, 200);
        labelHouseNumber.setForeground(Color.YELLOW); // Set text color to white
        panelFrame.add(labelHouseNumber);

        JLabel labelMoneyIcon = new JLabel();
        labelMoneyIcon.setIcon(imageicon.getResizedImage("src\\duitria\\Banners\\925065.png", 50, 50));
        labelMoneyIcon.setBounds(50, 675, 50, 50);
        panelFrame.add(labelMoneyIcon);

        String playerCurrentMoney = String.format("RM%,d", player.money);
        JTextArea textAreaPlayerCurrentMoney = new JTextArea();
        textAreaPlayerCurrentMoney.setBounds(100, 680, 400, 400);
        textAreaPlayerCurrentMoney.setRows(10);
        textAreaPlayerCurrentMoney.setColumns(30);
        textAreaPlayerCurrentMoney.setBackground(Color.BLACK);
        textAreaPlayerCurrentMoney.setForeground(Color.YELLOW); // Set text color to white
        // textAreaPlayerCurrentMoney.setText(propertyList); player current money update here
        textAreaPlayerCurrentMoney.setText(playerCurrentMoney);
        textAreaPlayerCurrentMoney.setFont((new Font("Arial", Font.BOLD, 20)));
        textAreaPlayerCurrentMoney.setEditable(false);
        textAreaPlayerCurrentMoney.setMargin(new Insets(10, 10, 0, 0));
        panelFrame.add(textAreaPlayerCurrentMoney);

        int count = 0;
        String landList = "";
        for (MiniTile propertyTile : propertySelector) {
            count++;
            totalLandCount++;
            landList += count + ". " + propertyTile.name + "\n";
        }
        JTextArea textAreaPropertyList = new JTextArea();
        textAreaPropertyList.setBounds(50, 250, 400, 400);
        textAreaPropertyList.setRows(10);
        textAreaPropertyList.setColumns(30);
        textAreaPropertyList.setBackground(Color.darkGray);
        textAreaPropertyList.setForeground(Color.WHITE); // Set text color to white
        textAreaPropertyList.setText(landList);
        textAreaPropertyList.setFont((new Font("Arial", Font.BOLD, 20)));
        textAreaPropertyList.setEditable(false);
        textAreaPropertyList.setMargin(new Insets(10, 10, 0, 0));
        panelFrame.add(textAreaPropertyList);

        textAreaLandNumber = new JTextArea();
        textAreaLandNumber.setBounds(610, 350, 150, 50);
        textAreaLandNumber.setRows(10);
        textAreaLandNumber.setColumns(10);
        textAreaLandNumber.setBackground(Color.WHITE);
        textAreaLandNumber.setForeground(Color.BLACK); // Set text color to white
        textAreaLandNumber.setFont((new Font("Arial", Font.BOLD, 30)));
        textAreaLandNumber.setMargin(new Insets(10, 5, 0, 0));
        panelFrame.add(textAreaLandNumber);

        buttonSell.setBounds(560, 560, 100, 50);
        buttonSell.setSize(100, 50);
        buttonSell.setEnabled(true);
        buttonSell.setVisible(true);
        buttonSell.setText("SELL");
        buttonSell.setFont((new Font("Arial", Font.BOLD, 20)));
        panelFrame.add(buttonSell);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == buttonSell){
            landNumber = Integer.parseInt(textAreaLandNumber.getText());

        }
    }
}