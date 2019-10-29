// У нас может быть много объектов, коммуницирующих между собой
// И, например, один объект должен послать собщение остальным 10-и, но себе не посылать, кроме себя
// пример - при нажатии на кнопку - все остальные кнопки меняют свои состояния

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Chat chat = new ChatMediator();
        CollegueImp mike = new CollegueImp(chat, "mike");
        chat.addColegue(new CollegueImp(chat,"John"));
        chat.addColegue(new CollegueImp(chat,"Sam"));
        mike.sendMessage("HelloWorld");
    }

}
interface Chat {
    void sendMessage(String message, Colegue colegue);
    void addColegue(Colegue colegue);
}

class ChatMediator implements  Chat {
    List<Colegue> list = new ArrayList<>();

    @Override
    public void sendMessage(String message, Colegue me) {    //отправить всем коллегам, кроме себя
        list.forEach(colegue -> {
            if (colegue != me) {
                colegue.printMessage(message);
            }
        });
    }

    @Override
    public void addColegue(Colegue colegue) {
        list.add(colegue);
    }
}
abstract class Colegue {
    Chat chat;
    String name;

    public Colegue(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }

    abstract void sendMessage(String message);
    abstract void printMessage(String  message);
}

class CollegueImp extends Colegue {
    public CollegueImp(Chat chat, String name) {
        super(chat, name);
    }

    @Override
    void sendMessage(String message) {
        chat.sendMessage(message, this);
    }

    @Override
    void printMessage(String message) {
        System.out.println(name + " " + message);
    }
}