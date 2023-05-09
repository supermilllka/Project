package lesson1;
/* Задание 1
 * Написать программу, которая запросит пользователя ввести <Имя> в консоли.
 * Получит введенную строку и выведет в консоль сообщение "Привет, <Имя>!"*/

import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.Scanner;

public class MainClassFromLessonOne {
    public static void main(String[] args) {
        //ex1();
        //ex2();
        //ex3();
        //ex5();
        //ex6(3,2);
        ex8();
    }

    private static void ex1() {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("name: ");
        String name = iScanner.nextLine();
        System.out.printf("Привет, %s!%n", name);
    }


    /* Дан массив двоичных чисел, например [1,1,0,1,1,1], вывести максимальное количество подряд идущих 1.*/

    private static void ex2() {
        int[] arr = new int[]{1, 1, 0, 1, 1, 1};
        int count = 0;
        int maxValue = 0;
        for (int i : arr) {
            if (i == 1) {
                count++;
            } else {
                if (count > maxValue) {
                    maxValue = count;
                    count = 0;

                }
            }
        }
        if (count > maxValue) {
            maxValue = count;
        }

        System.out.println(maxValue);
    }

    /* Дан массив nums = [3,2,2,3] и число val = 3.
     * Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
     * Таким образом, первые нескольно (или все) элементов массива должны быть отличны от заданного, а остальные - равны ему*/
    private static void ex3() {
        int[] nums = new int[]{3, 2, 3, 2, 3};
        int val = 3;
        int temp = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            for (int j = 0; j < nums.length - 1; j++)
                if (nums[j] == val) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
        }

        for (int i : nums) {
            System.out.print(i + " ");
        }
    }



    /* Во фразе "Добро пожаловать на курс по Java" переставить слова в обратном порядке.*/

    private static void ex5() {
        String str = "Добро пожаловать на курс по Java";
        String[] words = str.split(" ");
        String temp = "";
        for (int i = 0; i < words.length / 2; i++) {
            temp = words[i];
            words[i] = words[words.length - i - 1];
            words[words.length - i - 1] = temp;
        }
        for (String j : words) {
            System.out.print(j + " ");
        }

    }

    /*Реализовать функцию возведения числа а в степень b. a и b из z. Сводя количество выполняемых действий к минимуму.
     * Пример 1: a = 3, и = 2, ответ: 9
     * Пример 2: a = 2, и = -2, ответ: 0.25
     * Пример 3: a = 3, и = 0, ответ: 1*/
    private static void ex6(int a, int b) {
        System.out.println(Math.pow(a, b));

    }

    /* Записать в файл следующие данные:
     * - Name Surname Age
     * Kate Smith 20
     * Paul Green 25
     * Mike Black 23
     * */
    private static void ex8() {
        try (FileWriter fw = new FileWriter("GB_java_s01.txt", Charset.forName("UTF-8"), false)) {
            fw.write("Name\tSurname\tAge\n");
            fw.append("Kate\tSmith\t20\n" +
                    "                Paul\tGreen\t25\n" +
                    "                Mike\tBlack\t23");
            fw.flush();
        } catch (Exception ex) {
            System.out.println("Some error: " + ex.getMessage());
        }

    }
}
