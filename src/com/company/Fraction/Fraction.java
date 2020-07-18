package com.company.Fraction;
import Utils.OtherUtils.OtherUtils;
import com.company.Fraction.Exceptions.FractionDenominatorInvalidValue;

import static Utils.OtherUtils.OtherUtils.randInt;

public final class Fraction implements Comparable<Fraction>{

    /* Класс дробь описывает объект - дробь в виде двух целочисленных аргументов numerator - числитель и denominator -
       знаменатель. Поддерживаются отрицательные значения числителя и знаменателя. В классе реализованы методы
       сортировки как для дробей приведеных к общему знаменателю так и для неприведеных дробей, а так же другие
       вспомогательные методы. */

    private int numerator;
    private int denominator;

    private Fraction(int numerator, int denominator)
    {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public static Fraction createInstance(int numerator, int denominator) throws FractionDenominatorInvalidValue {
        // Метод для создания объекта. При некорректных данных может выбрасывать исключение FractionDenominatorInvalidValue.
        if (denominator != 0)
            return new Fraction(numerator, denominator);
        throw new FractionDenominatorInvalidValue("Invalid value of denominator");
    }

    public static Fraction generateRandomFraction(int limitA, int limitB) throws FractionDenominatorInvalidValue {
        /* Генерирует случайный числитель и знаменатель для дроби в пределах заданного [limitA, limitB]. Если в
        промежутке присутствует ноль, то игнорирует его и рандомит по другим ненулевым значениям. Если же промежуток
        состоит из одних нулей выбрасывает исключение FractionDenominatorInvalidValue. Возвращает объект - дробь
        (числитель и знаменатель). */
        if (limitA == 0 && limitB == 0)
            throw new FractionDenominatorInvalidValue("Invalid value of denominator");
        if (limitA == 0) {
            if (limitB > 0)
                limitA++;
            else
                limitA--;
        }
        else if (limitB == 0) {
            if (limitA > 0)
                limitB++;
            else
                limitB--;
        }
        else {
            if (limitA < 0 && limitB > 0)
            {
                int numerator = (randInt(0, 1) == 0) ? randInt(limitA, -1) : randInt(1, limitB);
                int denominator = (randInt(0, 1) == 0) ? randInt(limitA, -1) : randInt(1, limitB);
                return createInstance(numerator, denominator);
            }
            else if (limitA > 0 && limitB < 0)
            {
                int numerator = (randInt(0, 1) == 0) ? randInt(1, limitA) : randInt(-1, limitB);
                int denominator = (randInt(0, 1) == 0) ? randInt(1, limitA) : randInt(-1, limitB);
                return createInstance(numerator, denominator);
            }
        }
        int numerator = randInt(limitA, limitB);
        int denominator = randInt(limitA, limitB);
        return createInstance(numerator, denominator);
    }

    public static Fraction[] createAndFillFractions1DArrayRandom(int size, int limitA, int limitB) throws FractionDenominatorInvalidValue {
        /* Создает массив объектов - дробей. Размер массива задается параметром size. Дроби генерируются случайным
        образом. Диапазон значений числителя и знаменателя задается limitA и limitB. Если диапазон некорректен,
        выбрасывает исключение FractionDenominatorInvalidValue. */
        Fraction array[] = new Fraction[size];
        for (int i = 0; i < size; i++)
        {
            array[i] = generateRandomFraction(limitA, limitB);
        }
        return array;
    }

    public static int lowestCommonDenominator(int denominator1, int denominator2)
    {
        // Наименьшее общее кратное двух чисел (наименьший общий знаменатель).
        int maxDenominator = OtherUtils.max(Math.abs(denominator1), Math.abs(denominator2));
        int increment = maxDenominator;
        while (maxDenominator % denominator1 != 0 || maxDenominator % denominator2 != 0)
        {
            maxDenominator += increment;
        }
        return maxDenominator;
    }

    public static Fraction[] reductionOfFractionsToACommonDenominator(Fraction[] array)
    {
        /* Приведение одномерного массива дробей к общему знаменателю. Создает и возвращает новый одномерный массив
           приведенных дробей. Если массив пустой, то возвращает новый пустой массив. */
        if (array.length == 0)
            return new Fraction[0];
        int commonDenominator = array[0].denominator;
        for (Fraction fraction : array)
        {
            commonDenominator = lowestCommonDenominator(commonDenominator, fraction.denominator);
        }
        Fraction reducedFractions[] = new Fraction[array.length];
        for (int i = 0; i < reducedFractions.length; i++)
        {
            int currentNumerator = (commonDenominator / array[i].denominator) * array[i].numerator;
            reducedFractions[i] = new Fraction(currentNumerator, commonDenominator);
        }
        return reducedFractions;
    }

    public static void sortFractionsAscending(Fraction[] array)
    {
        /* Сортировка по возрастанию одномерного массива дробей, записанных в первоначальной форме. Форма записи дробей
           после сортировки не будет изменена. */
        Fraction reducedFractions[] = reductionOfFractionsToACommonDenominator(array);
        sortReducedFractionsAscending1DArray(reducedFractions);
        for (int i = 0; i < reducedFractions.length; i++)
        {
            for (int j = 0; j < array.length; j++) {
                if (reducedFractions[i].toDouble() == array[j].toDouble())
                {
                    Fraction temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void sortReducedFractionsAscending1DArray(Fraction[] array)
    {
        // Сортировка по возрастанию одномерного массива дробей !приведенных к общему знаменателю!.
        for (int i = 1; i < array.length; i++)
        {
            int temp = array[i].numerator;
            int j = i - 1;
            int k = i;
            while (j >= 0 && array[j].numerator > temp)
            {
                array[k--].numerator = array[j--].numerator;
            }
            array[k].numerator = temp;
        }
    }

    public static void printFractions1DArray(Fraction[] array)
    {
        // Вывод массива дробей в консоль.
        for (Fraction fraction : array)
        {
            System.out.printf("%4d/%d\t", fraction.numerator, fraction.denominator);
        }
        System.out.println();
    }

    public double toDouble()
    {
        // Приведение дроби к десятичной форме записи.
        return (double)numerator / denominator;
    }

    public void reduceFraction()
    {
        // Сокращение дроби.
        int gcd = OtherUtils.greatestCommonDivisor(this.numerator, this.denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }

    @Override
    public int compareTo(Fraction o) {
        return Double.compare(toDouble(), o.toDouble());
    }
}