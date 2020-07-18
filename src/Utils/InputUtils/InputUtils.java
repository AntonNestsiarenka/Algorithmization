package Utils.InputUtils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtils {

    /* Методы ввода различных значений из консоли. */

    public static int inputNaturalNumber(String str, Scanner scanner) {
        // Метод для ввода натурального числа из консоли.
        System.out.print(str);
        int number;
        try {
            number = scanner.nextInt();
        }
        catch (InputMismatchException e)
        {
            scanner.nextLine();
            System.out.println("Введенные данные некорректны. На ввод ожидается целое число.");
            return inputNaturalNumber(str, scanner);
        }
        if (number > 0)
            return number;
        System.out.println("Число должно быть > 0.");
        return inputNaturalNumber(str, scanner);
    }

    public static int inputUInt(String str, Scanner scanner) {
        // Метод для ввода целочисленного положительного значения из консоли.
        System.out.print(str);
        int number;
        try {
            number = scanner.nextInt();
        }
        catch (InputMismatchException e)
        {
            scanner.nextLine();
            System.out.println("Введенные данные некорректны. На ввод ожидается целое число.");
            return inputUInt(str, scanner);
        }
        if (number >= 0)
            return number;
        System.out.println("Число должно быть положительным.");
        return inputUInt(str, scanner);
    }

    public static int inputInt(String str, Scanner scanner) {
        // Метод для ввода целочисленного значения из консоли.
        System.out.print(str);
        int number;
        try {
            number = scanner.nextInt();
        }
        catch (InputMismatchException e)
        {
            scanner.nextLine();
            System.out.println("Введенные данные некорректны. На ввод ожидается целое число.");
            return inputInt(str, scanner);
        }
        return number;
    }

    public static double inputDouble(String str, Scanner scanner) {
        // Метод для ввода действительного значения из консоли.
        System.out.print(str);
        double number;
        try {
            number = scanner.nextDouble();
        }
        catch (InputMismatchException e)
        {
            scanner.nextLine();
            System.out.println("Введенные данные некорректны. На ввод ожидается действительное число.");
            return inputDouble(str, scanner);
        }
        return number;
    }

    public static double inputUDouble(String str, Scanner scanner) {
        // Метод для ввода действительного положительного значения из консоли.
        System.out.print(str);
        double number;
        try {
            number = scanner.nextDouble();
        }
        catch (InputMismatchException e)
        {
            scanner.nextLine();
            System.out.println("Введенные данные некорректны. На ввод ожидается действительное число.");
            return inputUDouble(str, scanner);
        }
        if (number >= 0)
            return number;
        System.out.println("Число должно быть положительным.");
        return inputUDouble(str, scanner);
    }
}