package Utilities;

import jakarta.mail.*;
import jakarta.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GmailOTPReader {
    private static final String EMAIL = "your_real_email@gmail.com";
    private static final String APP_PASSWORD = "your_real_app_password";
    public static String waitForOTP(long startTime) throws Exception {
        Properties props = new Properties();
        props.put("mail.store.protocol", "imaps");
        Session session = Session.getDefaultInstance(props);
        Store store = session.getStore("imaps");
        store.connect(
                "imap.gmail.com",
                EMAIL,
                APP_PASSWORD
        );

        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);
        for(int attempt = 0; attempt < 12; attempt++){

            Message[] messages =
                    inbox.getMessages();

            for(int i = messages.length - 1; i >= 0; i--){

                Message msg = messages[i];

                Date received =
                        msg.getReceivedDate();

                if(received.getTime() < startTime){
                    continue;
                }

                String body = getTextFromMessage(msg);
                Pattern pattern = Pattern.compile("\\b\\d{6}\\b");
                Matcher matcher = pattern.matcher(body);
                if(matcher.find()){
                    String otp = matcher.group();
                    inbox.close(false);
                    store.close();
                    return otp;
                }
            }
            Thread.sleep(5000);
            inbox.close(false);
            inbox.open(Folder.READ_ONLY);
        }
        inbox.close(false);
        store.close();
        return null;
    }

    private static String getTextFromMessage(Message message)
            throws Exception {
        if(message.isMimeType("text/plain")){
            return message.getContent().toString();
        }
        if(message.isMimeType("multipart/*")){
            MimeMultipart mimeMultipart =
                    (MimeMultipart) message.getContent();
            return getTextFromMimeMultipart(mimeMultipart);
        }
        return "";
    }

    private static String getTextFromMimeMultipart(
            MimeMultipart mimeMultipart)
            throws Exception {
        StringBuilder result = new StringBuilder();
        int count = mimeMultipart.getCount();
        for(int i = 0; i < count; i++){
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if(bodyPart.isMimeType("text/plain")){
                result.append(bodyPart.getContent());
            } else if(bodyPart.isMimeType("text/html")){
                result.append(
                        bodyPart.getContent().toString()
                );
            }
        }
        return result.toString();
    }
}