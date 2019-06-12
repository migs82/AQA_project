// найти и вывести номер нулевых элементов. если нулевых
//        элементов нет - вывести сообщение, что их нет

import java.util.Random;
import java.util.Scanner;

public class Task2_5 {
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
        nullElements(mas);
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

    public static void nullElements(int[] kakojtoMas) {
        int nl = 0;
        for (int i = 0; i < kakojtoMas.length; i++) {
            if (kakojtoMas[i] == 0) {
                System.out.print(i + " ");
                nl = nl + 1;
            }
        }
        if (nl == 0) {
            System.out.println("Нулевых элементов нет");
        }
    }
}