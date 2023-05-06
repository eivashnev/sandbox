package april;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayTest {

    public static void main(String[] args) {
        List<Box> boxes = new ArrayList<>();
      /* boxes.add(new april.Box(8, "skates", 72.0, 6));
        boxes.add(new april.Box(5, "boxes", 80, 2));
       boxes.add(new april.Box(7, "pens", 72.0, 3));
        boxes.add(new april.Box(3, "papers", 70.0, 4));*/
        //boxes.stream().sorted(Comparator.comparingInt(april.Box::getId).reversed()).forEach(b -> { System.out.println("#"+b.id+": "+b.name);});

        //boxes.stream().reduce();
        boxes.forEach(System.out::println);//Consumer func interface
        Map<Box, Double> cache = new HashMap<>();

        cache = boxes.stream()
                .collect(Collectors.toMap(box -> box, box -> getMaxPer(box)));
        Optional<Box> bestMatchingRule = cache.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> e.getKey().getSeq()))
                .max(Comparator.comparingDouble(e -> e.getValue()))
                .filter( e -> e.getValue() > 0).map(e -> e.getKey());

/*        Optional<april.Box> bestMatchingRule = boxes.stream().sorted(Comparator.comparingInt(april.Box::getSeq))
                .max(Comparator.comparingDouble(box -> {
                    System.out.println("from stream");
                    return cache.computeIfAbsent(box.getId(), b -> box.getPercentageMatch());
                }))
                .max(Comparator.comparingDouble(box -> cache.computeIfAbsent(box.getId(), b -> box.getPercentageMatch())))
                .filter(r -> cache.getOrDefault(r.getId(), 0D) > 0);*/
        System.out.println("size: " + cache.size());
        bestMatchingRule.ifPresent(r -> System.out.println(r.getId()));

/*

        Map<String,Integer> list = new ConcurrentHashMap();
        list.entrySet().stream().limit(100).forEach(e -> {
            System.out.println(e.getKey() + " ::: " + e.getValue());
        });
*//*        list.forEach((m,v) -> System.out.println(m + "===="+v));

        System.out.println(2<=2);*//*

        list.put("1", 1);
        list.put("2", 2);
        list.put("3", 3);
        list.put("4", 4);
        list.put("5", 5);
        list.put("6", 6);
        list.put("7", 7);

       list.entrySet().stream().filter(e -> { return e.getValue() > 3;}).limit(5).forEach(e -> {
            System.out.println(e.getKey() + " ::: " + e.getValue());
        });

*//*        list.forEach((m,c) -> {
            if (m.equals("5")) throw new IllegalArgumentException("sd");
        });*//*

        list.forEach((m,c) -> System.out.println("m = " + m + "; c = " + c));

        String abc = "abc";
        list.put(abc, list.getOrDefault(abc, 0) + 1);
        list.put(abc, list.getOrDefault(abc, 0) + 1);
        list.put(abc, list.getOrDefault(abc, 0) + 1);

        System.out.println(list.get(abc));

        list.remove(abc);
        list.remove(abc);

        System.out.println(list.containsKey(abc));

        list.remove("sd");
*//*        list.forEach(s -> {
            if(s.equals("1")) {
                list.remove("2");
                return;
            }
            System.out.println(s);
        });*//*


*//*        String abc = "abc";
        System.out.println(list.contains("abc"));
        list.remove("abc");
        System.out.println(list.contains(abc));*//*
        //Assert.notNull(null, "Message id must not be null");*/
    }

    static Double getMaxPer(Box box) {
        return box.getPercentageMatch();
    }
}
