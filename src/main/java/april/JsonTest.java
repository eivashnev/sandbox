package april;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import models.AddedCRM;
import models.CrmDetails;
import models.CustomerCrm;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;

public class JsonTest {
    public static void main(String[] args) throws IOException {

        String plainTextBody = "asdf56";
        String shortedBody = !StringUtils.isBlank(plainTextBody) && plainTextBody.length() > 5
                ? plainTextBody.substring(0, 4) + "***"
                : plainTextBody;
        System.out.println(shortedBody);
        String s = "12345";
        System.out.println(s.length());
        System.out.println(s.substring(0,5));
        String sb = "{\"updated\":[],\"added\":[{\"crmName\":\"Fasd\",\"crmId\":\"1231\"}],\"deleted\":[]}";
        ObjectMapper mapper = new ObjectMapper();
        CrmDetails details = mapper.readValue(sb, CrmDetails.class);

        for (CustomerCrm detail : details.getUpdated()) {
            System.out.println(detail.getCrmId());
        }

    }

}
