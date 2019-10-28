// позволяет избавитсья от создания херовой тонны конструкторов, сетая только нужные поля
// создаем интерфейс PersonBuilder с методами set() и build()
// создаем класс PersonBuilderImpl с реализацией, возвращающей this и build возвращающей person
// Создаем билдер, вызываем нужные методы, билдим и присваиваем объекту

public class Main {
    public static void main(String[] args) {

        Person person = new PersonBuilderImpl().setName("Max").setAge(22).build();
        person.print();
    }
}

class Person {
    String name;
    int age;
    double salary;
    public void print() {
        System.out.println(name + " " + age + " " + salary);
    }

}

interface PersonBuilder {
    PersonBuilder setName(String name);
    PersonBuilder setAge(int age);
    PersonBuilder setSalary(double salary);
    Person build();
}

class PersonBuilderImpl implements PersonBuilder {

    Person person = new Person();

    @Override
    public PersonBuilder setName(String name) {
        person.name = name;
        return this;
    }

    @Override
    public PersonBuilder setAge(int age) {
        person.age = age;
        return this;
    }

    @Override
    public PersonBuilder setSalary(double salary) {
        person.salary = salary;
        return this;
    }

    @Override
    public Person build() {
        return person;
    }
}