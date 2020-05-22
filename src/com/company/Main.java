package com.company;

import Utils.ArraysUtils.ArrayUtils;
import Utils.Exceptions.OverflowIntException;
import Utils.InputOutputUtils.InputOutputUtils;
import Utils.OtherUtils.OtherUtils;

import java.math.BigInteger;

public class Main {

    /**********************************************************************************************************/
    /******************************************* Одномерные массивы *******************************************/
    /**********************************************************************************************************/

    public static void task1()
    {
        // В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К.
        int sizeArray = InputOutputUtils.inputUInt("Введите размерность одномерного массива: ");
        int array[] = ArrayUtils.createAndFill1DArrayRandom(sizeArray, 1, 50);
        int k = InputOutputUtils.inputInt("Введите целое значение K для проверки на кратность: ");
        int sum = ArrayUtils.sumOfMultipleElements1DArray(array, k);
        System.out.printf("Сумма элементов одномерного массива кратных %d = %d\n", k, sum);
    }

    public static void task2()
    {
        /* Дана последовательность действительных чисел а1 ,а2 ,..., ап. Заменить все ее члены, большие данного Z, этим
           числом. Подсчитать количество замен. */
        int sizeArray = InputOutputUtils.inputUInt("Введите размерность одномерного массива: ");
        double array[] = ArrayUtils.createAndFill1DArrayRandom(sizeArray, -10.0, 10.0);
        double z = InputOutputUtils.inputDouble("Введите действительное значение Z: ");
        int count = ArrayUtils.countNumberOfReplacements1DArray(array, z);
        System.out.printf("Количество замен элементов одномерного массива числом %f = %d\n", z, count);
    }

    public static void task3()
    {
        /* Дан массив действительных чисел, размерность которого N. Подсчитать, сколько в нем отрицательных,
           положительных и нулевых элементов. */
        int sizeArray = InputOutputUtils.inputUInt("Введите размерность одномерного массива: ");
        double array[] = ArrayUtils.createAndFill1DArrayRandom(sizeArray, -10.0, 10.0);
        int arrayResult[] = ArrayUtils.countPositiveNegativeZerosElements1DArray(array);
        System.out.printf("Количество положительных элементов = %d\nКоличество отрицательных элементов = %d\nКоличество нулевых элементов = %d\n", arrayResult[0], arrayResult[1], arrayResult[2]);
    }

    public static void task4()
    {
        // Даны действительные числа а1 ,а2 ,..., аn . Поменять местами наибольший и наименьший элементы.
        int sizeArray = InputOutputUtils.inputUInt("Введите размерность одномерного массива: ");
        double array[] = ArrayUtils.createAndFill1DArrayRandom(sizeArray, -10.0, 10.0);
        System.out.println("Текущий массив.");
        ArrayUtils.print1DArray(array);
        ArrayUtils.swapMinMaxElements1DArray(array);
        System.out.println("Массив после того как поменяли местами минимальный и максимальный элементы.");
        ArrayUtils.print1DArray(array);
    }

    public static void task5()
    {
        // Даны целые числа а1 ,а2 ,..., аn . Вывести на печать только те числа, для которых аi > i.
        int sizeArray = InputOutputUtils.inputUInt("Введите размерность одномерного массива: ");
        int array[] = ArrayUtils.createAndFill1DArrayRandom(sizeArray, -20, 20);
        System.out.println("Текущий массив.");
        ArrayUtils.print1DArray(array);
        System.out.println("Значения элементов массива которые больше своего индекса.");
        ArrayUtils.printCustom1DArray(array);
    }

    public static void task6()
    {
        /* Задана последовательность N вещественных чисел. Вычислить сумму чисел, порядковые номера которых
           являются простыми числами. */
        int sizeArray = InputOutputUtils.inputUInt("Введите размерность одномерного массива: ");
        double array[] = ArrayUtils.createAndFill1DArrayRandom(sizeArray, 0.0, 10.0);
        double sum = ArrayUtils.sumOfElements1DArrayWithSimpleIndexes(array);
        System.out.printf("Сумма элементов одномерного массива, номера которых являются простыми числами =  %f\n", sum);
    }

    public static void task7()
    {
        // Даны действительные числа a1 ,a2...an. Найти max(a1 + an, a2 + an-1...an + a1).
        int sizeArray = InputOutputUtils.inputUInt("Введите размерность одномерного массива: ");
        double array[] = ArrayUtils.createAndFill1DArrayRandom(sizeArray, 0.0, 10.0);
        ArrayUtils.print1DArray(array);
        double maxSum = ArrayUtils.maxSumOfOppositeElements(array);
        System.out.printf("максимальная сумма противоположных элементов одномерного массива = %f\n", maxSum);
    }

    public static void task8()
    {
        /* Дана последовательность целых чисел a1, a2...an. Образовать новую последовательность, выбросив из
           исходной те члены, которые равны min(a1, a2...an). */
        int sizeArray = InputOutputUtils.inputUInt("Введите размерность одномерного массива: ");
        int array[] = ArrayUtils.createAndFill1DArrayRandom(sizeArray, -10, 10);
        System.out.println("Текущий массив.");
        ArrayUtils.print1DArray(array);
        int newArray[] = ArrayUtils.createAndFillNew1DArrayBasedOnTheOld1DArray(array);
        System.out.println("Новый массив.");
        ArrayUtils.print1DArray(newArray);
    }

    public static void task9()
    {
        /* В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число. Если таких
        чисел несколько, то определить наименьшее из них. */
        int sizeArray = InputOutputUtils.inputUInt("Введите размерность одномерного массива: ");
        int array[] = ArrayUtils.createAndFill1DArrayRandom(sizeArray, -10, 10);
        System.out.println("Текущий массив.");
        ArrayUtils.print1DArray(array);
        int newA = ArrayUtils.mostFrequentNumber(array);
        System.out.print("Наиболее часто встречающееся число в массиве: " + newA);
    }

    public static void task10()
    {
        /* Дан целочисленный массив с количеством элементов п. Сжать массив, выбросив из него каждый второй элемент
           (освободившиеся элементы заполнить нулями). Примечание. Дополнительный массив не использовать. */
        int sizeArray = InputOutputUtils.inputUInt("Введите размерность одномерного массива: ");
        int array[] = ArrayUtils.createAndFill1DArrayRandom(sizeArray, -10, 10);
        System.out.println("Текущий массив.");
        ArrayUtils.print1DArray(array);
        ArrayUtils.compress1DArray(array);
        System.out.println("Массив после сжатия.");
        ArrayUtils.print1DArray(array);
    }

    /**********************************************************************************************************/
    /******************************************* Массивы массивов *********************************************/
    /**********************************************************************************************************/

    public static void task11()
    {
        // Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего.
        int sizeArray = InputOutputUtils.inputUInt("Введите размерность двухмерного квадратного массива: ");
        int array[][] = ArrayUtils.createAndFill2DArrayRandom(sizeArray, sizeArray, -10, 10);
        System.out.println("Текущий массив.");
        ArrayUtils.print2DArray(array);
        System.out.println("Элементы нечетных столбцов двухмерного массива, где первый элемент больше последнего.");
        ArrayUtils.printOddColumnsWhereFirstLargerThanLast(array);
    }

    public static void task12()
    {
        // Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.
        int sizeArray = InputOutputUtils.inputUInt("Введите размерность двухмерного квадратного массива: ");
        int array[][] = ArrayUtils.createAndFill2DArrayRandom(sizeArray, sizeArray, -10, 10);
        System.out.println("Текущий массив.");
        ArrayUtils.print2DArray(array);
        System.out.println("Элементы главной диагонали.");
        ArrayUtils.printDiagonal2DArray(array);
    }

    public static void task13()
    {
        // Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
        int sizeArrayA = InputOutputUtils.inputUInt("Введите размерность A по строкам двухмерного массива: ");
        int sizeArrayB = InputOutputUtils.inputUInt("Введите размерность B по столбцам двухмерного массива: ");
        int array[][] = ArrayUtils.createAndFill2DArrayRandom(sizeArrayA, sizeArrayB, -10, 10);
        int row = InputOutputUtils.inputUInt("Введите номер строки которую необходимо вывести: ");
        int column = InputOutputUtils.inputUInt("Введите номер столбца который необходимо вывести: ");
        System.out.println("Текущий массив.");
        ArrayUtils.print2DArray(array);
        System.out.println("Элементы двухмерного массива заданной строки.");
        ArrayUtils.printAllElementsFixedRow2DArray(array, row);
        System.out.println("Элементы двухмерного массива заданного столбца.");
        ArrayUtils.printAllElementsFixedColumn2DArray(array, column);
    }

    public static void task14()
    {
        /* Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
           1    2   3   n
           n   n-1 n-2  1
           1    2   3   n
           n   n-1 n-2  1
           n   n-1 n-2  1
         */
        int sizeArray = InputOutputUtils.inputUInt("Введите размерность двухмерного квадратного массива: ");
        int array[][] = ArrayUtils.createAndFill2DArrayCustom1(sizeArray);
        System.out.println("Массив после заполнения данными.");
        ArrayUtils.print2DArray(array);
    }

    public static void task15()
    {
        /* Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
           1    1   1   1   1   1
           2    2   2   2   2   0
           3    3   3   3   0   0
          n-1  n-1  0   0   0   0
           n    0   0   0   0   0
         */
        int sizeArray = InputOutputUtils.inputUInt("Введите размерность двухмерного квадратного массива: ");
        int array[][] = ArrayUtils.createAndFill2DArrayCustom2(sizeArray);
        System.out.println("Массив после заполнения данными.");
        ArrayUtils.print2DArray(array);
    }

    public static void task16()
    {
        /* Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
           1    1   1   1   1   1
           0    1   1   1   1   0
           0    0   1   1   0   0
           0    1   1   1   1   0
           1    1   1   1   1   1
         */
        int sizeArray = InputOutputUtils.inputUInt("Введите размерность двухмерного квадратного массива: ");
        int array[][] = ArrayUtils.createAndFill2DArrayCustom3(sizeArray);
        System.out.println("Массив после заполнения данными.");
        ArrayUtils.print2DArray(array);
    }

    public static void task17()
    {
        /* Сформировать квадратную матрицу порядка N по правилу:
           A[i,j] = sin((i*i - j*j) / n)
           и подсчитать количество положительных элементов в ней.
         */
        int sizeArray = InputOutputUtils.inputUInt("Введите размерность двухмерного квадратного массива: ");
        double array[][] = new double[sizeArray][sizeArray];
        int count = ArrayUtils.fill2DArrayAndCountingPositiveElements(array);
        System.out.println("Массив после заполнения данными.");
        ArrayUtils.print2DArray(array);
        System.out.printf("Количество положительных элементов в заполненном двухмерном массиве: %d\n", count);
    }

    public static void task18()
    {
        /* В числовой матрице поменять местами два столбца любых столбца, т. е. все элементы одного столбца поставить
           на соответствующие им позиции другого, а его элементы второго переместить в первый. Номера столбцов вводит
           пользователь с клавиатуры. */
        int sizeArray = InputOutputUtils.inputUInt("Введите размерность двухмерного квадратного массива: ");
        int array[][] = ArrayUtils.createAndFill2DArrayRandom(sizeArray, sizeArray, -10, 10);
        int firstColumn = InputOutputUtils.inputUInt("Введите номер первого столбца для проведения замены: ");
        int secondColumn = InputOutputUtils.inputUInt("Введите номер второго столбца для проведения замены: ");
        System.out.println("Массив до замены элементов столбцов.");
        ArrayUtils.print2DArray(array);
        ArrayUtils.swapColumns2DArray(array, firstColumn, secondColumn);
        System.out.println("Массив после замены элементов столбцов.");
        ArrayUtils.print2DArray(array);
    }

    public static void task19()
    {
        /* Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце. Определить, какой
           столбец содержит максимальную сумму. */
        int sizeArray = InputOutputUtils.inputUInt("Введите размерность двухмерного квадратного массива: ");
        double array[][] = ArrayUtils.createAndFill2DArrayRandom(sizeArray, sizeArray, 0.0, 100.0);
        System.out.println("Массив после заполнения данными.");
        ArrayUtils.print2DArray(array);
        int numberOfColumnWithMaxSum = ArrayUtils.numberOfColumnWithMaxSum2DArray(array);
        System.out.printf("Номер столбца с максимальной суммой: %d\n", numberOfColumnWithMaxSum);
    }

    public static void task20()
    {
        // Найти положительные элементы главной диагонали квадратной матрицы.
        int sizeArray = InputOutputUtils.inputUInt("Введите размерность двухмерного квадратного массива: ");
        int array[][] = ArrayUtils.createAndFill2DArrayRandom(sizeArray, sizeArray, -10, 10);
        System.out.println("Массив данных.");
        ArrayUtils.print2DArray(array);
        int positiveElements[] = ArrayUtils.positiveElementsOfMainDiagonal2DArray(array);
        System.out.print("Положительные элементы главной диагонали: ");
        ArrayUtils.print1DArray(positiveElements);
    }

    public static void task21()
    {
        /* Матрицу 10x20 заполнить случайными числами от 0 до 15. Вывести на экран саму матрицу и номера строк, в
           которых число 5 встречается три и более раз. */
        int array[][] = ArrayUtils.createAndFill2DArrayRandom(10, 20, 0, 15);
        System.out.println("Двухмерный массив 10x20 заполненный числами от 0 до 15:");
        ArrayUtils.print2DArray(array);
        System.out.print("Номера строк, в которых число 5 встречается больше или равно 3 раз: ");
        ArrayUtils.printNumbersOfRowsWithSomeCondition(array, 5, 3);
    }

    public static void task22()
    {
        // Отсортировать строки матрицы по возрастанию и убыванию значений элементов.
        int sizeArray = InputOutputUtils.inputUInt("Введите размерность двухмерного квадратного массива: ");
        int array[][] = ArrayUtils.createAndFill2DArrayRandom(sizeArray, sizeArray, -10, 10);
        System.out.println("Двухмерный массив, заполненный случайными значениями:");
        ArrayUtils.print2DArray(array);
        System.out.println("Двухмерный массив, после сортировки строк по возрастанию элементов:");
        ArrayUtils.sortAscendingByRows2DArray(array);
        ArrayUtils.print2DArray(array);
        System.out.println("Двухмерный массив, после сортировки строк по убыванию элементов:");
        ArrayUtils.sortDescendingByRows2DArray(array);
        ArrayUtils.print2DArray(array);
    }

    public static void task23()
    {
        // Отсотрировать стобцы матрицы по возрастанию и убыванию значений эементов.
        int sizeArray = InputOutputUtils.inputUInt("Введите размерность двухмерного квадратного массива: ");
        int array[][] = ArrayUtils.createAndFill2DArrayRandom(sizeArray, sizeArray, -10, 10);
        System.out.println("Двухмерный массив, заполненный случайными значениями:");
        ArrayUtils.print2DArray(array);
        System.out.println("Двухмерный массив, после сортировки столбцов по возрастанию элементов:");
        ArrayUtils.sortAscendingByColumns2DArray(array);
        ArrayUtils.print2DArray(array);
        System.out.println("Двухмерный массив, после сортировки столбцов по убыванию элементов:");
        ArrayUtils.sortDescendingByColumns2DArray(array);
        ArrayUtils.print2DArray(array);
    }

    public static void task24()
    {
        /* Сформировать случайную матрицу m x n, состоящую из нулей и единиц, причем в каждом столбце число
           единиц равно номеру столбца. */
        int array[][] = ArrayUtils.createRecreate2DArrayRandom();
        ArrayUtils.fill2DArrayCustomRandom(array);
        System.out.println("Двухмерный массив, заполненный случайно единицами(количество 1 в каждом столбце равно номеру столбца):");
        ArrayUtils.print2DArray(array);
    }

    public static void task25()
    {
        // Найдите наибольший элемент матрицы и заменить все нечетные элементы на него.
        int sizeArray = InputOutputUtils.inputUInt("Введите размерность двухмерного квадратного массива: ");
        int array[][] = ArrayUtils.createAndFill2DArrayRandom(sizeArray, sizeArray, -10, 10);
        System.out.println("Двухмерный массив, заполненный случайными значениями:");
        ArrayUtils.print2DArray(array);
        int maxElement = ArrayUtils.maxElement2DArray(array);
        ArrayUtils.changeOddValues2DArrayWithOtherValue(array, maxElement);
        System.out.println("Двухмерный массив после замены нечетных элементов на максимальный:");
        ArrayUtils.print2DArray(array);
    }

    public static void task26()
    {
        /* Магическим квадратом порядка n называется квадратная матрица размера nxn, составленная из чисел 1, 2, 3,
           ..., 2 n так, что суммы по каждому столбцу, каждой строке и каждой из двух больших диагоналей равны между
           собой. Построить такой квадрат. Пример магического квадрата порядка 3:
           6 1 8
           7 5 3
           2 9 4
         */
        System.out.println("Магический квадрат нечетного порядка.");
        ArrayUtils.oddMagicSquare(5);
    }

    /**********************************************************************************************************/
    /************************************ Одномерные массивы. Сортировки **************************************/
    /**********************************************************************************************************/

    public static void task27()
    {
        /* Заданы два одномерных массива с различным количеством элементов и натуральное число k. Объединить их в
           один массив, включив второй массив между k-м и (k+1) - м элементами первого, при этом не используя
           дополнительный массив. */
        int sizeA = InputOutputUtils.inputUInt("Введите размерность первого одномерного массива: ");
        int sizeB = InputOutputUtils.inputUInt("Введите размерность второго одномерного массива: ");
        int array1[] = ArrayUtils.createAndFill1DArrayRandom(sizeA, -10, 10);
        int array2[] = ArrayUtils.createAndFill1DArrayRandom(sizeB, -10, 10);
        int k = InputOutputUtils.inputNaturalNumber("Введите натуральное число K (индекс после которого нужно вставить второй массив): ");
        System.out.println("Массив 1: ");
        ArrayUtils.print1DArray(array1);
        System.out.println("Массив 2: ");
        ArrayUtils.print1DArray(array2);
        int arrayAfterUnion[] = ArrayUtils.union1DArrays(array1, array2, k);
        System.out.println("Массив после операции обединения: ");
        ArrayUtils.print1DArray(arrayAfterUnion);
    }

    public static void task28()
    {
        /* Даны две последовательности a1 <= a2 <= an и b1 <= b2 <= bm. Образовать из них новую последовательность
           чисел так, чтобы она тоже была неубывающей. Примечание. Дополнительный массив не использовать. */
        int array1[] = new int[]{-1, 2, 3, 3, 5, 6, 6, 6, 8, 10};
        int array2[] = new int[]{-10, -9, -3, -3, 0, 2, 2, 4, 6, 9};
        System.out.print("Первый массив: ");
        ArrayUtils.print1DArray(array1);
        System.out.print("Второй массив: ");
        ArrayUtils.print1DArray(array2);
        int newArray[] = ArrayUtils.createNew1DArrayBasedOnOthers1DArrays(array1, array2);
        System.out.println("Новая неубывающая последовательность чисел: ");
        ArrayUtils.print1DArray(newArray);
    }

    public static void task29()
    {
        /* Сортировка выбором. Дана последовательность чисел a1 <= a2 <= an.Требуется переставить элементы так,
           чтобы они были расположены по убыванию. Для этого в массиве, начиная с первого, выбирается наибольший
           элемент и ставится на первое место, а первый - на место наибольшего. Затем, начиная со второго, эта процедура
           повторяется. Написать алгоритм сортировки выбором. */
        int array[] = new int[]{-1, 2, 3, 3, 5, 6, 6, 6, 8, 10};
        System.out.print("Массив до сортировки: ");
        ArrayUtils.print1DArray(array);
        ArrayUtils.sort1DArrayBySelectionDescending(array);
        System.out.print("Массив после сортировки выбором элементов по убыванию: ");
        ArrayUtils.print1DArray(array);
    }

    public static void task30()
    {
        /* Сортировка обменами. Дана последовательность чисел a1 <= a2 <= an.Требуется переставить числа в
        порядке возрастания. Для этого сравниваются два соседних числа ai и ai+1. Если ai > ai+1, то делается
        перестановка. Так продолжается до тех пор, пока все элементы не станут расположены в порядке возрастания.
        Составить алгоритм сортировки, подсчитывая при этом количества перестановок. */
        int size = InputOutputUtils.inputUInt("Введите размерность одномерного массива: ");
        int array[] = ArrayUtils.createAndFill1DArrayRandom(size, -10, 10);
        System.out.print("Массив до сортировки: ");
        ArrayUtils.print1DArray(array);
        int countPermutations = ArrayUtils.sort1DArrayAscending(array);
        System.out.print("Массив после сортировки выбором элементов по возрастанию: ");
        ArrayUtils.print1DArray(array);
        System.out.printf("Количество перестановок элементов = %d\n", countPermutations);
    }

    public static void task31()
    {
        /* Сортировка вставками. Дана последовательность чисел a1 <= a2 <= an. Требуется переставить числа в порядке
           возрастания. Делается это следующим образом. Пусть a1 <= a2 <= ai - упорядоченная последовательность, т. е.
           a1 <= a2 <= an. Берется следующее число ai+1 a и вставляется в последовательность так, чтобы новая
           последовательность была тоже возрастающей. Процесс производится до тех пор, пока все элементы от i+1 до n
           не будут перебраны. Примечание. Место помещения очередного элемента в отсортированную часть производить
           с помощью двоичного поиска. Двоичный поиск оформить в виде отдельной функции. */
        int size = InputOutputUtils.inputUInt("Введите размерность одномерного массива: ");
        int array[] = ArrayUtils.createAndFill1DArrayRandom(size, -10, 10);
        System.out.print("Массив до сортировки: ");
        ArrayUtils.print1DArray(array);
        ArrayUtils.sort1DArrayByInsertionsAscending(array);
        System.out.print("Массив после сортировки вставками элементов по возрастанию: ");
        ArrayUtils.print1DArray(array);
    }

    public static void task32()
    {
        /* Сортировка Шелла. Дан массив n действительных чисел. Требуется упорядочить его по возрастанию.
           Делается это следующим образом: сравниваются два соседних элемента ai и ai+1. Если ai <= ai+1, то
           продвигаются на один элемент вперед. Если ai > ai+1, то производится перестановка и сдвигаются на один
           элемент назад. Составить алгоритм этой сортировки. */
        int size = InputOutputUtils.inputUInt("Введите размерность одномерного массива: ");
        double array[] = ArrayUtils.createAndFill1DArrayRandom(size, -10.0, 10.0);
        System.out.print("Массив до сортировки: ");
        ArrayUtils.print1DArray(array);
        ArrayUtils.sortShell1DArrayAscending(array);
        System.out.print("Массив после сортировки Шелла элементов по возрастанию: ");
        ArrayUtils.print1DArray(array);
    }

    public static void task33()
    {
        /* Пусть даны две неубывающие последовательности действительных чисел a1 <= a2 <= an и b1 <= b2 <= bm.
           Требуется указать те места, на которые нужно вставлять элементы последовательности b1 <= b2 <= bm в первую
           последовательность так, чтобы новая последовательность оставалась возрастающей. */
        int size1 = InputOutputUtils.inputUInt("Введите размерность одномерного массива1: ");
        int size2 = InputOutputUtils.inputUInt("Введите размерность одномерного массива2: ");
        double array1[] = ArrayUtils.createAndFill1DArrayRandom(size1, -10.0, 10.0);
        double array2[] = ArrayUtils.createAndFill1DArrayRandom(size2, -10.0, 10.0);
        ArrayUtils.sortShell1DArrayAscending(array1);
        ArrayUtils.sortShell1DArrayAscending(array2);
        System.out.print("Массив 1: ");
        ArrayUtils.print1DArray(array1);
        System.out.print("Массив 2: ");
        ArrayUtils.print1DArray(array2);
        System.out.println("Места элементов в первом массиве, на которые нужно вставить элементы второго массива.");
        ArrayUtils.printIndexesInsertionForSort1DArray(array1, array2);
    }

    public static void task34()
    {
        /* Даны дроби p1/q1, p2/q2...pn/qn (pi, qi - натуральные). Составить программу, которая приводит эти дроби к
           общему знаменателю и упорядочивает их в порядке возрастания. */
        int size = InputOutputUtils.inputUInt("Введите размерность одномерного массива для хранения объектов - дробей: ");
        Fraction array[] = Fraction.createAndFillFractions1DArrayRandom(size, 1, 10);
        System.out.print("Массив случайных дробей: ");
        Fraction.printFractions1DArray(array);
        Fraction.sortFractionsAscending(array);
        System.out.print("Массив дробей после сортировки по возрастанию: ");
        Fraction.printFractions1DArray(array);
    }

    /**********************************************************************************************************/
    /************************* Декомпозиция с использованием методов (подпрограммы) ***************************/
    /**********************************************************************************************************/

    public static void task35()
    {
        /* Написать метод(методы) для нахождения наибольшего общего делителя и наименьшего общего кратного двух
           натуральных чисел:
           НОК(A, B) = (A * B) / НОД(A, B)
         */
        int number1 = InputOutputUtils.inputNaturalNumber("Введите первое натуральное число: ");
        int number2 = InputOutputUtils.inputNaturalNumber("Введите второе натуральное число: ");
        int gcd = OtherUtils.greatestCommonDivisor(number1, number2);
        int lcm = OtherUtils.leastCommonMultiple(number1, number2);
        System.out.printf("НОД = %d\n", gcd);
        System.out.printf("НОК = %d\n", lcm);
    }

    public static void task36()
    {
        // Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел.
        int number1 = InputOutputUtils.inputNaturalNumber("Введите первое натуральное число: ");
        int number2 = InputOutputUtils.inputNaturalNumber("Введите второе натуральное число: ");
        int number3 = InputOutputUtils.inputNaturalNumber("Введите третье натуральное число: ");
        int number4 = InputOutputUtils.inputNaturalNumber("Введите четвертое натуральное число: ");
        int gcd = OtherUtils.greatestCommonDivisor(number1, number2, number3, number4);
        System.out.printf("НОД четырех и более чисел = %d\n", gcd);
    }

    public static void task37()
    {
        // Вычислить площадь правильного шестиугольника со стороной а, используя метод вычисления площади треугольника.
        double sideLength = InputOutputUtils.inputUDouble("Введите длинну стороны правильного шестиугольника: ");
        double areaOfHexagon = OtherUtils.areaOfRegularHexagon(sideLength);
        System.out.printf("Площадь правильного шестиугольника = %f\n", areaOfHexagon);
    }

    public static void task38()
    {
        /* На плоскости заданы своими координатами n точек. Написать метод(методы), определяющие, между какими из пар
           точек самое большое расстояние. Указание. Координаты точек занести в массив. */
        int countOfPoints = InputOutputUtils.inputNaturalNumber("Введите количество необходимых точек: ");
        double points[][] = ArrayUtils.createAndFill2DArrayRandom(countOfPoints, 2, 0.0, 10.0);
        System.out.println("Массив случайно сгенерированных координат точек.");
        ArrayUtils.print2DArray(points);
        double pointsWithMaxDistance[][] = OtherUtils.maxDistanceBetweenPoints(points);
        System.out.println("Координаты наиболее отдаленных друг от друга точек.");
        ArrayUtils.print2DArray(pointsWithMaxDistance);
        double distance = Math.sqrt(OtherUtils.squareOfDistanceBetweenPoints(pointsWithMaxDistance[0], pointsWithMaxDistance[1]));
        System.out.printf("Расстояние между данными точками = %f\n", distance);
    }

    public static void task39()
    {
        /* Составить программу, которая в массиве A[N] находит второе по величине число (вывести на печать число,
           которое меньше максимального элемента массива, но больше всех других элементов). */
        int size = InputOutputUtils.inputUInt("Введите размерность одномерного массива: ");
        int array[] = ArrayUtils.createAndFill1DArrayRandom(size, -10, 10);
        System.out.print("Массив случайных значений: ");
        ArrayUtils.print1DArray(array);
        int secondMax = ArrayUtils.secondMaxNumber1DArray(array);
        if (secondMax != Integer.MIN_VALUE) {
            System.out.printf("Второе по величине число: %d\n", secondMax);
        }
        else
        {
            System.out.println("Второго по величине числа в массиве не существует!");
        }
    }

    public static void task40()
    {
        // Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми.
        int number1 = InputOutputUtils.inputNaturalNumber("Введите первое натуральное число: ");
        int number2 = InputOutputUtils.inputNaturalNumber("Введите второе натуральное число: ");
        int number3 = InputOutputUtils.inputNaturalNumber("Введите третье натуральное число: ");
        boolean isMutuallyPrime = OtherUtils.isMutuallyPrimeNumbers(number1, number2, number3);
        System.out.print(isMutuallyPrime);
    }

    public static void task41()
    {
        // Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9.
        int limitA = InputOutputUtils.inputUInt("Введите нижнюю границу диапазона: ");
        int limitB = InputOutputUtils.inputUInt("Введите верхнюю границу диапазона: ");
        BigInteger sum = OtherUtils.sumOfFactorialsOddNumbersInRange(limitA, limitB);
        System.out.printf("Сумма факториалов нечетных натуральных чисел из промежутка [%d, %d): %s", limitA, limitB, sum);
    }

    public static void task42()
    {
        /* Задан массив D. Определить следующие суммы: D[l] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6].
           Пояснение. Составить метод(методы) для вычисления суммы трех последовательно расположенных элементов массива
           с номерами от k до m. */
        int size = InputOutputUtils.inputUInt("Введите размерность одномерного массива: ");
        double array[] = ArrayUtils.createAndFill1DArrayRandom(size, -10.0, 10.0);
        int indexSum = InputOutputUtils.inputUInt("Введите индекс начала последовательной суммы: ");
        double sum = ArrayUtils.consecutiveSumOfThreeElements(array, indexSum);
        System.out.print("Массив созданный случайным образом: ");
        ArrayUtils.print1DArray(array);
        System.out.printf("Последовательная сумма: %f\n", sum);
    }

    public static void task43()
    {
        /* Даны числа X, Y, Z, Т — длины сторон четырехугольника. Написать метод(методы) вычисления его площади, если
           угол между сторонами длиной X и Y— прямой. */
        double x = InputOutputUtils.inputUDouble("Введите X длину стороны четырехугольника: ");
        double y = InputOutputUtils.inputUDouble("Введите Y длину стороны четырехугольника: ");
        double z = InputOutputUtils.inputUDouble("Введите Z длину стороны четырехугольника: ");
        double t = InputOutputUtils.inputUDouble("Введите T длину стороны четырехугольника: ");
        double area = OtherUtils.areaOfQuadrangle(x, y, z, t);
        System.out.printf("Площадь четырехугольника с прямым углом между стороной X и Y: %f\n", area);
    }

    public static void task44()
    {
        /* Дано натуральное число N. Написать метод(методы) для формирования массива, элементами которого являются
           цифры числа N. */
        int number = InputOutputUtils.inputNaturalNumber("Введите натуральное число: ");
        int array[] = ArrayUtils.createAndFill1DArrayWithDigitsFromNumber(number);
        System.out.print("Массив из цифр заданного числа: ");
        ArrayUtils.print1DArray(array);
    }

    public static void task45()
    {
        // Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр.
        int number1 = InputOutputUtils.inputNaturalNumber("Введите первое натуральное число: ");
        int number2 = InputOutputUtils.inputNaturalNumber("Введите второе натуральное число: ");
        int numberWithMaxDigits = OtherUtils.naturalNumberWithMaxDigits(number1, number2);
        System.out.printf("Число с наибольшим количеством цифр: %d\n", numberWithMaxDigits);
    }

    public static void task46()
    {
        /* Даны натуральные числа К и N. Написать метод(методы) формирования массива А, элементами которого являются
           числа, сумма цифр которых равна К и которые не большее N. */
        int k = InputOutputUtils.inputNaturalNumber("Введите первое натуральное число: ");
        int n = InputOutputUtils.inputNaturalNumber("Введите второе натуральное число: ");
        int array[] = ArrayUtils.createAndFillCustom1DArray(k, n);
        System.out.printf("Массив сформированный из чисел с суммой цифр = %d и числом не более %d: ", k, n);
        ArrayUtils.print1DArray(array);
    }

    public static void task47()
    {
        /* Два простых числа называются «близнецами», если они отличаются друг от друга на 2 (например, 41 и 43).
           Найти и напечатать все пары «близнецов» из отрезка [n,2n], где n - заданное натуральное число больше 2.
           Для решения задачи использовать декомпозицию. */
        int n = InputOutputUtils.inputNaturalNumber("Введите число n: ");
        System.out.printf("Все простые числа-близнецы в промежутке [%d, %d].\n", n, 2 * n);
        OtherUtils.printTwinPrimesInRange(n);
    }

    public static void task48()
    {
        /* Натуральное число, в записи которого n цифр, называется числом Армстронга, если сумма его цифр, возведенная
           в степень n, равна самому числу. Найти все числа Армстронга от 1 до k. Для решения задачи использовать
           декомпозицию. */
        int k = InputOutputUtils.inputNaturalNumber("Введите верхнюю границу для поиска чисел Армстронга: ");
        int array[] = OtherUtils.searchAllArmstrongNumbersInRange(k);
        System.out.print("Массив из чисел Армстронга: ");
        ArrayUtils.print1DArray(array);
    }

    public static void task49()
    {
        /* Найти все натуральные n-значные числа, цифры в которых образуют строго возрастающую последовательность
           (например, 1234, 5789). Для решения задачи использовать декомпозицию. */
        int n = InputOutputUtils.inputNaturalNumber("Введите количество цифр натурального числа: ");
        System.out.print("N - значные числа, цифры которых образуют строго возрастающую последовательность: ");
        try {
            OtherUtils.printAllNaturalNumbersWithDigitsAscending(n);
        } catch (OverflowIntException e) {
            e.printStackTrace();
        }
    }

    public static void task50()
    {
        /* Написать программу, определяющую сумму n - значных чисел, содержащих только нечетные цифры. Определить также,
           сколько четных цифр в найденной сумме. Для решения задачи использовать декомпозицию. */
        int n = InputOutputUtils.inputNaturalNumber("Введите количество цифр натурального числа: ");
        BigInteger sum = BigInteger.ZERO;
        try {
            sum = OtherUtils.sumOfNaturalNumbersWithOddDigits(n);
        } catch (OverflowIntException e) {
            e.printStackTrace();
        }
        int countEvenDigits = OtherUtils.countEvenDigitsInNaturalNumber(sum);
        System.out.printf("Сумма n-значных натуральных чисел, у которых все числа нечетные %s\n", sum);
        System.out.printf("Количество четных чисел суммы: %d\n", countEvenDigits);
    }

    public static void task51()
    {
        /* Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д. Сколько таких
           действий надо произвести, чтобы получился нуль? Для решения задачи использовать декомпозицию. */
        int number = InputOutputUtils.inputNaturalNumber("Введите натуральное число: ");
        int count = OtherUtils.countOfSubstraction(number);
        System.out.printf("Количество вычитаний суммы цифр: %d\n", count);
    }

    public static void main(String[] args)
    {
        task51();
    }
}
