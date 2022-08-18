package JavaLearningStart;
/**
 * Ваня принес на кухню рулет, который он хочет разделить с коллегами. Для этого он хочет разрезать рулет на  N равных частей. Разумеется, рулет можно резать только поперек. Соответственно, Костя сделает (N-1) разрез ножом через равные промежутки.
 * По возвращению с кофе-брейка Ваня задумался — а можно ли было обойтись меньшим числом движений, будь нож Вани бесконечно длинным (иначе говоря, если он мог бы сделать сколько угодно разрезов за раз, если эти разрезы лежат на одной прямой)?
 * Считается, что места для разрезов намечены заранее, и все разрезы делаются с ювелирной точностью.
 * Оказывается, что можно. Например, если Ваня хотел бы разделить рулет на 4 части, он мог бы обойтись двумя разрезами — сначала он разделил бы рулет на две половинки, а потом совместил бы две половинки и разрезал обе пополам одновременно.
 * Вам дано число N, требуется сказать, каким минимальным числом разрезов можно обойтись.
 *
 * Формат входных данных
 *
 * Дано одно натуральное число N(1≤N≤2×10^9) — количество людей на кофе-брейке.
 *
 * Формат выходных данных
 * Выведите одно число — минимальное число движений, которое придется сделать Косте.
 *
 * Замечание
 * Чтобы разрезать рулет на 6 частей, Ване сначала придется разрезать его на две равные части, после чего совместить две половинки и сделать два разреза.
 * Чтобы разрезать рулет на 5 частей, Ване понадобится разделить его в соотношении 2:3, после чего совместить два рулета по левому краю и разрезать бОльший рулет на одинарные кусочки — меньший тоже разделится на одинарные.
 */

import java.util.Scanner;

public class Task2_CutInHalf {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int Nguests = scanner.nextInt(); // получаем число гостей из консоли
            /**
             * Первое решение.
             * Мне оно нравится больше, т.к. оно более рациональное с математической точки зрения, и код заметно короче.
             */
            int cutsCount1= (int) Math.ceil((Math.log(Nguests))/Math.log(2)); // вычисляем логарифм по основанию 2
            System.out.println(cutsCount1);

            /**
             * Дополнение:
             * Есть и второе решение.
             * Ниже мы вычислим число разрезов другим способом (немного дополнив условие задачи)
             * В случае совпадения результатов - в консоли мы увидим сообщение об этом.
             */
            int cutsCount2=0;
            while (Nguests!=1){
                if (Nguests%2==1){ //
                    Nguests++;
                }
                Nguests=Nguests/2;
                ++cutsCount2; // в цикле пошагово происходит "разрезание"
            }
            System.out.println(cutsCount2);
            if (cutsCount1==cutsCount2){
                System.out.println("Результаты обоих решений совпадают");
            }
        }
    }
