package demo;

import java.awt.*;

import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import javax.swing.border.EmptyBorder;

public class SignIn extends JFrame implements ActionListener {
   JLabel sTittle;
   JLabel ti;
   JLabel password;
   JLabel Name;
   JLabel age;
   JLabel Mobile_NO;
   JLabel Email;
   JPanel sPanel;
   JTextField tpassword;
   JTextField tName;
   JTextField tage;
   JTextField tMobile_NO;
   JTextField tEmail;
   JButton Submit1;
   static Statement statement;
   static Connection co;
   static ResultSet resultSet;
   String getPas, getName, getGamil, getPho;
   String getage;
   int primrykey;

   SignIn() {

      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         co = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Student", "vartak");
         System.out.println("connected");
         statement = co.createStatement();
         ResultSet rs = statement.executeQuery("Select count(*)  from student_detail");
         while (rs.next()) {
            primrykey = rs.getInt(1);
            System.out.print(rs);

            primrykey += 1;

         }

         System.out.print(primrykey);

         co.close();

      } catch (Exception eobj) {

      }
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         co = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Student", "vartak");
         System.out.println("connected");

      } catch (Exception eobj) {

      }

      this.setExtendedState(6);
      this.setDefaultCloseOperation(3);
      this.setLayout((LayoutManager) null);
      this.setSize(1900, 1080);
      this.setBackground(Color.DARK_GRAY);
      this.sPanel = new JPanel();
      this.sPanel.setBounds(629, 178, 606, 381);
      this.sPanel.setBackground(new Color(132, 94, 194));
      // BoxLayout sbox = new BoxLayout(this.sPanel, 1);
      // this.sPanel.setBorder(new EmptyBorder(new Insets(10, 100, 300, 100)));
      this.sPanel.setLayout(null);
      ImageIcon sIcone = new ImageIcon(
            "src//main//java//demo//customer portal. simple flat gradient illustration (1).jpg");
      Image image = sIcone.getImage();
      Image newImage = image.getScaledInstance(1540, 900, Image.SCALE_SMOOTH);
      sIcone = new ImageIcon(newImage);
      this.sTittle = new JLabel(sIcone);

      ti = new JLabel("SignIN", JButton.CENTER);
      ti.setBounds(200, 0, 150, 45);
      ti.setBackground(Color.red);
      ti.setForeground(Color.WHITE);

      this.password = new JLabel("password");
      this.password.setBounds(100, 50, 150, 50);
      this.tpassword = new JTextField(1);
      this.tpassword.setBounds(250, 50, 150, 45);
      password.setForeground(Color.WHITE);

      this.Name = new JLabel("Name");
      this.Name.setBounds(100, 100, 150, 50);
      this.tName = new JTextField();
      this.tName.setBounds(250, 100, 150, 45);
      Name.setForeground(Color.WHITE);

      this.age = new JLabel("Age");
      this.age.setBounds(100, 150, 150, 50);
      this.tage = new JTextField(5);
      this.tage.setBounds(250, 150, 150, 45);
      age.setForeground(Color.WHITE);

      this.Mobile_NO = new JLabel("Mobile_No");
      this.Mobile_NO.setBounds(100, 200, 150, 50);
      this.tMobile_NO = new JTextField(10);
      this.tMobile_NO.setBounds(250, 200, 150, 45);
      Mobile_NO.setForeground(Color.WHITE);

      this.Email = new JLabel("Email");
      this.Email.setBounds(100, 250, 150, 50);
      this.tEmail = new JTextField(10);
      this.tEmail.setBounds(250, 250, 150, 45);
      Email.setForeground(Color.WHITE);

      this.Submit1 = new JButton("Create");
      this.Submit1.setBorder(new EmptyBorder(new Insets(10, 50, 10, 50)));
      this.Submit1.setBounds(150, 310, 200, 70);
      Submit1.setBackground(new Color(250, 128, 114));
      Submit1.setForeground(Color.white);

      Font font = new Font("Serif", Font.BOLD, 28);
      this.Submit1.setFont(font);
      this.password.setFont(font);
      this.Name.setFont(font);
      this.age.setFont(font);
      this.Mobile_NO.setFont(font);
      this.Email.setFont(font);
      Font fontti = new Font("Serif", Font.BOLD, 38);
      ti.setFont(fontti);

      this.sTittle.setBounds(0, -10, 1540, 900);
      sPanel.add(ti);
      this.sPanel.add(this.password);
      this.sPanel.add(this.tpassword);
      this.sPanel.add(this.Name);
      this.sPanel.add(this.tName);
      this.sPanel.add(this.age);
      this.sPanel.add(this.tage);
      this.sPanel.add(this.Mobile_NO);
      this.sPanel.add(this.tMobile_NO);
      this.sPanel.add(this.Email);
      this.sPanel.add(this.tEmail);

      this.sPanel.add(this.Submit1);
      this.add(this.sPanel);
      this.add(this.sTittle);
      this.setVisible(true);
      Submit1.addActionListener(this);

   }

   public void actionPerformed(ActionEvent e) {

      /*
       * if (tName.getText().equals("")) {
       * tName.setText("hello");
       * JOptionPane.showMessageDialog(null, "hello");
       * } else {
       * tName.setText("");
       * }
       */
      getPas = tpassword.getText();
      getGamil = tEmail.getText();
      getName = tName.getText();
      getPho = tMobile_NO.getText();
      getage = tage.getText();
      int getage1 = Integer.valueOf(getage);

      try {
         String qur = "insert into student_detail values(?,?,?,?,?,?)";
         PreparedStatement ps = co.prepareStatement(qur);
         ps.setInt(1, primrykey);

         ps.setString(2, getName);
         ps.setInt(3, getage1);
         ps.setString(4, getGamil);
         ps.setString(5, getPas);
         ps.setString(6, getPho);

         // ps.setString(5, getName);

         int count = ps.executeUpdate();
         if (count != 0) {
            JOptionPane.showMessageDialog(null, "sucee");
            System.out.println("sucee");
            tpassword.setText("");
            tEmail.setText("");
            tName.setText("");
            tMobile_NO.setText("");
            tage.setText("");
            setVisible(false);
            new Main_Page();

         } else {
            JOptionPane.showMessageDialog(null, "not sucee");
            System.out.println("sucee");
            tpassword.setText("");
            tEmail.setText("");
            tName.setText("");
            tMobile_NO.setText("");
            tage.setText("");

         }

      } catch (SQLException ex) {

         System.out.println(ex);

      }

   }

}
