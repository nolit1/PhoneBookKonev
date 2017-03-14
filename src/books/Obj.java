package books;

import java.util.ArrayList;

public class Obj {
    String name;
    ArrayList<String> number = new ArrayList<>();

    @Override
    public String toString() {
        return "Имя: " + name + " " + "Номер: " + number + "\n";
    }
}

