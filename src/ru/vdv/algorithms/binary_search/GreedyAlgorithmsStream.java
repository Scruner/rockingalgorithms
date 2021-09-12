package ru.vdv.algorithms.binary_search;

import java.util.Arrays;
import java.util.Collections;

public class GreedyAlgorithmsStream {

    public static void main(String[] args) {
        int[] digits = {3, 1, 7, 9, 9, 5};
        System.out.println(maxNumberFromDigits(digits));
    }

    public static String maxNumberFromDigits(int[] digits) {
        /*Переведём массив в stream. Далее массив примитивов оборачиваем в класс обёртки(boxed()). После
        * этого вызываем метод sorted(), а в параметр ему передаём свой компаратор, который сортирует
        * элементы в массиве в обратном порядке(Collections.reverseOrder())*/
        return String.join("", Arrays.stream(digits).boxed().sorted(Collections.reverseOrder())
                /*Вызываем map(), чтобы там перевести наши целые числа в строки(String::valueOf) */
                .map(String::valueOf)
                /*Вызываем toArray(), чтобы перевести наш stream в массив(String[]::new)*/
                .toArray(String[]::new));
    }
}
