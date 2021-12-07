package com.HW3p1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] arrayLine = printLine();
        if (isValid(arrayLine)) {
            int num = convertNumber(arrayLine);
            int sum = sumNumber(num);
            String strNumber = numberToString(sum);
            output(arrayLine, strNumber);
        } else {
            System.out.println("Неправильный ввод. Введите имя и число через пробел");
        }
    }

    /** Ввод данных с командной строки */
    private static String[] printLine() {
        Scanner scr = new Scanner(System.in);
        System.out.println("Введите имя и число через пробел:");
        return scr.nextLine().split(" ");
    }

    /** Проверка, что строка нужной длины и содержит число */
    private static boolean isValid(String[] arr) {
        if (arr.length != 2) {
            return false;
        }
        if (arr[1].length() < 2 || arr[1].length() > 5) {
            return false;
        }
        return arr[1].matches("\\d+");
    }

    /** Перевод второй части строки в число */
    private static int convertNumber(String[] arrayLine) {
        return Integer.parseInt(arrayLine[1]);
    }

    /** Сумма чисел */
    private static int sumNumber(int num) {
        if (num == 0) {
            return 0;
        }
        int remainder = num % 10;
        return remainder + sumNumber(num / 10);
    }

    /** Перевод числа в текст */
    private static String numberToString(int num) {
        return switch (num) {
            case 10 -> "десять";
            case 9 -> "девять";
            case 8 -> "восемь";
            case 7 -> "семь";
            case 6 -> "шесть";
            case 5 -> "пять";
            case 4 -> "четыре";
            case 3 -> "три";
            case 2 -> "два";
            case 1 -> "один";
            default -> "больше десяти";
        };
    }

    /** Вывод результирующей строки на экран */
    private static void output( String[] arrayLine, String strNumber) {
        System.out.println("Здравствуй " + arrayLine[0] + "! Сумма цифр в числе = " + strNumber);
    }
}
