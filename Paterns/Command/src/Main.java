// Паттерн команда решает проблему между связыванием того, что мы вызываем какой-то метод
// на каком-то классе, но мы не знаем какой методот и на каком классе мы вызовем,
// поэтому мы сделаем специальную прослойку типа команда, которая и будет вызывать конкртный метод
// на конкретном классе
// 1) создаем класс Button, сетаем туда Command и создаем метод pressButton() с вызовом command.execute()
// 2) создаем интерфейс Command с методом execute() и разные реализации CommandImpl

// паттерн позволяет очень гибко совмещать нажатие какой-то кнопки (вызов какой-то команды),
// но мы не знаем какая команда будет вызвана - какой класс, интерфейс
// Поэтому мы добавляем специальную прослойку Command, которая потом будет что-то конкретное вызывать


public class Main {
    public static void main(String[] args) {
        //Command command = new LightCommand(new Light());
       // Command command1 = new MusicCommand(new MusicPlayer());
       // Command command2 = new CoffeeCommand(new CoffeeMachine());
        //Command command3 = new LightAndMusicCommand(new MusicPlayer(), new Light());
        Command command4 = new PhoneCommand(new Phone(), "Mike");
        Button button = new Button(command4);
        button.pressButton();
    }
}

class Button {

    Command command;

    public Button(Command command) {
        this.command = command;
    }

    void pressButton() {
        command.execute();
    }
}

interface  Command {
    void execute();
}

class LightCommand implements  Command {
    Light light;

    public LightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.switchLight();
    }
}

class MusicCommand implements  Command {

    MusicPlayer musicPlayer;

    public MusicCommand(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @Override
    public void execute() {
        musicPlayer.playMusic();
    }
}

class CoffeeCommand implements Command {
    CoffeeMachine coffeeMachine;

    public CoffeeCommand(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void execute() {
        coffeeMachine.makeCoffee();
    }
}

class LightAndMusicCommand implements Command {
    MusicPlayer musicPlayer;
    Light light;

    public LightAndMusicCommand(MusicPlayer musicPlayer, Light light) {
        this.musicPlayer = musicPlayer;
        this.light = light;
    }

    @Override
    public void execute() {
        musicPlayer.playMusic();
        light.switchLight();
    }
}

class PhoneCommand implements  Command {
    Phone phone;
    String name;

    public PhoneCommand(Phone phone, String name) {
        this.phone = phone;
        this.name = name;
    }

    @Override
    public void execute() {
        phone.makeCall(name);
    }
}
class Light {
    boolean isOn;
    public void switchLight() {
        this.isOn = !this.isOn;
        System.out.println("light is " + (isOn ? "on" : "off"));
    }
}

class MusicPlayer {
    public void playMusic() {
        System.out.println("play music");
    }
}

class CoffeeMachine {
    public void makeCoffee() {
        System.out.println("coffee ready");
    }
}

class Phone {
    public void makeCall(String name) {
        System.out.println("make call to " + name);
    }
}