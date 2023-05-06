package april;

import org.apache.commons.lang3.StringUtils;

public class Regex {

    public static void main(String[] args) {
        String url = "\\//proglib.io/p/25-java-regex/";
        String url2 = url.replaceAll("^(\\|/)+$", "").replaceAll("^(\\|/)+", "").trim();
        System.out.println(url2);

        String s =  "\"string\"";

        System.out.println(s.replaceAll("^(?:\")$", ""));

        final String SchrodingersQuotedString = "may or may\" not be quoted";
        StringUtils.strip(SchrodingersQuotedString, "\""); //quoted no more
        System.out.println(StringUtils.strip(SchrodingersQuotedString, "\""));
    }
}
