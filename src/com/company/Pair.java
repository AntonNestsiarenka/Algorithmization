package com.company;

public class Pair {

    /* Класс "Пара" хранит в себе два целочисленных поля first и second. В данных полях можно хранить любые необходимые
       парные данные. Доступ к полям экземпляра можно получить через методы. */

    private int first;
    private int second;

    public Pair(int value1, int value2)
    {
        first = value1;
        second = value2;
    }

    public Pair()
    {
        first = 0;
        second = 0;
    }

    public int getFirst()
    {
        return first;
    }

    public int getSecond()
    {
        return second;
    }

    public void setFirst(int value)
    {
        first = value;
    }

    public void setSecond(int value)
    {
        second = value;
    }

}
