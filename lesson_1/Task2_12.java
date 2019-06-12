//циклически сдвинуть все элементы вправо на 2 позиции
//        (1-й элемент станет 3-м, 2-й стент 4-м и т.д.)

import java.util.Random;
import java.util.Scanner;

public class Task2_12 {
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
        printMas(shiftMas(mas));
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

    public static int[] shiftMas(int[] anyMas) {
        int[] mas2 = new int[anyMas.length];
        for (int i = 0; i <= anyMas.length - 1; i++) {
            while (i < anyMas.length - 2) {
                mas2[i + 2] = anyMas[i];
                break;
            }
            if (i == anyMas.length - 2) {
                mas2[0] = anyMas[anyMas.length - 2];
                continue;
            }
            if (i == anyMas.length - 1) {
                mas2[1] = anyMas[anyMas.length - 1];
                continue;
            }
        }
        return mas2;
    }
}
