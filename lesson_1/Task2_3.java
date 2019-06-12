// каждый 3-й элемент умножить на 2 (2-мя способами)

import java.util.Random;
import java.util.Scanner;

public class Task2_3 {
    public static void main(String[] args) {
        int[] mas = new int[getinput()];
        System.out.println("длина массива " + mas.length);
        for (int i = 0; i < mas.length; i++) {
            Random randNumber = new Random();
            int iNumber = randNumber.nextInt(99);
            mas[i] = iNumber;
        }
        printMas(mas);
        System.out.println();
        System.out.println("Первый метод");
        firstMethod(mas);
        printMas(mas);
        System.out.println();
        System.out.println("второй метод");
        secondMethod(mas);
        printMas(mas);
    }

    public static int getinput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число от 5 до 10 включительно:");
        int a = sc.nextInt();
        sc.close();
        System.out.println("Вы ввели число " + a);
        return a;
    }

    public static void printMas(int[] masToPrint) {
        for (int i = 0; i < masToPrint.length; i++) {
            System.out.print(masToPrint[i] + " ");
        }
    }

    public static void firstMethod(int[] a) {
        for (int i = 2; i < a.length; i = i + 3) {
            a[i] = a[i] * 2;
        }
    }

    public static void secondMethod(int[] a) {
        int i = 2;
        while (i < a.length) {
            a[i] = a[i] * 2;
            i = i + 3;
        }
    }
}


