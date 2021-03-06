//проверить, является ли массив возрастающей
//        последовательностью (каждое следующее число больше предыдущего)

import java.util.Random;
import java.util.Scanner;

public class Task2_10 {
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
        isItPosledovatelnost(mas);
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

    public static void isItPosledovatelnost(int[] anyMas) {
        int n = 0;
        for (int i = 1; i < anyMas.length; i++) {
            if (anyMas[i - 1] >= anyMas[i]) {
                System.out.println("Не является возрастающей последовательностью");
                break;
            } else {
                n = n + 1;
            }
            if (n == anyMas.length - 1)
                System.out.println("Является возрастающей последовательностью");
        }
    }
}