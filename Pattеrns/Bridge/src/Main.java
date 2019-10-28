// Паттерн Bridge позволит расти классам в арифметической прогрессии
// Если есть класс Фигура и два наследника - Квадрат и Круг - и у них в свою очерель КрасныйКруг,  КрасныйКвадрат
// То цвет следует вынести в отдельный класс

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Car(new Toyoya());
        vehicle.drive();
        Vehicle vehicle1 = new Track(new Audi());
        vehicle1.drive();
    }
}

abstract class Vehicle {   // Car, Track

    Model model;

    public Vehicle(Model model) {
        this.model = model;
    }

    abstract void drive();
}

class  Car extends Vehicle {

    public Car(Model model) {
        super(model);
    }

    @Override
    public void drive() {
        model.drive("drive car ");
    }
}

class  Track extends Vehicle {

    public Track(Model model) {
        super(model);
    }

    @Override
    public void drive() {
        model.drive("drive track ");
    }
}

interface Model {           // Mercedes, Toyota
    void drive(String str);
}

class Audi implements Model {
    @Override
    public void drive(String str) {
        System.out.println(str + "audi");
    }
}

class Toyoya implements Model {
    @Override
    public void drive(String str) {
        System.out.println(str + "toyota");
    }
}
