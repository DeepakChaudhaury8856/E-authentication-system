package demo;

import javax.swing.*;
import java.awt.*;

public class loginHome extends JFrame {
    JLabel welcome;

    loginHome(String name) {

        setSize(400, 400);
        setLayout(new BorderLayout(1, 2));
        welcome = new JLabel(name);
        Font f = new Font("Arail", 100, 30);
        welcome.setFont(f);
        // welcome.setBounds(10, 10, 300, 200);
        add(welcome, BorderLayout.NORTH);
        setVisible(true);

    }

    public static void main(String[] args) {
        new loginHome();
    }

}
