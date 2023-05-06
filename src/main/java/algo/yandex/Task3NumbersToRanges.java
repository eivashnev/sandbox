package algo.yandex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

/*
* Дан список интов, повторяющихся элементов в списке нет.
* Нужно преобразовать это множество в строку, сворачивая соседние по числовому ряду числа в диапазоны.
* Примеры:
* [1,4,5,2,3,9,8,11,0] => "0-5,8-9,11"
* [1,4,3,2] => "1-4"
* [1,4] => "1,4"
* */
public class Task3NumbersToRanges {

    public static void main(String[] args) {

        int[] a = new int[]{1,4,5,2,3,9,8,11,12,14,7,0};
        //int[] a = new int[]{1,4};
        //int[] a = new int[]{1,4,3,2,7};

        StringJoiner ranges = new StringJoiner(",");

        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        Integer lb = null;
        Integer rb = null;
        for (int i = 0; i < a.length; i++) {

            if (lb == null) lb = a[i];


            if (i+1 != a.length && a[i] == a[i+1]-1) {
                rb = a[i+1];
            } else {
                if (rb == null) {
                    ranges.add(lb + "");
                } else {
                    ranges.add(lb + "-" +rb);
                }
                lb = null;
                rb = null;
            }
        }

        System.out.println(ranges);

    }
}
