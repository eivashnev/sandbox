package april;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectionsTest {

    static class Box {
        private String id;
        private String name;

        public Box(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        @Override
        public String toString() {
            return "april.Box{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {


        Map<Integer, Box> map = new HashMap<>();
        map.put(1, new Box("123hl21k3hk1", "Superbox"));
        map.put(2, new Box("zxb86z8b", "Nanobox"));
        map.put(3, new Box("ahj42g4", "Smallbox"));
        map.put(4, new Box("vbc8n67c", "Goodbox"));

        Map<String, Box> chatSessions = map.entrySet().stream()
                .collect(
                        Collectors.toMap(k -> k.getValue().getId(), v -> v.getValue())
                );

        System.out.println(chatSessions.get("asdad"));
    }
}
