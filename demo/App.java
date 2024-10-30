package demo;

//import com.twilio.Twilio;

//import com.twilio.rest.api.v2010.account.Message;

import java.lang.String;

///import javax.mail.*;
//import javax.mail.internet.InternetAddress;
////import javax.mail.internet.MimeMessage;
//import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        /*
         *
         */

        // String host = "mail.smtp.host";
        // final String userName = "deepakchauudhary@javatpoint.com";// change
        // accordingly
        // final String password = "kzpdicgjykiwatco";// change accordingly

        // String to = "deepakarunchaudhary@gmail.com";// change accordingly

        /*
         * try {
         * 
         * MimeMessage message = new MimeMessage(session);
         * message.setFrom(new InternetAddress("from@gmail.com"));
         * message.setRecipients(
         * Message.RecipientType.TO,
         * InternetAddress.parse("to_username_a@gmail.com, to_username_b@yahoo.com"));
         * message.setSubject("Testing Gmail TLS");
         * message.setText("Dear Mail Crawler,"
         * + "\n\n Please do not spam my email!");
         * 
         * Transport.send(message);
         * 
         * System.out.println("Done");
         * 
         * } catch (MessagingException e) {
         * e.printStackTrace();
         * }
         */

        new Main_Page();
    }
}
