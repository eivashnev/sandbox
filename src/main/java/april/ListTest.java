package april;

import java.util.*;

public class ListTest {

    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();
        map.put("", "");

        List<String> list2 = new ArrayList<>(Arrays.asList("asdadsa", "asdad"));
        System.out.println(list2);

        List<String> list1 = null;

        for (String a : list1) {
            System.out.println(a);
        }

        String gfg[] = { "Geeks", "for", "Geeks" };
        System.out.println(Arrays.toString(new String[] {String.valueOf("213213"), "sadad"}));

        String s23 = null;
        Integer.parseInt(s23);
        long p = Integer.parseInt(s23);;
        System.out.println("lo ng: "+p);

        Dummy dummy = new Dummy();

        dummy.setName("gg");
        System.out.println(dummy.getName());
        setDumb(dummy, "asdad");
        System.out.println(dummy.getName());

        List<Container> list = new ArrayList<>();
        list.add(new Container("abc"));
        list.add(new Container("adf"));
        list.add(new Container("bsd2"));
       // list.add(null);
        list.add(new Container("b3"));
        list.add(new Container("c2"));

        list.stream()
                .peek(el -> System.out.println("peek: "+el.getName()))
                .filter(el -> el.getName().startsWith("b"))
                .forEach(el -> System.out.println("foreach: "+el.getName()));


        String s = Optional.ofNullable(list).orElse(Collections.emptyList()).stream()
                .filter(extraData -> "b3".equalsIgnoreCase(extraData.getName()))
                .findFirst()
                .map(Container::getName)
                .orElse(null);

        StringBuilder sb = new StringBuilder();
        Optional.ofNullable(list).orElse(Collections.emptyList()).stream().filter(container -> container != null)
                .forEach(container -> {
                    System.out.println(container.getName());
                    sb.append(container.getName());
                });
        System.out.println(sb);


        System.out.println("string s: "+s);

        boolean bool = Boolean.parseBoolean(null);
        System.out.println(bool);


        Boolean bool2 = false;
        makeTrue(bool2);
        System.out.println(bool2);
    }

    private static void setDumb(Dummy dummy, String name) {
        dummy.setName(name);
    }

    private static void makeTrue(Boolean bool) {
        bool = true;
    }


}
