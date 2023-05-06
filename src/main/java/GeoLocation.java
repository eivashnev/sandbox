import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;

public class GeoLocation {

    public static void main(String[] args) {

        try {
            // Create a File object pointing to the GeoIP2 database
            File database = new File("src/main/resources/GeoLite2-City.mmdb");

            // Create a DatabaseReader object using the GeoIP2 database
            DatabaseReader reader = new DatabaseReader.Builder(database).build();

            // Provide an IP address to look up
            InetAddress ipAddress = InetAddress.getByName("194.190.152.158");

            // Use the DatabaseReader object to look up the IP address
            CityResponse response = reader.city(ipAddress);

            // Get the country and city name from the response object
            String countryName = response.getCountry().getName();
            String cityName = response.getCity().getName();

            // Print the country and city name to the console
            System.out.println("Country: " + countryName);
            System.out.println("City: " + cityName);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (GeoIp2Exception e) {
            throw new RuntimeException(e);
        }
    }
}