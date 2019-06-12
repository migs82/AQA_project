//пройти по
//        массиву и поменять местами первый и последний, второй и предпоследний и т.д.

import java.util.Random;
import java.util.Scanner;

public class Task2_7 {
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
        reversMas(mas);
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

    public static void reversMas(int[] anyMas) {
        for (int i = anyMas.length-1, j = 0; i >=anyMas.length/2 ; i--,j++) {
            int temp = anyMas[j];
            anyMas[j] = anyMas[i];
            anyMas[i] = temp;
        }
    }
}
