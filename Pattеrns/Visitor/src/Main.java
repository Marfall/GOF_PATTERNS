// проблема добавления нового функционала к существующим интерфейсам, когда
// код в продакшне и используется другими программистами
// Добавляем интерфейсу метод accept(), который будет принимать интерфейс Animalisitor
// А метод action() в визитор будет принимать конкретного зверя
// в конкретных классах оверрайдим accep() и вызываем action сами на себе (this)
// создаем  класс-имплементацию Visitor - и реализуем там действия
// Теперь, каждый раз когда мы расширяем функционал - нам нужна еще одна
// имплементация интерфейса  Visitor

// Есть интерфейс Animal, который принимает азные вариации Visitor-ов,
// которые добавляют реализации действий

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.accept(new SoundVisitor());
        animal.accept(new EatVisitor());
    }
}


interface Animal {
    void accept(AnimalVisitor animalVisitor);
}

interface AnimalVisitor {
    void action(Dog dog);
    void action(Cat cat);
}

class Dog implements Animal{
    @Override
    public void accept(AnimalVisitor animalVisitor) {
        animalVisitor.action(this);
    }
}

class Cat implements Animal {
    @Override
    public void accept(AnimalVisitor animalVisitor) {
            animalVisitor.action(this);
    }
}

class SoundVisitor implements AnimalVisitor {
    @Override
    public void action(Dog dog) {
        System.out.println("wof");
    }

    @Override
    public void action(Cat cat) {
        System.out.println("mao");
    }
}
class EatVisitor implements AnimalVisitor {
    @Override
    public void action(Dog dog) {
        System.out.println("eat meat");
    }

    @Override
    public void action(Cat cat) {
        System.out.println("eat fish");
    }
}