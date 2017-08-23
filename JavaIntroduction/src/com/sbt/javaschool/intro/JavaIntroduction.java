package com.sbt.javaschool.intro;

import java.util.Scanner;
import java.util.StringJoiner;

public class JavaIntroduction {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        switch (in.next()) {
            case "2001":
                task2001();
                break;
            case "2002":
                task2002();
                break;
            case "2003":
                task2003();
                break;
            case "2004":
                task2004();
                break;
            case "2005":
                task2005();
                break;
            case "2015":
                task2015();
                break;
            case "2021":
                task2021();
                break;
            case "2022":
                task2022();
                break;
            case "2023":
                task2023();
                break;
            case "2024":
                task2024();
                break;
            case "2025":
                task2025();
                break;
            case "2026":
                task2026();
                break;
            case "2036":
                task2036();
                break;
            case "2037":
                task2037();
                break;
            case "2038":
                task2038();
                break;
            case "2039":
                task2039();
                break;
            case "2040":
                task2040();
                break;
            case "2041":
                task2041();
                break;
            case "2042":
                task2042();
                break;
            default:
                System.out.println("Задание отсутствует");
        }
    }

    /**
     * Заданы a и b. Выведите a+b.
     */
    public static void task2001() {
        Scanner in = new Scanner(System.in);

        int sum = in.nextInt();
        sum += in.nextInt();

        System.out.println(sum);

    }

    /**
     * Задано n целых чисел. Выведите их сумму.
     */
    public static void task2002() {
        Scanner in = new Scanner(System.in);

        int count = in.nextInt();
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += in.nextInt();
        }

        System.out.println(sum);
    }

    /**
     * По заданной последовательности целых чисел выведите ее альтернированную сумму.
     */
    public static void task2003() {
        Scanner in = new Scanner(System.in);

        int count = in.nextInt();
        int sum = 0, sign = 1;

        for (int i = 0; i < count; i++) {
            sum += in.nextInt() * sign;
            sign *= -1;
        }

        System.out.println(sum);
    }

    /**
     * Задан номер года y. Ваша задача вывести 1, если год високосный. Выведите 0 в противном случае.
     * Год является високосным, если он кратен 4 и при этом не кратен 100, либо кратен 400.
     * Так, годы 1700, 1800 и 1900 не были високосными, так как они кратны 100 и не кратны 400.
     * Год 2000 — високосный, так как он кратен 400. 2100, 2200 и 2300 — не високосные.
     */
    public static void task2004() {
        Scanner in = new Scanner(System.in);

        int year = in.nextInt();

        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
            System.out.println(1);
        else
            System.out.println(0);
    }

    /**
     * Заданы n целых чисел. Выведите индекс (позицию) первого из минимальных элементов последовательности.
     * Элементы последовательности занумерованы от 1 слева направо.
     */
    public static void task2005() {
        Scanner in = new Scanner(System.in);

        int count = in.nextInt();
        int min = in.nextInt(), minInd = 1;
        for (int i = 2; i <= count; i++) {
            int next = in.nextInt();
            if (next < min) {
                min = next;
                minInd = i;
            }
        }

        System.out.println(minInd);
    }

    /**
     * Простое число — это натуральное число, которое имеет ровно два различных натуральных делителя: единицу и самого себя. Последовательность простых чисел начинается так: 2, 3, 5, 7, 11, 13, 17, 19, 23,...
     * Напишите программу, которая выведет все простые числа на отрезке [1,n] в порядке возрастания.
     */
    public static void task2015() {
        Scanner in = new Scanner(System.in);

        int count = in.nextInt();

        for (int i = 2; i <= count; i++) {
            boolean isSimple = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isSimple = false;
                    break;
                }
            }
            if (isSimple)
                System.out.println(i);
        }
    }

    /**
     * Вспомогательная функция для задачи 2021. Находит максимальный элемент в массиве.
     *
     * @param array массив, в котором необходимо найти максимум
     * @return - int значение максимального элемента массива
     */
    public static int findMax(int[] array) {
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }
        return max;
    }

    /**
     * Задан массив из n чисел (a1, a2,..., an).
     * С ним два раза повторяют следующую процедуру: одновременно все максимумы в массиве делят на два.
     * Нечетные числа при делении на два следует округлять вниз. Ваша задача — вывести массив после этих действий.
     */
    public static void task2021() {
        Scanner in = new Scanner(System.in);

        int count = in.nextInt();
        int[] array = new int[count];

        for (int i = 0; i < array.length; i++) {
            array[i] = in.nextInt();
        }

        for (int i = 0; i < 2; i++) {
            int max = findMax(array);
            for (int j = 0; j < array.length; j++) {
                if (array[j] == max)
                    array[j] /= 2;
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    /**
     * Задан массив n целых чисел (a1, a2,..., an). Ваша задача — найти количество пар индексов (i, j), что i ≠ j и ai делит aj.
     * Обратите внимание, что пары (i, j) и (j, i) считаются различными.
     */
    public static void task2022() {
        Scanner in = new Scanner(System.in);

        int count = in.nextInt();
        int[] array = new int[count];

        for (int i = 0; i < array.length; i++) {
            array[i] = in.nextInt();
        }

        int result = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j)
                    continue;
                if (array[i] % array[j] == 0)
                    result++;
            }
        }

        System.out.println(result);
    }

    /**
     * Заданы два массива целых положительных чисел: a и b. Ваша задача сформировать такой массив c, содержащий все элементы массива a, которые встречаются в b.
     * В массиве c элементы должны идти в том же порядке, что и a, просто пропускайте те элементы, что не присутству
     */
    public static void task2023() {
        Scanner in = new Scanner(System.in);

        int count = in.nextInt();
        int[] arrayA = new int[count];
        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = in.nextInt();
        }

        count = in.nextInt();
        int[] arrayB = new int[count];
        for (int i = 0; i < arrayB.length; i++) {
            arrayB[i] = in.nextInt();
        }

        int[] arrayC = new int[arrayA.length];

        int indexC = 0;
        for (int i = 0; i < arrayA.length; i++) {
            for (int j = 0; j < arrayB.length; j++) {
                if (arrayA[i] == arrayB[j]) {
                    arrayC[indexC] = arrayA[i];
                    indexC++;
                    break;
                }
            }
        }

        if (arrayC[0] == 0)
            System.out.println(0);
        else {
            System.out.println(indexC);
            for (int i = 0; i < indexC; i++)
                System.out.print(arrayC[i] + " ");
        }
    }

    /**
     * Заданы два массива целых положительных чисел: a и b.
     * Ваша задача сформировать такой массив c, содержащий все элементы массива a, которые встречаются в b.
     * В массиве c элементы должны идти в том же порядке, что и a, просто пропускайте те элементы, что не присутству
     */
    public static void task2024() {
        Scanner in = new Scanner(System.in);

        int count = in.nextInt();
        int[] array = new int[count];

        for (int i = 0; i < array.length; i++) {
            array[i] = in.nextInt();
        }

        int result = 0;
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] != array[array.length - 1 - i])
                result++;
        }

        System.out.println(result);

    }

    /**
     * Рассмотрим простой вариант задачи RMQ (Range Minimum Query, запрос минимума на подмассиве).
     * Задан массив из n целых чисел (a1, a2,..., an) и m запросов вида (li, ri) (1 ≤ li ≤ ri ≤ n).
     * Ваша задача — на каждый запрос вывести минимальный среди элементов с индексами от li до ri включительно.
     */
    public static void task2025() {
        Scanner in = new Scanner(System.in);

        int count = in.nextInt();
        int[] array = new int[count];
        for (int i = 0; i < array.length; i++) {
            array[i] = in.nextInt();
        }

        count = in.nextInt();
        int begInd, endInd;
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            begInd = in.nextInt();
            endInd = in.nextInt();
            int min = array[begInd - 1];
            for (int j = begInd - 1; j < endInd; j++) {
                if (array[j] < min)
                    min = array[j];
            }
            result[i] = min;
        }

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    /**
     * Задан массив a. Требуется каждый его элемент заменить на ближайший справа больший.
     * Результаты замен не влияют на другие, то есть считайте, что все замены производятся одновременно.
     * Если справа нет большего элемента, то замените элемент на число 0.
     */
    public static void task2026() {
        Scanner in = new Scanner(System.in);

        int count = in.nextInt();
        int[] array = new int[count];
        for (int i = 0; i < array.length; i++) {
            array[i] = in.nextInt();
        }

        for (int i = 0; i < array.length; i++) {
            boolean isFound = false;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[i]) {
                    array[i] = array[j];
                    isFound = true;
                    break;
                }
            }
            if (!isFound)
                array[i] = 0;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    /**
     * Дан набор из n слов, состоящих из маленьких латинских букв.
     * <p>
     * Будем называть слово странным, если в нем встречаются 3 или более гласные буквы подряд.
     * <p>
     * Ваша задача — удалить из данного набора все странные слова.
     * <p>
     * Гласными буквами в латинском алфавите считаются e,y,u,i,o,a.
     */
    public static void task2036() {
        Scanner in = new Scanner(System.in);

        int count = in.nextInt();
        StringJoiner result = new StringJoiner("\n");

        for (int i = 0; i < count; i++) {
            String str = in.next();
            int letterCount = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'e' || str.charAt(j) == 'y' || str.charAt(j) == 'u' || str.charAt(j) == 'i' || str.charAt(j) == 'o' || str.charAt(j) == 'a')
                    letterCount++;
                else
                    letterCount = 0;
                if (letterCount == 3)
                    break;

            }
            if (letterCount != 3)
                result.add(str);
        }
        System.out.println(result);
    }

    /**
     * Дан текст, состоящий только из маленьких латинских букв и запятых.
     * Последовательность подряд идущих букв, окруженную запятыми (началом, концом строки), назовем словом. Слово может быть пустым.
     * <p>
     * Ваша задача — удалить из текста все слова короче k символов.
     */
    public static void task2037() {
        Scanner in = new Scanner(System.in);

        String str = in.next();
        int minLength = in.nextInt();

        String[] words = str.split(",", -1);
        StringJoiner result = new StringJoiner(",");

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= minLength) {
                result.add(words[i]);
            }
        }

        System.out.println(result);
    }

    /**
     * Определим слово как последовательность латинских букв алфавита. Все остальные символы являются разделителями.
     * <p>
     * Дан текст, состоящий из символов с номерами от 32 до 127 (см. таблицу символов ASCII).
     * Ваша задача — найти количество букв в наидлинейшем слове из этого текста.
     */
    public static void task2038() {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();

        String[] words = str.split("[^a-zA-Z]");

        int maxLength = words[0].length();
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > maxLength)
                maxLength = words[i].length();
        }

        System.out.println(maxLength);
    }

    /**
     * Определим слово как последовательность латинских букв алфавита. Все остальные символы являются разделителями.
     * <p>
     * Дан текст, состоящий из символов с номерами от 32 до 127 (см. таблицу символов ASCII).
     * Ваша задача — подсчитать количество слов в этом тексте.
     */
    public static void task2039() {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();

        String[] words = str.split("[^a-zA-Z]");

        int result = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() != 0)
                result++;
        }

        System.out.println(result);
    }

    /**
     * Циклическим сдвигом на k строки p = (p1, p2,..., pn) называется строка pk = (pk+1, pk+2,..., pn, p1,..., pk).
     * <p>
     * Ваша задача — найти наименьший в лексикографическом порядке сдвиг данной строки.
     */
    public static void task2040() {
        Scanner in = new Scanner(System.in);

        String str = in.next();

        String min = str;
        for (int i = 0; i < str.length() - 1; i++) {
            str = str.charAt(str.length() - 1) + str.substring(0, str.length() - 1);
            if (str.compareTo(min) < 0)
                min = str;
        }

        System.out.println(min);
    }

    /**
     * Вспомогательная функция для задания 2041. Проверяет, является ли строка палиндромом.
     *
     * @param str строка, которую необходимо проверить
     * @return - true, если строка является палиндромом, false - в противном случае
     */
    public static boolean isPalindome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Строка называется палиндромом, если она читается справа налево и слева направо одинаково.
     * Например, "abacaba" — палиндром, а "abac" — нет.
     * <p>
     * Конкатенацией двух строк называется строка, представляющий собой сначала записанную первую строку, потом вторую.
     * Например, "ad" + "caba" = "adcaba".
     * <p>
     * Дана строка, состоящая только из строчных латинских букв.
     * Ваша задача проверить, является ли эта строка конкатенацией двух палиндромов.
     * Обратите внимание, что пустая строка также является палиндромом.
     */
    public static void task2041() {
        Scanner in = new Scanner(System.in);

        String str = in.next();

        String result = "NO";
        for (int i = 0; i < str.length(); i++) {
            if (isPalindome(str.substring(0, i)) && isPalindome(str.substring(i))) {
                result = "YES";
                break;
            }
        }

        System.out.println(result);
    }

    /**
     * Дан текст, состоящий из строчных латинских букв, и шаблон, состоящий из строчных латинских букв и знаков вопроса.
     * Знак вопроса может обозначить любую букву. Например, строки "abaca" и "??ac?" равны, а "aba" и "?c?" — нет.
     * <p>
     * Ваша задача — вывести все позиции вхождения шаблона в текст.
     */
    public static void task2042() {
        Scanner in = new Scanner(System.in);

        String str = in.next();
        String pattern = in.next();

        for (int i = 0; i < str.length() - pattern.length() + 1; i++) {
            boolean isMatched = true;
            for (int j = 0; j < pattern.length(); j++) {
                if (str.charAt(i + j) != pattern.charAt(j) && pattern.charAt(j) != '?') {
                    isMatched = false;
                    break;
                }

            }
            if (isMatched)
                System.out.print(i + 1 + " ");
        }
    }
}
