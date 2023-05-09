package lesson1;
/* ������� 1
 * �������� ���������, ������� �������� ������������ ������ <���> � �������.
 * ������� ��������� ������ � ������� � ������� ��������� "������, <���>!"*/

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
        System.out.printf("������, %s!%n", name);
    }


    /* ��� ������ �������� �����, �������� [1,1,0,1,1,1], ������� ������������ ���������� ������ ������ 1.*/

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

    /* ��� ������ nums = [3,2,2,3] � ����� val = 3.
     * ���� � ������� ���� �����, ������ ���������, ����� ��������� ��� �������� � ����� �������.
     * ����� �������, ������ ��������� (��� ���) ��������� ������� ������ ���� ������� �� ���������, � ��������� - ����� ���*/
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



    /* �� ����� "����� ���������� �� ���� �� Java" ����������� ����� � �������� �������.*/

    private static void ex5() {
        String str = "����� ���������� �� ���� �� Java";
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

    /*����������� ������� ���������� ����� � � ������� b. a � b �� z. ����� ���������� ����������� �������� � ��������.
     * ������ 1: a = 3, � = 2, �����: 9
     * ������ 2: a = 2, � = -2, �����: 0.25
     * ������ 3: a = 3, � = 0, �����: 1*/
    private static void ex6(int a, int b) {
        System.out.println(Math.pow(a, b));

    }

    /* �������� � ���� ��������� ������:
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
