package lesson_2;

//Создать класс Methods со следующими методами:
//        - Найти минимальное число из 2 чисел, вернуть минимальное
//        - Проверить четное число или нечетное, вернуть boolean результат
//        - Возвести число в квадрат, вернуть результат возведения
//        - Возвести число в куб, вернуть результат возведения

public class Methods {

    public static void main(String[] args) {
        Methods ex = new Methods();
        double a = 4;
        double b = 7;
        System.out.println(ex.minValue(a, b));
        System.out.println(ex.isEven(a));
        System.out.println(ex.squareNum(a));
        System.out.println(ex.cubeNum(a));
    }

    public double minValue(double a, double b) {
        if (a < b && a != b) {
            return a;
        } else if (b < a && b != a) {
            return b;
        } else System.out.println("Числа равны");
        return a;
    }

    public boolean isEven(double a) {
        return a % 2 == 0;
    }

    public double squareNum(double a) {
        a = a * a;
        return a;
    }

    public double cubeNum(double a) {
        a = a * a * a;
        return a;
    }

}
