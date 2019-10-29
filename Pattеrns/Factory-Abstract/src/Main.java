// Фабричный метод - создает определенный объект, конкретно какой не знает
// какая машина создается определяется в потомках - переопределением метода getCar -
// и возвращем нужный релаьный объект
// Идея в том, что есть абстрактный клас, который возвращает объект -
// мы не знаем какой, поэтому используем Factory- метод
// - абстрактный метод, возвращающий объекты
// - какие объекты мы уже определяем в наследниках

// Абстрактнаясв

public class Main {
    public static void main(String[] args) {
        CarFactory carFactory = new MercedesFactory();
        carFactory.createCar();
    }
}

interface Car {
    void drive();
}

class Mercedes implements Car {
    public void drive() {
        System.out.println("drive mercedes");
    }
}

class Bmw implements Car {
    public void drive() {
        System.out.println("drive bmw");
    }
}

abstract class CarFactory {
    public void createCar() {
        Car car = getCar();
        car.drive();
    }
    abstract Car getCar();
}

class MercedesFactory extends  CarFactory {
    @Override
    Car getCar() {
        return new Mercedes();
    }
}

class BmwFactory extends CarFactory {
    @Override
    Car getCar() {
        return new Bmw();
    }
}