package ru.vdv.algorithms.binary_search;

import java.util.Arrays;

public class GreedyAlgorithmsDistanceFuel {

  public static void main(String[] args) {
    int[] stations = {0, 200, 375, 550, 750, 950};
    System.out.println(minStops(stations, 400));
  }

  /*Метод будет задавать оптимальное количество остановок для заправки автомобиля. В параметр ему передаём
   * массив, который является всеми возможными остановками (расстояния между ними) по пути следования(int[] digits)
   * второй параметр(int capacity) - это сколько километров может проехать машина на одном баке*/
  public static int minStops(int[] station, int capacity) {
    /*Создаём переменную, которая будет оптимальным количеством остановок автомобиля, именно её будет
     * возвращать наш метод*/
    int result = 0;
    /*Создаём переменную, которая будет означать ту остановку, на которой находится сейчас машина.
     * Изначально мы находимся в точке 0*/
    int currentStop = 0;
    /*Создаём цикл, в котором мы будем работать пока наша остановка(currentStop) будет меньше, чем конечная точка
     * остановки*/
    while (currentStop < station.length - 1) {
      /*Вычисляем заправку, которая дальше всех, но меньше возможного пробега на одном баке (capacity). Для
       * этого создаём переменную int nextStop. До того как мы начнём определять следующую оптимальную по расстоянию
       * заправку, следующая заправка будет равняться текущей заправке*/
      int nextStop = currentStop;
      /*Далее мы будем менять наш nextStop, чтобы узнать следующую оптимальную заправку на пути. Для этого в цикле
       * ставим условие, пока следующая заправка не достигла значения последней возможной точки заправки на всём пути*/
      while (nextStop < station.length - 1
          /*Здесь мы проверяем можем ли мы доехать до следующей заправки. Мы пытаемся доехать до следующей заправки,
          то есть увеличиваем индекс на единицу station[nextStop + 1] и разностью (station[nextStop + 1] - station[currentStop])
          мы смотрим какое у нас расстояние между следующей заправкой и текущей точкой нашего нахождения в данный момент.
          А если это расстояние меньше или равно возможному пробегу на одном баке (capacity), то мы смотрим следующую
          заправку (nextStop++).
          Так мы крутимся в этом цикле с этими двумя условиями, пока какое-нибудь из них не окажется равной false. В итоге
          в переменной nextStop будет индекс наиболее дальней, но при этом достижимой заправки*/
          && station[nextStop + 1] - station[currentStop] <= capacity) {
        nextStop++;
        /*Здесь мы проверяем, если текущее местоположение равно, следующей заправке. То мы не можем доехать до
         * следующей заправке*/
        if (currentStop == nextStop) {
          /*Если такая ситуация случается, то мы говорим, что мы не можем доехать из точки А в точку В(возвращаем -1).
           * Такое может произойти если первая ближайшая заправка будет дальше, чем возможный пробег на одном баке*/
          return -1;
        }
        /*Здесь проверяем доехали ли мы до финальной точки, не указывает ли наш указатель nextStop на финальную
         * точку, куда мы должны приехать*/
        if (nextStop < station.length - 1) {
          /*Если наша следующая точка не является конечной, то мы инкриминируем результат*/
          result++;
        }
        /*Сдвигаем машину и указателю (текущая точка) приравниваем к указателю (следующая точка)*/
        currentStop = nextStop;
      }
    }
    /*В переменной резалт будет храниться количество всех остановок на заправку*/
    return result;
  }
}