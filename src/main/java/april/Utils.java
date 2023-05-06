package april;

import org.apache.commons.lang3.StringUtils;

public class Utils {

    public static String addSlovo(String s) {
        System.out.println("slovo");
        return "slovo";
    }

    public static String addTest(String s) {
        if (StringUtils.isNotEmpty(s) && s.contains("abc")) {
            return s + "test";
        }
        return "test";

    }
}
