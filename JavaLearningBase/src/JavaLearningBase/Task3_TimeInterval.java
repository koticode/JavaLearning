package JavaLearningStart;

/**
 * 1. Создать класс, описывающий промежуток времени.
 *    Сам промежуток времени должен задаваться тремя свойствами:
 *    секундами, минутами и часами.
 *    Создать два конструктора: первый принимает общее количество секунд,
 *    второй - часы, минуты и секунды по отдельности.
 *    Создать метод для создания интервала.
 *    Создать метод для получения полного количества секунд в объекте.
 *    Создать метод для вывода данных.
 *    Создать метод для суммирования интервалов.
 */

    public class Task3_TimeInterval {
        public static void main(String[] args) {

            Interval interval = createTimeInterval(); // создаем первый интервал через вызов метода
            //Второй интервал создадим по второму конструктору, передав в него кол-во секунд первого интервала, применив метод для получения кол-ва секунд в интервале.
            Interval interval2 = new Interval(interval.countSeconds());// заодно убедимся, что перевод из секунд в формат ч+м+с работает правильно (оба интервала при выводе должны совпасть)
            // Вывод в консоль 2-х заданных интервалов:
            interval.printInterval();
            interval2.printInterval();
            Interval sumInterval=interval2.sumIntervals(interval); // создаем третий интервал, суммирующий первые 2
            sumInterval.printInterval();
        }
        private static Interval createTimeInterval() { // метод для создания интервала
            Interval interval = new Interval(1, 1, 1); // из этих 2-х строк, которые были в строке 15 и 16, мы создали метод через комбинацию клавиш Ctrl+alt+m
            System.out.println("Созданный интервал в переводе на секунды - "+interval.countSeconds()+" сек.");
            return interval;
        }
    }

/**
 * Класс, описывающий промежуток времени:
 */
class Interval {

    private int seconds;
    private int minutes;
    private int hours;
    public final int SECONDS_IN_MINUTE = 60;
    public final int SECONDS_IN_HOUR = 3600;


    public Interval(int seconds, int minutes, int hours) { // конструктор для задания кол-ва секунд, минут и часов в интервале
        this.seconds = seconds;
        this.minutes = minutes;
        this.hours = hours;
    }

    public Interval(int totalSeconds) { //Конструктор, принимающий общее кол-во секунд в интервале
        // каждый интервал должен быть в виде: часы+минуты+секунды
        // например, 3750=3600+120+30 секунд (т.е. 1 час, 2 мин. и 30 сек.)
        this.seconds = totalSeconds % SECONDS_IN_HOUR % SECONDS_IN_MINUTE; // 3750%3600=150-->150%60=30
        this.minutes = totalSeconds % SECONDS_IN_HOUR / SECONDS_IN_MINUTE; // 3750%3600=150-->150/60=2
        this.hours = totalSeconds / SECONDS_IN_HOUR; // 3750/3600=1
    }

    public int countSeconds() { // метод для получения полного количества секунд в объекте.
        return seconds + minutes * SECONDS_IN_MINUTE + hours * SECONDS_IN_HOUR;
    }

    public void printInterval() { // метод для вывода данных
        System.out.println("h " + hours + " m " + minutes + " s " + seconds);
    }

    public Interval sumIntervals(Interval second) { // метод для суммирования интервалов.
        System.out.println("Сумма двух интервалов: ");
        return new Interval(this.countSeconds() + second.countSeconds()); // this здесь для удобства. Его использование не обязательно, т.к. нет конфликта имен second!=countSeconds.
    }
}

