import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShortenLinkService {

    private static final String SHORT_LINK_PATTERN = "https://wblnk.ru/%03d_%s";
    //private static final Pattern INPUT_LINK_PATTERN = Pattern.compile("^https://www.wildberries.ru/catalog/(\\d{1,20})(?:/detail.aspx)?$");
    private static final Pattern INPUT_LINK_PATTERN = Pattern.compile("^https://www\\.wildberries\\.ru/catalog/(\\d{1,20})[^\\d]*(?:/detail\\.aspx)?$");


    public static void main(String[] args) {
        String inputLink = "https://www.wildberries.ru/catalog/27829222/detail.aspx";

        System.out.println(generateShortLink(inputLink));

        for (int i = 0; i<1000; i++) {
            System.out.println(generateHash(i));
        }

    }

    public static String generateShortLink(String inputLink) {
        // Match the input link against the regular expression pattern
        Matcher matcher = INPUT_LINK_PATTERN.matcher(inputLink);

        // Check if the input link matches the pattern
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid input link format");
        }

        // Extract the "N digits" part from the input link
        String someDigitsStr = matcher.group(1);

        // Extract the first 3 digits of the "N digits" part
        String firstThreeDigits = someDigitsStr.substring(0, 3);

        // Construct the shorter link with the pattern "https://wblnk.ru/{3 digits}_{same N digits as in original link}"
        String shortLink = "https://wblnk.ru/" + firstThreeDigits + "_" + someDigitsStr;


        return shortLink;
    }

    public static String generateHash(int num) {
        int sum = num + 100;
        String hash = String.format("%03d", sum % 1000);
        return hash;
    }
}