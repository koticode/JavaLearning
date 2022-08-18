package lesson15_upgrade;

public class Battle {

    public static void main(String[] args) {

        Hero warrior = new Warrior("Архангел", 40, 500);
        Hero mage = new Mage("Маг", 20,150);
        Hero archer = new Archer("Эльф",10, 200);
        /**
         * Выше, при создании объектов, видим пример полиморфизма.
         * На примере ссылочной переменной warrior: она создается типа "Hero", но объект, на который она ссылается, будет реализовывать переопределенные методы из класса Warrior.
         * Подробнее, все примененные принципы ООП описал в классе Hero.
         *
         * В методе ниже первым указывается обороняющийся герой, после - любое число нападающих
         * Сражение идет до победного - пока не останется в живых либо обороняющийся персонаж, либо хотя бы один из нападавших
         */
        attackToKillEnemy(warrior,mage,archer); // сначала задаем обороняющегося персонажа, все последующие -атакующие.
    }

    public static void attackToKillEnemy(Hero defender, Hero...attackers) { // создан статический метод, который позволяет атаковать врага, пока он не погибнет
        int countAttackers = attackers.length;
        while (defender.isAlive()&&countAttackers>0){
            for (Hero attacker : attackers) {
                if (defender.isAlive()&& attacker.isAlive()) { //герои прекращают атаковать, как только враг повержен, и не наносят удары по убитому врагу до конца шага цикла
                    attacker.attackEnemy(defender); // каждый герой атакует врага по очереди
                    if (!attacker.isAlive()) {
                        --countAttackers;
                    }
                }
                }
            }
        System.out.println();

        if (countAttackers==0){
            System.out.println("Все нападавшие уничтожены");
            System.out.println("Победил обороняющийся персонаж-"+defender.getName());
            System.out.println("У него осталось "+defender.getHealth()+ " единиц здоровья");
        }
        else
            System.out.println("Обороняющийся персонаж "+defender.getName()+" проиграл");
        }
    }
