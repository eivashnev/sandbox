package algo.yandex;


import java.util.Arrays;
import java.util.List;

/*
* Дан массив из нулей и единиц.
* Нужно определить, какой максимальный по длине подинтервал единиц можно получить, удалив ровно один элемент массива.
* Пример [0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1]
* return max_ones_length */
public class Task4MaxOnesLength {
    public static void main(String[] args) {
        int[] arr = new int[] {0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0,1,1,1,1,0,0,1,1};

        System.out.println(maxOnes(arr));

        System.out.println(findMaxInterval(arr));


    }

    public static int findMaxInterval(int[] arr) {
        int maxIntervalSize = 0;
        int currentIntervalSize = 0;
        boolean foundZero = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                if (foundZero) {
                    currentIntervalSize = 1;
                    foundZero = false;
                } else {
                    currentIntervalSize += 1;
                }
            } else if (arr[i] == 0) {
                currentIntervalSize = 0;
                foundZero = false;
            }
            if (currentIntervalSize > maxIntervalSize) {
                maxIntervalSize = currentIntervalSize;
            }
        }
        return maxIntervalSize - 1;
    }

    public static int maxOnes(int[] a) {
        int max = 0;
        if (a == null || a.length == 0) return 0;

        int ozoCnt = 0;
        //find number of removable zeros
        for (int i = 0; i < a.length; i++) {
            if(i+2 < a.length && a[i] == 1 && a[i+1] == 0 && a[i+2] == 1) {
                ozoCnt++;
            }
        }

        //find all indexes of removable zeros
        int[] zidxs = new int[ozoCnt];
        int idx = 0;
        for (int i = 0; i < a.length; i++) {
            if(i+2 < a.length && a[i] == 1 && a[i+1] == 0 && a[i+2] == 1) {
                zidxs[idx] = i+1;
                idx++;
            }
        }

        int[] maxes = new int[ozoCnt];
        for (int i = 0; i < zidxs.length; i++) {
            int lmax = 0;
            for (int j = zidxs[i]; j-1 >= 0 && a[j-1] != 0; j--) {
                lmax++;
            }
            for (int j = zidxs[i]; j+1 < a.length && a[j+1] != 0; j++) {
                lmax++;
            }
            maxes[i] = lmax;
        }

        for (int i = 0; i < maxes.length; i++) {
            if (maxes[i] > max) max = maxes[i];
        }

        System.out.println(Arrays.toString(maxes));


        return max;
    }
}
