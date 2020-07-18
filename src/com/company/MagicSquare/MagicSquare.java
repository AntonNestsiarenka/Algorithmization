package com.company.MagicSquare;

import com.company.MagicSquare.Exceptions.MagicSquareSizeException;

public final class MagicSquare {

    private final int size;
    private final int magicSum;

    private MagicSquare(int size)
    {
        this.size = size;
        magicSum = (size % 2 == 1) ? (size * (size * size + 1))/ 2 : ((size + 1) * size * (size - 1) / 2) + size;
    }

    public static MagicSquare createInstance(int size) throws MagicSquareSizeException {
        if (size >= 1)
        {
            return new MagicSquare(size);
        }
        throw new MagicSquareSizeException();
    }

    public int getSize() {
        return size;
    }

    public int getMagickSum() {
        return magicSum;
    }

    public void printMagicSquare()
    {
        // Выводит в консоль магический квадрат порядка size.
        switch(size)
        {
            case(1):
            {
                System.out.println(1);
                break;
            }
            case(2):
            {
                System.out.println("Такого магического квадрата не существует");
                break;
            }
            default:
            {
                if (size % 2 == 1)
                {
                    printOddMagicSquare();
                }
                else if (size % 4 == 0)
                {
                    printEvenEvenMagicSquare();
                }
            }
        }
    }

    private void printEvenEvenMagicSquare()
    {
        // Выводит в консоль магический квадрат четно четного порядка (порядок кратен 4).
        int[][] magicSquare = buildEvenEvenMagickSquare();
        printMatrix(magicSquare);
        System.out.println("\nМагическая сумма = " + magicSum);
    }

    private void printOddMagicSquare() {
        // Выводит в консоль магический квадрат нечетного порядка.
        int[][] array = buildOddMagicSquare();
        printMatrix(array);
        System.out.println("\nМагическая сумма = " + magicSum);
    }

    private int[][] buildEvenEvenMagickSquare()
    {
        // Строит магический квадрат четно четного порядка (порядок кратен 4). В основе лежит метод квадратных рамок.
        int[][] matrix = new int[size + size - 2][size];
        int startI = size / 2 - 1;
        int startJ = 0;
        int startIncrementI = -1;
        int startIncrementJ = 1;
        int countOfFrames = 0;
        int number = 1;
        byte flag = 1;
        while (countOfFrames < size / 2)
        {
            int countNumbersInOneFrame = 0;
            int i = startI;
            int j = startJ;
            int incrementI = startIncrementI;
            int incrementJ = startIncrementJ;
            while (countNumbersInOneFrame < (size / 2) * 4) {
                matrix[i][j] = number++;
                countNumbersInOneFrame++;
                if (countNumbersInOneFrame % (size / 2) == 0 && countNumbersInOneFrame / (size / 2) == 1)
                {
                    i--;
                    incrementI = 1;
                }
                else if (countNumbersInOneFrame % (size / 2) == 0 && countNumbersInOneFrame / (size / 2) == 2)
                {
                    if (flag == 1) {
                        j++;
                        incrementJ = -1;
                    }
                    else {
                        j--;
                        incrementJ = 1;
                    }
                }
                else if (countNumbersInOneFrame % (size / 2) == 0 && countNumbersInOneFrame / (size / 2) == 3)
                {
                    i++;
                    incrementI = -1;
                }
                i += incrementI;
                j += incrementJ;
            }
            countOfFrames++;
            flag *= -1;
            startI += 2;
            if (flag == 1) {
                startJ = 0;
                startIncrementJ = 1;
            }
            else
            {
                startJ = size - 1;
                startIncrementJ = -1;
            }
        }

        for (int j = 1; j < size - 1; j++) {
            for (int i = size / 2 - 2; i >= 0; i--) {
                if (matrix[i][j] != 0) {
                    insertToDown(matrix, i, j, matrix[i][j]);
                }
            }
        }

        for (int j = 1; j < size - 1; j++) {
            for (int i = matrix.length - size / 2 + 1; i < matrix.length; i++) {
                if (matrix[i][j] != 0) {
                    insertToUp(matrix, i, j, matrix[i][j]);
                }
            }
        }

        int[][] magicSquare = new int[size][size];
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                magicSquare[i][j] = matrix[size / 2 - 1 + i][j];
            }
        }
        return magicSquare;
    }

    private void insertToDown(int[][] matrix, int indexI, int indexJ, int value)
    {
        // Вспомогательный метод для построения магических квадратов четно четного порядка.
        for (int i = matrix.length - size / 2; i >= size / 2 - 1; i--)
        {
            if (matrix[i][indexJ] == 0)
            {
                matrix[i][indexJ] = value;
                return;
            }
        }
    }

    private void insertToUp(int[][] matrix, int indexI, int indexJ, int value)
    {
        // Вспомогательный метод для построения магических квадратов четно четного порядка.
        for (int i = size / 2 - 1; i <= matrix.length - size / 2; i++)
        {
            if (matrix[i][indexJ] == 0)
            {
                matrix[i][indexJ] = value;
                return;
            }
        }
    }

    private int[][] buildOddMagicSquare()
    {
        // Строит магический квадрат нечетного порядка. В основе лежит метод построения де ла Лубера.
        int[][] array = new int[size][size];
        int countValues = size * size;
        int i = 0;
        int j = size / 2;
        int number = 1;
        while (number <= countValues) {
            if (i < 0 && j > size - 1) {
                i += 2;
                j -= 1;
            } else if (i < 0) {
                i = size - 1;
            } else if (j > size - 1) {
                j = 0;
            }
            if (array[i][j] != 0) {
                i += 2;
                j -= 1;
            }
            array[i--][j++] = number++;
        }
        return array;
    }

    public static void printMatrix(int[][] array) {
        // Вывод двухмерного целочисленного массива в консоль.
        for (int[] internalArray : array) {
            for (int element : internalArray) {
                System.out.printf("%4d  ", element);
            }
            System.out.println();
        }
    }

    private int[][] createAndFillSquareMatrix()
    {
        // Заполняет матрицу последовательно числами от 1 до size * size.
        int[][] matrix = new int[size][size];
        for (int i = 0, value = 1; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                matrix[i][j] = value++;
            }
        }
        return matrix;
    }

    public static boolean isMagicSquare(int[][] array)
    {
        // Проверяет является ли двухмерный массив магическим квадратом.
        for (int[] array1D : array)
        {
            if (array1D.length != array.length)
                return false;
        }

        int magicSum = (array.length % 2 == 1) ? (array.length * (array.length * array.length + 1))/ 2 : ((array.length + 1) * array.length * (array.length - 1) / 2) + array.length;
        for (int[] row : array)
        {
            if (sum(row) != magicSum)
                return false;
        }

        for (int j = 0; j < array.length; j++) {
            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                sum += array[i][j];
            }
            if (sum != magicSum)
                return false;
        }

        int sum = 0;
        for (int i = 0, j = 0; i < array.length; i++, j++)
        {
            sum += array[i][j];
        }
        if (sum != magicSum)
            return false;

        int sum1 = 0;
        for (int i = array.length - 1, j = 0; i >= 0; i--, j++)
        {
            sum1 += array[i][j];
        }
        if (sum1 != magicSum)
            return false;
        return true;
    }

    private static int sum(int[] array)
    {
        // Возвращает сумму элементов одномерного массива.
        int sum = 0;
        for (int value : array)
        {
            sum += value;
        }
        return sum;
    }
}