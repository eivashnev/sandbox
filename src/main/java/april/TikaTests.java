package april;

import com.google.common.collect.ImmutableMap;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.mime.MimeType;
import org.apache.tika.mime.MimeTypeException;
import org.springframework.util.MimeTypeUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TikaTests {
    public static final ImmutableMap<String, String> ATTACHMENT_NAMES = ImmutableMap.<String, String>builder()
            .put("message/rfc822", "AttachedEmail")
            .put("text/calendar", "CalendarEvent")
            .put("message/delivery-status", "delivery-status")
            .build();


    public static void main(String[] args) throws IOException, MimeTypeException {
        TikaConfig config = TikaConfig.getDefaultConfig();

        String file = "C:\\Users\\ivashnev\\Desktop\\test data\\bird-1382262607iEg";

        Metadata metadata = new Metadata();
        //InputStream stream = TikaInputStream.get(new File(file), metadata);
        //MediaType mediaType = config.getMimeRepository().detect(stream, metadata);

        System.out.println("print "+ ATTACHMENT_NAMES.get("message/rfc822"));
        System.out.println("print "+ ATTACHMENT_NAMES.get("text/calendar"));
        System.out.println("print "+ ATTACHMENT_NAMES.get("message/delivery-status"));
        System.out.println("print "+ ATTACHMENT_NAMES.get("ery-status"));




        org.springframework.util.MimeType mime = MimeTypeUtils.parseMimeType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet; charset=\"utf-8\"; method=REQUEST");

        System.out.println("genert: "+ mime.getType() + "/" + mime.getSubtype());
        org.springframework.util.MimeType mime2 = new org.springframework.util.MimeType(mime.getType(), mime.getSubtype());
        System.out.println("new mime: " + mime2);
        System.out.println("evgen: "+ mime);

        System.out.println("spring: "+MimeTypeUtils.parseMimeType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet; charset=\"utf-8\"; method=REQUEST"));
        System.out.println();

        String type = "text/rfc822-headers";
        String name = type.replaceAll("/", "_");
        System.out.println("NAME: " +name);
        System.out.println(type);
        //MimeType mimeType = config.getMimeRepository().forName(mediaType.toString());
        MimeType mimeType = config.getMimeRepository().forName(type);
        String extension = mimeType.getExtension();


        if (StringUtils.isNotBlank(extension)) {
            System.out.println(extension);
        } else {
            System.out.println("pusto");
        }

        String contentType = "";
        String s = contentType.split(";")[0].trim();
        System.out.println("sadada      "+  s);

        int length = 3;
        boolean useLetters = true;
        boolean useNumbers = true;
        for(int i = 0; i < 10; i++) {
            //String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
            System.out.println(RandomStringUtils.random(length, useLetters, useNumbers));
        }


    }
}
