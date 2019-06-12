//Используя for вывести каждое четное число от 2 до 20 включительно и больше 10

public class Task1_3 {
    public static void main(String[] args) {
        for (int i = 2; i<= 20; i = i + 2) {
           if (i>=10)
            System.out.print(i + " ");
        }
    }
}
