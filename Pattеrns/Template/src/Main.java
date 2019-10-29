// Классы почти идентичны, но некотоые методы различаются
// Для решения используем паттерн Template
// создаем абстрактный класс Beverage(напиток),
// общие методы релизуем, различные делаем абстрактными
//  хуки нужны для дополнительных возможносте (переопределяем в наследниках)

public class Main {

    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        coffee.makeBevarage();
        Tea tea = new Tea();
        tea.makeBevarage();
    }
}

abstract class Bevarage {           //класс- Template
    private void boilWater() {
        System.out.println("boil water");
    }
    abstract void addBevarage();

    private void addSugar() {
        System.out.println("add sugar");
    }
    abstract void addConditment();
    public void makeBevarage() {
        boilWater();
        addBevarage();
        addSugar();
        addConditment();
    }

    void hook() {

    }
}

class Coffee extends Bevarage {
    @Override
    void addBevarage() {
        System.out.println("add coffee");
    }

    @Override
    void addConditment() {
        System.out.println("add sugar");
    }

    @Override
    void hook() {
        System.out.println("add syrop");
    }
}

class Tea  extends  Bevarage{
    @Override
    void addBevarage() {
        System.out.println("add tea");
    }

    @Override
    void addConditment() {
        System.out.println("add lemon");
    }
}