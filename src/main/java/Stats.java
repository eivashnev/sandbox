import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;

public class Stats {
    public static void main(String[] args) throws InterruptedException {

        if(false) {
            System.out.println("false?");
        }

/*        for (int i = 0; i < 100; i++) {
            System.out.println(getSystemCpuUsage());
            System.out.println(getSystemMemoryUsage());
            System.out.println(getFreeDiskSpace());
            Thread.sleep(1000);
        }*/

    }

    public static double getSystemCpuUsage() {
        String command = "wmic cpu get loadpercentage /value";
        try {
            Process powerShellProcess = Runtime.getRuntime().exec("powershell.exe " + command);
            powerShellProcess.getOutputStream().close();

            BufferedReader stdout = new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));
            String line;
            while ((line = stdout.readLine()) != null) {
                if (line.contains("LoadPercentage")) {
                    line = line.trim().replace("LoadPercentage=", "");
                    return Double.parseDouble(line) / 100;
                }
            }
            stdout.close();

            BufferedReader stderr = new BufferedReader(new InputStreamReader(powerShellProcess.getErrorStream()));
            while ((line = stderr.readLine()) != null) {
                System.err.println(line);
            }
            stderr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public static double getSystemCpuUsage2() {
        com.sun.management.OperatingSystemMXBean osBean = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        return osBean.getProcessCpuLoad() * 100;
    }

    public static double getSystemMemoryUsage() {
        com.sun.management.OperatingSystemMXBean osBean = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        double total = osBean.getTotalPhysicalMemorySize();
        double free = osBean.getFreePhysicalMemorySize();
        double perc = (total - free) / total;
        return perc;
    }

    public static double getFreeDiskSpace() {
        File[] roots = File.listRoots();
        double freeSpace = 0;
        for (File root : roots) {
            freeSpace += root.getUsableSpace();
        }
        return freeSpace / (1024 * 1024 * 1024) / 476;
    }
}
