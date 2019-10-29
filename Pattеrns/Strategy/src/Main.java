// Как сделать чтобы вновь добавленные трактора не летали
// Позволяет добавить некий функционал одним классам, и избавить от это функцинала других
// Проблема была в множестве разных классов , которые экстендят один и тот же класc
// и нам нужно было добавить одним - один функционал, которого не должо быть у других
// => добавляем отдельное поле в класс и есть разные релизации - FlyCar - NoFly
// не надо писать в кажом классе свою реализцию fly() - добавляем класс, имплементирующий Flyable с разным поведением
// отдельным полем- сетим в конструкторе

public class Main {
    public static void main(String[] args) {
        Car car = new Toyota(new FlyCar());
        Car car2 = new Tractor(new NoFly());
        car.fly();
        car2.fly();
    }
}

interface Flyable {
    void fly();
}

class FlyCar implements Flyable {
    @Override
    public void fly() {
        System.out.println("fly");
    }
}

class NoFly implements Flyable {
    @Override
    public void fly() {
        System.out.println("no fly");
    }
}
abstract class Car {
    Flyable flyable;        //поле интерфейса сетим через конструктор

    public Car(Flyable flyable) {
        this.flyable = flyable;
    }

    abstract  void run();
    public void stop() {
        System.out.println("stop");
    }
    public void fly() {
        flyable.fly();
    }
}
class Toyota extends Car {

    public Toyota(Flyable flyable) {
        super(flyable);
    }

    @Override
    void run() {
        System.out.println("run toyota");
    }
}

class Ferrari extends Car {
    public Ferrari(Flyable flyable) {

        super(flyable);
    }

    @Override
    void run() {
        System.out.println("run ferrari");
    }
}

class Tractor extends  Car {
    public Tractor(Flyable flyable) {
        super(flyable);
    }

    @Override
    void run() {
        System.out.println("run tractor");
    }
}