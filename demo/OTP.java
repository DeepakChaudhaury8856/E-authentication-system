package demo;

import com.twilio.Twilio;
//import com.twilio.Twilio;

import com.twilio.rest.api.v2010.account.Message;

public class OTP {
    String fotp, otp1;

    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("AUTH_TOKEN");

    public void Otp(String phone1, String otp) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        fotp = "you Otp is " + otp;
        System.out.println(fotp + "\n" + phone1);

        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(phone1),
                new com.twilio.type.PhoneNumber("+12513063447"),
                fotp)
                .create();

        System.out.println(message.getSid());

    }

}
