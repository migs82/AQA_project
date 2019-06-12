//заменить все элементы массива на полусумму соседних
//        элементов

import java.util.Random;
import java.util.Scanner;

public class Task2_11 {
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
        printMas(poluSum(mas));
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

    public static int[] poluSum(int[] anyMas) {
        int[] mas2 = new int[anyMas.length];
        mas2[0] = anyMas[1] / 2;
        mas2[anyMas.length - 1] = anyMas[anyMas.length - 2] / 2;
        int n = 0;
        for (int i = 1; i < anyMas.length - 1; i++) {
            mas2[i] = (anyMas[i - 1] + anyMas[i + 1]) / 2;
        }
        return mas2;
    }
}
