package send.mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail
{
    public static void main(String [] args){
        String host = "smtp.gmail.com";
        int port = 587;
        final String username = "xxxxxxxxxxx";  //登入帳號
        final String password = "xxxxxxxxxxx";//登入密碼

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", port);
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("xxxxxxxx")); //寄件人
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("xxxxxxxxx")); //收件人
            message.setSubject("測試寄信."); //主旨
            message.setText("Dear Levin, \n\n 測試 測試 測試 測試 測試 測試 email !"); //內容

            Transport transport = session.getTransport("smtp");
            transport.connect(host, port, username, password);

            Transport.send(message);

            System.out.println("寄送email結束.");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
