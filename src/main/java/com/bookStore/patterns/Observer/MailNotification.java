package com.bookStore.patterns.Observer;

import io.github.cdimascio.dotenv.Dotenv;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class MailNotification {
    static Dotenv dotenv = Dotenv.load();
    final String fromEmail = dotenv.get("MAILUSER"); // replace with your email
    final String password = dotenv.get("MAILPASSWORD"); // replace with your email password
    Session session;


    public MailNotification() {
        // Set the properties for the JavaMail session
        Properties props = new Properties();
        props.put("mail.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        // Create a Session object with the properties and an Authenticator to provide credentials
        session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });
    }

    public void sendMessage(Session session, String toEmail, String subject, String text) {
        try {
            // Create a MimeMessage object
            Message message = new MimeMessage(session);

            // Set the sender's and recipient's email addresses
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));

            // Set the subject and text of the email
            message.setSubject(subject);
            message.setText(text);

            // Send the email
            Transport.send(message);

            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Error sending email: " + e.getMessage());
        }
    }
}
