package miniproject;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class m_MailSender {

    public static void sendMail(String to, String name, String text) throws Exception {

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.mail.nate.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "smtp.mail.nate.com");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("younhb33@nate.com", "13572468yo!"); // ← 내 계정
            }
        });

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("younhb33@nate.com", "이클릭상담팀", "utf-8")); // 보내는 사람 정보
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to)); // 받는 사람
        msg.setSubject("[이클릭] 상담신청 확인 메일"); // 제목
        msg.setContent(name + "님의 상담 내용입니다.<br><br>" + text.replace("\n", "<br>"), "text/html;charset=utf-8");

        Transport.send(msg); // 전송
    }
}
