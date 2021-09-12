package ru.vdv.algorithms.binary_search;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibEffective(100));
    }

    private static long fibNative(int n) {
//        if (n == 0) {
//            return 0;
//        }
//        if (n == 1) {
//            return 1;
//        }
        /*Упростим вышенаписанное*/
        if (n <= 1) {
            return n;
        }
        /*Пишем рекурсивный алгоритм. Он не эффективен, очень долгий, потому-что дерево быстро разрастается и каждый
         * элемент ещё дублируется*/
        return fibNative(n - 1) + fibNative(n - 2);
    }

    /*Эффективный способ вычисления числа Фибоначчи*/
    private static long fibEffective(int n) {
        long[] arr = new long[n + 1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            /*Для получения числа по индексу 2(а значение элемента на этом индексе равно 1), мы складываем число на
            позиции 1(значение там равно единице) и число на позиции 0(там значение элемента равно 0). 1 + 0 = 1*/
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}
