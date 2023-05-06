package algo.yandex;


/*
* Дана строка (возможно, пустая), состоящая из букв A-Z: AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB
* Нужно написать функцию RLE, которая на выходе даст строку вида: A4B3C2XYZD4E3F3A6B28
* И сгенерирует ошибку, если на вход пришла невалидная строка.
* Пояснения: Если символ встречается 1 раз, он остается без изменений;
* Если символ повторяется более 1 раза, к нему добавляется количество повторений.
*
* */
public class Task2StringZip {
    public static void main(String[] args) {
        String s = "AAACCAAAABBCCCCCEEEDDDZZHHJJJKIIILLL";
        String result = "";

        if (s == null || s.length() == 0) {
            System.out.println("String should not be null or empty");
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // Validate String
            if (c < 'A' || c > 'Z') {
                System.out.println("Invalid string");
                return;
            }

            result += c;
            int counter = 1;
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(j) == c) {
                    counter++;
                    i = j;
                } else {
                    if (counter > 1) {
                        result += counter;
                    }
                    break;
                }
            }

        }
        System.out.println(result);

    }

}
