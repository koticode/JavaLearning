package JavaLearningStart.OOP.ClassComposition;

import java.util.Arrays;

/**
 * Здесь создан класс, представляющий собой жесткий диск компьютера
 */

public final class Ssd { // Задаю final, т.к. хочу запретить наследовать этот класс
    int[] allowValues={128,256,512,1024,2048,4096,8192};

    public void setValue(int value) {
        if (Arrays.binarySearch(allowValues,value)<0){ // в случае, когда значение value не совпадет ни с одним элементом массива, Arrays.binarySearch вернет ОТРИЦАТЕЛЬНЫЙ индекс.Так и поймем, что введено неверное значение.
            System.out.println(value+"-недопустимый объем жесткого диска. Введите одно из доступных значений - 128,256,512,1024,2048,4096,8192 (в гигабайтах)");
            System.out.println("Выполнение программы прекращено по причине неверно введенных данных");
            System.exit(1);
        }
        else
            this.value=value;
    }

    private int value; // поле со значением оперативной памяти сделано приватным. Доступ из других классов через Getter.

    public Ssd(int value) { // при создании объекта класса Ssd в конструкторе задается объем памяти жесткого диска.
        setValue(value);
    }

    public int getValue() { // Getter для возможности использовать значение value в других классах (пригодится в классе Computer)
        return value;
    }

}
