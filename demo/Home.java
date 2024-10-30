package demo;
//complited 

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class Home extends JFrame implements ActionListener {
    JLabel sTittle;
    JLabel ti;
    String charset = "UTF-8";

    JLabel User, password, errorme, User1, password1, errorme1;
    JPanel LoginPanel, VerifyOtp;
    JTextField user, paField, user1, paField1;

    JButton logiButton, verifButton, backButton;
    ImageIcon BackImage;

    static Statement statement;
    static Connection co;
    static ResultSet resultSet;
    String notp, userName, m, str, qrdata, phone1, otpc, otp1, path;
    OTP otp;

    Home() {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            co = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Student", "vartak");
            System.out.println("connected");
            statement = co.createStatement();

        } catch (Exception eobj) {

        }

        this.setExtendedState(6);
        this.setDefaultCloseOperation(3);
        this.setLayout((LayoutManager) null);
        this.setBounds(0, 0, 1200, 860);
        setBackground(Color.DARK_GRAY);
        // background Image
        ImageIcon sIcone = new ImageIcon(
                "src//main//java//demo//Login_Page_background.jpg");
        Image image = sIcone.getImage();
        Image newImage = image.getScaledInstance(1538, 830, Image.SCALE_SMOOTH);
        sIcone = new ImageIcon(newImage);
        this.ti = new JLabel(sIcone);
        ti.setBounds(0, 0, 1538, 830);

        this.sTittle = new JLabel("E-Authentication System");
        Font font = new Font("Serif", 20, 48);
        this.sTittle.setFont(font);
        this.sTittle.setForeground(Color.white);
        sTittle.setBounds(100, 0, 663, 100);

        this.LoginPanel = new JPanel();
        this.LoginPanel.setLayout(null);
        LoginPanel.setBackground(new Color(0, 0, 0, 60));
        LoginPanel.setBounds(530, 150, 662, 500);

        this.User = new JLabel("User");
        User.setForeground(Color.white);
        this.password = new JLabel("Password");
        password.setForeground(Color.white);
        this.user = new JTextField(40);
        this.paField = new JTextField(40);
        logiButton = new JButton("Login");
        logiButton.setBackground(Color.white);
        backButton = new JButton("back");
        backButton.setBackground(Color.white);

        this.User.setBounds(200, 100, 150, 30);
        this.user.setBounds(310, 100, 150, 50);

        this.password.setBounds(200, 160, 150, 30);
        this.paField.setBounds(310, 160, 150, 50);

        this.logiButton.setBounds(250, 290, 140, 50);
        this.backButton.setBounds(395, 290, 140, 50);
        Font fontl = new Font("Arial", 100, 25);
        errorme = new JLabel();
        errorme.setFont(fontl);
        errorme.setForeground(Color.red);
        errorme.setBounds(250, 340, 150, 50);

        this.User.setFont(fontl);
        this.password.setFont(fontl);
        this.user.setFont(fontl);
        this.paField.setFont(fontl);
        LoginPanel.add(sTittle);
        LoginPanel.add(this.User);
        this.LoginPanel.add(this.user);
        this.LoginPanel.add(this.password);
        this.LoginPanel.add(this.paField);
        this.LoginPanel.add(this.logiButton);
        this.LoginPanel.add(this.backButton);
        LoginPanel.add(errorme);

        VerifyOtp = new JPanel();
        this.VerifyOtp.setLayout(null);
        VerifyOtp.setBackground(new Color(0, 0, 0, 60));
        VerifyOtp.setBounds(530, 150, 662, 500);

        this.User1 = new JLabel("OTP");
        User1.setForeground(Color.white);
        this.password1 = new JLabel("URL");
        password1.setForeground(Color.white);
        this.user1 = new JTextField(40);
        this.paField1 = new JTextField(40);
        verifButton = new JButton("verif");
        verifButton.setBackground(Color.white);

        this.User1.setBounds(200, 100, 150, 30);
        this.user1.setBounds(310, 100, 150, 50);

        this.password1.setBounds(200, 160, 150, 30);
        this.paField1.setBounds(310, 160, 150, 50);

        this.verifButton.setBounds(250, 290, 140, 50);
        Font fontl1 = new Font("Arial", 100, 25);
        errorme1 = new JLabel();
        errorme1.setFont(fontl1);
        errorme1.setForeground(Color.red);
        errorme1.setBounds(250, 340, 150, 50);

        this.User1.setFont(fontl1);
        this.password1.setFont(fontl1);
        this.user1.setFont(fontl1);
        this.paField1.setFont(fontl1);
        VerifyOtp.add(sTittle);

        VerifyOtp.add(this.User1);
        this.VerifyOtp.add(this.user1);
        this.VerifyOtp.add(this.password1);
        this.VerifyOtp.add(this.paField1);
        this.VerifyOtp.add(this.verifButton);
        VerifyOtp.add(errorme);

        add(this.LoginPanel);
        add(VerifyOtp);
        VerifyOtp.setVisible(false);

        logiButton.addActionListener(this);
        verifButton.addActionListener(this);
        backButton.addActionListener(this);
        add(ti);
        setVisible(true);
        // otpgenrated
        Random r = new Random();
        int otp = (r.nextInt(999999)) + 100000;
        otp1 = String.valueOf(otp);
        // System.out.println(otp1);

    }

    String Gotp() {

        // System.out.println(otp1);
        return otp1;
    }

    // qr code generated
    public static void generateQRcode(String data, String path, String charset, int h, int w)
            throws WriterException, IOException {
        Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
        hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

        BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes(charset), charset),
                BarcodeFormat.QR_CODE, w, h);
        MatrixToImageWriter.writeToFile(matrix, path.substring(path.lastIndexOf('.') + 1), new File(path));

    }

    public static String readQRcode(String path)
            throws FileNotFoundException, IOException, NotFoundException {

        Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        BinaryBitmap binaryBitmap = new BinaryBitmap(
                new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(new FileInputStream(path)))));
        Result rslt = new MultiFormatReader().decode(binaryBitmap);
        return rslt.getText();

        // return rslt.getText();
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == logiButton) {
            String gmail = user.getText();
            String password = paField.getText();
            try {

                String sqlQur = "select * from student_detail where Email='" + gmail + "'and  Password='" + password
                        + "'";
                ResultSet rs = statement.executeQuery(sqlQur);
                if (rs.next()) {
                    LoginPanel.setVisible(false);
                    VerifyOtp.setVisible(true);
                    userName = rs.getString(2);

                    m = rs.getString(4);
                    phone1 = "+91" + rs.getString(6);
                    // System.out.print(phone1);

                    str = rs.getString(2) + otp1;

                    path = "Quote.png";

                    String charset = "UTF-8";
                    generateQRcode(str, path, charset, 200, 200);// increase or decrease height and width accodingly
                    System.out.println("QR Code created successfully.");

                    OTP obj = new OTP();

                    obj.Otp(phone1, otp1);
                    System.out.print(otp1);

                    String path1 = path;
                    Emailsend ob = new Emailsend();
                    ob.Send1(m, path1);

                } else {
                    if (!gmail.equals(null) || !password.equals(null)) {
                        JOptionPane.showMessageDialog(this, "User or password not null");
                        user.setText("");
                        paField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(this, "User or password not match");
                        user.setText("");
                        paField.setText("");
                    }
                    user.setText("");
                    paField.setText("");

                }

            } catch (

            Exception e1) {

                System.out.println(e1);
            }
            Emailsend eobj = new Emailsend();
            eobj.Send1(m, path);

        }
        if (e.getSource() == verifButton) {
            String cotp = user1.getText();
            String qrdata1 = paField1.getText();

            try {
                qrdata = readQRcode(qrdata1);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (NotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            System.out.println(qrdata);

            if (cotp.equals(otp1) && str.equals(qrdata)) {
                JOptionPane.showMessageDialog(this, "LOGIN");
                setVisible(false);

                loginHome obj = new loginHome(userName);
                obj.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "otp is not  match");
                user1.setText("");
                paField1.setText("");

            }

        }
        if (e.getSource() == backButton) {

            setVisible(false);
            new Main_Page();

        }

    }

}
