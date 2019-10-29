// Для каждого ингридиента свой класс и он будет добавляться к общей пицце
// решает проблему большого числа имплементаций - один класс, передаем в другой
// и получаем только то, что нам нужно

public class Main {
    public static void main(String[] args) {
        Pizza cheesePizza = new CheesePizza(new DoughPizza());
        Pizza pepperoniPizza= new PepperoniPizza(cheesePizza);
        System.out.println(pepperoniPizza.makePizza());
    }
}

interface Pizza {
    String makePizza();
}

class DoughPizza implements Pizza {
    @Override
    public String makePizza() {
        return "with ";
    }
}

class CheesePizza implements Pizza {
    Pizza pizza;

    public CheesePizza(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String makePizza() {
        return pizza.makePizza() + "cheese ";
    }
}

class PepperoniPizza implements Pizza {
    Pizza pizza;

    public PepperoniPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String makePizza() {
        return pizza.makePizza() + "pepperoni ";
    }
}