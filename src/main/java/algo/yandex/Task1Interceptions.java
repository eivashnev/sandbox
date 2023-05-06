package algo.yandex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* Даны два массива: [1, 2, 3, 2, 0] и [5, 1, 2, 7, 3, 2]
* Надо вернуть [1, 2, 2, 3] (порядок неважен)
* Фактически нам нужно вернуть пересечение множеств, но с повторением элементов.
*
* */
public class Task1Interceptions {

    public static void main(String[] args) {
        int[] a1 = new int[] {1, 2, 3, 2, 1, 1, 2, 0};
        int[] a2 = new int[] {5, 1, 2, 7, 1, 3, 2};

        Map<Integer, Integer> numIdx = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < a1.length; i++) {

            //запоминаем индекс совпадения, чтобы не добавлять повторно.
            for (int j = numIdx.getOrDefault(a1[i], 0); j < a2.length; j++) {
                if (a1[i] == a2[j]) {
                    result.add(a1[i]);
                    numIdx.put(a1[i], j + 1);
                    break;
                }
            }
        }

/*
solution 1

        ArrayList<Integer> list1 = new ArrayList<Integer>() {{ for (int i : a1) add(i); }};
        ArrayList<Integer> list2 = new ArrayList<Integer>() {{ for (int i : a2) add(i); }};
        List<Integer> result = new ArrayList<>();


        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i).equals(list2.get(j)) ) {
                    result.add(list1.get(i));
                    list2.remove(j);
                }
            }
        }
        */

        System.out.println(Arrays.deepToString(result.toArray()));


    }
}
