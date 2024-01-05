package duitria;
import java.io.*;
import javax.swing.*;
import java.awt.*;
class button {
    button() {
        Frame f = new Frame();
        Button b1 = new Button("OK");
        b1.setBounds(100,50,50,50);
        Button b2 = new Button("Submit");
        b2.setBounds(100, 100, 50, 50);
        Button b3 = new Button("Cancel");
        b3.setBounds(100, 150, 50, 50);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);
        }
}
class Lan {
    Lan() {
        Frame f = new Frame();
        Label l1 = new Label("Select known Languages");
        l1.setBounds(100, 50, 200, 80);
        Checkbox c2 = new Checkbox("Hindi");
        c2.setBounds(100, 150, 50, 50);
        Checkbox c3 = new Checkbox("English");
        c3.setBounds(100, 200, 80, 50);
        Checkbox c4 = new Checkbox("marathi");
        c4.setBounds(100, 250, 80, 50);
        f.add(l1);
        f.add(c2);
        f.add(c3);
        f.add(c4);
        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);
    }
}
class ButtonTest {
    JFrame frame;
    JButton button;
    ButtonTest() {
        frame = new JFrame("Button Test");
        button = new JButton("1 + 1 = ");
        button.addActionListener(null);
        button.setBounds(0, 0, 220, 50);

    }
}
public class testGround {
    public static void main(String[] args) {
        /*
        String gameTitle = "DuitRia";
        JFrame frame = new JFrame(gameTitle); // creating instance of JFrame
        JButton button = new JButton("GFG WebSite Click"); // creating instance of JButton
        button.setBounds(0, 0, 220, 50); // x axis, y axis, width, height
        frame.add(button); // adding button in JFrame
        frame.setSize(400, 300); // 400 width and 500 height
        frame.setLayout(null); // using no layout managers
        frame.setVisible(true); // making the frame visible
        */
        //new button();
        new Lan();
    }
}