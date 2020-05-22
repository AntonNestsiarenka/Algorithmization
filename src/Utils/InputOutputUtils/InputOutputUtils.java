package Utils.InputOutputUtils;

import java.util.Scanner;

public class InputOutputUtils {

    public static int inputNaturalNumber(String str) {
        // Функция для ввода натурального числа из консоли.
        System.out.print(str);
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        if (number > 0)
            return number;
        System.out.println("Число должно быть > 0.");
        return inputNaturalNumber(str);
    }

    public static int inputUInt(String str) {
        // Функция для ввода целочисленного положительного значения из консоли.
        System.out.print(str);
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        if (number >= 0)
            return number;
        System.out.println("Число должно быть положительным.");
        return inputUInt(str);
    }

    public static int inputInt(String str) {
        // Функция для ввода целочисленного значения из консоли.
        System.out.print(str);
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        return number;
    }

    public static double inputDouble(String str) {
        // Функция для ввода действительного значения из консоли.
        System.out.print(str);
        Scanner in = new Scanner(System.in);
        double number = in.nextDouble();
        return number;
    }

    public static double inputUDouble(String str) {
        // Функция для ввода действительного положительного значения из консоли.
        System.out.print(str);
        Scanner in = new Scanner(System.in);
        double number = in.nextDouble();
        if (number >= 0)
            return number;
        System.out.println("Число должно быть положительным.");
        return inputUDouble(str);
    }

}