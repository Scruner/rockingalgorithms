package ru.vdv.algorithms.binary_search;

import java.util.Arrays;

public class GreedyAlgorithms {

    public static void main(String[] args) {
        int[] digits = {3, 1, 7, 9, 9, 5};
        System.out.println(maxNumberFromDigits(digits));
    }

    public static String maxNumberFromDigits(int[] digits) {
        /*Сортируем массив методом sort() и конкатенируем цифры в число, начиная с конца массива*/
        Arrays.sort(digits);
        /*Создаём строку аккумулятор, куда будем складывать цифры*/
        String rsl = "";
        /*Создаём цикл, в котором начинаем шагать с последнего элемента массива*/
        for (int i = digits.length - 1; i >= 0; i--) {
            /*Аккумулируем, конкатенируем цифры в число*/
            rsl += digits[i];
        }
        return rsl;
    }
}
