//пройти по массиву, вывести все элементы в прямом и в обратном порядке.

import java.util.Random;
import java.util.Scanner;

public class Task2_1 {
    public static void main(String[] args) {
        int[] mas = new int[getinput()];
        System.out.println("длина массива " + mas.length);
        for (int i = 0; i < mas.length; i++) {
            Random randNumber = new Random();
            int iNumber = randNumber.nextInt(99);
            mas [i] = iNumber;
        }
        printMas(mas);
        System.out.println();
        printRevers(mas);
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
        for (int i=0; i<masToPrint.length; i++){
            System.out.print(masToPrint[i]+" ");
        }
    }

    public static void printRevers (int[] masToPrint) {
        for (int i = masToPrint.length-1; i>=0; i--){
            System.out.print(masToPrint[i]+" ");
        }

    }
}
