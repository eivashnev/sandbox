package april;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Spring {
    public static ScheduledExecutorService undeletedAuditExecutor = Executors.newSingleThreadScheduledExecutor();
    private static int i;
    public static void main(String[] args) {
        //ScheduledExecutorService undeletedAuditExecutor = Executors.newSingleThreadScheduledExecutor();
        undeletedAuditExecutor.schedule(() -> test(), 5, TimeUnit.SECONDS);
        System.out.println(i++);
        System.out.println(i);

    }

    public static void test() {
        System.out.println("Test");
        undeletedAuditExecutor.schedule(Spring::test, 2, TimeUnit.SECONDS);
    }

}
