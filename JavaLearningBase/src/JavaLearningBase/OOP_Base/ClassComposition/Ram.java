package JavaLearningStart.OOP.ClassComposition;

import java.util.Arrays;

/**
 * Здесь создан класс, представляющий собой оперативную память компьютера
 */
public final class Ram { // Задаю final, т.к. хочу запретить наследовать этот класс
    int[] allowValues={4,6,8,12,16,32};
    public void setValue(int value) { // в Setter задал ограничение по допустимым значениям.
            if (Arrays.binarySearch(allowValues,value)<0){ // в случае, когда значение value не совпадет ни с одним элементом массива, Arrays.binarySearch вернет ОТРИЦАТЕЛЬНЫЙ индекс.Так и поймем, что введено неверное значение.
                System.out.println(value+"-недопустимое значение оперативной памяти. Введите одно из доступных значений - 4,6,8,12,16,32 (в гигабайтах)");
                System.out.println("Выполнение программы прекращено по причине неверно введенных данных");
                System.exit(1);
            }
            else
                this.value=value;
    }

    private int value; // поле со значением оперативной памяти сделано приватным. Доступ из других классов через Getter.

    public Ram(int value) { // при создании объекта класса Ram в конструкторе задается величина оперативной памяти.
        setValue(value);
    }

    public int getValue() { // Getter для возможности использовать значение value в других классах (пригодится в классе Computer)
        return value;
    }
    public int addRam(Ram ram){ // метод для добавления оперативной памяти в компьютер
        return this.getValue()+ram.getValue();
    }

}