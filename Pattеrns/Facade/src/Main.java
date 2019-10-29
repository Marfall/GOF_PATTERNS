// Объединяет сложную логику в вызове одного метода
// выносим сложную логику в одно место (в один класс)и вызываем одним вызовом

public class Main {
    public static void main(String[] args) {
        LivingRoom livingRoom = new LivingRoom();
        livingRoom.pressButton("5", "22");
    }
}

class Tv {
    void playChannel(String channel) {
        System.out.println("play channel " + channel);

    }
}
class AirConditioning {
    void setTemperature(String temperature) {
        System.out.println("set temperature " + temperature);
    }
}

class Light {
    void turnLight() {
        System.out.println("run light");
    }
}

class RoomFacade {
    Tv tv = new Tv();
    AirConditioning airConditioning = new AirConditioning();
    Light light =  new Light();

    public void pressButton(String chanel, String temperature) {
        tv.playChannel(chanel);
        airConditioning.setTemperature(temperature);
        light.turnLight();
    }
}
class LivingRoom  {

    RoomFacade roomFacade = new RoomFacade();
    public void pressButton(String channel, String temperature) {
        roomFacade.pressButton(channel, temperature);

    }
}

class BadRoom {
    RoomFacade roomFacade = new RoomFacade();
    public void pressButton(String channel, String temperature) {
        roomFacade.pressButton(channel, temperature);
    }
}