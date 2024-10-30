package demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Main_Page extends JFrame implements ActionListener {
    JPanel p1;
    JPanel p2;
    JPanel maiPanel;
    JPanel LoginPanel;
    JPanel SignInPanel;
    JButton Login;
    JButton signIn;
    JButton logiButton;
    JLabel Tittle;
    JLabel Dis;
    JLabel Dis2;
    JLabel Dis3;
    JLabel iconJLabel;
    JLabel User;
    JLabel password;
    JTextField user;
    JTextField paField;
    ImageIcon icon;

    public static final String ACCOUNT_SID = "ACb73415187f8df15d484a486b9a38d449";
    public static final String AUTH_TOKEN = "83c3acf0138991d72929eb72f21b0842";

    public Main_Page() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.setLayout((LayoutManager) null);
        this.maiPanel = new JPanel();
        this.maiPanel.setLayout(new BorderLayout());
        this.p1 = new JPanel();
        this.p1.setLayout((LayoutManager) null);
        this.p1.setBorder(new EmptyBorder(new Insets(10, 30, 100, 30)));
        this.p2 = new JPanel();
        ImageIcon icon = new ImageIcon("src//LoginBack.jpg");
        BoxLayout box = new BoxLayout(this.p2, 1);
        this.p2.setBorder(new EmptyBorder(new Insets(100, 350, 100, 350)));
        this.p2.setLayout(box);
        this.Tittle = new JLabel("E-Authentication System");
        Font font = new Font("Algerian", 20, 58);
        this.Tittle.setFont(font);
        this.Tittle.setForeground(Color.white);
        this.Dis = new JLabel("This paper proposes an authentication system that combines");
        this.Dis2 = new JLabel("One-Time Password (OTP) and Quick Response (QR) code");
        this.Dis3 = new JLabel("technologies to enhance security and user experience");
        Font disfont = new Font("Arial", 20, 28);
        this.Dis.setFont(disfont);
        this.Dis2.setFont(disfont);
        this.Dis3.setFont(disfont);
        this.Login = new JButton("Login");
        Font Loginfont = new Font("Arial", 20, 28);
        this.Login.setBounds(200, 80, 150, 100);
        this.Login.setFont(Loginfont);
        this.signIn = new JButton("SignIn");
        Font SignINfont = new Font("Arial", 20, 28);
        this.signIn.setFont(SignINfont);
        this.signIn.setBounds(400, 80, 150, 100);
        this.iconJLabel = new JLabel(icon);
        this.iconJLabel.setBounds(10, 10, 10, 10);

        this.p2.add(this.Tittle);
        this.p2.add(this.Dis);
        this.p2.add(this.Dis2);
        this.p2.add(this.Dis3);
        this.Login.addActionListener(this);
        this.signIn.addActionListener(this);

        this.p1.add(this.Login);
        this.p1.add(this.signIn);
        this.p2.add(this.p1, "Center");

        this.maiPanel.add(this.p2);
        this.p2.setBackground(new Color(132, 94, 194));
        this.p1.setBackground(new Color(132, 94, 194));
        this.setContentPane(this.maiPanel);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.Login) {
            this.setVisible(false);
            Home home = new Home();

            home.setVisible(true);
        }

        if (e.getSource() == this.signIn) {
            this.setVisible(false);
            SignIn sign = new SignIn();
            sign.setVisible(true);
            System.out.println(this.getWidth() + this.getHeight());
        }

    }

}
