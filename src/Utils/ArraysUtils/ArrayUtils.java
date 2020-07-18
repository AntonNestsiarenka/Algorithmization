package Utils.ArraysUtils;

import Utils.OtherUtils.OtherUtils;
import com.company.Pair.Pair;

public class ArrayUtils {

    /* Методы для работы с массивами. */

    public static int[] createAndFill1DArrayRandom(int size, int limitA, int limitB) {
        // Метод создает целочисленный массив размерности size и заполняет его случайными значениями от [limitA, limitB].
        int array[] = new int[size];
        for (int i = 0; i < size; i++)
            array[i] = OtherUtils.randInt(limitA, limitB);
        return array;
    }

    public static double[] createAndFill1DArrayRandom(int size, double limitA, double limitB) {
        // Метод создает массив действительных чисел размерности size и заполняет его случайными значениями от [limitA, limitB).
        double array[] = new double[size];
        for (int i = 0; i < size; i++)
            array[i] = OtherUtils.uniform(limitA, limitB);
        return array;
    }

    public static void print1DArray(int[] array) {
        // Вывод одномерного целочисленного массива в консоль.
        for (int element : array)
            System.out.printf("%4d ", element);
        System.out.println();
    }

    public static void print1DArray(double[] array) {
        // Вывод одномерного массива действительных чисел в консоль.
        for (double element : array)
            System.out.printf("%10f ", element);
        System.out.println();
    }

    public static int sumOfMultipleElements1DArray(int[] array, int k) {
        // Метод возвращает сумму элементов одномерного массива кратных k.
        int sum = 0;
        for (int element : array) {
            if (element % k == 0) {
                sum += element;
            }
        }
        return sum;
    }

    public static void replacingAn1DArrayElementWithValue(double[] array, int indexOfElement, double value) {
        // Замена элемента одномерного массива с индексом indexOfElement значением value.
        array[indexOfElement] = value;
    }

    public static int countNumberOfReplacements1DArray(double[] array, double z) {
        // Метод возвращает количество выполненных замен элементов массива на число z.
        int countOfReplacements = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > z) {
                replacingAn1DArrayElementWithValue(array, i, z);
                countOfReplacements++;
            }
        }
        return countOfReplacements;
    }

    public static int[] countPositiveNegativeZerosElements1DArray(double[] array) {
        /* Метод считает количество положительных, отрицательных и нулевых элементов в одномерном массиве, формирует и
           возвращает одномерный массив результатов подсчета. */
        int countPositive = 0;
        int countNegative = 0;
        int countZeros = 0;
        for (double element : array) {
            if (element > 0) {
                countPositive++;
            } else if (element < 0) {
                countNegative++;
            } else {
                countZeros++;
            }
        }
        int arrayOfCounts[] = new int[]{countPositive, countNegative, countZeros};
        return arrayOfCounts;
    }

    public static void swapMinMaxElements1DArray(double[] array) {
        // Метод ищет максимальный и минимальный элемент в одномерном массиве и меняет их местами.
        if (array.length <= 1)
            return;
        double minElement = array[0];
        int indexMinElement = 0;
        double maxElement = array[0];
        int indexMaxElement = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < minElement) {
                minElement = array[i];
                indexMinElement = i;
            }
            if (array[i] > maxElement) {
                maxElement = array[i];
                indexMaxElement = i;
            }
        }
        array[indexMinElement] = maxElement;
        array[indexMaxElement] = minElement;
    }

    public static void printCustom1DArray(int[] array) {
        // Вывод в консоль элементов одномерного массива, для которых array[i] > i.
        for (int i = 0; i < array.length; i++) {
            if (array[i] > i) {
                System.out.print(array[i] + "\t");
            }
        }
        System.out.println();
    }

    public static double sumOfElements1DArrayWithSimpleIndexes(double[] array) {
        // Сумма всех элементов одномерного массива, индексы которых являются простыми числами.
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (OtherUtils.isSimpleNumber(i)) {
                sum += array[i];
            }
        }
        return sum;
    }

    public static double maxSumOfOppositeElements(double[] array) {
        // Нахождение максимальной суммы противоположных элементов одномерного массива max(a1 + an-1, a2 + an−2, an + an - n)
        double maxResult = 0;
        int castRange = array.length / 2 + array.length % 2;
        for (int i = 0, j = array.length - 1; i < castRange; i++, j--) {
            double tempSum = array[i] + array[j];
            maxResult = OtherUtils.max(tempSum, maxResult);
        }
        return maxResult;
    }

    public static Pair minElementAndCountIn1DArray(int[] array) {
        /* Нахождение минимального элемента одномерного массива и количества таких элементов. Результатом будет
           экземпляр класса Pair. */
        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int element : array) {
            if (element < min) {
                count = 1;
                min = element;
            } else if (element == min) {
                count++;
            }
        }
        return new Pair(min, count);
    }

    public static int[] createAndFillNew1DArrayBasedOnTheOld1DArray(int[] array) {
        /* Формирование нового одномерного массива и заполнение его значениями из другого одномерного массива
           исключая минимальный элемент (элементы если их несколько). */
        Pair min = minElementAndCountIn1DArray(array);
        int newArray[] = new int[array.length - min.getSecond()];
        for (int i = 0, j = 0; i < newArray.length; j++) {
            if (array[j] != min.getFirst()) {
                newArray[i++] = array[j];
            }
        }
        return newArray;
    }

    public static int[] sorted1DArray(int[] array) {
        // Сортирует одномерный массив по возрастанию элементов. Возвращает новый отсортированный массив.
        int copyArray[] = array.clone();
        for (int i = 0; i < copyArray.length; i++) {
            for (int j = 0; j < copyArray.length - 1 - i; j++) {
                if (copyArray[j] > copyArray[j + 1]) {
                    int temp = copyArray[j];
                    copyArray[j] = copyArray[j + 1];
                    copyArray[j + 1] = temp;
                }
            }
        }
        return copyArray;
    }

    public static int sort1DArrayAscending(int[] array) {
        /* Сортирует одномерный массив по возрастанию элементов. Результатом возвращает количество перестановок
           элементов. */
        int countPermutations = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    countPermutations++;
                }
            }
        }
        return countPermutations;
    }

    public static void sort1DArrayDescending(int[] array) {
        // Сортирует одномерный массив по убыванию элементов.
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static int mostFrequentNumber(int[] array) {
        /* Метод определяет наиболее часто встречающееся целое число в одномерном массиве. Если таких чисел несколько,
           то возвращает результатом наиболее меньшее число. */
        int newArray[] = sorted1DArray(array);
        int maxCount = 0;
        int number = 0;
        int i = 0;
        while (i < newArray.length) {
            int count = 1;
            int currentNumber = newArray[i];
            int j = i + 1;
            while (j < newArray.length) {
                if (newArray[i] == newArray[j]) {
                    count++;
                } else {
                    break;
                }
                j++;
            }
            if (count > maxCount) {
                maxCount = count;
                number = currentNumber;
            }
            i = j;
        }
        return number;
    }

    public static void compress1DArray(int[] array) {
        /* Метод сжимает одномерный массив: каждый второй элемент отбрасывается, оставшиеся элементы смещаются влево.
           Свободные зоны после смещения элементов заполняются нулями */
        int countOfPermutations = array.length / 2 - 1 + array.length % 2;
        int ind = 1;
        for (int i = 0, j = ind + 1; i < countOfPermutations; i++) {
            array[ind++] = array[j];
            j += 2;
        }
        int countOfZeros = array.length / 2;
        for (int i = array.length - countOfZeros; i < array.length; i++) {
            array[i] = 0;
        }
    }

    public static int[][] createAndFill2DArrayRandom(int sizeA, int sizeB, int limitA, int limitB) {
        /* Функция создает двухмерный целочисленный массив размерности sizeA x sizeB и заполняет его случайными
           значениями от [limitA, limitB]. */
        int array[][] = new int[sizeA][sizeB];
        for (int i = 0; i < sizeA; i++) {
            for (int j = 0; j < sizeB; j++) {
                array[i][j] = OtherUtils.randInt(limitA, limitB);
            }
        }
        return array;
    }

    public static double[][] createAndFill2DArrayRandom(int sizeA, int sizeB, double limitA, double limitB) {
        /* Функция создает двухмерный массив действительных чисел размерности sizeA x sizeB и заполняет его случайными
           значениями от [limitA, limitB). */
        double array[][] = new double[sizeA][sizeB];
        for (int i = 0; i < sizeA; i++) {
            for (int j = 0; j < sizeB; j++) {
                array[i][j] = OtherUtils.uniform(limitA, limitB);
            }
        }
        return array;
    }

    public static void print2DArray(int[][] array) {
        // Вывод двухмерного целочисленного массива в консоль.
        for (int[] internalArray : array) {
            for (int element : internalArray) {
                System.out.printf("%4d  ", element);
            }
            System.out.println();
        }
    }

    public static void print2DArray(double[][] array) {
        // Вывод двухмерного целочисленного массива в консоль.
        for (double[] internalArray : array) {
            for (double element : internalArray) {
                System.out.printf("%10f  ", element);
            }
            System.out.println();
        }
    }

    public static void printOddColumnsWhereFirstLargerThanLast(int[][] array) {
        /* Вывод в консоль элементов двухмерного целочисленного массива в нечетных столбцах если первый элемент этого
           столбца больше чем последний. */
        for (int j = 0; j < array[0].length; j += 2) {
            if (array[0][j] > array[array.length - 1][j]) {
                for (int k = 0; k < array.length; k++) {
                    System.out.printf("%4d  ", array[k][j]);
                }
                System.out.println();
            }
        }
    }

    public static void printDiagonal2DArray(int[][] array) {
        // Вывод элементов главной диагонали квадратного двухмерного массива.
        for (int i = 0, j = 0; i < array.length; i++, j++) {
            System.out.print(array[i][j] + "\t");
        }
        System.out.println();
    }

    public static void printAllElementsFixedRow2DArray(int[][] array, int rowNumber) {
        // Вывод всех элементов заданной строки rowNumber двухмерного массива если такая имеется.
        if (rowNumber >= 0 && rowNumber < array.length) {
            for (int j = 0; j < array[rowNumber].length; j++) {
                System.out.printf("%4d  ", array[rowNumber][j]);
            }
            System.out.println();
        }
    }

    public static void printAllElementsFixedColumn2DArray(int[][] array, int columnNumber) {
        // Вывод всех элементов заданного столбца columnNumber двухмерного массива если такой имеется.
        if (columnNumber >= 0 && columnNumber < array[0].length) {
            for (int i = 0; i < array.length; i++) {
                System.out.printf("%4d  ", array[i][columnNumber]);
            }
            System.out.println();
        }
    }

    public static int[][] createAndFill2DArrayCustom1(int size) {
        /* Создает квадратный двухмерный массив и заполняет его нечетные строки значениями от 1 до size, четные от size
           до 1. size - должно быть четным числом. Если число нечетное, возвращает пустой массив. */
        if (size % 2 == 0) {
            int array[][] = new int[size][size];
            for (int k = 0, i = 0; k < array.length / 2; k++) {
                int n = 1;
                for (int j = 0; j < array[0].length; j++) {
                    array[i][j] = n;
                    array[i + 1][array[0].length - 1 - j] = n;
                    n++;
                }
                i += 2;
            }
            return array;
        }
        return new int[0][0];
    }

    public static int[][] createAndFill2DArrayCustom2(int size) {
        /* Создает квадратный двухмерный массив и заполняет его определенным образом. size - должно быть четным числом.
           Если число нечетное, возвращает пустой массив. */
        if (size % 2 == 0) {
            int array[][] = new int[size][size];
            for (int i = 0, n = 1; i < array.length; i++, n++) {
                for (int j = 0; j < array[0].length - i; j++) {
                    array[i][j] = n;
                }
            }
            return array;
        }
        return new int[0][0];
    }

    public static int[][] createAndFill2DArrayCustom3(int size) {
        /* Создает квадратный двухмерный массив и заполняет его определенным образом. size - должно быть четным числом.
           Если число нечетное, возвращает пустой массив. */
        if (size % 2 == 0) {
            int array[][] = new int[size][size];
            int startJ = array.length / 2 - 1;
            int i = array.length / 2 - 1;
            for (int n = 0; n < array.length / 2; n++) {
                for (int j = startJ; j < array.length / 2; j++) {
                    array[i][j] = 1;
                    array[i][array.length - j - 1] = 1;
                    array[array.length - i - 1][j] = 1;
                    array[array.length - i - 1][array.length - j - 1] = 1;
                }
                i--;
                startJ--;
            }
            return array;
        }
        return new int[0][0];
    }

    public static int fill2DArrayAndCountingPositiveElements(double[][] array) {
        /* Метод заполняет переданный ей квадратный двухмерный массив по формуле A[i, j] = sin((i * i - j * j) / N).
           N -размерность квадратного массива, i,j - индексы строк/столбцов. Результатом возвращает количество
           заполненных положительных элементов. */
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = Math.sin((i * i - j * j) / (array.length * 1.0));
                if (array[i][j] > 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void swapColumns2DArray(int[][] array, int numberRow1, int numberRow2) {
        /* Метод меняет местами значения элементов столбца numberRow1 и numberRow2 в двухмерном массиве. Если
           какого-либо номера столбца не существует, то ничего не делает. */
        if (numberRow1 >= 0 && numberRow1 < array[0].length && numberRow2 >= 0 && numberRow2 < array[0].length) {
            for (int i = 0; i < array.length; i++) {
                int temp = array[i][numberRow1];
                array[i][numberRow1] = array[i][numberRow2];
                array[i][numberRow2] = temp;
            }
        }
    }

    public static int numberOfColumnWithMaxSum2DArray(double[][] array) {
        /* Метод определяет максимальную сумму в столбцах и номер столбца с максимальной суммой. Возвращает индекс
           столбца с максимальной суммой. */
        double maxSum = 0;
        int columnInd = 0;
        for (int j = 0; j < array[0].length; j++) {
            double currentSum = 0;
            for (int i = 0; i < array.length; i++) {
                currentSum += array[i][j];
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                columnInd = j;
            }
        }
        return columnInd;
    }

    public static int[] positiveElementsOfMainDiagonal2DArray(int[][] array) {
        // Метод возвращает одномерный массив положительных элементов главной диагонали квадратного двухмерного массива.
        int positiveElements[] = new int[array.length];
        int iOther = 0;
        for (int i = 0, j = 0; i < array.length; i++, j++) {
            if (array[i][j] > 0) {
                positiveElements[iOther++] = array[i][j];
            }
        }
        int delta = array.length - iOther;
        if (delta > 0) {
            int newPositiveElements[] = new int[iOther];
            for (int i = 0; i < iOther; i++) {
                newPositiveElements[i] = positiveElements[i];
            }
            return newPositiveElements;
        }
        return positiveElements;
    }

    public static void printNumbersOfRowsWithSomeCondition(int[][] array, int value, int countCondition) {
        /* Метод выводит в консоль номера строк в которых значение value встречается больше либо равно
           countCondition раз. */
        for (int i = 0; i < array.length; i++) {
            int count = 0;
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == value)
                    count++;
            }
            if (count >= countCondition) {
                System.out.print(i + "\t");
            }
        }
        System.out.println();
    }

    public static void sortAscendingByRows2DArray(int[][] array) {
        // Сортировка по строкам элементов в порядке возрастания.
        for (int i = 0; i < array.length; i++) {
            sort1DArrayAscending(array[i]);
        }
    }

    public static void sortDescendingByRows2DArray(int[][] array) {
        // Сортировка по строкам элементов в порядке убывания.
        for (int i = 0; i < array.length; i++) {
            sort1DArrayDescending(array[i]);
        }
    }

    public static void sortAscendingByColumns2DArray(int[][] array) {
        // Сортировка по столбцам элементов в порядке возрастания.
        for (int j = 0; j < array[0].length; j++) {
            int temp[] = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                temp[i] = array[i][j];
            }
            sort1DArrayAscending(temp);
            for (int i = 0; i < array.length; i++) {
                array[i][j] = temp[i];
            }
        }
    }

    public static void sortDescendingByColumns2DArray(int[][] array) {
        // Сортировка по столбцам элементов в порядке убывания.
        for (int j = 0; j < array[0].length; j++) {
            int temp[] = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                temp[i] = array[i][j];
            }
            sort1DArrayDescending(temp);
            for (int i = 0; i < array.length; i++) {
                array[i][j] = temp[i];
            }
        }
    }

    public static int[][] createRecreate2DArrayRandom() {
        /* Создается случайная матрица размера sizeA x sizeB. Если sizeA < sizeB, то матрица пересоздается до тех пор
           пока не выполнится условие. */
        int sizeA = OtherUtils.randInt(1, 50);
        int sizeB = OtherUtils.randInt(1, 50);
        if (sizeA < sizeB) {
            return createRecreate2DArrayRandom();
        }
        return new int[sizeA][sizeB];
    }

    public static void fill2DArrayCustomRandom(int[][] array) {
        /* Заполняет двухмерный массив единицами случайным образом (количество единиц в каждом столбце равно индексу
           столбца). */
        for (int j = 1; j < array[0].length; j++) {
            int count = 0;
            while (count != j) {
                int randomRowIndex = OtherUtils.randInt(0, array.length - 1);
                if (array[randomRowIndex][j] == 0) {
                    count++;
                    array[randomRowIndex][j] = 1;
                }
            }
        }
    }

    public static int maxElement2DArray(int[][] array) {
        // Возвращает максимальный элемент двухмерного массива.
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] > max)
                    max = array[i][j];
            }
        }
        return max;
    }

    public static void changeOddValues2DArrayWithOtherValue(int[][] array, int value) {
        // Заменяет все нечетные элементы массива заданным значением value.
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] % 2 != 0) {
                    array[i][j] = value;
                }
            }
        }
    }

    public static int[] union1DArrays(int[] array1, int[] array2, int k) {
        /* Объединяет два массива в один общий массив объединения. Массив array2 вставляется между k-ым и (k + 1)
           элементами массива array1. При отстутствии k-го элемента в массиве возвращает пустой массив объединения. */
        if (k >= 0 && k < array1.length) {
            int newArray[] = new int[array1.length + array2.length];
            for (int i = k + 1, j = 0; j < array2.length; i++, j++) {
                newArray[i] = array2[j];
            }
            for (int i = 0; i <= k; i++) {
                newArray[i] = array1[i];
            }
            for (int i = array2.length + k + 1, j = k + 1; j < array1.length; i++, j++) {
                newArray[i] = array1[j];
            }
            return newArray;
        }
        return new int[0];
    }

    public static int[] createNew1DArrayBasedOnOthers1DArrays(int[] array1, int[] array2) {
        // Из двух неубывающих одномерных массивов создает общий неубывающий массив.
        int newArray[] = new int[array1.length + array2.length];
        int i = 0;
        for (; i < array1.length; newArray[i] = array1[i], i++) ;
        for (int j = 0; i < newArray.length; newArray[i] = array2[j], i++, j++) ;
        sort1DArrayAscending(newArray);
        return newArray;
    }

    public static Pair maxElement1DArray(int[] array, int index) {
        /* Поиск максимального элемента одномерного массива начиная с элемента с индексом index. Если индекс с
           которого начинать поиск пришел неверный, то воспользоваться стандартным index = 0. */
        if (index < 0 || index >= array.length)
            index = 0;
        Pair maxAndInd = new Pair(Integer.MIN_VALUE, index);
        for (int i = index; i < array.length; i++) {
            if (array[i] > maxAndInd.getFirst()) {
                maxAndInd.setFirst(array[i]);
                maxAndInd.setSecond(i);
            }
        }
        return maxAndInd;
    }

    public static void sort1DArrayBySelectionDescending(int[] array) {
        // Сортировка выбором по убыванию элементов одномерного массива.
        for (int i = 0; i < array.length; i++) {
            Pair maxElementAndIndex = maxElement1DArray(array, i);
            int temp = array[i];
            array[i] = maxElementAndIndex.getFirst();
            array[maxElementAndIndex.getSecond()] = temp;
        }
    }

    public static void sort1DArrayByInsertionsAscending(int[] array) {
        // Сортировка вставками по возрастанию элементов одномерного массива.
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            int k = i;
            while (j >= 0 && array[j] > temp) {
                array[k--] = array[j--];
            }
            array[k] = temp;
        }
    }

    public static void sort1DArrayByInsertionsAscending(double[] array) {
        // Сортировка вставками по возрастанию элементов одномерного массива.
        for (int i = 1; i < array.length; i++) {
            double temp = array[i];
            int j = i - 1;
            int k = i;
            while (j >= 0 && array[j] > temp) {
                array[k--] = array[j--];
            }
            array[k] = temp;
        }
    }

    public static void sortShell1DArrayAscending(double[] array) {
        // Сортировка методом Шелла по возрастанию элементов.
        int offset = array.length / 2;
        while (offset >= 1) {
            for (int i = 0; i < array.length - offset; i++) {
                int j = i;
                while (j >= 0 && array[j] > array[j + offset]) {
                    double temp = array[j];
                    array[j] = array[j + offset];
                    array[j + offset] = temp;
                    j--;
                }
            }
            offset /= 2;
        }
    }

    public static int binarySearch1DArray(double[] array, double element) {
        /* Двоичный поиск индекса в отсортированном массиве array на который нужно вставить element, чтобы получить
           такой же остортированный массив. */
        int leftLimit = -1;
        int rightLimit = array.length;
        while (leftLimit < rightLimit - 1) {
            int medium = (rightLimit + leftLimit) / 2;
            if (element > array[medium]) {
                leftLimit = medium;
            } else {
                rightLimit = medium;
            }
        }
        return rightLimit;
    }

    public static void printIndexesInsertionForSort1DArray(double[] array1, double[] array2) {
        /* Выводит в консоль все элементы отсортированного массива array2 и индексы в отсортированном массиве array1,
           на которые эти элементы должны быть поставлены, чтобы получить новый такой же отсортированный массив. */
        int memory = 0;
        for (double element : array2) {
            int index = binarySearch1DArray(array1, element);
            System.out.printf("%f  :  %d\n", element, index + memory);
            memory++;
        }
    }

    public static Integer secondMaxNumber1DArray(int[] array) {
        // Возвращает второе по величине число. Если такого числа нет, то возвращает null.
        int copyArray[] = array.clone();
        sort1DArrayBySelectionDescending(copyArray);
        //int secondMaxNumber = Integer.MIN_VALUE;
        int i = 0;
        while (i < copyArray.length) {
            if (copyArray[i] < copyArray[0] && copyArray[i] != copyArray[copyArray.length - 1]) {
                return copyArray[i];
            }
            i++;
        }
        return null;
    }

    public static double consecutiveSumOfThreeElements(double[] array, int indexSum) throws ArrayIndexOutOfBoundsException {
        /* Возвращает последовательную сумму из трех элементов. Последовательная сумма считается начиная от элемента с
           индексом indexSum. Если indexSum - это недопустимый индекс для нахождения суммы 3-х последовательных
           элементов, то выбрасывается исключение ArrayIndexOutOfBoundsException("Недопустимый индекс для нахождения
           последовательной суммы"). */
        final int count = 3;
        if (array.length - indexSum >= count) {
            double sum = 0;
            for (int i = indexSum; i < indexSum + count; i++) {
                sum += array[i];
            }
            return sum;
        }
        throw new ArrayIndexOutOfBoundsException("Недопустимый индекс для нахождения последовательной суммы");
    }

    public static int[] createAndFill1DArrayWithDigitsFromNumber(int number) {
        // Создает и заполняет одномерный массив цифрами из натурального числа number.
        int size = OtherUtils.countOfDigitsInNaturalNumber(number);
        int array[] = new int[size];
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = OtherUtils.lastDigitOfNaturalNumber(number);
            number /= 10;
        }
        return array;
    }

    public static int[] resize1DArrayToDown(int[] array, int count) {
        /* Возвращает новый массив c новым размером count и копирует в новый массив count-элементов из массива array.
           Применять когда необходимо неполностью заполненный массив привести к полностью заполненному. */
        int newArray[] = new int[count];
        for (int i = 0; i < count; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    public static int[] createAndFillCustom1DArray(int k, int n) {
        // Формирование массива всеми возможными числами, сумма цифр которых равна k и само число <= n;
        int array[] = new int[n];
        int j = 0;
        for (int i = k; i <= n; i++) {
            if (OtherUtils.sumOfDigitsNaturalNumber(i) == k) {
                array[j++] = i;
            }
        }
        array = resize1DArrayToDown(array, j);
        return array;
    }
}