package ru.sbt.bit.ood.solid.homework;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

public class MailSender {

    public static void sendHTMLMessage(String host, String messageBody, String subject, String recipients) throws MessagingException {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(host);

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(recipients);

        helper.setText(messageBody, true);
        helper.setSubject(subject);

        mailSender.send(message);
    }
}
