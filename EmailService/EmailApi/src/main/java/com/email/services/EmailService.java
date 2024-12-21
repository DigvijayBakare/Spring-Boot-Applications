package com.email.services;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailService {
    public boolean sendEmail(String subject, String message, String to) {
        boolean f = false;
        String from = "mnoxyz31@gmail.com";

        // variable for email
        String host = "smtp.gmail.com";

        // get the system properties
        Properties properties = System.getProperties();
        System.out.println("Properties: " + properties);

        // setting import information to the properties

        // host set
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // step 1: to get the session object
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("mnoxyz31@gmail.com", "becm kydp nrwn gozh");
            }
        });
        session.setDebug(true);

        // step 2: compose the message [text, multimedia]
        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            // form email
            mimeMessage.setFrom(from);

            // adding recipient to message
            mimeMessage.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(to)));

            // adding subject to the message
            mimeMessage.setSubject(subject);

            // adding text to the message
            mimeMessage.setText(message);

            // send

            // step 3: send the message using transport class
            Transport.send(mimeMessage);
            System.out.println("Sent successfully.....");
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}
