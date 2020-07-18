package com.company.Pair;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return first == pair.first &&
                second == pair.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}