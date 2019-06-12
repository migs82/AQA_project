//найти произведения всех элементов массива, вывести

import java.util.Random;
import java.util.Scanner;

public class Task2_2 {
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
        proizvEltovMas(mas);
    }

    public static void proizvEltovMas(int[] kakojtoMas) {
        long pr = 1;
        for (int i = 0; i < kakojtoMas.length; i++) {
            pr = pr * kakojtoMas[i];
        }
        System.out.println("Произведение элементов массива " + pr);
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


}
