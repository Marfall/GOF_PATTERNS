//Идея в том, что у объекта может быть состояние, мы можем его менять - и
// может возникнуть необходимость к однуму из состояний вернуться
// originator и его внутренний static класс Momento

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Originator.Momento> list = new ArrayList<>();

        Originator originator = new Originator();
        originator.setState("one");
        originator.setState("two");
        list.add(originator.saveState());
        originator.setState("three");
        System.out.println(originator.getState());
        originator.restoreFromMomento(list.get(0));
        System.out.println(originator.state);

    }
}

class Originator {
    String state;



    public Originator.Momento saveState() {
        return new Momento(this.state);
    }

    public void restoreFromMomento(Momento momento) {
        this.state = momento.state;
    }

    static class Momento {
        String state;

        public Momento(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }


    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}