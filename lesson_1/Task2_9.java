//найти номер минимального-максимального элементов и
//вывести

import java.util.Random;
import java.util.Scanner;

public class Task2_9 {
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
        maxMinMas(mas);
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

    public static void maxMinMas(int[] anyMas) {
        int indexOfMax = 0;
        int indexOfMin = 0;
        for (int i = 1; i < anyMas.length; i++) {
            if (anyMas[i] > anyMas[indexOfMax]) {
                indexOfMax = i;
            } else if (anyMas[i] < anyMas[indexOfMin]) {
                indexOfMin = i;
            }
        }
        System.out.println("Максимальный элемент массива " + anyMas[indexOfMax] + " , " + "Минимальный элемент массива " + anyMas[indexOfMin]);
        System.out.println("Индекс максимального элемента массива " + indexOfMax + " , " + "Индекс минимального элемента массива " + indexOfMin);
    }
}