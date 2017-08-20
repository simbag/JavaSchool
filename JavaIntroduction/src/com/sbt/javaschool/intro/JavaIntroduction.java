package com.sbt.javaschool.intro;

import java.util.Scanner;

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

    public static void task2001() {
        Scanner in = new Scanner(System.in);

        int sum = in.nextInt();
        sum += in.nextInt();

        System.out.println(sum);

    }

    public static void task2002() {
        Scanner in = new Scanner(System.in);

        int count = in.nextInt();
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += in.nextInt();
        }

        System.out.println(sum);
    }

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

    public static void task2004() {
        Scanner in = new Scanner(System.in);

        int year = in.nextInt();

        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
            System.out.println(1);
        else
            System.out.println(0);
    }

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

    public static int findMax(int[] array) {
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }
        return max;
    }

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

    public static void task2036() {
        Scanner in = new Scanner(System.in);

        int count = in.nextInt();
        String result = "";

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
                result += str + '\n';
        }
        System.out.println(result);
    }

    public static void task2037() {
        Scanner in = new Scanner(System.in);

        String str = in.next();
        int minLength = in.nextInt();
        String cur = "";
        String result = "";

        str += ',';

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ',') {
                if (cur.length() >= minLength) {
                    if (result == "")
                        result += cur;
                    else
                        result += "," + cur;
                }
                cur = "";
            } else
                cur += str.charAt(i);
        }

        System.out.println(result);
    }

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

    public static boolean isPalindome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void task2041() {
        Scanner in = new Scanner(System.in);

        String str = in.next();

        String result = "NO";
        for (int i = 0; i < str.length(); i++) {
            if (isPalindome(str.substring(0, i + 1)) && isPalindome(str.substring(i + 1, str.length()))) {
                result = "YES";
                break;
            }
        }

        System.out.println(result);
    }

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
