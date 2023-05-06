package april;

import com.google.common.util.concurrent.RateLimiter;

public class RateLimitTest {

    public static void main(String[] args) {

        //RateLimiter r2 = new Smooth
        RateLimiter r = RateLimiter.create(5);
        for (int i =0; i < 100; i ++) {
            System.out.println(i + ": get 1 tokens: " + r.acquire() + "s");
        }
    }
}
