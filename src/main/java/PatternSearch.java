import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternSearch {
    public static void main(String[] args) {
        String input = "sadd123_45678901234567890dadad";
        String pattern = "\\d{3}_\\d{1,20}";

        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(input);

        if (matcher.find()) {
            System.out.println("Match found: " + matcher.group());
        } else {
            System.out.println("No match found.");
        }
    }
}