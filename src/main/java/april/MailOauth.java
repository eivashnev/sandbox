package april;

import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.smtp.SMTPTransport;
import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.Address;
import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class MailOauth {
    public static void main(String[] args) throws MessagingException, GeneralSecurityException, InterruptedException, UnsupportedEncodingException {
        testSmtpBasic();
        //testSmtp();
        //testImap();
        //testPop3();
    }

    static void testImap() throws MessagingException {
        Properties properties = new Properties();
        properties.put("mail.imap.ssl.enable", "true");
        properties.put("mail.imap.auth.mechanisms", "XOAUTH2");
        //properties.put("mail.imap.sasl.enable", "true"); //un-commented still results are same
        properties.put("mail.imap.auth.login.disable", "true");
        properties.put("mail.imap.auth.plain.disable", "true");
        properties.put("mail.debug", "true");
        properties.put("mail.store.protocol", "imap");
        properties.put("mail.imap.host", "outlook.office365.com");
        properties.put("mail.imap.port", "993");
        //properties.put("mail.imap.starttls.enable", "true");
        properties.put("mail.imap.auth", "true");
        properties.put("mail.imap.user", "oceana_o365_spe_3@avaya365it.onmicrosoft.com");

        String userEmail = "oceana_o365_spe_3@avaya365it.onmicrosoft.com";
        String accessToken = "eyJ0eXAiOiJKV1QiLCJub25jZSI6Ijd2dFdQQW4zYnFfalhFSGpmanZuSWhteFdCb3kxVWltd1RHZHZvSkU2S00iLCJhbGciOiJSUzI1NiIsIng1dCI6Ii1LSTNROW5OUjdiUm9meG1lWm9YcWJIWkdldyIsImtpZCI6Ii1LSTNROW5OUjdiUm9meG1lWm9YcWJIWkdldyJ9.eyJhdWQiOiJodHRwczovL291dGxvb2sub2ZmaWNlMzY1LmNvbSIsImlzcyI6Imh0dHBzOi8vc3RzLndpbmRvd3MubmV0L2VmZWQ1ZmE3LWQyMmQtNDU2ZS1hYjIzLTdjNmVlNjE5MmRiZC8iLCJpYXQiOjE2NzQ1ODM0MzgsIm5iZiI6MTY3NDU4MzQzOCwiZXhwIjoxNjc0NTg3MzM4LCJhaW8iOiJFMlpnWU9nNHF2N3Fac1RSS3Y1dis2UnpEcnBLQWdBPSIsImFwcF9kaXNwbGF5bmFtZSI6IkVtYWlsIENvbnRyb2xsZXIiLCJhcHBpZCI6IjcxN2E5YWY0LTViYWMtNDYyMC1iY2IyLTI3ODNiNDk2NmY4NSIsImFwcGlkYWNyIjoiMSIsImlkcCI6Imh0dHBzOi8vc3RzLndpbmRvd3MubmV0L2VmZWQ1ZmE3LWQyMmQtNDU2ZS1hYjIzLTdjNmVlNjE5MmRiZC8iLCJvaWQiOiI2NmY3NTAwMy1hZWZhLTQxYmEtOGU3Yy1kNzBlZmM0ZjNkNDEiLCJyaCI6IjAuQVVVQXAxX3Q3eTNTYmtXckkzeHU1aGt0dlFJQUFBQUFBUEVQemdBQUFBQUFBQUJGQUFBLiIsInJvbGVzIjpbIlVzZXIuUmVhZC5BbGwiLCJmdWxsX2FjY2Vzc19hc19hcHAiLCJNYWlsLlJlYWRXcml0ZSIsIlVzZXIuUmVhZEJhc2ljLkFsbCIsIk1haWwuUmVhZCIsIk1haWwuU2VuZCIsIkV4Y2hhbmdlLk1hbmFnZUFzQXBwIiwiUE9QLkFjY2Vzc0FzQXBwIiwiSU1BUC5BY2Nlc3NBc0FwcCJdLCJzaWQiOiI5ZTRhZTA4Zi0xNDRhLTQxODgtYjYwYy0xYmIwNWU2NGQ2OGYiLCJzdWIiOiI2NmY3NTAwMy1hZWZhLTQxYmEtOGU3Yy1kNzBlZmM0ZjNkNDEiLCJ0aWQiOiJlZmVkNWZhNy1kMjJkLTQ1NmUtYWIyMy03YzZlZTYxOTJkYmQiLCJ1dGkiOiJVOURpRVphdlBrR1hPLWZ1X1NnN0FBIiwidmVyIjoiMS4wIiwid2lkcyI6WyIwOTk3YTFkMC0wZDFkLTRhY2ItYjQwOC1kNWNhNzMxMjFlOTAiXX0.Y1NPFqg_XVbi_kZtGt_G4TM8cxlz_xgeR_7vfOJOANLxMZVyNgKDOU5MM35JLLItnelYnyCCZDRHl737ap48WKpTYIFbJtWmlCA5-bl98LDXavWO0JTcaGb61Z12DR6UAB5meTljiOodIKaPBOYUPpWsY-vDwiVrTTRDQHqZFo-69jOd5irInfriUrfcsOxUjSwNZc9YOzQCXDLvg3SoPSm0XC3OOfHEMHOe3EIGrb39EANodvUVfuSJFUBYcwbH9MKILCHxELW4DD7_G3u3QCtjdgiXhe1TIEUa_u3kp7S7Gnvg0g0FXSF_OajyMv7ct3LPOT4SQRHxDjJijvOYvA";
        properties.forEach(
                (key, value) -> System.out.println("EVGENY. " + "Property name : [" +key + "], value: "+ value));
        Session session = Session.getInstance(properties);
/*        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userEmail, accessToken);
            }
        });*/
        session.setDebug(true);

        final Store store = session.getStore();
        store.connect("outlook.office365.com", 993, userEmail, accessToken);
        //store.connect();

        javax.mail.Folder[] folders = store.getDefaultFolder().list("*");
        for (javax.mail.Folder folder : folders) {
            if ((folder.getType() & javax.mail.Folder.HOLDS_MESSAGES) != 0) {
                System.out.println(folder.getFullName() + ": " + folder.getMessageCount());
            }
        }
    }

    static void testPop3() throws MessagingException {
        Properties properties = new Properties();
        properties.put("mail.pop3.ssl.enable", "true");
        properties.put("mail.pop3.auth.mechanisms", "XOAUTH2");
        //properties.put("mail.imap.sasl.enable", "true"); //un-commented still results are same
        properties.put("mail.pop3.auth.login.disable", "true");
        properties.put("mail.pop3.auth.plain.disable", "true");
        properties.put("mail.debug", "true");
        properties.put("mail.store.protocol", "pop3");
        properties.put("mail.pop3.host", "outlook.office365.com");
        properties.put("mail.pop3.port", "995");
        properties.put("mail.pop3.auth.xoauth2.two.line.authentication.format", "true");
        //properties.put("mail.imap.starttls.enable", "true");
        properties.put("mail.pop3.auth", "true");
        properties.put("mail.pop3.user", "oceana_o365_spe_3@avaya365it.onmicrosoft.com");

        String userEmail = "oceana_o365_spe_3@avaya365it.onmicrosoft.com";
        String accessToken = "eyJ0eXAiOiJKV1QiLCJub25jZSI6Inh6dkVLSkZCRDV5OXN4NXdvVEhHR2UySFl4M3VFMTV3bjFldmNfa1Z0VFkiLCJhbGciOiJSUzI1NiIsIng1dCI6Ii1LSTNROW5OUjdiUm9meG1lWm9YcWJIWkdldyIsImtpZCI6Ii1LSTNROW5OUjdiUm9meG1lWm9YcWJIWkdldyJ9.eyJhdWQiOiJodHRwczovL291dGxvb2sub2ZmaWNlMzY1LmNvbSIsImlzcyI6Imh0dHBzOi8vc3RzLndpbmRvd3MubmV0L2VmZWQ1ZmE3LWQyMmQtNDU2ZS1hYjIzLTdjNmVlNjE5MmRiZC8iLCJpYXQiOjE2NzQ1ODcyNDMsIm5iZiI6MTY3NDU4NzI0MywiZXhwIjoxNjc0NTkxMTQzLCJhaW8iOiJFMlpnWVBocXBIa3l1c0Q4dlV2RmdwOEZzejN6QUE9PSIsImFwcF9kaXNwbGF5bmFtZSI6IkVtYWlsIENvbnRyb2xsZXIiLCJhcHBpZCI6IjcxN2E5YWY0LTViYWMtNDYyMC1iY2IyLTI3ODNiNDk2NmY4NSIsImFwcGlkYWNyIjoiMSIsImlkcCI6Imh0dHBzOi8vc3RzLndpbmRvd3MubmV0L2VmZWQ1ZmE3LWQyMmQtNDU2ZS1hYjIzLTdjNmVlNjE5MmRiZC8iLCJvaWQiOiI2NmY3NTAwMy1hZWZhLTQxYmEtOGU3Yy1kNzBlZmM0ZjNkNDEiLCJyaCI6IjAuQVVVQXAxX3Q3eTNTYmtXckkzeHU1aGt0dlFJQUFBQUFBUEVQemdBQUFBQUFBQUJGQUFBLiIsInJvbGVzIjpbIlVzZXIuUmVhZC5BbGwiLCJmdWxsX2FjY2Vzc19hc19hcHAiLCJNYWlsLlJlYWRXcml0ZSIsIlVzZXIuUmVhZEJhc2ljLkFsbCIsIk1haWwuUmVhZCIsIk1haWwuU2VuZCIsIkV4Y2hhbmdlLk1hbmFnZUFzQXBwIiwiUE9QLkFjY2Vzc0FzQXBwIiwiSU1BUC5BY2Nlc3NBc0FwcCJdLCJzaWQiOiI1NzgwYTAxZS0xNzQwLTQ1MDYtOGNmOS05OTZhY2YzMDYzMTEiLCJzdWIiOiI2NmY3NTAwMy1hZWZhLTQxYmEtOGU3Yy1kNzBlZmM0ZjNkNDEiLCJ0aWQiOiJlZmVkNWZhNy1kMjJkLTQ1NmUtYWIyMy03YzZlZTYxOTJkYmQiLCJ1dGkiOiJadjNOa3I0cVZVZW51Uk1xZGxrMEFBIiwidmVyIjoiMS4wIiwid2lkcyI6WyIwOTk3YTFkMC0wZDFkLTRhY2ItYjQwOC1kNWNhNzMxMjFlOTAiXX0.fQnXM-tev0bPQGIriMToTAY1YqCtfqqgRzXpcPp4FoQIRhJkzCH8ZYDEB4vNNKW06-xlLQ7TrTu-TDYJxx00zgCYJT1E21F8nZTfK2UMJEHBnTt-YU6ue70XTj1SJm2NdSAei5hSJd8yKsI8UJn2dbsKnnE8Mk9yxwaG_hTHJzZ8tLM9JEGXaF83WKvjqXIKbKCScOTcMF4E7xfS9MxnjTiXEk9I4I1Qtt5RiR5ilTY680pKx4B3mq1GoqkmDSMfSTYHQmyXuD5L2bFxZDF8nU0HZ8UHMjD-3OztEjZRNRBxTBhHKT3jqzDXmsRPmnlvcwtVA98aXrSoL8ZL3Zu8LQ";
        properties.forEach(
                (key, value) -> System.out.println("EVGENY. " + "Property name : [" +key + "], value: "+ value));
        Session session = Session.getInstance(properties);
/*        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userEmail, accessToken);
            }
        });*/
        session.setDebug(true);

        final Store store = session.getStore();
        store.connect("outlook.office365.com", 995, userEmail, accessToken);
        //store.connect();

        javax.mail.Folder[] folders = store.getDefaultFolder().list("*");
        for (javax.mail.Folder folder : folders) {
            if ((folder.getType() & javax.mail.Folder.HOLDS_MESSAGES) != 0) {
                System.out.println(folder.getFullName() + ": " + folder.getMessageCount());
            }
        }
    }

    static void testSmtpBasic() throws MessagingException, UnsupportedEncodingException {
        Properties properties = new Properties();
        properties.put("mail.smtp.ssl.enable", "false");
        //properties.put("mail.smtp.auth.mechanisms", "XOAUTH2");
        //properties.put("mail.imap.sasl.enable", "true"); //un-commented still results are same
        //properties.put("mail.smtp.auth.login.disable", "true");
        //properties.put("mail.smtp.auth.plain.disable", "true");
        properties.put("mail.debug", "true");
        //properties.put("mail.store.protocol", "imap");
        properties.put("mail.smtp.host", "outlook.office365.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        //properties.put("mail.smtp.starttls.required", "true");
        properties.put("mail.smtp.auth", "true");
        //properties.put("mail.imap.user", "oceana_o365_spe_3@avaya365it.onmicrosoft.com");

        Session session = Session.getInstance(properties);
        session.setDebug(true);

        String userEmail = "oceana_o365_spe_4@avaya365it.onmicrosoft.com";
        //String accessToken = "eyJ0eXAiOiJKV1QiLCJub25jZSI6Ik95TDdYaFRsUUNrTmVSMk5Genp2bGEtRDFPaVZKOEp5dDVMMUJIU1A3Mk0iLCJhbGciOiJSUzI1NiIsIng1dCI6Ii1LSTNROW5OUjdiUm9meG1lWm9YcWJIWkdldyIsImtpZCI6Ii1LSTNROW5OUjdiUm9meG1lWm9YcWJIWkdldyJ9.eyJhdWQiOiJodHRwczovL291dGxvb2sub2ZmaWNlMzY1LmNvbSIsImlzcyI6Imh0dHBzOi8vc3RzLndpbmRvd3MubmV0L2VmZWQ1ZmE3LWQyMmQtNDU2ZS1hYjIzLTdjNmVlNjE5MmRiZC8iLCJpYXQiOjE2NzM0NDAyNjEsIm5iZiI6MTY3MzQ0MDI2MSwiZXhwIjoxNjczNDQ0MTYxLCJhaW8iOiJFMlpnWUNqYlpMKzk5TGErZWQ5blYrUEhsUmI5QUE9PSIsImFwcF9kaXNwbGF5bmFtZSI6IkVtYWlsIENvbnRyb2xsZXIiLCJhcHBpZCI6IjcxN2E5YWY0LTViYWMtNDYyMC1iY2IyLTI3ODNiNDk2NmY4NSIsImFwcGlkYWNyIjoiMSIsImlkcCI6Imh0dHBzOi8vc3RzLndpbmRvd3MubmV0L2VmZWQ1ZmE3LWQyMmQtNDU2ZS1hYjIzLTdjNmVlNjE5MmRiZC8iLCJvaWQiOiI2NmY3NTAwMy1hZWZhLTQxYmEtOGU3Yy1kNzBlZmM0ZjNkNDEiLCJyaCI6IjAuQVVVQXAxX3Q3eTNTYmtXckkzeHU1aGt0dlFJQUFBQUFBUEVQemdBQUFBQUFBQUJGQUFBLiIsInJvbGVzIjpbIlVzZXIuUmVhZC5BbGwiLCJmdWxsX2FjY2Vzc19hc19hcHAiLCJNYWlsLlJlYWRXcml0ZSIsIlVzZXIuUmVhZEJhc2ljLkFsbCIsIk1haWwuUmVhZCIsIk1haWwuU2VuZCIsIkV4Y2hhbmdlLk1hbmFnZUFzQXBwIiwiUE9QLkFjY2Vzc0FzQXBwIiwiSU1BUC5BY2Nlc3NBc0FwcCJdLCJzaWQiOiJiZmYyNmNhYy0wMjc3LTQ2MjAtODRhNS1lZDdmY2ZhODY1ZWIiLCJzdWIiOiI2NmY3NTAwMy1hZWZhLTQxYmEtOGU3Yy1kNzBlZmM0ZjNkNDEiLCJ0aWQiOiJlZmVkNWZhNy1kMjJkLTQ1NmUtYWIyMy03YzZlZTYxOTJkYmQiLCJ1dGkiOiJmUGtQRHotMF9FZTBHYkQ4WmhJZUF3IiwidmVyIjoiMS4wIiwid2lkcyI6WyIwOTk3YTFkMC0wZDFkLTRhY2ItYjQwOC1kNWNhNzMxMjFlOTAiXX0.pgPDmX3SePU_b5wWHD4rd7sJt1CIlAS1oBrNb0f7hzYhmP62mxMpBc94pBCDlp5QT64dMhiENykrJODjFbLmEYzMyaFrE0AMZVyuN8YWpSNRZs5Fy5_b53DMfEef_e8WHIX7HfbARKRjWDAIJu6qaLq9I8jXDTVACA9Mr82Djq5LhpBR_P9grAOZWGFgw6HoCmYcgfOmtDQe5ZCmy_0TkZiwfmCc1e4wRAXfwJTCJZaCNeDdOffqHNMOTedNq_3gHLGtq7zUsvCU22svae4GlkP3XvaGAN_tXzALXmrsA5AaqFE8OooyvMvDwHUSRrsrbHDOfmoeBVJdTRHSpMXjYA";
        String accessToken = "Avaya123!";


        SMTPTransport transport = new SMTPTransport(session, null);
        transport.connect("outlook.office365.com", 587, userEmail, accessToken);

        String fromUserEmail = "oceana_o365_spe_4@avaya365it.onmicrosoft.com";
        String toEmail = "oceana_o365_spe_1@avaya365it.onmicrosoft.com";
        String fromUserFullName = "Evgeny";
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(fromUserEmail, fromUserFullName));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
        msg.setSubject("test subj");
        msg.setContent("body", "text/html");
        transport.sendMessage(msg, msg.getAllRecipients());

    }

    static void testSmtp() throws MessagingException, UnsupportedEncodingException {
        Properties properties = new Properties();
        properties.put("mail.smtp.ssl.enable", "false");
        properties.put("mail.smtp.auth.mechanisms", "XOAUTH2");
        //properties.put("mail.imap.sasl.enable", "true"); //un-commented still results are same
        properties.put("mail.smtp.auth.login.disable", "true");
        properties.put("mail.smtp.auth.plain.disable", "true");
        properties.put("mail.debug", "true");
        //properties.put("mail.store.protocol", "imap");
        properties.put("mail.smtp.host", "outlook.office365.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        //properties.put("mail.smtp.starttls.required", "true");
        properties.put("mail.smtp.auth", "true");
        //properties.put("mail.imap.user", "oceana_o365_spe_3@avaya365it.onmicrosoft.com");

        Session session = Session.getInstance(properties);
        session.setDebug(true);

        String userEmail = "oceana_o365_spe_3@avaya365it.onmicrosoft.com";
        String accessToken = "eyJ0eXAiOiJKV1QiLCJub25jZSI6IkhvSG9CQ1JKeS1pTzBCWHE4enUtdTZraHpOODZYOFhyMjEyRVRLaThqejgiLCJhbGciOiJSUzI1NiIsIng1dCI6Ii1LSTNROW5OUjdiUm9meG1lWm9YcWJIWkdldyIsImtpZCI6Ii1LSTNROW5OUjdiUm9meG1lWm9YcWJIWkdldyJ9.eyJhdWQiOiJodHRwczovL291dGxvb2sub2ZmaWNlMzY1LmNvbSIsImlzcyI6Imh0dHBzOi8vc3RzLndpbmRvd3MubmV0L2VmZWQ1ZmE3LWQyMmQtNDU2ZS1hYjIzLTdjNmVlNjE5MmRiZC8iLCJpYXQiOjE2NzM0MzcyODcsIm5iZiI6MTY3MzQzNzI4NywiZXhwIjoxNjczNDQxMTg3LCJhaW8iOiJFMlpnWUpnVmZiRC8vOW5FMVlwVFQ1dGRtdlZyUGdBPSIsImFwcF9kaXNwbGF5bmFtZSI6IkVtYWlsIENvbnRyb2xsZXIiLCJhcHBpZCI6IjcxN2E5YWY0LTViYWMtNDYyMC1iY2IyLTI3ODNiNDk2NmY4NSIsImFwcGlkYWNyIjoiMSIsImlkcCI6Imh0dHBzOi8vc3RzLndpbmRvd3MubmV0L2VmZWQ1ZmE3LWQyMmQtNDU2ZS1hYjIzLTdjNmVlNjE5MmRiZC8iLCJvaWQiOiI2NmY3NTAwMy1hZWZhLTQxYmEtOGU3Yy1kNzBlZmM0ZjNkNDEiLCJyaCI6IjAuQVVVQXAxX3Q3eTNTYmtXckkzeHU1aGt0dlFJQUFBQUFBUEVQemdBQUFBQUFBQUJGQUFBLiIsInJvbGVzIjpbIlVzZXIuUmVhZC5BbGwiLCJmdWxsX2FjY2Vzc19hc19hcHAiLCJNYWlsLlJlYWRXcml0ZSIsIlVzZXIuUmVhZEJhc2ljLkFsbCIsIk1haWwuUmVhZCIsIk1haWwuU2VuZCIsIkV4Y2hhbmdlLk1hbmFnZUFzQXBwIiwiUE9QLkFjY2Vzc0FzQXBwIiwiSU1BUC5BY2Nlc3NBc0FwcCJdLCJzaWQiOiI4YWJkMDNiMC05OTAwLTRjMDQtYTQ0Mi01ZDU5MGM0ZmQ5OWQiLCJzdWIiOiI2NmY3NTAwMy1hZWZhLTQxYmEtOGU3Yy1kNzBlZmM0ZjNkNDEiLCJ0aWQiOiJlZmVkNWZhNy1kMjJkLTQ1NmUtYWIyMy03YzZlZTYxOTJkYmQiLCJ1dGkiOiIySFVPY3ZwREMwQzA2SDZrUUZZYkFBIiwidmVyIjoiMS4wIiwid2lkcyI6WyIwOTk3YTFkMC0wZDFkLTRhY2ItYjQwOC1kNWNhNzMxMjFlOTAiXX0.ApijBF9JUFBB8xJKaFuoI4gzT_a4BHisJthYeI4NBwLYG7iEuD97H28kxKQpsJzX5iBmEX6DdQ2j7KvSZLLmQEHuh3aOp7cg_P1EtAYs2jtJJSIbQe9yvlPtyOBO0aZDhZiCuGCez2uYzG4LhP09fxwv5SxjFP_84t4VPpoLwgiPn9yyTbcwaZa0F9NNuDp1eCCdsz8pbwEo9wq66lpqr9pVPzLhaCMOp6sOc_G1Xl4Mj7Eh5vkiED3wlXH0smyQrNV_IGsfICQHjT8NnWfQF8QdF2aUsHBpWzdLCq0ODndMJY6PRgSHLOynCfopEdpVPoKDUleJF08uJmxlsNlbKQ";
        SMTPTransport transport = new SMTPTransport(session, null);
        transport.connect("outlook.office365.com", 587, userEmail, accessToken);

        String fromUserEmail = "oceana_o365_spe_4@avaya365it.onmicrosoft.com";
        String toEmail = "oceana_o365_spe_1@avaya365it.onmicrosoft.com";
        String fromUserFullName = "Evgeny";
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(fromUserEmail, fromUserFullName));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
        msg.setSubject("test subj");
        msg.setContent("body", "text/html");
        transport.sendMessage(msg, msg.getAllRecipients());

    }



}
