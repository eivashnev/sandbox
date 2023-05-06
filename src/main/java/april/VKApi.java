package april;

import com.sun.media.sound.JavaSoundAudioClip;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.messages.Message;
import com.vk.api.sdk.queries.messages.MessagesGetLongPollHistoryQuery;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class VKApi {
    public static void main(String[] args) throws ClientException, ApiException, InterruptedException, ApiException, ClientException {
        TransportClient transportClient = new HttpTransportClient();
        VkApiClient vk = new VkApiClient(transportClient);
        Random random = new Random();
        GroupActor groupActor = new GroupActor(160851048, "vk1.a.jI_J-Gxp1gb16RZljmUs7TB9t2M74mtWuS6FUQl2_pSybyWYeloZBt34yuFyS5_Vt99oyy5OFApO9todjhfDh8LyVpcCW1fdMhSLEUS1bR03A8YQO8wwhSfNi7xoKHrWWv9MQd3zuw3dgBb5AkFI5uKJdDlKvXeavnWhcR2yLnZjxA7jeUuLk_DGzWS4THXB");
        Integer ts = vk.messages().getLongPollServer(groupActor).execute().getTs();
        while (true) {
            MessagesGetLongPollHistoryQuery historyQuery = vk.messages().getLongPollHistory(groupActor).ts(ts);
            List<Message> messages = historyQuery.execute().getMessages().getItems();
            if (!messages.isEmpty()) {
                messages.forEach(message -> {
                    System.out.println("\n" + message);
                    if (message.getText().contains("test")) {

                        try {
                            notifyMe();
                            vk.messages().send(groupActor).message("qq").userId(message.getFromId()).randomId(random.nextInt(10000)).execute();
                        } catch (ApiException | ClientException | RuntimeException e) {
                            e.printStackTrace();
                            return;
                        }
                    }

                });
            }
            ts = vk.messages().getLongPollServer(groupActor).execute().getTs();
            Thread.sleep(1000);
            System.out.print(".");

        }

    }

    private static void notifyMe() {
        try {
            new JavaSoundAudioClip(new FileInputStream(new File("C:\\myfiles\\notif.wav"))).play();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
