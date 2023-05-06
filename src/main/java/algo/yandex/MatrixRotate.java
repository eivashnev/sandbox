package algo.yandex;

import java.util.Arrays;

/*
* Вращение матрицы на 90
* */
public class MatrixRotate {
    public static void main(String[] args) {
        int[][] m = new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(Arrays.deepToString(m));


        //вращение 90 по часовой = transpose + swapColums
        //вращение 90 против часовой = transpose + swapRows
        //вращение на 180 = swapRows + swapColumns

        transpose(m);
        //swapColumns(m);//rotate 90 clockwise
        swapRows(m);//rotate 90 counterclockwise

        System.out.println(Arrays.deepToString(m));
    }

    private static void transpose(int[][] m) {
        int s = m[0].length;

        for (int i = 0; i < s; i++) {
            for (int j = i; j < s; j++) {
                int tmp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = tmp;
            }
        }
    }
    private static void swapColumns(int[][] m) {
        int s = m[0].length;
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s/2; j++) {
                int tmp = m[i][j];
                m[i][j] = m[i][s - j - 1];
                m[i][s - j - 1] = tmp;
            }
        }
    }

    private static void swapRows(int[][] m) {
        int s = m[0].length;
        for (int i = 0; i < s / 2; i++) {
            for (int j = 0; j < s; j++) {
                int tmp = m[i][j];
                m[i][j] = m[s - i - 1][j];
                m[s - i - 1][j] = tmp;
            }
        }
    }


}
