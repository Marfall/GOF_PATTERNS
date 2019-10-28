// как бы  вы реализовали структуру для хранения данных, которой нет конца (не знаем глубину)
// пробегает по внутреннем элементам и выводит их

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Folder users = new Folder("users");
        Folder etc = new Folder("etc");
        Folder root = new Folder("root");
        root.addFolder(users,etc);

        Folder mike = new Folder("mike");
        Folder kent = new Folder("kent");
        Folder max = new Folder("max");

        users.addFolder(mike, kent, max);

        Folder one = new Folder("one");
        Folder two = new Folder("two");
        Folder three = new Folder("three");
        mike.addFolder(one, two, three);

        users.printFolders();
    }
}

class Folder {
    String name;

    public Folder(String name) {
        this.name = name;
    }

    List<Folder> list = new ArrayList<>();

    public void addFolder(Folder folder) {
        list.add(folder);
    }
    public void addFolder(Folder... folders) {
        list.addAll(Arrays.asList(folders));
    }

    public void printFolders() {
        for(Folder folder : list)  {
            System.out.println(folder.name);
            folder.printFolders();
        }
    }
}