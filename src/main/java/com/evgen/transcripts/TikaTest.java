package com.evgen.transcripts;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.entity.ContentType;
import org.apache.tika.Tika;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.mime.MimeTypeException;
import org.apache.tika.mime.MimeTypes;

import java.sql.SQLException;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public class TikaTest {
    private final Tika tika = new Tika();
    private final static MimeTypes ALL_TYPES = TikaConfig.getDefaultConfig().getMimeRepository();

    public static void main(String[] args) {

        try {
            //System.out.println(ALL_TYPES.forName("null; name=\"dice5.png\""));
            throw new SQLException("sadf");
        } catch (Exception e) {
            System.out.println("Ne mime! "+ e.getMessage());
        }
    }

}
