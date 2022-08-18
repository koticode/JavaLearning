package JavaLearningStart.OOP.ClassComposition;

public class Computer {


    private Ram ram; // класс Computer в качестве полей содержит другие классы
    private Ssd ssd; // класс Computer в качестве полей содержит другие классы

    public void setRam(Ram ram) { // Setter, потребуется для "замены" (установки нового значения) оперативной памяти
        this.ram = ram;
    }

    public void setSsd(Ssd ssd) { //Setter, аналогично setRam
        this.ssd = ssd;
    }

    public Computer(Ram ram, Ssd ssd) { // при создании объекта Computer в качестве параметров конструктора принимаются значения
        this.ram = ram;
        this.ssd = ssd;
    }

    public void printState() {
        System.out.println("Computer: ram " + ram.getValue() + ", ssd " + ssd.getValue()); //в методе класса Computer мы можем оперировать свойствами других классов, и это очень удобно!
    }
}
