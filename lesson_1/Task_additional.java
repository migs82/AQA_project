//Реализовать алгоритмы быстро сортировки и сортировки Шелла для одномерного массива размером 10,000 элементов.

import java.util.Random;
import java.util.Scanner;

public class Task_additional {
    public static void main(String[] args) {
        int[] mas = new int[getinput()];
        System.out.println("длина массива " + mas.length);
        for (int i = 0; i < mas.length; i++) {
            int iNumber = (int) Math.round((Math.random() * 201) - 100);
            mas[i] = iNumber;
        }
        printMas(mas);
        System.out.println();
        printMas(sortShell(mas));
    }

    public static int getinput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите длину массива:");
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

    public static int[] sortShell(int[] anyMas) {
        int i, j, n, d, count;
        n = anyMas.length;
        d = n / 2;
        while (d > 0) {
            for (i = 0; i < n - d; i++) {
                j = i;
                while (j >= 0 && anyMas[j] > anyMas[j + d]) {
                    count = anyMas[j];
                    anyMas[j] = anyMas[j + d];
                    anyMas[j + d] = count;
                    j--;
                }
            }
            d = d / 2;
        }
        return anyMas;
    }
}
