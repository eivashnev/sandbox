package com.evgen.transcripts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonTest {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        EmailTrasncript emailTrasncript = new EmailTrasncript();

        String p1 = "{\"updated\":[{\"id\":\"300\",\"crmId\":\"vova@mail.ru\",\"crmName\":\"CRM 1asdfaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"crmType\":\"\",\"defaultCrm\":true,\"source\":\"\",\"verified\":false,\"obsolete\":false,\"lastUpdatedBy\":\"\",\"lastUpdatedTimeStamp\":\"2021-12-09 22:39:11\"}],\"added\":[],\"deleted\":[]}";
        String p2 = "{\"updated\":[],\"added\":[{\"crmName\":\"Super CRM\",\"crmId\":\"vova@mail.ru\",\"defaultCrm\":true}],\"deleted\":[]}";
        String p3 = "{\"updated\":[],\"added\":[],\"deleted\":[{\"id\":\"302\",\"crmId\":\"sdasd123\",\"crmName\":\"CRM 3\",\"crmType\":\"\",\"defaultCrm\":false,\"source\":\"\",\"verified\":false,\"obsolete\":false,\"lastUpdatedBy\":\"\",\"lastUpdatedTimeStamp\":\"2021-12-09 23:28:21\"}]}";

        //CRM crm = mapper.readTree(p3).get("deleted")
/*        List<CRM> crms;
        long start = System.currentTimeMillis();
        crms = mapper.readerFor(new TypeReference<List<CRM>>() {}).readValue(mapper.readTree(p3).get("deleted"));
        System.out.println(crms.get(0).getCrmId());
        long time = System.currentTimeMillis() - start;
        System.out.println(time);

        long start2 = System.currentTimeMillis();
        crms = mapper.readValue(mapper.readTree(p3).get("deleted").toString(), new TypeReference<List<CRM>>(){});
        System.out.println(crms.get(0).getCrmId());
        long time2 = System.currentTimeMillis() - start2;
        System.out.println(time2);*/

        CRM[] x = mapper.convertValue(mapper.readTree(p3).get("deleted"), CRM[].class);
        System.out.println(x[0].getCrmName());

        List<CRM> x2 =  Arrays.asList(mapper.convertValue(mapper.readTree(p3).get("deleted"), CRM[].class));
        System.out.println(x2.get(0).getCrmName());

        JsonNode node1 = mapper.readTree(p1);
        JsonNode node2 = mapper.readTree(p2);
        System.out.println(node1.path("updated"));
        //System.out.println(node1.path("added").asText().isEmpty());
        System.out.println(node2.path("added").get(0).get("crmName"));
        System.out.println(node2.get("added"));
        System.out.println(mapper.readTree(p3).get("deleted").get(0));





/*        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(emailTrasncript);
        System.out.println(json);*/
    }
}
