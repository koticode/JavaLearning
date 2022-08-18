package lesson15_upgrade;

public class Mage extends Hero { // наследуем поля и методы от класса Hero

    public Mage(String name, int damage, int health) { // обязательно нужно создать конструктор, отсылающий к родительскому классу
        super(name, damage, health);
    }

    @Override
    public String hit() { // переопределяю метод нанесения удара противнику (для каждого класса персонажей он будет свой)
        return " сотворил заклинание на ";
    }
}
