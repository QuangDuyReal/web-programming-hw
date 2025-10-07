package murach.util;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class MailUtilGmail {

    public static void sendMail(String to, String from,
                                String subject, String body, boolean bodyIsHTML)
            throws MessagingException {

        // 1 - Lấy một Mail Session (đã bao gồm xác thực)
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host", "smtp.gmail.com");
        props.put("mail.smtps.port", 465);
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtps.quitwait", "false");

        // --- PHẦN QUAN TRỌNG NHẤT ---
        // Điền thông tin của bạn vào đây
        final String USERNAME = "fansjaki@gmail.com";
        final String PASSWORD = "lesb vlhl pmsr igtp";

        // Phương thức xác thực hiện đại, thay cho transport.connect()
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        // Bật debug để xem log chi tiết trong console của Tomcat
        session.setDebug(true);

        // 2 - Tạo một Message
        Message message = new MimeMessage(session);
        message.setSubject(subject);
        if (bodyIsHTML) {
            message.setContent(body, "text/html");
        } else {
            message.setText(body);
        }

        // 3 - Đặt địa chỉ
        Address fromAddress = new InternetAddress(from);
        Address toAddress = new InternetAddress(to);
        message.setFrom(fromAddress);
        message.setRecipient(Message.RecipientType.TO, toAddress);

        // 4 - Gửi Message
        // Phương thức này sẽ tự động kết nối, gửi và đóng kết nối.
        Transport.send(message);
    }
}