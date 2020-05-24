package Utils.OtherUtils;

import Utils.ArraysUtils.ArrayUtils;
import Utils.Exceptions.MyException;

import java.math.BigInteger;

public class OtherUtils {

    public static int randInt(int lowLimit, int highLimit)
    {
        // Генерация случайного целого значения в диапазоне [lowLimit, highlimit].
        if (lowLimit > highLimit)
        {
            int temp = lowLimit;
            lowLimit = highLimit;
            highLimit = temp;
        }
        int randomNumber = lowLimit + (int)(Math.random() * (highLimit - lowLimit + 1));
        return randomNumber;
    }

    public static double uniform(double lowLimit, double highLimit)
    {
        // Генерация случайного действительного значения в диапазоне [lowLimit, highlimit).
        if (lowLimit > highLimit)
        {
            double temp = lowLimit;
            lowLimit = highLimit;
            highLimit = temp;
        }
        double randomNumber = lowLimit + Math.random() * (highLimit - lowLimit);
        return randomNumber;
    }

    public static boolean isNaturalNumber(int number)
    {
        // Является ли число натуральным.
        return number >= 1;
    }

    public static boolean isSimpleNumber(int number)
    {
        // Функция определяет простое это число или нет.
        if (isNaturalNumber(number)) {
            double root = Math.sqrt(number);
            for (int i = 2; i <= root; i++) {
                if (number % i == 0)
                    return false;
            }
            return true;
        }
        return false;
    }

    public static double max(double a, double b)
    {
        // Максимальное из двух чисел.
        if (a > b)
        {
            return a;
        }
        return b;
    }

    public static double min(double a, double b)
    {
        // Минимальное из двух чисел.
        if (a < b)
        {
            return a;
        }
        return b;
    }

    public static int min(int a, int b)
    {
        // Минимальное из двух чисел.
        if (a < b)
        {
            return a;
        }
        return b;
    }

    public static int max(int a, int b)
    {
        // Максимальное из двух чисел.
        if (a > b)
        {
            return a;
        }
        return b;
    }

    public static int greatestCommonDivisor(int a, int b)
    {
        // Наибольший общий делитель двух целых натуральных чисел.
        a = Math.abs(a);
        b = Math.abs(b);
        int min = min(a, b);
        if (a % min == 0 && b % min == 0)
        {
            return min;
        }
        int limit = min / 2;
        int gcd = 1;
        for (int i = 2; i <= limit; i++)
        {
            if (a % i == 0 && b % i == 0)
            {
                gcd = i;
            }
        }
        return gcd;
    }

    public static int greatestCommonDivisor(int...numbers)
    {
        // Наибольший общий делитель двух и более целых натуральных чисел.
        int minNumber = Integer.MAX_VALUE;
        int maxNumber = Integer.MIN_VALUE;
        for (int numb : numbers)
        {
            if (numb > maxNumber)
            {
                maxNumber = numb;
            }
            if (numb < minNumber)
            {
                minNumber = numb;
            }
        }
        int gcd = greatestCommonDivisor(minNumber, maxNumber);
        boolean isGcdByAll = true;
        while (gcd > 1)
        {
            for (int element : numbers)
            {
                if (element % gcd != 0)
                {
                    isGcdByAll = false;
                    break;
                }
            }
            if (isGcdByAll)
            {
                return gcd;
            }
            isGcdByAll = true;
            gcd--;
        }
        return gcd;
    }

    public static int leastCommonMultiple(int a, int b)
    {
        // Наименьшее общее кратное двух целых натуральных чисел.
        return (a * b) / greatestCommonDivisor(a, b);
    }

    public static double equilateralTriangleArea(double sideLength)
    {
        // Площадь равностороннего треугольника.
        double h = Math.sqrt(Math.pow(sideLength, 2) - Math.pow(sideLength * 0.5, 2));
        double area = 0.5 * sideLength * h;
        return area;
    }

    public static double areaOfRegularHexagon(double sideLength)
    {
        // Площадь правильного шестиугольника.
        double areaOfOneTriangle = equilateralTriangleArea(sideLength);
        double areaOfHexagon = 6 * areaOfOneTriangle;
        return areaOfHexagon;
    }

    public static double squareOfDistanceBetweenPoints(double[] point1, double[] point2)
    {
        // Квадрат расстояния между двумя точками.
        return Math.pow(point2[0] - point1[0], 2) + Math.pow(point2[1] - point1[1], 2);
    }

    public static double[][] maxDistanceBetweenPoints(double[][] points)
    {
        /* Возвращает двухмерный массив 2x2 координат точек наиболее отдаленных друг от друга, где каждой строке
           соответствует одномерный массив координат точки, каждому столбцу координата точки по x и y. */
        double maxDistance = Double.MIN_VALUE;
        double pairOfPoints[][] = new double[2][2];
        for (int i = 0; i < points.length - 1; i++)
        {
            for (int j = i + 1; j < points.length; j++)
            {
                double squareOfDistance = squareOfDistanceBetweenPoints(points[i], points[j]);
                if (squareOfDistance > maxDistance)
                {
                    maxDistance = squareOfDistance;
                    pairOfPoints[0] = points[i];
                    pairOfPoints[1] = points[j];
                }
            }
        }
        return pairOfPoints;
    }

    public static boolean isMutuallyPrimeNumbers(int...numbers)
    {
        // Определяет являются ли числа взаимно простыми.
        int gcdCommon = greatestCommonDivisor(numbers);
        if (gcdCommon == 1)
        {
            return true;
        }
        return false;
    }

    public static BigInteger fact(int number)
    {
        // Факториал числа. Возвращает экземпляр класса BigInteger - факториал числа.
        if (number > 0)
        {
            return fact(number - 1).multiply(BigInteger.valueOf(number));
        }
        return BigInteger.valueOf(1);
    }

    public static BigInteger sumOfFactorialsOddNumbersInRange(int limitL, int limitH)
    {
        /* Вычисляет сумму факториалов нечетных чисел в промежутке от [limitL, limitH). Возвращает экземпляр класса
           BigInteger - сумма факториалов нечетных натуральных чисел. */
        if (limitL > limitH)
        {
            int temp = limitL;
            limitL = limitH;
            limitH = temp;
        }
        BigInteger sumOfFactorials = BigInteger.ZERO;
        for (int i = limitL + (limitL + 1) % 2; i < limitH; i += 2)
        {
            sumOfFactorials = sumOfFactorials.add(fact(i));
        }
        return sumOfFactorials;
    }

    public static double areaOfARightTriangle(double lengthA, double lengthB)
    {
        // Вычисляет площадь прямоугольного треугольника.
        return lengthA * lengthB * 0.5;
    }

    public static double triangleAreaOnThreeSides(double lengthA, double lengthB, double lengthC)
    {
        // Вычисляет площадь треугольника по трем сторонам.
        double halfPerimeter = 0.5 * (lengthA + lengthB + lengthC);
        double area = Math.sqrt(halfPerimeter * (halfPerimeter - lengthA) * (halfPerimeter - lengthB) * (halfPerimeter - lengthC));
        return area;
    }

    public static double areaOfQuadrangle(double lengthX, double lengthY, double lengthZ, double lengthT)
    {
        // Вычисляет площадь четырехугольника с прямым углом между сторонами lengthX и lengthY.
        double area1 = areaOfARightTriangle(lengthX, lengthY);
        double diagonal = Math.sqrt(lengthX * lengthX + lengthY * lengthY);
        double area2 = triangleAreaOnThreeSides(lengthZ, lengthT, diagonal);
        return area1 + area2;
    }

    public static int countOfDigitsInNaturalNumber(int number)
    {
        // Возвращает количество значимых цифр в натуральном числе.
        int count = 0;
        while (number != 0)
        {
            number /= 10;
            count++;
        }
        return count;
    }

    public static int lastDigitOfNaturalNumber(int number)
    {
        // Возвращает последнюю цифру натурального числа.
        return number % 10;
    }

    public static int naturalNumberWithMaxDigits(int number1, int number2)
    {
        /* Возвращает натуральное число с наибольшим количеством цифр. Если количество цифр равно, то возвращает
           большее число. */
        int count1 = countOfDigitsInNaturalNumber(number1);
        int count2 = countOfDigitsInNaturalNumber(number2);
        if (count1 > count2)
        {
            return number1;
        }
        else if (count1 == count2)
        {
            return max(number1, number2);
        }
        else
        {
            return number2;
        }
    }

    public static int sumOfDigitsNaturalNumber(int number)
    {
        // Сумма цифр натурального числа.
        int sum = 0;
        while (number != 0)
        {
            sum += lastDigitOfNaturalNumber(number);
            number /= 10;
        }
        return sum;
    }

    public static void printTwinPrimesInRange(int n)
    {
        // Выводит все простые числа-близнецы в диапазоне [limitL, limitH].
        final int limitL = n;
        final int limitH = 2 * n;
        int lastSimpleNumber = Integer.MAX_VALUE;
        for (int i = limitL + (limitL + 1) % 2; i <= limitH; i += 2)
        {
            if (isSimpleNumber(i))
            {
                if (i - lastSimpleNumber == 2) {
                    System.out.printf("%d\t%d\n", lastSimpleNumber, i);
                }
                lastSimpleNumber = i;
            }
        }
    }

    public static boolean isArmstrongNumber(int number)
    {
        // Определяет является ли натуральное число числом Армстронга.
        int countOfDigits = countOfDigitsInNaturalNumber(number);
        int sumOfDigitsInPower = 0;
        int i = 0;
        int copyNumber = number;
        while (i < countOfDigits)
        {
            sumOfDigitsInPower += (int)Math.pow(lastDigitOfNaturalNumber(copyNumber), countOfDigits);
            copyNumber /= 10;
            i++;
        }
        return sumOfDigitsInPower == number;
    }

    public static int[] searchAllArmstrongNumbersInRange(int k)
    {
        // Возвращает массив чисел Армстронга от limitL до k.
        final int limitL = 1;
        int array[] = new int[k - 1];
        int j = 0;
        for (int i = limitL; i < k; i++)
        {
            if (isArmstrongNumber(i))
            {
                array[j++] = i;
            }
        }
        array = ArrayUtils.resize1DArrayToDown(array, j);
        return array;
    }

    public static boolean isNaturalNumberWithDigitsAscending(int number)
    {
        // Определяет образуют ли цифры натурального числа строго возрастающую последовательность.
        int lastNumber = Integer.MAX_VALUE;
        while (number != 0)
        {
            int temp = lastDigitOfNaturalNumber(number);
            if (temp >= lastNumber)
            {
                return false;
            }
            number /= 10;
            lastNumber = temp;
        }
        return true;
    }

    public static boolean isNaturalNumberWithOddDigits(int number)
    {
        // Определяет являются ли все цифры натурального числа нечетными значениями.
        while (number != 0)
        {
            if (lastDigitOfNaturalNumber(number) % 2 == 0)
            {
                return false;
            }
            number /= 10;
        }
        return true;
    }

    public static void printAllNaturalNumbersWithDigitsAscending(int n) throws MyException {
        /* Выводит в консоль все натуральные n-значные числа, цифры которых образуют строго возрастающую
           последовательность. При длинне числа более 9 знаков бросает исключение OverflowIntException. */
        if (n > 9)
        {
            throw new MyException("Произошло переполнение типа Int");
        }
        int limit = (int)Math.pow(10, n);
        for (int i = (int)Math.pow(10, n - 1); i < limit; i++)
        {
            if(isNaturalNumberWithDigitsAscending(i))
            {
                System.out.print(i + "\t");
            }
        }
        System.out.println();
    }

    public static int countEvenDigitsInNaturalNumber(BigInteger number)
    {
        // Возвращает количество четных чисел в натуральном числе.
        int count = 0;
        while ((number.compareTo(BigInteger.ZERO)) == 1)
        {
            if ((number.mod(BigInteger.TEN)).mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO))
            {
                count++;
            }
            number = number.divide(BigInteger.TEN);
        }
        return count;
    }

    public static BigInteger sumOfNaturalNumbersWithOddDigits(int n) throws MyException {
        /* Возвращает сумму (экземпляр BigInteger) всех n-значных чисел, все цифры которых являются нечетными. При
           длинне числа более 9 знаков бросает исключение OverflowIntException. */
        if (n > 9)
        {
            throw new MyException("Произошло переполнение типа Int");
        }
        BigInteger sumOfOddDigits = BigInteger.ZERO;
        int limit = (int)Math.pow(10, n);
        for (int i = (int)Math.pow(10, n - 1) + 1 - ((int)Math.pow(10, n - 1)) % 2; i < limit; i += 2)
        {
            if(isNaturalNumberWithOddDigits(i))
            {
                sumOfOddDigits = sumOfOddDigits.add(BigInteger.valueOf(i));
            }
        }
        return sumOfOddDigits;
    }

    public static int countOfSubstraction(int number)
    {
        /* Определяет количество вычитаний из заданного натурального числа суммы цифр, пока натуральное число не станет
           нулем. */
        int count = 0;
        while (number != 0) {
            number -= sumOfDigitsNaturalNumber(number);
            count++;
        }
        return count;
    }

}