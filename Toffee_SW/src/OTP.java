import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class OTP {
    private String email;
            public String sendEmail() throws MessagingException {
//                OTP otp = new OTP();
//                otp.setEmail(email);
                String to = email;
                String from = "teamseassignment@gmail.com";
                String host = "smtp.gmail.com";
                String helo = "smtp.gmail.com";
                String username = "teamseassignment@gmail.com";
                String password = "dklxszbmpjvahhip";

                Properties properties = new Properties();
                properties.put("mail.smtp.host", host);
                properties.put("mail.smtp.localhost", helo);
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.port", "587");
                properties.put("mail.smtp.starttls.enable", "true");

                Session session = Session.getInstance(properties,
                        new javax.mail.Authenticator() {
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(username, password);
                            }
                        });

                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(from));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                message.setSubject("Test Email");
                int random = (int) (Math.random() * 999999 + 100000);
                String otp = String.valueOf(random);
                message.setText(otp);

                Transport.send(message);
                System.out.println("Email sent successfully.");
                return otp;
            }

            public void main(String[] args) {
                try {
                    sendEmail();
                } catch (MessagingException mex) {
                    mex.printStackTrace();
                }
            }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

