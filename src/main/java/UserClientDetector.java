import io.github.mngsk.devicedetector.Detection;
import io.github.mngsk.devicedetector.DeviceDetector;
import io.github.mngsk.devicedetector.DeviceDetector.DeviceDetectorBuilder;

public class UserClientDetector {


    public static void main(String[] args) {
        String userAgent = "Mozilla/5.0 (Linux; Android 11; RMX2001) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Mobile Safari/537.36";
        userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/111.0";

        DeviceDetector dd = new DeviceDetectorBuilder().build();
        Detection detection = dd.detect(userAgent);
        System.out.println(detection.getDevice().map(d -> d.toString()).orElse("unknown"));
        System.out.println(detection.getOperatingSystem().map(d -> d.toString()).orElse("unknown"));
        System.out.println(detection.getClient().map(d -> d.toString()).orElse("unknown"));

        if (detection.getDevice().isPresent()) {
            System.out.println(detection.getDevice().get().getType()); // bot, browser, feed reader...
            System.out.println(detection.getDevice().get().getBrand().orElse("unknown"));
            System.out.println(detection.getDevice().get().getModel().orElse("unknown"));
        }
    }
}
