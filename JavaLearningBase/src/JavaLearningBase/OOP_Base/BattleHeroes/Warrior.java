package lesson15_upgrade;

public class Warrior extends Hero { // наследуем поля и методы от класса Hero

    public Warrior(String name, int damage, int health) { // обязательно нужно создать конструктор, отсылающий к родительскому классу
        super(name, damage, health);
    }

    @Override
    public String hit() { // переопределяю метод нанесения удара противнику (для каждого класса персонажей он будет свой)
        return " взмахнул мечом на ";
    }
}
