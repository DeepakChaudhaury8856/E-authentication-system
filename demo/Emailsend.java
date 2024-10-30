package demo;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.util.Properties;

//import io.jsonwebtoken.io.IOException;

public class Emailsend {

    public void Send1(String em, String path) {

        final String username = "deepakchauudhary@gmail.com";
        final String password = "kzpdicgjykiwatco";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(prop,
                new jakarta.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try

        {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(em));
            message.setSubject("Testing Gmail SSL");

            // message
            MimeBodyPart p1 = new MimeBodyPart();
            p1.setText("Your qr code is ⬇");
            // MimeBodyPart p2 = new MimeBodyPart();
            // p2.attachFile("src\\main\\java\\demo\\Ai.jpg");
            MimeBodyPart p3 = new MimeBodyPart();
            p3.attachFile(path);
            MimeMultipart mul = new MimeMultipart();
            mul.addBodyPart(p1);
            // mul.addBodyPart(p2);
            mul.addBodyPart(p3);
            message.setContent(mul);
            Transport.send(message);
            // Boolean flag = true;

            System.out.println("Done");

        } catch (MessagingException | java.io.IOException e) {
            e.printStackTrace();
        }

    }

}
