//Реализовать алгоритмы быстро сортировки и сортировки Шелла для одномерного массива размером 10,000 элементов.

import java.util.Random;
import java.util.Scanner;

public class Task_add2 {
    public static void main(String[] args) {
        int[] mas = new int[getinput()];
        System.out.println("длина массива " + mas.length);
        for (int i = 0; i < mas.length; i++) {
            int iNumber = (int) Math.round((Math.random() * 201) - 100);
            mas[i] = iNumber;
        }
        printMas(mas);
        System.out.println();
        int low = 0;
        int high = mas.length - 1;
        quickSort(mas, low, high);
        System.out.println("Отсортированный массив");
        printMas(mas);
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

    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;//завершить выполнение если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }
}