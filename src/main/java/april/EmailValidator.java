package april;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.io.IOException;

public class EmailValidator {

    enum ChannelType {
        CHAT("Chat"), EMAIL("Email"), SMS("SMS"), SOCIAL("SOCIAL"), GENERIC("GENERIC"), MESSAGING("MESSAGING");

        /**
         * The name used in ACM / OC DB
         */
        private String typeName;

        ChannelType(String typeName) {
            this.typeName = typeName;
        }

        public String getTypeName() {
            return typeName;
        }

        public static ChannelType getByTypeName(String typeName) {
            if ("CHAT".equalsIgnoreCase(typeName)) {
                return ChannelType.CHAT;
            }
            if ("EMAIL".equalsIgnoreCase(typeName)) {
                return ChannelType.EMAIL;
            }
            if ("SMS".equalsIgnoreCase(typeName)) {
                return ChannelType.SMS;
            }
            if ("SOCIAL".equalsIgnoreCase(typeName)) {
                return ChannelType.SOCIAL;
            }
            if ("GENERIC".equalsIgnoreCase(typeName)) {
                return ChannelType.GENERIC;
            }
            if ("MESSAGING".equalsIgnoreCase(typeName)) {
                return ChannelType.MESSAGING;
            }

            return null;
        }
    }
    public static void main(String[] args) throws IOException {

        ChannelType test = ChannelType.EMAIL;

        System.out.println(test.getTypeName());

        System.out.println(true || false);
        try {
            InternetAddress ia = new InternetAddress(".adr@adr.ru");
            //System.out.println(InternetAddress.class.getClassLoader().getResource("javax/mail/internet/InternetAddress/InternetAddress.class"));
            //ia.validate();
        } catch (AddressException e) {
            e.printStackTrace();
        }
    }
}
