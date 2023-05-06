package algo.leetcode;

public class ReverseInteger {
    public static void main(String[] args) {
        int x = -153423646;

        System.out.println("Initial: " + x);
        System.out.println("Reversed stupid: " + reverseStupid(x));
        System.out.println("Reversed good: " + reverseGood(x));

    }

    public static int reverseGood(int x) {
        long r = 0;
        while(x!=0) {
            r = r * 10 + x % 10;
            x /= 10;

            if( r > Integer.MAX_VALUE || r < Integer.MIN_VALUE) return 0;
        }

        return (int) r;
    }

    public static int reverseStupid(int x) {
        if( x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) return 0;

        String s = String.valueOf(x);
        boolean negative = false;

        if (s.startsWith("-")) {
            s = s.replace("-", "");
            negative = true;
        }
        char[] ca = s.toCharArray();

        int size = ca.length;
        for (int i = 0; i < size/2; i++) {
            char tmp = ca[i];
            ca[i] = ca[size-i-1];
            ca[size-i-1] = tmp;
        }

        String result = new String(ca);

        try {
            return negative ? Integer.valueOf(result) * (-1) :  Integer.valueOf(result);
        } catch (NumberFormatException ex) {
            return 0;
        }
    }
}
