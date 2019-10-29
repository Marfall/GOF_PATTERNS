// В абстрактных фабрикак мы группируем фабрики, которые имеют какую-то
//  общую тему,(создаем несколько фабричных методов, которые в потомках создаеют
//  новые объекты) создаем экземляр конкретной фабрики и у нее запрашиваем объекты

public class Main {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new MetcedesFactory();
        Car car = abstractFactory.getCar();
        abstractFactory.getBike();
        Bike bike = abstractFactory.getBike();
        car.drive();
        bike.drive();

    }
}

interface Car {
    void drive();
}

interface  Bike {
    void drive();
}

class Mercedes implements Car {
    public void drive() {
        System.out.println("drive mercedes");
    }
}

class MercedesBike implements Bike {
    public void drive() {
        System.out.println("drive mercedes bike");
    }
}

class Bmw implements Car {
    public void drive() {
        System.out.println("drive bmw");
    }
}

class Bmwbike implements Bike {
    public void drive() {
        System.out.println("drive bmw bike");
    }
}

interface AbstractFactory {
    Car getCar();
    Bike getBike();
}

class MetcedesFactory implements AbstractFactory {
    @Override
    public Car getCar() {
        return new Mercedes();
    }

    @Override
    public Bike getBike() {
        return new MercedesBike();
    }
}

class BmwFactory implements AbstractFactory {
    @Override
    public Car getCar() {
        return new Bmw();
    }

    @Override
    public Bike getBike() {
        return new Bmwbike();
    }
}