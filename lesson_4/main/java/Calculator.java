import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int num1, num2;
        num1 = getInt();
        char operation = getOperation();
        num2 = getInt();
        int result = calc(num1, num2, operation);
        System.out.println("Результат операции: " + num1 + operation + num2 + " = " + result);
    }

    public static int getInt() {
        System.out.println("Введите число:");
        int num;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();
            num = getInt();

        }
        return num;
    }

    public static char getOperation() {
        List<String> list = new ArrayList(Arrays.asList("+", "-", "*", "/", "^"));
        System.out.println("Введите операцию:");
        String preOperation;
        preOperation = String.valueOf(scanner.next().trim().charAt(0));
        if (!list.contains(preOperation)) {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            preOperation = String.valueOf(getOperation());
        }
        return preOperation.charAt(0);
    }


    public static int calc(int num1, int num2, char operation) {
        int result;
        switch (operation) {
            case '+':
                result = getSum(num1, num2);
                break;
            case '-':
                result = getMinus(num1, num2);
                break;
            case '*':
                result = getMultiple(num1, num2);
                break;
            case '/':
                result = getDivide(num1, num2);
                break;
            case '^':
                result = getPow(num1, num2);
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(num1, num2, getOperation());//рекурсия
        }
        return result;
    }


    public static int getSum(int num1, int num2) {
        return num1 + num2;
    }

    public static int getMinus(int num1, int num2) {
        return num1 - num2;
    }

    public static int getDivide(int num1, int num2) {
        return num1 / num2;
    }

    public static int getMultiple(int num1, int num2) {
        return num1 * num2;
    }

    public static int getPow(int num1, int num2) {
        return (int)(Math.pow(num1,num2));
    }
}